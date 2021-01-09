package com.devsuperior.dsdeliver.controllers;

import java.util.List;

import com.devsuperior.dsdeliver.dto.OrderDTO;
import com.devsuperior.dsdeliver.services.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

  @Autowired
  public OrderService service;

  @GetMapping
  public ResponseEntity<List<OrderDTO>> findAll(){
    List<OrderDTO>list = service.findAll();
    return ResponseEntity.ok().body(list);
  }
  
}