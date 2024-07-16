package com.boki.bokispringactuator2;

import com.boki.bokispringactuator2.order.v0.OrderConfigV0;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.web.exchanges.InMemoryHttpExchangeRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@Import(OrderConfigV0.class)
@SpringBootApplication(scanBasePackages = "com.boki.bokispringactuator2.controller")
public class BokiSpringActuator2Application {

    public static void main(String[] args) {
        SpringApplication.run(BokiSpringActuator2Application.class, args);
    }

    @Bean
    public InMemoryHttpExchangeRepository httpExchangeRepository() {
        return new InMemoryHttpExchangeRepository();
    }
}
