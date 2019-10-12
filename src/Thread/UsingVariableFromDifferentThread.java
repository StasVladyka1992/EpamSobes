package Thread;

import sun.applet.Main;

public class UsingVariableFromDifferentThread{
  public static int counter;
     // сразу может быть не видно, но значение переменной counter может различаться, причем очень сильно, при одном и том
    // же запуске программы. Для того чтобы это исправить необходимо использовать syncronized блок. Этот блок может быть вызван
    // только на объекте (в т.ч. на объекте класса)
    public static void main(String[] args) {
        Thread t1 = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 10_000_000; i++) {
                    counter++;
                }
            }
        };

        Thread t2 = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i <10_000_000 ; i++) {
                    counter++;
                }

            }
        };

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        }
        catch (InterruptedException ex){
            ex.printStackTrace();
        }
        System.out.println(counter);
    }



}
