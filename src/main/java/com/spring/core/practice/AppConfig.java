package com.spring.core.practice;

import com.spring.core.practice.discount.DiscountPolicy;
import com.spring.core.practice.discount.RateDiscountPolicy;
import com.spring.core.practice.member.MemberRepository;
import com.spring.core.practice.member.MemberService;
import com.spring.core.practice.member.MemberServiceImpl;
import com.spring.core.practice.member.MemoryMemberRepository;
import com.spring.core.practice.order.Order;
import com.spring.core.practice.order.OrderService;
import com.spring.core.practice.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(getMemberRepository());
    }

    private MemberRepository getMemberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(getMemberRepository(), getDiscountPolicy());
    }

    private DiscountPolicy getDiscountPolicy() {
        return new RateDiscountPolicy();
    }


}

