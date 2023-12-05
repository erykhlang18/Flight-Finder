// --== CS400 File Header Information ==--
// Name: <Eric Liang>
// Email: <eliang7@wisc.edu>
// Group and Team: <G26>
// Group TA: <Alexander Peseckis>
// Lecturer: <Florian Heimerl>
// Notes to Grader: 

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * this class is responsible for implementing the backendinterface and its various methods and commands
 */
public class backend implements BackendInterface {

    private GraphADT graph;

    public backend(GraphADT graph) {
    this.graph = graph; 
    }

    /**
     * this class reads in a file that the user can choose to send in
     * throws a FileNOtFoundException if the file does not exist. 
     */
    @Override
    public void readDataFile(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
        String line = scanner.nextLine().trim();

        // Check if the line represents an edge
        if (line.contains("--") && line.contains("[miles=")) {
            // Extract information from the line
            String[] parts = line.split("--|\\[miles=|\\]");
            String airport1 = parts[0].replaceAll("\"", "").trim();
            String airport2 = parts[1].replaceAll("\"", "").trim();
            int miles = Integer.parseInt(parts[2].trim());
            graph.insertNode(airport1);
            graph.insertNode(airport2);
            graph.insertEdge(airport1,airport2,miles);
            // Insert the information into the DijkstraGraph
            
        }
      }

        // Close the scanner
        scanner.close();
    }

    /**
     * this class gets the shortest route, its data, its path and the miles per each segment. 
     * 
     */
    @Override
    public PathClass getShortestRoute(String start, String end) {

        List<String> data = graph.shortestPathData(start, end);
        double cost = graph.shortestPathCost(start, end);
        List<Double> milesSegment = graph.milesPerSegment(start,end);
        return new PathClass(data,milesSegment,cost);
    }

    /**
     * this method retrieves the total count of airports, segments and miles throughout each graph/file
     */
    @Override
    public String getGraphStats() {
        int nodes = graph.getNodeCount();
        int edges = graph.getEdgeCount();

        double totalMiles = calculateTotalMiles();
        String answer = "total airports " + nodes + "\ntotal connections " + edges + "\ntotal miles " + calculateTotalMiles();
        return answer;
    }

    /**
     * this helper method calculates each file's total mile count 
     * @return
     */
    private double calculateTotalMiles(){
        double totalMiles = 0.0;
        Pattern airports = Pattern.compile("miles=(\\d+)];");

        try(Scanner scan = new Scanner(new File("/home/eliang7/p2/flights.dot"))){
            while(scan.hasNextLine()){

                String next = scan.nextLine();
                Matcher match = airports.matcher(next);
                
                if(match.find()){
                    double miles = Double.parseDouble(match.group(1));
                    totalMiles += miles;
                }
            }

        } catch(FileNotFoundException e){
            System.out.println("File not found. Please check the file path and try again.");
        }
        return totalMiles;
    }


}
