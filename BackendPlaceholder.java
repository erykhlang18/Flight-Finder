// --== CS400 File Header Information ==--
// Name: Aiden Lang
// Email: ajlang5@wisc.edu
// Group and Team:G26, yellow
// Group TA: Alex Peseckis
// Lecturer: Florian Heimerl
// Notes to Grader: <optional extra notes>

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

public class BackendPlaceholder implements BackendInterface {

    @Override
    public void readDataFile(String filePath) throws FileNotFoundException {
        if (filePath.equals("invalid/file/path.txt")) {
            throw new FileNotFoundException("File not found: " + filePath);
        }
        System.out.println("Reading data file (placeholder): " + filePath);
    }

    @Override
    public ShortestPath getShortestRoute(String start, String end) {
        // Return a simple hardcoded ShortestPath object for testing
        return new ShortestPathPlaceholder(start, end);
    }

    @Override
    public String getGraphStats() {
        // Return some hardcoded stats for testing
        return "Number of Airports: 10, Number of Flights: 20, Total Miles: 10000";
    }

    /**
     * Placeholder implementation of the ShortestPath interface for testing.
     */
    private static class ShortestPathPlaceholder implements ShortestPath {
        private String start;
        private String end;

        public ShortestPathPlaceholder(String start, String end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public List<String> getRoute() {
            // Hardcoded route for testing
            return Arrays.asList(start, "INTERMEDIATE", end);
        }

        @Override
        public List<Integer> getMilesSegment() {
            // Hardcoded miles for each segment for testing
            return Arrays.asList(100, 200);
        }

        @Override
        public int getTotalMiles() {
            // Hardcoded total miles for testing
            return 300;
        }
    }
}

