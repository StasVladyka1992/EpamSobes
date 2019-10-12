package Collections;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * @project EpamSobes
 * author Stas Vladyka on 20.07.2019.
 */
public class QueueExample {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        QueueExample queueExample = new QueueExample();
        Random rand = new Random(47);
        for (int i = 0; i <10 ; i++) {
            queue.offer(rand.nextInt(i+10));
        }
        queueExample.print(queue);

        Queue<Character> queue1 = new LinkedList<>();
        for (Character c:"Brontosaurus".toCharArray()) {
            queue1.offer(c);
        }
        queueExample.print(queue1);

    }
    public void print (Queue queue){
        while(queue.peek()!=null){
            System.out.print(queue.remove()+" ");
        }
        System.out.println();
    }
}
