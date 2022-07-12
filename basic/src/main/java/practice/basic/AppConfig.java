package practice.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import practice.basic.discount.DiscountPolicy;
import practice.basic.discount.RateDiscountPolicy;
import practice.basic.member.MemberRepository;
import practice.basic.member.MemberService;
import practice.basic.member.MemberServiceImpl;
import practice.basic.member.MemoryMemberRepository;
import practice.basic.order.OrderService;
import practice.basic.order.OrderServiceImpl;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        System.out.println("Call -> AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("Call -> AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("Call -> AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), getDiscountPolicy());
    }

    @Bean
    public DiscountPolicy getDiscountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
