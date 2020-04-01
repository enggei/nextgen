package com.nextgen.server;

import com.generator.util.PasswordUtils;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.RoutingContext;

import java.util.Random;
import java.util.UUID;

public class FrontendVerticleImpl extends FrontendVerticle {

    @Override
    protected boolean verifyUserPassword(String providedPassword, String securedPassword, String salt) {
        return PasswordUtils.verifyUserPassword(providedPassword, securedPassword, salt);
    }

    protected void getLastGraph(RoutingContext routingContext) {
        debug(routingContext);

        final JsonObject response = new JsonObject();
        final JsonArray nodes = new JsonArray();
        final JsonArray links = new JsonArray();

        final String[] nodeArray = new String[20];
        for (int i = 0; i < nodeArray.length; i++) {
            nodeArray[i] = UUID.randomUUID().toString().substring(0, 8);
            nodes.add(new JsonObject().put("id", nodeArray[i]));
        }

        final Random random = new Random();
        for (String node : nodeArray) {
            int nRel = random.nextInt(nodeArray.length / 2) + 1;
            for (int j = 0; j < nRel; j++) {
                final String targetNode = nodeArray[random.nextInt(nodeArray.length - 1)];
                if (targetNode.equals(node)) continue;
                links.add(new JsonObject().put("source", node).put("target", targetNode));
            }
        }

        response.put("nodes", nodes);
        response.put("links", links);
        sendOKResponse(routingContext, response);
    }
}