package com.generator;

import com.generator.util.PasswordUtils;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

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
        users.add(newUser("ernst", "ernst"));
        config.put("users", users);

        final FileWriter writer = new FileWriter(new File("components/core/src/main/resources/conf.json"));
        writer.write(config.encodePrettily());
        writer.close();
    }

    private static void testGraph() {
//        const data = {
//                nodes: [{ id: 'Harry' }, { id: 'Sally' }, { id: 'Alice' }],
//        links: [{ source: 'Harry', target: 'Sally' }, { source: 'Harry', target: 'Alice' }]
//        };

        final StringBuilder nodeJs = new StringBuilder("nodes: [");
        final StringBuilder linksJS = new StringBuilder("links: [");

        final String[] nodes = new String[20];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = UUID.randomUUID().toString().substring(0, 8);
            if (i > 0) nodeJs.append(", ");
            nodeJs.append("{ id: '" + nodes[i] + "' }");
        }
        nodeJs.append("],");

        final Random random = new Random();
        boolean first = true;
        for (int i = 0; i < nodes.length; i++) {
            int nRel = random.nextInt(nodes.length/2 ) + 1;
            for (int j = 0; j < nRel; j++) {
                final String targetNode = nodes[random.nextInt(nodes.length - 1)];
                if (targetNode.equals(nodes[i])) continue;
                if (!first) linksJS.append(", ");
                linksJS.append("{ source: '" + nodes[i] + "', target: '" + targetNode + "' }");
                first = false;
            }
        }
        linksJS.append("]");

        System.out.println(nodeJs);
        System.out.println(linksJS);
    }

    private static JsonObject newUser(String username, String password) {
        final String salt = PasswordUtils.getSalt(10);
        return new JsonObject().put("username", username).put("password", PasswordUtils.generateSecurePassword(username, salt)).put("salt", salt);
    }
}
