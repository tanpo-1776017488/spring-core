package com.spring.core.practice.order;

import com.spring.core.practice.discount.DiscountPolicy;
import com.spring.core.practice.discount.FixedDiscountPolicy;
import com.spring.core.practice.member.Member;
import com.spring.core.practice.member.MemberRepository;
import com.spring.core.practice.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixedDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
