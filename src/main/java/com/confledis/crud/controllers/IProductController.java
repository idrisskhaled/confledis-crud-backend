package com.confledis.crud.controllers;

import com.confledis.crud.dto.BaseProductDto;
import com.confledis.crud.dto.ProductDto;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RequestMapping("product")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public interface IProductController {
    @GetMapping("")
    List<ProductDto> getProducts();

    @GetMapping("/base")
    List<BaseProductDto> getBaseProducts();

    @GetMapping("/{id}")
    ProductDto getOneProduct(@PathVariable Long id);

    @PostMapping("")
    BaseProductDto createProduct(@RequestBody @Valid BaseProductDto baseProductDto);


    @PutMapping("")
    ProductDto updateProduct(@RequestBody @Valid ProductDto productDto);



    @DeleteMapping("/{id}")
    void deleteProduct(@PathVariable Long id);
}
