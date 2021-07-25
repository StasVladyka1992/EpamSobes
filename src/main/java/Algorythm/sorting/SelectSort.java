package Algorythm.sorting;

/*
Алгоритмическая сложность -  O(n^2)
The selection sort algorithm sorts an array by repeatedly finding the minimum element (considering ascending order)
from unsorted part and putting it at the beginning. Все делается в одном и том же массиве.
https://www.geeksforgeeks.org/selection-sort/
 */
public class SelectSort {
	public static void main(String[] args) {
		int[] array = {1, 3, 10, 2, 19, 0, 20, 17};

		for (int i = 0; i < array.length - 1; i++) {
			int smallestElementIndex = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[smallestElementIndex]) {
					smallestElementIndex = j;
				}
			}
			int buf = array[i];
			array[i] = array[smallestElementIndex];
			array[smallestElementIndex] = buf;
		}
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

	private int findSmallestIndex(int[] array, int startIndex) {
		int smallest = array[startIndex];
		int smallest_ind = startIndex;
		for (int i = startIndex; i < array.length; ++i) {
			int current = array[i];
			if (current < smallest) {
				smallest_ind = i;
				smallest = array[smallest_ind];
			}
		}
		return smallest_ind;
	}

	public int[] selectSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			int smallest_ind = findSmallestIndex(array, i);
			changeElements(array, i, smallest_ind);
		}
		return array;
	}

	private void changeElements(int[] array, int newPos, int oldPos) {
		int savedItem = array[newPos];
		array[newPos] = array[oldPos];
		array[oldPos] = savedItem;
	}
}
