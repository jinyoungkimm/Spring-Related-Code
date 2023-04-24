import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jpql.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin(); // 트랜잭션 시작
        try {


            Team team1 = new Team();
            team1.setName("팀A");

            Team team2= new Team();
            team2.setName("팀B");

            Team team3 = new Team();
            team3.setName("팀C");

            entityManager.persist(team1);
            entityManager.persist(team2);
            entityManager.persist(team3);

            Member member1 = new Member();
            member1.setUsername("회원1");
            member1.setTeam(team1);

            Member member2 = new Member();
            member2.setUsername("회원2");
            member2.setTeam(team1);

            Member member3 = new Member();
            member3.setUsername("회원3");
            member3.setTeam(team2);

            entityManager.persist(member1);
            entityManager.persist(member2);
            entityManager.persist(member3);

            //이걸 안 해 주면, 아래의 B 부분에서 SQL문을 날려서 TEAM 객체를 조회하지 않고, Context에서 캐싱해서 들고 오기에, SQL문이 날라가는 것을 확인 불가!
            entityManager.flush();
            entityManager.clear();

            //[fetch join]을 사용하는 경우 : 1번의 SQL문으로 최적화. 이 시점에서 [지연 로딩]이긴 하지만, m 엔티티와 관련된 team 엔티티도 같이 가져 온다.
            List<Member> resultList = entityManager.createQuery("select m from Member m JOIN FETCH m.team",Member.class)
                    .getResultList();

            for (Member member : resultList) {

                System.out.println("member.name = " + member.getUsername() +"," +

                        member.getTeam().getName());  // Proxy 초기화가 일어나지 x. 왜냐하면 위에서 이미 실제 Team 엔티티를 조회했기 때문!
            }

            transaction.commit();
        }catch(Exception e){

            transaction.rollback();
            e.printStackTrace();
        }
        finally {
            entityManager.close();
        }

        entityManagerFactory.close();



    }
}