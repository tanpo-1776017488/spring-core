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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }


}

