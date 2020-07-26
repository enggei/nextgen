package nextgen.st.canvas;

import org.piccolo2d.event.PInputEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;

public class ScriptRelation extends nextgen.st.canvas.STRelation {


	public ScriptRelation(nextgen.st.canvas.STCanvas canvas, nextgen.st.canvas.ScriptNode src, nextgen.st.canvas.STNode dst) {
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