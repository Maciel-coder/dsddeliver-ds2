package com.devsuperior.dsdeliver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.devsuperior.dsdeliver.dto.ProductDTO;
import com.devsuperior.dsdeliver.services.ProductService;

@RestController
@RequestMapping(value = "/products")//definido o camiho do recurso
public class ProductController {

  @Autowired
  private ProductService service;

  @GetMapping
  public ResponseEntity<List<ProductDTO>> findAll(){
    List<ProductDTO> list = service.findAll();
    return ResponseEntity.ok().body(list);

  }
  
}
