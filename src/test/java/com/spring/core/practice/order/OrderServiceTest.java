package com.spring.core.practice.order;

import com.spring.core.practice.AppConfig;
import com.spring.core.practice.member.Grade;
import com.spring.core.practice.member.Member;
import com.spring.core.practice.member.MemberService;
import com.spring.core.practice.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appCfg = new AppConfig();
        memberService = appCfg.memberService();
        orderService = appCfg.orderService();
    }

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId,"memberA", Grade.VIP);
        memberService.join(member);
        int itemPrice = 10000;
        int expDiscont = itemPrice / 10;
        Order order = orderService.createOrder(memberId, "itemA",itemPrice);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(expDiscont);

    }
}
