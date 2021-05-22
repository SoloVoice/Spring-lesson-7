package springdata.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import springdata.model.Product;
import springdata.repository.ProductRepository;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductRepository pr;

    @GetMapping
    public List<Product> getAllProducts() {
        return (List<Product>) pr.findAll();
    }

    @GetMapping("/{id}")
    public Product getProductByID(@PathVariable Long id) {
        return pr.findById(id).get();
    }

    @GetMapping("/del/{id}")
    public List<Product> deleteProduct(@PathVariable Long id) {
        pr.deleteById(id);
        return getAllProducts();
    }

    @GetMapping("/add")
    public List<Product> addProduct(@RequestParam String title, @RequestParam int price) {
        pr.save(new Product(title, price));
        return getAllProducts();
    }
}
