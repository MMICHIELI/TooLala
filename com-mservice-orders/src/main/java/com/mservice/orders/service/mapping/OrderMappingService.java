package com.mservice.orders.service.mapping;

import com.mservice.orders.model.entity.Order;
import com.mservice.orders.service.dto.OrderDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Order to Dto & Dto to Order Mapping Service
 */
@Service
public class OrderMappingService {

  /**
   * entityToDto
   * @param order
   * @return OrderDto
   */
  public OrderDto entityToDto(Order order) {
    OrderDto orderDto = new OrderDto();
    orderDto.setId(order.getId());
    orderDto.setDeliverLocation(order.getDeliveryLocation());
    orderDto.setDescription(order.getDescription());
    return orderDto;
  }

  /**
   * entitiesToDto
   * @param orders
   * @return List<OrderDto>
   */
  public List<OrderDto> entitiesToDto(List<Order> orders) {
    return orders
        .stream()
        .map(this::entityToDto)
        .collect(Collectors.toList());
  }

  /**
   * dtoToEntity
   * @param orderDto
   * @return Order
   */
  public Order dtoToEntity(OrderDto orderDto) {
    Order order = new Order();
    order.setId(orderDto.getId());
    order.setDeliveryLocation(orderDto.getDeliverLocation());
    order.setDescription(orderDto.getDescription());
    return order;
  }
}
