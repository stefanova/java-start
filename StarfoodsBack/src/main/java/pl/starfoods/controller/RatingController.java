package pl.starfoods.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.starfoods.entity.Product;
import pl.starfoods.entity.Rating;
import pl.starfoods.repository.ProductRepository;
import pl.starfoods.repository.RatingRepository;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/products")
public class RatingController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private RatingRepository ratingRepository;

    @RequestMapping("/rate/{id}")
    public Rating rateProduct(@PathVariable("id") String id,
                              @RequestParam(name = "value") String ratingValue){
        long productId = Long.valueOf(id);
        int score = Integer.valueOf(ratingValue);
        Product p = productRepository.findOne(productId);
        Rating r = new Rating();

        r.setRating_value(score);
        r.setProduct(p);

        return ratingRepository.save(r);
    }

}
