package com.generator.app;

import com.generator.app.App.TransactionAction;
import com.generator.app.nodes.NeoNode;
import com.generator.app.nodes.NeoRelationship;
import com.generator.neo.NeoModel;
import com.generator.util.NeoUtil;
import com.generator.util.SwingUtil;
import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.Transaction;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;

import static com.generator.app.AppEvents.*;
import static com.generator.util.NeoUtil.*;

/**
 * Created 18.07.17.
 */
class NodeDetailPanel extends JPanel {

   private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(NodeDetailPanel.class);

   private App app;
   private Workspace workspace;
   private final JTabbedPane content = new JTabbedPane();
   private LabelsPanel labelsPanel;
   private PropertiesPanel propertiesPanel;
   private RelationsPanel nodeRelationsPanel;
   private RelationsPanel relationsPanel;

   private final Map<Long, JComponent> pluginPanels = new ConcurrentHashMap<>();

   NodeDetailPanel(App app, Workspace workspace) {
      super(new BorderLayout());
      this.app = app;
      this.workspace = workspace;

      add(content, BorderLayout.CENTER);

      app.events.addPropertyChangeListener(GRAPH_NEW, new AppEvents.TransactionalPropertyChangeListener(getClass(), NodeDetailPanel.this, app) {
         @Override
         protected void propertyChange(Object oldValue, Object newValue) {
            updatePanel();
         }
      });

      app.events.addPropertyChangeListener(AppEvents.NODES_CLOSED, new AppEvents.TransactionalPropertyChangeListener(getClass(), NodeDetailPanel.this, app) {
         @Override
         protected void propertyChange(Object oldValue, Object newValue) {
            updatePanel();
         }
      });

      app.events.addPropertyChangeListener(NODES_SELECTED, new AppEvents.TransactionalPropertyChangeListener(getClass(), NodeDetailPanel.this, app) {
         @Override
         protected void propertyChange(Object oldValue, Object newValue) {
            updatePanel();
         }
      });

      app.events.addPropertyChangeListener(NODE_HIGHLIGHTED, evt -> {
         labelsPanel.onNodeHighlighted((NeoNode) evt.getNewValue());
         propertiesPanel.onNodeHighlighted((NeoNode) evt.getNewValue());
         nodeRelationsPanel.onNodeHighlighted((NeoNode) evt.getNewValue());
         if (relationsPanel != null)
            relationsPanel.onNodeHighlighted((NeoNode) evt.getNewValue());
      });

      app.events.addPropertyChangeListener(NODES_DELETED, evt -> {
         final Set<Long> nodeIds = (Set<Long>) evt.getNewValue();
         labelsPanel.onNodesDeleted(nodeIds);
         propertiesPanel.onNodesDeleted(nodeIds);
         nodeRelationsPanel.onNodesDeleted(nodeIds);

         // todo: remove from content-panel
         for (Long nodeId : nodeIds) {
            if (pluginPanels.containsKey(nodeId)) {
               SwingUtilities.invokeLater(new Runnable() {
                  @Override
                  public void run() {
                     log.info("removing plugin panel for node " + nodeId);
                     content.remove(pluginPanels.remove(nodeId));
                  }
               });
            }
         }
      });

      app.events.addPropertyChangeListener(RELATIONS_SELECTED, new AppEvents.TransactionalPropertyChangeListener(getClass(), NodeDetailPanel.this, app) {
         @Override
         protected void propertyChange(Object oldValue, Object newValue) {
            updatePanel();
         }
      });

      app.events.addPropertyChangeListener(RELATIONS_DELETED, evt -> {
         if (relationsPanel != null)
            relationsPanel.onRelationsDeleted((Set<Long>) evt.getNewValue());
      });

      app.events.addPropertyChangeListener(RELATION_HIGHLIGHTED, evt -> {
         nodeRelationsPanel.onRelationsHighlighted((NeoRelationship) evt.getNewValue());
         if (relationsPanel != null)
            relationsPanel.onRelationsHighlighted((NeoRelationship) evt.getNewValue());
      });
   }

