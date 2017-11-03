## Docker containers

### Preparation

Set vm.max_map_count to at least 262144 (for Elasticsearch)

```bash
sudo sysctl -w vm.max_map_count=262144
```

```bash
sudo su -c "mkdir -p /opt/docker/stardog"
sudo su -c "mkdir -p /opt/docker/elasticsearch"
sudo chown -R user:user /opt/docker/*
```

### Build and start containers

```bash
./setup.sh
```
