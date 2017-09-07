package com.generator.generators.templates;

import com.generator.editors.BaseDomainVisitor;
import com.generator.editors.NeoModel;
import com.generator.editors.canvas.NeoPNodeRenderPanel;
import com.generator.editors.canvas.neo.NeoEditor;
import com.generator.editors.canvas.neo.NeoPNode;
import com.generator.generators.stringtemplate.TemplateGroupGroup;
import com.generator.generators.templates.domain.*;
import com.generator.generators.templates.domain.TemplateStatement;
import com.generator.generators.templates.parser.TemplateFileParser;
import com.generator.util.FileUtil;
import com.generator.util.StringUtil;
import com.generator.util.SwingUtil;
import com.jgoodies.forms.layout.CellConstraints;
import org.neo4j.graphdb.*;
import org.neo4j.graphdb.Label;
import org.piccolo2d.PNode;
import org.piccolo2d.event.PInputEvent;
import org.piccolo2d.nodes.PText;
import org.piccolo2d.util.PPickPath;
import org.stringtemplate.v4.AttributeRenderer;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroupString;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.AbstractTableModel;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static com.generator.editors.BaseDomainVisitor.*;
import static com.generator.editors.BaseDomainVisitor.getString;
import static com.generator.editors.NeoModel.*;
import static com.generator.editors.NeoModel.uuidOf;
import static com.generator.generators.templates.TemplateDomain.Entities.*;
import static com.generator.generators.templates.TemplateDomain.Relations.*;
import static org.neo4j.graphdb.Direction.INCOMING;
import static org.neo4j.graphdb.Direction.OUTGOING;

/**
 * goe on 11/28/16.
 * todo: export cypher / import cypher
 * todo: create group and neo from templateGroup (replace functionality in TemplateFileEditor)
 * todo: create a method for cleanup: remove all non-related SingleValues and Statements
 * todo: create a method for cloning nodes /trees ?
 * <p>
 * todo: convert this to IDomain, and allow parameters to come from various sources
 */
public class TemplateDomainImpl extends TemplateDomain {

