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
			System.out.print(item + " ");
		}
		System.out.println("");

		int[] arrayClassic = {20, 1, 3, 10, 2, 19, 0, 17, };
		sort.bubbleSortClassicAsc(arrayClassic);
		for (int item : arrayClassic) {
			System.out.print(item+ " ");
		}
		System.out.println("");

		int[] arrayClassic2 = {1, 3, 10, 2, 19, 0, 17, 20};
		sort.bubbleSortClassicDesc(arrayClassic2);
		for (int item : arrayClassic2) {
			System.out.print(item+ " ");
		}
		System.out.println("");

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

	/*
 	 [], [], [], []
 	 for (i, по всему списку - 1)
		for(j, начальный эл. = i+1)

	 */
	//по возрастанию
	public int[] bubbleSortClassicAsc(int[] ar) {
		for (int i = 0; i < ar.length - 1; i++) {
			for (int j = i; j < ar.length; j++) {
				if (ar[i] > ar[j]) {
					int buf = ar[i];
					ar[i] = ar[j];
					ar[j] = buf;
				}
			}
		}
		return ar;
	}

	//по убывания
	public int[] bubbleSortClassicDesc(int[] ar) {
		for (int i = 0; i < ar.length -1; i++) {
			for (int j = i + 1; j < ar.length; j++) {
				if (ar[j] > ar[i]) {
					int buf = ar[j];
					ar[j] = ar[i];
					ar[i] = buf;
				}
			}
		}
		return ar;
	}
}



