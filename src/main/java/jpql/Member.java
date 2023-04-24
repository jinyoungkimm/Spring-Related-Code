package jpql;


import jakarta.persistence.*;

@Entity
public class Member {
    @Id@GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;
    private String username;
    private int age;
    @ManyToOne(fetch = FetchType.LAZY) // 지연 로딩을 통해, Team 메서드가 호출되기 전에는 굳이 DB에서 가져오지 않는다.
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    @Enumerated(EnumType.STRING)
    private MemberType type;

    public MemberType getType() {
        return type;
    }

    public void setType(MemberType type) {
        this.type = type;
    }
    //[편의 메서드] 정의
    /*public void changeTeam(Team team){
        this.team = team;
        team.getMembrers().add(this);
    }*/

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {

        return "Member{" +
                "id = " + id +
                ", username = " + username +
                ", age = " + age +
                //", team = " + team +   -> 이 코드에서 team::toString()이 호출이 된다. 그런데 Team 클래스에 만약 toString()에도 ["Member = " + member]가 있다면, 또 member ::toString()이 호출돼,
                "}";                       //toString()에 의한 무한 루프에 빠지므로, team 부분은 반드시 지워야 한다.

    }
}
