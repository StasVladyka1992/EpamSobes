package Algorythm.searching;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class BinarySearchTest {
	private static BinarySearch object;

	@BeforeClass
	public static void before() {
		object = new BinarySearch();
	}

	@Test
	public void binarySearch() {
		int[] ar = {1, 5, 6, 9, 12, 19, 35};
		assertEquals(0, object.binarySearch(ar, 1));
		assertEquals(1, object.binarySearch(ar, 5));
		assertEquals(2, object.binarySearch(ar, 6));
		assertEquals(3, object.binarySearch(ar, 9));
		assertEquals(4, object.binarySearch(ar, 12));
		assertEquals(5, object.binarySearch(ar, 19));
		assertEquals(6, object.binarySearch(ar, 35));
		assertEquals(-1, object.binarySearch(ar, 3));
	}
}