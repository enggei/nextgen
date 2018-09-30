FROM docker.elastic.co/elasticsearch/elasticsearch:6.4.0

ENV TZ=Europe/Oslo

USER root

RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

USER elasticsearch
