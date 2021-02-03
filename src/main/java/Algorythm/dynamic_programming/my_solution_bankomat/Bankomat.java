package Algorythm.dynamic_programming.my_solution_bankomat;

import java.util.ArrayList;
import java.util.List;

public class Bankomat {
	//номинал банкноты == стоимость драгоценности
	//сумма банкнот == общий вес драгоценностей
	//M - масса драгоценности
	//P - стоимость

	public static void main(String[] args) {
		//количество видов банкнот
		Bankomat bankomat = new Bankomat();
		Banknote[] banknotes = bankomat.getBanknotes();

		int n = bankomat.getTotalNumberOfBanknotes(banknotes) - 1;
		int askedSum = 10;
		int[][] matrix = bankomat.createMatrix(bankomat.getTotalNumberOfBanknotes(banknotes), askedSum);

		int[][] filledMatrix = bankomat.fillMatrix(banknotes, askedSum, matrix);
		bankomat.printNominals(askedSum, matrix);
	}

	public int[][] fillMatrix(Banknote[] banknotes, int askedSum, int[][] matrix) {
		int n = getTotalNumberOfBanknotes(banknotes) - 1;

		//проходим по строкам матрицы (количество доступных купюр разных номиналов)
		int previousNominalCounter = -1;
		for (int i = 1; i < n + 1; i++) {
			if (i >= banknotes.length) {
				for (int j = 0; j < askedSum + 1; j++) {
					if (j >= banknotes[previousNominalCounter].getNominal()) {
						int oldValue = matrix[i - 1][j];
						int newValue = matrix[i - 1][j - banknotes[previousNominalCounter].getNominal()] + banknotes[previousNominalCounter].getNominal();
						matrix[i][j] = max(oldValue, newValue);
					} else {
						matrix[i][j] = matrix[i - 1][j];
					}
				}

			} else {
				//элементы столбца - различные суммы рюкзака
				for (int j = 0; j < askedSum + 1; j++) {
					if (j >= banknotes[i].getNominal()) {
						int oldValue = matrix[i - 1][j];
						int newValue = matrix[i - 1][j - banknotes[i].getNominal()] + banknotes[i].getNominal();
						matrix[i][j] = max(oldValue, newValue);
					} else {
						matrix[i][j] = matrix[i - 1][j];
					}
				}
				previousNominalCounter = banknotes[i].getNominal();
			}
		}

		return matrix;
	}

	public List<Integer> printNominals(int askedSum, int[][] matrix) {
		List<Integer> answer = new ArrayList<>();
		int tmp = askedSum;
		for (int i = matrix.length - 1; i > 0; i--) {
			if (matrix[i][tmp] != matrix[i - 1][tmp]) {
				int addedValue = matrix[i][tmp] - matrix[i - 1][tmp];
				answer.add(addedValue);
				tmp -= addedValue;
			}
		}

		for (Integer b : answer) {
			System.out.println(b);
		}
		return answer;
	}



	public Banknote[] getBanknotes() {
		Banknote zero = new Banknote(0, 0);
		Banknote one = new Banknote(1, 1);
		Banknote two = new Banknote(2, 2);
		Banknote three = new Banknote(1, 3);
//		Banknote six = new Banknote(1, 4);
//		Banknote seven = new Banknote(1, 5);

		return new Banknote[]{zero, three, two, one};
	}




	public int max(int oldValue, int newValue) {
		if (oldValue >= newValue) {
			return oldValue;
		} else {
			return newValue;
		}
	}

	public int[][] createMatrix(int banknotesNumber, int askedSum) {
		//столбец - сумма
		//строка - сумма, полученнная из доступных купюр
		int[][] ar = new int[banknotesNumber][];
		for (int i = 0; i < ar.length; i++) {
			int[] innerAr = new int[askedSum + 1];
			ar[i] = innerAr;
		}
		return ar;
	}

	public int getTotalNumberOfBanknotes(Banknote[] banknotes) {
		int totalNumber = 1;
		for (int i = 0; i < banknotes.length; i++) {
			totalNumber += banknotes[i].getQuantity();
		}
		return totalNumber;
	}
}