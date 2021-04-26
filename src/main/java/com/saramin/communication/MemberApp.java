package com.saramin.communication;

import com.saramin.communication.member.Grade;
import com.saramin.communication.member.Member;
import com.saramin.communication.member.MemberService;
import com.saramin.communication.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);

        System.out.println("new Member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
