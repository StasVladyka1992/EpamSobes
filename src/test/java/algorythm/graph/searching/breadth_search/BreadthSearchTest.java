package algorythm.graph.searching.breadth_search;


import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BreadthSearchTest {

    @Test
    public void widthSearch() {
        BreadthSearch object = new BreadthSearch();
        Map<Person, List<Person>> graph = object.createGraph();

        Person first = new Person("Stas", false);
        assertEquals(new Person("Anuj", true), object.widthSearch(graph, first));
    }
}
