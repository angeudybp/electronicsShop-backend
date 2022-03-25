package com.revature.techshop.services;

import com.revature.techshop.entities.Product;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ProductService {
    public List<Product> getAllProducts();
    public Product getProductById(int id);
    public Product addProduct(Product product);
    public List<Product> getProductsByCategory(String category);
    public void updateProduct(int id, Product product);
    public void deleteProduct(int id);
    public List<String> getCategories();

}
