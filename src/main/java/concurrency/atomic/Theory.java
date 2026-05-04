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

//TODO AtomicLongFieldUpdater
//TODO AtomicIntegerFieldUpdater
//TODO AtomicReferenceFieldUpdater
}
