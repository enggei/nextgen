package com.generator.editors.domain.editors;

import com.generator.generators.generatorDomain.GeneratorDomain;
import com.generator.editors.domain.*;
import com.generator.editors.graph.GraphEditor;
import com.generator.editors.graph.GraphEditorAction;
import com.generator.editors.graph.GraphNode;
import com.generator.util.SwingUtil;
import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.Transaction;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.*;

import static com.generator.editors.domain.NeoModel.uuidOf;

/**
 * goe on 6/9/15.
 */
public class NodePropertiesEditorPanel<E extends Enum<E>, R extends Enum<R>, G extends GraphNode<E>> extends JPanel {

	private final Set<EditorComponent> editorComponents = new LinkedHashSet<>();
	private final G graphNode;
	private final GraphEditor database;

	public NodePropertiesEditorPanel(final GraphEditor database, MetaNode<E> metaNode, G graphNode) {
		super(new BorderLayout());

		this.database = database;
		this.graphNode = graphNode;

		try (Transaction tx = database.getModel().beginTx()) {

			add(createNodePropertiesPanel(metaNode, graphNode), BorderLayout.NORTH);

			final JTabbedPane editors = new JTabbedPane();
			editors.add("Relations", new NodeRelationsEditor(graphNode, database));
			editors.add("Default values", new DefaultValuesEditor(graphNode.node(), database));
			add(editors, BorderLayout.CENTER);

			tx.success();
			tx.close();
		}
	}

	private JPanel createNodePropertiesPanel(MetaNode<E> metaNode, G graphNode) {
		final JPanel nodePropertiesPanel = new JPanel(new GridLayout(metaNode.properties().size(), 2));
		nodePropertiesPanel.setBorder(BorderFactory.createEmptyBorder(3, 5, 3, 5));

		// add type on meta-property (if file, then filechooser)
		for (final MetaProperty metaProperty : metaNode.properties()) {
			nodePropertiesPanel.add(new JLabel(metaProperty.getName()));
			final EditorComponent editorComponent = newEditorFor(metaProperty, graphNode);
			editorComponents.add(editorComponent);
			nodePropertiesPanel.add(editorComponent.editor());
			editorComponent.setValue(metaProperty.valueIn(this.graphNode.node()));
		}
		return nodePropertiesPanel;
	}

	private EditorComponent newEditorFor(final MetaProperty metaProperty, final G graphNode) {

		if (!metaProperty.getLegalValues().isEmpty()) {
			return new JComboBoxEditorComponent(metaProperty.getName(), metaProperty.getLegalValues()) {
				@Override
				public void commit() {
					final String value = delegate.getSelectedItem().toString().trim();
					metaProperty.setValue(graphNode.node(), value);
					graphNode.updated(metaProperty.getName(), value);
				}
			};

		} else if (metaProperty.getType() != null && (metaProperty.getType().toLowerCase().startsWith("file")))
			// default is String
			return new FileChooserComponent(BaseDomainVisitor.get(graphNode.node(), metaProperty.getName(), "")) {
				@Override
				public void commit() {
					final String value = txtPath.getText().trim();
					metaProperty.setValue(graphNode.node(), value);
					graphNode.updated(metaProperty.getName(), value);
				}
			};

		else if (metaProperty.getType() == null || (!metaProperty.getType().toLowerCase().startsWith("bool")))
			// default is String
			return new TextEditorComponent() {
				@Override
				public void commit() {
					final String value = delegate.getText().trim();
					metaProperty.setValue(graphNode.node(), value);
					graphNode.updated(metaProperty.getName(), value);
				}
			};

		// todo: add a Editor for reading value from another node ?
		return new CheckboxEditorComponent(metaProperty.getName()) {
			@Override
			public void commit() {
				final String value = delegate.isSelected() ? "true" : "false";
				metaProperty.setValue(graphNode.node(), value);
				graphNode.updated(metaProperty.getName(), value);
			}
		};
	}

