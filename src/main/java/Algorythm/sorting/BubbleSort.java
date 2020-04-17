package Algorythm.sorting;

/*
Сложность n^2
Поочередно сравниваются соседние элементы. Если левый больше правого, то элементы меняются местами. Сортировка заканчивается
тогда, когда за проход не было ни одной замены
*/
public class BubbleSort {
	public static void main(String[] args) {
		BubbleSort sort = new BubbleSort();
		int[] array = {1, 3, 10, 2, 19, 0, 17, 20};
		sort.bubbleSort(array);
		for (int item : array) {
			System.out.println(item);
		}
	}

	public int[] bubbleSort(int[] array) {
		boolean isSorted = false;
		while (!isSorted) {
			isSorted = true;
			for (int i = 0; i < array.length - 1; i++) {
				int left = array[i];
				int right = array[i + 1];
				if (left > right) {
					replace(array, i, i + 1);
					isSorted = false;
				}
			}
		}
		return array;
	}

	private void replace(int[] ar, int leftIndex, int rightIndex) {
		int buf = ar[leftIndex];
		ar[leftIndex] = ar[rightIndex];
		ar[rightIndex] = buf;
	}
}
