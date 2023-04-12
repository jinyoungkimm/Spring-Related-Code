package jpa.domain;


import jakarta.persistence.MappedSuperclass;

import java.time.LocalDateTime;

@MappedSuperclass
public abstract class BasicEntity {

    private String created;
    private String modified;

}
