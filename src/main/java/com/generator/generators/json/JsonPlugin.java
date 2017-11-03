package com.generator.generators.json;

import com.generator.app.App;
import com.generator.generators.json.parser.JSONLexer;
import com.generator.generators.json.parser.JSONNodeListener;
import com.generator.generators.json.parser.JSONParser;
import com.generator.util.SwingUtil;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.neo4j.graphdb.Transaction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created 03.11.17.
 */
public class JsonPlugin extends JsonDomainPlugin {

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
            txtEditor.setPreferredSize(new Dimension(800,640));

            SwingUtil.showTextInput("Json", txtEditor, app, new SwingUtil.ConfirmAction("Generate") {
               @Override
               public void verifyAndCommit() throws Exception {

                  final JSONParser parser = new JSONParser(new CommonTokenStream(new JSONLexer(CharStreams.fromString(txtEditor.getText()))));
                  final JSONNodeListener listener = new JSONNodeListener(true) {

                     @Override
                     protected void onEnter(Node node) {

                        if(!nodeStack.isEmpty())
                           System.out.println(nodeStack.peek().name + " -> " + node.name);
                        super.onEnter(node);
                     }

                     @Override
                     public void exitPair(JSONParser.PairContext arg) {

                        final String key = nodeStack.peek().startToken;
                        final String value = nodeStack.peek().children.iterator().next().startToken;
                        System.out.println(key + " : " + value);
                        super.exitPair(arg);
                     }
                  };
                  new ParseTreeWalker().walk(listener, parser.json());

               }
            });
         }
      });
   }
}