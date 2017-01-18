package com.generator.generators.templates.editor;

import com.generator.editors.NeoModel;
import com.generator.editors.canvas.neo.NeoEditor;
import com.generator.generators.templates.domain.GeneratedFile;
import com.generator.generators.templates.domain.TemplateParameter;
import com.generator.util.SwingUtil;
import org.neo4j.graphdb.*;
import org.stringtemplate.v4.AttributeRenderer;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroupString;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;

import static com.generator.editors.BaseDomainVisitor.*;
import static com.generator.editors.BaseDomainVisitor.getString;
import static com.generator.editors.NeoModel.debugNode;
import static com.generator.editors.NeoModel.uuidOf;
import static com.generator.generators.templates.editor.TemplateDomain.TemplateLabels.*;
import static com.generator.generators.templates.editor.TemplateDomain.TemplateRelations.*;
import static org.neo4j.graphdb.Direction.INCOMING;
import static org.neo4j.graphdb.Direction.OUTGOING;

/**
 * goe on 11/28/16.
 * todo: export cypher / import cypher
 * todo: create group and neo from templateGroup (replace functionality in TemplateFileEditor)
 * todo: create a method for cleanup: remove all non-related SingleValues and Statements
 * todo: create a method for cloning nodes /trees ?
 */
public class TemplateDomain {

   public enum TemplateLabels implements Label {
      TemplateGroup, TemplateStatement,
      SingleTemplateParameter, StatementTemplateParameter, ListTemplateParameter, KeyValueTemplateParameter,
      Statement, SingleValue, KeyValueSet,
      Project, Directory
   }

   public enum TemplateProperties implements Label {
      name, relationType, value, keys, text, delimiter,
      packageName, path, outputFormat,
      // statementLabel is property on TemplateStatement to render statement
      statementLabel
   }

   public enum TemplateRelations implements RelationshipType {
      TEMPLATE_GROUP, IMPORT, TEMPLATE_STATEMENT, TEMPLATE_PARAMETER, DIRECTORY_MEMBER, PROJECT_DIRECTORY, STATEMENT_PARAMETER
   }

   static Node newProject(NeoModel db, String name) {
      final Node node = db.newNode(Project);
      node.setProperty(TemplateProperties.name.name(), name);
      return node;
   }

   static Node newDirectory(NeoModel db, String path) {
      final Node node = db.newNode(Directory);
      node.setProperty(TemplateProperties.name.name(), path);
      return node;
   }

   static Node newTemplateGroup(NeoModel db, String name, String delimiter) {
      final Node node = db.newNode(TemplateGroup);
      node.setProperty(TemplateProperties.name.name(), name);
      node.setProperty(TemplateProperties.delimiter.name(), delimiter);

      // fixes for bugs in template (always include)
//		newTemplateStatement(db, node, "bugFixEndMethod", "}");
//		newTemplateStatement(db, node, "bugFixEndStatement", ">");

      return node;
   }

   static Node newTemplateStatement(NeoModel db, Node templateGroup, String templateStatementName, String templateStatementText) {

      final StringBuilder existingReferences = new StringBuilder("");
      new TemplateGroupVisitor() {
         @Override
         protected void onTemplateStatementStart(String name, String text, Node templateStatement) {
            if (templateStatementName.equals(name))
               existingReferences.append("\n").append(NeoModel.getNameOrLabelFrom(templateStatement)).append(" (").append(uuidOf(templateStatement)).append(")");
         }
      }.visitTemplateGroup(templateGroup);

      if (existingReferences.length() > 0)
         throw new IllegalArgumentException("cannot create new TemplateStatement since the name is already taken in TemplateGroup by " + existingReferences);

      final Node node = db.newNode(TemplateStatement);
      node.setProperty(TemplateProperties.name.name(), templateStatementName);
      node.setProperty(TemplateProperties.text.name(), templateStatementText);
      node.createRelationshipTo(templateGroup, TEMPLATE_GROUP);
      return node;
   }

