package com.zamacona.api.controller;

import com.zamacona.api.entities.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ProductController {

    public List<Product> getProducts();
    public ResponseEntity<Product> getProduct(@PathVariable Integer id);
    public void newProduct(@RequestBody Product product);
    public ResponseEntity<?> editProduct(@RequestBody Product product,@PathVariable Integer id);
    public void deleteProduct(@PathVariable Integer id);
}
