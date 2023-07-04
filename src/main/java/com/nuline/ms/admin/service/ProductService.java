package com.nuline.ms.admin.service;

import com.nuline.ms.admin.models.Product;
import com.nuline.ms.admin.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product addProduct(Product product) {
        if (product.getId() != null) {
            updateProduct(product);
        }
        return productRepository.save(product);
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product getProducts(String id) {
        Optional<Product> pr = productRepository.findById(id);
        return pr.orElse(null);
    }

    public Product updateProduct(Product pr) {

        if (pr.getId() == null) {
            return null;
        }
        Optional<Product> byId = productRepository.findById(pr.getId());
        if (byId.isEmpty()) {
            return null;
        }
        return productRepository.save(pr);
    }
}
