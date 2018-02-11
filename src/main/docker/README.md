## Docker containers

### Preparation

Set vm.max_map_count to at least 262144 (for Elasticsearch)

```bash
sudo sysctl -w vm.max_map_count=262144
```
And make it permanent by adding / changing the value in ``/etc/sysctl.conf``:
```text
vm.max_map_count = 262144
```

```bash
sudo su -c "mkdir -p /opt/docker/nextgen && chown user:user /opt/docker/nextgen"
```

### Build and start containers

```bash
./setup.sh all
```
