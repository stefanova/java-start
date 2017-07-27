package pl.starfoods.model;

public class Foods {

    private long id;
    private String name;
    private String brand;

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

    public Foods(long id, String name, String brand){
        this.id = id;
        this.name = name;
        this.brand = brand;


    }
}
