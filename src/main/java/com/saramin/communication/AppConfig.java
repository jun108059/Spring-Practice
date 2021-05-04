package com.saramin.communication;

import com.saramin.communication.discount.FixDiscountPolicy;
import com.saramin.communication.member.MemberService;
import com.saramin.communication.member.MemberServiceImpl;
import com.saramin.communication.member.MemoryMemberRepository;
import com.saramin.communication.order.OrderService;
import com.saramin.communication.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
