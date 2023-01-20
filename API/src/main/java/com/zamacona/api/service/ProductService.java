package com.zamacona.api.service;


import com.zamacona.api.entities.Product;

import java.util.List;
import java.util.Optional;


public interface ProductService {
    public List<Product> listProducts();
    public void saveProduct(Product product);

    public Optional<Product> getProductById(Integer id);

    public void deleteProduct(Integer id);
}
