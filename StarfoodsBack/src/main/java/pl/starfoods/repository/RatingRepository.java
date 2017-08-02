package pl.starfoods.repository;

import org.springframework.data.repository.CrudRepository;
import pl.starfoods.entity.Rating;

public interface RatingRepository extends CrudRepository<Rating, Long> {
}
