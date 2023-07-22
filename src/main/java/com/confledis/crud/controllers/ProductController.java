package com.confledis.crud.controllers;


import com.confledis.crud.dto.BaseProductDto;
import com.confledis.crud.service.IProductService;
import com.confledis.crud.dto.ProductDto;
import com.confledis.crud.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Slf4j
public class ProductController  implements IProductController{
    public final IProductService productService;
    private final ModelMapper mapper;

    public ProductController(IProductService productService, ModelMapper mapper) {
        this.productService = productService;
        this.mapper = mapper;
    }


    @Override
    public List<ProductDto> getProducts() {
        return   this.productService.getAllProducts()
                .stream()
                .map(product -> mapper.map(product, ProductDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<BaseProductDto> getBaseProducts() {
        return   this.productService.getAllProducts()
                .stream()
                .map(product -> mapper.map(product, BaseProductDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto getOneProduct(Long id) {
        return mapper.map(productService.getOneProduct(id), ProductDto.class);
    }

    @Override
    public BaseProductDto createProduct(BaseProductDto baseProductDto) {
        Product product = mapper.map(baseProductDto, Product.class);
        UUID uuid = UUID.randomUUID();
        product.setId(uuid);
        return mapper.map(productService.createProduct(product), BaseProductDto.class);
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto) {
        Product product = mapper.map(productDto, Product.class);
        return mapper.map(productService.createProduct(product), ProductDto.class);
    }

    @Override
    public void deleteProduct(Long id) {
        productService.deleteProduct(id);

    }
    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleEntityNotFoundException(EntityNotFoundException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleIllegalArgumentException(IllegalArgumentException ex) {
        return ex.getMessage();
    }
}
