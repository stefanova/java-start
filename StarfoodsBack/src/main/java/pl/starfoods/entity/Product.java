package pl.starfoods.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String brand;
    private String comment;
    private String image;

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
