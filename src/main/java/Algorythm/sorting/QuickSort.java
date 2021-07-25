
package Algorythm.sorting;

import java.util.Arrays;

/*
Быстрая сортировка основана на страегии "разделяй и властвуй".
Последовательность шагов:
0) Описываем базовый и рекурсивный случай.
1) Выбираем опорный элемент.
2) Создаем два новых массива, в один и которых складываются элементы МЕНЬШЕ опорного, а в другой - БОЛЬШЕ
3) Сортируем левый и правый массив с помощью рекурсии, т.е. повторяем шаги с 1 по 3.
4) Новый массив = отсортированная левая часть + опорный + отсортированная правая часть
Aлгоритмическая сложность: средний случа он же лучший -  O(n) *O(log n) = O(n*log n)
						   худший случай - O(n^2)
См. грокаем алгоритмы

 */
public class QuickSort {
	public int[] quickSort(int[] array) {
		//базовый случай
		if (array.length == 0 || array.length == 1) {
			return array;
		}

		int bearingIndex = (int) (Math.random() * array.length);

		//не самое удачное решение, но с другой стороны, мы не знаем изначальный размер каждого массива.
		//можно было бы использовать коллекции, но они не работают с примитивами. Использование коллекции
		//и foreach позволило бы сократить количество проходов по массиву с 3 до 1 раза.
		int[] smallerNumbers = getSmallerNumbers(array, array[bearingIndex]);
		int[] biggerNumbers = getBiggerNumbers(array, array[bearingIndex]);
		//in case if bearing numbers repeat
		int[] bearingNumbers = Arrays.stream(array).filter(i -> i == array[bearingIndex]).toArray();

		//рекурсивный
		return joinArrays(quickSort(smallerNumbers), bearingNumbers, quickSort(biggerNumbers));
	}

	private int[] getSmallerNumbers(int[] array, int bearingElement) {
		return Arrays.stream(array).filter(item -> item < bearingElement).toArray();
	}

	private int[] getBiggerNumbers(int[] array, int bearingElement) {
		return Arrays.stream(array).filter(i -> i > bearingElement).toArray();
	}

	private int[] joinArrays(int[] smallerPart, int[] bearingElem, int[] biggerPart) {
		int[] result = new int[smallerPart.length + bearingElem.length + biggerPart.length];
		System.arraycopy(smallerPart, 0, result, 0, smallerPart.length);
		System.arraycopy(bearingElem, 0, result, smallerPart.length, bearingElem.length);
		System.arraycopy(biggerPart, 0, result, smallerPart.length + bearingElem.length, biggerPart.length);
		return result;
	}

	public static void main(String[] args) {
		QuickSort object = new QuickSort();
		int[] ar = {1, 18, 6, 32, 6, 9, -5, 3};
		for (int item : object.quickSort(ar)) {
			System.out.println(item);
		}
	}
}