   static Node newSingleTemplateParameter(NeoModel db, Node templateStatement, String newName) {

      final Set<Node> existing = new LinkedHashSet<>();
      new TemplateGroupVisitor() {
         @Override
         protected void onSingleTemplateParameter(String name, Node parameterNode) {
            // name already exist, and is a singleTemplateParameter. use this instead
            if (name.equals(newName)) existing.add(parameterNode);
         }
      }.visitTemplateStatement(templateStatement);

      if (existing.isEmpty()) {
         final Node node = db.newNode(SingleTemplateParameter);
         node.setProperty(TemplateProperties.name.name(), newName);
         final Relationship relationship = node.createRelationshipTo(templateStatement, TEMPLATE_PARAMETER);
         relationship.setProperty(TemplateProperties.relationType.name(), SingleTemplateParameter.name());
         return node;
      }

      return existing.iterator().next();
   }

   static Node newListTemplateParameter(NeoModel db, Node templateStatement, String newName) {

      final Set<Node> existing = new LinkedHashSet<>();
      new TemplateGroupVisitor() {
         @Override
         protected void onListTemplateParameter(String name, Node parameterNode) {
            if (name.equals(newName)) existing.add(parameterNode);
         }
      }.visitTemplateStatement(templateStatement);

      if (existing.isEmpty()) {
         final Node node = db.newNode(ListTemplateParameter);
         node.setProperty(TemplateProperties.name.name(), newName);
         final Relationship relationship = node.createRelationshipTo(templateStatement, TEMPLATE_PARAMETER);
         relationship.setProperty(TemplateProperties.relationType.name(), ListTemplateParameter.name());
         return node;
      }

      return existing.iterator().next();
   }

   static Node newKeyValueListTemplateParameter(NeoModel db, Node templateStatement, String newName, String[] newKeys) {

      final Set<Node> existing = new LinkedHashSet<>();
      new TemplateGroupVisitor() {

         @Override
         protected void onKeyValueTemplateParameter(String name, String oldKeys, Node parameterNode) {

            if (name.equals(newName)) {
               existing.add(parameterNode);

               // append any new keys
               final StringBuilder serialized = new StringBuilder(oldKeys);
               for (String newKey : newKeys) {
                  boolean hasKey = false;
                  for (String oldKey : oldKeys.split(" ")) {
                     if (newKey.equals(oldKey)) {
                        hasKey = true;
                        break;
                     }
                  }
                  if (!hasKey) serialized.append(" ").append(newKey);
               }
               parameterNode.setProperty(TemplateProperties.keys.name(), serialized.toString().trim());
            }
         }
      }.visitTemplateStatement(templateStatement);

      if (existing.isEmpty()) {
         final Node node = db.newNode(KeyValueTemplateParameter);
         node.setProperty(TemplateProperties.name.name(), newName);
         final StringBuilder serialized = new StringBuilder();
         for (String key : newKeys) serialized.append(key).append(" ");
         node.setProperty(TemplateProperties.keys.name(), serialized.toString().trim());
         final Relationship relationship = node.createRelationshipTo(templateStatement, TEMPLATE_PARAMETER);
         relationship.setProperty(TemplateProperties.relationType.name(), KeyValueTemplateParameter.name());
         return node;
      }

      return existing.iterator().next();
   }

   public static Node newStatement(NeoModel db, Node templateStatement) {
      final Node newNode = db.newNode(Statement);
      newNode.createRelationshipTo(templateStatement, TEMPLATE_STATEMENT);
      return newNode;
   }

   static Node newSingleValue(NeoModel db, Object value) {
      Node newNode = db.newNode(SingleValue);
      newNode.setProperty(TemplateProperties.value.name(), value.toString());
      return newNode;
   }

