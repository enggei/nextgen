package nextgen.st;

import nextgen.model.*;
import nextgen.model.parser.*;
import org.antlr.runtime.tree.Tree;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.*;
import org.stringtemplate.v4.misc.*;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

import static nextgen.model.parser.AstNodeType.*;
import static nextgen.st.STGenerator.*;

public class STParser {

   private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STParser.class);

   public static boolean debug = false;

   protected static nextgen.swing.STAppPresentationModel appModel() {
      return nextgen.swing.AppModel.getInstance().getSTAppPresentationModel();
   }

   public static nextgen.model.parser.ParseResult parse(File stgFile) {
      final char delimiter = loadDelimiter(stgFile);
      return parse(new org.stringtemplate.v4.STGroupFile(stgFile.getAbsolutePath(), delimiter, delimiter));
   }

   public static nextgen.model.parser.ParseResult parseTemplate(String text) {
      return parse(new STGroupString("tmp", toStg(text), STGenerator.DELIMITERCHAR, STGenerator.DELIMITERCHAR));
   }

   public static nextgen.model.parser.ParseResult parse(STGroup stGroup) {

      final nextgen.model.parser.ParseResult parseResult = new nextgen.model.parser.ParseResult();

      stGroup.setListener(new STErrorListener() {
         @Override
         public void compileTimeError(STMessage stMessage) {

            final nextgen.model.parser.ParserError parserError = new nextgen.model.parser.ParserError()
                  .setType(nextgen.model.parser.ParserErrorType.COMPILE)
                  .setMessage(stMessage.toString());

            if (stMessage instanceof STCompiletimeMessage) {
               final STCompiletimeMessage message = (STCompiletimeMessage) stMessage;
               parseResult.addErrors(parserError
                     .setLine(message.token.getLine())
                     .setCharPosition(message.token.getCharPositionInLine()));
            }

            parseResult.addErrors(parserError);
         }

         @Override
         public void runTimeError(STMessage stMessage) {
            parseResult.addErrors(new nextgen.model.parser.ParserError().setType(nextgen.model.parser.ParserErrorType.RUNTIME));
         }

         @Override
         public void IOError(STMessage stMessage) {
            parseResult.addErrors(new nextgen.model.parser.ParserError().setType(nextgen.model.parser.ParserErrorType.IO));
         }

         @Override
         public void internalError(STMessage stMessage) {
            parseResult.addErrors(new nextgen.model.parser.ParserError().setType(nextgen.model.parser.ParserErrorType.INTERNAL));
         }
      });

      final nextgen.model.parser.ParsedSTGroupModel stGroupModel = STParserFactory.newParsedSTGroupModel()
            .setName(stGroup.getName())
            .setDelimiter(stGroup.delimiterStartChar + "");

      stGroup.getTemplateNames()
            .stream()
            .map(stGroup::getInstanceOf)
            .filter(stTemplate -> !(stTemplate.getName().equals("/eom") || stTemplate.getName().equals("/gt")))
            .filter(st -> !st.isAnonSubtemplate())
            .filter(st -> st.impl.ast != null)
            .sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()))
            .forEach(st -> {

               if (debug) log.debug("\n--- " + st.getName());
               if (debug) log.debug(st.impl.template);

               final TemplateVisitor visitor = new TemplateVisitor();
               visitor.visit(st);

               final nextgen.model.parser.ParsedSTTemplate stTemplate = STParserFactory.newParsedSTTemplate()
                     .setName(st.getName().substring(1))
                     .setText(st.impl.template);

               final Map<String, nextgen.model.parser.ParsedSTParameter> stParameterMap = new LinkedHashMap<>();
               visitor.astNodeStack.peek().getChildren().forEach(astNode -> addParameters(stParameterMap, astNode, new Stack<>()));
               stParameterMap.values().forEach(stTemplate::addParameters);

               if (debug) log.debug("=== >");
               stTemplate.getParameters().forEach(stParameter -> {
                  if (debug) log.debug("\t" + stParameter.getName() + " " + stParameter.getType());
                  stParameter.getKeys().forEach(stParameterKey -> {
                     if (debug) log.debug(" ." + stParameterKey.getName());
                  });
                  if (debug) log.debug("");
               });

               stGroupModel.addTemplates(stTemplate);
            });

      if (parseResult.getErrors().isEmpty())
         parseResult.setParsed(stGroupModel);

      return parseResult;
   }

   private static void addParameters(Map<String, nextgen.model.parser.ParsedSTParameter> stParameterMap, AstNode astNode, Stack<nextgen.model.parser.ParsedSTParameter> stParameters) {

      switch (astNode.getType()) {
         case Expression:

            final String expressionName = astNode.getChildren().get(0).getAst().toString();

            final boolean inSubtemplate = astNode.getParent().getType().equals(Subtemplate);
            if (inSubtemplate && expressionName.equals(astNode.getParent().getChildren().get(0).getAst().getChild(0).toString())) {
               for (AstNode child : astNode.getChildren())
                  addParameters(stParameterMap, child, stParameters);
            } else {

               if (astNode.getChildren().get(0).getType().equals(Name)) {

                  stParameterMap.putIfAbsent(expressionName, newSTParameter(expressionName));
                  stParameters.push(stParameterMap.get(expressionName));

                  for (AstNode child : astNode.getChildren())
                     addParameters(stParameterMap, child, stParameters);

                  stParameters.pop();
               } else {
                  for (AstNode child : astNode.getChildren())
                     addParameters(stParameterMap, child, stParameters);
               }
            }
            break;

         case Prop:
            stParameters.peek().setType(nextgen.model.STParameterType.KVLIST);

            final nextgen.model.parser.ParsedSTParameterKey parameterKey = new nextgen.model.parser.ParsedSTParameterKey()
                  .setName(astNode.getChildren().get(1).getAst().toString())
                  .setArgumentType("Object");

            final Optional<nextgen.model.parser.ParsedSTParameterKey> exists = stParameters.peek().getKeys()
                  .stream()
                  .filter(stParameterKey -> stParameterKey.getName().equals(parameterKey.getName()))
                  .findFirst();

            if (exists.isEmpty())
               stParameters.peek().addKeys(new nextgen.model.parser.ParsedSTParameterKey()
                     .setName(parameterKey.getName()))
                     .setArgumentType(parameterKey.getArgumentType());
            break;

         case ElseIf:
         case If:

            final AstNode condition = astNode.getChildren().get(0);
            if (condition.getType().equals(Prop)) {

               for (AstNode child : astNode.getChildren())
                  addParameters(stParameterMap, child, stParameters);

            } else {
               final String ifName = condition.getAst().toString();
               stParameterMap.putIfAbsent(ifName, newSTParameter(ifName));

               stParameters.push(stParameterMap.get(ifName));
               for (AstNode child : astNode.getChildren())
                  addParameters(stParameterMap, child, stParameters);
               stParameters.pop();
            }

            break;

         case Else:
            for (AstNode child : astNode.getChildren())
               addParameters(stParameterMap, child, stParameters);
            break;

         case Assign:

            final AstNode assignment = astNode.getChildren().get(1);
            if (assignment.getType().equals(Name)) {
               final String assignName = assignment.getAst().toString();
               stParameterMap.putIfAbsent(assignName, newSTParameter(assignName));
            }

            for (AstNode child : astNode.getChildren())
               addParameters(stParameterMap, child, stParameters);

            break;

         case Include:
            final List<AstNode> children = astNode.getChildren();
            for (int i = 1; i < children.size(); i++) {
               AstNode child = children.get(i);
               if (child.getType().equals(Name)) {
                  final String assignName = child.getAst().toString();
                  stParameterMap.putIfAbsent(assignName, newSTParameter(assignName));
               } else
                  addParameters(stParameterMap, child, stParameters);
            }

            break;

         case Subtemplate:
            if (!stParameters.isEmpty()) stParameters.peek().setType(nextgen.model.STParameterType.LIST);
            for (AstNode child : astNode.getChildren())
               addParameters(stParameterMap, child, stParameters);
            break;
      }
   }

   public static void mergeTemplate(nextgen.model.parser.ParsedSTTemplate parsed, nextgen.model.STTemplate model) {

      model.setText(parsed.getText());

      final List<nextgen.model.STParameter> existingParameters = model.getParametersSorted().collect(Collectors.toList());
      final java.util.List<nextgen.model.parser.ParsedSTParameter> parsedParameters = parsed.getParameters();

      final List<nextgen.model.STParameter> sameParameters = new ArrayList<>();
      final List<nextgen.model.STParameter> oldParameters = new ArrayList<>();

      for (STParameter existingParameter : existingParameters) {

         final Optional<ParsedSTParameter> foundParameter = parsedParameters.stream().filter(parsedSTParameter -> parsedSTParameter.getName().equals(existingParameter.getName())).findFirst();
         if (foundParameter.isPresent()) {

            existingParameter.setType(foundParameter.get().getType());

            final List<nextgen.model.STParameterKey> existingKeys = existingParameter.getKeysSorted().collect(Collectors.toList());
            final List<nextgen.model.parser.ParsedSTParameterKey> parsedKeys = foundParameter.get().getKeys();

            final List<nextgen.model.STParameterKey> sameKeys = new ArrayList<>();
            final List<nextgen.model.STParameterKey> oldKeys = new ArrayList<>();

            for (STParameterKey existingKey : existingKeys) {
               if (parsedKeys.stream().anyMatch(parsedKey -> parsedKey.getName().equals(existingKey.getName()))) sameKeys.add(existingKey);
               else oldKeys.add(existingKey);
            }

            final List<nextgen.model.parser.ParsedSTParameterKey> newKeys = new ArrayList<>();
            for (ParsedSTParameterKey parsedKey : parsedKeys)
               if (sameKeys.stream().filter(stParameterKey -> stParameterKey.getName().equals(parsedKey.getName())).findAny().isEmpty()) newKeys.add(parsedKey);

            for (STParameterKey oldKey : oldKeys)
               existingParameter.removeKeys(oldKey);

            for (ParsedSTParameterKey newKey : newKeys)
               existingParameter.addKeys(appModel().db.newSTParameterKey()
                     .setName(newKey.getName())
                     .setArgumentType(newKey.getArgumentType()));

            sameParameters.add(existingParameter);

         } else {
            oldParameters.add(existingParameter);
         }
      }

      final List<ParsedSTParameter> newParameters = new ArrayList<>();
      for (ParsedSTParameter parsedParameter : parsedParameters)
         if (sameParameters.stream().filter(stParameter -> stParameter.getName().equals(parsedParameter.getName())).findAny().isEmpty()) newParameters.add(parsedParameter);

      for (STParameter oldParameter : oldParameters)
         model.removeParameters(oldParameter);

      newParameters.forEach(o -> appModel().addSTParameter(model, o));
   }

   private static nextgen.model.parser.ParsedSTParameter newSTParameter(String name) {
      return new nextgen.model.parser.ParsedSTParameter()
            .setName(name)
            .setType(nextgen.model.STParameterType.SINGLE)
            .setArgumentType((name != null && (name.startsWith("is") || name.startsWith("use"))) ? "Boolean" : ((name != null && name.equalsIgnoreCase("name")) ? "String" : "Object"));
   }

   private static char loadDelimiter(File stgFile) {
      try {
         final String s = read(stgFile);
         final String pattern = "delimiters \"";
         final int start = s.indexOf(pattern) + pattern.length();
         return s.charAt(start);
      } catch (Throwable e) {
         log.debug("illegal format in file " + stgFile.getAbsolutePath());
         return '~';
      }
   }

   public static String read(File file) {
      if (!file.exists()) return "";
      try {
         final StringBuilder content = new StringBuilder();
         final BufferedReader in = new BufferedReader(new FileReader(file));
         String line;
         while ((line = in.readLine()) != null) content.append(line);
         in.close();
         return content.toString();
      } catch (IOException e) {
         e.printStackTrace();
         return "ERROR: " + e.getMessage();
      }
   }

   private static String debug(AstNode astNode, int level) {
      final StringBuilder out = new StringBuilder();
      out.append("\t".repeat(Math.max(0, level)));
      out.append(astNode.getType()).append(" \"").append(astNode.getAst().getText()).append("\"");
      astNode.getChildren().forEach(astNode1 -> out.append("\n").append(debug(astNode1, level + 1)));
      return out.toString();
   }

   public static ST asST(String content) {
      final nextgen.model.parser.ParsedSTTemplate stTemplate = parseTemplate(content).getParsed().getTemplates().iterator().next();
      return STGenerator.asST(stTemplate);
   }

   public static String toString(java.util.List<nextgen.model.parser.ParserError> errors) {
      final StringBuilder info = new StringBuilder("Parsing errors:");
      errors.forEach(stgError -> {
         info.append("\n").append(stgError.getType());
         if (stgError.getType() == nextgen.model.parser.ParserErrorType.COMPILE) {
            info.append("\n\tline               ").append(stgError.getLine());
            info.append("\n\tpos                ").append(stgError.getCharPosition());
            info.append("\n\tmessage            ").append(stgError.getMessage());

            if (stgError.getMessage().contains("expecting RDELIM")) {
               info.append("\n\tpossible cause     ").append("This is probably a '}' being interpreted as end-of a kv-iteration.");
               info.append("\n\tpossible solution  ").append("Try escaping the previous '}' (i.e from '}' to '\\}')");
            } else if (stgError.getMessage().contains("invalid character '>'")) {
               info.append("\n\tpossible cause     ").append("This is probably a '>' being interpreted as end-of template.");
               info.append("\n\tpossible solution  ").append("Try changing the last '>' to '" + nextgen.st.STGenerator.DELIMITERCHAR + "gt()" + nextgen.st.STGenerator.DELIMITERCHAR + "'");
            }
         }
      });
      return info.toString().trim();
   }

   static final class TemplateVisitor {

      private static final int EXPR = 41;
      private static final int NAME = 25;
      private static final int SUBTEMPLATE = 55;
      private static final int ARGS = 38;
      private static final int PROP = 52;
      private static final int INCLUDE = 42;
      private static final int IF = 4;
      private static final int ELSE = 5;
      private static final int ELSEIF = 6;
      private static final int ASSIGN = 12;

      private final Stack<AstNode> astNodeStack = new Stack<>();

      public void visit(ST st) {
         astNodeStack.push(STParserFactory.newAstNode().setType(ST));
         visit(st.impl.ast);
      }

      private void visit(Tree ast) {
         switch (ast.getType()) {
            case ARGS:
               pushAstNode(ast, Args);
               break;

            case NAME:
               pushAstNode(ast, Name);
               break;

            case PROP:
               pushAstNode(ast, Prop);
               break;

            case EXPR:
               pushAstNode(ast, Expression);
               break;

            case SUBTEMPLATE:
               pushAstNode(ast, Subtemplate);
               break;

            case INCLUDE:
               pushAstNode(ast, Include);
               break;

            case IF:
               pushAstNode(ast, If);
               break;

            case ELSE:
               pushAstNode(ast, Else);
               break;

            case ELSEIF:
               pushAstNode(ast, ElseIf);
               break;

            case ASSIGN:
               pushAstNode(ast, Assign);
               break;

            case 51:
            case 22:
               break;

            case 0:
            case 26:
            case 31:
            case 32:
            case 47:
            case 49:
               for (int i = 0; i < ast.getChildCount(); i++)
                  visit(ast.getChild(i));
               break;

            default:
               if (debug)
                  log.debug("case U" + ast.getType() + ":\npushAstNode(ast, U" + ast.getType() + ");\nbreak;");
               if (debug)
                  log.debug("private static final int U" + ast.getType() + " = " + ast.getType() + ";");
               for (int i = 0; i < ast.getChildCount(); i++)
                  visit(ast.getChild(i));
               break;
         }
      }

      private void pushAstNode(Tree ast, AstNodeType astNodeType) {

         newAstNode(astNodeType, ast);

         for (int i = 0; i < ast.getChildCount(); i++)
            visit(ast.getChild(i));

         astNodeStack.pop();
      }

      private void newAstNode(AstNodeType astNodeType, Tree ast) {

         final AstNode astNode = STParserFactory.newAstNode().setType(astNodeType).setAst(ast);

         if (debug) log.debug(debug(astNode, astNodeStack.size()));

         if (!astNodeStack.isEmpty()) {
            astNodeStack.peek().addChildren(astNode);
            astNode.setParent(astNodeStack.peek());
         }

         astNodeStack.push(astNode);
      }
   }
}