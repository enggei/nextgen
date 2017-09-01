package com.generator.generators.javareflection;

import com.generator.generators.antlr.parser.ANTLRv4ParserListener;
import com.generator.generators.mysql.parser.MySqlParserListener;
import com.generator.generators.templates.domain.GeneratedFile;

import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * Created 24.08.17.
 */
public class NeoBaseClassGenerator extends BaseClassVisitor {

   private final StringBuilder out = new StringBuilder();
   private final String packageName;
   private final String name;

   public NeoBaseClassGenerator(String packageName, String parserName) {
      this.packageName = packageName;
      this.name = parserName + "NeoListener";
      out.append("package ").append(packageName).append(";\n\n");

      out.append("import com.generator.editors.NeoModel;\n" +
            "import org.neo4j.graphdb.Label;\n" +
            "import org.neo4j.graphdb.Node;\n" +
            "import org.neo4j.graphdb.RelationshipType;");

      out.append("import java.util.Stack;\n" +
            "import static com.generator.app.plugins.DomainPlugin.Entities.Entity;");

      out.append("\n\npublic class ").append(name).append(" extends ").append(parserName).append("ParserBaseListener {\n");

      out.append("\n\tprivate final NeoModel graph;\n" +
            "   private final Stack<Node> nodeStack = new Stack<>();\n" +
            "\n" +
            "   public ANTLRv4NeoListener(NeoModel graph) {\n" +
            "      this.graph = graph;\n" +
            "   }\n");

      out.append("\n\tpublic Node getRoot() { return nodeStack.isEmpty() ? null : nodeStack.peek(); }\n");
   }

   @Override
   public void onPublicMethod(Method method) {

      final StringBuilder params = new StringBuilder();
      final Parameter[] parameters = method.getParameters();
      boolean first = true;
      for (Parameter parameter : parameters) {
         if (!first) params.append(", ");
         params.append(parameter.getType().getCanonicalName()).append(" ").append(parameter.getName());
         first = false;
      }
      out.append("\n\t@Override\n");
      out.append("\tpublic ").append(method.getReturnType().getSimpleName()).append(" ").append(method.getName()).append("(").append(params).append(") {\n");

      final String name = method.getName().substring(5);
      if (method.getName().startsWith("enter"))
         out.append("\t\tfinal Node entityNode = graph.findOrCreate(Entity, \"name\", \"" + name + "\");\n" +
               "      final Node node = graph.findOrCreate(Label.label(\"" + name + "\"), \"name\", arg0.getText());\n" +
               "      graph.relate(entityNode, node, RelationshipType.withName(\"INSTANCE\"));\n" +
               "      if (!nodeStack.isEmpty()) graph.relate(nodeStack.peek(), node, RelationshipType.withName(\"" + name + "\"));\n" +
               "      nodeStack.push(node);");
      else if (method.getName().startsWith("exit"))
         out.append("\t\tif (nodeStack.size() > 1) nodeStack.pop();");

      out.append("\n\t}\n");
   }

   @Override
   public void done() {
      out.append("}");
      System.out.println(out.toString());
      try {
         GeneratedFile.newJavaFile("/home/goe/projects/nextgen/src/main/java", packageName, name).write(out.toString());
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   public static void main(String[] args) {
//      new NeoBaseClassGenerator("com.generator.generators.mysql.parser", "MySql").visit(MySqlParserListener.class);
      new NeoBaseClassGenerator("com.generator.generators.antlr.parser", "ANTLRv4").visit(ANTLRv4ParserListener.class);
   }
}