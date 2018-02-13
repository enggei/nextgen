FROM docker.elastic.co/kibana/kibana:5.6.3

ENV TZ=Europe/Oslo

USER root

RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

USER kibana

# Remove x-pack
RUN kibana-plugin remove x-pack
