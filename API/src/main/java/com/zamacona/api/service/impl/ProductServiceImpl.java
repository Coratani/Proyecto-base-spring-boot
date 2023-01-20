package com.zamacona.api.service.impl;

import com.zamacona.api.entities.Product;
import com.zamacona.api.repositories.ProductRepository;
import com.zamacona.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> listProducts(){
        return productRepository.findAll();
    }
    public void saveProduct(Product product){
        productRepository.save(product);

    }

    public Optional<Product> getProductById(Integer id){
        return productRepository.findById(id);
    }
    public void deleteProduct(Integer id){
        productRepository.deleteById(id);
    }

}
