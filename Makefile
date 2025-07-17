JAVAC=javac
JAVA=java
SRC=src
OUT=out/production/judgement

SOURCES=$(wildcard $(SRC)/*.java)

build:
	mkdir -p $(OUT)
	$(JAVAC) -d $(OUT) $(SOURCES)

run: build
	$(JAVA) -cp $(OUT) Main

clean:
	rm -rf out