   @Override
   public void addToDomainMenu(PInputEvent event, NeoEditor editor, JMenu domainMenu) {
      domainMenu.add(new NeoEditor.TransactionAction("New testgroup", editor) {
         @Override
         public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final Node templateGroup = TemplateDomainImpl.newTemplateGroup(graph, "TestGroup", "~");

            // create first templateStatement
            final Node templateStatement1 = TemplateDomainImpl.newTemplateStatement(graph, templateGroup, "TEMPLATE_STATEMENT_1", "Testing single value: [~singleValue~]");
            TemplateDomainImpl.newSingleTemplateParameter(graph, templateStatement1, "singleValue");

            // create second templatestatement
            final Node templateStatement2 = TemplateDomainImpl.newTemplateStatement(graph, templateGroup, "TEMPLATE_STATEMENT_2", "Testing list: [~elements:{it|~it~};separator=\",\"~]");
            TemplateDomainImpl.newListTemplateParameter(graph, templateStatement2, "elements");

            // create third templatestatement
            final Node templateStatement3 = TemplateDomainImpl.newTemplateStatement(graph, templateGroup, "TEMPLATE_STATEMENT_3", "Testing keyvalues: [~keyValues:{it|~it.name~=~it.value~};separator=\",\"~]");
            TemplateDomainImpl.newKeyValueListTemplateParameter(graph, templateStatement3, "keyValues", "name value".split(" "));

            final Node templateStatement4 = TemplateDomainImpl.newTemplateStatement(graph, templateGroup, "TEMPLATE_STATEMENT_4", "keyvalues: [~keyValues:{it|~it.name~=~it.value~};separator=\",\"~]\nlist: [~elements:{it|~it~};separator=\",\"~]\nsingle: [~singleValue~]");
            TemplateDomainImpl.newSingleTemplateParameter(graph, templateStatement4, "singleValue");
            TemplateDomainImpl.newListTemplateParameter(graph, templateStatement4, "elements");
            TemplateDomainImpl.newKeyValueListTemplateParameter(graph, templateStatement4, "keyValues", "name value".split(" "));

            final NeoPNode pNode = editor.show(uuidOf(templateGroup), TemplateGroup.name());
            pNode.setOffset(event);
            pNode.expand();
         }
      });
      domainMenu.add(new NeoEditor.TransactionAction("New TemplateGroup", editor) {
         @Override
         public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
            final String name = SwingUtil.showInputDialog("Name and delimiter", canvas);
            if (name == null) return;

            if (!name.contains(" ")) {
               SwingUtil.showMessage("Please use [name] [delimiter]\n E.g. java ~", canvas);
               return;
            }

            editor.show(uuidOf(TemplateDomainImpl.newTemplateGroup(graph, name.split(" ")[0], name.split(" ")[1])), TemplateGroup.name()).
                  setOffset(event);
         }
      });
      domainMenu.add(new NeoEditor.TransactionAction("Parse .stg file", editor) {
         @Override
         public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
            final File file = SwingUtil.showOpenFile(canvas, "/media/storage/nextgen/src/test/java/com/generator/generators/templates");
            if (file == null || !file.getName().toLowerCase().endsWith(".stg")) return;

            parseTemplateGroupFile(file, event, editor).expand();
         }
      });
   }

   static Node newTemplateGroup(NeoModel db, String name, String delimiter) {
      final Node node = db.newNode(TemplateGroup);
      node.setProperty(Properties.name.name(), name);
      node.setProperty(Properties.delimiter.name(), delimiter);

      // fixes for bugs in template (always include)
      newTemplateStatement(db, node, "eom", "}");
      newTemplateStatement(db, node, "gt", ">");

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
      node.setProperty(Properties.name.name(), templateStatementName);
      node.setProperty(Properties.text.name(), templateStatementText);
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
         node.setProperty(Properties.name.name(), newName);
         final Relationship relationship = node.createRelationshipTo(templateStatement, TEMPLATE_PARAMETER);
         relationship.setProperty(Properties.relationType.name(), SingleTemplateParameter.name());
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
         node.setProperty(Properties.name.name(), newName);
         final Relationship relationship = node.createRelationshipTo(templateStatement, TEMPLATE_PARAMETER);
         relationship.setProperty(Properties.relationType.name(), ListTemplateParameter.name());
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
               parameterNode.setProperty(Properties.keys.name(), serialized.toString().trim());
            }
         }
      }.visitTemplateStatement(templateStatement);

      if (existing.isEmpty()) {
         final Node node = db.newNode(KeyValueTemplateParameter);
         node.setProperty(Properties.name.name(), newName);
         final StringBuilder serialized = new StringBuilder();
         for (String key : newKeys) serialized.append(key).append(" ");
         node.setProperty(Properties.keys.name(), serialized.toString().trim());
         final Relationship relationship = node.createRelationshipTo(templateStatement, TEMPLATE_PARAMETER);
         relationship.setProperty(Properties.relationType.name(), KeyValueTemplateParameter.name());
         return node;
      }

      return existing.iterator().next();
   }

   private static Node newStatement(NeoModel db, Node templateStatement) {
      final Node newNode = db.newNode(Statement);
      newNode.createRelationshipTo(templateStatement, TEMPLATE_STATEMENT);
      return newNode;
   }

   private static Node newSingleValue(NeoModel db, Object value) {
      Node newNode = db.newNode(SingleValue);
      newNode.setProperty(Properties.value.name(), value.toString());
      return newNode;
   }

   private static Node newKeyValueSet(NeoModel db, Node statement, Node templateParameter) {
      final Node newNode = db.newNode(KeyValueSet);
      newNode.createRelationshipTo(templateParameter, TEMPLATE_PARAMETER);
      statement.createRelationshipTo(newNode, RelationshipType.withName(get(templateParameter, Properties.name.name())));
      return newNode;
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
            st = stGroup.getInstanceOf(get(statementTemplate, Properties.name.name()));
         }

         @Override
         protected void onSingleValue(String name, Node referenceNode, Entities referenceNodeType) {
            st.add(name, renderReferenceNode(referenceNode, referenceNodeType));
         }

         @Override
         protected void onListValue(String name, Node referenceNode, Entities referenceNodeType) {
            st.add(name, renderReferenceNode(referenceNode, referenceNodeType));
         }

         @Override
         protected void onStartKeyValueSet(String name, Node keyValueNode) {
            aggr = new StringBuilder(name + ".{");
            first = true;
            aggrValues.clear();
         }

         @Override
         protected void onKeyValue(String key, Node referenceNode, Entities referenceNodeType) {
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

   public static String renderReferenceNode(Node referenceNode, Entities referenceNodeType) {

      if (referenceNode == null) return null;

      switch (referenceNodeType) {

         case Statement:
            return render(referenceNode);

         case SingleValue:
            return get(referenceNode, Properties.value.name());

         case Reference:
            final Relationship relationship = singleOutgoing(referenceNode, Relations.REFERENCE);
            return getOtherProperty(referenceNode, relationship, getString(referenceNode, Properties.reference.name()));
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

   private static Relationship setSingleReference(Node referencedNode, Node node, RelationshipType type, NeoEditor editor) throws NeoEditor.CircularStatementException {

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

   private static Relationship addNodeReference(Node referencedNode, Node node, RelationshipType type) throws NeoEditor.CircularStatementException {

      if (referencedNode.hasLabel(Statement) || referencedNode.hasLabel(SingleValue) || referencedNode.hasLabel(Reference)) {
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
         newRelationship.setProperty(Properties.relationType.name(), referencedNode.hasLabel(Statement) ? Statement.name() : (referencedNode.hasLabel(Reference) ? Reference.name() : SingleValue.name()));
         return newRelationship;
      }

      throw new IllegalArgumentException("illegal reference type: " + NeoModel.getNameOrLabelFrom(referencedNode));
   }

   private static boolean isStatementParameter(Node templateParameter) {
      return singleOutgoing(templateParameter, STATEMENT_PARAMETER) != null;
   }

   private static Node importTemplateStatement(Node templateGroup, com.generator.generators.templates.domain.TemplateStatement templateStatement, NeoEditor editor) {

      for (Node next : editor.getGraph().getAll(TemplateStatement.name(), Properties.name.name(), templateStatement.getName())) {
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

   @Override
   public void deleteNode(Node node) throws NeoEditor.ReferenceException {

      final Set<Relationship> constraints = new LinkedHashSet<>();
      final Consumer<Relationship> constraintVisitor = relationship -> {
         if (NeoEditor.isAppRelated(relationship)) return;
         constraints.add(relationship);
      };

      TemplateDomainImpl.debugRelationsFor(node);

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
            if (other.hasLabel(SingleValue) || other.hasLabel(KeyValueSet) || other.hasLabel(Statement) || other.hasLabel(Reference)) {
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

            final RelationshipType parameterType = RelationshipType.withName(get(templateParameter, Properties.name.name()));
            final Relationship relationship = singleIncoming(node, parameterType);
            templateRelationship.delete();
            relationship.delete();
         }

      } else if (node.hasLabel(Reference)) {

         node.getRelationships().forEach(Relationship::delete);

      } else if (node.hasLabel(KeyValueSet)) {

         final Relationship templateRelationship = singleOutgoing(node, TEMPLATE_PARAMETER);
         final Node templateParameter = other(node, templateRelationship);
         assert templateParameter != null;

         templateRelationship.delete();
         final RelationshipType parameterType = RelationshipType.withName(get(templateParameter, Properties.name.name()));
         final Relationship parameterRelation = singleIncoming(node, parameterType);
         if (parameterRelation != null) parameterRelation.delete();

         String keyString = getString(templateParameter, Properties.keys.name());
         assert keyString != null;
         for (String key : keyString.split(" ")) {
            final Relationship relationship = singleOutgoing(node, RelationshipType.withName(key));
            if (relationship == null) continue;

            final Node other = other(node, relationship);
            relationship.delete();

            // try to delete any of the parameters for this statement, (if they are only referenced by this)
            if (other.hasLabel(SingleValue) || other.hasLabel(KeyValueSet) || other.hasLabel(Statement) || other.hasLabel(Reference)) {
               try {
                  deleteNode(other);
               } catch (NeoEditor.ReferenceException e) {
                  System.out.println("other node is used elsewhere, ignore " + debugNode(other));
               }
            }
         }

      } else {
         System.out.println("trying to delete unhandled node " + BaseDomainVisitor.labelsFor(node));
      }

      // delete from layouts:
      NeoEditor.removeFromLayouts(node);
      TemplateDomainImpl.debugRelationsFor(node);

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
         if (NeoEditor.isAppRelated(relationship)) return;
         System.out.println(uuidOf(node) + "(" + labelsFor(node) + ") has INCOMING '" + relationship.getType() + "' from " + labelsFor(other(node, relationship)));
      });
   }

   private static NeoPNode parseTemplateGroupFile(File file, PInputEvent event, NeoEditor editor) {
      final TemplateFile templateFile = new TemplateFileParser().parse(file);

      // create new or use existing node with same name as templategroup:
      final String name = templateFile.getName().replaceAll(".stg", "");
      final Iterator<Node> iterator = editor.getGraph().getAll(TemplateGroup.name(), TemplateDomainImpl.Properties.name.name(), name).iterator();
      if (iterator.hasNext()) {
         final NeoPNode newTemplateGroupNode = editor.show(uuidOf(iterator.next()), TemplateGroup.name());
         newTemplateGroupNode.setOffset(event);
         return newTemplateGroupNode;
      }

      final Node templateGroup = TemplateDomainImpl.newTemplateGroup(editor.getGraph(), name, templateFile.getDelimiter() + "");

      for (TemplateImport templateImport : templateFile.getImports()) {
         final File templateFileImport = new File(file.getParentFile(), templateImport.getName() + ".stg");
         final NeoPNode imported = parseTemplateGroupFile(templateFileImport, event, editor);
         templateGroup.createRelationshipTo(imported.node, IMPORT);
         editor.show(uuidOf(imported.node), TemplateGroup.name());
      }

      for (com.generator.generators.templates.domain.TemplateStatement templateStatement : templateFile.getStatements())
         TemplateDomainImpl.importTemplateStatement(templateGroup, templateStatement, editor);

      final NeoPNode newTemplateGroupNode = editor.show(uuidOf(templateGroup), TemplateGroup.name());
      newTemplateGroupNode.setOffset(event);
      return newTemplateGroupNode;
   }

   static class CompositePText extends PText {

      @Override
      public void layoutChildren() {
         layoutHorizontal();
      }

      private void layoutHorizontal() {
         double xOffset = 0;
         final double yOffset = 0;

         final Iterator i = getChildrenIterator();
         while (i.hasNext()) {
            final PNode each = (PNode) i.next();
            each.setOffset(xOffset, yOffset);
            xOffset += each.getWidth() + 5;
         }
      }

      @Override
      public boolean fullPick(PPickPath pickPath) {
         if (super.fullPick(pickPath)) {
            PNode picked = pickPath.getPickedNode();
            // this code won't work with internal cameras, because it doesn't
            // pop the cameras view transform.
            while (picked != this) {
               pickPath.popTransform(picked.getTransformReference(false));
               pickPath.popNode(picked);
               picked = pickPath.getPickedNode();
            }
            return true;
         }
         return false;
      }
   }

//   private static class NewTestGroup extends NeoEditor.TransactionAction {
//
//      private final PInputEvent event;
//
//      NewTestGroup(PInputEvent event, NeoEditor editor) {
//         super("New Testgroup", editor);
//         this.event = event;
//      }
//
//
//   }

//   private static class NewTemplateGroup extends NeoEditor.TransactionAction {
//      private final PInputEvent event;
//
//      NewTemplateGroup(PInputEvent event, NeoEditor editor) {
//         super("New TemplateGroup", editor);
//         this.event = event;
//      }
//
//      @Override
//      public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
//
//
//      }
//   }

//   private static class ParseTemplateGroup extends NeoEditor.TransactionAction {
//      private final PInputEvent event;
//
//      ParseTemplateGroup(PInputEvent event, NeoEditor editor) {
//         super("Parse TemplateGroup", editor);
//         this.event = event;
//      }
//
//      @Override
//      public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
//
//
//      }
//   }

   static class TemplateEditor extends SwingUtil.FormPanel {

      final JTextField txtStatementName = new JTextField();
      final JTextArea txtEditor = new JTextArea();
      final Border defaultBorder = txtEditor.getBorder();
      final JTable tblParameters = new JTable();
      final JButton btnSetStatementLabel = new JButton();
      final java.util.List<TemplateParameter> parameters = new ArrayList<>();

      private String statementLabel;

      TemplateEditor(String delimiter, String name, String text, String initLabel) {
         super("50dlu, 4dlu, 350dlu:grow", "pref, 4dlu, 225dlu:grow, 4dlu, 66dlu, 4dlu, pref");

         int row = 1;
         addLabel("Name", 1, row);
         add(txtStatementName, 3, row);

         row += 2;
         addLabel("Text", 1, row, CellConstraints.LEFT, CellConstraints.TOP);
         addScrollPane(txtEditor, 3, row, 1, 1);

         row += 2;
         addLabel("Parameters", 1, row, CellConstraints.LEFT, CellConstraints.TOP);
         addScrollPane(tblParameters, 3, row, 1, 1);

         row += 2;
         addLabel("Label", 1, row).setToolTipText("Which Parameter-value to use as label for statements based on this template");
         add(btnSetStatementLabel, 3, row);

         txtEditor.setFont(new Font("Hack", Font.PLAIN, 10));
         txtEditor.setTabSize(3);
         txtStatementName.setText(name);
         txtEditor.setText(text);
         txtEditor.setCaretPosition(0);

         this.statementLabel = initLabel;
         btnSetStatementLabel.setText(this.statementLabel == null ? "NOT SET" : this.statementLabel);
         btnSetStatementLabel.setToolTipText("Select Parameter to use as label for statement based on this template");

         final DefaultHighlighter.DefaultHighlightPainter paramsHighlighter = new DefaultHighlighter.DefaultHighlightPainter(new Color(255, 127, 0));

         txtEditor.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {

               if (ke.getKeyCode() == KeyEvent.VK_ENTER && ke.getModifiers() == KeyEvent.CTRL_MASK) {
                  try {
                     parseAndValidate(delimiter);
                  } catch (Exception e) {
                     SwingUtil.showException(txtEditor, e);
                  }

               } else if (ke.getKeyCode() == KeyEvent.VK_L && ke.getModifiers() == KeyEvent.CTRL_MASK) {
                  insertListProperty();

               } else if (ke.getKeyCode() == KeyEvent.VK_I && ke.getModifiers() == KeyEvent.CTRL_MASK) {
                  insertIf();

               } else if (ke.getKeyCode() == KeyEvent.VK_SPACE && ke.getModifiers() == KeyEvent.CTRL_MASK) {
                  insertSimpleProperty();

               } else if (ke.getKeyCode() == KeyEvent.VK_R && ke.getModifiers() == KeyEvent.CTRL_MASK) {
                  replaceAndInsertProperty();

               } else if (ke.getKeyCode() == KeyEvent.VK_M && ke.getModifiers() == KeyEvent.CTRL_MASK) {
                  makeMethod();

               } else if (ke.getKeyCode() == KeyEvent.VK_DELETE && ke.getModifiers() == KeyEvent.SHIFT_MASK) {
                  deleteCurrentLine();
               }
            }

            private void makeMethod() {
               final String selected = txtEditor.getSelectedText();
               if (selected == null || selected.length() < 1) return;
               System.out.println(selected);
            }

            private void replaceAndInsertProperty() {
               final String selected = txtEditor.getSelectedText();
               if (selected == null || selected.length() < 1) return;

               final String propertyName = SwingUtil.showInputDialog("propertyName", txtEditor);
               if (propertyName == null) return;

               final String replacement = delimiter + propertyName + delimiter;
               txtEditor.setText(txtEditor.getText().replaceAll(selected, (delimiter.equals("$") ? replacement.replaceAll("\\$", "\\\\\\$") : replacement)));
               SwingUtil.tryToHighlight(txtEditor, Collections.singletonList(replacement), paramsHighlighter);
            }

            private void insertSimpleProperty() {
               SwingUtilities.invokeLater(() -> {

                  removeSelectedTextIfAny();

                  final int caretPosition = txtEditor.getCaretPosition();
                  txtEditor.insert(delimiter + "" + delimiter, caretPosition);
                  txtEditor.setCaretPosition(caretPosition + 1);
               });
            }

            private void insertListProperty() {

               final String input = SwingUtil.showInputDialog(TemplateDomainImpl.Properties.name.name(), txtEditor);
               if (input == null) return;

               final String name = input.contains(" ") ? input.split(" ")[0] : input.trim();
               final String separator = input.contains(" ") ? input.split(" ")[1] : null;

               SwingUtilities.invokeLater(() -> {

                  removeSelectedTextIfAny();

                  final int caretPosition = txtEditor.getCaretPosition();
                  final String pre = delimiter + name + ":{it|";
                  final String sep = separator == null ? "" : ";separator=\"" + separator + "\"";
                  final String list = pre + "}" + sep + delimiter;
                  txtEditor.insert(list, caretPosition);
                  txtEditor.setCaretPosition(caretPosition + pre.length());
               });
            }

            private void removeSelectedTextIfAny() {
               if (txtEditor.getSelectedText() != null) {
                  final int selectionStart = txtEditor.getSelectionStart();
                  txtEditor.replaceRange("", selectionStart, txtEditor.getSelectionEnd());
                  txtEditor.setCaretPosition(selectionStart);
               }
            }

            private void insertIf() {

               final String input = SwingUtil.showInputDialog("condition", txtEditor);
               if (input == null) return;

               final String name = input.trim();

               SwingUtilities.invokeLater(() -> {

                  removeSelectedTextIfAny();

                  final int caretPosition = txtEditor.getCaretPosition();
                  final String pre = delimiter + "if(" + name + ")" + delimiter;
                  final String list = pre + delimiter + "endif" + delimiter;
                  txtEditor.insert(list, caretPosition);
                  txtEditor.setCaretPosition(caretPosition + pre.length());
               });
            }

            private void deleteCurrentLine() {
               final String txt = txtEditor.getText();
               int startOfLine = txtEditor.getCaretPosition();
               while (startOfLine > 0) {

                  startOfLine--;

                  if (startOfLine < 0) {
                     startOfLine++;
                     break;
                  }

                  if (txt.charAt(startOfLine) == '\n') {
                     startOfLine++;
                     break;
                  }
               }

               int endOfLine = startOfLine;
               while (endOfLine < txt.length()) {

                  if (endOfLine >= txt.length()) {
                     endOfLine = txt.length() - 1;
                     break;
                  }

                  if (txt.charAt(endOfLine) == '\n') {
                     break;
                  }

                  endOfLine++;
               }

               if (endOfLine == startOfLine) {
                  endOfLine++;
                  if (endOfLine >= txt.length())
                     endOfLine = txt.length() - 1;
               }

               if (endOfLine <= startOfLine) return;

               txtEditor.replaceRange("", startOfLine, endOfLine);
            }
         });

         tblParameters.setModel(new AbstractTableModel() {
            @Override
            public int getRowCount() {
               return parameters.size();
            }

            @Override
            public int getColumnCount() {
               return 2;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
               final TemplateParameter templateParameter = parameters.get(rowIndex);
               switch (columnIndex) {
                  case 0:
                     return parameters.get(rowIndex).getPropertyName();
                  case 1:
                     return parameters.get(rowIndex).getDomainEntityType();
               }

               return templateParameter;
            }

            @Override
            public String getColumnName(int column) {
               switch (column) {
                  case 0:
                     return "Name";
                  case 1:
                     return "Type";
               }
               throw new IllegalArgumentException("Illegal column " + column);
            }
         });

         tblParameters.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               final int selectedRow = tblParameters.getSelectedRow();
               if (selectedRow == -1) return;

               final TemplateParameter templateParameter = parameters.get(selectedRow);

               final String name = templateParameter.getPropertyName();
               final String simple = delimiter + name + delimiter;
               final String formatted = delimiter + name + ";";
               final String list = delimiter + name + ":";
               final String methodCall = delimiter + name + "(";
               final String methodParam = "=" + name;
               final String ifName = delimiter + "if(" + name + ")" + delimiter;
               SwingUtil.tryToHighlight(txtEditor, Arrays.asList(simple, formatted, list, methodCall, methodParam, ifName), paramsHighlighter);
            }
         });

         btnSetStatementLabel.addActionListener(e -> SwingUtilities.invokeLater(() -> {
            final Set<String> legalParameters = parameters.stream().filter(parameter -> TemplateEntities.STRINGPROPERTY.equals(parameter.getDomainEntityType())).map(TemplateParameter::getPropertyName).collect(Collectors.toCollection(TreeSet::new));
            final String s = SwingUtil.showSelectDialog(txtEditor, "Select parameter to use as label:", "Parameter label", legalParameters);
            if (s == null) return;
            statementLabel = s;
            btnSetStatementLabel.setText(statementLabel = s);
         }));

         // try to parse if default text:
         if (text.length() > 0) {
            try {
               parseAndValidate(delimiter);
            } catch (Exception e) {
               txtEditor.setBorder(BorderFactory.createLineBorder(Color.RED));
            }
         }
      }

      String getStatementLabel() {
         return statementLabel;
      }

      TemplateStatement parseAndValidate(String delimiter) throws Exception {

         final int oldCaret = txtEditor.getCaretPosition();
         txtEditor.setBorder(defaultBorder);

         final String text = txtEditor.getText();

         System.out.println("todo ST-bugfixes here (escape } inside anonymous key-value templates, and >> inside statement");
         // 2 bugfixes: } inside anonymous key-value list
         // and >> inside statement

         final TemplateStatement parsed = new TemplateFileParser().parse(delimiter, txtStatementName.getText().trim(), text);
         if (parsed == null)
            throw new Exception("Unparseable template. Check properties and try again.");

         SwingUtilities.invokeLater(() -> {

            parameters.clear();
            parameters.addAll(parsed.getParameters().stream().collect(Collectors.toList()));

            ((AbstractTableModel) tblParameters.getModel()).fireTableDataChanged();

            txtEditor.setText(parsed.getText().trim());
            txtEditor.setCaretPosition(Math.min(text.length(), Math.max(0, oldCaret)));
         });

         return parsed;
      }
   }

   static class OldTemplateDomainPNode extends NeoPNode<PText> {

      final Color selectedColor = Color.RED;
      protected final Color defaultColor;
      protected String property;
      protected final TemplateDomainImpl.Entities nodeType;

      OldTemplateDomainPNode(Node node, TemplateDomainImpl.Entities nodeType, String property, String[] defaultColor, NeoEditor editor) {
         super(node, new PText(node.hasProperty(property) ? node.getProperty(property).toString() : getNameOrLabelFrom(node)), nodeType.name(), editor);
         this.defaultColor = new Color(Integer.valueOf(defaultColor[0]), Integer.valueOf(defaultColor[1]), Integer.valueOf(defaultColor[2]));
         this.property = property;
         this.nodeType = nodeType;
         pNode.setTextPaint(this.defaultColor);
         pNode.setFont(new Font("Hack", Font.BOLD, 12));
      }

      OldTemplateDomainPNode(Node node, PText representation, TemplateDomainImpl.Entities nodeType, String[] defaultColor, NeoEditor editor) {
         super(node, representation, nodeType.name(), editor);
         this.defaultColor = new Color(Integer.valueOf(defaultColor[0]), Integer.valueOf(defaultColor[1]), Integer.valueOf(defaultColor[2]));
         this.property = null;
         this.nodeType = nodeType;
         pNode.setTextPaint(this.defaultColor);
         pNode.setFont(new Font("Hack", Font.PLAIN, 12));
      }

      @Override
      public String getNodeType() {
         return nodeType.name();
      }

      @Override
      public void expand() {

      }

      @Override
      public void showDependents() {

      }

      @Override
      public void keyPressed(PInputEvent event) {
         super.keyPressed(event);
      }

      @Override
      public void updateView() {
         pNode.setText(getNodeLabel(node, property));
      }

      @Override
      public void onSelect() {
         pNode.setTextPaint(selectedColor);
      }

      @Override
      public void onUnselect() {
         pNode.setTextPaint(defaultColor);
      }

      @Override
      public void onStartHighlight() {
         pNode.setTextPaint(Color.ORANGE);
      }

      @Override
      public void onEndHighlight() {
         pNode.setTextPaint(selected.get() ? selectedColor : defaultColor);
      }

      @Override
      public void showNodeActions(JPopupMenu pop, PInputEvent event) {

         pop.add(new NeoEditor.TransactionAction("Select all " + nodeType, editor) {
            @Override
            public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
               editor.getAllNodes().forEach(neoPNode -> {
                  if (neoPNode.getNodeType().equals(nodeType.name()) && !neoPNode.selected.get())
                     neoPNode.select();
               });
            }
         });
         pop.add(new NeoEditor.TransactionAction("Hide all " + nodeType, editor) {
            @Override
            public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
               final Set<UUID> hide = new LinkedHashSet<>();
               editor.getAllNodes().forEach(pNode -> {
                  if (pNode.getNodeType().equals(nodeType.name())) hide.add(pNode.uuid);
               });
               hide.forEach(editor::removeNodeFromCanvas);
            }
         });

         pop.add(retainNode());
         pop.add(hideNode());
         pop.add(deleteNode());
      }
   }


   @Override
   protected NeoPNode newKeyValueSetPNode(Node node, NeoEditor editor) {

      final Node templateParameter = other(node, singleOutgoing(node, Relations.TEMPLATE_PARAMETER));

      return new TemplateDomain.KeyValueSetPNode(node, editor) {
         @Override
         public void expand() {
            final Map<UUID, org.neo4j.graphdb.Label> pNodes = new LinkedHashMap<>();
            for (String key : getString(templateParameter, TemplateDomainImpl.Properties.keys.name()).split(" ")) {
               final Relationship kvRelation = singleOutgoing(node, RelationshipType.withName(key));
               if (kvRelation == null) continue;
               pNodes.put(uuidOf(other(node, kvRelation)), TemplateDomainImpl.Entities.valueOf(getString(kvRelation, TemplateDomainImpl.Properties.relationType.name())));
            }
            editor.showAndLayout(pNodes, pNode);
         }

         @Override
         public void onSelect() {
            super.onSelect();
            for (Object o : pNode.getChildrenReference()) ((PText) o).setTextPaint(selectedColor);
         }

         @Override
         public void onUnselect() {
            super.onUnselect();
            for (Object o : pNode.getChildrenReference()) ((PText) o).setTextPaint(defaultColor);
         }

         @Override
         public void onStartHighlight() {
            super.onStartHighlight();
            for (Object o : pNode.getChildrenReference()) ((PText) o).setTextPaint(Color.ORANGE);
         }

         @Override
         public void onEndHighlight() {
            super.onEndHighlight();
            final Color textPaint = selected.get() ? selectedColor : defaultColor;
            for (Object o : pNode.getChildrenReference()) ((PText) o).setTextPaint(textPaint);
         }

         @Override
         public void updateView() {
            pNode.removeAllChildren();

            for (String key : getString(templateParameter, TemplateDomainImpl.Properties.keys.name()).split(" ")) {
               final PText keyName = new PText();
               keyName.setFont(new Font("Hack", Font.PLAIN, 11));
               keyName.setTextPaint(selected.get() ? selectedColor : defaultColor);
               pNode.addChild(keyName);

               final Relationship kvRelation = singleOutgoing(node, RelationshipType.withName(key));
               if (kvRelation == null) {
                  keyName.setText("[" + key + "]");
                  continue;
               }
               keyName.setText(TemplateDomainImpl.renderReferenceNode(other(node, kvRelation), TemplateDomainImpl.Entities.valueOf(getString(kvRelation, TemplateDomainImpl.Properties.relationType.name()))));
            }
         }

         @Override
         public void showNodeActions(JPopupMenu pop, PInputEvent event) {

            final JMenu setMenu = new JMenu("Set");
            final JMenu removeMenu = new JMenu("Remove");
            final String[] keys = getString(templateParameter, TemplateDomainImpl.Properties.keys.name()).split(" ");
            for (String key : keys) {
               setMenu.add(new SetKeyValue(key, editor));

               final Relationship kvRelation = singleOutgoing(node, RelationshipType.withName(key));
               if (kvRelation == null) continue;

               final Node kvValue = other(node, kvRelation);
               removeMenu.add(new DetachReference(key, kvValue, editor));
            }
            pop.add(setMenu);
            if (removeMenu.getMenuComponentCount() > 0) pop.add(removeMenu);

            pop.add(new Expand(editor));
            pop.add(new Edit(keys, editor));
            super.showNodeActions(pop, event);
         }

         @Override
         public void showTargetActions(JPopupMenu pop, PInputEvent event) {

            final Collection<NeoPNode> selectedNodes = editor.getSelectedNodes();

            for (String key : getString(templateParameter, TemplateDomainImpl.Properties.keys.name()).split(" ")) {
               if (selectedNodes.size() == 1) {
                  final Node selectedNode = selectedNodes.iterator().next().node;

                  // if selected node is Statement or SingleValue - set
                  if (selectedNode.hasLabel(Statement) || selectedNode.hasLabel(SingleValue)) {
                     pop.add(new NeoEditor.TransactionAction("Set " + key, editor) {
                        @Override
                        public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                           editor.addRelation(TemplateDomainImpl.setSingleReference(selectedNode, node, RelationshipType.withName(key), editor));
                           updateView();
                           editor.clearMousePosition();
                        }
                     });

                  } else {

                     if (selectedNode.getPropertyKeys().iterator().hasNext()) {

                        // if its something else, create a reference-node, and select property in selected node to be referenced and used
                        pop.add(new NeoEditor.TransactionAction("Set " + key, editor) {
                           @Override
                           public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

                              final String property = SwingUtil.showSelectDialog(editor.getCanvas(), selectedNode.getPropertyKeys());
                              if (property == null) return;

                              final Node referenceNode = editor.getGraph().newNode(Reference);
                              referenceNode.setProperty(Properties.reference.name(), property);
                              referenceNode.createRelationshipTo(selectedNode, Relations.REFERENCE);
                              editor.show(uuidOf(referenceNode), Reference.name()).setOffset(event);

                              editor.addRelation(TemplateDomainImpl.setSingleReference(referenceNode, node, RelationshipType.withName(key), editor));
                              updateView();
                              editor.clearMousePosition();
                           }
                        });
                     }
                  }
               }
            }
         }

         class Expand extends NeoEditor.TransactionAction {

            Expand(NeoEditor editor) {
               super("Expand", editor);
            }

            @Override
            public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
               expand();
            }
         }

         class SetKeyValue extends NeoEditor.TransactionAction {
            private final String key;

            SetKeyValue(String key, NeoEditor editor) {
               super("Set " + key, editor);
               this.key = key;
            }

            @Override
            public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

               final String newValue = SwingUtil.showInputDialog(key + " value", editor.canvas);
               if (newValue == null) return;

               final Node newSingleValue = TemplateDomainImpl.newSingleValue(editor.getGraph(), newValue);
               editor.addRelation(TemplateDomainImpl.setSingleReference(newSingleValue, node, RelationshipType.withName(key), editor));
               updateView();
            }
         }

         class DetachReference extends NeoEditor.TransactionAction {

            private final Node referencedNode;

            DetachReference(String key, Node referencedNode, NeoEditor editor) {
               super("Detach " + key, editor);
               this.referencedNode = referencedNode;
            }

            @Override
            public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
               node.getRelationships(Direction.OUTGOING).forEach(relationship -> {
                  if (other(node, relationship).equals(referencedNode))
                     relationship.delete();
               });
               updateView();
            }
         }

         class Edit extends NeoEditor.TransactionAction {

            private final String[] keys;

            public Edit(String[] keys, NeoEditor editor) {
               super("Edit ", editor);
               this.keys = keys;
            }

            @Override
            public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

               final Map<String, JTextField> txtKeyValues = new LinkedHashMap<>();
               final Map<String, String> existingValues = new LinkedHashMap<>();
               final StringBuilder rows = new StringBuilder();
               for (int i = 0; i < keys.length; i++) {
                  if (i >= 1) rows.append(", 4dlu, ");
                  rows.append("pref");
                  txtKeyValues.put(keys[i], new JTextField());
                  existingValues.put(keys[i], "");
               }
               final SwingUtil.FormPanel form = new SwingUtil.FormPanel("50dlu, 4dlu, 150dlu:grow", rows.toString().trim());
               form.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

               for (String key : keys) {
                  final Relationship kvRelation = singleOutgoing(node, RelationshipType.withName(key));
                  if (kvRelation == null) continue;

                  final Node kvValue = other(node, kvRelation);
                  final String textValue = TemplateDomainImpl.renderReferenceNode(kvValue, TemplateDomainImpl.Entities.valueOf(getString(kvRelation, TemplateDomainImpl.Properties.relationType.name())));
                  txtKeyValues.get(key).setText(textValue);
                  existingValues.put(key, textValue);
               }

               int row = 1;
               for (String key : keys) {
                  form.addLabel(key, 1, row);
                  form.add(txtKeyValues.get(key), 3, row);
                  row += 2;
               }

               SwingUtil.showDialog(form, editor.canvas, "Edit", () -> editor.doInTransaction(tx1 -> {
                  for (String key : keys) {
                     final String newValue = txtKeyValues.get(key).getText().trim();
                     if (newValue.equals(existingValues.get(key))) continue;

                     final Node newSingleValue = TemplateDomainImpl.newSingleValue(editor.getGraph(), newValue);
                     editor.addRelation(TemplateDomainImpl.setSingleReference(newSingleValue, node, RelationshipType.withName(key), editor));
                  }

                  updateView();
               }));
            }
         }
      };
   }

