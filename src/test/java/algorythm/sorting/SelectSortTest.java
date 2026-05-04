package algorythm.sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SelectSortTest {

	@Test
	public void selectSortTest() {
		SelectSort object = new SelectSort();

		assertArrayEquals(new int[]{0, 1, 3, 5, 6, 8, 9}, object.selectSort(new int[]{1, 8, 5, 6, 9, 3, 0}));
	}
}
