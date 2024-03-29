package Enum;

public enum EnumType {
    Friday(1){
        //переопределение abstract метода у каждого члена класса
        @Override
        public void print() {

        }
    },
    Thirhday(2){
        //переопределение abstract метода у каждого члена класса
        @Override
        public void print() {

        }
    },

    Wendsday(3){
        //переопределение abstract метода у каждого члена класса
        @Override
        public void print() {

        }
    };
    //Вместо слова class при описании перечисления используется слово enum. При этом объекты
    // перечисления инициализируются прямым объявлением без помощи оператора new.

    // При инициализации хотя бы одного перечисления происходит инициализация
    // всех без исключения оставшихся элементов данного перечисления.

    // Если хотим добавить поля, то перечисления д.б. на первом месте, потом поля
    // Конструктор м.б. только private


    // Enum-классам запрещено:
    //• быть суперклассами, т.к. они final;
    //• быть подклассами, т.к они наследуются от java.lang.Enum, а множественное наследование запрещено;
    //• быть абстрактными (т.е. в указании класса не может быть слова abstract), но могут быть абстрактные методы, тогда они должны быть переопределены в каждом экземпляре Enum;
    //• создавать экземпляры, используя ключевое слово new, т.к. у них private конструктор по умолчанию.

    // Особенности:
    //• неявно реализует интерфейсы Serializable и Comparable
    //• не достуны для переопределения методы Object, кроме toString. Эти методы уже переопределены в классе Enum от
    //которого наследуется все enum классы.

    private int a;
    private String s;

    public abstract void print();
    public void ordinaryPring(){
        System.out.println("Ordinary print");
    }

    //friendly модификатор доступа к конструктору (на самом деле модификатор по умолчанию private)
    EnumType(int a ){
        this.a=a;
    }
    //private модификатор доступа
    private EnumType(){

    }
}
