package com.spring.core.practice.order;

import com.spring.core.practice.discount.DiscountPolicy;
import com.spring.core.practice.discount.FixedDiscountPolicy;
import com.spring.core.practice.discount.RateDiscountPolicy;
import com.spring.core.practice.member.Member;
import com.spring.core.practice.member.MemberRepository;
import com.spring.core.practice.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
