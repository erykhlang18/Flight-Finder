# Makefile for Frontend Developer Tests

# Compile and run frontend developer tests
runFDTest: 
	java -cp ".:/home/ajlang5/junit5.jar" FrontendDeveloperTests.java
	java -jar ../junit5.jar -cp . -c FrontendDeveloperTests

# Clean up the compiled files
clean:
	rm -f *.class

