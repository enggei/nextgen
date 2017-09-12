package com.generator.generators.stringtemplate;

import com.generator.NeoModel;
import com.generator.app.App;
import com.generator.app.AppEvents;
import com.generator.app.AppMotif;
import com.generator.app.Workspace;
import com.generator.generators.domain.DomainPlugin;
import com.generator.generators.project.ProjectPlugin;
import com.generator.generators.stringtemplate.domain.*;
import com.generator.generators.stringtemplate.parser.TemplateFileParser;
import com.generator.util.StringUtil;
import com.generator.util.SwingUtil;
import org.antlr.runtime.Token;
import org.jetbrains.annotations.NotNull;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.*;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STErrorListener;
import org.stringtemplate.v4.STGroupString;
import org.stringtemplate.v4.misc.ErrorType;
import org.stringtemplate.v4.misc.STCompiletimeMessage;
import org.stringtemplate.v4.misc.STMessage;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.DefaultHighlighter;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

import static com.generator.BaseDomainVisitor.*;
import static com.generator.NeoModel.getNameAndLabelsFrom;
import static com.generator.generators.project.ProjectPlugin.getFile;

/**
 * Created 06.08.17.
 */
public class StringTemplatePlugin extends DomainPlugin {

   public StringTemplatePlugin(App app) {
      super(app, "StringTemplate");
      System.out.println("todo add domain-structure in StringTemplatePlugin. But not use ids.");
   }

   public enum Entities implements Label {
      STGroup, STTemplate, Single, List, KeyValue
   }

   public enum Properties {
      text, deprecated
   }

   @Override
   protected Label[] getLabels() {
      return Entities.values();
   }

   @Override
   protected void addActionsTo(JMenu menu) {

      final JMenu showMenu = new JMenu("STGroups");
      getGraph().findNodes(Entities.STGroup).forEachRemaining(node -> showMenu.add(new App.TransactionAction("Show " + getNameAndLabelsFrom(node), app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
            fireNodesLoaded(true, node);
         }
      }));
      menu.add(showMenu);

      menu.add(new AbstractAction("Parse STG file") {
         @Override
         public void actionPerformed(ActionEvent e) {

            final File file = SwingUtil.showOpenFile(app, System.getProperty("user.home"));
            if (file == null || !file.getName().toLowerCase().endsWith(".stg")) return;

            final StringBuilder errors = new StringBuilder("Errors");

            final TemplateFile templateFile = TemplateFileParser.parse(file, new STErrorListener() {
               @Override
               public void compileTimeError(STMessage stMessage) {
                  if (stMessage instanceof STCompiletimeMessage) {
                     final Token token = ((STCompiletimeMessage) stMessage).token;
                     errors.append("\nat ").append(token.getLine()).append(" position ").append(token.getCharPositionInLine()).append(token.getText());
                  }
               }

               @Override
               public void runTimeError(STMessage stMessage) {

               }

               @Override
               public void IOError(STMessage stMessage) {

               }

               @Override
               public void internalError(STMessage stMessage) {

               }
            });

            if (templateFile == null) {
               if (errors.toString().length() > 7) {
                  SwingUtil.showTextResult("Errors", errors.toString(), app);
               } else
                  SwingUtil.showMessage("Could not parse " + file.getAbsolutePath(), app);
               return;
            }

            getGraph().doInTransaction(new NeoModel.Committer() {
               @Override
               public void doAction(Transaction tx) throws Throwable {
                  final String name = templateFile.getName().replaceAll(".stg", "");
                  final Node stGroupNode = getGraph().newNode(Entities.STGroup, AppMotif.Properties.name.name(), name);
                  for (TemplateStatement templateStatement : templateFile.getStatements()) {

                     final Node stNode = getGraph().newNode(Entities.STTemplate,
                           AppMotif.Properties.name.name(), templateStatement.getName(),
                           Properties.text.name(), templateStatement.getText());
                     stNode.addLabel(DomainPlugin.Entities.Entity);
                     stGroupNode.createRelationshipTo(stNode, Relations.ENTITY);

                     for (TemplateParameter templateParameter : templateStatement.getParameters())
                        newTemplateParameter(templateParameter, stNode);
                  }
                  fireNodesLoaded(stGroupNode);
               }

               @Override
               public void exception(Throwable throwable) {
                  SwingUtil.showException(app, throwable);
               }
            });
         }
      });

