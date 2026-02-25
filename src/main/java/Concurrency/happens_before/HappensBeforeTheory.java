package Concurrency.happens_before;

/*
To guarantee that the thread executing action Y can see the results
of action X (whether or not X and Y occur in different threads), there must be a happens-before relationship
between X and Y. In the absence of a happens-before ordering between two operations, the JVM is free to reorder
them as it wants (JIT compiler optimization)
*/

//TODO 1. Правило монитора (Monitor Lock Rule)
//Разблокировка монитора happens-before последующей блокировкой того же монитора.

//TODO 2. Правило volatile переменной (Volatile Variable Rule)
//Запись в volatile переменную happens-before чтением той же переменной.

//TODO 3. Правило транзитивности (Transitivity Rule)
//Если A happens-before B и B happens-before C, то A happens-before C.

//TODO 4. Правило старта потока (Thread Start Rule)
//Вызов Thread.start() happens-before любым действием в запущенном потоке.

//TODO 5. Правило завершения потока (Thread Join Rule)
//Действия в потоке happens-before возврата из join() для этого потока.

//TODO 6. Правило прерывания потока (Thread Interruption Rule)
//Вызов interrupt() happens-before обнаружению прерывания.

//TODO 7. Правило финализации (Finalizer Rule)
//Окончание конструктора happens-before началом finalize().



//https://www.logicbig.com/tutorials/core-java-tutorial/java-multi-threading/happens-before.html
public class HappensBeforeTheory {

}
