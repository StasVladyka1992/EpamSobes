public class InstanceOf {

	public static void main(String[] args) {
		Integer integer = new Integer(2);

		//Проверяет принадлежит ли текущий объект классу вверх по иерархии наследования/либо интерфейсу, указанному справа.
		System.out.println(integer instanceof Number);
		//можно использовать getClass(), чтобы избавиться от родителей, а сравнивать чисто объекты класса.
	}
}
