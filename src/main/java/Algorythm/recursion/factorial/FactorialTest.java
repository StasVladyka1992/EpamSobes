package Algorythm.recursion.factorial;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FactorialTest {
	@Test
	public void recursion() {
		Factorial object = new Factorial();

		assertEquals(24, object.factorial(4));
		assertEquals(120, object.factorial(5));
		assertEquals(1, object.factorial(1));
		assertEquals(1, object.factorial(0));
	}
}
