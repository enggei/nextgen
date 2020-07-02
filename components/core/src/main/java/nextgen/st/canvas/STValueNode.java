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

import static nextgen.st.STModelPatterns.*;

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
			final String s = com.generator.util.SwingUtil.showInputDialog("Value", canvas, node.stValue.getValue().toString());
			if (s == null || s.trim().length() == 0) return;
			node.stValue.setValue(s);
			node.setText(node.stValue.getValue().toString());
		}
	}
}