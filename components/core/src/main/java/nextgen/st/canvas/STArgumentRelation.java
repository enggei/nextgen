package nextgen.st.canvas;

import org.piccolo2d.event.PInputEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;

public class STArgumentRelation extends STRelation {

	nextgen.st.model.STArgument stArgument;
	nextgen.st.domain.STParameter stParameter;

	public STArgumentRelation(STCanvas canvas, STModelNode src, STNode dst, nextgen.st.model.STArgument stArgument, nextgen.st.domain.STParameter stParameter) {
		super(canvas, src, dst, stParameter.getName(), UUID.fromString(stArgument.getUuid()));
		this.stArgument = stArgument;
		this.stParameter = stParameter;
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

	private static final class Delete extends RelationAction<STArgumentRelation> {


		Delete(STArgumentRelation relation, STCanvas canvas, PInputEvent event) {
			super("Delete", relation, canvas, event);
		}

		@Override
		void actionPerformed(STArgumentRelation relation, STCanvas canvas, PInputEvent event, ActionEvent e) {
			if (!com.generator.util.SwingUtil.showConfirmDialog(canvas, "Delete ?")) return;
			final STModelNode src = (STModelNode) relation.getSrc();
			doLaterInTransaction(tx -> {
				src.stModel.removeArguments(relation.stArgument);
				canvas.removeRelation(relation.getUuid());
			});
		}
	}
}