clean:
	rm -rf *.class *~

all:
	javac *.java

run:    all
	java Calculator

git commit: git add
	git commit -m "meddelande"

git add: clean
	git add .

git: git commit
	git push
	


