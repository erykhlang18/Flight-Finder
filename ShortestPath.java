import java.util.List;

/**
 * This interface is designed to get the results of a shortest path.
 */
public interface ShortestPath {

    /**
     * Returns the route as a list of airports along the shortest path.
     * @return a list of airports on the shortest path.
     */
    List<String> getRoute();

    /**
     * Returns a list of the miles to travel for each segment of the route.
     * @return a list of integers where each integer represents the miles for a segment.
     */
    List<Integer> getMilesSegment();

    /**
     * Returns the total miles for the entire route.
     * @return an integer representing total miles on route.
     */
    int getTotalMiles();
}
