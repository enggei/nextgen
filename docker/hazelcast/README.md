# Hazelcast configuration

The configuration is tailored for use with Vert.x.

Ref [using an existing Hazelcast cluster](http://vertx.io/docs/vertx-hazelcast/java/#_using_an_existing_hazelcast_cluster)

## Environment variables

```text
HAZELCAST_CONFIG_FOLDER=/path/to/hazelcast-config-folder
```

## Preparation

```bash
sudo su -c "mkdir -p $HAZELCAST_CONFIG_FOLDER && cp hazelcast.xml $HAZELCAST_CONFIG_FOLDER/"
```
