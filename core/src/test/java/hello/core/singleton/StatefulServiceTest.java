package hello.core.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

        StatefulService statefulService = ac.getBean("statefulService",StatefulService.class);
        StatefulService statefulService2 = ac.getBean("statefulService",StatefulService.class);

        //ThreadA : A사용자 1만원주문
        int userAPrice = statefulService.order("userA", 10000);

        //ThreadB : B사용자 2만원주문
        int userBPrice = statefulService2.order("userB", 20000);

        System.out.println("userAPrice = " + userAPrice);
        //assertThat(statefulService.getPrice()).isEqualTo(20000);
    }

    static class TestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }

}