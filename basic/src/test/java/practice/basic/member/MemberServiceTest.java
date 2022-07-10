package practice.basic.member;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService = new MemberServiceMemoryImpl();

    @Test
    @DisplayName("회원가입이 잘 되는지 테스트")
    void 회원_가입_검증() {
        // given
        Member member = new Member(1L, "memberA", Grade.VIP);

        // when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        // then
        Assertions.assertEquals("memberA", findMember.getName());

    }
}
