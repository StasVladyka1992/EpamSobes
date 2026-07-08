package concurrency.thread.problem;

public class Theory {
	public  final  Object object = new Object();

//	Цикл статей про многопоточку -https://javarush.ru/groups/posts/2048-threadom-java-ne-isportishjh--chastjh-ii---sinkhronizacija
//	Использование jvisual VM для мониторинга dead lock
//	https://javarush.ru/groups/posts/2060-threadom-java-ne-isportishjh--chastjh-iii---vzaimodeystvie

	// TODO visibility
	// поток не видит изменения, сделанные другим.
	// TODO SOLUTION
	// Ключевое слово volatile гарантирует, что чтения и записи переменной происходят напрямую из основной памяти,
	// обеспечивая видимость для всех потоков. Аналогичного эффекта можно добиться с помощью synchronized или Lock

	// TODO deadlock
	// взаимная блокировка намертво.
	// TODO SOLUTION
	// Фиксированный порядок захвата ресурсов (всегда захватывать A, потом B).
	// Использование tryLock() с таймаутом.
	// Избегать вложенных блокировок, где это возможно.

	// TODO livelock
	// потоки активны, но не двигаются вперёд.
	// https://javarush.ru/groups/posts/2060-threadom-java-ne-isportishjh--chastjh-iii---vzaimodeystvie
	// TODO SOLUTION
	// Вносить случайную задержку перед повторной попыткой.
	// Использовать алгоритмы с экспоненциальной отсрочкой.
	// Пересмотреть логику взаимодействия потоков (например, использовать приоритеты).

	// TODO thread starvation
	// низкоприоритетный поток не получает ресурс.
	// https://javarush.ru/groups/posts/2060-threadom-java-ne-isportishjh--chastjh-iii---vzaimodeystvie
	// TODO SOLUTION
	// Использование справедливых (fair) блокировок (new ReentrantLock(true)), которые передают доступ ожидающим потокам в порядке очереди.
	// Избегать чрезмерной разницы в приоритетах потоков.
	// Использовать Thread.yield() или таймауты на ожидание.

	// TODO reordering
	// поток видит не тот порядок инструкций, который ожидал.
	// TODO SOLUTION
	//volatile, synchronized, Lock и final поля в конструкторе вводят барьеры памяти, которые запрещают опасное переупорядочивание.

	// TODO race condition
	// результат зависит от "гонки" между потоками.
	// TODO SOLUTION
	// Атомарные операции (AtomicInteger, synchronized, Lock), обеспечивающие неделимость критической секции.
	// https://stackoverflow.com/questions/34510/what-is-a-race-condition

}
