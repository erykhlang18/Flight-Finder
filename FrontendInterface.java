import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This interface will be implemented for the frontend class in the Flight Router App.
 * It will need a backend class for the app to work completely.
 * This frontend will be an interactive loop that will need the user to interact with the app with the help of the terminal
 */
public interface FrontendInterface {


  /*
  Scanner scanner; // Instance of scanner the user will enter his command in
  Backend backend; //Backend that will be required for the app to work correctly
  */
  /**
   * This constructor assigns the parameter to the class variables.
   * @param backend backend object that will be required for the app to wor
   * @param scanner instance of scanner that the user will use to enter his command
   */
  /*
  public IndividualFrontendInterface(Backend backend, Scanner scanner){
    this.backend = backend;
    this.scanner = scanner;
  }
  */



  /**
   * This method will ask the user to specify a data file that can be read
   * by the backend. The user will specify this with the help of the terminal
   * If there is no file with the name specified, throws an exception.
   *
   * @throws FileNotFoundException, if there is no existing file with the specified name
   */
  public void loadFile() throws FileNotFoundException;


  /**
   * This method will show the statistics about the dataset. Those statistics
   * will include the number of airports, flights, and also the total number of miles
   * All of those statistics will be printed through the terminal.
   * Will print a message error if there was no file loaded before using this function.
   */
  public void showStats();


  /**
   * This method first asks the user for a start and destination airport. It will then call
   * the backend method to get a list of the shortest route between those two airports.
   * Within this list will be printed the total distance, all the airports on the way and the distance
   * between each airport on the route.
   * Will print a message error if there was no file loaded before using this function.
   * Will print a message error if one of the two airports entered by the user doesn't exist in the data file.
   */
  public void getRoute();


  /**
   * This method will allow the user to exit the app.
   */
  public void exitApp();

  /**
   * This method starts the main loop that allow the access to all the other commands
   */
  public void startApp();


}
