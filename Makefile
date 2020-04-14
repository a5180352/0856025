JFLAGS = -g
JC = javac
JVM = java

CLASSES = \
	src/PriorityQueueTest.java

MAIN = PriorityQueueTest

.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

default: classes

classes: $(CLASSES:.java=.class)

run: classes
	$(JVM) $(MAIN)

clean:
	$(RM) *.class