// --== CS400 File Header Information ==--
// Name: Aiden Lang
// Email: ajlang5@wisc.edu
// Group and Team:G26, yellow
// Group TA: Alex Peseckis
// Lecturer: Florian Heimerl
// Notes to Grader: <optional extra notes>

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains unit tests for the Frontend class.
 * It tests various functionalities of the Frontend class including file loading,
 * displaying statistics, finding routes, and exiting the application.
 */
public class FrontendDeveloperTests {

    private Frontend frontend;
    private BackendPlaceholder mockBackend;
    private BackendInterface backend;

    private final InputStream originalSystemIn = System.in;

    /**
     * Set up common test data and configurations before each test.
     * Initializes a new instance of BackendPlaceholder and Frontend with a new Scanner.
     */
    @BeforeEach
    public void setUp() {
        mockBackend = new BackendPlaceholder();
        frontend = new Frontend(mockBackend, new Scanner(System.in));
    }

    /**
     * Provides a way to simulate user input by setting System.in to a ByteArrayInputStream.
     * @param data The string to be used as the simulated input.
     */
    private void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    /**
     * Tests loading of a valid file.
     * Expects no exception to be thrown for a valid file path.
     */
    @Test
    public void testLoadFile_ValidFile() {
        provideInput("path/to/valid/file.txt");
        Scanner scanner = new Scanner(System.in);
        Frontend testFrontend = new Frontend(mockBackend, scanner);

        try {
            testFrontend.loadFile();
        } catch (Exception e) {
            fail("Loading a valid file should not have thrown any exception.");
        }
    }

    /**
     * Tests loading of an invalid file.
     * Expects a FileNotFoundException to be thrown for an invalid file path.
     */
    @Test
    public void testLoadFile_InvalidFile() {
        provideInput("invalid/file/path.txt");
        Scanner scanner = new Scanner(System.in);
        Frontend testFrontend = new Frontend(mockBackend, scanner);

        Exception exception = assertThrows(FileNotFoundException.class, testFrontend::loadFile);
        assertTrue(exception.getMessage().contains("File not found"));
    }

    /**
     * Tests the display of statistics with a file loaded.
     * Expects no exception to be thrown when displaying statistics.
     */
    @Test
    public void testShowStats_WithFileLoaded() {
        try {
            frontend.showStats();
        } catch (Exception e) {
            fail("Showing stats should not have thrown any exception.");
        }
    }

    /**
     * Tests finding a route with valid start and end inputs.
     * Expects no exception to be thrown for valid inputs.
     */
    @Test
    public void testGetRoute_ValidInputs() {
        provideInput("START\nEND");
        Scanner scanner = new Scanner(System.in);
        Frontend testFrontend = new Frontend(mockBackend, scanner);

        try {
            testFrontend.getRoute();
        } catch (Exception e) {
            fail("Getting route with valid inputs should not have thrown any exception.");
        }
    }

    /**
     * Tests finding a route with invalid start and end inputs.
     * Expects no exception to be thrown for invalid inputs.
     */
    @Test
    public void testGetRoute_InvalidInputs() {
        provideInput("INVA LID_START\nINVALID_END");
        Scanner scanner = new Scanner(System.in);
        Frontend testFrontend = new Frontend(mockBackend, scanner);

        try {
            testFrontend.getRoute();
        } catch (Exception e) {
            fail("The method should handle invalid inputs without throwing an exception.");
        }
    }

    /**
     * Tests the functionality of exiting the application.
     * Expects no exception to be thrown when exiting the application.
     */
    @Test
    public void testExitApp() {
        try {
            frontend.exitApp();
        } catch (Exception e) {
            fail("Exiting the app should not have thrown any exception.");
        }
    }

    @BeforeEach
    public void setUp2() {
        DijkstraGraph<String, Integer> graph = new DijkstraGraph<>(new PlaceholderMap<>());
        backend back = new backend(graph);
        backend = new backend(graph); 
        frontend = new Frontend(backend, new Scanner(System.in));
    }

    /**
     * Integration test to check if the frontend correctly uses the backend to load a file.
     * This test simulates the frontend loading a file using the backend's interface.
     * It's expected to fail compilation until the actual backend implementation is provided.
     */
    @Test
    public void testLoadFileIntegration() {
        provideInput("path/to/valid/file.txt");
        Scanner scanner = new Scanner(System.in);
        Frontend testFrontend = new Frontend(backend, scanner);

       assertDoesNotThrow(testFrontend::loadFile);
    }

    /**
     * Integration test to check if the frontend correctly interacts with the backend to find a route.
     * This test simulates the process of finding a route using the frontend with backend integration.
     * It's expected to fail compilation until the actual backend implementation is provided.
     */
    @Test
    public void testGetRouteIntegration() {
        provideInput("START\nEND");
        Scanner scanner = new Scanner(System.in);
        Frontend testFrontend = new Frontend(backend, scanner);

        testFrontend.getRoute();
        // Further assertions would be made here based on the expected behavior of the backend
    }

}
