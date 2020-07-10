package nextgen.st.canvas;

import org.piccolo2d.event.PInputEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;

public class STSinkRelation extends STRelation {


	public STSinkRelation(STCanvas canvas, STModelNode src, STFileNode dst) {
		super(canvas, src, dst, "SINK", dst.getUuid());
	}

	@Override
	protected void onRelationRightClick(PInputEvent event, JPopupMenu pop) {
		pop.add(new Delete(this, canvas, event));
	}

	@Override
	protected void onRelationKeyPressed(PInputEvent event) {
		switch (event.getKeyCode()) {
			case java.awt.event.KeyEvent.VK_D:
				new Delete(this, canvas, event).actionPerformed(null);
				break;

		}
		super.onRelationKeyPressed(event);
	}

	private static final class Delete extends RelationAction<STSinkRelation> {


		Delete(STSinkRelation relation, STCanvas canvas, PInputEvent event) {
			super("Delete", relation, canvas, event);
		}

		@Override
		void actionPerformed(STSinkRelation relation, STCanvas canvas, PInputEvent event, ActionEvent e) {
			if (!com.generator.util.SwingUtil.showConfirmDialog(canvas, "Delete ?")) return;
			final STModelNode src = (STModelNode) relation.getSrc();
			final STFileNode dst = (STFileNode) relation.getDst();
			doLaterInTransaction(tx -> {
				src.stModel.removeFiles(dst.stFile);
				canvas.removeRelation(relation.getUuid());
			});
		}
	}
}