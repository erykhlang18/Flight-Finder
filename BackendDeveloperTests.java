import org.junit.Test;
import org.junit.jupiter.api.Assertions;
public class BackendDeveloperTests {

    private GraphADT<String, Double> graph;
    private MapADT<String, BaseGraph<String, Double>.Node> map;

    
    void setUp() {
        // Initialize the graph and map before each test
        map = new PlaceholderMap<>();
        graph = new BaseGraph<>(map);
    }

    @Test
    void testInsertNode() {
        // Test inserting a new node
        Assertions.assertTrue(graph.insertNode("A"));
        Assertions.assertEquals(1, graph.getNodeCount());
        Assertions.assertTrue(graph.containsNode("A"));

        // Test inserting a duplicate node
        Assertions.assertFalse(graph.insertNode("A"));
        Assertions.assertEquals(1, graph.getNodeCount());
    }

    @Test
    void testRemoveNode() {
        // Test removing a non-existent node
        Assertions.assertFalse(graph.removeNode("A"));
        Assertions.assertEquals(0, graph.getNodeCount());

        // Test removing an existing node
        graph.insertNode("A");
        Assertions.assertTrue(graph.removeNode("A"));
        Assertions.assertEquals(0, graph.getNodeCount());
        Assertions.assertFalse(graph.containsNode("A"));
    }

    @Test
    void testInsertEdge() {
        // Test inserting a new edge
        graph.insertNode("A");
        graph.insertNode("B");
        Assertions.assertTrue(graph.insertEdge("A", "B", 5.0));
        Assertions.assertEquals(1, graph.getEdgeCount());
        Assertions.assertTrue(graph.containsEdge("A", "B"));
        Assertions.assertEquals(5.0, graph.getEdge("A", "B"));

        // Test inserting an edge with non-existent nodes
        Assertions.assertFalse(graph.insertEdge("C", "D", 3.0));
        Assertions.assertEquals(1, graph.getEdgeCount());
    }

    @Test
    void testRemoveEdge() {
        // Test removing a non-existent edge
        Assertions.assertFalse(graph.removeEdge("A", "B"));

        // Test removing an existing edge
        graph.insertNode("A");
        graph.insertNode("B");
        graph.insertEdge("A", "B", 5.0);
        Assertions.assertTrue(graph.removeEdge("A", "B"));
        Assertions.assertEquals(0, graph.getEdgeCount());
        Assertions.assertFalse(graph.containsEdge("A", "B"));
    }

    @Test
    void testShortestPathData() {
        // Test finding the shortest path between nodes
        graph.insertNode("A");
        graph.insertNode("B");
        graph.insertNode("C");
        graph.insertEdge("A", "B", 2.0);
        graph.insertEdge("B", "C", 3.0);
        graph.insertEdge("A", "C", 5.0);

        Assertions.assertEquals(3, graph.shortestPathData("A", "C").size());
        Assertions.assertEquals("A", graph.shortestPathData("A", "C").get(0));
        Assertions.assertEquals("B", graph.shortestPathData("A", "C").get(1));
        Assertions.assertEquals("C", graph.shortestPathData("A", "C").get(2));
    }
}




