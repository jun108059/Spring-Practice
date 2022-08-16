package practice.basic.discount;

import org.springframework.stereotype.Component;
import practice.basic.member.Grade;
import practice.basic.member.Member;

@Component
public class RateDiscountPolicy implements DiscountPolicy{

    private final int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        }
        else {
            return 0;
        }
    }
}
