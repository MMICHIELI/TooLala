package com.mservice.orders.service;

import com.mservice.orders.service.dto.OrderDto;

import java.util.List;

/**
 * All Order Services
 */
public interface IOrderService {

  /**
   * @param orderId
   * @return OrderDto
   */
  OrderDto getById(Long orderId);

  /**
   * @return List<OrderDto>
   */
  List<OrderDto> list();

  /**
   * @param orderDto
   * @return OrderDto
   */
  OrderDto save(OrderDto orderDto);

  /**
   * @param orderId
   */
  void delete(Long orderId);
}