   static Node newKeyValueSet(NeoModel db, Node statement, Node templateParameter) {
      final Node newNode = db.newNode(KeyValueSet);
      newNode.createRelationshipTo(templateParameter, TEMPLATE_PARAMETER);
      statement.createRelationshipTo(newNode, RelationshipType.withName(get(templateParameter, TemplateProperties.name.name())));
      return newNode;
   }

   static void renderProjectMember(final Node node, final JComponent component) {
      outgoing(node, DIRECTORY_MEMBER).forEach(projectRelation -> {

         final String root = getString(node, TemplateDomain.TemplateProperties.name.name());
         final String outputFormat = getString(projectRelation, TemplateDomain.TemplateProperties.outputFormat.name());

         final Node statementNode = other(node, projectRelation);

         assert outputFormat != null;
         switch (outputFormat) {

            case "java": {

               final String packageParameter = getString(projectRelation, TemplateDomain.TemplateProperties.packageName.name());
               final String nameParameter = getString(projectRelation, TemplateDomain.TemplateProperties.name.name());

               new StatementVisitor() {

                  private String nameValue;
                  private String packageValue;

                  @Override
                  protected void onSingleValue(String name, Node referenceNode, TemplateDomain.TemplateLabels referenceNodeType) {
                     assert nameParameter != null;
                     if (nameParameter.equals(name))
                        nameValue = TemplateDomain.renderReferenceNode(referenceNode, referenceNodeType);
                     else {
                        assert packageParameter != null;
                        if (packageParameter.equals(name))
                           packageValue = TemplateDomain.renderReferenceNode(referenceNode, referenceNodeType);
                     }
                  }

                  @Override
                  protected void onStatementEnd() {
                     final GeneratedFile generatedFile = GeneratedFile.newJavaFile(root, packageValue, nameValue);
                     try {
                        generatedFile.write(TemplateDomain.render(statementNode));
                     } catch (IOException e1) {
                        SwingUtil.showException(component, e1);
                     }
                  }
               }.visitStatement(statementNode);

               break;
            }

            case "other": {

               final String filename = getString(projectRelation, TemplateDomain.TemplateProperties.name.name());

               assert filename != null;
               final GeneratedFile generatedFile = new GeneratedFile(new File(root, filename));
               try {
                  generatedFile.write(TemplateDomain.render(statementNode));
               } catch (IOException e1) {
                  SwingUtil.showException(component, e1);
               }
               break;
            }
         }
      });
   }

   public static String render(Node statement) {

      final StringBuilder out = new StringBuilder();

      new StatementVisitor() {

         private ST st;

         // key-value set
         private StringBuilder aggr;
         boolean first = true;
         final Map<String, String> aggrValues = new LinkedHashMap<>();

         @Override
         protected void onStatementStart(Node statementTemplate, Node templateGroup) {
            final STGroupString stGroup = new STGroupString(asSTGString(templateGroup));
            stGroup.registerRenderer(String.class, newTemplateStringRenderer());
            st = stGroup.getInstanceOf(get(statementTemplate, TemplateProperties.name.name()));
         }

         @Override
         protected void onSingleValue(String name, Node referenceNode, TemplateLabels referenceNodeType) {
            st.add(name, renderReferenceNode(referenceNode, referenceNodeType));
         }

         @Override
         protected void onListValue(String name, Node referenceNode, TemplateLabels referenceNodeType) {
            st.add(name, renderReferenceNode(referenceNode, referenceNodeType));
         }

         @Override
         protected void onStartKeyValueSet(String name, Node keyValueNode) {
            aggr = new StringBuilder(name + ".{");
            first = true;
            aggrValues.clear();
         }

         @Override
         protected void onKeyValue(String key, Node referenceNode, TemplateLabels referenceNodeType) {
            if (!first) aggr.append(",");
            first = false;
            aggr.append(key);
            aggrValues.put(key, renderReferenceNode(referenceNode, referenceNodeType));
         }

         @Override
         protected void onEndKeyValueSet(Node keyValueNode) {
            if (first) return;

            final Object[] values = new Object[aggrValues.keySet().size()];
            int index = 0;
            for (String key : aggrValues.keySet())
               values[index++] = aggrValues.get(key);
            aggr.append("}");
            st.addAggr(aggr.toString(), values);
         }

         @Override
         protected void onStatementEnd() {
            out.append(st.render());
         }


      }.visitStatement(statement);

      return out.toString();
   }

