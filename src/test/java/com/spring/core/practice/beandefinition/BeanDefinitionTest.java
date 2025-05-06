package com.spring.core.practice.beandefinition;

import com.spring.core.practice.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanDefinitionTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 설정 확인")
    void findApplicationBean() {
        String[] beanDefinitions = ac.getBeanDefinitionNames();
        for (String name : beanDefinitions) {
            BeanDefinition definition = ac.getBeanDefinition(name);

            if (definition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                System.out.println("name = " + name + "definition = " + definition);
            }
        }
    }

}
