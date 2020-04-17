package Algorythm.graph.searching.dijkstra_search;

import java.util.Map;

public class Item {
	private NameEnum name;
	private boolean handled;
	private Map<Item, Integer> neighbors;

	public Item(NameEnum name, boolean handled) {
		this.name = name;
		this.handled = handled;
	}

	public Item() {
	}

	public Item(NameEnum name) {
		this.name = name;
	}

	public NameEnum getName() {
		return name;
	}

	public void setName(NameEnum name) {
		this.name = name;
	}

	public boolean isHandled() {
		return handled;
	}

	public void setHandled(boolean handled) {
		this.handled = handled;
	}

	public Map<Item, Integer> getNeighbors() {
		return neighbors;
	}

	public void setNeighbors(Map<Item, Integer> neighbors) {
		this.neighbors = neighbors;
	}
}
