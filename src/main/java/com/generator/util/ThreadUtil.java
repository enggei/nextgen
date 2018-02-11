package com.generator.util;

import com.generator.neo.NeoModel;
import org.neo4j.graphdb.Transaction;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/**
 * Created 05.12.17.
 */
public class ThreadUtil {

   private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ThreadUtil.class);

   public interface ThreadTask<U> {

      U run();

      void onComplete(U result);
   }

   public static void shutdown(ExecutorService executor, long millisecondsAwait) {
      try {
         log.info("shutdown ExecutorService");
         executor.shutdown();
         executor.awaitTermination(millisecondsAwait, TimeUnit.MILLISECONDS);
      } catch (InterruptedException e) {
         log.warn("executor task interrupted: " + e.getMessage(), e);
      } finally {
         if (!executor.isTerminated())
            log.warn("executor task shutdownNow with running tasks still in progress!");
         executor.shutdownNow();
         log.info("executor service shutdown");
      }
   }

   public static <T> void runTask(ThreadTask<T> task) {
      CompletableFuture.supplyAsync(task::run).thenAccept(task::onComplete);
   }

   public static <T> void runTaskInNeoTransaction(NeoModel graph, ThreadTask<T> task) {
      CompletableFuture.supplyAsync(new Supplier<T>() {

         private T result = null;

         @Override
         public T get() {

            graph.doInTransaction(new NeoModel.Committer() {
               @Override
               public void doAction(Transaction tx) throws Throwable {
                  result = task.run();
               }

               @Override
               public void exception(Throwable throwable) {
                  throwable.printStackTrace();
               }
            });

            return result;
         }
      }).thenAccept(task::onComplete);
   }
}