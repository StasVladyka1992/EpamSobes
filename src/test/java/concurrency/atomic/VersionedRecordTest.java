package concurrency.atomic;

import jdk.jfr.Description;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicStampedReference;


public class VersionedRecordTest {
    @Test
    @Description("VersionedRecord - потокобезопасная запись с версионностью, которая позволяет обновлять данные только если версия совпадает")
    public void versionedRecord() throws InterruptedException {
        var record = new VersionedRecord("initial");

        var updateThread1 = new Thread(() -> {
            boolean success = record.update("update1", 0);
            System.out.println("Update 1 success: " + success);
        });

        var updateThread2 = new Thread(() -> {
            boolean success = record.update("update2", 0);
            System.out.println("Update 2 success: " + success);
        });

        var updateThread3 = new Thread(() -> {
            boolean success = record.update("update3", 0);
            System.out.println("Update 3 success: " + success);
        });

        var updateThread4 = new Thread(() -> {
            boolean success = record.update("update4", 0);
            System.out.println("Update 4 success: " + success);
        });

        var updateThread5 = new Thread(() -> {
            boolean success = record.update("update5", 0);
            System.out.println("Update 5 success: " + success);
        });

        updateThread1.start();
        updateThread2.start();
        updateThread3.start();
        updateThread4.start();
        updateThread5.start();


        updateThread1.join();
        updateThread2.join();
        updateThread3.join();
        updateThread4.join();
        updateThread5.join();


        System.out.println("Final value: " + record.read());
        System.out.println("Final version: " + record.getVersion());
    }


    public static class VersionedRecord{
        private AtomicStampedReference<String> data;

        public VersionedRecord (String value){
            data = new AtomicStampedReference<>(value, 0);
        }

        public boolean update(String newData, int expectedVersion) {
            String currentRef = data.getReference();
            int currentStamp = data.getStamp();

            if (currentStamp != expectedVersion) {
                return false;
            }

            return data.compareAndSet(currentRef, newData, currentStamp, currentStamp + 1);
        }

        public String read(){
            return data.getReference();
        }

        public int getVersion() {
            return data.getStamp();
        }
    }
}
