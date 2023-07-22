package com.confledis.crud.service;

import com.confledis.crud.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    Product createProduct(Product Product);
    List<Product> getAllProducts();

    Optional<Product> getOneProduct(Long Id);

    Product updateProduct(Product Product);

    void deleteProduct(Long Id);

    void deleteAllProducts();

}
