package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductRepository repo;

    public ProductController(ProductRepository repo) {
        this.repo = repo;
    }

    // 查询所有产品
    @GetMapping
    public List<Product> getAll() {
        return repo.findAll();
    }

    // 添加产品
    @PostMapping
    public Product add(@RequestBody Product product) {
        return repo.save(product);
    }

    // 删除产品
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        repo.deleteById(id);
    }
}
