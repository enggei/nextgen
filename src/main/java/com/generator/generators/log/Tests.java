package com.generator.generators.log;

import com.generator.util.FileUtil;
import io.vertx.core.json.JsonObject;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created 20.12.17.
 */
public class Tests {

   @Test
   public void testLog() throws IOException {

      final Set<String> logClasses = new LinkedHashSet<>();

      final Map<String, LogClassHandler> handlers = new LinkedHashMap<>();
      handlers.put("com.generator.generators.vertx.verticles.BaseServerVerticle", new BaseServerVerticleClassHandler());
      handlers.put("com.generator.generators.vertx.verticles.BaseTcpBridgeVerticle", new BaseTcpBridgeVerticleClassHandler());
      handlers.put("com.generator.generators.vertx.verticles.BaseDeployVerticle", new BaseDeployVerticleClassHandler());
      handlers.put("com.generator.generators.vertx.DeployInstanceFSM", new DeployInstanceFSMClassHandler());
      handlers.put("com.generator.neo.vertx.BaseNeoVerticle", new BaseNeoVerticleClassHandler());
      handlers.put("com.generator.neo.embedded.EmbeddedNeoModel", new EmbeddedNeoModelClassHandler());
      handlers.put("com.generator.generators.easyFlow.EasyFlowDomainVerticle", new EasyFlowDomainVerticleClassHandler());
      handlers.put("com.generator.generators.easyFlow.vertx.EasyFlowClientFSM", new EasyFlowClientFSMClassHandler());
      handlers.put("com.generator.generators.easyFlow.EasyFlowFacade", new EasyFlowFacadeClassHandler());
      handlers.put("com.generator.generators.easyFlow.vertx.EasyFlowDomainVisitor", new EasyFlowDomainVisitorClassHandler());
      handlers.put("com.generator.generators.easyFlow.vertx.AbstractDeployAndTestEasyFlow", new AbstractDeployAndTestEasyFlowClassHandler());

      handlers.put("com.generator.app.AppEvents", new AppEventsClassHandler());
      handlers.put("com.generator.app.App", new AppClassHandler());
      handlers.put("com.generator.app.Workspace", new WorkspaceClassHandler());
      handlers.put("com.generator.app.AppMotif", new AppMotifClassHandler());
      handlers.put("com.generator.app.Plugin", new PluginClassHandler());
      handlers.put("com.generator.app.InformationPanel", new InformationPanelClassHandler());
      handlers.put("com.generator.generators.domain.DomainVisitor", new DomainVisitorClassHandler());
      handlers.put("com.generator.util.FileUtil", new FileUtilClassHandler());

      FileUtil.readString(new File("/home/goe/projects/nextgen/nextgen.log"), new FileUtil.LineHandler() {
         @Override
         public boolean handleLine(String line) {
            final String timestamp = line.substring(0, 23);
            final int endStatusIndex = line.indexOf(" - ", 25);
            final String status = line.substring(25, endStatusIndex).trim();
            final int endClassIndex = line.indexOf(" - ", endStatusIndex + 3);
            final String className = line.substring(endStatusIndex + 3, endClassIndex);
            final String content = line.substring(endClassIndex + 3);
            final JsonObject logEvent = new JsonObject().put("timestamp", timestamp).put("status", status).put("class", className).put("content", content);

            final LogClassHandler logClassHandler = handlers.get(className);
            if (logClassHandler == null)
               logClasses.add(className);
            else
               logClassHandler.handle(logEvent);

            return false;
         }
      });

      for (LogClassHandler logClassHandler : handlers.values()) {
         if(logClassHandler.events.isEmpty()) continue;
         System.out.println(logClassHandler);
      }


      for (String logClass : logClasses) {
         System.out.println("\nprivate static class " + logClass.substring(logClass.lastIndexOf('.') + 1) + "ClassHandler extends LogClassHandler {\n" +
               "\n\tprivate final String className = \"" + logClass + "\";\n" +
               "\n\t@Override \n\tpublic String toString() {\n\t\treturn className + \"\\n\\t\" + super.toString(); \n\t}" +
               "\n}");
      }

      for (String logClass : logClasses) {
         System.out.println("handlers.put(\"" + logClass + "\", new " + logClass.substring(logClass.lastIndexOf('.') + 1) + "ClassHandler());");
      }

   }

   public static abstract class LogClassHandler {

      protected final Queue<JsonObject> events = new LinkedList<>();

      void handle(JsonObject logEvent) {
         events.add(logEvent);
      }

      @Override
      public String toString() {
         final StringBuilder out = new StringBuilder();
         for (JsonObject event : events)
            out.append(event.toString()).append("\n\t");
         return out.toString();
      }
   }

