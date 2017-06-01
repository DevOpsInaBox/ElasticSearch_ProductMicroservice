package com.newt.ecom.service;

import com.newt.ecom.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface ProductService {

    Product save(Product book);

    void delete(Product book);

    Product findOne(String id);

    Iterable<Product> findAll();

    Page<Product> findByProductName(String author, PageRequest pageRequest);
    
    List<Product> findByProductName(String author);
    
    List<Product> findByProductNameContaining(String author);

    List<Product> findByProductPrice(String title);

}