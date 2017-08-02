package com.generator.app;

import com.generator.app.App.TransactionAction;
import com.generator.editors.NeoModel;
import com.generator.generators.templates.TemplateDomainImpl;
import com.generator.generators.templates.domain.TemplateEntities;
import com.generator.generators.templates.domain.TemplateParameter;
import com.generator.generators.templates.domain.TemplateStatement;
import com.generator.generators.templates.parser.TemplateFileParser;
import com.generator.util.SwingUtil;
import org.antlr.runtime.Token;
import org.neo4j.graphdb.*;
import org.stringtemplate.v4.STErrorListener;
import org.stringtemplate.v4.misc.STCompiletimeMessage;
import org.stringtemplate.v4.misc.STMessage;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.text.DefaultHighlighter;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.*;

import static com.generator.app.TemplateMotif.getLabelFor;
import static com.generator.app.TemplateMotif.render;
import static com.generator.editors.BaseDomainVisitor.*;

/**
 * Created 18.07.17.
 */
class NodeDetailPanel extends JPanel {

   private App app;
   private Workspace workspace;
   private final JTabbedPane content = new JTabbedPane();

   NodeDetailPanel(App app, Workspace workspace) {
      super(new BorderLayout());
      this.app = app;
      this.workspace = workspace;
      setBackground(Color.decode(app.model.getCurrentCanvasColor()));

      add(content, BorderLayout.CENTER);

      app.events.addNodesClosedListener(new AppEvents.EventsTransactionHandler(getClass(), NodeDetailPanel.this, app.model) {
         @Override
         public void doAction(Transaction tx) throws Throwable {
            updatePanel();
         }
      });

      app.events.addNodesSelectedListener(new AppEvents.EventsTransactionHandler(getClass(), NodeDetailPanel.this, app.model) {
         @Override
         public void doAction(Transaction tx) throws Throwable {
            updatePanel();
         }
      });

      app.events.addRelationsSelectedListener(new AppEvents.EventsTransactionHandler(getClass(), NodeDetailPanel.this, app.model) {
         @Override
         public void doAction(Transaction tx) throws Throwable {
            updatePanel();
         }
      });

      app.events.addGraphNewListener(evt -> SwingUtilities.invokeLater(this::updatePanel));
   }

   private void updatePanel() {

      content.removeAll();

      final Set<Workspace.NodeCanvas.NeoNode> currentNodes = app.workspace.nodeCanvas.getSelectedNodes();
      final Set<Workspace.NodeCanvas.NeoRelationship> currentRelations = workspace.nodeCanvas.getSelectedRelations();

      int max = 0;
      if (!currentNodes.isEmpty()) {
         content.add("Labels", new LabelsPanel(currentNodes));
         content.add("Properties", new PropertiesPanel(currentNodes));

         final Set<Relationship> elements = new LinkedHashSet<>();
         for (Workspace.NodeCanvas.NeoNode node : currentNodes)
            node.getNode().getRelationships(Direction.OUTGOING).forEach(elements::add);
         content.add("Node-Relations", new RelationsPanel(elements));
         max += 3;
      }

      if (!currentRelations.isEmpty()) {
         final Set<Relationship> elements = new LinkedHashSet<>();
         for (Workspace.NodeCanvas.NeoRelationship currentRelation : currentRelations)
            elements.add(currentRelation.getRelationship());
         content.add("Relations", new RelationsPanel(elements));
         max += 1;
      }

      if (currentNodes.size() < 20) {
         for (Workspace.NodeCanvas.NeoNode currentNode : currentNodes) {

            if (currentNode.getNode().hasLabel(TemplateMotif.Entities._STTemplate))
               content.add(getString(currentNode.getNode(), AppMotif.Properties.name.name()), new TemplateEditor(currentNode));

            currentNode.getNode().getLabels().forEach(label -> app.model.graph().findNodes(TemplateMotif.Entities._STTemplate, AppMotif.Properties.name.name(), label.name()).forEachRemaining(templateNode -> content.add(getString(currentNode.getNode(), AppMotif.Properties.name.name()), new TemplateRenderPanel(currentNode, templateNode))));

            if (currentNode.getNode().hasLabel((ProjectMotif.Entities._Directory)))
               content.add(getString(currentNode.getNode(), AppMotif.Properties.name.name()), new DirectoryEditor(currentNode));
         }
      }

      if (content.getTabCount() > max)
         content.setSelectedIndex(content.getTabCount() - 1);

      SwingUtilities.invokeLater(() -> {
         content.revalidate();
         content.repaint();
      });
   }

   private final class LabelsPanel extends JPanel {

      private AppMotif.PropertiesToShow propertiesToShow = app.model.getPropertiesFilter();
      private JScrollPane centerPanel;

