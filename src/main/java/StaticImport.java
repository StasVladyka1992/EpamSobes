// благодаря статическому импорту нет нужды писать каждый раз Math
import static java.lang.Math.*;
// также можно импортнуть отдельный метод
import static java.lang.Integer.toHexString;

public class StaticImport {
    public static void main(String[] args) {
        //Counting square of triangle
        System.out.println(countSquare(4,3));
        System.out.println(toHexString(12));
    }
    private static double countSquare(int ... a){
    return sqrt(pow(a[0],2)+pow(a[1],2));
    }
}
