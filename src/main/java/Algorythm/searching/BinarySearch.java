package Algorythm.searching;

/*
Бинарный поиск работает за O(log n).
Массив должен быть отсортирован.
Суть алгоритма:
1) Записываем индексы наименьшего и наибольшего элемента
2) Далее проверяем, где находится элемент, который ищмем: слева, справа или равен мидлу.
3) Если не равен мидлу, смещаем high или low и снова бинарный поиск.
 */
public class BinarySearch {

	int binarySearch(int[] array, int number) {
		int high = array.length - 1;
		int low = 0;
		int mid = -1;
		int operationCounter = 0;

		while (low <= high) {
			mid = (high + low) / 2;
			operationCounter++;

			if (array[mid] == number) {
				break; }
			if (number < array[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
			if(low > high) return -1;
		}

		System.out.println("Operations count: " + operationCounter);
		return mid;
	}
}
