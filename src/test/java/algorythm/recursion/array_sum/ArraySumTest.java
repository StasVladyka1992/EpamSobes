package algorythm.recursion.array_sum;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArraySumTest {

    @Test
    public void sum() {
        ArraySum object = new ArraySum();
        assertEquals(18, object.sum(new int[]{1, 24, 0, -7}));
        assertEquals(7, object.sum(new int[]{7}));
        assertEquals(242, object.sum(new int[]{100, -5, 35, 65, 47}));
        assertEquals(0, object.sum(new int[]{}));
    }
}
