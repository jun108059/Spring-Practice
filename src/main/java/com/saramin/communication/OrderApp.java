package com.saramin.communication;

import com.saramin.communication.member.Grade;
import com.saramin.communication.member.Member;
import com.saramin.communication.member.MemberService;
import com.saramin.communication.order.Order;
import com.saramin.communication.order.OrderService;

public class OrderApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();

        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "itemA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order : " + order);
    }
}
