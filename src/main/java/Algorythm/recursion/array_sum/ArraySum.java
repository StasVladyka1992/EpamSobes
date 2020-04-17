package Algorythm.recursion.array_sum;


public class ArraySum {
	public static void main(String[] args) {
		ArraySum object = new ArraySum();
		System.out.println(object.sum(new int[]{1, 24, 0, -7}));
	}

	public int sum(int [] array){
		int sum = 0;
		if (array.length == 0) return sum;
		if (array.length == 1) return sum + array[0];
		return sum += array[0] + sum (split(array));
	}

	int[] split(int[] array) {
		int[] rightPart = new int[array.length - 1];
		System.arraycopy(array, 1, rightPart, 0, array.length - 1);
		return rightPart;
	}
}
