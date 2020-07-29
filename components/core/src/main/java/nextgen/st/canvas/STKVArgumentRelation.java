package nextgen.st.canvas;

import nextgen.utils.SwingUtil;
import org.piccolo2d.event.PInputEvent;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.*;

public class STKVArgumentRelation extends STRelation {

	nextgen.st.model.STArgument stArgument;
	nextgen.st.domain.STParameterKey stParameterKey;
	nextgen.st.model.STArgumentKV stArgumentKV;

	public STKVArgumentRelation(STCanvas canvas, STKVNode src, STNode dst, nextgen.st.model.STArgument stArgument, nextgen.st.domain.STParameterKey stParameterKey, nextgen.st.model.STArgumentKV stArgumentKV) {
		super(canvas, src, dst, stParameterKey.getName(), UUID.fromString(stArgumentKV.getUuid()));
		this.stArgument = stArgument;
		this.stParameterKey = stParameterKey;
		this.stArgumentKV = stArgumentKV;
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

	private static final class Delete extends RelationAction<STKVArgumentRelation> {


		Delete(STKVArgumentRelation relation, STCanvas canvas, PInputEvent event) {
			super("Delete", relation, canvas, event);
		}

		@Override
		void actionPerformed(STKVArgumentRelation relation, STCanvas canvas, PInputEvent event, ActionEvent e) {
			if (!SwingUtil.showConfirmDialog(canvas, "Delete ?")) return;
			doLaterInTransaction(tx -> {
				canvas.removeRelation(relation.getUuid());
				relation.stArgument.removeKeyValues(relation.stArgumentKV);
			});
		}
	}
}