//   static class KeyValueSetPNode extends TemplateDomainPNode {

//      private
//      private final Color defaultColor;

//      KeyValueSetPNode(Node keyValueNode, PText pText, NeoEditor editor, Node templateParameter) {
//         super(keyValueNode, pText, KeyValueSet, "0, 68, 27".split(", "), editor);
//         pNode.setFont(new Font("Hack", Font.PLAIN, 11));
//         this.templateParameter = templateParameter;

//         defaultColor = new Color(Integer.valueOf("0, 68, 27".split(", ")[0]), Integer.valueOf("0, 68, 27".split(", ")[1]), Integer.valueOf("0, 68, 27".split(", ")[2]));
//         updateView();
//      }

//   }

   @Override
   protected NeoPNode newSingleValuePNode(Node node, NeoEditor editor) {
      return new SingleValuePNode(node, editor) {
         @Override
         public void showDependents() {
            final Map<UUID, org.neo4j.graphdb.Label> pNodes = new LinkedHashMap<>();

            for (Relationship relationship : node.getRelationships(INCOMING)) {
               if (NeoEditor.isAppRelated(relationship)) continue;
               final Node other = other(node, relationship);
               if (hasLabel(other, TemplateDomainImpl.Entities.Statement.name()))
                  pNodes.put(uuidOf(other(node, relationship)), TemplateDomainImpl.Entities.Statement);
               else if (hasLabel(other, TemplateDomainImpl.Entities.KeyValueSet.name()))
                  pNodes.put(uuidOf(other(node, relationship)), TemplateDomainImpl.Entities.KeyValueSet);
               else
                  System.out.println(other.getLabels().iterator().next());
            }

            editor.showAndLayout(pNodes, pNode);
         }

         @Override
         public void updateView() {
            final String value = getString(node, TemplateDomainImpl.Properties.value.name());
            pNode.setText(value == null ? SingleValue.name() : (value.length() == 0 ? "EMPTY" : value));
         }

         @Override
         public void showNodeActions(JPopupMenu pop, PInputEvent event) {
            pop.add(new SetValue(editor));
            super.showNodeActions(pop, event);
         }

         class SetValue extends NeoEditor.TransactionAction {

            SetValue(NeoEditor editor) {
               super("Edit value", editor);
            }

            @Override
            public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

               final String defaultValue = get(node, TemplateDomainImpl.Properties.value.name());
               final String newValue = SwingUtil.showInputDialog("Value", editor.canvas, defaultValue);
               if (newValue == null || newValue.trim().equals(defaultValue)) return;

               node.setProperty(TemplateDomainImpl.Properties.value.name(), newValue.trim());

               // notify any nodes referencing this
               editor.visitRelations(neoRelationshipPath -> {
                  if (!neoRelationshipPath.target.node.equals(node)) return;
                  // node is being referred by another visible node, update view on this node:
                  neoRelationshipPath.source.updateView();
               });

               updateView();
            }
         }
      };
   }

   @Override
   protected NeoPNode newReferencePNode(Node node, NeoEditor editor) {
      return new ReferencePNode(node, editor) {
         @Override
         public void updateView() {

            pNode.setText("(\"" + node.getProperty(Properties.reference.name()) + "\")");
         }

         @Override
         public void showNodeActions(JPopupMenu pop, PInputEvent event) {

            pop.add(new NeoEditor.TransactionAction("Change property", editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

                  final Relationship outgoing = singleOutgoing(node, Relations.REFERENCE);
                  final Node selectedNode = other(node, outgoing);

                  final String property = SwingUtil.showSelectDialog(editor.getCanvas(), "Property to use", "Select Property from node", selectedNode.getPropertyKeys());
                  if (property == null) return;

                  node.setProperty(Properties.reference.name(), property);
                  updateView();
               }
            });

            pop.add(deleteNode());
         }
      };
   }

   @Override
   protected NeoPNode newStatementPNode(Node node, NeoEditor editor) {

      final Node templateStatement = other(node, singleOutgoing(node, TEMPLATE_STATEMENT));

      return new TemplateDomain.StatementPNode(node, editor) {
         @Override
         public void updateView() {
            pNode.setText(getNodeLabel(templateStatement, Properties.name.name()));
         }

         @Override
         public void expand() {

            final Map<UUID, org.neo4j.graphdb.Label> pNodes = new LinkedHashMap<>();

            new StatementVisitor() {

               @Override
               protected void onSingleValue(String name, Node referenceNode, TemplateDomainImpl.Entities referenceNodeType) {
                  pNodes.put(uuidOf(referenceNode), referenceNodeType);
               }

               @Override
               protected void onListValue(String name, Node referenceNode, TemplateDomainImpl.Entities referenceNodeType) {
                  pNodes.put(uuidOf(referenceNode), referenceNodeType);
               }

               @Override
               protected void onStartKeyValueSet(String name, Node keyValueNode) {
                  pNodes.put(uuidOf(keyValueNode), KeyValueSet);
               }
            }.visitStatement(node);

            editor.showAndLayout(pNodes, pNode);
         }

         @Override
         public void showDependents() {

            final Map<UUID, org.neo4j.graphdb.Label> pNodes = new LinkedHashMap<>();

            for (Relationship relationship : node.getRelationships(INCOMING)) {
               if (NeoEditor.isAppRelated(relationship)) continue;
               final Node other = other(node, relationship);
               if (hasLabel(other, Entities.Directory.name()))
                  pNodes.put(uuidOf(other(node, relationship)), Entities.Directory);
               else
                  System.out.println(other.getLabels().iterator().next());
            }

            // also show TemplateStatement (makes logic sense)
            final Relationship relationship = singleOutgoing(node, TEMPLATE_STATEMENT);
            pNodes.put(uuidOf(other(node, relationship)), TemplateDomainImpl.Entities.TemplateStatement);

            editor.showAndLayout(pNodes, pNode);
         }

         @Override
         public void showNodeActions(JPopupMenu pop, PInputEvent event) {

            final JMenu setMenu = new JMenu("Set");
            final JMenu addMenu = new JMenu("Add");
            final AtomicBoolean hasEditableParameters = new AtomicBoolean(false);
            new TemplateGroupVisitor() {
               @Override
               protected void onSingleTemplateParameter(String name, Node templateParameter) {

                  // check if templateParameter has parameterNode.createRelationshipTo(templateStatement, TemplateDomain.Relations.STATEMENT_PARAMETER)
                  final Relationship statementParameterRelation = BaseDomainVisitor.singleOutgoing(templateParameter, STATEMENT_PARAMETER);
                  if (statementParameterRelation != null)
                     return;

                  setMenu.add(new SetSingleValue(name, event, templateParameter, editor));
                  hasEditableParameters.set(true);
               }

               @Override
               protected void onListTemplateParameter(String name, Node templateParameter) {
                  addMenu.add(new AddListValues(name, templateParameter, editor));
               }

               @Override
               protected void onKeyValueTemplateParameter(String name, String keys, Node templateParameter) {
                  addMenu.add(new AddKeyValueSets(name, event, templateParameter, editor));
               }
            }.visitTemplateStatement(templateStatement);

            final JMenu removeMenu = new JMenu("Remove");
            new StatementVisitor() {

               @Override
               protected void onSingleValue(String name, Node referenceNode, TemplateDomainImpl.Entities referenceNodeType) {
                  removeMenu.add(new DetachReferenceAction(name, referenceNode, referenceNodeType, editor, TemplateDomainImpl.this));
               }

               @Override
               protected void onListValue(String name, Node referenceNode, TemplateDomainImpl.Entities referenceNodeType) {
                  removeMenu.add(new DetachReferenceAction(name, referenceNode, referenceNodeType, editor, TemplateDomainImpl.this));
               }
            }.visitStatement(node);

            if (addMenu.getMenuComponentCount() > 0) pop.add(addMenu);
            if (setMenu.getMenuComponentCount() > 0) pop.add(setMenu);
            if (removeMenu.getMenuComponentCount() > 0) pop.add(removeMenu);

            if (hasEditableParameters.get())
               pop.add(new Edit(event, editor));

            pop.add(new RenderToClipboard(editor));
            pop.add(new ShowTemplate(event, editor));

            super.showNodeActions(pop, event);
         }

         @Override
         public void showTargetActions(JPopupMenu pop, PInputEvent event) {

            final Collection<NeoPNode> selectedNodes = editor.getSelectedNodes();

            if (selectedNodes.size() != 1) return;

            new TemplateGroupVisitor() {
               @Override
               protected void onSingleTemplateParameter(final String name, Node templateParameter) {
                  final Node selectedNode = selectedNodes.iterator().next().node;

                  // check if templateParameter has parameterNode.createRelationshipTo(templateStatement, TemplateDomain.Relations.STATEMENT_PARAMETER)
                  final Relationship statementParameterRelation = BaseDomainVisitor.singleOutgoing(templateParameter, STATEMENT_PARAMETER);
                  if (statementParameterRelation != null) {
                     if (!selectedNode.hasLabel(Statement)) {
                        return;  // if not a statement, disallow selected node for this parameter
                     }

                     final Node templateStatementNode = other(templateParameter, statementParameterRelation);
                     final Node selectedTemplateStatementNode = other(selectedNode, BaseDomainVisitor.singleOutgoing(selectedNode, TEMPLATE_STATEMENT));
                     if (templateStatementNode.equals(selectedTemplateStatementNode))
                        pop.add(new SetSingleReference(name, templateParameter, selectedNode, event, editor));
                     return;
                  }


                  pop.add(new SetSingleReference(name, templateParameter, selectedNode, event, editor));
               }

               @Override
               protected void onListTemplateParameter(String name, Node templateParameter) {
                  pop.add(new AddListReference(name, templateParameter, selectedNodes.iterator().next().node, event, editor));
               }
            }.visitTemplateStatement(templateStatement);
         }

         @Override
         public void renderTo(NeoPNodeRenderPanel panel) {
            super.renderTo(panel);

            editor.doInTransaction(tx -> {
               panel.txtEditor.setText(TemplateDomainImpl.render(node));
               panel.txtEditor.setCaretPosition(0);
            });
         }

         class SetSingleValue extends NeoEditor.TransactionAction {
            private final PInputEvent event;
            private final Node templateParameter;

            SetSingleValue(String name, PInputEvent event, Node templateParameter, NeoEditor editor) {
               super("Set " + name, editor);
               this.event = event;
               this.templateParameter = templateParameter;
            }

            @Override
            public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

               final String newValue = SwingUtil.showInputDialog("Value", editor.canvas);
               if (newValue == null) return;

               final Node newSingleValue = TemplateDomainImpl.newSingleValue(editor.getGraph(), newValue);
               TemplateDomainImpl.setSingleReference(newSingleValue, node, RelationshipType.withName(get(templateParameter, TemplateDomainImpl.Properties.name.name())), editor);
               // no need for editor.addRelation, as show-method will ensure its visible
               editor.
                     show(uuidOf(newSingleValue), SingleValue.name()).
                     setOffset(event);
            }
         }

         class AddListValues extends NeoEditor.TransactionAction {
            private final Node templateParameter;

            AddListValues(String name, Node templateParameter, NeoEditor editor) {
               super(name, editor);
               this.templateParameter = templateParameter;
            }

            @Override
            public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

               final String newValues = SwingUtil.showInputDialog("Value (for multiple values, separate by space)", editor.canvas);
               if (newValues == null) return;

               final Map<UUID, org.neo4j.graphdb.Label> pNodes = new LinkedHashMap<>();
               for (String newValue : newValues.split(" ")) {

                  final Node newListValue = TemplateDomainImpl.newSingleValue(editor.getGraph(), newValue);
                  TemplateDomainImpl.addNodeReference(newListValue, node, RelationshipType.withName(get(templateParameter, TemplateDomainImpl.Properties.name.name())));
                  // no need for editor.addRelation, as show-method will ensure its visible
                  pNodes.put(uuidOf(newListValue), SingleValue);
               }

               editor.showAndLayout(pNodes, pNode);
            }
         }

         class DetachReferenceAction extends NeoEditor.TransactionAction {

            private final Node referencedNode;
            private final TemplateDomain domain;

            DetachReferenceAction(String name, Node referencedNode, TemplateDomainImpl.Entities nodeType, NeoEditor editor, TemplateDomain domain) {
               super("Remove " + name + " : " + TemplateDomainImpl.renderReferenceNode(referencedNode, nodeType), editor);
               this.referencedNode = referencedNode;
               this.domain = domain;
            }

            @Override
            public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

               final AtomicBoolean nodeDetached = new AtomicBoolean(false);
               node.getRelationships(Direction.OUTGOING).forEach(relationship -> {
                  if (other(node, relationship).equals(referencedNode)) {
                     relationship.delete();
                     nodeDetached.set(true);
                  }
               });

               if (nodeDetached.get()) {
                  try {
                     domain.deleteNode(referencedNode);
                  } catch (NeoEditor.ReferenceException e1) {
                     System.out.println("detached node " + uuidOf(referencedNode) + " is constrained. Not deleted.");
                  }
               }
            }
         }

         class AddKeyValueSets extends NeoEditor.TransactionAction {
            private final PInputEvent event;
            private final Node templateParameter;

            AddKeyValueSets(String name, PInputEvent event, Node templateParameter, NeoEditor editor) {
               super(name, editor);
               this.event = event;
               this.templateParameter = templateParameter;
            }

            @Override
            public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

               final String[] keys = getString(templateParameter, TemplateDomainImpl.Properties.keys.name()).split(" ");
               final java.util.List<Map<String, String>> valueMap = new ArrayList<>(8);
               for (int i = 0; i < 8; i++) valueMap.add(new LinkedHashMap<>());

               final JTable tblValues = new JTable(new AbstractTableModel() {
                  @Override
                  public int getRowCount() {
                     return valueMap.size();
                  }

                  @Override
                  public int getColumnCount() {
                     return keys.length;
                  }

                  @Override
                  public Object getValueAt(int rowIndex, int columnIndex) {
                     return valueMap.get(rowIndex).get(keys[columnIndex]);
                  }

                  @Override
                  public String getColumnName(int column) {
                     return keys[column];
                  }

                  @Override
                  public boolean isCellEditable(int rowIndex, int columnIndex) {
                     return true;
                  }

                  @Override
                  public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
                     valueMap.get(rowIndex).put(keys[columnIndex], aValue == null ? null : aValue.toString().trim());
                     fireTableCellUpdated(rowIndex, columnIndex);
                  }

                  @Override
                  public Class<?> getColumnClass(int columnIndex) {
                     return String.class;
                  }
               });

               final JPanel contentPanel = new JPanel(new BorderLayout());
               contentPanel.add(new JLabel("Add " + getString(templateParameter, TemplateDomainImpl.Properties.name.name())));
               contentPanel.add(new JScrollPane(tblValues), BorderLayout.CENTER);
               contentPanel.setPreferredSize(new Dimension(640, 320));
               SwingUtil.showDialog(contentPanel, editor.canvas, "", () -> editor.doInTransaction(tx1 -> {

                  final Set<UUID> newKeyValueSets = new LinkedHashSet<>();
                  for (Map<String, String> map : valueMap) {

                     final Map<String, String> validMap = new LinkedHashMap<>();
                     for (String key : keys) {
                        final String value = map.get(key);
                        if (value == null || value.trim().length() == 0) continue;
                        validMap.put(key, value.trim());
                     }
                     if (validMap.isEmpty()) continue;

                     final Node newKeyValueSet = TemplateDomainImpl.newKeyValueSet(editor.getGraph(), node, templateParameter);
                     for (Map.Entry<String, String> entry : validMap.entrySet())
                        TemplateDomainImpl.setSingleReference(TemplateDomainImpl.newSingleValue(editor.getGraph(), entry.getValue()), newKeyValueSet, RelationshipType.withName(entry.getKey()), editor);
                     newKeyValueSets.add(uuidOf(newKeyValueSet));
                  }

                  for (UUID newKeyValueSet : newKeyValueSets) {
                     editor.
                           show(newKeyValueSet, KeyValueSet.name()).
                           setOffset(event);
                  }

                  updateView();
               }));
            }
         }

         class Edit extends NeoEditor.TransactionAction {

            private final PInputEvent event;

            public Edit(PInputEvent event, NeoEditor editor) {
               super("Edit", editor);
               this.event = event;
            }

            @Override
            public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

               final Node templateStatement = other(node, singleOutgoing(node, TEMPLATE_STATEMENT));

               final Map<String, JTextField> singleValues = new LinkedHashMap<>();
               final Map<String, String> existingValues = new LinkedHashMap<>();
               final Map<String, Node> templateParameters = new LinkedHashMap<>();
               final StringBuilder rows = new StringBuilder();
               final AtomicInteger i = new AtomicInteger(0);
               new TemplateGroupVisitor() {
                  @Override
                  protected void onSingleTemplateParameter(String name, Node templateParameter) {
                     if (TemplateDomainImpl.isStatementParameter(templateParameter)) return;
                     if (i.get() >= 1) rows.append(", 4dlu, ");
                     rows.append("pref");
                     singleValues.put(name, new JTextField());
                     existingValues.put(name, "");
                     templateParameters.put(name, templateParameter);
                     i.incrementAndGet();
                  }
               }.visitTemplateStatement(templateStatement);

               final SwingUtil.FormPanel form = new SwingUtil.FormPanel("50dlu, 4dlu, 150dlu:grow", rows.toString().trim());
               form.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
               new StatementVisitor() {
                  @Override
                  protected void onSingleValue(String name, Node referenceNode, TemplateDomainImpl.Entities referenceNodeType) {
                     // do not render statements (not editable through editor)
                     if (TemplateDomainImpl.Entities.Statement.equals(referenceNodeType)) return;
                     final String value = TemplateDomainImpl.renderReferenceNode(referenceNode, referenceNodeType);
                     singleValues.get(name).setText(value);
                     existingValues.put(name, value);
                  }
               }.visitStatement(node);

               int row = 1;
               for (String key : singleValues.keySet()) {
                  form.addLabel(key, 1, row);
                  form.add(singleValues.get(key), 3, row);
                  row += 2;
               }

               SwingUtil.showDialogNoDefaultButton(form, editor.canvas, "Statement", () -> editor.doInTransaction(tx1 -> {
                  for (String singleValueName : singleValues.keySet()) {
                     final String newValue = singleValues.get(singleValueName).getText();
                     if (!newValue.equals(existingValues.get(singleValueName))) {

                        final Node newSingleValue = TemplateDomainImpl.newSingleValue(editor.getGraph(), newValue);
                        TemplateDomainImpl.setSingleReference(newSingleValue, node, RelationshipType.withName(get(templateParameters.get(singleValueName), TemplateDomainImpl.Properties.name.name())), editor);
                        // no need for editor.addRelation, as show-method will ensure its visible
                        editor.
                              show(uuidOf(newSingleValue), SingleValue.name()).
                              setOffset(event);
                     }
                  }
               }));
            }
         }

         class ShowTemplate extends NeoEditor.TransactionAction {
            private final PInputEvent event;

            ShowTemplate(PInputEvent event, NeoEditor editor) {
               super("Show Template", editor);
               this.event = event;
            }

            @Override
            public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
               final Relationship relationship = singleOutgoing(node, TEMPLATE_STATEMENT);
               editor.
                     show(uuidOf(other(node, relationship)), TemplateStatement.name()).
                     setOffset(event);
            }
         }

         class RenderToClipboard extends NeoEditor.TransactionAction {

            RenderToClipboard(NeoEditor editor) {
               super("Copy to clipboard", editor);
            }

            @Override
            public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
               SwingUtil.toClipboard(TemplateDomainImpl.render(node));
            }
         }

         class SetSingleReference extends NeoEditor.TransactionAction {

            private final PInputEvent event;
            private final Node templateParameter;
            private final Node selectedNode;

            SetSingleReference(String name, Node templateParameter, Node selectedNode, PInputEvent event, NeoEditor editor) {
               super("Set " + name, editor);
               this.event = event;
               this.templateParameter = templateParameter;
               this.selectedNode = selectedNode;
            }

            @Override
            public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

               if (selectedNode.hasLabel(Statement) || selectedNode.hasLabel(SingleValue)) {
                  editor.addRelation(TemplateDomainImpl.setSingleReference(selectedNode, node, RelationshipType.withName(get(templateParameter, TemplateDomainImpl.Properties.name.name())), editor));

               } else {
                  final String property = SwingUtil.showSelectDialog(editor.getCanvas(), "Property to use", "Select Property from node", selectedNode.getPropertyKeys());
                  if (property == null) return;

                  final Node referenceNode = editor.getGraph().newNode(Reference);
                  referenceNode.setProperty(Properties.reference.name(), property);
                  referenceNode.createRelationshipTo(selectedNode, Relations.REFERENCE);
                  editor.show(uuidOf(referenceNode), Reference.name()).setOffset(event);

                  editor.addRelation(TemplateDomainImpl.setSingleReference(referenceNode, node, RelationshipType.withName(get(templateParameter, TemplateDomainImpl.Properties.name.name())), editor));
               }

               updateView();
            }
         }

         class AddListReference extends NeoEditor.TransactionAction {

            private final PInputEvent event;
            private final Node templateParameter;
            private final Node selectedNode;

            AddListReference(String name, Node templateParameter, Node selectedNode, PInputEvent event, NeoEditor editor) {
               super("Add " + name, editor);
               this.event = event;
               this.templateParameter = templateParameter;
               this.selectedNode = selectedNode;
            }

            @Override
            public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

               if (selectedNode.hasLabel(Statement) || selectedNode.hasLabel(SingleValue)) {
                  editor.addRelation(TemplateDomainImpl.addNodeReference(selectedNode, node, RelationshipType.withName(get(templateParameter, TemplateDomainImpl.Properties.name.name()))));

               } else {

                  final String property = SwingUtil.showSelectDialog(editor.getCanvas(), selectedNode.getPropertyKeys());
                  if (property == null) return;

                  final Node referenceNode = editor.getGraph().newNode(Reference);
                  referenceNode.setProperty(Properties.reference.name(), property);
                  referenceNode.createRelationshipTo(selectedNode, Relations.REFERENCE);
                  editor.show(uuidOf(referenceNode), Reference.name()).setOffset(event);

                  editor.addRelation(TemplateDomainImpl.addNodeReference(referenceNode, node, RelationshipType.withName(get(templateParameter, TemplateDomainImpl.Properties.name.name()))));
               }

               editor.clearMousePosition();
            }
         }
      };
   }

