package com.fds.orderservice.repository;

import com.fds.orderservice.model.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<ProductOrder,Long> {
}
