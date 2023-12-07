import java.io.FileNotFoundException;

/**
 * Interface for backend functionality.
 */
public interface BackendInterface {

    // Constructor comment: Expected constructor to accept a GraphADT implementation
    // public IBackend(GraphADT graph) {
      // this.graph = graph; 
    //}


    /**
     * Reads in graph data from file and stores it in a graph data structure.
     * @param filePath the path to file
     * @throws FileNotFoundException if it is the wrong file.
     */
    void readDataFile(String filePath)  throws FileNotFoundException;

    /**
     * Gets the shortest route from a start to a destination airport.
     * @param start three letter code of the starting airport.
     * @param end three letter code of the destination airport.
     * @return an instance of ShortestPath.
     */
    PathInterface getShortestRoute(String start, String end);

    /**
     * Gets stats about the graph dataset.
     * return a String with stats including the number of airports,
     * the number of flights, and the total miles of all edges.
     */
    String getGraphStats();
}
