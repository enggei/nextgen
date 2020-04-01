package com.generator.generators.json;

import com.generator.app.App;
import com.generator.app.NodeRenderPanel;
import com.generator.app.nodes.NeoNode;
import com.generator.generators.json.parser.JSONLexer;
import com.generator.generators.json.parser.JSONNodeListener;
import com.generator.generators.json.parser.JSONParser;
import com.generator.util.NeoUtil;
import com.generator.util.SwingUtil;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.Transaction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created 03.11.17.
 */
public class JsonPlugin extends JsonDomainPlugin {

   private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(JsonPlugin.class);

   private static final JsonGroup jsonGroup = new JsonGroup();

   public JsonPlugin(App app) {
      super(app);
   }

   @Override
   protected void addActionsTo(JMenu menu) {

      addShowMenu(menu, Entities.Json);

      menu.add(new App.TransactionAction("Create Pojo from Json", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final JTextArea txtEditor = SwingUtil.newTextArea();
            txtEditor.setPreferredSize(new Dimension(800, 640));

            SwingUtil.showTextInput("Json", txtEditor, app, new SwingUtil.ConfirmAction("Generate") {
               @Override
               public void verifyAndCommit() throws Exception {

                  final JSONParser parser = new JSONParser(new CommonTokenStream(new JSONLexer(CharStreams.fromString(txtEditor.getText()))));
                  final JSONNodeListener listener = new JSONNodeListener(true) {

                     @Override
                     protected void onEnter(Node node) {

                        if (!nodeStack.isEmpty())
                           log.info(nodeStack.peek().name + " -> " + node.name);
                        super.onEnter(node);
                     }

                     @Override
                     public void exitPair(JSONParser.PairContext arg) {

                        final String key = nodeStack.peek().startToken;
                        final String value = nodeStack.peek().children.iterator().next().startToken;
                        log.info(key + " : " + value);
                        super.exitPair(arg);
                     }
                  };
                  new ParseTreeWalker().walk(listener, parser.json());

               }
            });
         }
      });
   }

   @Override
   protected JComponent newJsonEditor(NeoNode jsonNode) {
      return new NodeRenderPanel(jsonNode) {
         @Override
         protected String render(Node node) {
            final JsonGroup.documentST documentST = jsonGroup.newdocument();

            outgoingSTRING(node, (relationship, stringNode) -> {
               documentST.addContentValue(renderString(stringNode));
            });

            outgoingNUMBER(node, (relationship, numberNode) -> {
               documentST.addContentValue(renderNumber(numberNode));
            });

            outgoingOBJ(node, (relationship, objectNode) -> {
               documentST.addContentValue(renderObject(objectNode));
            });

            outgoingARRAY(node, (relationship, arrayNode) -> {
               documentST.addContentValue(renderArray(arrayNode));
            });

            return documentST.toString();
         }
      };
   }

   @Override
   protected JComponent newArrayEditor(NeoNode arrayNode) {
      return new NodeRenderPanel(arrayNode) {
         @Override
         protected String render(Node node) {
            return renderArray(node);
         }
      };
   }

   @Override
   protected JComponent newObjectEditor(NeoNode objectNode) {
      return new NodeRenderPanel(objectNode) {
         @Override
         protected String render(Node node) {
            return renderObject(node);
         }
      };
   }

   @Override
   protected JComponent newStringEditor(NeoNode stringNode) {
      return new NodeRenderPanel(stringNode) {
         @Override
         protected String render(Node node) {
            return renderString(node);
         }
      };
   }

   @Override
   protected JComponent newNumberEditor(NeoNode numberNode) {
      return new NodeRenderPanel(numberNode) {
         @Override
         protected String render(Node node) {
            return renderNumber(node);
         }
      };
   }

   @Override
   protected JComponent newPairEditor(NeoNode pairNode) {
      return new NodeRenderPanel(pairNode) {
         @Override
         protected String render(Node node) {
            final JsonGroup.objectST objectST = jsonGroup.newobject();
            final String key = getKeyProperty(node);
            if (isObject(node)) {
               objectST.addPairsValue(key, renderObject(node));
            } else if (isArray(node)) {
               objectST.addPairsValue(key, renderArray(node));
            } else if (isString(node)) {
               objectST.addPairsValue(key, renderString(node));
            } else if (isNumber(node)) {
               objectST.addPairsValue(key, renderNumber(node));
            }
            return objectST.toString();
         }
      };
   }

   public static String renderString(Node stringNode) {
      return jsonGroup.newprimitiveString().setValue(getValueProperty(stringNode)).toString();
   }

   public static String renderNumber(Node numberNode) {
      return jsonGroup.newprimitive().setValue(getValueProperty(numberNode)).toString();
   }

   public static String renderObject(Node objectNode) {

      final JsonGroup.objectST objectST = jsonGroup.newobject();

      outgoingPAIR(objectNode, (relationship, pairNode) -> {

         final String key = getKeyProperty(pairNode);
         final Node valueNode = singleOutgoingVALUE(pairNode);

         if (isObject(valueNode)) {
            objectST.addPairsValue(key, renderObject(valueNode));
         } else if (isArray(valueNode)) {
            objectST.addPairsValue(key, renderArray(valueNode));
         } else if (isString(valueNode)) {
            objectST.addPairsValue(key, renderString(valueNode));
         } else if (isNumber(valueNode)) {
            objectST.addPairsValue(key, renderNumber(valueNode));
         }
      });

      return objectST.toString();
   }

   public static String renderArray(Node arrayNode) {

      final JsonGroup.arrayST arrayST = jsonGroup.newarray();

      outgoingELEMENTS(arrayNode, (relationship, elementNode) -> {
         if (isObject(elementNode)) {
            arrayST.addElementsValue(renderObject(elementNode));
         } else if (isArray(elementNode)) {
            arrayST.addElementsValue(renderArray(elementNode));
         } else if (isString(elementNode)) {
            arrayST.addElementsValue(renderString(elementNode));
         } else if (isNumber(elementNode)) {
            arrayST.addElementsValue(renderNumber(elementNode));
         }
      });

      return arrayST.toString();
   }
}