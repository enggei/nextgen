package com.generator.generators.json;

import com.generator.ProjectConstants;
import com.generator.generators.java.JavaGroup;
import com.generator.generators.json.parser.JSONLexer;
import com.generator.generators.json.parser.JSONNodeListener;
import com.generator.generators.json.parser.JSONParser;
import com.generator.util.StringUtil;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.jetbrains.annotations.NotNull;
import org.junit.Test;

import java.io.IOException;
import java.util.*;

/**
 * Created 08.09.17.
 */
public class Tests {
   private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(Tests.class);


   //@Test
   public void testJsonGenerator() {

      final JsonGroup jsonGroup = new JsonGroup();

      log.info(jsonGroup.newdocument().
            addContentValue(jsonGroup.newobject().
                  addPairsValue("name","value")).toString());

   }

   //@Test
   public void testPojoGenerator() throws IOException {

      final JavaGroup javaGroup = new JavaGroup();

      final JavaGroup.PojoST pojoST = javaGroup.newPojo().setPackage("com.test.ud").setName("JsonTest");

      final Set<String> uniquePaths = new TreeSet<>();

      final JSONParser parser = new JSONParser(new CommonTokenStream(new JSONLexer(CharStreams.fromFileName(ProjectConstants.GENERATORS_ROOT + "json/todo.txt"))));
      final JSONNodeListener listener = new JSONNodeListener(true) {

         private final List<String> path = new ArrayList<>();
         private Stack<String> valueTypeStack = new Stack<>();

         @Override
         protected void onEnter(Node node) {

            path.add((path.isEmpty() ? "" : " -> ") + node.name);

            super.onEnter(node);
         }

         @Override
         protected void onExit() {

            final String currentPath = getPath();
            uniquePaths.add(currentPath);

            path.remove(path.size() - 1);
            super.onExit();
         }

         @NotNull
         private String getPath() {
            final StringBuilder currentPath = new StringBuilder();
            for (String s : path) currentPath.append(s);
            return currentPath.toString();
         }

         @Override
         public void exitPair(JSONParser.PairContext arg) {

            final String key = nodeStack.peek().startToken;
            final String value = valueTypeStack.pop();

            if(getPath().equals("Json -> Value -> Obj -> Pair"))
               pojoST.addPropertiesValue(null, value, StringUtil.trimEnds(1, key));

            super.exitPair(arg);
         }

         @Override
         public void exitValue(JSONParser.ValueContext arg) {

            final Set<Node> children = nodeStack.peek().children;
            if(children.isEmpty()) {
               if(nodeStack.peek().startToken.startsWith("\"")) {
                  valueTypeStack.push("String");
               } else {
                  valueTypeStack.push("Integer");
               }

            } else {

               final Node child = children.iterator().next();

               if(child.name.equals("Array")) {
                  valueTypeStack.push("Array");
               } else if(child.name.equals("Obj")) {
                  valueTypeStack.push("Obj");
               } else {
                  valueTypeStack.push("?");
               }
            }

            super.exitValue(arg);
         }
      };
      new ParseTreeWalker().walk(listener, parser.json());

      for (String uniquePath : uniquePaths) {
         log.info(uniquePath);
      }

      log.info(pojoST.toString());

   }

   //@Test
   public void testParser() throws IOException {
      final JSONParser parser = new JSONParser(new CommonTokenStream(new JSONLexer(CharStreams.fromFileName(ProjectConstants.GENERATORS_ROOT + "json/example.json"))));
      final JSONNodeListener listener = new JSONNodeListener(true);
      new ParseTreeWalker().walk(listener, parser.json());
   }
}