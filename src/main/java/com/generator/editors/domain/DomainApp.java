package com.generator.editors.domain;

import com.generator.editors.BaseDomainVisitor;
import com.generator.editors.NeoModel;
import com.generator.editors.canvas.neo.NeoPNode;
import com.generator.util.SwingUtil;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;
import org.piccolo2d.event.PInputEvent;

import java.awt.event.ActionEvent;

import static com.generator.editors.NeoModel.uuidOf;

/**
 * goe on 12/30/16.
 */
public class DomainApp extends DomainEditor {

	@Override
	protected void onNewDomainNode(ActionEvent e, Transaction tx, NeoModel graph, PInputEvent event) throws Exception {

		final String name = SwingUtil.showInputDialog("Name", canvas);
		if (name == null) return;

		show(uuidOf(newDomainNode(graph, name)), Labels.DomainNode.name()).setOffset(event);
	}

	@Override
	protected void onNewDomainRelation(ActionEvent e, Transaction tx, NeoModel graph, PInputEvent event) throws Exception {

		final String name = SwingUtil.showInputDialog("Name", canvas);
		if (name == null) return;

		show(uuidOf(newDomainRelation(graph, name)), Labels.DomainRelation.name()).setOffset(event);
	}

	@Override
	protected NeoPNode newDomainNodePNode(Node node, DomainEditor editor) {
		return new DomainNodePNode(node,editor) {
		};
	}


	public static void main(String[] args) {
		showEditor(new DomainApp(), new DomainEditorRenderPanel() {
			@Override
			protected void renderDomainNode(BasePNode node) {
				txtEditor.setText(BaseDomainVisitor.getString(node.node, Properties.name.name()));
			}

			@Override
			protected void renderDomainRelation(BasePNode node) {
				txtEditor.setText(BaseDomainVisitor.getString(node.node, Properties.name.name()));
			}
		});
	}
}
