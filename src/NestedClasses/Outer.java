package NestedClasses;

//рассмотрение вложенных классов (на примере статического класса)
public class Outer {
    private int outterPrivateObjectField;
    private static int outterPrivateStaticField;

    private void outterPrivateNONStaticPrint() {
    }

    private static void outterPrivateStaticPrint() {
    }

    public static void main(String[] args) {
        //внешний класс может обращаться к ЛЮБЫМ(private, public или static, non-static) переменным и методам вложенного класса
        // через указание имени класса
        StaticNestedClass.nestedPrivateStaticField = 10;
        StaticNestedClass staticNestedClass = new StaticNestedClass();
        staticNestedClass.nestedPrivateObjectField = 10;
        StaticNestedClass.nestedPrivateStaticPrint();
    }


    // класс вложенный в интерфейс статический по умолчанию.
    // вложенный статический класс может реализовывать интерфейсы, наследоваться, быть абстрактным без ограниченний


    public static class StaticNestedClass {
        private int nestedPrivateObjectField;
        private static int nestedPrivateStaticField;

        public static void main(String[] args) {
            //статический класс имеет доступ ко ВСЕМ (в т.ч. private полям и методам внешнего класса), кроме нестатических
            //полей и методов, за исключением случая создания объекта внешнего класса и обращения через него
            //Пример:
            //обращение к приватному static методу внешнего класса
            outterPrivateStaticPrint();
            //создание объекта внешнего класса
            Outer outer = new Outer();
            //обращение к приватному non-static методу внешнего класса
            outer.outterPrivateNONStaticPrint();
            //обращение к приватной переменной экземпляра внешнего класса
            outer.outterPrivateObjectField = 10;
            //обращение к приватной переменной внешнего класса
            outterPrivateStaticField = 20;
        }


        private static void nestedPrivateStaticPrint() {
        }

        private void nestedPrivateNONStaticPrint() {
        }
    }
}
    // подкласс вложенного класса не наследует возможность доступа к членам внешнего класса,
    // которыми наделен его суперкласс: т.е. Outer2 не может обращаться к private переменным класса Outer
//    public  class Outer2 extends Outer.StaticNestedClass{
//    }
