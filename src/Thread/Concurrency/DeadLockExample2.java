package Thread.Concurrency;

public class DeadLockExample2 {

    // В этой задаче происходит DeadLock объектов o1 и o2. Чтобы он наверняка произошел,
    // Мы делаем синхронизацию по объекту o1 и о2 у первой нити. После засыпаем на 500 милисек.
    // далее вызываем метод someMethodWithSynchronizedBlocks у второй ниит, чтобы попытаться заблочить мютексы у o1 и o2
    // и уже после этого смотрим, какой объект залочился первым благодаря методу getState();
        public void someMethodWithSynchronizedBlocks(Object obj1, Object obj2) {
            synchronized (obj1) {

                synchronized (obj2) {
                    System.out.println(obj1 + " " + obj2);
                }
            }
        }

        public static boolean isNormalLockOrder(final DeadLockExample2 solution, final Object o1, final Object o2) throws Exception {

            Thread t1 = new Thread() {
                @Override
                public void run() {
                    try {
                        synchronized (o1){
                            sleep(500);
                            synchronized (o2){
                            }
                        }


                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };

            Thread t2 = new Thread() {
                @Override
                public void run() {
                    solution.someMethodWithSynchronizedBlocks(o1, o2);
                }
            };
            t1.start();
            t2.start();
            Thread.sleep(2000);
            if (t2.getState() != Thread.State.BLOCKED) {
                return true;
            }
            return false;
        }

        public static void main(String[] args) throws Exception {

                final DeadLockExample2 solution = new DeadLockExample2();
                final Object o1 = new Object();
                final Object o2 = new Object();

                System.out.println(isNormalLockOrder(solution, o1, o2));
            }

    }

