# Elasticsearch-logs

This docker image is configured for the intention of processing logs.

## Prerequisites

Set vm.max_map_count to at least 262144:

```bash
sysctl -w vm.max_map_count=262144
```
And make it permanent by adding / changing the value in ``/etc/sysctl.conf``:
```text
vm.max_map_count = 262144
```
