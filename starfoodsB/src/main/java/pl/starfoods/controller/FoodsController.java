package pl.starfoods.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.starfoods.model.Foods;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@CrossOrigin
@RestController
public class FoodsController {
private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/")
    public String animal() {
                return counter.incrementAndGet()
                                + ". W sumie nic sie nie dzieje, nie wiem po co to :D";
            }

@RequestMapping("/foods")
    public List<Foods> foods(){
    List<Foods> foods = new LinkedList<>();

    foods.add(new Foods(1, "Majonez", "Winiary"));
    foods.add(new Foods(2, "Ketchup", "Włocławek"));
    foods.add(new Foods(3, "Chleb razowy", "Mielnik"));
    foods.add(new Foods(4, "Parówki sojowe", "Sojolove"));
    System.out.println(foods);
    return foods;


}

}
