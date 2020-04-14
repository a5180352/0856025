JFLAGS = -classpath /usr/share/java/junit.jar
JC = javac
JVM = java

CLASSES = \
	PriorityQueueTest.java

MAIN = PriorityQueueTest

.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

default: classes

classes: $(CLASSES:.java=.class)

run: classes
	$(JVM) $(JFLAGS) $(MAIN)

clean:
	$(RM) *.class