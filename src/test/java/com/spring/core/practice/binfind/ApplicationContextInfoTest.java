package com.spring.core.practice.binfind;

import com.spring.core.practice.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력")
    void findAllBean() {
        String[] beanDefinitions = ac.getBeanDefinitionNames();

        for (String s : beanDefinitions) {
            Object bean = ac.getBean(s);
            System.out.println("name = " + s + " objet =" + bean);
        }
    }

    @Test
    @DisplayName("application bean 출력")
    void findApplicationBean() {
        String[] beanDefinitions = ac.getBeanDefinitionNames();

        for (String s : beanDefinitions) {
            BeanDefinition definition = ac.getBeanDefinition(s);
            if (definition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = ac.getBean(s);
                System.out.println("name = " + s + " objet =" + bean);
            }
        }
    }

}
