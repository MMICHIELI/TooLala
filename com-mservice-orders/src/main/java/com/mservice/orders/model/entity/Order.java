package com.mservice.orders.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "ms_order")
@SequenceGenerator(allocationSize = 1, initialValue = 1, name = "idgen", sequenceName = "msOrderSeq")
@Data
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idgen")
  @Column(name = "order_id")
  private Long id;

  @Column(name = "delivery_location")
  private String deliveryLocation;

  @Column(name = "description")
  private String description;
}
