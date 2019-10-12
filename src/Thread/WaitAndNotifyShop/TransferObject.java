package Thread.WaitAndNotifyShop;

public class TransferObject {
    private int value;
    protected volatile boolean isValuePresent = false; //use this variable


    // Логика методов get и put была изначально другой: выполнение проги запускалось исходя из переменной isValuePresent
    // т.е. шел цикл while (isValuePresent) {...}, после изменения его вида на while (isValuePresent), прошло валидацию
    public synchronized int get() {
        while (!isValuePresent) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Got: " + value);
        isValuePresent = false;
        notify();

        return value;
    }

    public synchronized void put(int value) {
        while (isValuePresent)
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        this.value = value;
        isValuePresent = true;
        System.out.println("Put: " + value);
        notify();
    }
}
