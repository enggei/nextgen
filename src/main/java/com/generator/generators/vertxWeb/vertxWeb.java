package com.generator.generators.vertxWeb;

import com.generator.editors.domain.NeoModel;
import com.generator.editors.domain.*;

import org.neo4j.graphdb.*;

import static com.generator.editors.domain.MetaRelation.Cardinality.*;
import static com.generator.editors.domain.MetaRelation.Direction.*;

import java.util.*;

import static com.generator.generators.vertxWeb.vertxWeb.ENTITIES.*;
import static com.generator.generators.vertxWeb.vertxWeb.RELATIONS.*;

/**
 * 
 */
public class vertxWeb extends MetaDomain<vertxWeb.ENTITIES, vertxWeb.RELATIONS> {

    public enum ENTITIES {
        HTTPServer, Router, HandlerThrowable, Route, RequestHandler, StaticHandler, FaviconHandler
    }

    public enum RELATIONS implements RelationshipType {
        ROUTES, EXCEPTIONHANDLER, ROUTE, HANDLER
    }

    public vertxWeb(final NeoModel model) {
        super(model, "vertxWeb");

        try (Transaction tx = model.beginTx()) {

            addMetaNode(ENTITIES.HTTPServer, UUID.randomUUID());
            addMetaNode(ENTITIES.Router, UUID.randomUUID());
            addMetaNode(ENTITIES.HandlerThrowable, UUID.randomUUID());
            addMetaNode(ENTITIES.Route, UUID.randomUUID())
                    .addProperty(new MetaProperty("uri").setType("String"));
            addMetaNode(ENTITIES.RequestHandler, UUID.randomUUID());
            addMetaNode(ENTITIES.StaticHandler, UUID.randomUUID())
                    .addProperty(new MetaProperty("cachingEnabled").setType("Boolean"))
                    .addProperty(new MetaProperty("includeHidden").setType("Boolean"))
                    .addProperty(new MetaProperty("maxAgeSeconds").setType("Integer"))
                    .addProperty(new MetaProperty("webRoot").setType("String"));
            addMetaNode(ENTITIES.FaviconHandler, UUID.randomUUID())
                    .addProperty(new MetaProperty("path").setType("String"));

            addMetaRelation(ROUTES, newNodeSet(HTTPServer), newNodeSet(Router), OneToOne, OneWay);
            addMetaRelation(EXCEPTIONHANDLER, newNodeSet(Router), newNodeSet(HandlerThrowable), OneToOne, OneWay);
            addMetaRelation(ROUTE, newNodeSet(Router), newNodeSet(Route), OneToMany, OneWay);
            addMetaRelation(HANDLER, newNodeSet(Route), newNodeSet(FaviconHandler,RequestHandler,StaticHandler), OneToOne, OneWay);

            validate();

            tx.success();
        }
    }

    @Override
    protected final ENTITIES entity(String s) {
        return ENTITIES.valueOf(s);
    }

    @Override
    protected final RELATIONS relation(String s) {
        return RELATIONS.valueOf(s);
    }

    @Override
    public final MetaNode<ENTITIES> getRootNode() {
        return getNode(HTTPServer);
    }

    @Override
    public final boolean isConstrained(Node node) {
        return super.isConstrained(node);
    }
    public Node addHTTPServer(UUID uuid) {
        return newNode(ENTITIES.HTTPServer, uuid);
    }
    public Node addRouter(UUID uuid) {
        return newNode(ENTITIES.Router, uuid);
    }
    public Node addHandlerThrowable(UUID uuid) {
        return newNode(ENTITIES.HandlerThrowable, uuid);
    }
    public Node addRoute(UUID uuid, String _uri) {
        return newNode(ENTITIES.Route, uuid, "uri", (_uri == null || _uri.trim().length()==0) ? "[]" : _uri);
    }
    public Node addRequestHandler(UUID uuid) {
        return newNode(ENTITIES.RequestHandler, uuid);
    }
    public Node addStaticHandler(UUID uuid, String _cachingEnabled, String _includeHidden, String _maxAgeSeconds, String _webRoot) {
        return newNode(ENTITIES.StaticHandler, uuid, "cachingEnabled", (_cachingEnabled == null || _cachingEnabled.trim().length()==0) ? "[]" : _cachingEnabled, "includeHidden", (_includeHidden == null || _includeHidden.trim().length()==0) ? "[]" : _includeHidden, "maxAgeSeconds", (_maxAgeSeconds == null || _maxAgeSeconds.trim().length()==0) ? "[]" : _maxAgeSeconds, "webRoot", (_webRoot == null || _webRoot.trim().length()==0) ? "[]" : _webRoot);
    }
    public Node addFaviconHandler(UUID uuid, String _path) {
        return newNode(ENTITIES.FaviconHandler, uuid, "path", (_path == null || _path.trim().length()==0) ? "[]" : _path);
    }


    public vertxWeb relateHTTPServer_Routes_Router(Node httpserverSrc, Node routerDst) {
        relate(RELATIONS.ROUTES, httpserverSrc, routerDst);
        return this;
    } 



    public vertxWeb relateRouter_ExceptionHandler_HandlerThrowable(Node routerSrc, Node handlerthrowableDst) {
        relate(RELATIONS.EXCEPTIONHANDLER, routerSrc, handlerthrowableDst);
        return this;
    } 



    public vertxWeb relateRouter_Route_Route(Node routerSrc, Node routeDst) {
        relate(RELATIONS.ROUTE, routerSrc, routeDst);
        return this;
    } 



    public vertxWeb relateRoute_Handler_FaviconHandler(Node routeSrc, Node faviconhandlerDst) {
        relate(RELATIONS.HANDLER, routeSrc, faviconhandlerDst);
        return this;
    } 


    public vertxWeb relateRoute_Handler_StaticHandler(Node routeSrc, Node statichandlerDst) {
        relate(RELATIONS.HANDLER, routeSrc, statichandlerDst);
        return this;
    } 


    public vertxWeb relateRoute_Handler_RequestHandler(Node routeSrc, Node requesthandlerDst) {
        relate(RELATIONS.HANDLER, routeSrc, requesthandlerDst);
        return this;
    } 

}