FROM docker.elastic.co/elasticsearch/elasticsearch:6.4.0

ENV TZ=Europe/Oslo

USER root

RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

USER elasticsearch

COPY lib/ingest-attachment-6.4.0.zip /tmp/ingest-attachment-6.4.0.zip
COPY lib/analysis-icu-6.4.0.zip /tmp/analysis-icu-6.4.0.zip
COPY config/hunspell /usr/share/elasticsearch/config/hunspell

RUN elasticsearch-plugin install --batch file:/tmp/ingest-attachment-6.4.0.zip
RUN elasticsearch-plugin install file:/tmp/analysis-icu-6.4.0.zip
