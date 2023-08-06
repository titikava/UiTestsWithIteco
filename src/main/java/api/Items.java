package api;

import java.util.Objects;

public class Items {

    private String name;
    private String section;
    private String description;
    private String color;
    private int size;
    private int price;
    private String params;


    public Items(String name, String section, String description, String color, int size, int price, String params){
        this.name = name;
        this.section = section;
        this.description = description;
        this.color = color;
        this.size = size;
        this.price = price;
        this.params = params;
    }

    public String getSection() {
        return section;
    }

    public String getDescription() {
        return description;
    }

    public String getColor() {
        return color;
    }

    public int getSize() {
        return size;
    }

    public int getPrice() {
        return price;
    }

    public String getParams() {
        return params;
    }

    public String getName(){
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Items item = (Items) o;
        return Objects.equals(name, item.name) &&
                Objects.equals(section, item.section) &&
                Objects.equals(description, item.description) &&
                Objects.equals(color, item.color) &&
                Objects.equals(size, item.size) &&
                Objects.equals(price, item.price) &&
                Objects.equals(params, item.params);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, section, description, color, size, price, params);
    }
}
