package Algorythm.dynamic_programming.fibonacci;

import java.util.Date;

public class Fibonacci {
	public static int[] cache;

	//задача - найти n-е число в последовательности фиббоначи
	public static void main(String[] args) {
		Fibonacci fibonacci = new Fibonacci();

		int firstNumbers = 12;
		cache = new int[firstNumbers];

		long startTime = new Date().getTime();
		System.out.print(fibonacci.getFibonacciSum(firstNumbers));
		long finish = new Date().getTime();
		System.out.println(" Время:" + (finish - startTime));
	}

	public int getFibonacciSum(int number) {
		if (number <= 1) {
			return number;
		}
		if (cache[number - 1] != 0) {
			return cache[number - 1];
		}

		int result = getFibonacciSum(number - 1) + getFibonacciSum((number - 2));
		cache[number - 1] = result;
		return result;
	}
}