   static String renderReferenceNode(Node referenceNode, TemplateLabels referenceNodeType) {

      if (referenceNode == null) return null;

      switch (referenceNodeType) {

         case Statement:
            return render(referenceNode);

         case SingleValue:
            return get(referenceNode, TemplateProperties.value.name());
      }

      throw new IllegalArgumentException("cannot render " + NeoModel.getNameOrLabelFrom(referenceNode) + "(" + referenceNodeType + ")");
   }


   static String asSTGString(Node templateGroup) {
      final StringBuilder out = new StringBuilder();
      final AtomicBoolean firstParameter = new AtomicBoolean(true);

      new TemplateGroupVisitor() {
         @Override
         protected void onTemplateGroupStart(String name, String delimiter, Node templateGroup) {
            out.append("/* ").append(name).append(" ").append(uuidOf(templateGroup)).append("*/").append("\n");
            out.append("delimiters \"").append(delimiter).append("\", \"").append(delimiter).append("\"");
         }

         @Override
         protected void onTemplateStatementStart(String name, String text, Node templateStatement) {
            out.append("\n\n").append(name).append("(");
            firstParameter.set(true);
         }

         @Override
         protected void onSingleTemplateParameter(String name, Node parameterNode) {
            if (!firstParameter.get()) out.append(",");
            out.append(name);
            firstParameter.set(false);
         }

         @Override
         protected void onListTemplateParameter(String name, Node parameterNode) {
            if (!firstParameter.get()) out.append(",");
            out.append(name);
            firstParameter.set(false);
         }

         @Override
         protected void onKeyValueTemplateParameter(String name, String keys, Node parameterNode) {
            if (!firstParameter.get()) out.append(",");
            out.append(name);
            firstParameter.set(false);
         }

         @Override
         protected void onTemplateStatementEnd(String name, String text, Node templateStatement) {
            // ST bug if error message when tail of a template is '>>>' avoid by add a space before end of statement
            out.append(") ::= <<").append(text).append(text.endsWith(">") ? " >>" : ">>");
         }

      }.visitTemplateGroup(templateGroup);

      return out.toString();
   }

   static Relationship setSingleReference(Node referencedNode, Node node, RelationshipType type, NeoEditor editor) throws NeoEditor.CircularStatementException {

      final Relationship existingRelationship = singleOutgoing(node, type);
      if (existingRelationship != null) {
         // if exact relationship already exists, just return this:
         if (existingRelationship.getStartNode().equals(node) && existingRelationship.getEndNode().equals(referencedNode) && type.equals(existingRelationship.getType()))
            return existingRelationship;

         final Node oldReferencedNode = other(node, existingRelationship);
         existingRelationship.delete(); // Neo-editor will catch deleted relationships and update canvas
         // try to delete old node (if its not referenced by anything else anymore)
         try {
            editor.deleteNode(oldReferencedNode);
         } catch (NeoEditor.ReferenceException e) {
            System.out.println("debug: could not remove old single referenced node : " + e.getMessage());
            // ignore
         }
      }

      return addNodeReference(referencedNode, node, type);
   }

