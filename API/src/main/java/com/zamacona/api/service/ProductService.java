package com.zamacona.api.service;


import com.zamacona.api.entities.Product;

import java.util.List;


public interface ProductService {
    public List<Product> listProducts();
    public void saveProduct(Product product);

    public Product getProductById(Integer id);

    public void deleteProduct(Integer id);
}
