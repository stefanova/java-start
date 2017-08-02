package pl.starfoods.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.starfoods.ProductWithScore;
import pl.starfoods.repository.ProductRepository;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/products")
public class ProductWithScoreController {

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping("/scores")
    public List<ProductWithScore> showProductsScore() {
        return (List<ProductWithScore>) productRepository.findProductsWithScore();
    }

}