   static Relationship addNodeReference(Node referencedNode, Node node, RelationshipType type) throws NeoEditor.CircularStatementException {

      if (referencedNode.hasLabel(Statement) || referencedNode.hasLabel(SingleValue)) {
         // check existing relations and return this if already exists:
         Relationship existingRelation = null;
         for (Relationship relationship : outgoing(node, type)) {
            if (other(node, relationship).equals(referencedNode)) {
               existingRelation = relationship;
               break;
            }
         }
         if (existingRelation != null) return existingRelation;

         // constrain circular statement-relations
         if (node.hasLabel(Statement) && referencedNode.hasLabel(Statement)) {
            for (Relationship relationship : referencedNode.getRelationships(OUTGOING)) {
               if (other(referencedNode, relationship).equals(node))
                  throw new NeoEditor.CircularStatementException(node, referencedNode);
            }
         }

         final Relationship newRelationship = node.createRelationshipTo(referencedNode, type);
         newRelationship.setProperty(TemplateProperties.relationType.name(), referencedNode.hasLabel(Statement) ? Statement.name() : SingleValue.name());
         return newRelationship;
      }

      throw new IllegalArgumentException("illegal reference type: " + NeoModel.getNameOrLabelFrom(referencedNode));
   }

   static boolean isStatementParameter(Node templateParameter) {
      return singleOutgoing(templateParameter, STATEMENT_PARAMETER) != null;
   }

   static Node importTemplateStatement(Node templateGroup, com.generator.generators.templates.domain.TemplateStatement templateStatement, NeoEditor editor) {

      for (Node next : editor.getGraph().getAll(TemplateStatement.name(), TemplateProperties.name.name(), templateStatement.getName())) {
         final Node otherTemplateGroup = other(next, singleOutgoing(next, TEMPLATE_GROUP));
         assert otherTemplateGroup != null;
         if (otherTemplateGroup.equals(templateGroup))
            return next;   // return if template-group is same, and name is same:
      }

      final Node templateStatementNode = newTemplateStatement(editor.getGraph(), templateGroup, templateStatement.getName(), templateStatement.getText());

      for (TemplateParameter templateParameter : templateStatement.getParameters()) {
         switch (templateParameter.getDomainEntityType()) {
            case STRINGPROPERTY:
            case BOOLEANPROPERTY:
            case STATEMENTPROPERTY:
               newSingleTemplateParameter(editor.getGraph(), templateStatementNode, templateParameter.getPropertyName());
               break;
            case LISTPROPERTY:
               newListTemplateParameter(editor.getGraph(), templateStatementNode, templateParameter.getPropertyName());
               break;
            case KEYVALUELISTPROPERTY:
               newKeyValueListTemplateParameter(editor.getGraph(), templateStatementNode, templateParameter.getPropertyName(), templateParameter.getKvNames().toArray(new String[templateParameter.getKvNames().size()]));
               break;
         }
      }

      return templateStatementNode;
   }

