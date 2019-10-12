public class Cycles {
    public static void main(String[] args) {
        // Управляющая конструкция switch:
        // в качестве const может использоваться int, byte, short (их обертки), string, enum,
        String s1 = "Стас";
        switch (s1){
            case "Вовка":{
                System.out.println("Конь");
            }
            case "3": {
                System.out.println("Балет");
            }
            case "Стас":{
                System.out.println("Стас");
            }
            default:{
                break;
            }
        }

        // В java были добавлены новые возможности для continue и break.
        int a = 15;
        for (int i = 0; i <10 ; i++) {
            System.out.printf("цикл 1, шаг %d", i);
            System.out.println();
            OUT:
            //TODO новая возможность
            for (int j = 0; j < 10; j++) {
                System.out.printf("цикл 2, шаг %d", j);
                System.out.println();
                if (a > 2) {
                    System.out.println("конструкция if");
                    for (int k = 0; k < 3; k++) {
                        break OUT; //TODO новая возможность
                    }
                }
            }
        }
    }
}
