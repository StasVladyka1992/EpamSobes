package Algorythm.sorting;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class BubbleSortTest {
	@Test
	public void bubbleSort() {
		BubbleSort object = new BubbleSort();
		assertArrayEquals(object.bubbleSort(new int[]{1, 3, 10, 2, 19, 0, 17, 20}), new int[]{0, 1, 2, 3, 10, 17, 19, 20});
	}
}
