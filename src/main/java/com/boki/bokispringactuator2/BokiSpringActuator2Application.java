package com.boki.bokispringactuator2;

import com.boki.bokispringactuator2.order.v1.OrderConfigV1;
import com.boki.bokispringactuator2.order.v2.OrderConfigV2;
import com.boki.bokispringactuator2.order.v3.OrderConfigV3;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.web.exchanges.InMemoryHttpExchangeRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

//@Import(OrderConfigV0.class)
//@Import(OrderConfigV1.class)
//@Import(OrderConfigV2.class)
@Import(OrderConfigV3.class)
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