   static void deleteNode(Node node) throws NeoEditor.ReferenceException {

      final Set<Relationship> constraints = new LinkedHashSet<>();
      final Consumer<Relationship> constraintVisitor = relationship -> {
         if (relationship.isType(NeoEditor.layoutMember)) return;
         constraints.add(relationship);
      };

      TemplateDomain.debugRelationsFor(node);

      if (node.hasLabel(TemplateGroup)) {

         node.getRelationships(INCOMING, TEMPLATE_GROUP).forEach(constraintVisitor);
         if (!constraints.isEmpty())
            throw new NeoEditor.ReferenceException(node, constraints);

         // delete all imports
         node.getRelationships(OUTGOING, IMPORT).forEach(Relationship::delete);

      } else if (node.hasLabel(TemplateStatement)) {

         final Set<Node> parameterNodes = new LinkedHashSet<>();
         new TemplateGroupVisitor() {
            @Override
            protected void onTemplateStatementStart(String name, String text, Node templateStatement) {
               templateStatement.getRelationships(INCOMING, TEMPLATE_STATEMENT).forEach(constraintVisitor);
            }

            @Override
            protected void onSingleTemplateParameter(String name, Node parameterNode) {
               parameterNode.getRelationships(INCOMING, TEMPLATE_PARAMETER).forEach(constraintVisitor);
               parameterNodes.add(parameterNode);
            }

            @Override
            protected void onListTemplateParameter(String name, Node parameterNode) {
               parameterNode.getRelationships(INCOMING, TEMPLATE_PARAMETER).forEach(constraintVisitor);
               parameterNodes.add(parameterNode);
            }

            @Override
            protected void onKeyValueTemplateParameter(String name, String keys, Node parameterNode) {
               parameterNode.getRelationships(INCOMING, TEMPLATE_PARAMETER).forEach(constraintVisitor);
               parameterNodes.add(parameterNode);
            }
         }.visitTemplateStatement(node);

         if (!constraints.isEmpty())
            throw new NeoEditor.ReferenceException(node, constraints);

         for (Node parameterNode : parameterNodes) {
            Relationship outgoing = singleOutgoing(parameterNode, TEMPLATE_PARAMETER);
            assert outgoing != null;
            outgoing.delete();
            deleteNode(parameterNode);
         }
         Relationship singleOutgoing = singleOutgoing(node, TEMPLATE_GROUP);
         assert singleOutgoing != null;
         singleOutgoing.delete();

      } else if (node.hasLabel(Directory)) {

         outgoing(node, DIRECTORY_MEMBER).forEach(Relationship::delete);

      } else if (node.hasLabel(Statement)) {

         node.getRelationships(INCOMING).forEach(constraintVisitor);
         if (!constraints.isEmpty())
            throw new NeoEditor.ReferenceException(node, constraints);

         // this will remove all parameter-relations (and recursively try to delete each value, if its only referenced by this statement (not shared))
         // this will also remove the TEMPLATE_STATEMENT reference for this statement
         node.getRelationships(Direction.OUTGOING).forEach(relationship -> {
            final Node other = other(node, relationship);
            relationship.delete();

            // try to delete any of the parameters for this statement, (if they are only referenced by this)
            if (other.hasLabel(SingleValue) || other.hasLabel(KeyValueSet) || other.hasLabel(Statement)) {
               try {
                  deleteNode(other);
               } catch (NeoEditor.ReferenceException e) {
                  System.out.println("parameter " + debugNode(other));
               }
            }
         });

      } else if (node.hasLabel(SingleValue)) {

         node.getRelationships(INCOMING).forEach(constraintVisitor);
         if (!constraints.isEmpty())
            throw new NeoEditor.ReferenceException(node, constraints);

         final Relationship templateRelationship = singleOutgoing(node, TEMPLATE_PARAMETER);
         if (templateRelationship != null) {
            final Node templateParameter = other(node, templateRelationship);
            assert templateParameter != null;

            final RelationshipType parameterType = RelationshipType.withName(get(templateParameter, TemplateDomain.TemplateProperties.name.name()));
            final Relationship relationship = singleIncoming(node, parameterType);
            templateRelationship.delete();
            relationship.delete();
         }

      } else if (node.hasLabel(KeyValueSet)) {

         final Relationship templateRelationship = singleOutgoing(node, TEMPLATE_PARAMETER);
         final Node templateParameter = other(node, templateRelationship);
         assert templateParameter != null;

         templateRelationship.delete();
         final RelationshipType parameterType = RelationshipType.withName(get(templateParameter, TemplateDomain.TemplateProperties.name.name()));
         final Relationship parameterRelation = singleIncoming(node, parameterType);
         if (parameterRelation != null) parameterRelation.delete();

         String keyString = getString(templateParameter, TemplateDomain.TemplateProperties.keys.name());
         assert keyString != null;
         for (String key : keyString.split(" ")) {
            final Relationship relationship = singleOutgoing(node, RelationshipType.withName(key));
            if (relationship == null) continue;

            final Node other = other(node, relationship);
            relationship.delete();

            // try to delete any of the parameters for this statement, (if they are only referenced by this)
            if (other.hasLabel(SingleValue) || other.hasLabel(KeyValueSet) || other.hasLabel(Statement)) {
               try {
                  deleteNode(other);
               } catch (NeoEditor.ReferenceException e) {
                  System.out.println("other node is used elsewhere, ignore " + debugNode(other));
               }
            }
         }
      }

      // delete from layouts:
      for (Relationship layout : incoming(node, NeoEditor.layoutMember))
         layout.delete();

      TemplateDomain.debugRelationsFor(node);

      node.delete();
   }

