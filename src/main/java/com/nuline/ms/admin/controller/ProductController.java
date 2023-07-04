package com.nuline.ms.admin.controller;

import com.nuline.ms.admin.models.Product;
import com.nuline.ms.admin.service.Message;
import com.nuline.ms.admin.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class ProductController {


    @Autowired
    private ProductService productService;

    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestBody Product product){
        Product savedProduct = productService.addProduct(product);
        return ResponseEntity.ok(savedProduct);
    }

    @GetMapping("/product")
    public ResponseEntity<?> getAllProduct(){
        List<Product> savedProduct = productService.getProducts();
        return ResponseEntity.ok(savedProduct);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<?> getProduct(@PathVariable String id){
        Product savedProduct = productService.getProducts(id);
        if(savedProduct == null){
            return new ResponseEntity<Message>(new Message("No product found","failed"), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(savedProduct);
    }

    @PutMapping("/product")
    public ResponseEntity<?> updateProduct(@RequestBody Product product){
        Product pr = productService.updateProduct(product);
        if(pr == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(pr);
    }
}