//   class StatementPNode extends TemplateDomainPNode {

//      StatementPNode(Node node, Node templateStatement, NeoEditor editor) {
//         super(node, Statement, "name", "0, 109, 44".split(", "), editor);
//         pNode.setFont(new Font("Hack", Font.PLAIN, 11));
//         this.templateStatement = templateStatement;
//         updateView();
//      }
//
//      @Override
//      public void updateView() {
//         pNode.setText(getNodeLabel(templateStatement, Properties.name.name()));
//      }
//
//      @Override
//      public String getNodeType() {
//         return Statement.name();
//      }

//      @Override
//      public void expand() {
//
//         final Map<UUID, org.neo4j.graphdb.Label> pNodes = new LinkedHashMap<>();
//
//         new StatementVisitor() {
//
//            @Override
//            protected void onSingleValue(String name, Node referenceNode, TemplateDomainImpl.Entities referenceNodeType) {
//               pNodes.put(uuidOf(referenceNode), referenceNodeType);
//            }
//
//            @Override
//            protected void onListValue(String name, Node referenceNode, TemplateDomainImpl.Entities referenceNodeType) {
//               pNodes.put(uuidOf(referenceNode), referenceNodeType);
//            }
//
//            @Override
//            protected void onStartKeyValueSet(String name, Node keyValueNode) {
//               pNodes.put(uuidOf(keyValueNode), KeyValueSet);
//            }
//         }.visitStatement(node);
//
//         editor.showAndLayout(pNodes, pNode);
//      }

