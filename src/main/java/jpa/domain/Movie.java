package jpa.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Movie extends Item{

    @Id@GeneratedValue
    @Column(name = "MOVIE_ID")
    private Long id;

    private String director;
    private String actor;

}
