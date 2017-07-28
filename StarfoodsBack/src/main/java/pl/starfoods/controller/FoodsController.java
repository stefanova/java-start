package pl.starfoods.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.starfoods.entity.Foods;

import pl.starfoods.repository.FoodsRepository;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/foods")
public class FoodsController {

    @Autowired
    private FoodsRepository foodsRepository;

    @RequestMapping("/")
    public String foods() {
        return "";
    }

    @RequestMapping("/show")
    public List<Foods> foodsList() {
        return (List<Foods>) foodsRepository.findAll();
    }

    @RequestMapping("/add")
    public Foods addFood(@RequestParam(name = "name") String name,
                            @RequestParam(name = "brand") String brand,
                            @RequestParam(name = "description") String description,
                            @RequestParam(name = "image") String image,
                            @RequestParam(name = "price") String price) {
        Foods foods = new Foods();
        foods.setName(name);
        foods.setBrand(brand);
        foods.setDescription(description);
        foods.setImage(image);
        foods.setPrice(Double.parseDouble(price));

        return foodsRepository.save(foods);
    }
}


