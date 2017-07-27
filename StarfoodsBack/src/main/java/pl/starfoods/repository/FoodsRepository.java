package pl.starfoods.repository;

import org.springframework.data.repository.CrudRepository;
import pl.starfoods.entity.Foods;

public interface FoodsRepository extends CrudRepository<Foods, Long> {
}

