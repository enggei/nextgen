package com.generator.util;

import io.vertx.core.DeploymentOptions;
import io.vertx.core.Handler;
import io.vertx.core.Verticle;
import io.vertx.core.Vertx;
import io.vertx.core.eventbus.DeliveryOptions;
import io.vertx.core.eventbus.Message;
import io.vertx.core.file.FileSystem;
import io.vertx.core.json.JsonObject;
import io.vertx.core.shareddata.LocalMap;
import io.vertx.core.shareddata.SharedData;
import org.apache.log4j.Logger;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;


/**
 * goe on 1/14/16.
 */
public class VertxUtil {

	public static final String RESULT = "result";
	public static final String SUCCESS = "success";
	public static final String FAIL = "fail";
	public static final String CONTENT = "content";
	public static final String CAUSE = "cause";

	public static void putInLocalMap(Vertx vertx, Logger log, String mapName, String key, Object value) {

		final SharedData sharedData = vertx.sharedData();
		final LocalMap<Object, Object> localMap = sharedData.getLocalMap(mapName);
		log.info("putting '" + key + "' = '" + value + "' in local map '" + mapName + "'");
		localMap.put(key, value);
	}

	@SuppressWarnings("unchecked")
	public static <V> V removeFromLocalMap(Vertx vertx, Logger log, String mapName, String key) {
		final SharedData sharedData = vertx.sharedData();
		final LocalMap<Object, Object> localMap = sharedData.getLocalMap(mapName);
		log.info("removing '" + key + "' = '" + (localMap.get(key)) + "' in local map '" + mapName + "'");
		return (V) localMap.remove(key);
	}

	@SuppressWarnings("unchecked")
	public static <V> V getFromLocalMap(Vertx vertx, Logger log, String mapName, String key) {
		final SharedData sharedData = vertx.sharedData();
		final LocalMap<Object, Object> localMap = sharedData.getLocalMap(mapName);
		log.info("getting '" + key + "' = '" + (localMap.get(key)) + "' from local map '" + mapName + "'");
		return (V) localMap.get(key);
	}

	public static void readDir(Vertx vertx, Logger log, File directory, SuccessHandler<List<File>> successHandler) {

		final FileSystem fileSystem = vertx.fileSystem();
		log.info("readDir " + directory.getAbsolutePath());

		fileSystem.readDir(directory.getAbsolutePath(), result -> {

			if (result.failed()) {
				successHandler.onFail(result.cause());
				return;
			}

			final List<File> list = new ArrayList<>(result.result().size());
			for (String s : result.result())
				list.add(new File(s));

			successHandler.onSuccess(list);
		});
	}

	public static void putInClusterMap(Vertx vertx, Logger log, String mapName, String key, Object value, SuccessHandler<Void> successHandler) {

		vertx.sharedData().getClusterWideMap(mapName, result -> {

			if (result.failed()) {
				log.error("could not get clusterWiteMap '" + mapName + "'");
				successHandler.onFail(result.cause());
				return;
			}

			result.result().put(key, value, resultPut -> {
				if (resultPut.failed()) {
					log.error("could not store " + key + " (" + value + ") in " + mapName);
					successHandler.onFail(resultPut.cause());
					return;
				}

				log.info(key + " stored in sessions");
				successHandler.onSuccess(null);
			});
		});
	}

	@SuppressWarnings("unchecked")
	public static <V> void removeFromClusterMap(Vertx vertx, Logger log, String mapName, String key, SuccessHandler<V> successHandler) {

		vertx.sharedData().getClusterWideMap(mapName, result -> {

			if (result.failed()) {

				log.error("could not get clusterWideMap '" + mapName + "'");

				successHandler.onFail(result.cause());
				return;
			}

			result.result().remove(key, resultGet -> {

				if (resultGet.failed()) {
					log.error("could not remove '" + key + "' from '" + mapName + "'");
					successHandler.onFail(resultGet.cause());
					return;
				}

				log.info("'" + key + "' removed from '" + mapName + "'");
				successHandler.onSuccess((V) resultGet);
			});
		});
	}

	@SuppressWarnings("unchecked")
	public static <V> void getFromClusterMap(Vertx vertx, Logger log, String mapName, String key, SuccessHandler<V> successHandler) {

		vertx.sharedData().getClusterWideMap(mapName, result -> {

			if (result.failed()) {
				log.error("could not get clusterWideMap '" + mapName + "'");
				successHandler.onFail(result.cause());
				return;
			}

			result.result().get(key, resultGet -> {

				if (resultGet.failed()) {
					log.error("could not get '" + key + "' from '" + mapName + "'");
					successHandler.onFail(resultGet.cause());
					return;
				}

				if (resultGet.result() == null) {
					log.error("could not get '" + key + "' from '" + mapName + "', its null.");
					successHandler.onFail(new Throwable("'" + key + "'" + " has null-value in '" + mapName + "'"));
					return;
				}

				log.info("'" + key + "' found in '" + mapName + "'");
				successHandler.onSuccess((V) resultGet);
			});
		});
	}

	public interface SuccessHandler<T> {

		void onSuccess(T result);

		void onFail(Throwable t);

	}

	public interface Executor<R, T> extends SuccessHandler<T> {

		R execute() throws Throwable;
	}

