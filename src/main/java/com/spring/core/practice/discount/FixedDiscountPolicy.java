package com.spring.core.practice.discount;

import com.spring.core.practice.member.Grade;
import com.spring.core.practice.member.Member;

public class FixedDiscountPolicy implements DiscountPolicy {

    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        } else {
            return 0;
        }

    }
}
