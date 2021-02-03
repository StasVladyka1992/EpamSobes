package Patterns.Delegate;

/**
 * Паттерн Delegate самый простой из всех возможных. Вместо того, чтобы выполнять работу
 * самому, мы просто делегируем ее другому объекту
 *
 */
public class EnergyExtractor {
	private Extractor extractor;

	public Extractor getExtractor() {
		return extractor;
	}

	public void setExtractor(Extractor extractor) {
		this.extractor = extractor;
	}

	public static void main(String[] args) {
		EnergyExtractor energyExtractor = new EnergyExtractor();
		energyExtractor.setExtractor(new SolarEnergyExtractor());
		energyExtractor.extractEnergy();;
		energyExtractor.setExtractor(new WindEnergyExtractor());
		energyExtractor.extractEnergy();;
	}

	private   void extractEnergy(){
		extractor.extractEnergy();
	}

}

interface Extractor{
	void extractEnergy();
}

class SolarEnergyExtractor implements Extractor{
	public  void extractEnergy(){
		System.out.println("Солнечная энергия переведена в работу");
	}
}
class WindEnergyExtractor implements Extractor{
	public  void extractEnergy(){
		System.out.println("Ветренная энергия переведена в работу");
	}
}