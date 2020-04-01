package com.generator;

import com.generator.util.PasswordUtils;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class CreateConfig {

    public static void main(String[] args) throws IOException {

        testGraph();

        if (args.length == 0)
            System.out.println("Optional parameters: [host|127.0.0.1] [port|8080] [dbDir|.db_nextgen]");

        final String host = args.length == 0 ? "127.0.0.1" : args[0];
        final Integer port = args.length == 0 ? 8080 : Integer.valueOf(args[1]);
        final String path = args.length == 0 ? "./db_nextgen" : args[3];

        final JsonObject config = new JsonObject().
                put("path", path).
                put("tcpHost", host).
                put("port", port).
                put("web.root", "components/core/target").
                put("jwt.store.path", "jwtStore.jceks").
                put("jwt.store.password", "jwtPassword").
                put("jwt.store.type", "jceks").
                put("ssl.store.path", "sslStore.jceks").
                put("ssl.store.password", "sslPassword");

        final JsonArray users = new JsonArray();
        users.add(newUser("geirove", "geirove"));
        users.add(newUser("test", "test"));
        users.add(newUser("ernst", "ernst"));
        config.put("users", users);

        final FileWriter writer = new FileWriter(new File("components/core/src/main/resources/conf.json"));
        writer.write(config.encodePrettily());
        writer.close();
    }

    private static void testGraph() throws IOException {
//        this.boxMap.set("ce9131ee-f528-4952-a012-543780c5e66d", new BoxModel("ce9131ee-f528-4952-a012-543780c5e66d","Rotterdam", 10, 10));
//        this.boxMap.set("14194d76-aa31-45c5-a00c-104cc550430f", new BoxModel("14194d76-aa31-45c5-a00c-104cc550430f","Bratislava", 10, 10));
//
//        this.arrows.push(new ArrowModel("7b5d33c1-5e12-4278-b1c5-e4ae05c036bd", this.boxMap.get("ce9131ee-f528-4952-a012-543780c5e66d"), this.boxMap.get("14194d76-aa31-45c5-a00c-104cc550430f")));

        final JsonObject response = new JsonObject();
        final JsonArray nodes = new JsonArray();
        final JsonArray links = new JsonArray();

        final Random random = new Random();

        final String[] nodeArray = new String[200];
        for (int i = 0; i < nodeArray.length; i++) {
            nodeArray[i] = UUID.randomUUID().toString();
            nodes.add(new JsonObject().put("id", nodeArray[i]).put("code", "this.boxMap.set(\"" + nodeArray[i] + "\", new BoxModel(\"" + nodeArray[i] + "\",\"Node " + (i + 1) + "\", " + random.nextInt(800) + ", " + random.nextInt(800) + "));"));
        }

        for (String node : nodeArray) {
            int nRel = random.nextInt(nodeArray.length / 2) + 1;
            for (int j = 0; j < nRel; j++) {
                final String targetNode = nodeArray[random.nextInt(nodeArray.length - 1)];
                if (targetNode.equals(node)) continue;
                links.add(new JsonObject().put("source", node).put("target", targetNode).put("code", "this.arrows.push(new ArrowModel(\"" + UUID.randomUUID().toString() + "\", this.boxMap.get(\"" + node + "\"), this.boxMap.get(\"" + targetNode + "\")));"));
            }
        }

        final BufferedWriter out = new BufferedWriter(new FileWriter(new File("/home/goe/projects/nextgen/components/core/src/test/java/com/generator/graph.txt")));

        for (Object node : nodes) {
            out.write(((JsonObject)node).getString("code"));
            out.newLine();
        }
        for (Object link : links) {
            out.write(((JsonObject)link).getString("code"));
            out.newLine();
        }
        out.close();
    }

    private static JsonObject newUser(String username, String password) {
        final String salt = PasswordUtils.getSalt(10);
        return new JsonObject().put("username", username).put("password", PasswordUtils.generateSecurePassword(username, salt)).put("salt", salt);
    }
}
