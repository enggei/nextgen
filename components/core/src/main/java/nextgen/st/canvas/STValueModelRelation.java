package nextgen.st.canvas;

import nextgen.utils.SwingUtil;
import org.piccolo2d.event.PInputEvent;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class STValueModelRelation extends STRelation {


	public STValueModelRelation(STModelCanvas canvas, STValueNode src, STModelNode dst) {
		super(canvas, src, dst, "Value", dst.getUuid());
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

	private static final class Delete extends RelationAction<STValueModelRelation> {


		Delete(STValueModelRelation relation, STModelCanvas canvas, PInputEvent event) {
			super("Delete", relation, canvas, event);
		}

		@Override
		void actionPerformed(STValueModelRelation relation, STModelCanvas canvas, PInputEvent event, ActionEvent e) {
			if (!SwingUtil.showConfirmDialog(canvas, "Delete ?")) return;
			doLaterInTransaction(tx -> {
				final STValueNode src = (STValueNode) relation.getSrc();
				src.close();
				canvas.presentationModel.db.remove(src.stValue);
			});
		}
	}
}