package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


// 因为前端运行在 http://localhost:3000，后端在 http://localhost:8080，必须允许跨域请求。
@CrossOrigin(origins = "http://localhost:3000") 

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
