package Thread.WaitAndNotifyShop;

/*
Producer–consumer
*/



public class Solution {
    public static void main(String args[]) throws InterruptedException {
        for (int i = 0; i <10 ; i++) {
            TransferObject transferObject = new TransferObject();
            ProducerTask producerTask = new ProducerTask(transferObject);
            ConsumerTask consumerTask = new ConsumerTask(transferObject);

            Thread.sleep(50);
            producerTask.stop();
            consumerTask.stop();
        }

    }
}