   private static class BaseServerVerticleClassHandler extends LogClassHandler {

      private final String className = "com.generator.generators.vertx.verticles.BaseServerVerticle";

      @Override
      public String toString() {
         return className + "\n\t" + super.toString();
      }
   }

   private static class BaseTcpBridgeVerticleClassHandler extends LogClassHandler {

      private final String className = "com.generator.generators.vertx.verticles.BaseTcpBridgeVerticle";

      @Override
      public String toString() {
         return className + "\n\t" + super.toString();
      }
   }

   private static class BaseDeployVerticleClassHandler extends LogClassHandler {

      private final String className = "com.generator.generators.vertx.verticles.BaseDeployVerticle";

      @Override
      public String toString() {
         return className + "\n\t" + super.toString();
      }
   }

   private static class DeployInstanceFSMClassHandler extends LogClassHandler {

      private final String className = "com.generator.generators.vertx.DeployInstanceFSM";

      @Override
      public String toString() {
         return className + "\n\t" + super.toString();
      }
   }

   private static class BaseNeoVerticleClassHandler extends LogClassHandler {

      private final String className = "com.generator.neo.vertx.BaseNeoVerticle";

      @Override
      public String toString() {
         return className + "\n\t" + super.toString();
      }
   }

   private static class EmbeddedNeoModelClassHandler extends LogClassHandler {

      private final String className = "com.generator.neo.embedded.EmbeddedNeoModel";

      @Override
      public String toString() {
         return className + "\n\t" + super.toString();
      }
   }

   private static class EasyFlowDomainVerticleClassHandler extends LogClassHandler {

      private final String className = "com.generator.generators.easyFlow.EasyFlowDomainVerticle";

      @Override
      public String toString() {
         return className + "\n\t" + super.toString();
      }
   }

   private static class EasyFlowClientFSMClassHandler extends LogClassHandler {

      private final String className = "com.generator.generators.easyFlow.vertx.EasyFlowClientFSM";

      @Override
      public String toString() {
         return className + "\n\t" + super.toString();
      }
   }

   private static class EasyFlowFacadeClassHandler extends LogClassHandler {

      private final String className = "com.generator.generators.easyFlow.EasyFlowFacade";

      @Override
      public String toString() {
         return className + "\n\t" + super.toString();
      }
   }

   private static class EasyFlowDomainVisitorClassHandler extends LogClassHandler {

      private final String className = "com.generator.generators.easyFlow.vertx.EasyFlowDomainVisitor";

      @Override
      public String toString() {
         return className + "\n\t" + super.toString();
      }
   }

   private static class AbstractDeployAndTestEasyFlowClassHandler extends LogClassHandler {

      private final String className = "com.generator.generators.easyFlow.vertx.AbstractDeployAndTestEasyFlow";

      @Override
      public String toString() {
         return className + "\n\t" + super.toString();
      }
   }

   private static class AppEventsClassHandler extends LogClassHandler {

      private final String className = "com.generator.app.AppEvents";

      @Override
      public String toString() {
         return className + "\n\t" + super.toString();
      }
   }

   private static class AppClassHandler extends LogClassHandler {

      private final String className = "com.generator.app.App";

      @Override
      public String toString() {
         return className + "\n\t" + super.toString();
      }
   }

   private static class WorkspaceClassHandler extends LogClassHandler {

      private final String className = "com.generator.app.Workspace";

      @Override
      public String toString() {
         return className + "\n\t" + super.toString();
      }
   }

   private static class AppMotifClassHandler extends LogClassHandler {

      private final String className = "com.generator.app.AppMotif";

      @Override
      public String toString() {
         return className + "\n\t" + super.toString();
      }
   }

   private static class PluginClassHandler extends LogClassHandler {

      private final String className = "com.generator.app.Plugin";

      @Override
      public String toString() {
         return className + "\n\t" + super.toString();
      }
   }

   private static class InformationPanelClassHandler extends LogClassHandler {

      private final String className = "com.generator.app.InformationPanel";

      @Override
      public String toString() {
         return className + "\n\t" + super.toString();
      }
   }

   private static class DomainVisitorClassHandler extends LogClassHandler {

      private final String className = "com.generator.generators.domain.DomainVisitor";

      @Override
      public String toString() {
         return className + "\n\t" + super.toString();
      }
   }

   private static class FileUtilClassHandler extends LogClassHandler {

      private final String className = "com.generator.util.FileUtil";

      @Override
      public String toString() {
         return className + "\n\t" + super.toString();
      }
   }
}