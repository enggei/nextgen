package com.generator.generators.easyFlow.vertx;

import com.generator.neo.embedded.EmbeddedNeoModel;
import com.generator.neo.vertx.NeoVerticle;
import com.generator.util.NeoUtil;
import io.vertx.core.json.JsonObject;
import org.neo4j.graphdb.Node;

import java.util.UUID;

/**
 * Created 19.12.17.
 */
public class EasyFlowDomainVisitor implements NeoVerticle.NeoVisitor {

   protected final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(EasyFlowDomainVisitor.class);

   @Override
   public Object visit(EmbeddedNeoModel model, JsonObject params) throws Throwable {
      log.info("visitor with params " + params);

      final Node node = model.getNode(UUID.fromString(params.getString("uuid")));
      if(node!=null) {
         log.info("found node " + NeoUtil.labelsFor(node));
         return NeoUtil.labelsFor(node);
      }

      return "Node not found";
   }
}