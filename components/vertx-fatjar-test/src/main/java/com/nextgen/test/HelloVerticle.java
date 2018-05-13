package com.nextgen.test;

import com.generator.util.VertxUtil.SuccessHandler;
import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.client.config.ClientNetworkConfig;
import com.hazelcast.config.GroupConfig;
import com.hazelcast.core.HazelcastInstance;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.spi.cluster.ClusterManager;
import io.vertx.spi.cluster.hazelcast.HazelcastClusterManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.generator.util.VertxUtil.deploy;

public class HelloVerticle extends AbstractVerticle {

   private static final Logger log = LoggerFactory.getLogger(HelloVerticle.class);

   @Override
   public void start(Future<Void> startFuture) throws Exception {
      log.info("Starting");

      vertx.createHttpServer().requestHandler(
         request -> request.response().end("Yeah! It works!")
      ).listen(8081);

      log.debug("Pinging every 5 seconds");

      vertx.setPeriodic(5000L, timerId -> vertx.eventBus().send("ping.address", "PING?", reply -> {
         if (reply.succeeded()) {
            log.info("Reply received: " + reply.result().body());
         } else {
            log.warn("No reply received");
         }
      }));

      log.info("Started");

      startFuture.complete();
   }

   // Run with
   // * VM Options: -Dhazelcast.logging.type=slf4j
   public static void main(String[] args) {
      ClientConfig clientConfig = new ClientConfig()
         .setGroupConfig(new GroupConfig().setName("nextgen").setPassword("nextgen"))
         .setNetworkConfig(new ClientNetworkConfig().addAddress("172.19.0.5"));

      HazelcastInstance hazelcastInstance = HazelcastClient.newHazelcastClient(clientConfig);

      log.info("Hazelcast client ID: {}", hazelcastInstance.getLocalEndpoint().getUuid());

      ClusterManager clusterManager = new HazelcastClusterManager(hazelcastInstance);

      deploy(clusterManager, HelloVerticle.class, log, new SuccessHandler<String>() {
         @Override
         public void onSuccess(String result) {
            log.info("YAY: " + result);
         }

         @Override
         public void onFail(Throwable t) {
            log.error("WTF", t);
         }
      });
   }
}
