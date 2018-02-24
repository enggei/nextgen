#!/usr/bin/env bash

docker run -it --rm -v "$PWD"/ssh:/root/.ssh -v "$PWD"/src:/src -w /src/nextgen-frontend node:8-alpine /src/build-frontend.sh
