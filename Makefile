# Makefile for Frontend Developer Tests

# JUnit JAR path
JUNIT_JAR = /home/ajlang5/junit5.jar

# Compile frontend and backend placeholder classes along with tests
compileFDTest:
	javac *.java

# Run frontend developer tests
runFDTest: compileFDTest
	java -jar $(JUNIT_JAR) --class-path . --scan-class-path

# Clean up the compiled files
clean:
	rm -f *.class
