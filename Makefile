# Makefile for Frontend Developer Tests

# Variable for JUnit classpath
JUNIT_CP = ./junit5.jar

# Compile and run frontend developer tests
runFDTest: 
	javac -cp ".:$(JUNIT_CP)" FrontendDeveloperTests.java
	java -cp ".:$(JUNIT_CP)" org.junit.platform.console.ConsoleLauncher --scan-class-path

# Clean up the compiled files
clean:
	rm -f *.class
