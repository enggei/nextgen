#!/usr/bin/env bash
set -e

# docker-compose environment variables
export COMPOSE_PROJECT_NAME=nextgen

# environment variables used in docker-compose*.yml
export DOCKER_BASE_DIR=/opt/docker
export DOCKER_REGISTRY=localhost
export TAG=dev
export COMPOSE_FILES="-f docker-compose.yml -f docker-compose.override.yml"

build() {
  echo -e "\n### BUILDING $1"
  docker-compose ${COMPOSE_FILES} build $1
}

buildAndStart() {
  name=$1[@]
  containers=("${!name}")
  for container in "${containers[@]}"; do
    build ${container}
    start ${container}
  done
}

start() {
  echo -e "\n### STARTING $1"
  docker-compose ${COMPOSE_FILES} up -d $1
}

case $1 in
  all)
    declare -a containers=("stardog" "elasticsearch" "elasticsearchlogs" "kibana" "fluentd" "web")
    buildAndStart containers
    ;;

  stardog | elasticsearchlogs | kibana | fluentd | web)
    build $1
    start $1
    ;;

  elasticsearch)
    if [ ! -f elasticsearch/analysis-icu-5.6.3.zip ]; then
      wget -P elasticsearch https://artifacts.elastic.co/downloads/elasticsearch-plugins/analysis-icu/analysis-icu-5.6.3.zip
    fi
    if [ ! -f elasticsearch/ingest-attachment-5.6.3.zip ]; then
      wget -P elasticsearch https://artifacts.elastic.co/downloads/elasticsearch-plugins/ingest-attachment/ingest-attachment-5.6.3.zip
    fi

    build $1
    start $1
    ;;

  efk)
    declare -a containers=("elasticsearchlogs" "kibana" "fluentd" "web")
    buildAndStart containers
    ;;

  list)
    echo -e "Build options:\n
  - all
  - efk
  - elasticsearch
  - elasticsearchlogs
  - kibana
  - fluentd
  - web
  - stardog
"
    ;;
  *)
    echo -e "Usage:\n'$0 list' to display available options\n'$0 all' to build everything"
    ;;
esac
