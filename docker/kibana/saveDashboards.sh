#!/usr/bin/env bash

docker run --network=nextgen_platform --rm -ti taskrabbit/elasticsearch-dump \
  --input=http://elasticsearchlogs:9200/.kibana \
  --output=$ \
  --type=data > config/dashboard_temp.json

sort config/dashboard_temp.json > config/dashboard.json
rm config/dashboard_temp.json