	@SuppressWarnings("unchecked")
	public static <R> void executeBlocking(Vertx vertx, Logger log, Executor<R, R> executor) {

		vertx.executeBlocking(future -> {

			try {

				final R result = executor.execute();

				if (result == null) future.complete();
				else future.complete(result);

			} catch (Throwable throwable) {
				log.error("Could not execute blocking : " + throwable.getMessage(), throwable);
			}

		}, res -> {

			if (res.failed()) {
				executor.onFail(res.cause());
				return;
			}
			if (res.succeeded())
				executor.onSuccess((R) res);
		});
	}

	public static <T> void consume(Vertx vertx, String consumer, String address, Logger log, Handler<Message<T>> messageHandler) {
		log.info(consumer + " listening for '" + address + "' messages");
		vertx.eventBus().consumer(address, messageHandler);
	}

	public static <T, R> void sendMessage(Vertx vertx, String address, T content, Logger log, SuccessHandler<Message<R>> handler) {
		sendMessage(vertx, address, content, null, log, handler);
	}

	@SuppressWarnings("unchecked")
	public static <T, R> void sendMessage(Vertx vertx, String address, T content, DeliveryOptions options, Logger log, SuccessHandler<R> handler) {

		if (options == null) options = new DeliveryOptions();

		vertx.eventBus().send(address, content, options, result -> {

			if (result.failed()) {
				handler.onFail(result.cause());
				return;
			}

			log.debug("' sent to " + address);
			handler.onSuccess((R) result.result());
		});
	}

	public static void publish(Vertx vertx, String address, Object content, Logger log) {
		publish(vertx, address, content, null, log);
	}

	public static void publish(Vertx vertx, String address, Object content, DeliveryOptions options, Logger log) {
		if (options == null) options = new DeliveryOptions();
		log.info("publish to " + address + " : " + content);
		vertx.eventBus().publish(address, content, options);
	}

	private static final AtomicLong NO_VERTICLES = new AtomicLong();

	public static void undeploy(Vertx vertx, Logger log, String deploymentId, SuccessHandler<Void> handler) {

		vertx.undeploy(deploymentId, result -> {

			if (result.failed()) {
				handler.onFail(result.cause());
				log.error("could not UNDEPLOY '" + deploymentId + "'", result.cause());
				return;
			}

			log.info("Undeployed " + deploymentId + " (" + NO_VERTICLES.decrementAndGet() + ")");
			handler.onSuccess(null);
		});
	}

	public static void deploy(Vertx vertx, Verticle verticle, Logger log, SuccessHandler<String> handler) {
		deploy(vertx, verticle, null, log, handler);
	}

	public static void deploy(Vertx vertx, Verticle verticle, DeploymentOptions deploymentOptions, Logger log, SuccessHandler<String> handler) {

		if (deploymentOptions == null) deploymentOptions = new DeploymentOptions();

		vertx.deployVerticle(verticle, deploymentOptions, result -> {

			if (result.failed()) {
				handler.onFail(result.cause());
				log.error("could not DEPLOY VERTICLE '" + verticle + "'", result.cause());
				return;
			}

			log.info(verticle + " deployed (" + NO_VERTICLES.incrementAndGet() + ")");
			handler.onSuccess(result.result());
		});
	}

	public static void deploy(Vertx vertx, String className, DeploymentOptions deploymentOptions, Logger log, SuccessHandler<String> handler) {

		if (deploymentOptions == null) deploymentOptions = new DeploymentOptions();

		vertx.deployVerticle(className, deploymentOptions, result -> {

			if (result.failed()) {
				handler.onFail(result.cause());
				log.error("could not DEPLOY VERTICLE '" + className + "'", result.cause());
				return;
			}

			log.info(className + " deployed (" + NO_VERTICLES.incrementAndGet() + ")");
			handler.onSuccess(result.result());
		});
	}

	public static void deploy(Vertx vertx, String className, JsonObject config, Logger log, SuccessHandler<String> handler) {

		final DeploymentOptions deploymentOptions = new DeploymentOptions();
		if (config != null) deploymentOptions.setConfig(config);

		deploy(vertx, className, deploymentOptions, log, handler);
	}

	public static void deploy(Vertx vertx, String className, Logger log, SuccessHandler<String> handler) {
		deploy(vertx, className, new DeploymentOptions(), log, handler);
	}

	public static JsonObject newSuccess() {
		return new JsonObject().
			put("status", "OK");
	}

	public static JsonObject generateSuccess(final Object content) {
		final JsonObject reply = new JsonObject();
		reply.put(RESULT, SUCCESS);
		reply.put(CONTENT, content);
		return reply;
	}

	public static JsonObject generateFail(final Object cause) {
		final JsonObject reply = new JsonObject();
		reply.put(RESULT, FAIL);
		if (cause != null && ((cause instanceof Throwable) && ((Throwable) cause).getMessage() != null))
			reply.put(CAUSE, ((Throwable) cause).getMessage());
		return reply;
	}

	public static boolean isSuccess(Message<Object> message) {
		final Object body = message.body();
		if (body instanceof JsonObject) {
			final String result = ((JsonObject) body).getString(RESULT);
			return result != null && SUCCESS.equals(result);
		}
		return false;
	}

	public static boolean isFail(Message<Object> message) {
		final Object body = message.body();
		if (body instanceof JsonObject) {
			final String result = ((JsonObject) body).getString(RESULT);
			return result != null && FAIL.equals(result);
		}
		return false;
	}
}