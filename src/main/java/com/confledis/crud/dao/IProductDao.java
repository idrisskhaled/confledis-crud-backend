package com.confledis.crud.dao;


import com.confledis.crud.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductDao {
    Product saveProduct(Product Product);

    Optional<Product> getOneProduct(Long id);

    List<Product> getAllProducts();

    void removeProduct(Long id);

    void removeAllProducts();

}
