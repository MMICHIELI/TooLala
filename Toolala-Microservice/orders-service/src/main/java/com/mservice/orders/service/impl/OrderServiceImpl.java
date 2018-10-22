package com.mservice.orders.service.impl;

import com.mservice.orders.model.dao.IOrderDao;
import com.mservice.orders.model.entity.Order;
import com.mservice.orders.service.IOrderService;
import com.mservice.orders.service.dto.OrderDto;
import com.mservice.orders.service.mapping.OrderMappingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of IOrderService
 */
@Service
public class OrderServiceImpl implements IOrderService {

  @Autowired
  IOrderDao orderDao;

  @Autowired
  OrderMappingService orderMappingService;

  private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);

  @Override
  public OrderDto getById(Long orderId) {
    LOGGER.info("ORDER [SERVICE] GET Order by ID: " + orderId);
    OrderDto orderDto = null;

    Optional<Order> order = orderDao.findById(orderId);
    if (order.isPresent())
      orderDto = orderMappingService.entityToDto(order.get());

    return orderDto;
  }

  @Override
  public List<OrderDto> list() {
    LOGGER.info("ORDER [SERVICE] GET All Orders ");
    List<OrderDto> orderDtos = null;

    List<Order> orders = orderDao.findAll();
    if (orders != null)
      orderDtos = orderMappingService.entitiesToDto(orders);

    return orderDtos;
  }

  @Override
  public OrderDto save(OrderDto orderDto) {
    LOGGER.info("ORDER [SERVICE] Save ORDER");
    OrderDto response = null;

    Order order = orderDao.save(orderMappingService.dtoToEntity(orderDto));
    if (order != null)
      response = orderMappingService.entityToDto(order);

    return response;
  }

  @Override
  public void delete(Long orderId) {
    LOGGER.info("ORDER [SERVICE] Delete Order by Id: " + orderId);
    orderDao.deleteById(orderId);
  }
}
