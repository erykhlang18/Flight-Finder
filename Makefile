# Makefile for Frontend Developer Tests

# Compile and run frontend developer tests
runFDTest: 
	javac -cp ".:/home/ajlang5/junit5.jar" FrontendDeveloperTests.java
	java -cp ".:/home/ajlang5/junit5.jar" FrontendDeveloperTests.java

# Clean up the compiled files
clean:
	rm -f *.class

