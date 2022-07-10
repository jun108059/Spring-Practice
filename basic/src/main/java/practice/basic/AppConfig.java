package practice.basic;

import practice.basic.discount.DiscountPolicy;
import practice.basic.discount.RateDiscountPolicy;
import practice.basic.member.MemberRepository;
import practice.basic.member.MemberService;
import practice.basic.member.MemberServiceImpl;
import practice.basic.member.MemoryMemberRepository;
import practice.basic.order.OrderService;
import practice.basic.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(getMemberRepository());
    }

    private MemberRepository getMemberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(getMemberRepository(), getDiscountPolicy());
    }

    public DiscountPolicy getDiscountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
