FROM hazelcast/hazelcast

ENV TZ=Europe/Oslo
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

# Dependencies
ADD lib $HZ_HOME/lib
