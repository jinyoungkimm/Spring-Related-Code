package jpql;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {

    @Id@GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;
    private String name;

    @OneToMany(mappedBy = "team") // 양방향으로 하는 이유: JPQL 문법 소개를 위해서!!!(원래는 단방향이 원칙)
    private List<Member> membrers = new ArrayList<>();

    public List<Member> getMembrers() {
        return membrers;
    }

    public void setMembrers(List<Member> membrers) {
        this.membrers = membrers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
