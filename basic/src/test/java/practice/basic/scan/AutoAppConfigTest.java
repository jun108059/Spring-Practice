package practice.basic.scan;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import practice.basic.AutoAppConfig;
import practice.basic.member.MemberService;

public class AutoAppConfigTest {

    @Test
    void basicScanTest() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService memberService = ac.getBean(MemberService.class);
        Assertions.assertTrue(memberService instanceof MemberService);
    }
}
