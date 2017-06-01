package com.newt.ecom;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.newt.ecom.model.Product;
import com.newt.ecom.service.ProductService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.elasticsearch.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ElasticSearchProductApplication implements CommandLineRunner {

    @Autowired
    private ElasticsearchOperations es;

    @Autowired
    private ProductService productService;

    public static void main(String args[]) {
        SpringApplication.run(ElasticSearchProductApplication.class, args);
    }
    
    @Override
    public void run(String... args) throws Exception {

        printElasticSearchInfo();
        
        ObjectMapper mapper = new ObjectMapper();
        List<Product> result = new ArrayList<Product>();
        RestTemplate restTemplate = new RestTemplate();
        JsonNode jsonNodeResult = restTemplate.getForObject("http://localhost:8765/products/findAllProduct", JsonNode.class);

        result = mapper.readValue(
                mapper.treeAsTokens(jsonNodeResult),
                new TypeReference<List<Product>>() {
        });
        for (Product product : result) {
//            System.out.println("product--->"+product);
            productService.save(product);
        }

    }

    //useful for debug
    private void printElasticSearchInfo() {

        System.out.println("--ElasticSearch-->");
        Client client = es.getClient();
        Map<String, String> asMap = client.settings().getAsMap();

        asMap.forEach((k, v) -> {
            System.out.println(k + " = " + v);
        });
        System.out.println("<--ElasticSearch--");
    }

}
