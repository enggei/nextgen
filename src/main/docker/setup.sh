#!/usr/bin/env bash
set -e

export DOCKER_REGISTRY=localhost
export TAG=dev
export COMPOSE_FILES="-f docker-compose.yml -f docker-compose.override.yml"

docker-compose ${COMPOSE_FILES} build
docker-compose ${COMPOSE_FILES} up -d stardog
