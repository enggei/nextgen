package com.nextgen.tests.util;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer;
import io.vertx.core.AsyncResult;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.eventbus.DeliveryOptions;
import io.vertx.core.eventbus.Message;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.json.JsonObject;
import io.vertx.core.shareddata.LocalMap;
import io.vertx.core.shareddata.SharedData;
import org.slf4j.Logger;

import java.util.concurrent.atomic.AtomicLong;


/**
 * NextGen core Vertx utils 10.01.17
 *
 * Vert.x: http://vertx.io/docs/
 */
public class VertxUtil {

	private static final int KB = 1024;
	private static final int MB = 1024 * KB;

	private static final MetricRegistry metricRegistry = new MetricRegistry();

	private static final AtomicLong NO_VERTICLES = new AtomicLong();

	public static long MB(int size) {
		return (long) (size * MB);
	}

	public static String getBody(AsyncResult<Message<JsonObject> > result) {
		final Message<JsonObject> message = result.result();
		return (message != null ? (message.body() != null ? message.body().encode() : message.toString()) : "UNKNOWN ERROR");
	}

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

	public static void putInClusterMap(Vertx vertx, Logger log, String mapName, String key, Object value, SuccessHandler<Void> successHandler) {

		vertx.sharedData().getClusterWideMap(mapName, result -> {

			if (result.failed()) {

				log.error("could not get clusterWiteMap '" + mapName + "'");

				successHandler.onFail(new AsyncResult<Void>() {
					@Override
					public Void result() {
						return null;
					}

					@Override
					public Throwable cause() {
						return result.cause();
					}

					@Override
					public boolean succeeded() {
						return result.succeeded();
					}

					@Override
					public boolean failed() {
						return result.failed();
					}
				});
				return;
			}

			result.result().put(key, value, resultPut -> {

				if (resultPut.failed()) {
					log.error("could not store " + key + " (" + value + ") in " + mapName);
					successHandler.onFail(resultPut);
					return;
				}

				log.info(key + " stored in sessions");
				successHandler.onSuccess(resultPut);
			});
		});
	}

	@SuppressWarnings("unchecked")
	public static <V> void removeFromClusterMap(Vertx vertx, Logger log, String mapName, String key, SuccessHandler<V> successHandler) {

		vertx.sharedData().getClusterWideMap(mapName, result -> {

			if (result.failed()) {

				log.error("could not get clusterWideMap '" + mapName + "'");

				successHandler.onFail(new AsyncResult<V>() {
					@Override
					public V result() {
						return null;
					}

					@Override
					public Throwable cause() {
						return result.cause();
					}

					@Override
					public boolean succeeded() {
						return result.succeeded();
					}

					@Override
					public boolean failed() {
						return result.failed();
					}
				});
				return;
			}

			result.result().remove(key, resultGet -> {

				if (resultGet.failed()) {
					log.error("could not remove '" + key + "' from '" + mapName + "'");
					successHandler.onFail((AsyncResult<V>) resultGet);
					return;
				}

				log.info("'" + key + "' removed from '" + mapName + "'");
				successHandler.onSuccess((AsyncResult<V>) resultGet);
			});
		});
	}

	@SuppressWarnings("unchecked")
	public static <V> void getFromClusterMap(Vertx vertx, Logger log, String mapName, String key, SuccessHandler<V> successHandler) {

		vertx.sharedData().getClusterWideMap(mapName, result -> {

			if (result.failed()) {

				log.error("could not get clusterWideMap '" + mapName + "'");

				successHandler.onFail(new AsyncResult<V>() {
					@Override
					public V result() {
						return null;
					}

					@Override
					public Throwable cause() {
						return result.cause();
					}

					@Override
					public boolean succeeded() {
						return result.succeeded();
					}

					@Override
					public boolean failed() {
						return result.failed();
					}
				});
				return;
			}

			result.result().get(key, resultGet -> {

				if (resultGet.failed()) {
					log.error("could not get '" + key + "' from '" + mapName + "'");
					successHandler.onFail((AsyncResult<V>) resultGet);
					return;
				}

				if (resultGet.result() == null) {
					log.error("could not get '" + key + "' from '" + mapName + "', its null.");
					successHandler.onFail(new AsyncResult<V>() {
						@Override
						public V result() {
							return null;
						}

						@Override
						public Throwable cause() {
							return new Throwable("'" + key + "'" + " has null-value in '" + mapName + "'");
						}

						@Override
						public boolean succeeded() {
							return false;
						}

						@Override
						public boolean failed() {
							return true;
						}
					});
					return;
				}

				log.info("'" + key + "' found in '" + mapName + "'");
				successHandler.onSuccess((AsyncResult<V>) resultGet);
			});
		});
	}


