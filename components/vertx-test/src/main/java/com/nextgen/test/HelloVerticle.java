package com.nextgen.test;

import io.vertx.core.AbstractVerticle;

public class HelloVerticle extends AbstractVerticle {

   @Override
   public void start() throws Exception {
      vertx.createHttpServer().requestHandler(
         request -> request.response().end("Yeah! It works!")
      ).listen(8080);
   }
}
