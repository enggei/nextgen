package nextgen.st.canvas;

import org.piccolo2d.event.PInputEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;

public class STValueModelRelation extends STRelation {


	public STValueModelRelation(STCanvas canvas, STValueNode src, STModelNode dst) {
		super(canvas, src, dst, "sTValueModelRelation", UUID.fromString(src.stValue.getUuid()));
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


		Delete(STValueModelRelation relation, STCanvas canvas, PInputEvent event) {
			super("Delete", relation, canvas, event);
		}

		@Override
		void actionPerformed(STValueModelRelation relation, STCanvas canvas, PInputEvent event, ActionEvent e) {
			if (!com.generator.util.SwingUtil.showConfirmDialog(canvas, "Delete ?")) return;
			doLaterInTransaction(tx -> {
				final STValueNode src = (STValueNode) relation.getSrc();
				src.close();
				canvas.modelDb.remove(src.stValue);
			});
		}
	}
}