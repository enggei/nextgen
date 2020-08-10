package nextgen.st.canvas;

import org.piccolo2d.event.PInputEvent;

import javax.swing.*;

public class ScriptRelation extends nextgen.st.canvas.STRelation {


	public ScriptRelation(STModelCanvas canvas, nextgen.st.canvas.ScriptNode src, nextgen.st.canvas.STNode dst) {
		super(canvas, src, dst, "SCRIPT", src.getUuid());
	}

	@Override
	protected void onRelationRightClick(PInputEvent event, JPopupMenu pop) {
	}

	@Override
	protected void onRelationKeyPressed(PInputEvent event) {
		super.onRelationKeyPressed(event);
	}

}