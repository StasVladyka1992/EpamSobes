package Thread.key_words_and_commands;

public class YieldExample {
	//yield - сообщает, что нить досрочно завершила работу в пределах выделенного ей кванта времени. гарантирует также,
	//что следующий квант будет полным, а не кусочком.
	public static void main(String[] args) {
		Thread thread = new Thread(Thread::yield);
		thread.start();
		Object object = new Object();
		String string = new String();
	}
}
