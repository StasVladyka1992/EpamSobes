package Algorythm.sorting;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class SelectSortTest {

	@Test
	public void selectSortTest() {
		SelectSort object = new SelectSort();

		assertArrayEquals(object.selectSort(new int[]{1, 8, 5, 6, 9, 3, 0}), new int[]{0, 1, 3, 5, 6, 8, 9});
	}
}