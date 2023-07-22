package com.confledis.crud.dao;

import com.confledis.crud.dao.repository.ProductRepository;
import com.confledis.crud.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;


@Component
public class ProductDao implements IProductDao {

    @Autowired
    private  final ProductRepository productRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductDao.class);

    public ProductDao(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> getOneProduct(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if(! product.isPresent()){
            LOGGER.error("Trying to get a non existent product , id : " +id);
            throw new EntityNotFoundException("Trying to get a non existent product , id : " +id);
        }
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }


    @Override
    public void removeProduct(Long id) {
        try{
            Product product = productRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("product not found"));
            productRepository.deleteById(id);
        }catch(EmptyResultDataAccessException e){
            LOGGER.error(e.getMessage());
            throw new EntityNotFoundException("Trying to delete a non existent product , id : " +id);
        }
    }

    @Override
    public void removeAllProducts() {
       productRepository.deleteAll();
    }


}
