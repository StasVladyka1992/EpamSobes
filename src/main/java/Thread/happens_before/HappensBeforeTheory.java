package Thread.happens_before;

/*
To guarantee that the thread executing action Y can see the results
of action X (whether or not X and Y occur in different threads), there must be a happens-before relationship
between X and Y. In the absence of a happens-before ordering between two operations, the JVM is free to reorder
them as it wants (JIT compiler optimization)
*/

//https://www.logicbig.com/tutorials/core-java-tutorial/java-multi-threading/happens-before.html
public class HappensBeforeTheory {

}