	public void commit() {
		try (Transaction tx = database.getModel().beginTx()) {
			for (EditorComponent editorComponent : editorComponents) {
				editorComponent.commit();
			}
			tx.success();
			tx.close();
		}

		database.updateRelationships(graphNode);
	}

	private class NodeRelationsEditor extends JPanel {

		private final JTable table;
		private final NodeRelationTableModel tableModel;

		public NodeRelationsEditor(G node, final GraphEditor<E, R, G> graphEditor) {
			super(new BorderLayout());
			setPreferredSize(new Dimension(400, 360));

			add(new JScrollPane(this.table = new JTable(this.tableModel = new NodeRelationTableModel(node, graphEditor))), BorderLayout.CENTER);

			final CommandPanel commandPanel = new CommandPanel();
			commandPanel.addCommand(new GraphEditorAction("Del", graphEditor) {
				@Override
				public void doAction(Transaction tx) {

					final int selectedRow = table.getSelectedRow();
					if (selectedRow == -1) return;

					if (SwingUtil.confirm("Delete row " + selectedRow + " ?", table)) {
						SwingUtilities.invokeLater(new Runnable() {
							@Override
							public void run() {
								tableModel.deleteRow(selectedRow, graphEditor);
							}
						});
					}
				}
			});
			add(commandPanel, BorderLayout.NORTH);
		}

		private class NodeRelationTableModel extends AbstractTableModel {

			private final G node;
			private final String[] columns;
			private final java.util.List<Map<String, Object>> relations = new ArrayList<>();
			private final GraphEditor<E, R, G> editor;

			public NodeRelationTableModel(G node, GraphEditor<E, R, G> editor) {

				this.node = node;
				this.editor = editor;

				final Set<String> metacolumns = new LinkedHashSet<>();
				for (final Relationship relationship : node.node().getRelationships(Direction.OUTGOING)) {
					final MetaRelation<E, R> metaRelation = editor.getDomain().getMetaRelation(relationship);
					if (metaRelation == null) continue; // if relationship is not part of this domain, ignore it

					final Map<String, Object> row = new LinkedHashMap<>();

					// columns:
					row.put("Relation", relationship.getType().name());
					row.put("Target", NeoModel.getNameOrLabelFrom(relationship.getOtherNode(node.node())));

					final Set<String> isEditable = new TreeSet<>();
					final Map<String, MetaProperty> metaPropertyMap = new LinkedHashMap<>();
					for (MetaProperty metaProperty : metaRelation.properties()) {
						final String columnName = metaRelation.getName() + "." + metaProperty.getName();
						if (!metacolumns.contains(columnName)) {
							metacolumns.add(columnName);
						}
						isEditable.add(columnName);
						row.put(columnName, metaProperty.valueIn(relationship));
						metaPropertyMap.put(columnName, metaProperty);
					}

					// hidden values for row
					row.put("_relationship", relationship); // handle to relationship
					row.put("_editable", isEditable);   // map of columns which are editable, based on meta-relation
					row.put("_metaProperties", metaPropertyMap);   // map from column-names to meta-property

					relations.add(row);
				}

				columns = new String[metacolumns.size() + 2];
				int i = 0;
				columns[i++] = "Relation";
				columns[i++] = "Target";
				for (String metacolumn : metacolumns) {
					columns[i++] = metacolumn;
				}
			}

			@Override
			public int getRowCount() {
				return this.relations.size();
			}

			@Override
			public int getColumnCount() {
				return this.columns.length;
			}

			@Override
			public Object getValueAt(int rowIndex, int columnIndex) {
				return relations.get(rowIndex).get(columns[columnIndex]);
			}

			@Override
			public String getColumnName(int column) {
				return columns[column];
			}

			@Override
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return columnIndex >= 2 && ((Set<String>) this.relations.get(rowIndex).get("_editable")).contains(this.columns[columnIndex]);
			}

