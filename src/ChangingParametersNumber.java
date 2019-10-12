public class ChangingParametersNumber {
    public static void main(String[] args) {
    Integer [] i = {1,3,45,6};
    printArgCount(7,"No", true, null);
    printArgCount(i,i,i);
    printArgCount(i,4,71);
    printArgCount(i);
    //printArgCount(5,7); неопределенность
    }

    public static void printArgCount(Object ... args){
        System.out.println("Object args: " +args.length);
    }
    public static void printArgCount(Integer[] ... args){
        System.out.println("Integer [] args: " + args.length);
    }
    public static void printArgCount(int ... args){
        System.out.println("int args: " + args.length);
    }




}
