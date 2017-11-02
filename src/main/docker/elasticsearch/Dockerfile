FROM docker.elastic.co/elasticsearch/elasticsearch:5.6.3

ENV TZ=Europe/Oslo

USER root

RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

USER elasticsearch

RUN elasticsearch-plugin remove x-pack

COPY ingest-attachment-5.6.3.zip /tmp/ingest-attachment-5.6.3.zip
COPY analysis-icu-5.6.3.zip /tmp/analysis-icu-5.6.3.zip
COPY config/hunspell /usr/share/elasticsearch/config/hunspell

RUN elasticsearch-plugin install file:/tmp/ingest-attachment-5.6.3.zip
RUN elasticsearch-plugin install file:/tmp/analysis-icu-5.6.3.zip
