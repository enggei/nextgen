package nextgen.st.canvas;

import org.piccolo2d.event.PInputEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class STValueNode extends STNode {

	nextgen.st.model.STValue stValue;
	nextgen.st.STRenderer stRenderer;

	public STValueNode(STCanvas canvas, String initText, java.util.UUID uuid, nextgen.st.model.STValue stValue, nextgen.st.STRenderer stRenderer) {
		super(canvas, initText, uuid);
		this.stValue = stValue;
		this.stRenderer = stRenderer;
	}


	@Override
	protected void onNodeRightClick(PInputEvent event, JPopupMenu pop) {
		pop.add(new ToClipboard(this, canvas, event));
		pop.add(new EditSTValue(this, canvas, event));
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

	private static final class ToClipboard extends NodeAction<STValueNode> {

		ToClipboard(STValueNode node, STCanvas canvas, PInputEvent event) {
			super("To Clipboard", node, canvas, event);
		}

		@Override
		void actionPerformed(STValueNode node, STCanvas canvas, PInputEvent event, ActionEvent e) {
			com.generator.util.SwingUtil.toClipboard(node.stRenderer.render(node.stValue));
		}
	}

	private static final class EditSTValue extends NodeAction<STValueNode> {

		EditSTValue(STValueNode node, STCanvas canvas, PInputEvent event) {
			super("Edit", node, canvas, event);
		}

		@Override
		void actionPerformed(STValueNode node, STCanvas canvas, PInputEvent event, ActionEvent e) {
			final JTextArea textArea = new JTextArea(15,40);
			textArea.setText(node.stValue.getValue());
			final JPanel inputPanel = new JPanel(new BorderLayout());
			inputPanel.add(textArea, BorderLayout.CENTER);
			inputPanel.setBorder(BorderFactory.createEmptyBorder(4,4,4,4));
			com.generator.util.SwingUtil.showDialog(inputPanel, canvas, "Edit", new com.generator.util.SwingUtil.ConfirmAction() {
				@Override
				public void verifyAndCommit() throws Exception {
					final String s = textArea.getText().trim();
					javax.swing.SwingUtilities.invokeLater(() ->  {
						node.stValue.setValue(s);
						node.setText(node.stValue.getValue());
					});
				}
			});
		}
	}
}