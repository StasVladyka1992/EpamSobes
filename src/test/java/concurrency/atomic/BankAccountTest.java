package concurrency.atomic;


import jdk.jfr.Description;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.assertEquals;



public class BankAccountTest {

    @Test
    @Description("BankAccount - потокобезопасный счет, который позволяет делать депозиты и снимать деньги одновременно из разных потоков")
    public void depositsAndWithdrawals() throws InterruptedException {
        var account = new BankAccount(BigDecimal.ZERO);

        var depositThread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                account.deposit(BigDecimal.ONE);
            }
        });

        var withdrawThread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                account.withdraw(BigDecimal.ONE);
            }
        });

        depositThread.start();
        withdrawThread.start();

        depositThread.join();
        withdrawThread.join();

        assertEquals(BigDecimal.ZERO, account.balance.get());
    }

    public static class BankAccount {
        private final AtomicReference<BigDecimal> balance;

        public BankAccount(BigDecimal initialBalance) {
            balance = new AtomicReference<>(initialBalance);
        }

        public void withdraw(BigDecimal amount) {
//            balance.compareAndSet(balance.get(), balance.get().subtract(amount)); //TODO balance.compareAndSet и balance.get() - не атомарны в связке
            balance.updateAndGet(current -> current.subtract(amount));
        }

        public void deposit(BigDecimal amount) {
//            balance.compareAndSet(balance.get(), balance.get().add(amount)); //TODO balance.compareAndSet и balance.get() - не атомарны в связке
            balance.updateAndGet(current -> current.add(amount));
        }
    }
}
