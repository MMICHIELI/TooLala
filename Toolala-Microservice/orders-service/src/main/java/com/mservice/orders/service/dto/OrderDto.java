package com.mservice.orders.service.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Order Bean
 */
@Data
public class OrderDto implements Serializable {

  private Long id;

  private String deliverLocation;

  private String description;
}
