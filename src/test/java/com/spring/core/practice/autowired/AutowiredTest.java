package com.spring.core.practice.autowired;

import com.spring.core.practice.member.Member;
import jakarta.annotation.Nullable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void autowiredOption() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean {

        @Autowired(required = false)
        public void setBean1(Member member1) {
            System.out.println("TestBean.setBean1" + member1);
            // Member가 bean에 등록되지 않았기 때문에 호출되지 않음.
        }

        @Autowired
        public void setBean2(@Nullable Member member2) {
            System.out.println("TestBean.setBean2" + member2);
            // 호출은 되지만 null
        }

        @Autowired
        public void setBean3(Optional<Member> member3) {
            System.out.println("TestBean.setBean3" + member3);
            // 호출은 되지만 empty
        }


    }
}
