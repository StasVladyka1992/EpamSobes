package Patterns.Facade;

/**
 * Фасад очень похож на Delegate, но основное отличие в том,
 * что фасад является как бы оберткой над НЕСКОЛЬКИМИ объектами одновременно,
 * устраняя необходимость в ручную вызывать каждый из них
 *
 */
public class FacadeApp {
	public static void main(String[] args) {
		/*
		Без применения объекта фасада для записи данных на диск приходится создавать объект каждого
		класса и выполнять у него определенные действия
		 */
		PowerButton powerButton = new PowerButton();
		powerButton.turnOn();

		DvdRom dvdRom = new DvdRom();
		dvdRom.openRom();
		dvdRom.closeRom();

		Hdd hdd = new Hdd();
		hdd.recordToHdd();
		/*****************/

		Computer computer = new Computer();
		computer.copyFileFromDisk();

	}
}

/**
 * Computer - это объект фасад
 */
class Computer{
	Hdd hdd = new Hdd();
	DvdRom dvdRom = new DvdRom();
	PowerButton button = new PowerButton();

	public void copyFileFromDisk(){
		button.turnOn();
		dvdRom.openRom();
		dvdRom.closeRom();
		hdd.recordToHdd();
	}
}


class DvdRom{
	public void openRom(){
		System.out.println("DVD ROM открыт");
	}
	public void closeRom(){
		System.out.println("DVD ROM закрыт");
	}
}
class PowerButton{
	public void turnOn(){
		System.out.println("Копьютер включен");
	}
	public void turnOff() {
		System.out.println("Компьютер выключен");
	}
}
class Hdd {
	public void recordToHdd(){
		System.out.println("Записать на жесткий диск");
	}
}

