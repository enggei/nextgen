# Elasticsearch

This docker image is configured for the purpose of processing full text data and documents.

Plugins include the Lucene ICU module, and ingesting attachments.

## Prerequisites

Set vm.max_map_count to at least 262144:

```bash
sysctl -w vm.max_map_count=262144
```
And make it permanent by adding / changing the value in ``/etc/sysctl.conf``:
```text
vm.max_map_count = 262144
```

### Plugins

#### Hunspell dictionaries for token filter
```bash
git clone https://github.com/LibreOffice/dictionaries

# Copy as many dictionaries you want
mkdir -p config/hunspell/en_GB && cp -rp dictionaries/en/en_GB* config/hunspell/en_GB/
mkdir -p config/hunspell/nb_NO && cp -rp dictionaries/no/nb_NO* config/hunspell/nb_NO/
mkdir -p config/hunspell/ru_RU && cp -rp dictionaries/ru_RU/ru_RU* config/hunspell/ru_RU/

# etc... etc...
```

#### Analysis ICU
```bash
wget https://artifacts.elastic.co/downloads/elasticsearch-plugins/analysis-icu/analysis-icu-5.6.3.zip
```

#### Ingest attachment
```bash
wget https://artifacts.elastic.co/downloads/elasticsearch-plugins/ingest-attachment/ingest-attachment-5.6.3.zip
```
