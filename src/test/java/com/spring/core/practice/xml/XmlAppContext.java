package com.spring.core.practice.xml;

import com.spring.core.practice.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class XmlAppContext {

    @Test
    void xmlAppContext() {
        ApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");
        MemberService service = ac.getBean("memberService", MemberService.class);
        Assertions.assertThat(service).isInstanceOf(MemberService.class);
    }
}
