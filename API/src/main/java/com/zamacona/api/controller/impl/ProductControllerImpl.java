package com.zamacona.api.controller.impl;

import com.zamacona.api.controller.ProductController;
import com.zamacona.api.entities.Product;
import com.zamacona.api.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ProductControllerImpl implements ProductController {

    private final ProductService productService;

    @Override
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value="/Product")
    public List<Product> getProducts() {
        try {
            return productService.listProducts();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value="/Product/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer id){
        try{
            Optional<Product> product=Optional.of(productService.getProductById(id));
            return ResponseEntity.of(product);
        }catch(Exception e){
          return ResponseEntity.notFound().build();
        }
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value="/Product")
    public void newProduct(@RequestBody Product product){
        productService.saveProduct(product);
    }
    @Override
    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value="/Product/{id}")
    public ResponseEntity<?> editProduct(@RequestBody Product product,@PathVariable Integer id){
        try{
            Product productExists=productService.getProductById(id);
            productExists.setName(product.getName());
            productExists.setPrice(product.getPrice());
            productService.saveProduct(productExists);
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }

    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value="/Product/{id}")
    public void deleteProduct(@PathVariable Integer id){
        productService.deleteProduct(id);
    }















}