   private static AttributeRenderer newTemplateStringRenderer() {
      return new AttributeRenderer() {

         @Override
         public String toString(Object o, String formatString, Locale locale) {

            final String text = o.toString();

            if (formatString == null) return text;

            switch (formatString) {
               case "capitalize":
                  return capitalize(text);
               case "toUpper":
                  return toUpper(text);
               case "lowFirst":
                  return lowFirst(text);
               case "toLower":
                  return text.toLowerCase();
               case "humpToCap":
                  return humpToCap(text);
               case "camelHump":
                  return camelHump(text);
               case "splitCamelHump":
                  return splitCamelHump(text);
               case "packageToPath":
                  return packageToPath((text));
               default:
                  return o.toString();
            }
         }

         private String capitalize(String string) {
            if (string == null || string.length() == 0) return "";
            return Character.toUpperCase(string.charAt(0)) + (string.length() > 1 ? string.substring(1) : "");
         }

         private String lowFirst(String string) {
            if (string == null || string.length() == 0) return "";
            return Character.toLowerCase(string.charAt(0)) + (string.length() > 1 ? string.substring(1) : "");
         }

         private String toUpper(String text) {
            return text.toUpperCase();
         }

         private String humpToCap(String text) {
            final char[] chars = text.toCharArray();
            final StringBuilder out = new StringBuilder();
            boolean first = true;
            for (int i = 0; i < chars.length; i++) {
               char aChar = chars[i];
               if (!first && Character.isUpperCase(aChar) && (i < chars.length - 2 && Character.isLowerCase(chars[i + 1]))) {
                  out.append("_");
               }
               first = false;
               out.append(Character.toUpperCase(aChar));
            }
            return out.toString();
         }

         private String camelHump(String text) {
            final char[] chars = text.toCharArray();
            final StringBuilder out = new StringBuilder();
            boolean capitalize = true;
            for (char aChar : chars) {
               if (Character.isWhitespace(aChar)) {
                  capitalize = true;
                  continue;
               }
               out.append(capitalize ? Character.toUpperCase(aChar) : aChar);
               capitalize = false;
            }
            return out.toString();
         }

         private String splitCamelHump(String text) {
            final char[] chars = text.toCharArray();
            final StringBuilder out = new StringBuilder();
            boolean first = true;
            for (char aChar : chars) {
               if (Character.isUpperCase(aChar)) out.append(" ");
               out.append(first ? Character.toUpperCase(aChar) : Character.toLowerCase(aChar));
               first = false;
            }
            return out.toString();
         }

         private String packageToPath(String packageName) {
            return (packageName == null ? "" : (packageName.replaceAll("[.]", "/") + File.separator));
         }
      };
   }

   private static void debugRelationsFor(final Node node) {

      node.getRelationships(Direction.OUTGOING).
            forEach(relationship ->
                  System.out.println(uuidOf(node) + "(" + labelsFor(node) + ") has OUTGOING '" + relationship.getType() + "' to " + labelsFor(other(node, relationship))));

      node.getRelationships(Direction.INCOMING).forEach(relationship -> {
         if (NeoEditor.layoutMember.equals(relationship.getType())) return;
         System.out.println(uuidOf(node) + "(" + labelsFor(node) + ") has INCOMING '" + relationship.getType() + "' from " + labelsFor(other(node, relationship)));
      });
   }
}