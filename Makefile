all:
	javac *java
	java Assignment3 5 SCBST input.txt
clean:
	rm *class
