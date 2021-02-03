package Algorythm.sorting;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class QuickSortTest {
	@Test
	public void test() {
		QuickSort object = new QuickSort();

		assertArrayEquals(new int[]{-5, 1, 3, 6, 6, 9, 18, 32}, object.quickSort(new int[]{1, 18, 6, 32, 6, 9, -5, 3}));
		assertArrayEquals(new int[]{-5, 1}, object.quickSort(new int[]{1, -5}));
		assertArrayEquals(new int[]{-5}, object.quickSort(new int[]{-5}));
	}
}
