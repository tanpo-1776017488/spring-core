package com.spring.core.practice;

import com.spring.core.practice.member.Grade;
import com.spring.core.practice.member.Member;
import com.spring.core.practice.member.MemberService;
import com.spring.core.practice.member.MemberServiceImpl;
import com.spring.core.practice.order.Order;
import com.spring.core.practice.order.OrderService;
import com.spring.core.practice.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId,"memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId,"itemA",1000);
        System.out.println(order);
        System.out.println(order.calculatePrice());
    }
}
