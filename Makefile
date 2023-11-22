# Makefile for Frontend Developer Tests

# Compile and run frontend developer tests
runFDTest: 
	javac -cp ".:../junit5.jar" FrontendDeveloperTests.java
	java -cp ".:../junit5.jar" org.junit.platform.console.ConsoleLauncher --scan-class-path

# Clean up the compiled files
clean:
	rm -f *.class
