# Makefile for Frontend Developer Tests

# JUnit 5 jar file
JUNIT_JAR = /home/ajlang5/junit5.jar

# Compile and run frontend developer tests
runFDTest: compileFDTests
	java -jar $(JUNIT_JAR) -cp . --scan-classpath

# Compile frontend and backend placeholder classes along with tests
compileFDTests:
	javac -cp ".:$(JUNIT_JAR)" *.java

# Clean up the compiled files
clean:
	rm -f *.class
	rm -f */*.class
