package com.fds.orderservice.service;

import com.fds.orderservice.dto.InventoryRespon;
import com.fds.orderservice.dto.OrderLineItemsDto;
import com.fds.orderservice.dto.OrderRequest;
import com.fds.orderservice.model.ProductOrder;
import com.fds.orderservice.model.OrderLineItems;
import com.fds.orderservice.repository.OrderRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class OrderService {
    @Autowired
    private  OrderRepository orderRepository;
    @Autowired
    private WebClient webClient;
    @SneakyThrows
    public void placeOrder(OrderRequest orderRequest) {
        ProductOrder order = new ProductOrder();
        order.setOrderNumber(UUID.randomUUID().toString());
        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList().stream()
                .map(this::maptoDto)
                .collect(Collectors.toList());
        order.setOrderLineItemsList(orderLineItems);
        List<String> skuCodes = order.getOrderLineItemsList()
                        .stream()
                .map(OrderLineItems::getSkuCode).
                collect(Collectors.toList());//lấy ra mã skuCode của từng item

//        order.setOrderLineItems(orderLineItems);
        InventoryRespon[] inventoryResponArray = webClient.get()// tạo một yêu cầu get()
                .uri("http://localhost:8082/api/inventory",
                        uriBuilder -> uriBuilder.queryParam("skuCode",skuCodes).build())// yêu cầu get đưcọ gửi đến đại chỉ uri
                .retrieve()// gủi yêu cầu và nhận yêu cầu từ máy chủ
                .bodyToMono(InventoryRespon[].class)// tạo két quả trả về kiểu mảng
                .block();// chặn không thực hiện các yêu cầu khác cho đến khi nhận đc kêt quả

        boolean allProductInstock = Arrays.stream(inventoryResponArray).allMatch(InventoryRespon::isInStock);
        // kiểm tra tất cả các phần tử của mảng đó có thuộc InStock hay ko, nếu tất cả đều thuộc thì trả về true
       if(allProductInstock){
        orderRepository.save(order);}
       else {
           throw new IllegalAccessException("lỗi rồi");
       }
    }

    private OrderLineItems maptoDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        return orderLineItems;
    }
}
