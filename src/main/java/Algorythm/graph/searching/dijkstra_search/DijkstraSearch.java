package Algorythm.graph.searching.dijkstra_search;

import static Algorythm.graph.searching.dijkstra_search.NameEnum.A;
import static Algorythm.graph.searching.dijkstra_search.NameEnum.B;
import static Algorythm.graph.searching.dijkstra_search.NameEnum.BEGIN;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
Алгоритм Дейкстры работает только во взвешенных, ациклических графах с неотрицательными весами
В отличие от поиска в ширину позволяет найти ОПТИМАЛЬНЫЙ путь с наименьшим весом.

Взвешенный граф - это граф с весами, т.е. у ребра которого есть значения.

В случае, если стоимость отрицательная, то используется алгоритм Белманна-Форда
1) Пока остаются необработанные узлы
2) Взять узел ближайший к началу
3) Обновить стоимости его соседей
4) Если стоимости каких-либо соседей были обновлены, обновить и родителей
5) Пометить узел как обработанный
 */
public class DijkstraSearch {
	public static void main(String[] args) {
		DijkstraSearch object = new DijkstraSearch();

		Set<Item> graph = object.createGraph();
		Map<Item, Item> pairParentChild = new HashMap<>();
		Map<Item, Integer> costs = new HashMap<>();
		Item startItem = object.findRootElement(graph);

		object.dijkstraSearch(graph, startItem, pairParentChild, costs);
	}

	public void dijkstraSearch(Set<Item> graph, Item start,
							   Map<Item, Item> childParentMap,
							   Map<Item, Integer> costs) {
		Set<Item> checkedNodes = new HashSet<>();

		Item lowestCostNode = null;

		while (graph.size() > 0) {
			//находим элемент с наименьшей стоимостью. Для первого прохода - это BEGIN, далее ищется
			//из родственников
			if (lowestCostNode == null) {
				lowestCostNode = start;
			} else {
				lowestCostNode = findNextLowestCostNode(lowestCostNode);
			}

			//обновить стоимости всех соседей элемента с наименьшей стоимостью
			if (!checkedNodes.contains(lowestCostNode) && lowestCostNode.getNeighbors() != null) {
				for (Map.Entry<Item, Integer> pair : lowestCostNode.getNeighbors().entrySet()) {
					Item neighbor = pair.getKey();
					//обновляем стоимости
					boolean result = updateCost(neighbor, lowestCostNode, costs);
					//обновляем таблицу родители-дети
					if (result) {
						updateChildParent(lowestCostNode, neighbor, childParentMap);
					}
				}
			}
			graph.remove(lowestCostNode);
			checkedNodes.add(lowestCostNode);
		}
		printResult(childParentMap, costs);
	}

	private void updateChildParent(Item parent, Item child, Map<Item, Item> childParentMap) {
		childParentMap.put(child, parent);
	}

	private boolean updateCost(Item neighbor, Item parent, Map<Item, Integer> costs) {
		Integer newCost = parent.getNeighbors().get(neighbor);
		boolean result = false;
		if (costs.containsKey(neighbor)) {
			Integer currentCost = costs.get(neighbor);
			if (currentCost > newCost) {
				costs.put(neighbor, newCost);
				result = true;
			}
		} else {
			costs.put(neighbor, newCost);
			result = true;
		}
		return result;
	}

	private Item findNextLowestCostNode(Item item) {
		Integer lowestCost = null;
		Item result = null;
		for (Map.Entry<Item, Integer> entry : item.getNeighbors().entrySet()) {
			if (lowestCost == null || lowestCost.compareTo(entry.getValue()) > 0) {
				lowestCost = entry.getValue();
				result = entry.getKey();
			}
		}
		return result;
	}

	public Item findRootElement(Set<Item> graph) {
		return graph.stream().filter(item -> item.getName() == BEGIN).findFirst().orElse(null);
	}

	public Set<Item> createGraph() {
		Item begin = new Item(NameEnum.BEGIN);
		Item a = new Item(A);
		Item b = new Item(B);
		Item end = new Item(NameEnum.END);

		Map<Item, Integer> beginNeighbors = new HashMap<>();
		beginNeighbors.put(a, 6);
		beginNeighbors.put(b, 2);
		begin.setNeighbors(beginNeighbors);

		Map<Item, Integer> aNeighbors = new HashMap<>();
		aNeighbors.put(end, 1);
		a.setNeighbors(aNeighbors);

		Map<Item, Integer> bNeighbors = new HashMap<>();
		bNeighbors.put(a, 3);
		bNeighbors.put(end, 5);
		b.setNeighbors(bNeighbors);

		return new HashSet<>(Arrays.asList(begin, a, b, end));
	}

	private void printResult(Map<Item, Item> childParentMap,
							 Map<Item, Integer> costs) {
		childParentMap.forEach((child, parent) -> {
			System.out.println("Child: " + child.getName() + " Parent: " + parent.getName());
		});

		costs.forEach((node, cost) -> {
			System.out.println("Node: " + node.getName() + " Cost: " + cost);
		});
	}
}

