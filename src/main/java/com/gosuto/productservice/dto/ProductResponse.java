package com.gosuto.productservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponse {
  // on peut commenter l'id si on ne veut pas l'exposer
  private Long id;
  private String name;
  private double price;
}
