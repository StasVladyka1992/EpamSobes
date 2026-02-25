package Concurrency.locking.lock_free_algorithm;

import java.util.concurrent.atomic.AtomicInteger;

//TODO FAA
//Aтомарная операция процессора, которая возвращает текущее значение, добавляет к нему указанное число и сохраняет результат
public class FAAAlgorithm {
    private AtomicInteger counter = new AtomicInteger(0);

    public void increment() {
        // Это FAA операция под капотом
        int oldValue = counter.getAndIncrement();  // FAA
        // или
        int oldValue2 = counter.getAndAdd(5);      // FAA с произвольным дельта
    }
}
