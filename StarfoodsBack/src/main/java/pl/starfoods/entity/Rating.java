package pl.starfoods.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;


@Entity
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int rating_value;
    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    private Product product;

    public Rating(long id, int rating_value) {
        this.id = id;
        this.rating_value = rating_value;
    }

    public Rating(){}

    public int getRating_value() {
        return rating_value;
    }

    public void setRating_value(int rating_value) {
        this.rating_value = rating_value;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


}