			@Override
			public void setValueAt(Object aValue, final int row, final int columnIndex) {

				final Map<String, Object> valueMap = this.relations.get(row);
				final Relationship relationship = (Relationship) valueMap.get("_relationship");
				final Map<String, MetaProperty> metaPropertyMap = (Map<String, MetaProperty>) valueMap.get("_metaProperties");

				try (Transaction tx = editor.getModel().beginTx()) {
					try {

						final MetaProperty metaProperty = metaPropertyMap.get(columns[columnIndex]);
						metaProperty.setValue(relationship, (String) aValue);
						tx.success();

						this.relations.get(row).put(this.columns[columnIndex], aValue);
						fireTableCellUpdated(row, columnIndex);

						SwingUtilities.invokeLater(new Runnable() {
							@Override
							public void run() {
								fireTableCellUpdated(row, columnIndex);
								editor.requestRepaint();
							}
						});

					} catch (Throwable throwable) {
						SwingUtil.showException(throwable, editor);
						tx.failure();
					}
				}
			}

			@Override
			public Class<?> getColumnClass(int columnIndex) {
				return String.class;
			}

			public void deleteRow(final int row, final GraphEditor<E, R, G> editor) {

				final Map<String, Object> valueMap = this.relations.get(row);
				final Relationship relationship = (Relationship) valueMap.get("_relationship");

				try (Transaction tx = editor.getModel().beginTx()) {
					try {
						node.removeOutgoing(relationship);
						relationship.delete();
						tx.success();

						this.relations.remove(row);

						SwingUtilities.invokeLater(new Runnable() {
							@Override
							public void run() {
								fireTableRowsDeleted(row, row);
								editor.requestRepaint();
							}
						});

					} catch (Throwable throwable) {
						SwingUtil.showException(throwable, editor);
						tx.failure();
					}
				}
			}
		}
	}

	private class DefaultValuesEditor extends JPanel {

		private final JTable table;
		private final DefaultValuesTableModel tableModel;

		public DefaultValuesEditor(final Node domainTermNode, final GraphEditor<E, R, G> graphEditor) {
			super(new BorderLayout());
			setPreferredSize(new Dimension(400, 360));

			add(new JScrollPane(this.table = new JTable(this.tableModel = new DefaultValuesTableModel(domainTermNode, graphEditor))), BorderLayout.CENTER);

			final CommandPanel commandPanel = new CommandPanel();
			commandPanel.addCommand(new GraphEditorAction("Add", graphEditor) {
				@Override
				public void doAction(Transaction tx) {
					tableModel.add(domainTermNode, graphEditor);
				}
			});
			commandPanel.addCommand(new GraphEditorAction("Del", graphEditor) {
				@Override
				public void doAction(Transaction tx) {

					final int selectedRow = table.getSelectedRow();
					if (selectedRow == -1) return;

					if (SwingUtil.confirm("Delete row " + selectedRow + " ?", table)) {
						SwingUtilities.invokeLater(new Runnable() {
							@Override
							public void run() {
								tableModel.deleteRow(selectedRow, graphEditor);
							}
						});
					}
				}
			});
			add(commandPanel, BorderLayout.NORTH);
		}


		private class DefaultValuesTableModel extends AbstractTableModel {

			private final String[] columns;
			private final java.util.List<Map<String, String>> values = new ArrayList<>();
			private final GraphEditor editor;

			public DefaultValuesTableModel(Node node, final GraphEditor editor) {
				final java.util.List<String> columnList = new ArrayList<>();
				this.editor = editor;

				columnList.add(NeoModel.TAG_UUID);
				// note: this is using GeneratorDomain.RELATIONS.FEATURE, to get the features
				for (Relationship relationship : node.getRelationships(Direction.OUTGOING, GeneratorDomain.RELATIONS.FEATURE)) {
					final Node featureNode = relationship.getOtherNode(node);
					final String featureName = featureNode.hasProperty("name") ? featureNode.getProperty("name").toString() : null;
					if (featureName == null) continue;
					columnList.add(featureName);
				}

				this.columns = columnList.toArray(new String[columnList.size()]);
				for (Relationship relationship : node.getRelationships(Direction.OUTGOING, MetaDomain.MetaRelations.DefaultValue)) {
					final Node defaultValueNode = relationship.getOtherNode(node);
					final Map<String, String> valueMap = new LinkedHashMap<>();
					for (String column : columns)
						valueMap.put(column, (defaultValueNode.hasProperty(column) ? defaultValueNode.getProperty(column).toString() : null));
					this.values.add(valueMap);
				}
			}

			@Override
			public int getRowCount() {
				return values.size();
			}

			@Override
			public int getColumnCount() {
				return columns.length;
			}

			@Override
			public String getColumnName(int column) {
				return columns[column];
			}

			@Override
			public Object getValueAt(int rowIndex, int columnIndex) {
				return values.get(rowIndex).get(columns[columnIndex]);
			}

			@Override
			public Class<?> getColumnClass(int columnIndex) {
				return String.class;
			}

			@Override
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return columnIndex > 0;
			}

			@Override
			public void setValueAt(Object aValue, final int rowIndex, final int columnIndex) {

				final String propertyName = columns[columnIndex];
				final String propertyValue = aValue == null || aValue.toString().trim().length() == 0 ? null : aValue.toString().trim();

				try (Transaction tx = editor.getModel().beginTx()) {
					try {

						final Map<String, String> valueMap = values.get(rowIndex);
						final Node valueNode = editor.getModel().getNode(UUID.fromString(valueMap.get(NeoModel.TAG_UUID)));
						valueNode.setProperty(propertyName, propertyValue);
						valueMap.put(propertyName, propertyValue);
						tx.success();

						SwingUtilities.invokeLater(new Runnable() {
							@Override
							public void run() {
								fireTableCellUpdated(rowIndex, columnIndex);
							}
						});

					} catch (Throwable throwable) {
						SwingUtil.showException(throwable, editor);
						tx.failure();
					}
				}
			}

			public void deleteRow(final int row, GraphEditor<E, R, G> editor) {

				final Map<String, String> valueMap = values.get(row);
				final UUID nodeUUID = UUID.fromString(valueMap.get(NeoModel.TAG_UUID));

				try (Transaction tx = editor.getModel().beginTx()) {
					try {

						final Node nodeToDelete = editor.getModel().getNode(nodeUUID);
						nodeToDelete.getSingleRelationship(MetaDomain.MetaRelations.DefaultValue, Direction.INCOMING).delete();
						nodeToDelete.delete();
						tx.success();

						values.remove(row);

						SwingUtilities.invokeLater(new Runnable() {
							@Override
							public void run() {
								fireTableRowsDeleted(row, row);
							}
						});

					} catch (Throwable throwable) {
						SwingUtil.showException(throwable, editor);
						tx.failure();
					}
				}
			}

			public void add(Node entityNode, GraphEditor<E, R, G> editor) {

				final UUID uuid = UUID.randomUUID();

				if (!entityNode.hasProperty("name"))
					throw new IllegalStateException("Node must have a name to add a default-value");

				// this is not a labelled-node, use native
				// error: do not use default value ? use Label in domain here:
				final Node newNode = editor.getModel().newNode(entityNode.getProperty("name").toString(), uuid);
				entityNode.createRelationshipTo(newNode, MetaDomain.MetaRelations.DefaultValue);

				final Map<String, String> valueMap = new LinkedHashMap<>();
				valueMap.put(NeoModel.TAG_UUID, uuidOf(newNode).toString());
				values.add(valueMap);

				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						fireTableRowsInserted(values.size() - 1, values.size() - 1);
					}
				});
			}
		}
	}
}