//      @Override
//      public void showDependents() {
//
//         final Map<UUID, org.neo4j.graphdb.Label> pNodes = new LinkedHashMap<>();
//
//         for (Relationship relationship : node.getRelationships(INCOMING)) {
//            if (NeoEditor.isAppRelated(relationship)) continue;
//            final Node other = other(node, relationship);
//            if (hasLabel(other, Entities.Directory.name()))
//               pNodes.put(uuidOf(other(node, relationship)), Entities.Directory);
//            else
//               System.out.println(other.getLabels().iterator().next());
//         }
//
//         // also show TemplateStatement (makes logic sense)
//         final Relationship relationship = singleOutgoing(node, TEMPLATE_STATEMENT);
//         pNodes.put(uuidOf(other(node, relationship)), TemplateDomainImpl.Entities.TemplateStatement);
//
//         editor.showAndLayout(pNodes, pNode);
//      }
//
//      @Override
//      public void showNodeActions(JPopupMenu pop, PInputEvent event) {
//
//         final JMenu setMenu = new JMenu("Set");
//         final JMenu addMenu = new JMenu("Add");
//         final AtomicBoolean hasEditableParameters = new AtomicBoolean(false);
//         new TemplateGroupVisitor() {
//            @Override
//            protected void onSingleTemplateParameter(String name, Node templateParameter) {
//
//               // check if templateParameter has parameterNode.createRelationshipTo(templateStatement, TemplateDomain.Relations.STATEMENT_PARAMETER)
//               final Relationship statementParameterRelation = BaseDomainVisitor.singleOutgoing(templateParameter, STATEMENT_PARAMETER);
//               if (statementParameterRelation != null)
//                  return;
//
//               setMenu.add(new SetSingleValue(name, event, templateParameter, editor));
//               hasEditableParameters.set(true);
//            }
//
//            @Override
//            protected void onListTemplateParameter(String name, Node templateParameter) {
//               addMenu.add(new AddListValues(name, templateParameter, editor));
//            }
//
//            @Override
//            protected void onKeyValueTemplateParameter(String name, String keys, Node templateParameter) {
//               addMenu.add(new AddKeyValueSets(name, event, templateParameter, editor));
//            }
//         }.visitTemplateStatement(templateStatement);
//
//         final JMenu removeMenu = new JMenu("Remove");
//         new StatementVisitor() {
//
//            @Override
//            protected void onSingleValue(String name, Node referenceNode, TemplateDomainImpl.Entities referenceNodeType) {
//               removeMenu.add(new DetachReferenceAction(name, referenceNode, referenceNodeType, editor, TemplateDomainImpl.this));
//            }
//
//            @Override
//            protected void onListValue(String name, Node referenceNode, TemplateDomainImpl.Entities referenceNodeType) {
//               removeMenu.add(new DetachReferenceAction(name, referenceNode, referenceNodeType, editor, TemplateDomainImpl.this));
//            }
//         }.visitStatement(node);
//
//         if (addMenu.getMenuComponentCount() > 0) pop.add(addMenu);
//         if (setMenu.getMenuComponentCount() > 0) pop.add(setMenu);
//         if (removeMenu.getMenuComponentCount() > 0) pop.add(removeMenu);
//
//         if (hasEditableParameters.get())
//            pop.add(new Edit(event, editor));
//
//         pop.add(new RenderToClipboard(editor));
//         pop.add(new ShowTemplate(event, editor));
//
//         super.showNodeActions(pop, event);
//      }
//
//      @Override
//      public void showTargetActions(JPopupMenu pop, PInputEvent event) {
//
//         final Collection<NeoPNode> selectedNodes = editor.getSelectedNodes();
//
//         if (selectedNodes.size() != 1) return;
//
//         new TemplateGroupVisitor() {
//            @Override
//            protected void onSingleTemplateParameter(final String name, Node templateParameter) {
//               final Node selectedNode = selectedNodes.iterator().next().node;
//
//               // check if templateParameter has parameterNode.createRelationshipTo(templateStatement, TemplateDomain.Relations.STATEMENT_PARAMETER)
//               final Relationship statementParameterRelation = BaseDomainVisitor.singleOutgoing(templateParameter, STATEMENT_PARAMETER);
//               if (statementParameterRelation != null) {
//                  if (!selectedNode.hasLabel(Statement)) {
//                     return;  // if not a statement, disallow selected node for this parameter
//                  }
//
//                  final Node templateStatementNode = other(templateParameter, statementParameterRelation);
//                  final Node selectedTemplateStatementNode = other(selectedNode, BaseDomainVisitor.singleOutgoing(selectedNode, TEMPLATE_STATEMENT));
//                  if (templateStatementNode.equals(selectedTemplateStatementNode))
//                     pop.add(new SetSingleReference(name, templateParameter, selectedNode, event, editor));
//                  return;
//               }
//
//
//               pop.add(new SetSingleReference(name, templateParameter, selectedNode, event, editor));
//            }
//
//            @Override
//            protected void onListTemplateParameter(String name, Node templateParameter) {
//               pop.add(new AddListReference(name, templateParameter, selectedNodes.iterator().next().node, event, editor));
//            }
//         }.visitTemplateStatement(templateStatement);
//      }
//
//      @Override
//      public void renderTo(JTextComponent textArea) {
//         editor.doInTransaction(tx -> {
//            textArea.setText(TemplateDomainImpl.render(node));
//            textArea.setCaretPosition(0);
//         });
//      }
//
//      private class SetSingleValue extends NeoEditor.TransactionAction {
//         private final PInputEvent event;
//         private final Node templateParameter;
//
//         SetSingleValue(String name, PInputEvent event, Node templateParameter, NeoEditor editor) {
//            super("Set " + name, editor);
//            this.event = event;
//            this.templateParameter = templateParameter;
//         }
//
//         @Override
//         public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
//
//            final String newValue = SwingUtil.showInputDialog("Value", editor.canvas);
//            if (newValue == null) return;
//
//            final Node newSingleValue = TemplateDomainImpl.newSingleValue(editor.getGraph(), newValue);
//            TemplateDomainImpl.setSingleReference(newSingleValue, node, RelationshipType.withName(get(templateParameter, TemplateDomainImpl.Properties.name.name())), editor);
//            // no need for editor.addRelation, as show-method will ensure its visible
//            editor.
//                  show(uuidOf(newSingleValue), SingleValue.name()).
//                  setOffset(event);
//         }
//      }
//
//      private class AddListValues extends NeoEditor.TransactionAction {
//         private final Node templateParameter;
//
//         AddListValues(String name, Node templateParameter, NeoEditor editor) {
//            super(name, editor);
//            this.templateParameter = templateParameter;
//         }
//
//         @Override
//         public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
//
//            final String newValues = SwingUtil.showInputDialog("Value (for multiple values, separate by space)", editor.canvas);
//            if (newValues == null) return;
//
//            final Map<UUID, org.neo4j.graphdb.Label> pNodes = new LinkedHashMap<>();
//            for (String newValue : newValues.split(" ")) {
//
//               final Node newListValue = TemplateDomainImpl.newSingleValue(editor.getGraph(), newValue);
//               TemplateDomainImpl.addNodeReference(newListValue, node, RelationshipType.withName(get(templateParameter, TemplateDomainImpl.Properties.name.name())));
//               // no need for editor.addRelation, as show-method will ensure its visible
//               pNodes.put(uuidOf(newListValue), SingleValue);
//            }
//
//            editor.showAndLayout(pNodes, pNode);
//         }
//      }
//
//      private class DetachReferenceAction extends NeoEditor.TransactionAction {
//
//         private final Node referencedNode;
//         private final TemplateDomain domain;
//
//         DetachReferenceAction(String name, Node referencedNode, TemplateDomainImpl.Entities nodeType, NeoEditor editor, TemplateDomain domain) {
//            super("Remove " + name + " : " + TemplateDomainImpl.renderReferenceNode(referencedNode, nodeType), editor);
//            this.referencedNode = referencedNode;
//            this.domain = domain;
//         }
//
//         @Override
//         public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
//
//            final AtomicBoolean nodeDetached = new AtomicBoolean(false);
//            node.getRelationships(Direction.OUTGOING).forEach(relationship -> {
//               if (other(node, relationship).equals(referencedNode)) {
//                  relationship.delete();
//                  nodeDetached.set(true);
//               }
//            });
//
//            if (nodeDetached.get()) {
//               try {
//                  domain.deleteNode(referencedNode);
//               } catch (NeoEditor.ReferenceException e1) {
//                  System.out.println("detached node " + uuidOf(referencedNode) + " is constrained. Not deleted.");
//               }
//            }
//         }
//      }
//
//      private class AddKeyValueSets extends NeoEditor.TransactionAction {
//         private final PInputEvent event;
//         private final Node templateParameter;
//
//         AddKeyValueSets(String name, PInputEvent event, Node templateParameter, NeoEditor editor) {
//            super(name, editor);
//            this.event = event;
//            this.templateParameter = templateParameter;
//         }
//
//         @Override
//         public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
//
//            final String[] keys = getString(templateParameter, TemplateDomainImpl.Properties.keys.name()).split(" ");
//            final java.util.List<Map<String, String>> valueMap = new ArrayList<>(8);
//            for (int i = 0; i < 8; i++) valueMap.add(new LinkedHashMap<>());
//
//            final JTable tblValues = new JTable(new AbstractTableModel() {
//               @Override
//               public int getRowCount() {
//                  return valueMap.size();
//               }
//
//               @Override
//               public int getColumnCount() {
//                  return keys.length;
//               }
//
//               @Override
//               public Object getValueAt(int rowIndex, int columnIndex) {
//                  return valueMap.get(rowIndex).get(keys[columnIndex]);
//               }
//
//               @Override
//               public String getColumnName(int column) {
//                  return keys[column];
//               }
//
//               @Override
//               public boolean isCellEditable(int rowIndex, int columnIndex) {
//                  return true;
//               }
//
//               @Override
//               public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
//                  valueMap.get(rowIndex).put(keys[columnIndex], aValue == null ? null : aValue.toString().trim());
//                  fireTableCellUpdated(rowIndex, columnIndex);
//               }
//
//               @Override
//               public Class<?> getColumnClass(int columnIndex) {
//                  return String.class;
//               }
//            });
//
//            final JPanel contentPanel = new JPanel(new BorderLayout());
//            contentPanel.add(new JLabel("Add " + getString(templateParameter, TemplateDomainImpl.Properties.name.name())));
//            contentPanel.add(new JScrollPane(tblValues), BorderLayout.CENTER);
//            contentPanel.setPreferredSize(new Dimension(640, 320));
//            SwingUtil.showDialog(contentPanel, editor.canvas, "", () -> editor.doInTransaction(tx1 -> {
//
//               final Set<UUID> newKeyValueSets = new LinkedHashSet<>();
//               for (Map<String, String> map : valueMap) {
//
//                  final Map<String, String> validMap = new LinkedHashMap<>();
//                  for (String key : keys) {
//                     final String value = map.get(key);
//                     if (value == null || value.trim().length() == 0) continue;
//                     validMap.put(key, value.trim());
//                  }
//                  if (validMap.isEmpty()) continue;
//
//                  final Node newKeyValueSet = TemplateDomainImpl.newKeyValueSet(editor.getGraph(), node, templateParameter);
//                  for (Map.Entry<String, String> entry : validMap.entrySet())
//                     TemplateDomainImpl.setSingleReference(TemplateDomainImpl.newSingleValue(editor.getGraph(), entry.getValue()), newKeyValueSet, RelationshipType.withName(entry.getKey()), editor);
//                  newKeyValueSets.add(uuidOf(newKeyValueSet));
//               }
//
//               for (UUID newKeyValueSet : newKeyValueSets) {
//                  editor.
//                        show(newKeyValueSet, KeyValueSet.name()).
//                        setOffset(event);
//               }
//
//               updateView();
//            }));
//         }
//      }
//
//      private class Edit extends NeoEditor.TransactionAction {
//
//         private final PInputEvent event;
//
//         public Edit(PInputEvent event, NeoEditor editor) {
//            super("Edit", editor);
//            this.event = event;
//         }
//
//         @Override
//         public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
//
//            final Node templateStatement = other(node, singleOutgoing(node, TEMPLATE_STATEMENT));
//
//            final Map<String, JTextField> singleValues = new LinkedHashMap<>();
//            final Map<String, String> existingValues = new LinkedHashMap<>();
//            final Map<String, Node> templateParameters = new LinkedHashMap<>();
//            final StringBuilder rows = new StringBuilder();
//            final AtomicInteger i = new AtomicInteger(0);
//            new TemplateGroupVisitor() {
//               @Override
//               protected void onSingleTemplateParameter(String name, Node templateParameter) {
//                  if (TemplateDomainImpl.isStatementParameter(templateParameter)) return;
//                  if (i.get() >= 1) rows.append(", 4dlu, ");
//                  rows.append("pref");
//                  singleValues.put(name, new JTextField());
//                  existingValues.put(name, "");
//                  templateParameters.put(name, templateParameter);
//                  i.incrementAndGet();
//               }
//            }.visitTemplateStatement(templateStatement);
//
//            final SwingUtil.FormPanel form = new SwingUtil.FormPanel("50dlu, 4dlu, 150dlu:grow", rows.toString().trim());
//            form.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
//            new StatementVisitor() {
//               @Override
//               protected void onSingleValue(String name, Node referenceNode, TemplateDomainImpl.Entities referenceNodeType) {
//                  // do not render statements (not editable through editor)
//                  if (TemplateDomainImpl.Entities.Statement.equals(referenceNodeType)) return;
//                  final String value = TemplateDomainImpl.renderReferenceNode(referenceNode, referenceNodeType);
//                  singleValues.get(name).setText(value);
//                  existingValues.put(name, value);
//               }
//            }.visitStatement(node);
//
//            int row = 1;
//            for (String key : singleValues.keySet()) {
//               form.addLabel(key, 1, row);
//               form.add(singleValues.get(key), 3, row);
//               row += 2;
//            }
//
//            SwingUtil.showDialogNoDefaultButton(form, editor.canvas, "Statement", () -> editor.doInTransaction(tx1 -> {
//               for (String singleValueName : singleValues.keySet()) {
//                  final String newValue = singleValues.get(singleValueName).getText();
//                  if (!newValue.equals(existingValues.get(singleValueName))) {
//
//                     final Node newSingleValue = TemplateDomainImpl.newSingleValue(editor.getGraph(), newValue);
//                     TemplateDomainImpl.setSingleReference(newSingleValue, node, RelationshipType.withName(get(templateParameters.get(singleValueName), TemplateDomainImpl.Properties.name.name())), editor);
//                     // no need for editor.addRelation, as show-method will ensure its visible
//                     editor.
//                           show(uuidOf(newSingleValue), SingleValue.name()).
//                           setOffset(event);
//                  }
//               }
//            }));
//         }
//      }
//
//      private class ShowTemplate extends NeoEditor.TransactionAction {
//         private final PInputEvent event;
//
//         ShowTemplate(PInputEvent event, NeoEditor editor) {
//            super("Show Template", editor);
//            this.event = event;
//         }
//
//         @Override
//         public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
//            final Relationship relationship = singleOutgoing(node, TEMPLATE_STATEMENT);
//            editor.
//                  show(uuidOf(other(node, relationship)), TemplateStatement.name()).
//                  setOffset(event);
//         }
//      }
//
//      private class RenderToClipboard extends NeoEditor.TransactionAction {
//
//         RenderToClipboard(NeoEditor editor) {
//            super("Copy to clipboard", editor);
//         }
//
//         @Override
//         public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
//            SwingUtil.toClipboard(TemplateDomainImpl.render(node));
//         }
//      }
//
//      private class SetSingleReference extends NeoEditor.TransactionAction {
//
//         private final PInputEvent event;
//         private final Node templateParameter;
//         private final Node selectedNode;
//
//         SetSingleReference(String name, Node templateParameter, Node selectedNode,  PInputEvent event, NeoEditor editor) {
//            super("Set " + name, editor);
//            this.event = event;
//            this.templateParameter = templateParameter;
//            this.selectedNode = selectedNode;
//         }
//
//         @Override
//         public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
//
//            if (selectedNode.hasLabel(Statement) || selectedNode.hasLabel(SingleValue)) {
//               editor.addRelation(TemplateDomainImpl.setSingleReference(selectedNode, node, RelationshipType.withName(get(templateParameter, TemplateDomainImpl.Properties.name.name())), editor));
//
//            } else {
//               final String property = SwingUtil.showSelectDialog(editor.getCanvas(), "Property to use", "Select Property from node", selectedNode.getPropertyKeys());
//               if (property == null) return;
//
//               final Node referenceNode = editor.getGraph().newNode(Reference);
//               referenceNode.setProperty(Properties.reference.name(), property);
//               referenceNode.createRelationshipTo(selectedNode, Relations.REFERENCE);
//               editor.show(uuidOf(referenceNode), Reference.name()).setOffset(event);
//
//               editor.addRelation(TemplateDomainImpl.setSingleReference(referenceNode, node, RelationshipType.withName(get(templateParameter, TemplateDomainImpl.Properties.name.name())), editor));
//            }
//
//            updateView();
//         }
//      }
//
//      private class AddListReference extends NeoEditor.TransactionAction {
//
//         private final PInputEvent event;
//         private final Node templateParameter;
//         private final Node selectedNode;
//
//         AddListReference(String name, Node templateParameter, Node selectedNode, PInputEvent event, NeoEditor editor) {
//            super("Add " + name, editor);
//            this.event = event;
//            this.templateParameter = templateParameter;
//            this.selectedNode = selectedNode;
//         }
//
//         @Override
//         public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
//
//            if (selectedNode.hasLabel(Statement) || selectedNode.hasLabel(SingleValue)) {
//               editor.addRelation(TemplateDomainImpl.addNodeReference(selectedNode, node, RelationshipType.withName(get(templateParameter, TemplateDomainImpl.Properties.name.name()))));
//
//            } else {
//
//               final String property = SwingUtil.showSelectDialog(editor.getCanvas(), selectedNode.getPropertyKeys());
//               if (property == null) return;
//
//               final Node referenceNode = editor.getGraph().newNode(Reference);
//               referenceNode.setProperty(Properties.reference.name(), property);
//               referenceNode.createRelationshipTo(selectedNode, Relations.REFERENCE);
//               editor.show(uuidOf(referenceNode), Reference.name()).setOffset(event);
//
//               editor.addRelation(TemplateDomainImpl.addNodeReference(referenceNode, node, RelationshipType.withName(get(templateParameter, TemplateDomainImpl.Properties.name.name()))));
//            }
//
//            editor.clearMousePosition();
//         }
//      }
//   }

   static public class StatementVisitor {

      public final void visitStatement(Node statement) {

         if (!hasLabel(statement, Statement.name()))
            throw new IllegalArgumentException(NeoModel.getNameOrLabelFrom(statement) + " is not a " + Statement.name());

         final Node statementTemplate = other(statement, singleOutgoing(statement, TEMPLATE_STATEMENT));
         final Node templateGroup = other(statementTemplate, singleOutgoing(statementTemplate, TEMPLATE_GROUP));

         if (statementTemplate == null || templateGroup == null) return;

         onStatementStart(statementTemplate, templateGroup);

         for (Relationship templateParameterRelation : incoming(statementTemplate, TEMPLATE_PARAMETER)) {
            final Node templateParameter = other(statementTemplate, templateParameterRelation);

            final RelationshipType parameterName = RelationshipType.withName(get(templateParameter, TemplateDomainImpl.Properties.name.name()));

            switch (TemplateDomainImpl.Entities.valueOf(getString(templateParameterRelation, TemplateDomainImpl.Properties.relationType.name()))) {

               case SingleTemplateParameter: {

                  final Relationship relationship = singleOutgoing(statement, parameterName);
                  final Node value = other(statement, relationship);
                  if (value == null) continue;

                  onSingleValue(parameterName.name(), other(statement, relationship), TemplateDomainImpl.Entities.valueOf(getString(relationship, TemplateDomainImpl.Properties.relationType.name())));
                  break;
               }
               case ListTemplateParameter: {

                  for (Relationship relationship : outgoing(statement, parameterName))
                     onListValue(parameterName.name(), other(statement, relationship), TemplateDomainImpl.Entities.valueOf(getString(relationship, TemplateDomainImpl.Properties.relationType.name())));
                  break;
               }
               case KeyValueTemplateParameter: {

                  for (Relationship relationship : outgoing(statement, parameterName)) {
                     final Node kvSet = other(statement, relationship);

                     onStartKeyValueSet(parameterName.name(), kvSet);

                     for (String key : getString(templateParameter, TemplateDomainImpl.Properties.keys.name()).split(" ")) {
                        final Relationship kvRelation = singleOutgoing(kvSet, RelationshipType.withName(key));
                        if (kvRelation == null) continue;

                        final Node kvValue = other(kvSet, kvRelation);
                        onKeyValue(key, kvValue, TemplateDomainImpl.Entities.valueOf(getString(kvRelation, TemplateDomainImpl.Properties.relationType.name())));
                     }

                     onEndKeyValueSet(kvSet);
                  }
                  break;
               }
            }
         }

         onStatementEnd();
      }

      protected void onStatementStart(Node statementTemplate, Node templateGroup) {
      }

      protected void onSingleValue(String name, Node referenceNode, TemplateDomainImpl.Entities referenceNodeType) {
      }

      protected void onListValue(String name, Node referenceNode, TemplateDomainImpl.Entities referenceNodeType) {
      }

      protected void onStartKeyValueSet(String name, Node kvNode) {
      }

      protected void onKeyValue(String name, Node referenceNode, TemplateDomainImpl.Entities referenceNodeType) {
      }

      protected void onEndKeyValueSet(Node kvNode) {
      }

      protected void onStatementEnd() {
      }
   }

   @Override
   protected NeoPNode newTemplateGroupPNode(Node node, NeoEditor editor) {
      return new TemplateDomain.TemplateGroupPNode(node, editor) {


         @Override
         public void expand() {

            final Map<UUID, Label> pNodes = new LinkedHashMap<>();

            new TemplateGroupVisitor() {
               @Override
               protected void onTemplateStatementStart(String name, String text, Node templateStatement) {
                  pNodes.put(uuidOf(templateStatement), TemplateStatement);
               }
            }.visitTemplateGroup(node);

            editor.showAndLayout(pNodes, pNode);
         }

         @Override
         public void showNodeActions(JPopupMenu pop, PInputEvent event) {
            pop.add(new NewTemplateStatement(event, editor));
            pop.add(editor.newSetNodePropertyAction(Properties.root.name(), this));
            pop.add(editor.newSetNodePropertyAction(Properties.packageName.name(), this));
            pop.add(new GenerateGroupFile(this, editor));
//            pop.add(new ExpandTemplateGroup(editor));
            super.showNodeActions(pop, event);
         }

         @Override
         public void renderTo(JTextComponent textArea) {
            editor.doInTransaction(tx -> {
               textArea.setText(TemplateDomainImpl.asSTGString(node));
               textArea.setCaretPosition(0);
            });
         }

         class NewTemplateStatement extends NeoEditor.TransactionAction {

            private final PInputEvent event;

            NewTemplateStatement(PInputEvent event, NeoEditor editor) {
               super("New Templatestatement", editor);
               this.event = event;
            }

            @Override
            public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
               final String delimiter = get(node, TemplateDomainImpl.Properties.delimiter.name());
               final TemplateDomainImpl.TemplateEditor statementEditorPanel = new TemplateDomainImpl.TemplateEditor(delimiter, "", "", null);
               SwingUtil.showDialogNoDefaultButton(statementEditorPanel, editor.canvas, "Statement", () -> {

                  if (statementEditorPanel.txtStatementName.getText().trim().length() == 0)
                     throw new IllegalStateException("Statement must have a name");

                  final com.generator.generators.templates.domain.TemplateStatement templateStatement = statementEditorPanel.parseAndValidate(delimiter);
                  editor.doInTransaction(tx1 -> {
                     final Node importTemplateStatement = TemplateDomainImpl.importTemplateStatement(node, templateStatement, editor);
                     editor.show(uuidOf(importTemplateStatement), TemplateStatement.name()).
                           setOffset(event);
                  });
               });
            }
         }

      };
   }

   static public class TemplateGroupVisitor {

      final void visitTemplateGroup(Node templateGroup) {

         if (!hasLabel(templateGroup, TemplateGroup.name()))
            throw new IllegalArgumentException(NeoModel.getNameOrLabelFrom(templateGroup) + " is not a " + TemplateGroup.name());

         onTemplateGroupStart(get(templateGroup, TemplateDomainImpl.Properties.name.name()), get(templateGroup, TemplateDomainImpl.Properties.delimiter.name()), templateGroup);

         for (Relationship relationship : incoming(templateGroup, TEMPLATE_GROUP))
            visitTemplateStatement(other(templateGroup, relationship));

         onTemplateGroupEnd();
      }

      public final void visitTemplateStatement(Node templateStatement) {

         if (!hasLabel(templateStatement, TemplateStatement.name()))
            throw new IllegalArgumentException(NeoModel.getNameOrLabelFrom(templateStatement) + " is not a " + TemplateStatement.name());

         onTemplateStatementStart(get(templateStatement, TemplateDomainImpl.Properties.name.name()).toString(), get(templateStatement, TemplateDomainImpl.Properties.text.name()).toString(), templateStatement);

         for (Relationship parameterRelationship : incoming(templateStatement, TEMPLATE_PARAMETER)) {
            final Node templateParameter = other(templateStatement, parameterRelationship);
            onTemplateParameterStart(getString(templateParameter, TemplateDomainImpl.Properties.name.name()));
            switch (TemplateDomainImpl.Entities.valueOf(getString(parameterRelationship, TemplateDomainImpl.Properties.relationType.name()))) {

               case SingleTemplateParameter:
                  // use this to check if templateParameter is statement-parameter
                  //final Relationship statementParameterRelation = BaseDomainVisitor.singleOutgoing(templateParameter, STATEMENT_PARAMETER);
                  onSingleTemplateParameter(get(templateParameter, TemplateDomainImpl.Properties.name.name()), templateParameter);
                  break;

               case ListTemplateParameter:
                  onListTemplateParameter(get(templateParameter, TemplateDomainImpl.Properties.name.name()), templateParameter);
                  break;

               case KeyValueTemplateParameter:
                  onKeyValueTemplateParameter(get(templateParameter, TemplateDomainImpl.Properties.name.name()), get(templateParameter, TemplateDomainImpl.Properties.keys.name()), templateParameter);
                  break;
            }
            onTemplateParameterEnd(getString(templateParameter, TemplateDomainImpl.Properties.name.name()));
         }

         onTemplateStatementEnd(get(templateStatement, TemplateDomainImpl.Properties.name.name()).toString(), get(templateStatement, TemplateDomainImpl.Properties.text.name()), templateStatement);
      }

      protected void onTemplateGroupStart(String name, String delimiter, Node templateGroup) {
      }

      protected void onTemplateStatementStart(String name, String text, Node templateStatement) {
      }

      protected void onTemplateParameterStart(String name) {
      }

      protected void onTemplateParameterEnd(String name) {
      }

      protected void onSingleTemplateParameter(String name, Node parameterNode) {
      }

      protected void onListTemplateParameter(String name, Node parameterNode) {
      }

      protected void onKeyValueTemplateParameter(String name, String keys, Node parameterNode) {
      }

      protected void onTemplateStatementEnd(String name, String text, Node templateStatement) {
      }

      protected void onTemplateGroupEnd() {
      }
   }

   @Override
   protected NeoPNode newSingleTemplateParameterPNode(Node node, NeoEditor editor) {
      return new SingleTemplateParameterPNode(node, editor) {
         @Override
         public void showNodeActions(JPopupMenu pop, PInputEvent event) {
            // not allowed to delete node
            pop.add(hideNode());
         }

         @Override
         public void expand() {
            final Map<UUID, Label> pNodes = new LinkedHashMap<>();
            incoming(node, TEMPLATE_PARAMETER).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), TemplateDomainImpl.Entities.valueOf(getString(relationship, TemplateDomainImpl.Properties.relationType.name()))));
            editor.showAndLayout(pNodes, pNode);
         }
      };
   }

   @Override
   protected NeoPNode newListTemplateParameterPNode(Node node, NeoEditor editor) {
      return new ListTemplateParameterPNode(node, editor) {
         @Override
         public void showNodeActions(JPopupMenu pop, PInputEvent event) {
            // not allowed to delete node
            pop.add(hideNode());
         }

         @Override
         public void expand() {
            final Map<UUID, Label> pNodes = new LinkedHashMap<>();
            incoming(node, TEMPLATE_PARAMETER).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), TemplateDomainImpl.Entities.valueOf(getString(relationship, TemplateDomainImpl.Properties.relationType.name()))));
            editor.showAndLayout(pNodes, pNode);
         }
      };
   }

   @Override
   protected NeoPNode newKeyValueTemplateParameterPNode(Node node, NeoEditor editor) {
      return new KeyValueTemplateParameterPNode(node, editor) {
         @Override
         public void showNodeActions(JPopupMenu pop, PInputEvent event) {
            // not allowed to delete node
            pop.add(hideNode());
         }

         @Override
         public void expand() {
            final Map<UUID, Label> pNodes = new LinkedHashMap<>();
            incoming(node, TEMPLATE_PARAMETER).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), TemplateDomainImpl.Entities.valueOf(getString(relationship, TemplateDomainImpl.Properties.relationType.name()))));
            editor.showAndLayout(pNodes, pNode);
         }
      };
   }

   @Override
   protected NeoPNode newTemplateStatementPNode(Node node, NeoEditor editor) {
      return new TemplateStatementPNode(node, editor) {
         @Override
         public void expand() {
            final Map<UUID, Label> pNodes = new LinkedHashMap<>();
            for (Relationship relationship : incoming(node, TEMPLATE_STATEMENT))
               pNodes.put(uuidOf(other(node, relationship)), Statement);
            editor.showAndLayout(pNodes, pNode);
         }

         @Override
         public void showDependents() {
            final Map<UUID, Label> pNodes = new LinkedHashMap<>();
            pNodes.put(uuidOf(other(node, singleOutgoing(node, TEMPLATE_GROUP))), TemplateGroup);
            editor.showAndLayout(pNodes, pNode);
         }

         @Override
         public void showNodeActions(JPopupMenu pop, PInputEvent event) {
            pop.add(new NewStatement(editor));
            pop.add(new EditTemplateStatment(editor));
            pop.add(new ShowStatements(editor));
            pop.add(new ShowTemplateGroup(editor));
            pop.add(new ShowTemplateParameters(editor));
            pop.add(new HideParameters(editor));
            super.showNodeActions(pop, event);
         }

         @Override
         public void showTargetActions(JPopupMenu pop, PInputEvent event) {

            //todo if selected node is a TemplateStatement, ask to assign its statements as values for a given single-template-parameter (also support key-value-values ?)
            final Collection<NeoPNode> selectedNodes = editor.getSelectedNodes();
            if (selectedNodes.size() != 1) return;

            final Node selectedNode = selectedNodes.iterator().next().node;
            if (!selectedNode.hasLabel(TemplateStatement)) return;

            // assumes selectedNode is a TemplateStatement:
            new TemplateGroupVisitor() {

               @Override
               protected void onSingleTemplateParameter(String name, Node templateParameter) {
                  pop.add(new SetTemplateStatementParameter(name, templateParameter, selectedNode, editor));
               }

               @Override
               protected void onListTemplateParameter(String name, Node templateParameter) {
                  pop.add(new SetTemplateStatementParameter(name, templateParameter, selectedNode, editor));
               }

               @Override
               protected void onKeyValueTemplateParameter(String name, String keys, Node parameterNode) {
                  // todo add support for key-value-values
                  System.out.println("add support for key-value values for statement as value");
               }

            }.visitTemplateStatement(node);
         }

         @Override
         public void renderTo(JTextComponent textArea) {
            editor.doInTransaction(tx -> {
               textArea.setText(get(node, TemplateDomainImpl.Properties.text.name()));
               textArea.setCaretPosition(0);
            });
         }

         class EditTemplateStatment extends NeoEditor.TransactionAction {

            EditTemplateStatment(NeoEditor editor) {
               super("Edit", editor);
            }

            @Override
            public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

               final Node templateGroup = other(node, singleOutgoing(node, TEMPLATE_GROUP));
               assert templateGroup != null;
               final String delimiter = get(templateGroup, TemplateDomainImpl.Properties.delimiter.name());
               final String name = getString(node, TemplateDomainImpl.Properties.name.name());
               final String text = getString(node, TemplateDomainImpl.Properties.text.name());
               final String statementLabel = getString(node, TemplateDomainImpl.Properties.statementLabel.name());

               final TemplateDomainImpl.TemplateEditor statementEditorPanel = new TemplateDomainImpl.TemplateEditor(delimiter, name, text, statementLabel);
               final JDialog dialog = new JDialog(SwingUtil.getFrame(editor.canvas), "Edit statement", true);
               dialog.add(statementEditorPanel, BorderLayout.CENTER);
               final JPanel commandPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
               commandPanel.add(new JButton(new AbstractAction("Save") {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                     editor.getGraph().doInTransaction(new NeoModel.Committer() {
                        @Override
                        public void doAction(Transaction tx) throws Throwable {

                           if (statementEditorPanel.txtStatementName.getText().trim().length() == 0)
                              throw new IllegalStateException("Statement must have a name");

                           final com.generator.generators.templates.domain.TemplateStatement editedStatement = statementEditorPanel.parseAndValidate(delimiter);

                           final java.util.List<TemplateParameter> parameters = editedStatement.getParameters();
                           final Set<Node> oldParametersToDelete = new LinkedHashSet<>();
                           final Set<TemplateParameter> newParameters = new LinkedHashSet<>();
                           final Map<Node, String> updatedKeySets = new LinkedHashMap<>();
                           final StringBuilder constraints = new StringBuilder();
                           new TemplateGroupVisitor() {

                              @Override
                              protected void onSingleTemplateParameter(String name, Node parameterNode) {

                                 // todo regarding StatementTemplateParameter, check if there is a need to do changes here:

                                 TemplateParameter found = null;
                                 for (TemplateParameter templateParameter : parameters) {
                                    if (!templateParameter.getPropertyName().equals(name)) continue;
                                    found = templateParameter;

                                    // same name: check if same type and no dependencies:
                                    switch (templateParameter.getDomainEntityType()) {
                                       case LISTPROPERTY:
                                       case KEYVALUELISTPROPERTY:
                                          // type changed: only allow if no dependencies:
                                          if (!hasDependents(parameterNode, constraints)) {
                                             oldParametersToDelete.add(parameterNode);
                                             newParameters.add(templateParameter);
                                          }
                                          break;
                                    }
                                 }

                                 if (found != null)
                                    parameters.remove(found);
                                 else if (!hasDependents(parameterNode, constraints))
                                    oldParametersToDelete.add(parameterNode);
                              }

                              @Override
                              protected void onListTemplateParameter(String name, Node parameterNode) {

                                 TemplateParameter found = null;
                                 for (TemplateParameter templateParameter : parameters) {
                                    if (!templateParameter.getPropertyName().equals(name)) continue;
                                    found = templateParameter;

                                    // same name: check if same type and no dependencies:
                                    switch (templateParameter.getDomainEntityType()) {
                                       case STRINGPROPERTY:
                                       case BOOLEANPROPERTY:
                                       case STATEMENTPROPERTY:
                                       case KEYVALUELISTPROPERTY:
                                          // type changed: only allow if no dependencies:
                                          if (!hasDependents(parameterNode, constraints)) {
                                             oldParametersToDelete.add(parameterNode);
                                             newParameters.add(templateParameter);
                                          }
                                          break;
                                    }
                                 }

                                 if (found != null)
                                    parameters.remove(found);
                                 else if (!hasDependents(parameterNode, constraints))
                                    oldParametersToDelete.add(parameterNode);
                              }

                              @Override
                              protected void onKeyValueTemplateParameter(String name, String keys, Node parameterNode) {

                                 TemplateParameter found = null;
                                 for (TemplateParameter templateParameter : parameters) {
                                    if (!templateParameter.getPropertyName().equals(name)) continue;
                                    found = templateParameter;

                                    // same name: check if same type and no dependencies:
                                    switch (templateParameter.getDomainEntityType()) {
                                       case STRINGPROPERTY:
                                       case BOOLEANPROPERTY:
                                       case STATEMENTPROPERTY:
                                       case LISTPROPERTY:
                                          // type changed: only allow if no dependencies:
                                          if (!hasDependents(parameterNode, constraints)) {
                                             oldParametersToDelete.add(parameterNode);
                                             newParameters.add(templateParameter);
                                          }
                                          break;

                                       case KEYVALUELISTPROPERTY:

                                          final Set<String> newKeySet = new LinkedHashSet<>();
                                          final Set<String> templateKeySet = new LinkedHashSet<>(templateParameter.getKvNames());
                                          boolean isValid = true;
                                          for (String oldKey : keys.split(" ")) {

                                             if (templateKeySet.contains(oldKey)) {
                                                newKeySet.add(oldKey);
                                                templateKeySet.remove(oldKey);
                                                continue;
                                             }

                                             // old key missing, only allow if no dependencies:
                                             if (hasDependents(parameterNode, constraints, oldKey)) {
                                                isValid = false;
                                             }
                                          }

                                          if (isValid) {
                                             newKeySet.addAll(templateKeySet);
                                             final StringBuilder serialized = new StringBuilder();
                                             for (String newKey : newKeySet)
                                                serialized.append(" ").append(newKey);
                                             updatedKeySets.put(parameterNode, serialized.toString().trim());
                                          }
                                          break;
                                    }
                                 }

                                 if (found != null)
                                    parameters.remove(found);
                                 else if (!hasDependents(parameterNode, constraints))
                                    oldParametersToDelete.add(parameterNode);
                              }
                           }.visitTemplateStatement(node);

                           if (constraints.length() > 0)
                              throw new IllegalArgumentException("cannot change template as it has parameters in use that is not compatible with new parameters: " + constraints);

                           // update new key-sets:
                           for (Map.Entry<Node, String> kvEntry : updatedKeySets.entrySet())
                              kvEntry.getKey().setProperty(TemplateDomainImpl.Properties.keys.name(), kvEntry.getValue());

                           newParameters.addAll(parameters.stream().collect(Collectors.toList()));

                           for (TemplateParameter templateParameter : newParameters) {
                              switch (templateParameter.getDomainEntityType()) {
                                 case STRINGPROPERTY:
                                 case BOOLEANPROPERTY:
                                 case STATEMENTPROPERTY:
                                    TemplateDomainImpl.newSingleTemplateParameter(editor.getGraph(), node, templateParameter.getPropertyName());
                                    break;

                                 case LISTPROPERTY:
                                    TemplateDomainImpl.newListTemplateParameter(editor.getGraph(), node, templateParameter.getPropertyName());
                                    break;

                                 case KEYVALUELISTPROPERTY:
                                    TemplateDomainImpl.newKeyValueListTemplateParameter(editor.getGraph(), node, templateParameter.getPropertyName(), templateParameter.getKvNames().toArray(new String[templateParameter.getKvNames().size()]));
                                    break;
                              }
                           }

                           // delete old parameters
                           for (Node oldParameter : oldParametersToDelete) {
                              singleOutgoing(oldParameter, TEMPLATE_PARAMETER).delete();
                              oldParameter.delete();
                           }

                           node.setProperty(TemplateDomainImpl.Properties.name.name(), editedStatement.getName());
                           node.setProperty(TemplateDomainImpl.Properties.text.name(), editedStatement.getText().trim());

                           boolean foundStatementLabelParameter = false;
                           for (TemplateParameter parameter : editedStatement.getParameters()) {
                              if (parameter.getPropertyName().equals(statementEditorPanel.getStatementLabel())) {
                                 foundStatementLabelParameter = true;
                                 node.setProperty(TemplateDomainImpl.Properties.statementLabel.name(), statementEditorPanel.getStatementLabel());
                                 break;
                              }
                           }
                           if (!foundStatementLabelParameter)
                              node.removeProperty(TemplateDomainImpl.Properties.statementLabel.name());

                           updateView();

                           // for each dependent statement of this template, re-render
                           //todo refactor this ? Its a convenience for when updating templates, to render to any dependent-statements
//                        incoming(node, TEMPLATE_STATEMENT).forEach(relationship -> {
//                           final Node statementNode = other(node, relationship);
//                           incoming(statementNode, DIRECTORY_MEMBER).forEach(projectRelationship -> renderProjectMember(other(statementNode, projectRelationship), editor.canvas));
//                        });

                           editor.getAllNodesByLabel(Statement.name()).forEach(neoPNode -> {
                              if (isRelated(neoPNode.node, node, TEMPLATE_STATEMENT))
                                 neoPNode.updateView();
                           });

                           SwingUtilities.invokeLater(dialog::dispose);
                        }

                        @Override
                        public void exception(Throwable throwable) {
                           SwingUtil.showExceptionNoStack(dialog, throwable);
                        }
                     });
                  }
               }));
               commandPanel.add(new JButton(new AbstractAction("Cancel") {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                     SwingUtilities.invokeLater(dialog::dispose);
                  }
               }));
               dialog.add(commandPanel, BorderLayout.SOUTH);

               SwingUtil.showDialog(dialog, editor.canvas);
            }

            //todo use Constraints-exception
            // todo turn into Set<Relationship> constraints like deleteNode pattern
            private boolean hasDependents(final Node parameterNode, StringBuilder constraints) {
               final String constraintsAtStart = constraints.toString();
               incoming(parameterNode, TEMPLATE_PARAMETER).forEach(relationship -> {
                  final Node dependentValue = other(parameterNode, relationship);
                  constraints.append("\n").append(NeoModel.getNameOrLabelFrom(parameterNode)).append(" (").append(uuidOf(parameterNode)).append(") is used by ").append(NeoModel.getNameOrLabelFrom(dependentValue)).append(" (").append(uuidOf(dependentValue)).append(")");
               });
               return !constraintsAtStart.equals(constraints.toString());
            }

            private boolean hasDependents(final Node parameterNode, StringBuilder constraints, String key) {
               final String constraintsAtStart = constraints.toString();
               incoming(parameterNode, TEMPLATE_PARAMETER).forEach(relationship -> {
                  final Node dependentValue = other(parameterNode, relationship);
                  if (dependentValue.hasProperty(key))
                     constraints.append("\n").append(NeoModel.getNameOrLabelFrom(parameterNode)).append(" (").append(uuidOf(parameterNode)).append(").").append(key).append(" is used by ").append(NeoModel.getNameOrLabelFrom(dependentValue)).append(" (").append(uuidOf(dependentValue)).append(")");
               });
               return !constraintsAtStart.equals(constraints.toString());
            }
         }

         class SetTemplateStatementParameter extends NeoEditor.TransactionAction {

            private final Node parameterNode;
            private final Node templateStatement;

            SetTemplateStatementParameter(String name, Node parameterNode, Node templateStatement, NeoEditor editor) {
               super("Set parameter " + name + " to statements of " + get(templateStatement, "name"), editor);
               this.parameterNode = parameterNode;
               this.templateStatement = templateStatement;
            }

            @Override
            public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

               if (isRelated(parameterNode, templateStatement, TemplateDomainImpl.Relations.STATEMENT_PARAMETER))
                  getRelationship(parameterNode, templateStatement, TemplateDomainImpl.Relations.STATEMENT_PARAMETER).delete();

               final Relationship statementParameterRelation = parameterNode.createRelationshipTo(templateStatement, TemplateDomainImpl.Relations.STATEMENT_PARAMETER);
               editor.addRelation(statementParameterRelation);
               updateView();
            }
         }

         class NewStatement extends NeoEditor.TransactionAction {

            NewStatement(NeoEditor editor) {
               super("New " + get(node, TemplateDomainImpl.Properties.name.name()), editor);
            }

            @Override
            public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
               editor.
                     show(uuidOf(TemplateDomainImpl.newStatement(editor.getGraph(), node)), TemplateDomainImpl.Entities.Statement.name()).
                     setOffset(getRandomPosition());
            }
         }

         class ShowTemplateGroup extends NeoEditor.TransactionAction {

            ShowTemplateGroup(NeoEditor editor) {
               super("Show TemplateGroup", editor);
            }

            @Override
            public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
               editor.
                     show(uuidOf(other(node, singleOutgoing(node, TEMPLATE_GROUP))), TemplateDomainImpl.Entities.TemplateGroup.name()).
                     setOffset(getRandomPosition());
            }
         }

         class ShowTemplateParameters extends NeoEditor.TransactionAction {

            ShowTemplateParameters(NeoEditor editor) {
               super("Show parameters", editor);
            }

            @Override
            public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

               final Map<UUID, Label> pNodes = new LinkedHashMap<>();

               // show parameters
               new TemplateGroupVisitor() {
                  @Override
                  protected void onSingleTemplateParameter(String name, Node parameterNode) {
                     pNodes.put(uuidOf(parameterNode), SingleTemplateParameter);
                  }

                  @Override
                  protected void onListTemplateParameter(String name, Node parameterNode) {
                     pNodes.put(uuidOf(parameterNode), ListTemplateParameter);
                  }

                  @Override
                  protected void onKeyValueTemplateParameter(String name, String keys, Node parameterNode) {
                     pNodes.put(uuidOf(parameterNode), KeyValueTemplateParameter);
                  }

               }.visitTemplateStatement(node);

               editor.showAndLayout(pNodes, pNode);
            }
         }

         class ShowStatements extends NeoEditor.TransactionAction {

            ShowStatements(NeoEditor editor) {
               super("Expand", editor);
            }

            @Override
            public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
               expand();
            }
         }

         class HideParameters extends NeoEditor.TransactionAction {

            HideParameters(NeoEditor editor) {
               super("Hide parameters", editor);
            }

            @Override
            public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

               new TemplateGroupVisitor() {
                  @Override
                  protected void onSingleTemplateParameter(String name, Node parameterNode) {
                     editor.removeNodeFromCanvas(uuidOf(parameterNode));
                  }

                  @Override
                  protected void onListTemplateParameter(String name, Node parameterNode) {
                     editor.removeNodeFromCanvas(uuidOf(parameterNode));
                  }

                  @Override
                  protected void onKeyValueTemplateParameter(String name, String keys, Node parameterNode) {
                     editor.removeNodeFromCanvas(uuidOf(parameterNode));
                  }

               }.visitTemplateStatement(node);
            }
         }
      };
   }

   class GenerateGroupFile extends NeoEditor.TransactionAction {

      private TemplateGroupPNode templateGroupPNode;

      GenerateGroupFile(TemplateGroupPNode templateGroupPNode, NeoEditor editor) {
         super("Generate group-file", editor);
         this.templateGroupPNode = templateGroupPNode;
      }

      @Override
      public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

         final String packageName = BaseDomainVisitor.getString(templateGroupPNode.node, Properties.packageName.name());
         final String groupName = StringUtil.capitalize(BaseDomainVisitor.getString(templateGroupPNode.node, Properties.name.name())) + "DomainGroup";
         final String root = BaseDomainVisitor.getString(templateGroupPNode.node, Properties.root.name());

         final TemplateGroupGroup group = new TemplateGroupGroup();

         new TemplateGroupVisitor() {

            private TemplateGroupGroup.GroupClassDeclarationST groupClassDeclaration;
            private TemplateGroupGroup.NewStatementDeclarationST declarationST;
            private String statementName;
            private Object setter;

            @Override
            protected void onTemplateGroupStart(String name, String delimiter, Node templateGroup) {
               groupClassDeclaration = group.newGroupClassDeclaration().
                     setName(groupName).
                     setDomain(name).
//                     setResourcePath(GeneratedFile.packageToPath(packageName)).
                     setPackageName(packageName);
            }

            @Override
            protected void onTemplateStatementStart(String name, String text, Node templateStatement) {
               declarationST = group.newNewStatementDeclaration().setGroupname(groupName);
               statementName = name;
            }

            @Override
            protected void onTemplateParameterStart(String name) {
               setter = null;
            }

            @Override
            protected void onSingleTemplateParameter(String name, Node parameterNode) {
               setter = group.newStatementStringPropertySetter().setPropertyName(name).setStatementName(statementName);
            }

            @Override
            protected void onListTemplateParameter(String name, Node parameterNode) {
               setter = group.newStatementListPropertySetter().setPropertyName(name).setStatementName(statementName);
            }

            @Override
            protected void onKeyValueTemplateParameter(String name, String keys, Node parameterNode) {
               final TemplateGroupGroup.StatementKeyValueListPropertySetterST kvSetter = group.newStatementKeyValueListPropertySetter().
                     setPropertyName(name).
                     setStatementName(statementName);
               for (String key : keys.split(" ")) kvSetter.addKvNamesValue(key);
               setter = kvSetter;
            }

            @Override
            protected void onTemplateParameterEnd(String name) {
               declarationST.addPropertiesValue(name, setter);
            }

            @Override
            protected void onTemplateStatementEnd(String name, String text, Node templateStatement) {
               groupClassDeclaration.addStatementsValue(declarationST.setName(statementName), group.newNewStatementInstance().setName(statementName));
            }

            @Override
            protected void onTemplateGroupEnd() {

               if (root != null && packageName != null) {
                  final GeneratedFile javaFile = GeneratedFile.newJavaFile(root, packageName, groupName);
                  final File groupFile = FileUtil.tryToCreateFileIfNotExists(new File(root, GeneratedFile.packageToPath(packageName, BaseDomainVisitor.getString(templateGroupPNode.node, Properties.name.name()) + ".stg")));

                  try {
                     javaFile.write(groupClassDeclaration.toString());
                     FileUtil.writeFile(TemplateDomainImpl.asSTGString(templateGroupPNode.node), groupFile);
                  } catch (IOException e1) {
                     SwingUtil.showException(editor.getCanvas(), e1);
                  }
               }

               SwingUtil.toClipboard(groupClassDeclaration.toString());
            }
         }.visitTemplateGroup(templateGroupPNode.node);
      }
   }
}