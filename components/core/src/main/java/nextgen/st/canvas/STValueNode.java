package nextgen.st.canvas;

import org.piccolo2d.event.PInputEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;
import java.util.stream.Stream;

public class STValueNode extends STNode {

	nextgen.st.model.STValue stValue;
	nextgen.st.STRenderer stRenderer;

	public STValueNode(STCanvas canvas, nextgen.st.model.STValue stValue, nextgen.st.STRenderer stRenderer) {
		super(canvas, stRenderer.render(stValue), java.util.UUID.fromString(stValue.getUuid()));
		this.stValue = stValue;
		this.stRenderer = stRenderer;
	}


	@Override
	public void addedToCanvas() {
		if (stValue.getType().equals(nextgen.st.model.STValueType.STMODEL)) {
			final nextgen.st.model.STModel stModel = stValue.getStModel();
			final STNode stModelNode = canvas.getNode(UUID.fromString(stModel.getUuid()));
			if (stModelNode instanceof STModelNode) {
				canvas.addRelation(new STValueModelRelation(canvas, STValueNode.this, (STModelNode) stModelNode));
			}
		}
	}

	@Override
	public void newNodeAdded(STNode node) {
		if (stValue.getType().equals(nextgen.st.model.STValueType.STMODEL)) {
			final UUID uuid = UUID.fromString(stValue.getStModel().getUuid());
			if (uuid.equals(node.getUuid())) {
				canvas.addRelation(new STValueModelRelation(canvas, STValueNode.this, (STModelNode) node));
			}
		}
	}

	@Override
	protected void onNodeRightClick(PInputEvent event, JPopupMenu pop) {
		pop.add(new EditSTValue(this, canvas, event));
		pop.add(new ToClipboard(this, canvas, event));
		pop.add(new Delete(this, canvas, event));
		pop.addSeparator();
		super.onNodeRightClick(event, pop);
	}

	@Override
	protected void onNodeKeyPressed(PInputEvent event) {
		switch (event.getKeyCode()) {
			case java.awt.event.KeyEvent.VK_D:
				new Delete(this, canvas, event).actionPerformed(null);
				return;

		}
		super.onNodeKeyPressed(event);
	}

	@Override
	protected void onNodeLeftClick(PInputEvent event) {
		super.onNodeLeftClick(event);
	}

	private static final class EditSTValue extends NodeAction<STValueNode> {


		EditSTValue(STValueNode node, STCanvas canvas, PInputEvent event) {
			super("Edit", node, canvas, event);
		}

		@Override
		void actionPerformed(STValueNode node, STCanvas canvas, PInputEvent event, ActionEvent e) {
			final JTextArea textArea = new JTextArea(15,40);
			canvas.modelDb.doInTransaction(tx -> {
				textArea.setText(node.stValue.getValue());
			});
			final JPanel inputPanel = new JPanel(new BorderLayout());
			inputPanel.add(textArea, BorderLayout.CENTER);
			inputPanel.setBorder(BorderFactory.createEmptyBorder(4,4,4,4));
			com.generator.util.SwingUtil.showDialog(inputPanel, canvas, "Edit", new com.generator.util.SwingUtil.ConfirmAction() {
				@Override
				public void verifyAndCommit() throws Exception {
					final String s = textArea.getText().trim();
					doLaterInTransaction(tx -> {
						node.stValue.setValue(s);
						node.setText(node.stValue.getValue());
					});
				}
			});
		}
	}

	private static final class ToClipboard extends NodeAction<STValueNode> {


		ToClipboard(STValueNode node, STCanvas canvas, PInputEvent event) {
			super("To Clipboard", node, canvas, event);
		}

		@Override
		void actionPerformed(STValueNode node, STCanvas canvas, PInputEvent event, ActionEvent e) {
			canvas.modelDb.doInTransaction(tx -> {
				com.generator.util.SwingUtil.toClipboard(node.stRenderer.render(node.stValue));
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
				canvas.modelDb.remove(node.stValue);
			});
		}
	}
}