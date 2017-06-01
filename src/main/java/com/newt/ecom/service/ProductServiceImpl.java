package com.newt.ecom.service;

import com.newt.ecom.model.Product;
import com.newt.ecom.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository bookRepository) {
        this.productRepository = bookRepository;
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public void delete(Product product) {
        productRepository.delete(product);
    }

    public Product findOne(String id) {
        return productRepository.findOne(id);
    }

    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    public Page<Product> findByProductName(String productName, PageRequest pageRequest) {
        return productRepository.findByProductName(productName, pageRequest);
    }
    public List<Product> findByProductName(String productName) {
        return productRepository.findByProductName(productName);
    }
    public List<Product> findByProductNameContaining(String productName) {
        return productRepository.findByProductNameContaining(productName);
    }

    public List<Product> findByProductPrice(String price) {
        return productRepository.findByProductPrice(price);
    }

}