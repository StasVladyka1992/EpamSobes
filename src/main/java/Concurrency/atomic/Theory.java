package Concurrency.atomic;

public class Theory {
//	Теория по атомикам:
//	http://java-online.ru/concurrent-atomic.xhtml
//	https://www.baeldung.com/java-atomic-variables

//TODO AtomicBoolean
//TODO AtomicInteger
//TODO AtomicLong
//TODO AtomicReference

//TODO AtomicIntegerArray - Обычный массив int[] или Object[] не потокобезопасен.

//Даже изменение одного элемента array[i] = x не гарантирует, что другой поток увидит изменение.
//volatile здесь не поможет для элементов массива. AtomicIntegerArray дает гарантию на атомарность с одним элементом массива, НО НЕ ВСЕХ

//TODO AtomicLongArray

//TODO AtomicReferenceArray

//TODO AtomicIntegerFieldUpdater
//TODO AtomicLongFieldUpdater
//TODO AtomicReferenceFieldUpdater

//TODO AtomicStampedReference
//TODO AtomicMarkableReference


//ABA-проблема: Поток может не заметить, что значение менялось A -> B -> A
}
