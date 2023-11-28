runBDTests: BackendDeveloperTests.java
	javac BackendDeveloperTests.java
	java BackendDeveloperTests
clean:
	rm -f *.class
	rm -f *.1
	rm -f *.save

