package Algorythm.graph.searching.breadth_search;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import Algorythm.graph.searching.breadth_search.BreadthSearch;
import Algorythm.graph.searching.breadth_search.Person;

public class BreadthSearchTest {

	@Test
	public void widthSearch() {
		BreadthSearch object = new BreadthSearch();
		Map<Person, List<Person>> graph = object.createGraph();

		Person first = new Person("Stas", false);
		assertEquals(new Person("Anuj", true), object.widthSearch(graph,first));
	}
}