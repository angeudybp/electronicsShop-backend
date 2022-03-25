package com.revature.techshop.controller;

import com.revature.techshop.entities.Product;
import com.revature.techshop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable("id") int id){
        return productService.getProductById(id);
    }
    @GetMapping("/products/categories")
    public List<String> getCategories(){
        return productService.getCategories();
    }
    @GetMapping("/products/categories/{category}")
    public List<Product> getAllByCategory(@PathVariable("category") String category){
        return productService.getProductsByCategory(category);
    }
    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }
    @PostMapping("/products/{id}")
    public String updateProduct(@PathVariable("id") int id, @RequestBody Product product){
        productService.updateProduct(id,product);
        return  "record update successfully";
    }
    @DeleteMapping("/products/{id}")
    public String deleteProduct(@PathVariable("id") int id){
        productService.deleteProduct(id);
        return "record deleted successfully";
    }


}