   private void updatePanel() {

      final int selectedIndex = content.getSelectedIndex();

      content.removeAll();
      pluginPanels.clear();

      final Set<NeoNode> currentNodes = app.workspace.nodeCanvas.getSelectedNodes();
      final Set<NeoRelationship> currentRelations = workspace.nodeCanvas.getSelectedRelations();

      int maxIndex = 0;
      if (!currentNodes.isEmpty()) {
         content.add("Labels", labelsPanel = new LabelsPanel(currentNodes));
         content.add("Properties", propertiesPanel = new PropertiesPanel(currentNodes));

         final Set<Relationship> elements = new LinkedHashSet<>();
         for (NeoNode node : currentNodes)
            node.getNode().getRelationships(Direction.OUTGOING).forEach(elements::add);
         content.add("Node-Relations", nodeRelationsPanel = new RelationsPanel(elements));
         maxIndex += 3;
      }

      if (!currentRelations.isEmpty()) {
         final Set<Relationship> elements = new LinkedHashSet<>();
         for (NeoRelationship currentRelation : currentRelations)
            elements.add(currentRelation.getRelationship());
         content.add("Relations", relationsPanel = new RelationsPanel(elements));
         maxIndex += 1;
      }

      if (currentNodes.size() < 20) {
         for (NeoNode currentNode : currentNodes) {
            final AtomicBoolean editorFound = new AtomicBoolean(false);
            for (Plugin plugin : app.plugins) {
               final JComponent editorComponent = plugin.getEditorFor(currentNode);
               if (editorComponent != null) {
                  editorFound.set(true);
                  content.add(getNameOrLabelFrom(currentNode.getNode()), editorComponent);
                  pluginPanels.put(currentNode.id(), editorComponent);
               }
            }

            if (!editorFound.get()) {
               final JComponent editorComponent = new DefaultNodeEditor(currentNode);
               content.add(getNameOrLabelFrom(currentNode.getNode()), editorComponent);
               pluginPanels.put(currentNode.id(), editorComponent);
            }
         }
      }

      // try to select the tab that was open,
      // or show the last-tab (usually the single node selected, and therefore the one user wants to see)
      if (selectedIndex > -1 && content.getTabCount() > selectedIndex) {
         content.setSelectedIndex(selectedIndex);
      } else {
         if (content.getTabCount() > maxIndex)
            content.setSelectedIndex(content.getTabCount() - 1);
      }

      SwingUtilities.invokeLater(() -> {
         content.revalidate();
         content.repaint();
      });
   }

   private final class DefaultNodeEditor extends JPanel {

      private final JTextArea txtEditor = SwingUtil.newTextArea();

      DefaultNodeEditor(NeoNode currentNode) {
         super(new BorderLayout());

         txtEditor.setText(nodeInfo(currentNode.getNode()));
         txtEditor.setCaretPosition(0);

         add(new JScrollPane(txtEditor), BorderLayout.CENTER);
      }

      private String nodeInfo(Node node) {
         final StringBuilder out = new StringBuilder();

         out.append(getNameAndLabelsFrom(node)).append("\n");

         out.append("\nPROPERTIES:");
         for (String propertyKey : node.getPropertyKeys()) {
            out.append("\n\t").append(propertyKey).append(" : ").append("password".equals(propertyKey.toLowerCase()) ? "[PASSWORD]" : node.getProperty(propertyKey));
         }

         out.append("\n\nOUTGOING:");
         NeoUtil.outgoing(node).forEach(relationship -> out.append("\n\t--> ").append(relationshipInfo(relationship)).append(" --> ").append(getNameAndLabelsFrom(other(node, relationship))));

         out.append("\n\nINCOMING:");
         NeoUtil.incoming(node).forEach(relationship -> out.append("\n\t <-- ").append(relationshipInfo(relationship)).append(" <-- ").append(getNameAndLabelsFrom(other(node, relationship))));


         return out.toString();
      }

      private String relationshipInfo(Relationship relationship) {
         final StringBuilder out = new StringBuilder(relationship.getType().name());
         boolean first = true;
         for (String propertyKey : relationship.getPropertyKeys()) {
            if (first) out.append(" [");
            out.append(" ").append(propertyKey).append(" : ").append(relationship.getProperty(propertyKey));
            first = false;
         }
         if (!first) out.append("]");
         return out.toString();
      }
   }

