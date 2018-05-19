#!/usr/bin/env bash

docker run --network=nextgen_platform --rm -ti --volume $(pwd)/config:/tmp/config taskrabbit/elasticsearch-dump \
  --volume $(pwd)/config:/tmp/config \
  --direction=load \
  --input=/tmp/config/dashboard.json \
  --output=http://elasticsearchlogs:9200/.kibana \
  --type=data
