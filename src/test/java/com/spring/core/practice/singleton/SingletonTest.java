package com.spring.core.practice.singleton;

import com.spring.core.practice.AppConfig;
import com.spring.core.practice.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();
        // 사용자의 요구가 생길 때 마다 새로은 service를 생성하게 됨.
        MemberService memberService1 = appConfig.memberService();

        MemberService memberService2 = appConfig.memberService();

        Assertions.assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService1 = ac.getBean(MemberService.class);

        MemberService memberService2 = ac.getBean(MemberService.class);

        Assertions.assertThat(memberService1).isSameAs(memberService2);
    }
}
