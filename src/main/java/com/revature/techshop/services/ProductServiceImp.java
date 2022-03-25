package com.revature.techshop.services;

import com.revature.techshop.entities.Product;
import com.revature.techshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductServiceImp implements ProductService{
    @Autowired
    private ProductRepository repository;
    @Override
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    @Override
    public Product getProductById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public Product addProduct(Product product) {
        return repository.save(product);
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        List<Product> products = new ArrayList<>();
        for (Product p : getAllProducts()
             ) {
            if (p.getCategory().equals(category)){
                products.add(p);
            }
        }
        return products;
    }

    @Override
    public void updateProduct(int id, Product product) {
        Product productDb = repository.getById(id);
        productDb.setProductName(product.getProductName());
        productDb.setPrice(product.getPrice());
        productDb.setDescription(product.getDescription());
        productDb.setCategory(product.getCategory());
        repository.save(productDb);
    }

    @Override
    public void deleteProduct(int id) {
        repository.deleteById(id);
    }

    @Override
    public List<String> getCategories() {
        List<String> categories = new ArrayList<>();
        for (Product p: getAllProducts()
             ) {
            if (!categories.contains(p.getCategory())){
                categories.add(p.getCategory());
            }
        }
        return categories;
    }
}
