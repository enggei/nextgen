package com.generator.generators.stringtemplate;

import com.generator.app.*;
import com.generator.app.nodes.NeoNode;
import com.generator.generators.domain.DomainPlugin;
import com.generator.generators.domain.Visitor;
import com.generator.generators.project.ProjectPlugin;
import com.generator.generators.stringtemplate.domain.TemplateEntities;
import com.generator.generators.stringtemplate.domain.TemplateFile;
import com.generator.generators.stringtemplate.domain.TemplateParameter;
import com.generator.generators.stringtemplate.domain.TemplateStatement;
import com.generator.generators.stringtemplate.parser.TemplateFileParser;
import com.generator.neo.NeoModel;
import com.generator.util.RegexpUtil;
import com.generator.util.StringUtil;
import com.generator.util.SwingUtil;
import com.generator.util.TextProcessingPanel;
import org.antlr.runtime.Token;
import org.jetbrains.annotations.NotNull;
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

import static com.generator.app.DomainMotif.*;
import static com.generator.generators.domain.DomainPlugin.*;
import static com.generator.generators.project.ProjectPlugin.getFile;
import static com.generator.util.NeoUtil.*;

/**
 * Created 06.08.17.
 */
public class StringTemplatePlugin extends StringTemplateDomainPlugin {
   private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(StringTemplatePlugin.class);
   public StringTemplatePlugin(App app) {
      super(app);
   }

