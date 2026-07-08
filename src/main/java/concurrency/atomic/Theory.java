package concurrency.atomic;

public class Theory {
//	Теория по атомикам:
//	http://java-online.ru/concurrent-atomic.xhtml
//	https://www.baeldung.com/java-atomic-variables

//TODO AtomicLong
//TODO AtomicInteger
//TODO AtomicBoolean

//ABA-проблема: Поток может не заметить, что значение менялось A -> B -> A
//TODO AtomicReference - защищает не объект, а ссылку
//TODO AtomicStampedReference - защищает объект и версию (стамп), который позволяет решать ABA-проблему
//TODO AtomicMarkableReference


//TODO AtomicLongArray
//TODO AtomicIntegerArray - Обычный массив int[] или Object[] не потокобезопасен.
//TODO AtomicReferenceArray
//Даже изменение одного элемента array[i] = x не гарантирует, что другой поток увидит изменение.
//volatile здесь не поможет для элементов массива. AtomicIntegerArray дает гарантию на атомарность с одним элементом массива, НО НЕ ВСЕХ

//АТОМАРНЫ для каждого элемента:
//atomicArray.set(0, 42)           // happens-before гарантия
//atomicArray.get(0)                // volatile чтение
//atomicArray.getAndSet(0, 100)     // атомарная замена
//atomicArray.compareAndSet(0, 42, 100)  // CAS операция
//atomicArray.getAndIncrement(0)    // атомарный инкремент
//atomicArray.addAndGet(0, 5)       // атомарное сложе

//НЕ АТОМАРНЫ:
//Атомарность композитных операций над разными элементами
//Атомарность операций над ВСЕМ массивом (нет блокировки всего массива)


//TODO AtomicLongFieldUpdater
//TODO AtomicIntegerFieldUpdater
//TODO AtomicReferenceFieldUpdater

//    public class Example {
//        private volatile int value;
//
//        private static final AtomicIntegerFieldUpdater<Example> UPDATER =
//                AtomicIntegerFieldUpdater.newUpdater(Example.class, "value");
//
//        public void increment() {
//            // Гарантированно атомарная операция
//            UPDATER.incrementAndGet(this);  // ✅ Атомарно
//
//            // Эквивалентно, но НЕ атомарно:
//            // this.value++;  // ❌ Не атомарно
//        }
//    }
}
