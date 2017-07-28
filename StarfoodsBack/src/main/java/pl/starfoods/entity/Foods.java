package pl.starfoods.entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Foods {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String brand;
    private String description;
    private String image;
    private double price;
    private boolean best;

    public Foods(long id, String name, String brand, String description, String image, double price, boolean best) {
        this.name = name;
        this.brand = brand;
        this.description = description;
        this.image = image;
        this.price = price;
        this.best = best;
    }

    public Foods(){}

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

    public double getPrice() {return price;}

    public void setPrice(double price) {this.price = price;}

    public boolean isBest() {return best;}

    public void setBest(boolean best) {this.best = best;}


    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}


}
