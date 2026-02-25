package Clone;

public class CloneTheory {
    //В java по умолчанию происходит поверхностное копирование. Для полного копирования необходимо, чтобы все поля клонируемого
    //объекта имплементировали интерфейс Cloneable

    public static void main(String[] args) throws CloneNotSupportedException {
        Pilot pilot = new Pilot();
        pilot.setAge(10);
        pilot.setName("Michael");
        Kart parentKart = new Kart(60, 20, pilot);
//		parentKart.clone() - Can't do this, because we try to call clone() of Kart, but due to protected term, protected
//		method can be called only inside class itself and inside children. CloneTheory isn't a child of Kart
        Kart newKart = (Kart) parentKart.clone();
        parentKart.getPilot().setName("Andrew");
        System.out.println("old one:" + parentKart.toString());
        System.out.println("new one:" + newKart.toString());
    }
    //test commit for rebase
    //test commit for rebase 2
    //test commit for rebase 3 from test
}
