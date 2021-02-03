package Patterns.Adapter;

public class AlternativeCurrencyDevice  {
	AlternativeCurrencySocketInterface alternativeCurrencySocketInterface = new AlternativeCurrencyAdapter();

	public void turnOn(){
		alternativeCurrencySocketInterface.giveAlternativeCurrent();
	}
}
