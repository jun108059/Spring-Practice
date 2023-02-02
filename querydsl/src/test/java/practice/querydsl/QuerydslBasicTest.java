package practice.querydsl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import practice.querydsl.entity.*;

import javax.persistence.EntityManager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static practice.querydsl.entity.QMember.*;

@SpringBootTest
@Transactional
class QuerydslBasicTest {

	@Autowired
	EntityManager em;

	JPAQueryFactory queryFactory;

	@BeforeEach
	public void before() {
		queryFactory = new JPAQueryFactory(em);

		Team teamA = new Team("teamA");
		Team teamB = new Team("teamB");
		em.persist(teamA);
		em.persist(teamB);

		Member member1 = new Member("member1", 10, teamA);
		Member member2 = new Member("member2", 20, teamA);
		Member member3 = new Member("member3", 30, teamB);
		Member member4 = new Member("member4", 40, teamB);

		em.persist(member1);
		em.persist(member2);
		em.persist(member3);
		em.persist(member4);
	}

	@DisplayName("JPQL 테스트")
	@Test
	void startJPQL() {

		String qlString = "select m from Member m where m.username = :username";
		Member findMember = em.createQuery(qlString, Member.class)
				.setParameter("username", "member1")
				.getSingleResult();

		assertEquals(findMember.getUsername(), "member1");

	}

	@DisplayName("QueryDSL 테스트")
	@Test
	void startQuerydsl() {
		Member findMember = queryFactory
				.select(member)
				.from(member)
				.where(member.username.eq("member1"))
				.fetchOne();

		assertEquals(findMember.getUsername(), "member1");
	}

	@Test
	public void search() {
		Member findMember = queryFactory
				.selectFrom(member)
				.where(member.username.eq("member1")
						.and(member.age.eq(10)))
				.fetchOne();
		assertEquals(findMember.getUsername(), "member1");
	}

	@Test
	public void searchAndParam() {
		List<Member> result1 = queryFactory
				.selectFrom(member)
				.where(member.username.eq("member1"),
						member.age.eq(10))
				.fetch();
		assertEquals(result1.size(), 1);
	}
}
