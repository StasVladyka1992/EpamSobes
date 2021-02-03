package Exception;

import java.io.FileNotFoundException;

public class ChildWithException extends ParentWIthException {


	//Двигаться вниз по иерархии наследования можно. А вверх нельзя
	@Override
	public void methodWithException() throws FileNotFoundException {
	}
}
