package Arrays;

public class Battery implements Comparable<Battery> {
    int capacity;
    String producer;
    int price;

    public Battery(int capacity, String producer, int price) {
        this.capacity = capacity;
        this.producer = producer;
        this.price = price;
    }

    @Override
    public int compareTo(Battery o) {
        return price - o.price;
    }

    @Override
    public String toString() {
        return "Battery "+ producer+ " capacity "+ capacity + " price "+ price;
    }
}
