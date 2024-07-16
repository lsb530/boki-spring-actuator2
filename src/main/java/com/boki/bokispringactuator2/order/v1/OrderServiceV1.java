package com.boki.bokispringactuator2.order.v1;

import com.boki.bokispringactuator2.order.OrderService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderServiceV1 implements OrderService {

    private final MeterRegistry registry;

    private AtomicInteger stock = new AtomicInteger(100);

    public OrderServiceV1(MeterRegistry registry) {
        this.registry = registry;
    }

    @Override
    public void order() {
        log.info("주문");
        stock.decrementAndGet();

        Counter.builder("my.order")
            .tag("class", this.getClass().getSimpleName())
            .tag("method", "order")
            .description("order")
            .register(registry)
            .increment();
    }

    @Override
    public void cancel() {
        log.info("취소");
        stock.incrementAndGet();

        Counter.builder("my.order")
            .tag("class", this.getClass().getSimpleName())
            .tag("method", "cancel")
            .description("order")
            .register(registry)
            .increment();
    }

    @Override
    public AtomicInteger getStock() {
        return stock;
    }
}
