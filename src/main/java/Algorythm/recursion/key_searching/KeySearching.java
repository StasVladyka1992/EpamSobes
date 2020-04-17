package Algorythm.recursion.key_searching;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.List;

/*

 */
public class KeySearching {
	public static void main(String[] args) {
		KeySearching object = new KeySearching();
		List<Box> boxes = object.createBoxes();
		object.search(boxes);
	}

	public void search(List<Box> boxes) {
		for (Box box : boxes) {
			checkBox(box);
		}
	}

	private void checkBox(Box box) {
		if (box.isKey()) {
			System.out.println("Ключ найден в коробке - " + box.getBoxId());
		} else if (box.getBoxes() != null) {
			for (Box item : box.getBoxes()) {
				checkBox(item);
			}
		}
	}

	public List<Box> createBoxes() {
		List<Box> boxes = new ArrayList<>();

		Box level3First = new Box(null, false, 1);
		Box level3Second = new Box(null, false, 2);
		Box level3Third = new Box(null, false, 3);
		Box level3Fourth = new Box(null, false, 4);

		Box level2First = new Box(null, false, 5);
		List<Box> forLevel2Second = asList(level3First, level3Second, level3Third);
		Box level2Second = new Box(forLevel2Second, false, 6);
		Box level2Third = new Box(asList(level3Fourth), false, 7);

		Box level1First = new Box(null, false, 8);
		Box level1Second = new Box(asList(level2First, level2Third), true, 9);
		Box level1Third = new Box(asList(level2Second), false, 10);

		return asList(level1First, level1Second, level1Third);
	}
}