      LabelsPanel(Set<Workspace.NodeCanvas.NeoNode> currentNodes) {
         super(new BorderLayout());
         final JPanel filterPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

         final JRadioButton radAll = new JRadioButton(new AbstractAction("All") {
            @Override
            public void actionPerformed(ActionEvent e) {
               propertiesToShow = AppMotif.PropertiesToShow.all;
               app.model.setPropertiesFilter(propertiesToShow);
               updateTable(currentNodes);
            }
         });
         if (propertiesToShow.equals(AppMotif.PropertiesToShow.all)) radAll.setSelected(true);
         final JRadioButton radWithValues = new JRadioButton(new AbstractAction("Has values") {
            @Override
            public void actionPerformed(ActionEvent e) {
               propertiesToShow = AppMotif.PropertiesToShow.hasValue;
               app.model.setPropertiesFilter(propertiesToShow);
               updateTable(currentNodes);
            }
         });
         if (propertiesToShow.equals(AppMotif.PropertiesToShow.hasValue)) radWithValues.setSelected(true);
         final ButtonGroup radGroup = new ButtonGroup();
         radGroup.add(radAll);
         radGroup.add(radWithValues);
         filterPanel.add(new JLabel("Filter"));
         filterPanel.add(radAll);
         filterPanel.add(radWithValues);

         centerPanel = new JScrollPane(new LabelsTable(new LabelTableModel(currentNodes, getLabelsToShow(currentNodes))), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

         add(filterPanel, BorderLayout.NORTH);
         add(centerPanel, BorderLayout.CENTER);
      }

      private Set<String> getLabelsToShow(Set<Workspace.NodeCanvas.NeoNode> currentNodes) {
         final Set<String> labels = new TreeSet<>();
         switch (propertiesToShow) {
            case all:
               app.model.graph().getGraphDb().getAllLabelsInUse().forEach(label -> labels.add(label.name()));
               break;
            case hasValue:
               app.model.graph().getGraphDb().getAllLabelsInUse().forEach(s -> {
                  for (Workspace.NodeCanvas.NeoNode currentNode : currentNodes)
                     if (hasLabel(currentNode.getNode(), s)) {
                        labels.add(s.name());
                        break;
                     }
               });
               break;
         }
         return labels;
      }

      private void updateTable(Set<Workspace.NodeCanvas.NeoNode> currentNodes) {
         app.model.graph().doInTransaction(new NeoModel.Committer() {
            @Override
            public void doAction(Transaction tx) throws Throwable {
               final LabelTableModel tableModel = new LabelTableModel(currentNodes, getLabelsToShow(currentNodes));
               SwingUtilities.invokeLater(() -> {
                  remove(centerPanel);
                  add(centerPanel = new JScrollPane(new LabelsTable(tableModel), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.CENTER);
                  revalidate();
                  repaint();
               });
            }

            @Override
            public void exception(Throwable throwable) {
               SwingUtil.showException(NodeDetailPanel.this, throwable);
            }
         });
      }
   }

   private final class LabelsTable extends JTable {

      LabelsTable(LabelTableModel model) {
         super(model);
         resizeColumnWidth(this);
         setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
         setRowSelectionAllowed(true);

         app.events.addNodeHighlightedListener(evt -> {
            final int index = model.getIndexOf((Workspace.NodeCanvas.NeoNode) evt.getNewValue());
            if (index == -1) return;
            setRowSelectionInterval(convertRowIndexToView(index), convertRowIndexToView(index));
            scrollRectToVisible(getCellRect(index, 0, true));
         });

         addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               SwingUtilities.invokeLater(() -> {
                  final Set<Workspace.NodeCanvas.NeoNode> selected = model.getValuesAt(new int[]{convertRowIndexToModel(getSelectedRow())});
                  for (Workspace.NodeCanvas.NeoNode pNode : workspace.nodeCanvas.getAllNodes()) {
                     if (selected.contains(pNode)) {
                        pNode.highlight();
                        workspace.nodeCanvas.getCamera().animateViewToCenterBounds(pNode.getGlobalFullBounds(), false, 500);
                     } else pNode.unhighlight();
                  }
               });
            }
         });
      }
   }

   private final class LabelTableModel extends AbstractTableModel {

      private final java.util.List<LabelTableModel.LabelElement> content = new ArrayList<>();
      private final java.util.List<String> columns = new ArrayList<>();

      LabelTableModel(Set<Workspace.NodeCanvas.NeoNode> nodes, Set<String> labels) {

         columns.add("node");
         labels.forEach(label -> columns.add(label));

         for (Workspace.NodeCanvas.NeoNode node : nodes)
            content.add(new LabelTableModel.LabelElement(node, columns));

         app.events.addNodesDeletedListener(evt -> {
            final Set<Long> nodeIds = (Set<Long>) evt.getNewValue();
            for (int i = content.size() - 1; i >= 0; i--) {
               if (nodeIds.contains(content.get(i).node.id()))
                  content.remove(content.get(i));
            }
            fireTableDataChanged();
         });
      }

      @Override
      public int getRowCount() {
         return content.size();
      }

      @Override
      public int getColumnCount() {
         return columns.size();
      }

      @Override
      public Object getValueAt(int rowIndex, int columnIndex) {
         return content.get(rowIndex).get(columns.get(columnIndex));
      }

      @Override
      public String getColumnName(int column) {
         return columns.get(column);
      }

      @Override
      public Class<?> getColumnClass(int columnIndex) {
         return columnIndex == 0 ? String.class : Boolean.class;
      }

      @Override
      public boolean isCellEditable(int rowIndex, int columnIndex) {
         return columnIndex > 0;
      }

      @Override
      public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
         app.model.graph().doInTransaction(new NeoModel.Committer() {
            @Override
            public void doAction(Transaction tx) throws Throwable {
               final LabelTableModel.LabelElement element = content.get(rowIndex);
               if (((Boolean) aValue)) element.addLabel(columns.get(columnIndex));
               else element.removeLabel(columns.get(columnIndex));
               SwingUtilities.invokeLater(() -> fireTableCellUpdated(rowIndex, columnIndex));
            }

            @Override
            public void exception(Throwable throwable) {
               SwingUtil.showException(NodeDetailPanel.this, throwable);
            }
         });
      }

      private int getIndexOf(Workspace.NodeCanvas.NeoNode node) {
         for (int i = 0; i < content.size(); i++)
            if (node.equals(content.get(i).node)) return i;
         return -1;
      }

      private Set<Workspace.NodeCanvas.NeoNode> getValuesAt(int[] selectedRows) {
         final Set<Workspace.NodeCanvas.NeoNode> values = new LinkedHashSet<>();
         for (int selectedRow : selectedRows)
            values.add(content.get(selectedRow).node);
         return values;
      }

      private final class LabelElement {
         private final Workspace.NodeCanvas.NeoNode node;
         private final Map<String, Object> values = new LinkedHashMap<>();

         LabelElement(Workspace.NodeCanvas.NeoNode node, java.util.List<String> labels) {
            this.node = node;
            values.put("node", NeoModel.getNameOrLabelFrom(node.getNode()));
            boolean first = true;
            for (String label : labels) {
               if (first) {
                  first = false;
                  continue;
               }
               values.put(label, hasLabel(node.getNode(), label) ? Boolean.TRUE : Boolean.FALSE);
            }
         }

         Object get(String column) {
            return values.get(column);
         }

         void removeLabel(String label) {
            node.getNode().removeLabel(org.neo4j.graphdb.Label.label(label));
            values.put(label, Boolean.FALSE);
         }

         void addLabel(String label) {
            node.getNode().addLabel(org.neo4j.graphdb.Label.label(label));
            values.put(label, Boolean.TRUE);
         }
      }
   }

   private final class PropertiesPanel extends JPanel {

      private AppMotif.PropertiesToShow propertiesToShow = app.model.getPropertiesFilter();
      private JScrollPane centerPanel;

      PropertiesPanel(Set<Workspace.NodeCanvas.NeoNode> currentNodes) {
         super(new BorderLayout());
         final JPanel filterPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

         final JRadioButton radAll = new JRadioButton(new AbstractAction("All") {
            @Override
            public void actionPerformed(ActionEvent e) {
               propertiesToShow = AppMotif.PropertiesToShow.all;
               app.model.setPropertiesFilter(propertiesToShow);
               updateTable(currentNodes);
            }
         });
         if (propertiesToShow.equals(AppMotif.PropertiesToShow.all)) radAll.setSelected(true);
         final JRadioButton radWithValues = new JRadioButton(new AbstractAction("Has values") {
            @Override
            public void actionPerformed(ActionEvent e) {
               propertiesToShow = AppMotif.PropertiesToShow.hasValue;
               app.model.setPropertiesFilter(propertiesToShow);
               updateTable(currentNodes);
            }
         });
         if (propertiesToShow.equals(AppMotif.PropertiesToShow.hasValue)) radWithValues.setSelected(true);
         final ButtonGroup radGroup = new ButtonGroup();
         radGroup.add(radAll);
         radGroup.add(radWithValues);
         filterPanel.add(new JLabel("Filter"));
         filterPanel.add(radAll);
         filterPanel.add(radWithValues);

         centerPanel = new JScrollPane(new PropertiesTable(new PropertyTableModel(currentNodes, getPropertiesToShow(currentNodes))), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

         add(filterPanel, BorderLayout.NORTH);
         add(centerPanel, BorderLayout.CENTER);
      }

      private Set<String> getPropertiesToShow(Set<Workspace.NodeCanvas.NeoNode> currentNodes) {
         final Set<String> properties = new TreeSet<>();
         switch (propertiesToShow) {
            case all:
               app.model.graph().getGraphDb().getAllPropertyKeys().forEach(properties::add);
               break;
            case hasValue:
               app.model.graph().getGraphDb().getAllPropertyKeys().forEach(s -> {
                  for (Workspace.NodeCanvas.NeoNode currentNode : currentNodes)
                     if (currentNode.getNode().hasProperty(s)) {
                        properties.add(s);
                        break;
                     }
               });
               break;
         }
         return properties;
      }

      private void updateTable(Set<Workspace.NodeCanvas.NeoNode> currentNodes) {
         app.model.graph().doInTransaction(new NeoModel.Committer() {
            @Override
            public void doAction(Transaction tx) throws Throwable {
               final PropertyTableModel tableModel = new PropertyTableModel(currentNodes, getPropertiesToShow(currentNodes));
               SwingUtilities.invokeLater(() -> {
                  remove(centerPanel);
                  add(centerPanel = new JScrollPane(new PropertiesTable(tableModel), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.CENTER);
                  revalidate();
                  repaint();
               });
            }

            @Override
            public void exception(Throwable throwable) {
               SwingUtil.showException(NodeDetailPanel.this, throwable);
            }
         });
      }
   }

   private final class PropertiesTable extends JTable {

      PropertiesTable(PropertyTableModel model) {
         super(model);
         resizeColumnWidth(this);
         setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
         setAutoCreateRowSorter(true);
         setRowSelectionAllowed(true);

         app.events.addNodeHighlightedListener(evt -> {
            final int index = model.getIndexOf((Workspace.NodeCanvas.NeoNode) evt.getNewValue());
            if (index == -1) return;
            setRowSelectionInterval(convertRowIndexToView(index), convertRowIndexToView(index));
            scrollRectToVisible(getCellRect(index, 0, true));
         });

         addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               SwingUtilities.invokeLater(() -> {
                  final Set<Workspace.NodeCanvas.NeoNode> selected = model.getValuesAt(new int[]{convertRowIndexToModel(getSelectedRow())});
                  for (Workspace.NodeCanvas.NeoNode pNode : workspace.nodeCanvas.getAllNodes()) {
                     if (selected.contains(pNode)) {
                        pNode.highlight();
                        workspace.nodeCanvas.getCamera().animateViewToCenterBounds(pNode.getGlobalFullBounds(), false, 500);
                     } else pNode.unhighlight();
                  }
               });
            }
         });
      }
   }

   private final class PropertyTableModel extends AbstractTableModel {

      private final java.util.List<PropertyTableModel.NodeElement> content = new ArrayList<>();
      private final java.util.List<String> columns = new ArrayList<>();
      private final int columnOffset = 1;

      PropertyTableModel(Set<Workspace.NodeCanvas.NeoNode> nodes, Set<String> propertiesToShow) {

         columns.addAll(propertiesToShow);

         for (Workspace.NodeCanvas.NeoNode node : nodes)
            content.add(new PropertyTableModel.NodeElement(node, columns));

         app.events.addNodesDeletedListener(evt -> {
            final Set<Long> nodesDeleted = (Set<Long>) evt.getNewValue();
            for (int i = content.size() - 1; i >= 0; i--)
               if (nodesDeleted.contains(content.get(i).node.id()))
                  content.remove(content.get(i));
            fireTableDataChanged();
         });
      }

      @Override
      public int getRowCount() {
         return content.size();
      }

      @Override
      public int getColumnCount() {
         return columns.size() + columnOffset;
      }

      @Override
      public Object getValueAt(int rowIndex, int columnIndex) {
         switch (columnIndex) {
            case 0:
               return content.get(rowIndex).name;
            default:
               return content.get(rowIndex).getValueAt(columns.get(columnIndex - columnOffset));
         }
      }

      @Override
      public String getColumnName(int column) {
         switch (column) {
            case 0:
               return "Node";
            default:
               return columns.get(column - columnOffset);
         }
      }

      @Override
      public Class<?> getColumnClass(int columnIndex) {
         return String.class; // consider changing based on domain-property-type
      }

      @Override
      public boolean isCellEditable(int rowIndex, int columnIndex) {
         return columnIndex >= columnOffset;
      }

      @Override
      public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
         app.model.graph().doInTransaction(new NeoModel.Committer() {
            @Override
            public void doAction(Transaction tx) throws Throwable {
               final PropertyTableModel.NodeElement element = content.get(rowIndex);
               final int index = columnIndex - columnOffset;
               if (aValue == null || aValue.toString().length() == 0)
                  element.removeProperty(columns.get(index));
               else
                  element.setProperty(columns.get(index), aValue);
               SwingUtilities.invokeLater(() -> {
                  fireTableCellUpdated(rowIndex, columnIndex);
                  app.events.fireNodeChanged(element.node.id(), columns.get(index), (aValue == null || aValue.toString().length() == 0) ? null : aValue);
               });
            }

            @Override
            public void exception(Throwable throwable) {
               SwingUtil.showException(NodeDetailPanel.this, throwable);
            }
         });
      }

      private int getIndexOf(Workspace.NodeCanvas.NeoNode node) {
         for (int i = 0; i < content.size(); i++)
            if (node.equals(content.get(i).node)) return i;
         return -1;
      }

      private Set<Workspace.NodeCanvas.NeoNode> getValuesAt(int[] selectedRows) {
         final Set<Workspace.NodeCanvas.NeoNode> values = new LinkedHashSet<>();
         for (int selectedRow : selectedRows)
            values.add(content.get(selectedRow).node);
         return values;
      }

      private final class NodeElement {
         private final Workspace.NodeCanvas.NeoNode node;
         private final Map<String, Object> values = new LinkedHashMap<>();
         private final String name;

         NodeElement(Workspace.NodeCanvas.NeoNode node, java.util.List<String> properties) {
            this.node = node;
            this.name = NeoModel.getNameOrLabelFrom(node.getNode());
            for (String property : properties)
               values.put(property, node.getNode().hasProperty(property) ? get(node.getNode(), property) : null);
         }

         Object getValueAt(String column) {
            return values.get(column);
         }

         void removeProperty(String property) {
            node.getNode().removeProperty(property);
            values.remove(property);
         }

         void setProperty(String property, Object value) {
            node.getNode().setProperty(property, value);
            values.put(property, value);
         }
      }
   }

   private final class DirectoryEditor extends JPanel {
      DirectoryEditor(Workspace.NodeCanvas.NeoNode node) {
         super(new BorderLayout());

         final JTextArea txtEditor = new JTextArea();
         txtEditor.setFont(new Font("Hack", Font.PLAIN, 10));
         txtEditor.setTabSize(3);
         txtEditor.setCaretPosition(0);

         final File getDir = ProjectMotif.getFile(node.getNode());

         final StringBuilder out = new StringBuilder();
         listDirectory(getDir, out);

         txtEditor.setText(out.toString().trim());

         add(new JScrollPane(txtEditor), BorderLayout.CENTER);
      }

      private void listDirectory(File getDir, StringBuilder out) {
         out.append("\n").append(getDir.getAbsolutePath()).append("\n");
         for (File file : getDir.listFiles()) {
            if (file.isFile()) out.append(file.getAbsolutePath()).append("\n");
            else listDirectory(file, out);
         }
      }
   }

   private final class TemplateEditor extends JPanel {
      TemplateEditor(Workspace.NodeCanvas.NeoNode templateNode) {
         super(new BorderLayout());

         final JTextArea txtEditor = new JTextArea();
         txtEditor.setText(get(templateNode.getNode(), TemplateMotif.Properties._text.name(), ""));
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

            String startText = get(templateNode.getNode(), TemplateMotif.Properties._text.name(), "");

            public void keyPressed(KeyEvent ke) {

               if (ke.getKeyCode() == KeyEvent.VK_ENTER && ke.getModifiers() == KeyEvent.CTRL_MASK) {
                  final int oldCaret = txtEditor.getCaretPosition();
                  txtEditor.setBorder(defaultBorder);
                  final String text = txtEditor.getText().trim();

                  final TemplateStatement parsed;
                  try {
                     final StringBuilder errors = new StringBuilder("Errors");
                     parsed = new TemplateFileParser().parse(delimiter, statementName, text, new STErrorListener() {
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

                  SwingUtilities.invokeLater(() -> app.model.graph().doInTransaction(new NeoModel.Committer() {
                     @Override
                     public void doAction(Transaction tx) throws Throwable {
                        final java.util.List<Node> existingParameters = new ArrayList<>();
                        outgoing(templateNode.getNode(), TemplateMotif.Relations.TEMPLATE_PARAMETER).forEach(relationship -> existingParameters.add(other(templateNode.getNode(), relationship)));

                        final java.util.List<TemplateParameter> parameters = parsed.getParameters();
                        for (TemplateParameter templateParameter : parameters) {
                           final String parameterType = getLabelFor(templateParameter.getDomainEntityType());

                           int size = existingParameters.size();
                           for (int i = existingParameters.size() - 1; i >= 0; i--) {
                              final Node existingParameter = existingParameters.get(i);
                              if (templateParameter.getPropertyName().equals(getString(existingParameter, AppMotif.Properties.name.name()))) {
                                 if (hasLabel(existingParameter, parameterType)) {
                                    if (templateParameter.getDomainEntityType().equals(TemplateEntities.KEYVALUELISTPROPERTY)) {
                                       System.out.println("todo: check deprecation here, if already in use");
                                       existingParameter.getPropertyKeys().forEach(s -> existingParameter.removeProperty("key_" + s));
                                       templateParameter.getKvNames().forEach(s -> existingParameter.setProperty("key_" + s, s));
                                    }
                                    existingParameters.remove(existingParameter);
                                    break;
                                 }
                              }
                           }

                           if (existingParameters.size() == size) {
                              final Node node = app.model.graph().newNode(parameterType);
                              node.setProperty(AppMotif.Properties.name.name(), templateParameter.getPropertyName());
                              if (templateParameter.getDomainEntityType().equals(TemplateEntities.KEYVALUELISTPROPERTY))
                                 templateParameter.getKvNames().forEach(s -> node.setProperty("key_" + s, s));
                              templateNode.getNode().createRelationshipTo(node, TemplateMotif.Relations.TEMPLATE_PARAMETER);
                           }
                        }

                        for (Node existingParameter : existingParameters) {
                           if (hasIncoming(existingParameter, TemplateMotif.Relations.PARAMETER)) {
                              existingParameter.setProperty(TemplateMotif.Properties._deprecated.name(), Boolean.TRUE);
                           } else {
                              incoming(existingParameter).forEach(Relationship::delete);
                              existingParameter.delete();
                           }
                        }

                        templateNode.getNode().setProperty(TemplateMotif.Properties._text.name(), txtEditor.getText().trim());
                        txtEditor.setText(parsed.getText().trim());
                        txtEditor.setCaretPosition(Math.min(text.length(), Math.max(0, oldCaret)));
                        startText = get(templateNode.getNode(), TemplateMotif.Properties._text.name(), "");
                        txtEditor.setBackground(uneditedColor);

                        // re-render all statements of this template
                        app.model.graph().findNodes(org.neo4j.graphdb.Label.label(getString(templateNode.getNode(), AppMotif.Properties.name.name()))).forEachRemaining(statementNode -> outgoing(statementNode, ProjectMotif.Relations.RENDERER).forEach(rendererRelation -> {
                           final Node dirNode = other(statementNode, rendererRelation);
                           final String content = render(statementNode, templateNode.getNode(), app.model.graph());
                           ProjectMotif.renderToFile(rendererRelation, statementNode, content, dirNode, app);
                        }));
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

         add(new JScrollPane(txtEditor), BorderLayout.CENTER);
      }
   }

   private final class TemplateRenderPanel extends JPanel {
      TemplateRenderPanel(Workspace.NodeCanvas.NeoNode statementNode, Node templateNode) {
         super(new BorderLayout());

         final JTextArea txtEditor = new JTextArea(25, 85);
         txtEditor.setFont(new Font("Hack", Font.PLAIN, 10));
         txtEditor.setTabSize(3);
         txtEditor.setEditable(false);
         txtEditor.setText(render(statementNode.getNode(), templateNode, app.model.graph()));
         txtEditor.setCaretPosition(0);

         txtEditor.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               if (SwingUtilities.isLeftMouseButton(e)) {
                  onLeftClick(txtEditor, statementNode, templateNode);
               } else if (SwingUtilities.isRightMouseButton(e)) {
                  onRightClick(txtEditor, statementNode, templateNode);
               }
            }
         });

         app.events.addNodeChangedListener(statementNode.id(), new AppEvents.EventsTransactionHandler(getClass(), TemplateRenderPanel.this, app.model) {
            @Override
            public void doAction(Transaction tx) throws Throwable {
               txtEditor.setText(render(statementNode.getNode(), templateNode, app.model.graph()));
               txtEditor.setCaretPosition(0);
            }
         });

         add(new JScrollPane(txtEditor), BorderLayout.CENTER);
      }

      private void onLeftClick(JTextArea txtEditor, Workspace.NodeCanvas.NeoNode statementNode, Node templateNode) {
         SwingUtilities.invokeLater(() -> app.model.graph().doInTransaction(new NeoModel.Committer() {
            @Override
            public void doAction(Transaction tx) throws Throwable {
               txtEditor.setText(render(statementNode.getNode(), templateNode, app.model.graph()));
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

      private void onRightClick(JTextArea txtEditor, Workspace.NodeCanvas.NeoNode statementNode, Node templateNode) {
         SwingUtil.toClipboard(txtEditor.getText());
      }
   }

   private final class RelationsPanel extends JPanel {

      private AppMotif.PropertiesToShow propertiesToShow = app.model.getPropertiesFilter();
      private JScrollPane centerPanel;

      RelationsPanel(final Set<Relationship> elements) {
         super(new BorderLayout());
         final JPanel filterPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
         filterPanel.add(new JLabel("Filter"));
         final ButtonGroup radGroup = new ButtonGroup();
         final JRadioButton radAll = new JRadioButton(new AbstractAction("All") {
            @Override
            public void actionPerformed(ActionEvent e) {
               propertiesToShow = AppMotif.PropertiesToShow.all;
               app.model.setPropertiesFilter(propertiesToShow);
               updateTable(elements);
            }
         });
         if (propertiesToShow.equals(AppMotif.PropertiesToShow.all)) radAll.setSelected(true);
         radGroup.add(radAll);
         filterPanel.add(radAll);

         final JRadioButton radWithValues = new JRadioButton(new AbstractAction("With values") {
            @Override
            public void actionPerformed(ActionEvent e) {
               propertiesToShow = AppMotif.PropertiesToShow.hasValue;
               app.model.setPropertiesFilter(propertiesToShow);
               updateTable(elements);
            }
         });
         if (propertiesToShow.equals(AppMotif.PropertiesToShow.hasValue)) radWithValues.setSelected(true);
         radGroup.add(radWithValues);
         filterPanel.add(radWithValues);

         add(filterPanel, BorderLayout.NORTH);
         add(centerPanel = new JScrollPane(new RelationsTable(new RelationTableModel(elements, getPropertiesToShow(elements))), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.CENTER);
      }

      private Set<String> getPropertiesToShow(final Set<Relationship> elements) {
         final Set<String> properties = new TreeSet<>();
         switch (propertiesToShow) {
            case all:
               app.model.graph().getGraphDb().getAllPropertyKeys().forEach(properties::add);
               break;
            case hasValue:
               app.model.graph().getGraphDb().getAllPropertyKeys().forEach(s -> {
                  for (Relationship element : elements) {
                     if (element.hasProperty(s)) {
                        properties.add(s);
                        break;
                     }
                  }
               });
               break;
         }
         return properties;
      }

      private void updateTable(Set<Relationship> elements) {
         app.model.graph().doInTransaction(new NeoModel.Committer() {
            @Override
            public void doAction(Transaction tx) throws Throwable {
               final RelationTableModel tableModel = new RelationTableModel(elements, getPropertiesToShow(elements));
               SwingUtilities.invokeLater(() -> {
                  remove(centerPanel);
                  add(centerPanel = new JScrollPane(new RelationsTable(tableModel), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.CENTER);
                  revalidate();
                  repaint();
               });
            }

            @Override
            public void exception(Throwable throwable) {
               SwingUtil.showException(NodeDetailPanel.this, throwable);
            }
         });
      }
   }

   private final class RelationsTable extends JTable {

      RelationsTable(RelationTableModel tableModel) {
         super(tableModel);
         resizeColumnWidth(this);
         setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
         setAutoCreateRowSorter(true);
         setRowSelectionAllowed(true);
         setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

         app.events.addNodeHighlightedListener(evt -> {
            final Set<Integer> indices = tableModel.getIndicesFor((Workspace.NodeCanvas.NeoNode) evt.getNewValue());
            final ListSelectionModel selectionModel = getSelectionModel();
            selectionModel.clearSelection();
            if (indices.isEmpty()) return;
            for (Integer index : indices)
               selectionModel.addSelectionInterval(convertRowIndexToView(index), convertRowIndexToView(index));
            scrollRectToVisible(getCellRect(indices.iterator().next(), 0, true));
         });

         app.events.addRelationsHighlightedListener(evt -> {
            final Set<Integer> indices = tableModel.getIndicesFor((Workspace.NodeCanvas.NeoRelationship) evt.getNewValue());
            final ListSelectionModel selectionModel = getSelectionModel();
            selectionModel.clearSelection();
            if (indices.isEmpty()) return;
            for (Integer index : indices)
               selectionModel.addSelectionInterval(convertRowIndexToView(index), convertRowIndexToView(index));
            scrollRectToVisible(getCellRect(indices.iterator().next(), 0, true));
         });

         addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent event) {
               if (SwingUtilities.isRightMouseButton(event))
                  SwingUtilities.invokeLater(() -> onRightClick(event));
               else if (SwingUtilities.isLeftMouseButton(event))
                  SwingUtilities.invokeLater(this::onLeftClick);
            }

            private void onRightClick(MouseEvent event) {

               int selectedRow[] = getSelectedRows();
               final Set<RelationTableModel.RelationElement> elements = new LinkedHashSet<>();
               for (int row : selectedRow) elements.add(tableModel.getValueAt(row));
               if (elements.isEmpty()) return;

               final JPopupMenu pop = new JPopupMenu();

               pop.add(new TransactionAction("Delete", app) {
                  @Override
                  protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                     if (SwingUtil.showConfirmDialog(app, "Delete relation" + (elements.size() == 1 ? "" : "s") + " ?")) {
                        for (RelationTableModel.RelationElement element : elements)
                           element.relationship.delete();
                     }
                  }
               });

               pop.show(RelationsTable.this, event.getX(), event.getY());
            }

            private void onLeftClick() {
               final Set<Long> selected = asSet(getSelectedRows());
               for (Workspace.NodeCanvas.NeoRelationship neoRelationship : workspace.nodeCanvas.getAllRelations()) {
                  if (selected.contains(neoRelationship.id())) {
                     neoRelationship.highlight();
                     workspace.nodeCanvas.getCamera().animateViewToCenterBounds(neoRelationship.path.getGlobalFullBounds(), false, 500);
                  } else neoRelationship.unhighlight();
               }
            }

            private Set<Long> asSet(int[] selectedRows) {
               final Set<Long> set = new LinkedHashSet<>();
               for (int row : selectedRows)
                  set.add(tableModel.content.get(convertRowIndexToModel(row)).id);
               return set;
            }
         });

         addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

               switch (e.getKeyCode()) {
                  case KeyEvent.VK_DELETE:
                     SwingUtilities.invokeLater(() -> {
                        int selectedRow[] = getSelectedRows();
                        final Set<RelationTableModel.RelationElement> elements = new LinkedHashSet<>();
                        for (int row : selectedRow) elements.add(tableModel.getValueAt(row));
                        if (elements.isEmpty()) return;

                        if (SwingUtil.showConfirmDialog(app, "Delete relation" + (elements.size() == 1 ? "" : "s") + " ?")) {
                           app.model.graph().doInTransaction(new NeoModel.Committer() {
                              @Override
                              public void doAction(Transaction tx) throws Throwable {
                                 for (RelationTableModel.RelationElement element : elements)
                                    element.relationship.delete();
                              }

                              @Override
                              public void exception(Throwable throwable) {
                                 SwingUtil.showException(app, throwable);
                              }
                           });
                        }
                     });
                     break;
               }
            }
         });
      }
   }

   private final class RelationTableModel extends AbstractTableModel {

      private final java.util.List<RelationTableModel.RelationElement> content = new ArrayList<>();
      private final java.util.List<String> columns = new ArrayList<>();
      private final int columnOffset = 3;

      private RelationTableModel(Set<Relationship> elements, Set<String> propertiesToShow) {

         columns.addAll(propertiesToShow);

         for (Relationship element : elements)
            content.add(new RelationElement(element, element.getStartNode(), columns));

         app.events.addNodesDeletedListener(evt -> {
            final Set<Long> nodesDeleted = (Set<Long>) evt.getNewValue();
            for (int i = content.size() - 1; i >= 0; i--)
               if (content.get(i).referencesNodes(nodesDeleted))
                  content.remove(content.get(i));
            fireTableDataChanged();
         });

         app.events.addRelationsDeletedListener(evt -> {
            final Set<Long> relations = (Set<Long>) evt.getNewValue();
            for (int i = content.size() - 1; i >= 0; i--)
               if (relations.contains(content.get(i).id))
                  content.remove(content.get(i));
            fireTableDataChanged();
         });
      }

      @Override
      public int getRowCount() {
         return content.size();
      }

      @Override
      public int getColumnCount() {
         return columns.size() + columnOffset;
      }

      @Override
      public Object getValueAt(int rowIndex, int columnIndex) {
         switch (columnIndex) {
            case 0:
               return content.get(rowIndex).sourceName;
            case 1:
               return content.get(rowIndex).relationtype;
            case 2:
               return content.get(rowIndex).destinationName;
            default:
               return content.get(rowIndex).getValueAt(columns.get(columnIndex - columnOffset));
         }
      }

      @Override
      public String getColumnName(int column) {
         switch (column) {
            case 0:
               return "Source \u2192";
            case 1:
               return "Relation";
            case 2:
               return "\u2192 Destination";
            default:
               return columns.get(column - columnOffset);
         }
      }

      @Override
      public Class<?> getColumnClass(int columnIndex) {
         return String.class;
      }

      @Override
      public boolean isCellEditable(int rowIndex, int columnIndex) {
         return columnIndex >= columnOffset;
      }

      @Override
      public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
         app.model.graph().doInTransaction(new NeoModel.Committer() {
            @Override
            public void doAction(Transaction tx) throws Throwable {
               final RelationTableModel.RelationElement relationElement = content.get(rowIndex);
               final int index = columnIndex - columnOffset;
               if (aValue == null || aValue.toString().length() == 0)
                  relationElement.removeProperty(columns.get(index));
               else
                  relationElement.setProperty(columns.get(index), aValue);
               SwingUtilities.invokeLater(() -> fireTableCellUpdated(rowIndex, index));
            }

            @Override
            public void exception(Throwable throwable) {
               SwingUtil.showException(NodeDetailPanel.this, throwable);
            }
         });
      }

      private Set<RelationTableModel.RelationElement> getValuesAt(int minSelectionIndex, int maxSelectionIndex) {
         final Set<RelationTableModel.RelationElement> values = new LinkedHashSet<>();
         for (int i = minSelectionIndex; i <= maxSelectionIndex; i++)
            values.add(content.get(i));
         return values;
      }

      private Set<Integer> getIndicesFor(Workspace.NodeCanvas.NeoNode neoNode) {
         final Set<Long> nodes = Collections.singleton(neoNode.id());
         final Set<Integer> indices = new LinkedHashSet<>();
         for (int i = 0; i < content.size(); i++) {
            if (content.get(i).referencesNodes(nodes)) indices.add(i);
         }
         return indices;
      }

      private Set<Integer> getIndicesFor(Workspace.NodeCanvas.NeoRelationship neoRelationship) {
         final Set<Integer> indices = new LinkedHashSet<>();
         for (int i = 0; i < content.size(); i++) {
            if (content.get(i).id == neoRelationship.id()) indices.add(i);
         }
         return indices;
      }

      RelationElement getValueAt(int row) {
         return content.get(row);
      }

      private final class RelationElement {
         private final long id;
         private final long sourceId;
         private final long destinationId;
         private final Relationship relationship;
         private final Map<String, Object> values = new LinkedHashMap<>();
         private final String sourceName;
         private final String relationtype;
         private final String destinationName;

         RelationElement(Relationship relationship, Node source, java.util.List<String> properties) {
            this.relationship = relationship;
            this.id = relationship.getId();
            this.sourceId = source.getId();
            this.sourceName = NeoModel.getNameOrLabelFrom(source);
            this.relationtype = relationship.getType().name();
            this.destinationId = other(source, relationship).getId();
            this.destinationName = NeoModel.getNameOrLabelFrom(other(source, relationship));
            for (String property : properties)
               values.put(property, relationship.hasProperty(property) ? get(relationship, property) : null);
         }

         Object getValueAt(String column) {
            return values.get(column);
         }

         void removeProperty(String property) {
            relationship.removeProperty(property);
            values.remove(property);
         }

         void setProperty(String property, Object value) {
            relationship.setProperty(property, value);
            values.put(property, value);
         }

         boolean referencesNodes(Set<Long> nodes) {
            return nodes.contains(sourceId) || nodes.contains(destinationId);
         }
      }
   }

   private static void resizeColumnWidth(JTable table) {
      final TableColumnModel columnModel = table.getColumnModel();
      for (int column = 0; column < table.getColumnCount(); column++) {
         int width = 60; // Min width
         for (int row = 0; row < table.getRowCount(); row++)
            width = Math.max(table.prepareRenderer(table.getCellRenderer(row, column), row, column).getPreferredSize().width + 1, width);
         if (width > 200) width = 200; // constraint on large-values
         columnModel.getColumn(column).setPreferredWidth(width);
      }
   }
}