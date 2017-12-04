
compiletest:
	javac -cp hamcrest-core-1.3.jar:junit-4.12.jar:. TestRunner.java

runtests: compiletest
	java -cp hamcrest-core-1.3.jar:junit-4.12.jar:. org.junit.runner.JUnitCore TestRunner

clean:
	rm -rf *.class *~ symbolic/*.class

all:
	javac *.java symbolic/*.java

run:    all
	java Calculator

git commit: git add
	git commit -m "meddelande"

git add: clean
	git add .

git: git commit
	git push


