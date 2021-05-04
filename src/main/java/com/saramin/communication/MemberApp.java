package com.saramin.communication;

import com.saramin.communication.member.Grade;
import com.saramin.communication.member.Member;
import com.saramin.communication.member.MemberService;

public class MemberApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new Member : " + findMember.getName());
    }
}
