package pl.starfoods.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import pl.starfoods.ProductWithScore;
import pl.starfoods.entity.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long>, CrudRepository<Product, Long> {

    @Query(value ="SELECT p.id AS id, p.name AS name, SUM(r.rating_value) / COUNT(r.id) AS score FROM Product p, Rating r WHERE p.id = r.product_id GROUP BY r.product_id ORDER BY score DESC", nativeQuery = true)
    public List<ProductWithScore> findProductsWithScore();

//    @Query(value ="select p.name from Product p where p.name like ':userInput%'", nativeQuery=true)
//    public List<Product> findByCategory(@Param("userInput") String userInput);

    List<Product> findProductsByNameIsLike(String name);
}


