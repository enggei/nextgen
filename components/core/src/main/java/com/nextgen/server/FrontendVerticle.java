package com.nextgen.server;

import com.generator.util.PasswordUtils;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.MultiMap;
import io.vertx.core.http.HttpHeaders;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.core.net.JksOptions;
import io.vertx.ext.auth.KeyStoreOptions;
import io.vertx.ext.auth.jwt.JWTAuth;
import io.vertx.ext.auth.jwt.JWTAuthOptions;
import io.vertx.ext.jwt.JWTOptions;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;
import io.vertx.ext.web.handler.JWTAuthHandler;
import io.vertx.ext.web.handler.SessionHandler;
import io.vertx.ext.web.handler.StaticHandler;
import io.vertx.ext.web.sstore.LocalSessionStore;

import java.util.Map;

public class FrontendVerticle extends AbstractVerticle {

    protected final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(FrontendVerticle.class);

    protected static final String JSON_CONTENT_TYPE = "application/json; charset=utf-8";

    private JsonObject config;

    @Override
    public void start(Future<Void> startFuture) throws Exception {
        log.info("starting FrontendVerticle using config " + config());

        this.config = config();

        final Router router = Router.router(vertx);

        router.route().handler(BodyHandler.create());
        router.route().handler(SessionHandler.create(LocalSessionStore.create(vertx)));

        final KeyStoreOptions keyStoreOptions = new KeyStoreOptions().
                setPath(config().getString("jwt.store.path")).
                setPassword(config().getString("jwt.store.password")).
                setType(config().getString("jwt.store.type", "jceks"));

        final JWTAuthOptions jwtAuthOptions = new JWTAuthOptions().setKeyStore(keyStoreOptions);
        final JWTAuth auth = JWTAuth.create(vertx, jwtAuthOptions);

        router.post("/login").handler(routingContext -> login(routingContext, auth));
        router.get("/user").handler(this::getUser);
        router.route("/api/*").handler(JWTAuthHandler.create(auth, "/login"));

        final StaticHandler staticHandler = StaticHandler.create();
        staticHandler.setWebRoot(config.getString("web.root"));
        router.route("/*").handler(staticHandler);

        final HttpServerOptions serverOptions = new HttpServerOptions().
                setSsl(true).
                setKeyStoreOptions(new JksOptions().
                        setPath(config().getString("ssl.store.path")).
                        setPassword(config().getString("ssl.store.password")));

        vertx.createHttpServer(serverOptions).requestHandler(router::accept).listen(config().getInteger("port"));

        log.info("serving on port " + config().getInteger("port"));
        startFuture.complete();
    }

    private void getUser(RoutingContext routingContext) {

        final String authorization = routingContext.request().getHeader("Authorization");
        final String token = authorization == null ? null : authorization.substring(7).trim();

        final JsonObject response = new JsonObject();
        final JsonArray users = config.getJsonArray("users");
        for (Object o : users) {
            final JsonObject user = (JsonObject) o;

            if (user.getString("token","").equals(token)) {

                response.put("user", new JsonObject().
                        put("token", token).
                        put("username", user.getString("username")).
                        put("bio", "bio").
                        put("image", ""));
                sendOKResponse(routingContext, response);
                return;
            }
        }

        sendErrorResponse(routingContext, new JsonObject().put("message", "user not found"));
    }

    private void login(RoutingContext routingContext, JWTAuth authProvider) {

        debug(routingContext);

        final JsonObject bodyAsJson = routingContext.getBodyAsJson();

        final JsonObject response = new JsonObject();

        final JsonArray users = config.getJsonArray("users");
        for (Object o : users) {
            final JsonObject user = (JsonObject) o;

            if (user.getString("username").equals(bodyAsJson.getString("username"))) {
                boolean passwordMatch = PasswordUtils.verifyUserPassword(bodyAsJson.getString("password"), user.getString("password"), user.getString("salt"));

                if (passwordMatch) {

                    final JsonObject payload = new JsonObject().put("sub", user.getString("username"));
                    final String token = authProvider.generateToken(payload, new JWTOptions().setExpiresInMinutes(120).setSubject(user.getString("username")));
                    user.put("token", token);

                    response.put("user", new JsonObject().
                            put("token", token).
                            put("username", user.getString("username")).
                            put("bio", "bio").
                            put("image", ""));
                    sendOKResponse(routingContext, response);
                    return;
                }
            }
        }

        sendErrorResponse(routingContext, errorMessage("user not found"));
    }

    protected void sendOKResponse(RoutingContext routingContext, JsonObject content) {
        final String encode = content.encode();
        log.info(routingContext.request().absoluteURI() + " response " + encode);
        routingContext.response().setStatusCode(HttpResponseStatus.OK.code())
                .putHeader(HttpHeaders.CONTENT_LENGTH, encode.length() + "")
                .putHeader(HttpHeaders.CONTENT_TYPE, JSON_CONTENT_TYPE)
                .end(encode);
    }

    protected void sendErrorResponse(RoutingContext routingContext, JsonObject content) {
        sendErrorResponse(routingContext, HttpResponseStatus.INTERNAL_SERVER_ERROR.code(), content);
    }

    protected JsonObject errorMessage(String... errors) {
        final JsonArray errorMessages = new JsonArray();
        for (String error : errors)
            errorMessages.add(error);
        return new JsonObject().put("errors", new JsonObject().put("error", errorMessages));
    }

    protected void sendErrorResponse(RoutingContext routingContext, int responseCode, JsonObject content) {
        final String encode = content.encode();
        log.info(routingContext.request().absoluteURI() + " response " + encode);
        routingContext.response().setStatusCode(responseCode)
                .putHeader(HttpHeaders.CONTENT_LENGTH, encode.length() + "")
                .putHeader(HttpHeaders.CONTENT_TYPE, JSON_CONTENT_TYPE)
                .end(encode);
    }

    protected static void debug(String method, RoutingContext routingContext) {
        final String uri = method + " " + routingContext.request().method().name() + " " + routingContext.request().uri();
        boolean isAuthenticated = routingContext.user() != null;
        log.info(uri + " " + (isAuthenticated ? "(authenticated)" : "(NOT authenticated)"));
        final MultiMap headers = routingContext.request().headers();
        for (Map.Entry<String, String> header : headers)
            log.info("\t" + header.getKey() + "=" + header.getValue());
        log.info("body " + routingContext.getBody().toString());

    }

    protected static void debug(RoutingContext routingContext) {
        debug("?", routingContext);
    }
}