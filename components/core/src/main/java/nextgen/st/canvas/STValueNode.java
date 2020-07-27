package nextgen.st.canvas;

import org.piccolo2d.event.PInputEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;

public class STValueNode extends nextgen.st.canvas.STNode {

	nextgen.st.model.STValue stValue;

	public STValueNode(STCanvas canvas, nextgen.st.model.STValue stValue) {
		super(canvas, canvas.presentationModel.render(stValue), java.util.UUID.fromString(stValue.getUuid()));
		this.stValue = stValue;
	}

	@Override
	public void addedToCanvas() {
		if (stValue.getType().equals(nextgen.st.model.STValueType.STMODEL)) {
		            final nextgen.st.model.STModel stModel = stValue.getStModel();
		            final STNode stModelNode = canvas.getNode(UUID.fromString(stModel.getUuid()));
		            if (stModelNode instanceof STModelNode) {
		                canvas.addRelation(stModelNode.getUuid(), canvas.newSTValueModelRelation(STValueNode.this, (STModelNode) stModelNode));
		            }
		        }
	}

	@Override
	public void newNodeAdded(nextgen.st.canvas.STNode node) {
		if (stValue.getType().equals(nextgen.st.model.STValueType.STMODEL)) {
		            final UUID uuid = UUID.fromString(stValue.getStModel().getUuid());
		            if (uuid.equals(node.getUuid())) {
		                canvas.addRelation(node.getUuid(), canvas.newSTValueModelRelation(STValueNode.this, (STModelNode) node));
		            }
		        }
	}

	@Override
	protected void onNodeRightClick(PInputEvent event, JPopupMenu pop) {
		pop.add(new EditSTValue(this, canvas, event));
		pop.add(new ToClipboard(this, canvas, event));
		pop.add(new Delete(this, canvas, event));
		pop.add(new OpenIncoming(this, canvas, event));
		pop.addSeparator();
		super.onNodeRightClick(event, pop);
	}

	@Override
	protected void onNodeKeyPressed(PInputEvent event) {
		super.onNodeKeyPressed(event);
	}

	@Override
	protected void onNodeLeftClick(PInputEvent event) {
		super.onNodeLeftClick(event);
	}

	private static final class EditSTValue extends NodeAction<STValueNode> {


		EditSTValue(STValueNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event) {
			super("Edit", node, canvas, event);
		}

		@Override
		void actionPerformed(STValueNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event, ActionEvent e) {
			com.generator.util.SwingUtil.showInputDialog("Edit", canvas, canvas.presentationModel.db.get(() -> node.stValue.getValue()), s -> doLaterInTransaction(tx -> {
				node.stValue.setValue(s);
				node.setText(node.stValue.getValue());
			}));
		}
	}

	private static final class ToClipboard extends NodeAction<STValueNode> {


		ToClipboard(STValueNode node, STCanvas canvas, PInputEvent event) {
			super("To Clipboard", node, canvas, event);
		}

		@Override
		void actionPerformed(STValueNode node, STCanvas canvas, PInputEvent event, ActionEvent e) {
			canvas.presentationModel.db.doInTransaction(tx -> {
				com.generator.util.SwingUtil.toClipboard(canvas.presentationModel.render(node.stValue));
			});
		}
	}

	private static final class Delete extends NodeAction<STValueNode> {


		Delete(STValueNode node, STCanvas canvas, PInputEvent event) {
			super("Delete", node, canvas, event);
		}

		@Override
		void actionPerformed(STValueNode node, STCanvas canvas, PInputEvent event, ActionEvent e) {
			if (!com.generator.util.SwingUtil.showConfirmDialog(canvas, "Delete value ?")) return;
			doLaterInTransaction(tx -> {
				node.close();
				canvas.presentationModel.db.remove(node.stValue);
			});
		}
	}

	private static final class OpenIncoming extends NodeAction<STValueNode> {


		OpenIncoming(STValueNode node, STCanvas canvas, PInputEvent event) {
			super("Open Incoming", node, canvas, event);
		}

		@Override
		void actionPerformed(STValueNode node, STCanvas canvas, PInputEvent event, ActionEvent e) {
			doLaterInTransaction(transaction -> {
				canvas.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
				final org.neo4j.graphdb.Node neoNode = node.stValue.getNode();
				neoNode.getRelationships(org.neo4j.graphdb.Direction.INCOMING).forEach(relationship -> {
					final org.neo4j.graphdb.Node otherNode = relationship.getOtherNode(neoNode);
					if (otherNode.hasLabel(org.neo4j.graphdb.Label.label("STArgument"))) {
						final nextgen.st.model.STArgument stArgument = new nextgen.st.model.STArgument(otherNode);
						stArgument.getIncomingArguments().forEach(stModel -> {
							final nextgen.st.domain.STTemplate stTemplateByUuid = canvas.presentationModel.db.findSTTemplateByUuid(stModel.getStTemplate());
							if (stTemplateByUuid == null) return;
							stTemplateByUuid.getParameters()
									.filter(stParameter -> stParameter.uuid().equals(stArgument.getStParameter()))
									.findFirst()
									.ifPresent(stParameter -> {
										final STModelNode stModelNode = canvas.addNode(stModel.getUuid(), canvas.newSTNode(stModel));
										canvas.addRelation(stArgument.getUuid(), canvas.newSTArgumentRelation(stModelNode, node, stArgument, stParameter));
									});
						});
					}
				});
				canvas.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			});
		}
	}
}