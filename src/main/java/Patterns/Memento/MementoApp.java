package Patterns.Memento;

/**
 * Суть паттерна в том, что у нас есть Originator - источник состояния, Memento - хранитель и Caretaker - охранитель
 * Собсвтенно Originator создает объект состояния, который может быть использован для восстановления состояния Originator
 *
 */
public class MementoApp {
	public static void main(String[] args) {
		Game game = new Game();
		game.set("18:30", 2);

		File file = new File();
		file.setSave(game.createMomento());

		game.loadMomento(file.getSave());
	}
}

class Game{
	private int time;
	private String level;

	public void set(String level, int time){
		this.time = time;
		this.level = level;
	}

	public Save  createMomento() {
		return new Save(level, time);
	}


	public void loadMomento(Save momento) {
		time = momento.getTime();
		level = momento.getLevel();
	}
}


class Save {
	private final String level;
	private final int time;

	public Save(String level, int time) {
		this.level = level;
		this.time = time;
	}
	public String getLevel() {
		return level;
	}

	public int getTime() {
		return time;
	}
}
class  File {
	private Save save;

	public Save getSave() {
		return save;
	}

	public void setSave(Save save) {
		this.save = save;
	}
}