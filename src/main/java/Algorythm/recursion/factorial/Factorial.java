package Algorythm.recursion.factorial;

/*
Лучше всего пользоваться определением базового и рекурсивного случая.
базовый: number = 1 или 0
рекурсивный = все остальное.
 */
public class Factorial {

	public int factorial(int number) {
		if (number == 0 || number == 1) return 1;
		else {
			return number * factorial(number - 1);
		}
	}


}
