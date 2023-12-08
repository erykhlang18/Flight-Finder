runBDTests: BackendDeveloperTests.java
	javac -cp ../junit5.jar: BackendDeveloperTests.java
	java -jar ../junit5.jar -cp . -c BackendDeveloperTests
clean:
	rm -f *.class
	rm -f *.1
	rm -f *.save
runFDTests:
	javac -cp ".:../junit5.jar" FrontendDeveloperTests.java
	java -cp ".:../junit5.jar" org.junit.platform.console.ConsoleLauncher --scan-class-path
