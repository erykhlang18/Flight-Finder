import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class extends the backend class to run tests
 */
public class BackendDeveloperTests  {

        /**
        * this tester method reads a given file and then 
        *finds if the program throws an exception or not
        */
    @Test
    public void testReadDataFile() {
        DijkstraGraph<String, Integer> graph = new DijkstraGraph<>(new PlaceholderMap<>());
        backend back = new backend(graph);
          try {
            back.readDataFile("/home/eliang7/p2/flights.dot");
        } catch (FileNotFoundException e) {
            Assertions.assertFalse(true);
        }

    }

        /**
        *this tester method tests the functionality of the getGraphStats method in the backend class
        */
    @Test
    public void testGetGraphStats() {
        DijkstraGraph<String, Integer> graph = new DijkstraGraph<>(new PlaceholderMap<>());
        backend back = new backend(graph);
          try {
            back.readDataFile("/home/eliang7/p2/flights.dot");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String expectedStats = "total airports 58\ntotal connections 1598\ntotal miles 2142457.0";
            Assertions.assertEquals(expectedStats, back.getGraphStats());
        }

    
        /**
        * this tester method tests the functionality of the shortest path and tests for
        * the prograrm's ability to catch null exceptions 
        */
    @Test
    public void testShortestPathException() {
        DijkstraGraph<String, Integer> graph = new DijkstraGraph<>(new PlaceholderMap<>());
        backend back = new backend(graph);

        try {
        back.readDataFile("/home/eliang7/p2/flights.dot");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    assertDoesNotThrow(() -> back.getShortestRoute("Start", "null"));   
    }    

        /**
        *this tests loading an invalid file to the program 
        */
    @Test
    public void testReadDataFileFileNotFoundException() {
        DijkstraGraph<String, Integer> graph = new DijkstraGraph<>(new PlaceholderMap<>());
        backend back = new backend(graph);
        assertThrows(FileNotFoundException.class, () -> back.readDataFile("NonexistentFile.dot"));
        // Add additional assertions if needed
    }

        /**
        * this tester method tries to test the functionality of the dikjstra's graph implementation 
        * by using the shortest path command between two different airports
        */
    @Test
    public void testShortestPath(){
                DijkstraGraph<String, Integer> graph = new DijkstraGraph<>(new PlaceholderMap<>());
        backend back = new backend(graph);
        try {
            back.readDataFile("/home/eliang7/p2/flights.dot");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Assertions.assertEquals(1330.0, graph.shortestPathCost("LAX", "OMA"));
    }


    //integration tests
    @Test
    public void testLoadFileIntegration() {
        DijkstraGraph<String, Integer> graph = new DijkstraGraph<>(new PlaceholderMap<>());
        backend back = new backend(graph);
        String input = "load\n/home/eliang7/p2/flights.dot\nexit\n";
        StringReader stringReader = new StringReader(input);
        Scanner scan = new Scanner (stringReader);
        Frontend front = new Frontend(back, scan);

        try {
            front.startApp();
        } catch (Exception e) {
            // If an exception is thrown, fail the test
            e.printStackTrace();
            // You can add additional assertions or log messages as needed
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void testGetInvalidRouteIntegration () {
        DijkstraGraph<String, Integer> graph = new DijkstraGraph<>(new PlaceholderMap<>());
        backend back = new backend(graph);
        String input = "load\n/home/eliang7/p2/flights.dot\nroute\nLAX\nJFK";
        StringReader stringReader = new StringReader(input);
        Scanner scan = new Scanner (stringReader);
        Frontend front = new Frontend(back, scan);

        try {
            front.startApp();
            Assertions.assertTrue(false);
        } catch (Exception e) {
            Assertions.assertTrue(true);
        }
    }
    }

 
