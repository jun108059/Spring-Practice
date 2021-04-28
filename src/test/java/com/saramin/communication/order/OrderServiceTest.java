package com.saramin.communication.order;

import com.saramin.communication.member.Grade;
import com.saramin.communication.member.Member;
import com.saramin.communication.member.MemberService;
import com.saramin.communication.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscount()).isEqualTo(1000);
    }
}