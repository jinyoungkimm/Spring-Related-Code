package jpa.domain;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {


    @Id@GeneratedValue
    @Column(name = "CATEGORY_ID")
    private Long id;

    @ManyToMany
    @JoinTable(name = "CATEGORY_ITEM",
                joinColumns = @JoinColumn(name = "CATEGORY_ID"), // 중간 연결 테이블의 CATOGORY_ITEM -> CATEGORY의 연관 관계 주인 설정
                inverseJoinColumns = @JoinColumn(name  = "ITEM_ID")) // 중간 연결 테이블의 CATOGORY_ITEM -> ITEM의 연관 관계 주인 설정
    private List<Item> items = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    private Category parent; //상위 카테고리
    @OneToMany(mappedBy = "parent")
    private List<Category> child;//하위 카테고리

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }

    public List<Category> getChild() {
        return child;
    }

    public void setChild(List<Category> child) {
        this.child = child;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
