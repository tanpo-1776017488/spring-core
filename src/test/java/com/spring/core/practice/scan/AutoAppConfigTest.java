package com.spring.core.practice.scan;

import com.spring.core.practice.AutoAppConfig;
import com.spring.core.practice.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoAppConfigTest {

    @Test
    void basicScan() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService memberservice = ac.getBean(MemberService.class);
        Assertions.assertThat(memberservice).isInstanceOf(MemberService.class);
    }
}
