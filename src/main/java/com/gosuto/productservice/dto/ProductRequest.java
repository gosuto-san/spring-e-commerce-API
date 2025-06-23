package com.gosuto.productservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequest {
  @NotBlank(message = "Le nom du produit ne peut pas être vide")
  private String name;
  @Positive(message = "Le prix du produit doit être positif")
  private double price;
}