      menu.add(new App.TransactionAction("New STGroup", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final String name = SwingUtil.showInputDialog("STGroup name", app);
            if (name == null || name.length() == 0) return;

            final Node stGroupNode = getGraph().newNode(Entities.STGroup, AppMotif.Properties.name.name(), name);
            stGroupNode.addLabel(DomainPlugin.Entities.Domain);
            fireNodesLoaded(stGroupNode);
         }
      });
   }

   @Override
   protected void handleNodeRightClick(JPopupMenu pop, Workspace.NodeCanvas.NeoNode neoNode, Set<Workspace.NodeCanvas.NeoNode> selectedNodes) {

      if (hasLabel(neoNode.getNode(), Entities.STGroup)) {
         pop.add(new App.TransactionAction("Add template", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

               final String name = SwingUtil.showInputDialog("Template name", app);
               if (name == null || name.length() == 0) return;

               if (name.contains(" ")) throw new IllegalArgumentException("Template-name cannot have spaces");

               final AtomicBoolean exists = new AtomicBoolean(false);
               outgoing(neoNode.getNode(), DomainPlugin.Relations.ENTITY).forEach(relationship -> {
                  if (name.equalsIgnoreCase(getOtherProperty(neoNode.getNode(), relationship, AppMotif.Properties.name.name()).toString()))
                     exists.set(true);
               });
               if (exists.get()) {
                  SwingUtil.showMessage(name + " already exists for group ", app);
                  return;
               }

               final Node newNode = getGraph().newNode(Entities.STTemplate, AppMotif.Properties.name.name(), name);
               newNode.addLabel(DomainPlugin.Entities.Entity);
               neoNode.getNode().createRelationshipTo(newNode, DomainPlugin.Relations.ENTITY);
               fireNodesLoaded(newNode);
            }
         });

         incoming(neoNode.getNode(), ProjectPlugin.Relations.RENDERER).forEach(rendererRelationship -> pop.add(new App.TransactionAction("Render " + getString(rendererRelationship, ProjectPlugin.Properties.fileType.name()), app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
               renderSTGGroup(neoNode.getNode(), rendererRelationship);
            }
         }));

      } else if (hasLabel(neoNode.getNode(), Entities.STTemplate)) {

         pop.add(new App.TransactionAction("Preview template", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
               SwingUtil.showTextResult("Template", get(neoNode.getNode(), Properties.text.name(), ""), app);
            }
         });
      }
   }

   @Override
   public void showEditorFor(Workspace.NodeCanvas.NeoNode neoNode, JTabbedPane tabbedPane) {
      if (neoNode.getNode().hasLabel(Entities.STTemplate))
         tabbedPane.add(getNameAndLabelsFrom(neoNode.getNode()), new TemplateEditor(neoNode));

      incoming(neoNode.getNode(), Relations.INSTANCE).forEach(instanceRelation -> {
         final Node other = other(neoNode.getNode(), instanceRelation);
         if (hasLabel(other, Entities.STTemplate))
            tabbedPane.add(getNameAndLabelsFrom(neoNode.getNode()), new TemplateRenderPanel(neoNode, other));
      });
   }

   private static RelationCardinality getCardinalityFor(TemplateEntities domainEntityType) {
      switch (domainEntityType) {
         case STRINGPROPERTY:
         case BOOLEANPROPERTY:
         case STATEMENTPROPERTY:
            return RelationCardinality.SINGLE;
         case LISTPROPERTY:
         case KEYVALUELISTPROPERTY:
            return RelationCardinality.LIST;
      }
      throw new IllegalStateException("Unknown domainEntity type " + domainEntityType);
   }

   public static String renderStatement(Node node, Node templateNode) {

      // eom() and gt() are templates that will be available to all templates by default (they are bugfixes from StringTemplate)
      final STGroupString group = new STGroupString("wrapper", "eom() ::= <<}>>\ngt() ::= \">\"", '~', '~');
      group.registerRenderer(String.class, new DefaultAttributeRenderer());
      group.setListener(new STErrorListener() {
         @Override
         public void compileTimeError(STMessage stMessage) {
            System.out.println(stMessage.toString());
         }

         @Override
         public void runTimeError(STMessage msg) {
            if (msg.error == ErrorType.NO_SUCH_ATTRIBUTE) return;
            System.out.println(msg.toString());
         }

         @Override
         public void IOError(STMessage stMessage) {
            System.out.println(stMessage.toString());
         }

         @Override
         public void internalError(STMessage stMessage) {
            System.out.println(stMessage.toString());
         }
      });

      final ST template = new ST(group, getString(templateNode, Properties.text.name()));

      new EntityRelationVisitor() {
         @Override
         public void onSingle(Node relationNode, Node dstNode) {
            final String parameterName = getString(relationNode, AppMotif.Properties.name.name());
            final Node other = other(node, singleOutgoing(node, RelationshipType.withName(parameterName)));
            if (hasLabel(dstNode, DomainPlugin.Entities.Property) && hasLabel(other(node, singleOutgoing(node, RelationshipType.withName(parameterName))), DomainPlugin.Entities.Value)) {
               renderNode(template, relationNode, parameterName, other(node, singleOutgoing(node, RelationshipType.withName(parameterName))));
            } else if (hasLabel(dstNode, DomainPlugin.Entities.Entity) && !hasLabel(other(node, singleOutgoing(node, RelationshipType.withName(parameterName))), DomainPlugin.Entities.Value)) {
               renderNode(template, relationNode, parameterName, other);
            }
         }

         @Override
         public void onList(Node relationNode, Node dstNode) {
            final String parameterName = getString(relationNode, AppMotif.Properties.name.name());

            outgoing(node, RelationshipType.withName(parameterName)).forEach(listRelation -> {
               final Node other = other(node, listRelation);
//               if (hasLabel(dstNode, DomainPlugin.Entities.Property) && hasLabel(other, DomainPlugin.Entities.Value)) {
               if (hasLabel(dstNode, DomainPlugin.Entities.Property)) {
                  renderNode(template, relationNode, parameterName, other);
               } else if (hasLabel(dstNode, DomainPlugin.Entities.Entity) && !hasLabel(other, DomainPlugin.Entities.Value)) {
                  renderNode(template, relationNode, parameterName, other);
               }
            });

//            outgoing(node, RelationshipType.withName(parameterName)).forEach(listRelation -> renderNode(template, relationNode, parameterName, other(node, listRelation)));
         }
      }.visit(templateNode);

      return template.render();
   }

   private static void renderNode(ST template, Node relationNode, String parameterName, Node node) {

      if (node == null) return;

      if (node.hasLabel(DomainPlugin.Entities.Value)) {
         template.add(parameterName, getString(node, AppMotif.Properties.name.name()));

      } else {
         final Node entityReferenceNode = other(node, singleIncoming(node, Relations.INSTANCE));

         switch (RelationCardinality.valueOf(getString(relationNode, DomainPlugin.Properties.relationCardinality.name()))) {

            case SINGLE:
               if (hasLabel(entityReferenceNode, Entities.STTemplate))
                  template.add(parameterName, renderStatement(node, entityReferenceNode));
               else if (hasLabel(entityReferenceNode, DomainPlugin.Entities.Value))
                  template.add(parameterName, getString(node, AppMotif.Properties.name.name()));
               break;

            case LIST:

               if (hasLabel(entityReferenceNode, Entities.STTemplate))
                  template.add(parameterName, renderStatement(node, entityReferenceNode));
               else {

                  final Set<String> keys = getKeys(entityReferenceNode);

                  final Map<String, String> aggrValues = new LinkedHashMap<>();
                  final StringBuilder aggr = new StringBuilder(parameterName + ".{");
                  boolean first = true;
                  for (String key : keys) {

                     final Relationship valueRelation = singleOutgoing(node, RelationshipType.withName(key));
                     if (valueRelation == null) continue;

                     if (!first) aggr.append(",");
                     first = false;
                     aggr.append(key);

                     final Node referenceValueNode = other(node, valueRelation);

                     if (hasLabel(referenceValueNode, DomainPlugin.Entities.Value)) {
                        aggrValues.put(key, getString(referenceValueNode, AppMotif.Properties.name.name()));
                     } else {
                        final Node keyValueReferenceNode = other(referenceValueNode, singleIncoming(referenceValueNode, Relations.INSTANCE));
                        if (hasLabel(keyValueReferenceNode, Entities.STTemplate))
                           aggrValues.put(key, renderStatement(referenceValueNode, keyValueReferenceNode));
                     }
                  }

                  final Object[] values = new Object[aggrValues.keySet().size()];
                  int index = 0;
                  for (String key : aggrValues.keySet())
                     values[index++] = aggrValues.get(key);
                  aggr.append("}");

                  if (values.length > 0)
                     template.addAggr(aggr.toString(), values);
               }
               break;
         }
      }
   }

   public static String escape(String text) {
      return text.
            replaceAll("\\\\", "\\\\\\\\").
            replaceAll("\"", "\\\\\"");
   }

   public static void renderSTGGroup(Node node, Relationship rendererRelationship) {
      final String packageName = getString(rendererRelationship, "package");
      final String groupName = StringUtil.capitalize(getString(node, AppMotif.Properties.name.name())) + "Group";
      final File targetDir = getFile(other(node, rendererRelationship));

      final TemplateGroupGroup group = new TemplateGroupGroup();

      final TemplateGroupGroup.stgBuilderST stgBuilderST = group.newstgBuilder().
            setDelimiter("~");

      final TemplateGroupGroup.GroupClassDeclarationST groupClassDeclaration = group.newGroupClassDeclaration().
            setName(groupName).
            setDomain(getString(node, AppMotif.Properties.name.name())).
            setPackageName(packageName);

      outgoing(node, Relations.ENTITY).forEach(groupStatementRelation -> {

         final TemplateGroupGroup.NewStatementDeclarationST declarationST = group.newNewStatementDeclaration().setGroupname(groupName);
         final Node templateNode = other(node, groupStatementRelation);
         final String statementName = getString(templateNode, AppMotif.Properties.name.name());

         final TemplateGroupGroup.templateST templateST = group.newtemplate().
               setName(statementName);

         new EntityRelationVisitor() {
            @Override
            public void onSingle(Node relationNode, Node dstNode) {
               final String parameterName = getString(relationNode, AppMotif.Properties.name.name());
               templateST.addParamsValue(parameterName);

               declarationST.addPropertiesValue(parameterName, group.newStatementStringPropertySetter().
                     setPropertyName(parameterName).
                     setStatementName(statementName), "Object", null);
            }

            @Override
            public void onList(Node relationNode, Node dstNode) {
               final String parameterName = getString(relationNode, AppMotif.Properties.name.name());
               templateST.addParamsValue(parameterName);

               // list property
               if (hasLabel(dstNode, DomainPlugin.Entities.Property)) {

                  final TemplateGroupGroup.StatementListPropertySetterST listPropertySetterST = group.newStatementListPropertySetter().
                        setPropertyName(parameterName).
                        setStatementName(statementName);
                  declarationST.addPropertiesValue(parameterName, listPropertySetterST, "java.util.Set<Object>", "new java.util.LinkedHashSet<>()");

               } else if (hasLabel(dstNode, DomainPlugin.Entities.Entity)) {

                  // statement-property
                  if (hasLabel(dstNode, Entities.STTemplate)) {

                     final TemplateGroupGroup.StatementListPropertySetterST listPropertySetterST = group.newStatementListPropertySetter().
                           setPropertyName(parameterName).
                           setStatementName(statementName);
                     declarationST.addPropertiesValue(parameterName, listPropertySetterST, "java.util.Set<Object>", "new java.util.LinkedHashSet<>()");

                  } else {

                     // key-value list property
                     final TemplateGroupGroup.StatementKeyValueListPropertySetterST kvSetter = group.newStatementKeyValueListPropertySetter().
                           setPropertyName(parameterName).
                           setStatementName(statementName);

                     // visit Entity's properties (only uses single)
                     new EntityRelationVisitor() {
                        @Override
                        public void onSingle(Node relationNode, Node dstNode) {
                           kvSetter.addKvNamesValue(getString(relationNode, AppMotif.Properties.name.name()));
                        }

                        @Override
                        public void onList(Node relationNode, Node dstNode) {
                           System.out.println("should not be here. ignoring " + getString(relationNode, AppMotif.Properties.name.name()));
                        }
                     }.visit(dstNode);

                     // todo use set of maps
                     declarationST.addPropertiesValue(parameterName, kvSetter, "java.util.Set<java.util.Map<String, Object>>", "new java.util.LinkedHashSet<>()");
                  }
               }
            }
         }.visit(templateNode);

         stgBuilderST.addAppendsValue(templateST.setContent(escape(getString(templateNode, Properties.text.name())).replaceAll("\n", "\\\\n\" + \n\"") + ">>"));
         groupClassDeclaration.addStatementsValue(
               declarationST.
                     setName(statementName),
               group.newNewStatementInstance().
                     setName(statementName));
      });

      groupClassDeclaration.setStg(stgBuilderST);

      try {
         GeneratedFile.newJavaFile(targetDir.getAbsolutePath(), packageName, groupName).write(groupClassDeclaration);
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   @NotNull
   private static Set<String> getKeys(Node entityReferenceNode) {
      final Set<String> existingKeys = new LinkedHashSet<>();
      outgoing(entityReferenceNode, Relations.SRC).forEach(kvRelation -> {
         final Node kvRelationNode = other(entityReferenceNode, kvRelation);
         final String key = getString(kvRelationNode, AppMotif.Properties.name.name());
//         final Node keyNode = other(kvRelationNode, singleOutgoing(kvRelationNode, Relations.DST));
//         final String key = getString(keyNode, AppMotif.Properties.name.name());
         if (key != null) existingKeys.add(key);
      });
      return existingKeys;
   }

   private enum FormatCode {
      capitalize, toUpper, lowFirst, toLower, humpToCap, camelHump, splitCamelHump, packageToPath
   }

   private static final class DefaultAttributeRenderer implements org.stringtemplate.v4.AttributeRenderer {

      @Override
      public String toString(Object o, String formatString, Locale locale) {

         final String text = o.toString();

         if (formatString == null) return text;

         switch (FormatCode.valueOf(formatString)) {
            case capitalize:
               return capitalize(text);
            case toUpper:
               return toUpper(text);
            case lowFirst:
               return lowFirst(text);
            case toLower:
               return text.toLowerCase();
            case humpToCap:
               return humpToCap(text);
            case camelHump:
               return camelHump(text);
            case splitCamelHump:
               return splitCamelHump(text);
            case packageToPath:
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
   }

   private final class TemplateEditor extends JPanel {
      TemplateEditor(Workspace.NodeCanvas.NeoNode templateNode) {
         super(new BorderLayout());

         final JTextArea txtEditor = new JTextArea();
         txtEditor.setText(get(templateNode.getNode(), StringTemplatePlugin.Properties.text.name(), ""));
         txtEditor.setFont(new Font("Hack", Font.PLAIN, 10));
         txtEditor.setTabSize(3);
         txtEditor.setCaretPosition(0);

         txtEditor.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               if (SwingUtilities.isRightMouseButton(e))
                  SwingUtilities.invokeLater(() -> app.showTextProcessor(txtEditor.getText()));
            }
         });

         final Border defaultBorder = txtEditor.getBorder();
         final Color uneditedColor = txtEditor.getBackground();
         final Color editedColor = Color.decode("#fc8d59");

         final String statementName = getString(templateNode.getNode(), AppMotif.Properties.name.name());
         final String delimiter = "~";

         final DefaultHighlighter.DefaultHighlightPainter paramsHighlighter = new DefaultHighlighter.DefaultHighlightPainter(new Color(255, 127, 0));
         txtEditor.addKeyListener(new KeyAdapter() {

            String startText = get(templateNode.getNode(), StringTemplatePlugin.Properties.text.name(), "");

            public void keyPressed(KeyEvent ke) {

               if (ke.getKeyCode() == KeyEvent.VK_ENTER && ke.getModifiers() == KeyEvent.CTRL_MASK) {
                  final int oldCaret = txtEditor.getCaretPosition();
                  txtEditor.setBorder(defaultBorder);
                  final String text = txtEditor.getText().trim();

                  final TemplateStatement parsed;
                  try {
                     final StringBuilder errors = new StringBuilder("Errors");
                     parsed = TemplateFileParser.parse(delimiter, statementName, text, new STErrorListener() {
                        @Override
                        public void compileTimeError(STMessage stMessage) {
                           if (stMessage instanceof STCompiletimeMessage) {
                              final Token token = ((STCompiletimeMessage) stMessage).token;
                              errors.append("\nat ").append(token.getLine()).append(" position ").append(token.getCharPositionInLine());
                           }
                        }

                        @Override
                        public void runTimeError(STMessage stMessage) {

                        }

                        @Override
                        public void IOError(STMessage stMessage) {

                        }

                        @Override
                        public void internalError(STMessage stMessage) {

                        }
                     });

                     if (!"Errors".equals(errors.toString()))
                        throw new IllegalStateException(errors.toString());
                     else if (parsed == null)
                        throw new IllegalStateException("Template is invalid. check syntax");
                  } catch (Throwable e) {
                     txtEditor.setBorder(BorderFactory.createLineBorder(Color.RED));
                     SwingUtil.showExceptionNoStack(txtEditor, e);
                     return;
                  }

                  SwingUtilities.invokeLater(() -> getGraph().doInTransaction(new NeoModel.Committer() {
                     @Override
                     public void doAction(Transaction tx) throws Throwable {

                        final java.util.List<Node> existingParameters = new ArrayList<>();
                        outgoing(templateNode.getNode(), Relations.SRC).forEach(relationship -> existingParameters.add(other(templateNode.getNode(), relationship)));

                        final java.util.List<TemplateParameter> parameters = parsed.getParameters();
                        for (TemplateParameter templateParameter : parameters) {
                           final DomainPlugin.RelationCardinality cardinality = getCardinalityFor(templateParameter.getDomainEntityType());

                           int size = existingParameters.size();
                           for (int i = existingParameters.size() - 1; i >= 0; i--) {
                              final Node existingParameter = existingParameters.get(i);

                              // if existing parameter has same name and cardinality
                              if (templateParameter.getPropertyName().equals(getString(existingParameter, AppMotif.Properties.name.name()))) {

                                 if (cardinality.equals(DomainPlugin.RelationCardinality.valueOf(getString(existingParameter, DomainPlugin.Properties.relationCardinality.name())))) {

                                    if (templateParameter.getDomainEntityType().equals(TemplateEntities.KEYVALUELISTPROPERTY)) {

                                       final Node entityNode = other(existingParameter, singleOutgoing(existingParameter, Relations.DST));
                                       final Set<String> newKeys = new LinkedHashSet<>(templateParameter.getKvNames());
                                       final Set<String> existingKeys = getKeys(entityNode);

                                       final Set<String> oldKeys = new LinkedHashSet<>();
                                       for (String existingKey : existingKeys) {
                                          if (newKeys.contains(existingKey)) {
                                             newKeys.remove(existingKey);
                                             continue;
                                          }
                                          oldKeys.add(existingKey);
                                       }

                                       for (String oldKey : oldKeys) {
                                          outgoing(entityNode, DomainPlugin.Relations.SRC).forEach(kvRelation -> {
                                             final Node kvRelationNode = other(entityNode, kvRelation);
                                             final Relationship kvRelationship = singleOutgoing(kvRelationNode, Relations.DST);
                                             final Node keyNode = other(kvRelationNode, kvRelationship);

                                             final String existingName = getString(keyNode, AppMotif.Properties.name.name(), "");
                                             if (existingName.equals(oldKey)) {

                                                // deprecate all INSTANCES of this property:
                                                outgoing(keyNode, DomainPlugin.Relations.INSTANCE).forEach(instanceRelation -> {
                                                   final Node instanceNode = other(keyNode, instanceRelation);

                                                   final Relationship oldPropertyRelation = singleOutgoing(instanceNode, RelationshipType.withName(oldKey));
                                                   if (oldPropertyRelation == null) return;

                                                   oldPropertyRelation.setProperty(Properties.deprecated.name(), "true");
                                                });

                                                kvRelation.delete();
                                                kvRelationship.delete();
                                                AppMotif.tryToDeleteValueNode(kvRelationNode);
                                                AppMotif.tryToDeleteValueNode(keyNode);
                                             }
                                          });
                                       }

                                       for (String newKey : newKeys) {
                                          newEntityRelation(entityNode, newKey, RelationCardinality.SINGLE, getGraph().newNode(DomainPlugin.Entities.Property, AppMotif.Properties.name.name(), newKey));
                                       }
                                    }

                                    existingParameters.remove(existingParameter);   // parameter exists
                                    break;
                                 }
                              }
                           }

                           if (existingParameters.size() == size)
                              newTemplateParameter(templateParameter, templateNode.getNode());
                        }

                        for (Node existingParameter : existingParameters) {
                           // unlink all INSTANCES of this parameter:
                           outgoing(existingParameter, DomainPlugin.Relations.INSTANCE).forEach(instanceRelation -> {
                              final Node instanceNode = other(existingParameter, instanceRelation);

                              instanceRelation.delete();
                              AppMotif.tryToDeleteValueNode(instanceNode);
                           });

                           // delete parameter-node
                           incoming(existingParameter).forEach(Relationship::delete);
                           AppMotif.tryToDeleteValueNode(existingParameter);
                        }

                        templateNode.getNode().setProperty(StringTemplatePlugin.Properties.text.name(), txtEditor.getText().trim());
                        txtEditor.setText(parsed.getText().trim());
                        txtEditor.setCaretPosition(Math.min(text.length(), Math.max(0, oldCaret)));
                        startText = get(templateNode.getNode(), StringTemplatePlugin.Properties.text.name(), "");
                        txtEditor.setBackground(uneditedColor);

                        // re-render all statements of this template
                        outgoing(templateNode.getNode(), Relations.INSTANCE).forEach(relationship -> {
                           final Node instanceNode = other(templateNode.getNode(), relationship);
                           incoming(instanceNode, ProjectPlugin.Relations.RENDERER).forEach(rendererRelation -> {
                              final Node dirNode = other(instanceNode, rendererRelation);
                              final String content = renderStatement(instanceNode, templateNode.getNode());
                              ProjectPlugin.renderToFile(rendererRelation, instanceNode, content, dirNode, app);
                           });
                        });
                     }

                     @Override
                     public void exception(Throwable throwable) {
                        SwingUtil.showException(txtEditor, throwable);
                     }
                  }));


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

               } else {
                  SwingUtilities.invokeLater(() -> txtEditor.setBackground(startText.equals(txtEditor.getText().trim()) ? uneditedColor : editedColor));
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

               final String input = SwingUtil.showInputDialog(AppMotif.Properties.name.name(), txtEditor);
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

         add(new JScrollPane(txtEditor), BorderLayout.CENTER);
      }
   }

   private void newTemplateParameter(TemplateParameter templateParameter, Node templateNode) {
      switch (templateParameter.getDomainEntityType()) {
         case STATEMENTPROPERTY: // todo split this and use referenceType = ReferenceType.ENTITY;
         case STRINGPROPERTY:
         case BOOLEANPROPERTY:
            newEntityRelation(templateNode, templateParameter.getPropertyName(), RelationCardinality.SINGLE, getGraph().newNode(DomainPlugin.Entities.Property, AppMotif.Properties.name.name(), templateParameter.getPropertyName()));
            break;
         case LISTPROPERTY:
            newEntityRelation(templateNode, templateParameter.getPropertyName(), RelationCardinality.LIST, getGraph().newNode(DomainPlugin.Entities.Property, AppMotif.Properties.name.name(), templateParameter.getPropertyName()));
            break;
         case KEYVALUELISTPROPERTY:
            final Node newParameterNode = getGraph().newNode(DomainPlugin.Entities.Entity, AppMotif.Properties.name.name(), templateParameter.getPropertyName());
            templateParameter.getKvNames().forEach(key -> {
               newEntityRelation(newParameterNode, key, RelationCardinality.SINGLE, getGraph().newNode(DomainPlugin.Entities.Property, AppMotif.Properties.name.name(), key));
            });
            newEntityRelation(templateNode, templateParameter.getPropertyName(), RelationCardinality.LIST, newParameterNode);
            break;
      }
   }

   private final class TemplateRenderPanel extends JPanel {
      TemplateRenderPanel(Workspace.NodeCanvas.NeoNode statementNode, Node templateNode) {
         super(new BorderLayout());

         final JTextArea txtEditor = new JTextArea(25, 85);
         txtEditor.setFont(new Font("Hack", Font.PLAIN, 10));
         txtEditor.setTabSize(3);
         txtEditor.setEditable(false);
         txtEditor.setText(renderStatement(statementNode.getNode(), templateNode));
         txtEditor.setCaretPosition(0);

         txtEditor.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               if (SwingUtilities.isLeftMouseButton(e)) {
                  onLeftClick(txtEditor, statementNode, templateNode);
               } else if (SwingUtilities.isRightMouseButton(e)) {
                  onRightClick(txtEditor);
               }
            }
         });

         addNodeChangedListener(statementNode, new AppEvents.TransactionalPropertyChangeListener<Object, Object>(getClass(), TemplateRenderPanel.this, app) {
            @Override
            protected void propertyChange(Object oldValue, Object newValue) {
               txtEditor.setText(renderStatement(statementNode.getNode(), templateNode));
               txtEditor.setCaretPosition(0);
            }
         });

         add(new JScrollPane(txtEditor), BorderLayout.CENTER);
      }

      private void onLeftClick(JTextArea txtEditor, Workspace.NodeCanvas.NeoNode statementNode, Node templateNode) {
         SwingUtilities.invokeLater(() -> getGraph().doInTransaction(new NeoModel.Committer() {
            @Override
            public void doAction(Transaction tx) throws Throwable {
               txtEditor.setText(renderStatement(statementNode.getNode(), templateNode));
               txtEditor.setCaretPosition(0);
            }

            @Override
            public void exception(Throwable throwable) {
               final StringBuilder stack = new StringBuilder("ERROR: " + throwable.getMessage() + "\n");
               for (StackTraceElement stackTraceElement : throwable.getStackTrace())
                  stack.append(stackTraceElement.toString()).append("\n");
               txtEditor.setText(stack.toString());
               txtEditor.setCaretPosition(0);
            }
         }));
      }

      private void onRightClick(JTextArea txtEditor) {
         SwingUtil.toClipboard(txtEditor.getText());
      }
   }
}
