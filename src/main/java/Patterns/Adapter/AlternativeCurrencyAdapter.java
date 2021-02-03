package Patterns.Adapter;

public class AlternativeCurrencyAdapter implements AlternativeCurrencySocketInterface, DirectCurrencySocketInterface {
	@Override
	public void giveAlternativeCurrent() {
		giveDirectCurrent();
		System.out.println("DC was changed to AC");
	}

	@Override
	public void giveDirectCurrent() {
		System.out.println("DC was accepted");
	}
}
