package com.confledis.crud.service;


import com.confledis.crud.dao.IProductDao;
import com.confledis.crud.model.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j

public class ProductService implements IProductService {

    @Autowired
    private final IProductDao ProductDao;


    @Override
    public List<Product> getAllProducts() {

        return this.ProductDao.getAllProducts();
    }

    @Override
    public Optional<Product> getOneProduct(Long Id) {
        return this.ProductDao.getOneProduct(Id);
    }

    @Override
    public Product updateProduct(Product Product) {
        return  this.ProductDao.saveProduct(Product);
    }

    @Override
    public Product createProduct(Product Product) {
         return  this.ProductDao.saveProduct(Product);
    };

    @Override
    public void deleteProduct(Long id) {
       ProductDao.removeProduct(id);
    }

    @Override
    public void deleteAllProducts() {
        this.ProductDao.removeAllProducts();
    }


}
