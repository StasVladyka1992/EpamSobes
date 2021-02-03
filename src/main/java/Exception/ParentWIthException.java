package Exception;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ParentWIthException  {
	public ParentWIthException() {
	}

	public void methodWithException() throws IOException {
		boolean marker = false;
		if(marker){
			throw new FileNotFoundException("Parent exception");
		}
		else {
			System.out.println("Все ок");
		}
	}
}