   @Override
   protected void addActionsTo(JMenu menu) {

      addShowMenu(menu, Entities.STGroup);

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
                  final Node stGroupNode = newSTGroup(name);
                  for (TemplateStatement templateStatement : templateFile.getStatements()) {

                     final Node stNode = newSTTemplate(templateStatement.getText(), templateStatement.getName());
                     stNode.addLabel(DomainPlugin.Entities.Entity);
                     relateTEMPLATE(stGroupNode, stNode);

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

            final Node stGroupNode = newSTGroup(name);
            stGroupNode.addLabel(DomainPlugin.Entities.Domain);
            fireNodesLoaded(stGroupNode);
         }
      });
   }

   @Override
   protected void handleSTTemplate(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) {

      final Set<Node> statementNodes = new LinkedHashSet<>();

      outgoingINSTANCE(neoNode.getNode(), (relationship, instanceNode) -> statementNodes.add(instanceNode));

      pop.add(new App.TransactionAction("Edit", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final JPanel editor = new JPanel(new BorderLayout());

            final JTabbedPane tabbedPane = new JTabbedPane();
            int i = 1;
            for (Node statementNode : statementNodes)
               tabbedPane.add(i + "", new TemplateRenderPanel(statementNode, neoNode.getNode()));

            final TemplateEditor templateEditor = new TemplateEditor(neoNode, templateNode -> {
               for (int j = 0; j < tabbedPane.getComponentCount(); j++)
                  ((TemplateRenderPanel) tabbedPane.getComponent(j)).render();
            });

            final JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, templateEditor, tabbedPane);
            editor.add(split, BorderLayout.CENTER);

            SwingUtil.showDialog(editor, app, "Edit Template");
         }
      });
   }

   @Override
   protected void handleSTGroup(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) {

      pop.add(new App.TransactionAction("Add template", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final String name = SwingUtil.showInputDialog("Template name", app);
            if (name == null || name.length() == 0) return;

            if (name.contains(" ")) throw new IllegalArgumentException("Template-name cannot have spaces");

            final AtomicBoolean exists = new AtomicBoolean(false);
            outgoingTEMPLATE(neoNode.getNode(), (relationship, other) -> {
               if (name.equalsIgnoreCase(getNameProperty(other))) exists.set(true);
            });
            if (exists.get()) {
               SwingUtil.showMessage(name + " already exists for group ", app);
               return;
            }

            final Node newNode = newSTTemplate("",name);
            newNode.addLabel(DomainPlugin.Entities.Entity);
            neoNode.getNode().createRelationshipTo(newNode, Relations.TEMPLATE);
            fireNodesLoaded(newNode);
         }
      });

      for (NeoNode selectedNode : selectedNodes) {
         if (isSTTemplate(selectedNode.getNode())) {
            if (isRelated(neoNode.getNode(), selectedNode.getNode(), Relations.TEMPLATE)) continue;

            final String templateName = getNameProperty(selectedNode.getNode());
            final AtomicBoolean exists = new AtomicBoolean(false);
            outgoingTEMPLATE(neoNode.getNode(), (relationship, other) -> {
               if (templateName.equals(getNameProperty(other))) exists.set(true);
            });
            if (exists.get()) continue;   // template with same name already exists for this STGroup

            pop.add(new App.TransactionAction("Add template -> " + getNameAndLabelsFrom(selectedNode.getNode()), app) {
               @Override
               protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  relateTEMPLATE(neoNode.getNode(), selectedNode.getNode());
               }
            });
         }
      }

      ProjectPlugin.incomingRENDERER(neoNode.getNode(), (rendererRelationship, other) -> pop.add(new App.TransactionAction("Render " + ProjectPlugin.getFileTypeProperty(rendererRelationship), app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
            new STGGroupRenderer(rendererRelationship).visit(neoNode.getNode());
         }
      }));
   }

   @Override
   protected JComponent newSTTemplateEditor(NeoNode neoNode) {
      return new TemplateEditor(neoNode, templateNode -> {
         // when saved re-render all instances of this template:
         outgoing(templateNode, DomainPlugin.Relations.INSTANCE).forEach(relationship -> {
            final Node instanceNode = other(templateNode, relationship);
            incoming(instanceNode, ProjectPlugin.Relations.RENDERER).forEach(rendererRelation -> {
               final Node dirNode = other(instanceNode, rendererRelation);
               final String content = renderStatement(instanceNode, templateNode);
               ProjectPlugin.renderToFile(rendererRelation, instanceNode, content, dirNode);
            });
         });

      });
   }

   @Override
   public JComponent getEditorFor(NeoNode neoNode) {
      final JComponent component = super.getEditorFor(neoNode);
      if (component == null) {
         // try to render any STTemplate, by looking for STTEmplate-instance
         final Relationship instanceRelation = singleIncoming(neoNode.getNode(), DomainPlugin.Relations.INSTANCE);
         final Node other = other(neoNode.getNode(), instanceRelation);
         if (isSTTemplate(other)) return new TemplateRenderPanel(neoNode, other);
      }
      return component;
   }

   private static RelationCardinality getCardinalityFor(TemplateEntities domainEntityType) {
      switch (domainEntityType) {
         case STRINGPROPERTY:
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
            log.info(stMessage.toString());
         }

         @Override
         public void runTimeError(STMessage msg) {
            if (msg.error == ErrorType.NO_SUCH_ATTRIBUTE) return;
            log.info(msg.toString());
         }

         @Override
         public void IOError(STMessage stMessage) {
            log.info(stMessage.toString());
         }

         @Override
         public void internalError(STMessage stMessage) {
            log.info(stMessage.toString());
         }
      });

      final ST template = new ST(group, getTextProperty(templateNode));

      new EntityRelationVisitor() {
         @Override
         public void onSingle(Node relationNode, Node dstNode) {
            final String parameterName = getNameProperty(relationNode);
            final Node other = other(node, singleOutgoing(node, RelationshipType.withName(parameterName)));
            if (isProperty(dstNode) && isValue(other(node, singleOutgoing(node, RelationshipType.withName(parameterName))))) {
               renderNode(template, relationNode, parameterName, other(node, singleOutgoing(node, RelationshipType.withName(parameterName))));
            } else if (isEntity(dstNode) && !isValue(other(node, singleOutgoing(node, RelationshipType.withName(parameterName))))) {
               renderNode(template, relationNode, parameterName, other);
            }
         }

         @Override
         public void onList(Node relationNode, Node dstNode) {
            final String parameterName = getNameProperty(relationNode);

            outgoing(node, RelationshipType.withName(parameterName)).forEach(listRelation -> {
               final Node other = other(node, listRelation);
               if (isProperty(dstNode)) {
                  renderNode(template, relationNode, parameterName, other);
               } else if (isEntity(dstNode) && !isValue(other)) {
                  renderNode(template, relationNode, parameterName, other);
               }
            });
         }
      }.visit(templateNode);

      return template.render();
   }

   private static void renderNode(ST template, Node relationNode, String parameterName, Node node) {

      if (node == null) return;

      if (isValue(node)) {
         template.add(parameterName, getNameProperty(node));
      } else {

         final Node entityReferenceNode = other(node, singleIncoming(node, DomainPlugin.Relations.INSTANCE));

         switch (RelationCardinality.valueOf(getRelationCardinalityProperty(relationNode))) {

            case SINGLE:
               if (isSTTemplate(entityReferenceNode))
                  template.add(parameterName, renderStatement(node, entityReferenceNode));
               else if (isValue(entityReferenceNode))
                  template.add(parameterName, getNameProperty(node));
               break;

            case LIST:

               if (isSTTemplate(entityReferenceNode))
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

                     if (isValue(referenceValueNode)) {
                        aggrValues.put(key, getNameProperty(referenceValueNode));
                     } else {
                        final Node keyValueReferenceNode = other(referenceValueNode, singleIncoming(referenceValueNode, DomainPlugin.Relations.INSTANCE));
                        if (isSTTemplate(keyValueReferenceNode))
                           aggrValues.put(key, renderStatement(referenceValueNode, keyValueReferenceNode));
                     }
                  }

                  final Object[] values = new Object[aggrValues.keySet().size()];
                  int index = 0;
                  for (String key : aggrValues.keySet())
                     values[index++] = aggrValues.get(key);
                  aggr.append("}");
                  if (values.length > 0) template.addAggr(aggr.toString(), values);
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

   public static final class STGGroupRenderer implements Visitor<String> {

      private final TemplateGroupGroup group = new TemplateGroupGroup();
      private final Relationship rendererRelationship;
      private String result;

      public STGGroupRenderer(Relationship rendererRelationship) {
         this.rendererRelationship = rendererRelationship;
      }

      @Override
      public String getResult() {
         return result;
      }

      @Override
      public void visit(Node node) {
         final String packageName = getPackageNameProperty(rendererRelationship);
         final String groupName = StringUtil.capitalize(getNameProperty(node)) + "Group";
         final File targetDir = getFile(other(node, rendererRelationship));

         final TemplateGroupGroup.stgBuilderST stgBuilderST = group.newstgBuilder().
               setDelimiter("~");

         final TemplateGroupGroup.GroupClassDeclarationST groupClassDeclaration = group.newGroupClassDeclaration().
               setName(groupName).
               setDomain(getNameProperty(node)).
               setPackageName(packageName);

         outgoingTEMPLATE(node, (groupStatementRelation, templateNode) -> {

            if (!isSTTemplate(templateNode)) return;

            final TemplateGroupGroup.NewStatementDeclarationST declarationST = group.newNewStatementDeclaration().setGroupname(groupName);
            final String statementName = getNameProperty(templateNode);

            final TemplateGroupGroup.templateST templateST = group.newtemplate().
                  setName(statementName);

            new EntityRelationVisitor() {

               @Override
               public void onSingle(Node relationNode, Node dstNode) {
                  final String parameterName = getNameProperty(relationNode);
                  templateST.addParamsValue(parameterName);

                  declarationST.addPropertiesValue(parameterName, group.newStatementStringPropertySetter().
                        setPropertyName(parameterName).
                        setStatementName(statementName), "Object", null);
               }

               @Override
               public void onList(Node relationNode, Node dstNode) {
                  final String parameterName = getNameProperty(relationNode);
                  templateST.addParamsValue(parameterName);

                  // list property
                  if (isProperty(dstNode)) {
                     final TemplateGroupGroup.StatementListPropertySetterST listPropertySetterST = group.newStatementListPropertySetter().
                           setPropertyName(parameterName).
                           setStatementName(statementName);
                     declarationST.addPropertiesValue(parameterName, listPropertySetterST, "java.util.Set<Object>", "new java.util.LinkedHashSet<>()");

                  } else if (isEntity(dstNode)) {

                     // statement-property
                     if (isSTTemplate(dstNode)) {
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
                              kvSetter.addKvNamesValue(getNameProperty(relationNode));
                           }

                           @Override
                           public void onList(Node relationNode, Node dstNode) {
                              log.info("should not be here. ignoring " + getNameProperty(relationNode));
                           }
                        }.visit(dstNode);

                        declarationST.addPropertiesValue(parameterName, kvSetter, "java.util.Set<java.util.Map<String, Object>>", "new java.util.LinkedHashSet<>()");
                     }
                  }
               }
            }.visit(templateNode);

            // todo issue with template ending with >: it appends >> for template, so result is >>>, which STGroup cannot parse
            final String content = escape(getTextProperty(templateNode)).replaceAll("\n", "\\\\n\" + \n\"");
            stgBuilderST.addAppendsValue(templateST.setContent(content.endsWith(">") ? (content.trim() + " ") : content.trim()));
            groupClassDeclaration.addStatementsValue(declarationST.setName(statementName), statementName);
         });

         groupClassDeclaration.setStg(stgBuilderST);

         try {
            GeneratedFile.newJavaFile(targetDir.getPath(), packageName, groupName).write(groupClassDeclaration);
         } catch (IOException e) {
            e.printStackTrace();
         }

         this.result = groupClassDeclaration.toString();
      }
   }

   @NotNull
   private static Set<String> getKeys(Node entityReferenceNode) {
      final Set<String> existingKeys = new LinkedHashSet<>();
      outgoingSRC(entityReferenceNode, (kvRelation, kvRelationNode) -> {
         final String key = getNameProperty(kvRelationNode);
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

   interface TemplateEditorListener {

      void onTemplateSaved(Node templateNode);
   }

   private final class TemplateEditor extends JPanel {
      TemplateEditor(NeoNode templateNode, TemplateEditorListener templateEditorListener) {
         super(new BorderLayout());

         final JTextArea txtEditor = SwingUtil.newTextArea();

         txtEditor.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               if (SwingUtilities.isRightMouseButton(e))
                  SwingUtilities.invokeLater(() -> {
                     final TextProcessingPanel processingPanel = new TextProcessingPanel(txtEditor.getText(), Collections.emptySet());
                     SwingUtil.showDialog(processingPanel, app, "Process Text", new SwingUtil.ConfirmAction() {
                        @Override
                        public void verifyAndCommit() throws Exception {
                           final String outputText = processingPanel.getOutputText();
                           if (outputText.trim().length() == 0) return;
                           txtEditor.setText(outputText);
                           SwingUtilities.invokeLater(() -> txtEditor.dispatchEvent(new KeyEvent(txtEditor, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_ENTER, '\n')));
                        }
                     });
                  });
            }
         });

         txtEditor.setText(getTextProperty(templateNode.getNode(),""));

         final Border defaultBorder = txtEditor.getBorder();
         final Color uneditedColor = txtEditor.getBackground();
         final Color editedColor = Color.decode("#fc8d59");

         final String statementName = getNameProperty(templateNode.getNode());
         final String delimiter = "~";

         final DefaultHighlighter.DefaultHighlightPainter paramsHighlighter = new DefaultHighlighter.DefaultHighlightPainter(new Color(255, 127, 0));
         txtEditor.addKeyListener(new KeyAdapter() {

            String startText = getTextProperty(templateNode.getNode(), "");

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
                        outgoingSRC(templateNode.getNode(), (relationship, other) -> existingParameters.add(other));

                        final java.util.List<TemplateParameter> parameters = parsed.getParameters();
                        for (TemplateParameter templateParameter : parameters) {
                           final RelationCardinality cardinality = getCardinalityFor(templateParameter.getDomainEntityType());

                           int size = existingParameters.size();
                           for (int i = existingParameters.size() - 1; i >= 0; i--) {
                              final Node existingParameter = existingParameters.get(i);

                              // if existing parameter has same name and cardinality
                              if (templateParameter.getPropertyName().equals(getNameProperty(existingParameter))) {
                                 if (cardinality.equals(RelationCardinality.valueOf(getRelationCardinalityProperty(existingParameter)))) {

                                    if (templateParameter.getDomainEntityType().equals(TemplateEntities.KEYVALUELISTPROPERTY)) {

                                       final Node entityNode = other(existingParameter, singleOutgoing(existingParameter, DomainPlugin.Relations.DST));
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
                                          outgoingSRC(entityNode, (kvRelation, kvRelationNode) -> {

                                             final Relationship kvRelationship = singleOutgoing(kvRelationNode, DomainPlugin.Relations.DST);
                                             final Node keyNode = other(kvRelationNode, kvRelationship);

                                             final String existingName = getNameProperty(keyNode);
                                             if (existingName.equals(oldKey)) {
                                                // deprecate all INSTANCES of this property:
                                                outgoingINSTANCE(keyNode, (instanceRelation, instanceNode) -> {
                                                   final Relationship oldPropertyRelation = singleOutgoing(instanceNode, RelationshipType.withName(oldKey));
                                                   log.info("old key value " + existingName + " -> " + getNameProperty(instanceNode));
                                                });

                                                kvRelation.delete();
                                                kvRelationship.delete();
                                                AppMotif.tryToDeleteValueNode(kvRelationNode);
                                                AppMotif.tryToDeleteValueNode(keyNode);
                                             }
                                          });
                                       }

                                       for (String newKey : newKeys) {
                                          newDomainEntityRelation(getGraph(), entityNode, newKey, RelationCardinality.SINGLE, newProperty(getGraph(), newKey));
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
                           outgoingINSTANCE(existingParameter, (instanceRelation, instanceNode) -> {
                              instanceRelation.delete();
                              AppMotif.tryToDeleteValueNode(instanceNode);
                           });

                           // delete parameter-node
                           incoming(existingParameter).forEach(Relationship::delete);
                           AppMotif.tryToDeleteValueNode(existingParameter);
                        }

                        setTextProperty(templateNode.getNode(), txtEditor.getText().trim());

                        txtEditor.setText(parsed.getText().trim());
                        txtEditor.setCaretPosition(Math.min(text.length(), Math.max(0, oldCaret)));
                        startText = getTextProperty(templateNode.getNode());
                        txtEditor.setBackground(uneditedColor);

                        templateEditorListener.onTemplateSaved(templateNode.getNode());
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

               } else if (ke.getKeyCode() == KeyEvent.VK_F && ke.getModifiers() == KeyEvent.CTRL_MASK) {
                  format();

               } else {
                  SwingUtilities.invokeLater(() -> txtEditor.setBackground(startText.equals(txtEditor.getText().trim()) ? uneditedColor : editedColor));
               }
            }

            private void makeMethod() {
               final String selected = txtEditor.getSelectedText();
               if (selected == null || selected.length() < 1) return;
               log.info(selected);
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

               final String name = input.contains(" ") ? input.split(" ")[0] : input;
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

            private void format() {
               final String replace = RegexpUtil.replace("[ ]{2}", txtEditor.getText(), " ");
               txtEditor.setText(replace);
               txtEditor.setCaretPosition(0);
            }
         });

         add(new JScrollPane(txtEditor), BorderLayout.CENTER);
      }
   }

   private void newTemplateParameter(TemplateParameter templateParameter, Node templateNode) {
      switch (templateParameter.getDomainEntityType()) {
         case STRINGPROPERTY:
            newDomainEntityRelation(getGraph(), templateNode, templateParameter.getPropertyName(), RelationCardinality.SINGLE, DomainPlugin.newProperty(getGraph(), templateParameter.getPropertyName()));
            break;
         case LISTPROPERTY:
            newDomainEntityRelation(getGraph(), templateNode, templateParameter.getPropertyName(), RelationCardinality.LIST, DomainPlugin.newProperty(getGraph(), templateParameter.getPropertyName()));
            break;
         case KEYVALUELISTPROPERTY:
            final Node newParameterNode = DomainPlugin.newEntity(getGraph(), templateParameter.getPropertyName());
            templateParameter.getKvNames().forEach(key -> newDomainEntityRelation(getGraph(), newParameterNode, key, RelationCardinality.SINGLE, DomainPlugin.newProperty(getGraph(), key)));
            newDomainEntityRelation(getGraph(), templateNode, templateParameter.getPropertyName(), RelationCardinality.LIST, newParameterNode);
            break;
      }
   }

   private final class TemplateRenderPanel extends JPanel {

      private final JTextArea txtEditor = new JTextArea(25, 85);
      private final Node statementNode;
      private final Node templateNode;

      TemplateRenderPanel(Node statementNode, Node templateNode) {
         super(new BorderLayout());

         this.statementNode = statementNode;
         this.templateNode = templateNode;

         txtEditor.setFont(com.generator.app.AppMotif.getDefaultFont());
         txtEditor.setTabSize(3);
         txtEditor.setEditable(false);
         render();

         txtEditor.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               if (SwingUtilities.isLeftMouseButton(e)) {
                  onLeftClick(txtEditor);
               } else if (SwingUtilities.isRightMouseButton(e)) {
                  onRightClick(txtEditor);
               }
            }
         });

         add(new JScrollPane(txtEditor), BorderLayout.CENTER);
      }

      TemplateRenderPanel(NeoNode statementNode, Node templateNode) {
         this(statementNode.getNode(), templateNode);

         addNodeChangedListener(statementNode, new AppEvents.TransactionalPropertyChangeListener<Object, Object>(getClass(), TemplateRenderPanel.this, app) {
            @Override
            protected void propertyChange(Object oldValue, Object newValue) {
               render();
            }
         });
      }

      private void render() {
         txtEditor.setText(renderStatement(statementNode, templateNode));
         txtEditor.setCaretPosition(0);
      }

      private void onLeftClick(JTextArea txtEditor) {
         SwingUtilities.invokeLater(() -> getGraph().doInTransaction(new NeoModel.Committer() {
            @Override
            public void doAction(Transaction tx) throws Throwable {
               render();
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