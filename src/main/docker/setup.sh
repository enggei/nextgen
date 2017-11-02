#!/usr/bin/env bash
set -e

# docker-compose environment variables
export COMPOSE_PROJECT_NAME=nextgen

# environment variables used in docker-compose*.yml
export DOCKER_BASE_DIR=/opt/docker
export DOCKER_REGISTRY=localhost
export TAG=dev
export COMPOSE_FILES="-f docker-compose.yml -f docker-compose.override.yml"

if [ ! -f elasticsearch/analysis-icu-5.6.3.zip ]; then
  wget -P elasticsearch https://artifacts.elastic.co/downloads/elasticsearch-plugins/analysis-icu/analysis-icu-5.6.3.zip
fi
if [ ! -f elasticsearch/ingest-attachment-5.6.3.zip ]; then
  wget -P elasticsearch https://artifacts.elastic.co/downloads/elasticsearch-plugins/ingest-attachment/ingest-attachment-5.6.3.zip
fi

echo "### DOCKER-COMPOSE START"

#declare -a containers=("stardog" "elasticsearch" "elasticsearchlogs" "kibana" "fluentd" "web")
declare -a containers=("elasticsearch" "elasticsearchlogs" "kibana" "fluentd" "web")

for container in "${containers[@]}"; do
    echo "### BUILDING $container"
    docker-compose ${COMPOSE_FILES} build ${container}
    docker-compose ${COMPOSE_FILES} up -d ${container}
done

echo "### DOCKER-COMPOSE DONE"
