package jpa.domain;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Item {

    @Id@GeneratedValue
    @Column(name = "ITEM_ID")
    private Long id;

    @ManyToMany( mappedBy = "items") // 다대다의 관계는 1대 다 와 다대일이 합쳐진 것이기에 필연적으로 양방향이다.
    private List<Category> catagories = new ArrayList<>();

    private String name;
    private int price;
    private int stockQuantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Category> getCatagories() {
        return catagories;
    }

    public void setCatagories(List<Category> catagories) {
        this.catagories = catagories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
}
