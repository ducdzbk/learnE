package com.fds.orderservice.service;

import com.fds.orderservice.dto.OrderLineItemsDto;
import com.fds.orderservice.dto.OrderRequest;
import com.fds.orderservice.model.ProductOrder;
import com.fds.orderservice.model.OrderLineItems;
import com.fds.orderservice.repository.OrderRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class OrderService {
    @Autowired
    private  OrderRepository orderRepository;

    public void placeOrder(OrderRequest orderRequest) {
        ProductOrder order = new ProductOrder();
        order.setOrderNumber(UUID.randomUUID().toString());
        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList().stream()
                .map(this::maptoDto)
                .collect(Collectors.toList());

//        order.setOrderLineItems(orderLineItems);
        orderRepository.save(order);
    }

    private OrderLineItems maptoDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        return orderLineItems;
    }
}
