package com.spring.core.practice.discount;

import com.spring.core.practice.member.Member;

public interface DiscountPolicy {

    int discount(Member member, int price);
}
