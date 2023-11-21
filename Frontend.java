// --== CS400 File Header Information ==--
// Name: Aiden Lang
// Email: ajlang5@wisc.edu
// Group and Team:G26, yellow
// Group TA: Alex Peseckis
// Lecturer: Florian Heimerl
// Notes to Grader: <optional extra notes>

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

/**
 * This class represents the frontend of the application.
 * It interacts with the backend to perform various operations like loading data,
 * showing statistics, finding the shortest route, and exiting the application.
 */
public class Frontend implements FrontendInterface {
    private BackendPlaceholder backend;
    private Scanner scanner;

    /**
     * Constructs a new Frontend object.
     *
     * @param backend The backend placeholder to interact with.
     * @param scanner The scanner to read user input.
     */
    public Frontend(BackendPlaceholder backend, Scanner scanner) {
        this.backend = backend;
        this.scanner = scanner;
    }

    /**
     * Starts the main application loop. This loop displays the main menu and processes user commands.
     *
     * @throws FileNotFoundException If the specified file in the load command is not found.
     */
    @Override
    public void startApp()  {
        boolean running = true;
        while (running) {
            displayMainMenu();
            String command = scanner.nextLine();

            switch (command.toLowerCase()) {
                case "load":
                    try {
                        loadFile();
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case "stats":
                    showStats();
                    break;
                case "route":
                    getRoute();
                    break;
                case "exit":
                    exitApp();
                    running = false;
                    break;
                default:
                    System.out.println("Invalid command. Please try again.");
            }
        }
    }

    /**
     * Displays the main menu to the user.
     */
    private void displayMainMenu() {
        System.out.println("\nMain Menu:");
        System.out.println("load - Load a data file");
        System.out.println("stats - Show dataset statistics");
        System.out.println("route - Find shortest route");
        System.out.println("exit - Exit the application");
        System.out.print("Enter a command: ");
    }

    /**
     * Loads a data file as specified by the user.
     *
     * @throws FileNotFoundException If the file specified by the user is not found.
     */
    @Override
    public void loadFile() throws FileNotFoundException {
        System.out.print("Enter file path: ");
        String filePath = scanner.nextLine();
        backend.readDataFile(filePath);
        System.out.println("File loaded successfully.");
    }

    /**
     * Displays statistics about the data set.
     */
    @Override
    public void showStats() {
        String stats = backend.getGraphStats();
        System.out.println(stats);
    }

    /**
     * Prompts the user for start and end airports and displays the shortest route.
     */
    @Override
    public void getRoute() {
        System.out.print("Enter start airport code: ");
        String start = scanner.nextLine();
        System.out.print("Enter destination airport code: ");
        String end = scanner.nextLine();

        ShortestPath route = backend.getShortestRoute(start, end);
        if (route != null) {
            displayRoute(route);
        } else {
            System.out.println("No route found.");
        }
    }

    /**
     * Displays the shortest route from start to destination airport.
     *
     * @param route The shortest path instance containing route information.
     */
    private void displayRoute(ShortestPath route) {
        List<String> airports = route.getRoute();
        List<Integer> miles = route.getMilesSegment();
        int totalMiles = route.getTotalMiles();

        System.out.println("Shortest route from " + airports.get(0) + " to " + airports.get(airports.size() - 1) + ":");
        for (int i = 0; i < airports.size() - 1; i++) {
            System.out.println(airports.get(i) + " to " + airports.get(i + 1) + " - " + miles.get(i) + " miles");
        }
        System.out.println("Total miles: " + totalMiles);
    }

    /**
     * Exits the application.
     */
    @Override
    public void exitApp() {
        System.out.println("Exiting application.");
    }
}
