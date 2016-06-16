package com.generator.generators.templates.parser;

import com.generator.generators.templates.domain.*;
import com.generator.util.Tuple;
import org.antlr.runtime.tree.Tree;

import java.util.*;

/**
 * User: goe
 * Date: 08.09.13
 */
public class Expression {

   private final Stack<Integer> expressionStack = new Stack<>();
   private final Debugger debugger;

   public Expression(Tree ast, ParameterBuilder parameterBuilder, Debugger debugger) {

      expressionStack.push(ast.getType());
      this.debugger = debugger;

      for (int i = 0; i < ast.getChildCount(); i++)
         parse(ast.getChild(i), parameterBuilder, i);
   }

   protected Expression parse(Tree ast, ParameterBuilder builder, int childIndex) {

      final int type = ast.getType();

      debugger.inc();
      debugger.onType(ast);

      switch (type) {
         case 52:
            builder.addKvname(ast.getChild(0).getText(), ast.getChild(1).getText());
            break;
         case 49:
            builder.isCollection();
            break;
         case 25:

            switch (expressionStack.peek()) {
               case 4:
                  builder.setName(ast.getText());
                  break;

               case 6:
                  builder.setName(ast.getText());
                  break;

               case 12:

                  if (ast.getText().equals("separator") || ast.getText().equals("format")) break;

                  if (childIndex == 0)
                     builder.addMethodCallParam(ast.getText());
                  else if (childIndex == 1)
                     builder.setName(ast.getText());
                  break;

               case 38:
                  builder.addIterator(ast.getText());
                  break;

               case 40:
                  if (childIndex == 1)
                     builder.setName(ast.getText());
                  break;

               case 41:
                  if (expressionStack.size() == 1) builder.setName(ast.getText());
                  else if (expressionStack.size() > 1) {
                     for (Integer level : expressionStack) {
                        if (level == 4 && !builder.isIterator(ast.getText())) {
                           builder.setName(ast.getText());
                           break;
                        }
                     }
                  }
                  break;

               case 42:
                  if (childIndex == 0)
                     builder.addMethodCall(ast.getText(), false);
                  else if (childIndex == 1) {
                     builder.setName(ast.getText());
                     builder.addMethodCallParam(ast.getText());   // param same name
                  }
                  break;

               case 45:
                  if (childIndex == 0)
                     builder.addMethodCall(ast.getText(), true);  // SUPER-CALL
                  else if (childIndex == 1) {
                     builder.setName(ast.getText());
                     builder.addMethodCallParam(ast.getText());   // param same name
                  }
                  break;

               case 49:
                  builder.setName(ast.getText());
                  break;
            }

            debugger.dec();
            return this;
      }

      expressionStack.push(type);
      for (int i = 0; i < ast.getChildCount(); i++)
         parse(ast.getChild(i), builder, i);
      expressionStack.pop();

      debugger.dec();

      return this;
   }

   public static final class ParameterBuilder {

      private final Map<String, Parameter> parameterMap = new TreeMap<>();
      private final Map<String, MethodCall> methodCalls = new TreeMap<>();

      private final Map<String, String> iteratorParameterMap = new LinkedHashMap<>();
      private String currentParameter;
      private String currentMethod;
      private boolean isCollection = false;
      private final String name;
      private final char delimiterStartChar;
      private final String content;

      public ParameterBuilder(String name, char delimiterStartChar, String content) {
         this.name = name;
         this.delimiterStartChar = delimiterStartChar;
         this.content = content;
      }

      public void addMethodCall(String name, boolean isSuper) {
         MethodCall methodCall = methodCalls.get(name);
         if (methodCall == null) methodCalls.put(name, methodCall = new MethodCall());
         methodCall.setName(name);
         if (isSuper) methodCall.isSuper = isSuper;
         currentMethod = name;
      }

      public boolean hasMethodCalls() {
         return !methodCalls.isEmpty();
      }

      public void addMethodCallParam(String paramName) {
         methodCalls.get(currentMethod).methodParams.add(paramName);
      }

      public void setName(String text) {
         Parameter parameter = parameterMap.get(text);
         if (parameter == null) parameterMap.put(text, parameter = new Parameter());
         parameter.setName(text);
         currentParameter = text;

         if (isCollection) {
            parameter.isCollection();
            isCollection = false;
         }
      }

