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
    public Foods addFood(@RequestParam(value = "name") String name,
                            @RequestParam(value = "brand") String brand,
                            @RequestParam(value = "image") String image) {
        Foods a = new Foods();
        a.setName(name);
        a.setBrand(brand);
        a.setImage(image);
        return foodsRepository.save(a);
    }
}


