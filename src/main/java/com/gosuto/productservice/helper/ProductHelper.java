// package com.gosuto.productservice.helper;

// import java.util.List;

// import org.springframework.stereotype.Component;

// import com.gosuto.productservice.constant.ErrorMessage;
// //import com.gosuto.productservice.dto.ProductRequest;
// import com.gosuto.productservice.dto.ProductResponse;
// import com.gosuto.productservice.exceptions.ProductNotFoundException;
// import com.gosuto.productservice.mapper.ProductMapper;
// import com.gosuto.productservice.model.Product;
// import com.gosuto.productservice.service.interfaces.ProductService;

// import lombok.RequiredArgsConstructor;

// @RequiredArgsConstructor
// @Component
// public class ProductHelper {
//   private final ProductService productService;
//   private final ProductMapper productMapper;

//   /**
//    * Retrieves a ProductResponse by its ID.
//    *
//    * @param id the ID of the product
//    * @return the ProductResponse corresponding to the product with the given ID
//    * @throws ProductNotFoundException if no product is found with the given ID
//    */

//   public ProductResponse getProductResponse(Long id) {
//     Product product = productService.getProductById(id);
//     if (product == null) {
//       throw new ProductNotFoundException(String.format(ErrorMessage.PRODUCT_NOT_FOUND_WITH_ID, id));
//     }
//     return productMapper.toProductDTO(product);
//   }

//   /**
//    * Retrieves all products and maps them to ProductResponse DTOs.
//    *
//    * @return a list of ProductResponse DTOs representing all products
//    */

//   public List<ProductResponse> getAllProducts() {
//     List<Product> products = productService.getAllProducts();
//     return products.stream()
//         .map(productMapper::toProductDTO).toList();
//   }

//   public ProductResponse createProduct(Product product) {
//     Product createdProduct = productService.createProduct(product);
//     return productMapper.toProductDTO(createdProduct);
//   }

// }
