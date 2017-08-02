package pl.starfoods.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;
import pl.starfoods.ProductWithScore;
import pl.starfoods.entity.Product;

import pl.starfoods.entity.Rating;
import pl.starfoods.repository.ProductRepository;
import pl.starfoods.repository.RatingRepository;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping("/")
    public String products() {
        return "";
    }

    @RequestMapping("/show")
    public List<Product> productsList() {
        return (List<Product>) productRepository.findAll();
    }

    @RequestMapping("/add")
    public Product addProduct(@RequestParam(name = "name") String name,
                              @RequestParam(name = "brand") String brand,
                              @RequestParam(name = "comment") String comment,
                              @RequestParam(name = "image") String image) {
        Product product = new Product();

        product.setName(name);
        product.setBrand(brand);
        product.setComment(comment);
        product.setImage(image);

        return productRepository.save(product);
    }

    @RequestMapping("/show/{id}")
    public Product showProductById(@PathVariable ("id") String id){
        return productRepository.findOne(Long.valueOf(id));
    }




}


