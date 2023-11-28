// --== CS400 File Header Information ==--
// Name: <Eric Liang>
// Email: <eliang7@wisc.edu>
// Group and Team: <G26>
// Group TA: <Alexander Peseckis>
// Lecturer: <Florian Heimerl>
// Notes to Grader: <My test are located in the p23 
//submission checker instead of this class>

import java.util.PriorityQueue;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * This class extends the BaseGraph data structure with additional methods for
 * computing the total cost and list of node data along the shortest path
 * connecting a provided starting to ending nodes. This class makes use of
 * Dijkstra's shortest path algorithm.
 */
public class DijkstraGraph<NodeType, EdgeType extends Number>
        extends BaseGraph<NodeType, EdgeType>
        implements GraphADT<NodeType, EdgeType> {

    /**
     * While searching for the shortest path between two nodes, a SearchNode
     * contains data about one specific path between the start node and another
     * node in the graph. The final node in this path is stored in its node
     * field. The total cost of this path is stored in its cost field. And the
     * predecessor SearchNode within this path is referened by the predecessor
     * field (this field is null within the SearchNode containing the starting
     * node in its node field).
     *
     * SearchNodes are Comparable and are sorted by cost so that the lowest cost
     * SearchNode has the highest priority within a java.util.PriorityQueue.
     */
    protected class SearchNode implements Comparable<SearchNode> {
        public Node node;
        public double cost;
        public SearchNode predecessor;

        public SearchNode(Node node, double cost, SearchNode predecessor) {
            this.node = node;
            this.cost = cost;
            this.predecessor = predecessor;
        }

        public int compareTo(SearchNode other) {
            if (cost > other.cost)
                return +1;
            if (cost < other.cost)
                return -1;
            return 0;
        }
    }

    /**
     * Constructor that sets the map that the graph uses.
     * @param map the map that the graph uses to map a data object to the node
     *        object it is stored in
     */
    public DijkstraGraph(MapADT<NodeType, Node> map) {
        super(map);
    }

    /**
     * This helper method creates a network of SearchNodes while computing the
     * shortest path between the provided start and end locations. The
     * SearchNode that is returned by this method is represents the end of the
     * shortest path that is found: it's cost is the cost of that shortest path,
     * and the nodes linked together through predecessor references represent
     * all of the nodes along that shortest path (ordered from end to start).
     *
     * @param start the data item in the starting node for the path
     * @param end   the data item in the destination node for the path
     * @return SearchNode for the final end node within the shortest path
     * @throws NoSuchElementException when no path from start to end is found
     *                                or when either start or end data do not
     *                                correspond to a graph node
     */
    protected SearchNode computeShortestPath(NodeType start, NodeType end) {
        // Create a priority queue to store SearchNodes
        PriorityQueue<SearchNode> queue = new PriorityQueue<>();
        // Create a map to track visited nodes and their shortest distances
        MapADT<NodeType, SearchNode> visitedNodes = new PlaceholderMap<>();

        // Find the start and end nodes in the graph
        Node startNode = nodes.get(start);
        Node endNode = nodes.get(end);

        // Check if start and end nodes are not null
        if (startNode == null || endNode == null) {
            throw new NoSuchElementException("Start or end data do not correspond to a graph node");
        
        }


         // Initialize the priority queue with the start node
         queue.add(new SearchNode(startNode, 0, null));

         while (!queue.isEmpty()) {
             // Get the node with the shortest known distance
             SearchNode current = queue.poll();
 
             // Check if the current node is the destination
             if (current.node == endNode) {
                 return current; // Found the shortest path
             }
 
             // Check if the current node has already been visited
             if (!visitedNodes.containsKey(current.node.data)) {
                 // Mark the current node as visited
                 visitedNodes.put(current.node.data, current);
 
                 // Explore neighbors and update their distances
                 for (Edge edge : current.node.edgesLeaving) {
                     Node neighbor = edge.successor;
                     double newCost = current.cost + edge.data.doubleValue();
 
                     // Add the neighbor to the priority queue
                     queue.add(new SearchNode(neighbor, newCost, current));
                 }
             }
         }
 
         // No path found
         throw new NoSuchElementException("No path from start to end is found");
     } 
    

    /**
     * Returns the list of data values from nodes along the shortest path
     * from the node with the provided start value through the node with the
     * provided end value. This list of data values starts with the start
     * value, ends with the end value, and contains intermediary values in the
     * order they are encountered while traversing this shorteset path. This
     * method uses Dijkstra's shortest path algorithm to find this solution.
     *
     * @param start the data item in the starting node for the path
     * @param end   the data item in the destination node for the path
     * @return list of data item from node along this shortest path
     */
    public List<NodeType> shortestPathData(NodeType start, NodeType end) {
       // Use the computeShortestPath method to get the SearchNode representing the end node
       SearchNode endSearchNode = computeShortestPath(start, end);

       // Reconstruct the path from end to start
       List<NodeType> path = new LinkedList<>();
       SearchNode current = endSearchNode;
       while (current != null) {
           path.add(0, current.node.data); // Add to the beginning of the list to maintain order
           current = current.predecessor;
       }

       return path;
        }

    /**
     * Returns the cost of the path (sum over edge weights) of the shortest
     * path freom the node containing the start data to the node containing the
     * end data. This method uses Dijkstra's shortest path algorithm to find
     * this solution.
     *
     * @param start the data item in the starting node for the path
     * @param end   the data item in the destination node for the path
     * @return the cost of the shortest path between these nodes
     */
    public double shortestPathCost(NodeType start, NodeType end) {
        // Use the computeShortestPath method to get the SearchNode representing the end node
        SearchNode endSearchNode = computeShortestPath(start, end);

        // Return the cost of the shortest path
        return endSearchNode.cost;
    }
    // Tests in P23 submissionChcker
    
}
