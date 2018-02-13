FROM docker.elastic.co/elasticsearch/elasticsearch:5.6.3

ENV TZ=Europe/Oslo

USER root

RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

USER elasticsearch

RUN elasticsearch-plugin remove x-pack
