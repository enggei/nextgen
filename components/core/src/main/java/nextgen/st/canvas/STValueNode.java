package nextgen.st.canvas;

import com.generator.util.SwingUtil;
import nextgen.st.domain.STParameterKey;
import nextgen.st.model.STArgumentKV;
import nextgen.st.model.STValue;
import nextgen.st.model.STValueType;
import org.piccolo2d.event.PInputEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;


public class STValueNode extends STNode {

	nextgen.st.model.STValue stValue;
	nextgen.st.STRenderer stRenderer;

	public STValueNode(STCanvas canvas, nextgen.st.model.STValue stValue, nextgen.st.STRenderer stRenderer) {
		super(canvas, stRenderer.render(stValue), java.util.UUID.fromString(stValue.getUuid()));
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
			canvas.modelDb.doInTransaction(tx -> {
				com.generator.util.SwingUtil.toClipboard(node.stRenderer.render(node.stValue));
			}, throwable -> com.generator.util.SwingUtil.showExceptionNoStack(canvas, throwable));
		}
	}

	private static final class EditSTValue extends NodeAction<STValueNode> {


		EditSTValue(STValueNode node, STCanvas canvas, PInputEvent event) {
			super("Edit", node, canvas, event);
		}

		@Override
		void actionPerformed(STValueNode node, STCanvas canvas, PInputEvent event, ActionEvent e) {
			final JTextArea textArea = new JTextArea(15,40);
			canvas.modelDb.doInTransaction(tx -> {
				textArea.setText(node.stValue.getValue().toString());
			}, throwable -> com.generator.util.SwingUtil.showExceptionNoStack(canvas, throwable));
			final JPanel inputPanel = new JPanel(new BorderLayout());
			inputPanel.add(textArea, BorderLayout.CENTER);
			inputPanel.setBorder(BorderFactory.createEmptyBorder(4,4,4,4));
			com.generator.util.SwingUtil.showDialog(inputPanel, canvas, "Edit", new com.generator.util.SwingUtil.ConfirmAction() {
				@Override
				public void verifyAndCommit() throws Exception {
					final String s = textArea.getText().trim();
					javax.swing.SwingUtilities.invokeLater(() -> canvas.modelDb.doInTransaction(tx -> {
						node.stValue.setValue(s);
						node.setText(node.stValue.getValue().toString());
					}, throwable -> com.generator.util.SwingUtil.showExceptionNoStack(canvas, throwable)));
				}
			});
		}
	}
}