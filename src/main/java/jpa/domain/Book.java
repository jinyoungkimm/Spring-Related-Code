package jpa.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Book extends Item {

    @Id@GeneratedValue
    @Column(name = "BOOK_ID")
    private Long id;

    private String author;
    private String isbn;


}
