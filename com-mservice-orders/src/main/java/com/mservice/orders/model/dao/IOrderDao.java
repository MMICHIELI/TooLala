package com.mservice.orders.model.dao;

import com.mservice.orders.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IOrderDao extends JpaRepository<Order, Long> {

  @Override
  Optional<Order> findById(Long orderId);
}
