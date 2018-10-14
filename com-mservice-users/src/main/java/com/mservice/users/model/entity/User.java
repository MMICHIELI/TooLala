package com.mservice.users.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "USER")
@Data
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "USER_ID")
  private Long id;

  @Column(name = "NAME")
  private String name;

  @Column(name = "FIRST_NAME")
  private String firstName;
}
