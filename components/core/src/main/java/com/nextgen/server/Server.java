package com.nextgen.server;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Server extends AbstractVerticle {

    public static void main(String[] args) throws IOException {

        final String configPath = args.length == 0 ? ("components/core/src/main/resources/conf.json") : args[0];
        if (args.length == 0)
            System.out.println("using config file '" + configPath + "'");

        BufferedReader reader = new BufferedReader(new FileReader(new File(configPath)));
        String line;
        final StringBuilder configData = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            configData.append(line);
        }
        reader.close();

        final JsonObject config = new JsonObject(configData.toString());

        // start vertx
        final Vertx vertx = Vertx.vertx();

        // setup verticles to be deployed when starting server
        final JsonArray verticles = new JsonArray();

        // front-end verticle (handles api requests from webfrontend
        verticles.add(new JsonObject().
                put("verticle", FrontendVerticleImpl.class.getCanonicalName()).
                put("config", config));

        // pack verticles as configuration and start server
        final JsonObject serverConfig = new JsonObject();
        serverConfig.put("verticles", verticles);

        vertx.deployVerticle(Server.class, new DeploymentOptions().setConfig(serverConfig), result -> {
            if (result.failed())
                result.cause().printStackTrace();
            else
                System.out.println("server started " + result.result() + " using " + serverConfig.encode());
        });
    }

    @Override
    public void start() throws Exception {

        // Deploy verticles for server

        for (Object v : config().getJsonArray("verticles")) {
            final JsonObject verticle = (JsonObject) v;

            final Class verticleClass = Class.forName(verticle.getString("verticle"));
            vertx.deployVerticle(verticleClass, new DeploymentOptions().setConfig(verticle.getJsonObject("config")), result -> {
                if (result.failed())
                    result.cause().printStackTrace();
                else
                    System.out.println(verticleClass.getCanonicalName() + " deployed " + result.result());
            });
        }
    }
}