      public void addKvname(String iterator, String text) {
         String key = iteratorParameterMap.get(iterator);

         if (key == null) {
            isCollection();
            setName(iterator);
            addIterator(iterator);
         }

         parameterMap.get(iteratorParameterMap.get(iterator)).addKvname(text);
      }

      public void isCollection() {
         isCollection = true;
      }

      @Override
      public String toString() {
         return parameterMap.values() + (methodCalls.isEmpty() ? "" : ("\n\t -> " + methodCalls));
      }

      public void addIterator(String iteratorName) {
         iteratorParameterMap.put(iteratorName, currentParameter);
      }

      public List<TemplateParameter> getParameters() {
         final List<TemplateParameter> list = new ArrayList<>();
         for (Parameter parameterBuilder : parameterMap.values())
            list.add(parameterBuilder.asTemplateParameter());
         return list;
      }

      public boolean isIterator(String token) {
         return iteratorParameterMap.keySet().contains(token);
      }

      public TemplateStatement toStatement() {
         return new TemplateStatement(name, TemplateStatementType.METHOD, getParameters(), content, delimiterStartChar);
      }

      public String getName() {
         return name;
      }

      public ParameterBuilder processMethodCalls(Map<String, ParameterBuilder> map, Map<String, TemplateFile> imports) {
         for (Map.Entry<String, MethodCall> callEntry : methodCalls.entrySet()) {
            for (String methodParam : callEntry.getValue().methodParams) {
               final Tuple<TemplateStatement, TemplateParameter> parameter = findTemplateParameterFor(callEntry.getKey(), methodParam, map, imports);
               if (parameter == null) {
                  continue;
               }

               final Parameter myParam = parameterMap.get(methodParam);
               if (myParam == null) continue;

               System.out.println("'" + this.getName() + "' calls method '" + callEntry.getKey() + "' : parameter '" + myParam.name + "(" + myParam.paramType + ")" + "." + methodParam + ("' ->  set to '" + parameter.last().getDomainEntityType() + "'"));
               myParam.setParamType(parameter.last().getDomainEntityType());
               for (String s : parameter.last().getKvNames()) myParam.addKvname(s);
            }
         }
         return this;
      }

       private Tuple<TemplateStatement, TemplateParameter> findTemplateParameterFor(String methodCall, String methodParam, Map<String, ParameterBuilder> builderMap, Map<String, TemplateFile> imports) {

         for (ParameterBuilder parameterBuilder : builderMap.values()) {
            if (!parameterBuilder.getName().equals(methodCall)) continue;
            for (TemplateParameter templateParameter : parameterBuilder.getParameters()) {
               if (methodParam.equals(templateParameter.getPropertyName()))
                  return new Tuple<>(parameterBuilder.toStatement(), templateParameter);
            }
         }

         for (TemplateFile templateFile : imports.values()) {
            for (TemplateStatement templateStatement : templateFile.getStatements()) {
               if (!templateStatement.getName().equals(methodCall)) continue;

               for (TemplateParameter templateParameter : templateStatement.getParameters()) {
                  if (templateParameter.getPropertyName().equals(methodParam))
                     return new Tuple<>(templateStatement, templateParameter);
               }
            }
         }
         return null;
      }

      private final class MethodCall {
         private String name;
         private boolean isSuper = false;
         private final Set<String> methodParams = new LinkedHashSet<>();

         public void setName(String name) {
            this.name = name;
         }

         @Override
         public String toString() {
            return name + (isSuper ? "(SUPER)" : "") + methodParams;
         }
      }

      private final class Parameter {
         private String name;
         private TemplateEntities paramType = TemplateEntities.STRINGPROPERTY;
         private final Set<String> kvNames = new TreeSet<>();

         public void setParamType(TemplateEntities paramType) {
            this.paramType = paramType;
         }

         public void setName(String name) {
            this.name = name;
         }

         public void isCollection() {
            this.paramType = TemplateEntities.LISTPROPERTY;
         }

         public void addKvname(String name) {
            this.kvNames.add(name);
            this.paramType = TemplateEntities.KEYVALUELISTPROPERTY;
         }

         @Override
         public String toString() {
            return name + "(" + paramType + ")" + (kvNames.size() > 0 ? kvNames : "");
         }

         public TemplateParameter asTemplateParameter() {
            return new TemplateParameter(name, paramType, kvNames);
         }
      }
   }

}