FROM docker.elastic.co/kibana/kibana:6.4.0

ENV TZ=Europe/Oslo

USER root

RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

USER kibana
