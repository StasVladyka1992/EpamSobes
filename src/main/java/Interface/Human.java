package Interface;

public class Human implements Behavior{
    @Override
    public void think() {
        walk();
    }

    @Override
    public void arguing() {
        think();
    }

    @Override
    public void walk() {
        swim();
    }

    @Override
    public void swim() {
        getStackTrace();
    }


    public void getStackTrace () {
        StackTraceElement [] st = Thread.currentThread().getStackTrace();
        for (StackTraceElement s: st) {
            System.out.println(s.getMethodName());
        }
    }

    public static void main(String[] args) {
        Human h = new Human();
        h.arguing();
    }
}
