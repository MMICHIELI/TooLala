package com.mservice.orders.rest.controllers;

import com.mservice.orders.rest.exceptions.NoOrderException;
import com.mservice.orders.rest.exceptions.OrderNotFoundException;
import com.mservice.orders.service.IOrderService;
import com.mservice.orders.service.dto.OrderDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping(value = "/orders")
@Api(description = "Order Micro-Service", value = "/orders")
public class OrderController {

  @Autowired
  IOrderService orderService;

  private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

  @GetMapping
  @ApiOperation(value = "List All Orders", response = Iterable.class, responseContainer = "ResponseEntity")
  public ResponseEntity<Iterable<OrderDto>> list() throws NoOrderException {
    LOGGER.info("ORDER [CONTROLLER] - GET All Orders ");

    List<OrderDto> orderDtos = orderService.list();
    if (orderDtos == null || orderDtos.isEmpty())
      throw new NoOrderException("Il n'y a Aucune Commande.");
    else
      return new ResponseEntity<>(orderDtos, OK);
  }

  @GetMapping(value = "/{id}")
  @ApiOperation(value = "Get a Order by id", response = OrderDto.class, responseContainer = "ResponseEntity")
  public ResponseEntity<OrderDto> getById(
      @PathVariable("id") @ApiParam(value = "Order Id", required = true) Long orderId)
      throws OrderNotFoundException {
    LOGGER.info("ORDER [CONTROLLER] - GET Order by id: " + orderId);

    OrderDto orderDto = orderService.getById(orderId);
    if (orderDto == null)
      throw new OrderNotFoundException("La commande avec l'id: " + orderId + " n'éxiste pas.");
    else
      return new ResponseEntity<>(orderDto, OK);
  }

  @PostMapping
  @ApiOperation(value = "Create a new Order", response = OrderDto.class, responseContainer = "ResponseEntity")
  public ResponseEntity<OrderDto> create(
      @Valid @RequestBody @ApiParam(value = "Order Informations", required = true) OrderDto orderDto
  ) {
    LOGGER.info("ORDER [CONTROLLER] - CREATE a new Order = {description: " + orderDto.getDescription()
        + ", deliveryLocation: " + orderDto.getDeliverLocation() + "}");

    OrderDto orderDtoCreated = orderService.save(orderDto);
    if (orderDtoCreated == null)
      return ResponseEntity.noContent().build();

    return new ResponseEntity<>(orderDtoCreated, OK);
  }

  @PutMapping(value = "/{id}")
  @ApiOperation(value = "Update User", response = OrderDto.class, responseContainer = "ResponseEntity")
  public ResponseEntity<OrderDto> update(
      @Valid @RequestBody @ApiParam(value = "User Information", required = true) OrderDto orderDto,
      @PathVariable("id") @ApiParam(value = "manufacturing id", required = true) Long orderId
  ) {
    LOGGER.info("ORDER [CONTROLLER] - Update Order = {orderId: " + orderId
        + ", description: " + orderDto.getDescription() + ", deliveryLocation: " + orderDto.getDeliverLocation() + " }");
    OrderDto orderDtoUpdated = orderService.save(orderDto);

    if (orderDtoUpdated == null)
      return ResponseEntity.noContent().build();

    return new ResponseEntity<>(orderDtoUpdated, OK);
  }

  @DeleteMapping(value = "/{id}")
  @ApiOperation(value = "Delete a Order", responseContainer = "ResponseEntity")
  public void delete(
      @PathVariable("id") @ApiParam(value = "Order Id to Delete", required = true) Long orderId) {
    LOGGER.info("ORDER [CONTROLLER] - DELETE Order by id: " + orderId);
    orderService.delete(orderId);
  }
}
