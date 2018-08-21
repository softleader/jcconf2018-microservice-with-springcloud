.PHONY: all
all: build push

.PHONY: build
build:
	docker build -t softleader/build-env:jcconf2018 .

.PHONY: push
push:
	docker push softleader/build-env:jcconf2018