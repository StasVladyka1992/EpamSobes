package Algorythm.recursion.key_searching;

import java.util.List;

public class Box {
	private List<Box> boxes;
	private boolean key;
	private int boxId;

	public Box(List<Box> boxes, boolean key, int boxId) {
		this.boxes = boxes;
		this.key = key;
		this.boxId = boxId;
	}

	public Box() {
	}

	public int getBoxId() {
		return boxId;
	}

	public void setBoxId(int boxId) {
		this.boxId = boxId;
	}

	public List<Box> getBoxes() {
		return boxes;
	}

	public void setBoxes(List<Box> boxes) {
		this.boxes = boxes;
	}

	public boolean isKey() {
		return key;
	}

	public void setKey(boolean key) {
		this.key = key;
	}
}
