package pl.starfoods.repository;


import org.springframework.data.repository.CrudRepository;

import pl.starfoods.entity.Product;



public interface ProductRepository extends CrudRepository<Product, Long> {


}

