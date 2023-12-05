runBDTests: BackendDeveloperTests.java
	javac -cp ../junit5.jar: BackendDeveloperTests.java
	java -jar ../junit5.jar -cp . -c BackendDeveloperTests
clean:
	rm -f *.class
	rm -f *.1
	rm -f *.save

