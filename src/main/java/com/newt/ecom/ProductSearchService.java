/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newt.ecom;

import com.newt.ecom.model.Product;
import com.newt.ecom.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author shyams
 */
@RestController
public class ProductSearchService {
    
    @Autowired
    private ProductService productService;
    
    @RequestMapping("/findByProductName/{productName}")
    public List<Product> helloMsg(@PathVariable("productName")  String productName) {
        List<Product> products = productService.findByProductNameContaining(productName);
        return products;
    }
    
}