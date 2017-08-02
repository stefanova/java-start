package pl.starfoods.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String brand;
    private String comment;
    private String image;
    @JsonManagedReference
    @OneToMany(mappedBy = "product")
    private List<Rating> ratings;

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public Product(long id, String name, String brand, String comment, String image) {
        this.name = name;
        this.brand = brand;
        this.comment = comment;
        this.image = image;
    }

    public Product(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getImage() {return image;}

    public void setImage(String image) {
        this.image = image;
    }


    public String getComment() {return comment;}

    public void setComment(String comment) {this.comment = comment;}


}
