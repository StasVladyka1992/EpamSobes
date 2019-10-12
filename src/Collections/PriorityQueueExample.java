package Collections;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * @project EpamSobes
 * author Stas Vladyka on 21.07.2019.
 */
public class PriorityQueueExample {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        Random random = new Random(30);
        for (int i = 0; i < 10; i++) {
            //get random elem from [i,30]
            priorityQueue.offer(i + random.nextInt(30 - i));
        }
        System.out.println(priorityQueue);

        //выводится в порядке приоритета, т.е. в порядке СОРТИРОВКИ 
        List<Integer> list = Arrays.asList(25, 255, 300, 302, 120, 912);
        priorityQueue = new PriorityQueue<>(list);
        System.out.println(priorityQueue);
    }
}
