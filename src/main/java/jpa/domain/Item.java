package jpa.domain;


import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name ="DTYPE")
public class Item extends BasicEntity{

    @Id@GeneratedValue
    @Column(name = "ITEM_ID")
    Long id;

    private String name;
    private int price;
    int stockQuantity;

}
