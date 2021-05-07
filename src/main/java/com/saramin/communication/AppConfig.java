package com.saramin.communication;

import com.saramin.communication.discount.DiscountPolicy;
import com.saramin.communication.discount.RateDiscountPolicy;
import com.saramin.communication.member.MemberRepository;
import com.saramin.communication.member.MemberService;
import com.saramin.communication.member.MemberServiceImpl;
import com.saramin.communication.member.MemoryMemberRepository;
import com.saramin.communication.order.OrderService;
import com.saramin.communication.order.OrderServiceImpl;

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
