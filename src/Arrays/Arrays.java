package Arrays;

public class Arrays {
    public static void main(String[] args) {
        // массивы - это объекты если объявляется ссылка на массив и она ничем не инициализируется,
        // присваивается значение null. Если внутри ничего не хранится, то значения по умолчанию в ячейках
        // соответствуют значениям типа массива: для int = 0, для Integer = null и т.п.
        Integer [] ar = new Integer [2];
        for (int i = 0; i <ar.length; i++) {
            System.out.println(ar[i]);
        }
        //Доказательство, что это массив - это объект видно в выводею "[" означает, что это массив, а F- соответствует
        //примитивному типу F
        float [] checkClass = {24.5f, 2141.1f,1412.3f};
        System.out.println("array class: "+ checkClass.getClass());


        // способы создания массива:
        //1)
        Object [] ar1 = new Object[2];

        //2)
        Object [] ar2 = { new Object(), new Object()};

        //3)
        Object [] ar3 = new Object[] {new Object()};

        // ПРИВЕДЕНИЕ ТИПОВ для массивов

        // из обертки в примитивы преобразования запрещены
            // Integer [] ar4 = new Integer[]{new Integer(2), new Integer(3)};
            // int [] ar5 = (int[]) ar4;
        Object ob;
        float [] ar4 = {2.5f,2.3f};
        ob = ar4; //говорит о том, что массив - это объект

        // ArrayStoreException
//        Object[] o = "a;b;c".split(";");
//        o[0] = 42;

        //Массив массивов
        // Многомерных массивов в Java не существует, зато существует массив массивов. Вид инициализация говорит о том,
        // что это не многомерный массив, а массив массивов ( обрати вниммание на {});
        int [] [] ar5 = new int [] []{{2,5,6},
                                      {2,8,9,15},
                                      {3,6,10,10,0,5}};

        for (int i = 0; i <ar5.length; i++) {
            for (int j = 0; j <ar5[i].length ; j++) {
                System.out.println(ar5[i][j]);
            }
        }
    }
}