	public interface SuccessHandler<T> {

		void onSuccess(AsyncResult<T> result);

		void onFail(AsyncResult<T> result);

	}

	public interface Executor<R, T> extends SuccessHandler<T> {

		R execute();
	}

	@SuppressWarnings("unchecked")
	public static <R> void executeBlocking(Vertx vertx, Logger log, Executor<R, R> executor) {

		// todo check if using metricRegistry like this is the best
		final Timer timer = metricRegistry.timer("Blocking timer");
		final Timer.Context time = timer.time();

		vertx.executeBlocking(future -> {

			final R result = executor.execute();

			if (result == null) future.complete();
			else future.complete(result);

		}, res -> {

			time.stop();

			if (res.failed()) {
				executor.onFail((AsyncResult<R>) res);
				return;
			}

			executor.onSuccess((AsyncResult<R>) res);
		});
	}

	public static <T> void consume(Vertx vertx, String deploymentId, String address, Logger log, Handler<Message<T> > messageHandler) {
		log.info(deploymentId + " listening for '" + address + "' messages");
		vertx.eventBus().consumer(address, messageHandler);
	}

	public static <T> void sendMessage(Vertx vertx, String address, JsonObject content, Logger log, SuccessHandler<Message<T> > handler) {
		sendMessage(vertx, address, content, null, log, handler);
	}

	public static <T> void sendMessage(Vertx vertx, String address, JsonObject content, DeliveryOptions options, Logger log, SuccessHandler<Message<T> > handler) {

		if (options == null) options = new DeliveryOptions();

		vertx.eventBus().<T>send(address, content, options, result -> {

			if (result.failed()) {
				log.error("error sending message '" + content.encode() + "' to '" + address + "' : " + result.cause(), result.cause());
				handler.onFail(result);
				return;
			}

			log.debug(content.encode() + " sent to " + address + " " + result.result().body());
			handler.onSuccess(result);
		});
	}

	public static void undeploy(Vertx vertx, Logger log, String deploymentId, SuccessHandler<Void> handler) {

		vertx.undeploy(deploymentId, result -> {

			if (result.failed()) {
				handler.onFail(result);
				log.error("could not UNDEPLOY '" + deploymentId + "'", result.cause());
				return;
			}

			log.info("Undeployed " + deploymentId + " (" + NO_VERTICLES.decrementAndGet() + ")");
			handler.onSuccess(result);
		});
	}

	public static void deploy(Vertx vertx, Class verticleClass, DeploymentOptions deploymentOptions, Logger log, SuccessHandler<String> handler) {
		deploy(vertx, verticleClass.getCanonicalName(), deploymentOptions, log, handler);
	}

	public static void deploy(Vertx vertx, String className, DeploymentOptions deploymentOptions, Logger log, SuccessHandler<String> handler) {

		if (deploymentOptions == null) deploymentOptions = new DeploymentOptions();

		vertx.deployVerticle(className, deploymentOptions, result -> {

			if (result.failed()) {
				handler.onFail(result);
				log.error("could not DEPLOY VERTICLE '" + className + "'", result.cause());
				return;
			}

			log.info(className + " deployed (" + NO_VERTICLES.incrementAndGet() + ")");
			handler.onSuccess(result);
		});
	}

	public static void deploy(Vertx vertx, Class verticleClass, Logger log, SuccessHandler<String> handler) {
		deploy(vertx, verticleClass.getCanonicalName(), log, handler);
	}

	public static void deploy(Vertx vertx, Class verticleClass, JsonObject config, Logger log, SuccessHandler<String> handler) {
		deploy(vertx, verticleClass.getCanonicalName(), config, log, handler);
	}

	public static void deploy(Vertx vertx, String verticleClass, Logger log, SuccessHandler<String> handler) {
		deploy(vertx, verticleClass, new DeploymentOptions(), log, handler);
	}

	public static void deploy(Vertx vertx, String verticleClass, JsonObject config, Logger log, SuccessHandler<String> handler) {

		final DeploymentOptions deploymentOptions = new DeploymentOptions();
		if (config != null) deploymentOptions.setConfig(config);

		deploy(vertx, verticleClass, deploymentOptions, log, handler);
	}

	/**
	 * Resolves HTTP request remote IP.
	 *
	 * @param request HTTP request
	 * @return IP address
	 */
	public static String getRemoteIP(HttpServerRequest request) {
		if (request.headers().contains("X-Forwarded-For"))
			return request.headers().get("X-Forwarded-For");

		return request.remoteAddress().host();
	}
}