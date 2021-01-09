package com.devsuperior.dsdeliver.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.devsuperior.dsdeliver.entities.Order;
import com.devsuperior.dsdeliver.entities.OrderStatus;
import com.devsuperior.dsdeliver.entities.Product;
import com.devsuperior.dsdeliver.dto.OrderDTO;
import com.devsuperior.dsdeliver.dto.ProductDTO;
import com.devsuperior.dsdeliver.repositories.OrderRepository;
import com.devsuperior.dsdeliver.repositories.ProductRepository;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

 
  @Autowired
  private OrderRepository repository;

  @Autowired ProductRepository productRepository;

  @Transactional(readOnly = true)
  public List<OrderDTO> findAll(){

    List<Order> list = repository.findAlOrdersWithProducts();
    return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());

  }

  @Transactional
  public OrderDTO insert(OrderDTO dto){
    Order order = new Order(null, dto.getAddress(), dto.getLatitude(), dto.getLongitude(),
                     Instant.now(),OrderStatus.PENDING);  
    for(ProductDTO p : dto.getProducts()){
      Product product = productRepository.getOne(p.getId());
      order.getProducts().add(product);

    }

    order = repository.save(order);
    return new OrderDTO(order);
    

  }
  
}
