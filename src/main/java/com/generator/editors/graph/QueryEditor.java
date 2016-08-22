package com.generator.editors.graph;

import com.generator.editors.domain.MetaDomain;
import com.generator.editors.domain.MetaNode;
import com.generator.editors.domain.MetaRelation;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Result;
import org.neo4j.graphdb.Transaction;
import org.neo4j.helpers.collection.Iterators;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * User: goe
 * Date: 30.04.14
 */
public class QueryEditor<E extends Enum<E>, R extends Enum<R>> extends JFrame {

	public QueryEditor(final GraphEditor<E, R, ?> graphEditor) {
		super("Query");
		setPreferredSize(new Dimension(1024, 768));
		setLayout(new BorderLayout());

		final DomainListModel queryModel = new DomainListModel(graphEditor.getDomain());
		final JList<String> lstQueries = new JList<>(queryModel);
		final JTextArea txtQuery = new JTextArea(10, 50);
		final JTextArea txtResult = new JTextArea(10, 50);

		graphEditor.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				graphEditor.addKeyListener(graphEditor);
			}

			@Override
			public void focusLost(FocusEvent e) {
				graphEditor.removeKeyListener(graphEditor);
			}
		});
		graphEditor.addKeyListener(graphEditor);

		final AbstractAction queryAction = newQueryAction(txtQuery, txtResult, graphEditor);

		lstQueries.addListSelectionListener(e -> {
			if (e.getValueIsAdjusting()) return;
			txtQuery.setText(queryModel.getElementAt(lstQueries.getSelectedIndex()));
			queryAction.actionPerformed(null);
		});

		txtQuery.getActionMap().put(txtQuery.getInputMap(JComponent.WHEN_FOCUSED).get(KeyStroke.getKeyStroke("ENTER")), queryAction);

		final JScrollPane scrQueries = new JScrollPane(lstQueries);
		scrQueries.setMaximumSize(new Dimension(200, 600));

		final JScrollPane scrResult = new JScrollPane(txtResult);
		scrResult.setMaximumSize(new Dimension(800, 600));

		final JScrollPane scrGraph = new JScrollPane(graphEditor);
		add(txtQuery, BorderLayout.NORTH);
		add(scrQueries, BorderLayout.WEST);

		final JTabbedPane centerPanel = new JTabbedPane();
		centerPanel.add("Graph", scrGraph);
		centerPanel.add("Text", scrResult);
		add(centerPanel, BorderLayout.CENTER);
	}

	private AbstractAction newQueryAction(final JTextArea txtQuery, final JTextArea txtResult, final GraphEditor editor) {
		return new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(() -> {
					txtQuery.setEditable(false);
					txtQuery.setBackground(Color.LIGHT_GRAY);
					txtQuery.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

					try (Transaction tx = editor.getModel().beginTx()) {

						final Result res = editor.getModel().query(txtQuery.getText().trim());
						if (res.columns().contains("n")) {
							final Iterator<Node> n_column = res.columnAs("n");
							for (Node node : Iterators.asIterable(n_column))
								editor.getOrAdd(node);
						} else if (res.columns().contains("s") && res.columns().contains("t")) {

							final Iterator<Node> source = res.columnAs("s");
							for (Node node : Iterators.asIterable(source)) editor.getOrAdd(node);

							final Iterator<Node> target = res.columnAs("t");
							for (Node node : Iterators.asIterable(target)) editor.getOrAdd(node);

						} else {
							txtResult.setText(res.resultAsString());
						}

						tx.success();

						SwingUtilities.invokeLater(() -> {
							editor.requestFocusInWindow();
							repaint();
						});

					} catch (Exception ex) {
						txtResult.setText(ex.getLocalizedMessage());
					}

					txtQuery.setEditable(true);
					txtQuery.setBackground(Color.WHITE);
					txtQuery.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				});
			}
		};
	}

	private class DomainListModel extends AbstractListModel<String> {

		private final java.util.List<String> content = new ArrayList<>();

		DomainListModel(MetaDomain<E, R> domain) {

			for (MetaNode metaNode : domain.getAllNodes())
				content.add("MATCH (n:" + metaNode.getLabel() + ") RETURN *");

			for (MetaRelation<E, R> metaRelation : domain.getAllRelations()) {
				for (E source : metaRelation.sources()) {
					for (E target : metaRelation.targets()) {
						content.add("MATCH " + metaRelation.cypher(source, target) + " RETURN *");
					}
				}
			}
		}

		@Override
		public int getSize() {
			return content.size();
		}

		@Override
		public String getElementAt(int index) {
			return content.get(index);
		}
	}
}