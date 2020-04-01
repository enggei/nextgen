FROM vertx/vertx3

ENV TZ=Europe/Oslo
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

ENV VERTICLE_HOME /usr/verticles

#
ENV VERTICLE_NAME com.nextgen.test.HelloVerticle
ENV VERTICLE_FILE target/vertx-test-1.0.jar

# Copy verticle to container
COPY $VERTICLE_FILE $VERTICLE_HOME/

EXPOSE 8080

# Launch the verticle
WORKDIR $VERTICLE_HOME
ENTRYPOINT ["sh", "-c"]
CMD ["exec vertx run $VERTICLE_NAME -cp $VERTICLE_HOME/*"]
