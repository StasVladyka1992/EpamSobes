package patterns.adapter;

public class AlternativeCurrencyDevice  {
	AlternativeCurrencySocketInterface alternativeCurrencySocketInterface = new AlternativeCurrencyAdapter();

	public void turnOn(){
		alternativeCurrencySocketInterface.giveAlternativeCurrent();
	}
}
