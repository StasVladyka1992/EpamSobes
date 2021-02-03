package Algorythm.dynamic_programming.my_solution_bankomat;

public class Banknote {
	private int quantity;
	private int nominal;

	public Banknote() {
	}

	public Banknote(int quantity, int nominal) {
		this.quantity = quantity;
		this.nominal = nominal;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getNominal() {
		return nominal;
	}

	public void setNominal(int nominal) {
		this.nominal = nominal;
	}
}