   private final class LabelsPanel extends JPanel {

      private AppMotif.PropertiesToShow propertiesToShow = app.model.getPropertiesFilter();
      private JScrollPane centerPanel;
      private LabelsTable table;

      LabelsPanel(Set<NeoNode> currentNodes) {
         super(new BorderLayout());
         final JPanel filterPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

         final JRadioButton radAll = new JRadioButton(new AbstractAction("All") {
            @Override
            public void actionPerformed(ActionEvent e) {
               propertiesToShow = AppMotif.PropertiesToShow.all;
               app.model.setPropertiesFilter(propertiesToShow);
               app.model.setPropertiesFilter(propertiesToShow);
               app.model.setProperties("properties.filter", propertiesToShow.name());
               updateTable(currentNodes);
            }
         });
         if (propertiesToShow.equals(AppMotif.PropertiesToShow.all)) radAll.setSelected(true);
         final JRadioButton radWithValues = new JRadioButton(new AbstractAction("With values") {
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

         centerPanel = new JScrollPane(table = new LabelsTable(new LabelTableModel(currentNodes, getLabelsToShow(currentNodes))), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

         add(filterPanel, BorderLayout.NORTH);
         add(centerPanel, BorderLayout.CENTER);
      }

      private Set<String> getLabelsToShow(Set<NeoNode> currentNodes) {
         final Set<String> labels = new TreeSet<>();
         switch (propertiesToShow) {
            case all:
               app.model.graph().getAllLabelsInUse().forEach(label -> labels.add(label.name()));
               break;
            case hasValue:
               app.model.graph().getAllLabelsInUse().forEach(s -> {
                  for (NeoNode currentNode : currentNodes)
                     if (hasLabel(currentNode.getNode(), s)) {
                        labels.add(s.name());
                        break;
                     }
               });
               break;
         }
         return labels;
      }

      private void updateTable(Set<NeoNode> currentNodes) {
         app.model.graph().doInTransaction(new NeoModel.Committer() {
            @Override
            public void doAction(Transaction tx) throws Throwable {
               final LabelTableModel tableModel = new LabelTableModel(currentNodes, getLabelsToShow(currentNodes));
               SwingUtilities.invokeLater(() -> {
                  remove(centerPanel);
                  add(centerPanel = new JScrollPane(table = new LabelsTable(tableModel), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.CENTER);
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

      void onNodeHighlighted(NeoNode node) {
         table.onNodeHighlighted(node);
      }

      void onNodesDeleted(Set<Long> nodeIds) {
         table.onNodesDeleted(nodeIds);
      }
   }

   private final class LabelsTable extends JTable {

      LabelsTable(LabelTableModel model) {
         super(model);
         resizeColumnWidth(this);
         setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
         setRowSelectionAllowed(true);

         addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               SwingUtilities.invokeLater(() -> {
                  final Set<NeoNode> selected = model.getValuesAt(new int[]{convertRowIndexToModel(getSelectedRow())});
                  for (NeoNode pNode : workspace.nodeCanvas.getAllNodes()) {
                     if (selected.contains(pNode)) {
                        pNode.highlight();
                        workspace.nodeCanvas.getCamera().animateViewToCenterBounds(pNode.getGlobalFullBounds(), false, 500);
                     } else pNode.unhighlight();
                  }
               });
            }
         });
      }

      void onNodeHighlighted(NeoNode node) {
         final int index = ((LabelTableModel) getModel()).getIndexOf(node);
         if (index == -1) return;
         setRowSelectionInterval(convertRowIndexToView(index), convertRowIndexToView(index));
         scrollRectToVisible(getCellRect(index, 0, true));
      }

      void onNodesDeleted(Set<Long> nodeIds) {
         ((LabelTableModel) getModel()).onNodesDeleted(nodeIds);
      }
   }

   private final class LabelTableModel extends AbstractTableModel {

      private final java.util.List<LabelTableModel.LabelElement> content = new ArrayList<>();
      private final java.util.List<String> columns = new ArrayList<>();

      LabelTableModel(Set<NeoNode> nodes, Set<String> labels) {

         columns.add("node");
         labels.forEach(label -> columns.add(label));

         for (NeoNode node : nodes)
            content.add(new LabelTableModel.LabelElement(node, columns));
      }

      void onNodesDeleted(Set<Long> nodeIds) {
         for (int i = content.size() - 1; i >= 0; i--) {
            if (nodeIds.contains(content.get(i).node.id()))
               content.remove(content.get(i));
         }
         fireTableDataChanged();
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
               app.events.firePropertyChange(NODE_CHANGED + element.node.id());
               SwingUtilities.invokeLater(() -> fireTableCellUpdated(rowIndex, columnIndex));
            }

            @Override
            public void exception(Throwable throwable) {
               SwingUtil.showException(NodeDetailPanel.this, throwable);
            }
         });
      }

      private int getIndexOf(NeoNode node) {
         for (int i = 0; i < content.size(); i++)
            if (node.equals(content.get(i).node)) return i;
         return -1;
      }

      private Set<NeoNode> getValuesAt(int[] selectedRows) {
         final Set<NeoNode> values = new LinkedHashSet<>();
         for (int selectedRow : selectedRows)
            values.add(content.get(selectedRow).node);
         return values;
      }

      private final class LabelElement {
         private final NeoNode node;
         private final Map<String, Object> values = new LinkedHashMap<>();

         LabelElement(NeoNode node, java.util.List<String> labels) {
            this.node = node;
            values.put("node", getNameOrLabelFrom(node.getNode()));
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
      private PropertiesTable table;

      PropertiesPanel(Set<NeoNode> currentNodes) {
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
         final JRadioButton radWithValues = new JRadioButton(new AbstractAction("With values") {
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

         centerPanel = new JScrollPane(table = new PropertiesTable(new PropertyTableModel(currentNodes, getPropertiesToShow(currentNodes))), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

         add(filterPanel, BorderLayout.NORTH);
         add(centerPanel, BorderLayout.CENTER);
      }

      private Set<String> getPropertiesToShow(Set<NeoNode> currentNodes) {
         final Set<String> properties = new TreeSet<>();
         switch (propertiesToShow) {
            case all:
               app.model.graph().getAllPropertyKeys().forEach(properties::add);
               break;
            case hasValue:
               app.model.graph().getAllPropertyKeys().forEach(s -> {
                  for (NeoNode currentNode : currentNodes)
                     if (currentNode.getNode().hasProperty(s)) {
                        properties.add(s);
                        break;
                     }
               });
               break;
         }
         return properties;
      }

      private void updateTable(Set<NeoNode> currentNodes) {
         app.model.graph().doInTransaction(new NeoModel.Committer() {
            @Override
            public void doAction(Transaction tx) throws Throwable {
               final PropertyTableModel tableModel = new PropertyTableModel(currentNodes, getPropertiesToShow(currentNodes));
               SwingUtilities.invokeLater(() -> {
                  remove(centerPanel);
                  add(centerPanel = new JScrollPane(table = new PropertiesTable(tableModel), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.CENTER);
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

      void onNodeHighlighted(NeoNode node) {
         table.onNodeHighlighted(node);
      }

      void onNodesDeleted(Set<Long> nodeIds) {
         table.onNodesDeleted(nodeIds);
      }
   }

   private final class PropertiesTable extends JTable {

      PropertiesTable(PropertyTableModel model) {
         super(model);
         resizeColumnWidth(this);
         setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
         setAutoCreateRowSorter(true);
         setRowSelectionAllowed(true);

         addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               SwingUtilities.invokeLater(() -> {
                  final Set<NeoNode> selected = model.getValuesAt(new int[]{convertRowIndexToModel(getSelectedRow())});
                  for (NeoNode pNode : workspace.nodeCanvas.getAllNodes()) {
                     if (selected.contains(pNode)) {
                        pNode.highlight();
                        workspace.nodeCanvas.getCamera().animateViewToCenterBounds(pNode.getGlobalFullBounds(), false, 500);
                     } else pNode.unhighlight();
                  }
               });
            }
         });
      }

      void onNodeHighlighted(NeoNode node) {
         final int index = ((PropertyTableModel) getModel()).getIndexOf(node);
         if (index == -1) return;
         setRowSelectionInterval(convertRowIndexToView(index), convertRowIndexToView(index));
         scrollRectToVisible(getCellRect(index, 0, true));
      }

      void onNodesDeleted(Set<Long> nodesDeleted) {
         ((PropertyTableModel) getModel()).onNodesDeleted(nodesDeleted);
      }
   }

   private final class PropertyTableModel extends AbstractTableModel {

      private final java.util.List<PropertyTableModel.NodeElement> content = new ArrayList<>();
      private final java.util.List<String> columns = new ArrayList<>();
      private final int columnOffset = 1;

      PropertyTableModel(Set<NeoNode> nodes, Set<String> propertiesToShow) {

         columns.addAll(propertiesToShow);

         for (NeoNode node : nodes)
            content.add(new PropertyTableModel.NodeElement(node, columns));
      }

      void onNodesDeleted(Set<Long> nodesDeleted) {
         for (int i = content.size() - 1; i >= 0; i--)
            if (nodesDeleted.contains(content.get(i).node.id()))
               content.remove(content.get(i));
         fireTableDataChanged();
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
                  app.events.firePropertyChange(NODE_CHANGED + element.node.id(), columns.get(index), (aValue == null || aValue.toString().length() == 0) ? null : aValue);
               });
            }

            @Override
            public void exception(Throwable throwable) {
               SwingUtil.showException(NodeDetailPanel.this, throwable);
            }
         });
      }

      private int getIndexOf(NeoNode node) {
         for (int i = 0; i < content.size(); i++)
            if (node.equals(content.get(i).node)) return i;
         return -1;
      }

      private Set<NeoNode> getValuesAt(int[] selectedRows) {
         final Set<NeoNode> values = new LinkedHashSet<>();
         for (int selectedRow : selectedRows)
            values.add(content.get(selectedRow).node);
         return values;
      }

      private final class NodeElement {
         private final NeoNode node;
         private final Map<String, Object> values = new LinkedHashMap<>();
         private final String name;

         NodeElement(NeoNode node, java.util.List<String> properties) {
            this.node = node;
            this.name = getNameOrLabelFrom(node.getNode());
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

   private final class RelationsPanel extends JPanel {

      private AppMotif.PropertiesToShow propertiesToShow = app.model.getPropertiesFilter();
      private JScrollPane centerPanel;
      private RelationsTable table;

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
         add(centerPanel = new JScrollPane(table = new RelationsTable(new RelationTableModel(elements, getPropertiesToShow(elements))), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.CENTER);
      }

      private Set<String> getPropertiesToShow(final Set<Relationship> elements) {
         final Set<String> properties = new TreeSet<>();
         switch (propertiesToShow) {
            case all:
               app.model.graph().getAllPropertyKeys().forEach(properties::add);
               break;
            case hasValue:
               app.model.graph().getAllPropertyKeys().forEach(s -> {
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
                  add(centerPanel = new JScrollPane(table = new RelationsTable(tableModel), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.CENTER);
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

      void onNodeHighlighted(NeoNode node) {
         table.onNodeHighlighted(node);
      }

      void onRelationsHighlighted(NeoRelationship relationship) {
         table.onRelationsHighlighted(relationship);
      }

      void onNodesDeleted(Set<Long> nodes) {
         table.onNodesDeleted(nodes);
      }

      void onRelationsDeleted(Set<Long> relations) {
         table.onRelationsDeleted(relations);
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

         addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent event) {
               if (SwingUtilities.isRightMouseButton(event))
                  SwingUtilities.invokeLater(() -> onRightClick(event));
               else if (SwingUtilities.isLeftMouseButton(event))
                  SwingUtilities.invokeLater(() -> onLeftClick(event));
            }

            private void onRightClick(MouseEvent event) {

               int selectedRow[] = getSelectedRows();
               final Set<RelationTableModel.RelationElement> elements = new LinkedHashSet<>();
               for (int row : selectedRow) elements.add(tableModel.getValueAt(convertRowIndexToModel(row)));
               if (elements.isEmpty()) return;

               final JPopupMenu pop = new JPopupMenu();

               pop.add(new TransactionAction("Open nodes", app) {
                  @Override
                  protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                     final Set<AppEvents.NodeLoadEvent> nodes = new LinkedHashSet<>();
                     for (RelationTableModel.RelationElement element : elements)
                        nodes.add(new NodeLoadEvent(element.relationship.getEndNode()));
                     app.events.firePropertyChange(NODE_LOAD, nodes);
                  }
               });

               pop.add(new TransactionAction("Delete", app) {
                  @Override
                  protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                     if (SwingUtil.showConfirmDialog(app, "Delete relation" + (elements.size() == 1 ? "" : "s") + " ?")) {
                        final Set<Relationship> relations = new LinkedHashSet<>();
                        for (RelationTableModel.RelationElement element : elements)
                           relations.add(element.relationship);
                        app.model.deleteRelations(relations);
                     }
                  }
               });

               pop.show(RelationsTable.this, event.getX(), event.getY());
            }

            private void onLeftClick(MouseEvent event) {
               final Set<Long> selected = asSet(getSelectedRows());
               for (NeoRelationship neoRelationship : workspace.nodeCanvas.getAllRelations()) {
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
                        for (int row : selectedRow) elements.add(tableModel.getValueAt(convertRowIndexToModel(row)));
                        if (elements.isEmpty()) return;

                        if (SwingUtil.showConfirmDialog(app, "Delete relation" + (elements.size() == 1 ? "" : "s") + " ?")) {
                           app.model.graph().doInTransaction(new NeoModel.Committer() {
                              @Override
                              public void doAction(Transaction tx) throws Throwable {
                                 final Set<Relationship> relations = new LinkedHashSet<>();
                                 for (RelationTableModel.RelationElement element : elements)
                                    relations.add(element.relationship);
                                 app.model.deleteRelations(relations);
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

      private void onRelationsHighlighted(NeoRelationship node) {
         final Set<Integer> indices = ((RelationTableModel) getModel()).getIndicesFor(node);
         final ListSelectionModel selectionModel = getSelectionModel();
         selectionModel.clearSelection();
         if (indices.isEmpty()) return;
         for (Integer index : indices)
            selectionModel.addSelectionInterval(convertRowIndexToView(index), convertRowIndexToView(index));
         scrollRectToVisible(getCellRect(indices.iterator().next(), 0, true));
      }

      private void onNodeHighlighted(NeoNode node) {
         final Set<Integer> indices = ((RelationTableModel) getModel()).getIndicesFor(node);
         final ListSelectionModel selectionModel = getSelectionModel();
         selectionModel.clearSelection();
         if (indices.isEmpty()) return;
         for (Integer index : indices)
            selectionModel.addSelectionInterval(convertRowIndexToView(index), convertRowIndexToView(index));
         scrollRectToVisible(getCellRect(indices.iterator().next(), 0, true));
      }

      void onRelationsDeleted(Set<Long> relations) {
         ((RelationTableModel) getModel()).onRelationsDeleted(relations);
      }

      void onNodesDeleted(Set<Long> nodes) {
         ((RelationTableModel) getModel()).onNodesDeleted(nodes);
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
      }

      void onRelationsDeleted(Set<Long> relations) {
         for (int i = content.size() - 1; i >= 0; i--)
            if (relations.contains(content.get(i).id))
               content.remove(content.get(i));
         fireTableDataChanged();
      }

      void onNodesDeleted(Set<Long> nodesDeleted) {
         for (int i = content.size() - 1; i >= 0; i--)
            if (content.get(i).referencesNodes(nodesDeleted))
               content.remove(content.get(i));
         fireTableDataChanged();
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

      private Set<Integer> getIndicesFor(NeoNode neoNode) {
         final Set<Long> nodes = Collections.singleton(neoNode.id());
         final Set<Integer> indices = new LinkedHashSet<>();
         for (int i = 0; i < content.size(); i++) {
            if (content.get(i).referencesNodes(nodes)) indices.add(i);
         }
         return indices;
      }

      private Set<Integer> getIndicesFor(NeoRelationship neoRelationship) {
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
            this.sourceName = getNameOrLabelFrom(source);
            this.relationtype = relationship.getType().name();
            this.destinationId = other(source, relationship).getId();
            this.destinationName = getNameOrLabelFrom(other(source, relationship));
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
