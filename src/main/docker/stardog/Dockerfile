FROM java:8-jre

ENV TZ=Europe/Oslo
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

# Installing bash to run /tmp/script.sh bellow
RUN apt-get update && apt-get -y upgrade && apt-get -y install curl bash bash-completion

##### SET STARDOG VERSION TO DOWNLOADED VERSION ###
#ENV STARDOG_VERSION=stardog-5.1.0
ARG STARDOG_VERSION
ENV STARDOG_VERSION "stardog-$STARDOG_VERSION"

ENV STARDOG_HOME=/home/stardog/data/
ENV STARDOG_APP=/home/stardog/app
ENV STARDOG_LOCATION=$STARDOG_APP/$STARDOG_VERSION
ENV LICENSE=stardog-license-key.bin
ENV STARDOG_FLAGS=

WORKDIR $STARDOG_APP/

ADD $STARDOG_VERSION $STARDOG_LOCATION/
RUN chmod +x $STARDOG_LOCATION/bin/stardog-admin
ADD $LICENSE /

WORKDIR $STARDOG_LOCATION/bin

ADD stardog.properties $STARDOG_HOME

ADD script.sh /tmp/script.sh
RUN chmod +x /tmp/script.sh

EXPOSE 5820

RUN mv stardog-completion.sh /etc/

WORKDIR /root
RUN touch .bashrc
RUN echo "PATH=${STARDOG_LOCATION}/bin:$PATH" >> .bashrc
RUN echo "source /etc/stardog-completion.sh" >> .bashrc

WORKDIR $STARDOG_HOME

CMD sh /tmp/script.sh $STARDOG_FLAGS
