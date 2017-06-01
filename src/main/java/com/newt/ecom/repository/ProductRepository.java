package com.newt.ecom.repository;

import com.newt.ecom.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ProductRepository extends ElasticsearchRepository<Product, String> {

    Page<Product> findByProductName(String author, Pageable pageable);
    
    List<Product> findByProductName(String author);

    List<Product> findByProductPrice(String title);

    public List<Product> findByProductNameContaining(String author);

}