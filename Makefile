# Makefile for Frontend Developer Tests

# Compile and run frontend developer tests
runFDTest: 
	javac -cp ".:/home/ajlang5/junit5.jar" FrontendDeveloperTests.java
	java -cp ".:/home/ajlang5/junit5.jar" org.junit.platform.console.ConsoleLauncher --scan-class-path

# Clean up the compiled files
clean:
	rm -f *.class
	rm -f *.class
