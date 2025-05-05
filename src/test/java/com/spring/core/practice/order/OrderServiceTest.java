package com.spring.core.practice.order;

import com.spring.core.practice.member.Grade;
import com.spring.core.practice.member.Member;
import com.spring.core.practice.member.MemberService;
import com.spring.core.practice.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId,"memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA",1000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }
}
