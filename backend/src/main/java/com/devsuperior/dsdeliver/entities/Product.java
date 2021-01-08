package com.devsuperior.dsdeliver.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity //mapeando as classes com as tabelas do bancp
@Table(name = "tb_product") //declarando que a classe pruduct corresponde a tabela tb_poduct
public class Product implements Serializable{
  /**
   *
   */
  private static final long serialVersionUID = 1L;
  @Id //mapeando o id
  @GeneratedValue(strategy = GenerationType.IDENTITY) //mapeando o id com o campo id do banco com incremento automatico
  private Long id;
  private String name;
  private Double price;
  private String description;
  private String imageUri;


  public Product(){

  }


  public Product(Long id, String name, Double price, String description, String imageUri){
    super();
    this.id = id;
    this.name = name;
    this.price = price;
    this.description = description;
    this.imageUri = imageUri;
  }


  //gets e sets methods
  public Long getId(){
    return id;
  }

  public void setId(Long id){
    this.id = id;
  }

  public String getName(){
    return name;
  }

  public void setName(String name){
    this.name = name;
  }

  public Double getPrice(){
    return price;
  }

  public void setPrice(Double price){
    this.price = price;
  }

  public String getDescription(){
    return description;
  }

  public void setDescription(String description){
    this.description = description;
  }
  
  public String getImageUri(){
    return imageUri;
  }

  public void setImageUri(String imageUri){
    this.imageUri = imageUri;
  }


  //metodo para comparação dos valores dos produto comparação feita atraves do id
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Product other = (Product) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }


}