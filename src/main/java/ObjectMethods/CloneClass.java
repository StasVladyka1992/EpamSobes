package ObjectMethods;

import java.util.ArrayList;
import java.util.Objects;

public class CloneClass implements Cloneable{
    int a = 10;
    String s = "Stas";

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CloneClass)) return false;
        CloneClass that = (CloneClass) o;
        return a == that.a &&
                Objects.equals(s, that.s);
    }

    @Override
    public int hashCode() {

        return Objects.hash(a, s);
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        CloneClass cl1 = new CloneClass();
        cl1.a=11;
        cl1.s="Maks";

        CloneClass cl2 = (CloneClass) cl1.clone();
        System.out.println(cl2.equals(cl1));
        ArrayList <Integer> ar = new ArrayList<>();
        for (int i = 0; i <ar.size(); i++) {
            System.out.println(ar.get(i));
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }

//    https://www.infoq.com/news/2017/03/Java-Finalize-Deprecated/
//    https://hackernoon.com/java-lang-object-finalize-is-finally-deprecated-f99df40fa71
//    https://medium.com/javarevisited/time-to-say-goodbye-to-the-finalize-method-in-java-a2f5b7e4f1b1
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }


}
