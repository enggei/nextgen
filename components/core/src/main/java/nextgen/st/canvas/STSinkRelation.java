package nextgen.st.canvas;

import nextgen.utils.SwingUtil;
import org.piccolo2d.event.PInputEvent;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class STSinkRelation extends STRelation {


	public STSinkRelation(STModelCanvas canvas, STModelNode src, STFileNode dst) {
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


		Delete(STSinkRelation relation, STModelCanvas canvas, PInputEvent event) {
			super("Delete", relation, canvas, event);
		}

		@Override
		void actionPerformed(STSinkRelation relation, STModelCanvas canvas, PInputEvent event, ActionEvent e) {
			if (!SwingUtil.showConfirmDialog(canvas, "Delete ?")) return;
			doLaterInTransaction(tx -> {
				((STModelNode) relation.getSrc()).stModel.removeFiles(((STFileNode) relation.getDst()).stFile);
				canvas.removeRelation(relation.getUuid());
			});
		}
	}
}