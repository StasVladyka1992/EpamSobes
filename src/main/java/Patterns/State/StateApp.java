package Patterns.State;
/**
 * Опять же очень простой шаблон. Этот паттерн состоит из двух объектов Context и State. State - это некоторое состояние
 * которое будет переключать СAM контекст(изменять состояния контекста могут внешние классы). Короче, контекст меняет свое поведение в зависимости
 * от своего состояния.
 * Пример: радио и радиостанции
 */
public class StateApp {
	public static void main(String[] args) {
		Radio radio = new Radio();
		radio.nextStation("FM");
		radio.nextStation("Relax");
	}
}

class Radio{
	Station station;

	public Radio() {
	}

	public Radio(Station station) {
		this.station = station;
	}

	public Station getStation() {
		return station;
	}

	public void setStation(Station station) {
		this.station = station;
	}

	void nextStation(String stationName){
		if(stationName.equals("FM")){
			station = new FMStation();
			station.play();
		} else {
			station = new RelaxStation();
			station.play();
		}
	}
}

interface Station{
	void play();
}

class RelaxStation implements  Station{
	@Override
	public void play() {
		System.out.println("Radio relax");
	}
}

class FMStation implements Station{
	@Override
	public void play() {
		System.out.println("Radio FM");
	}
}

