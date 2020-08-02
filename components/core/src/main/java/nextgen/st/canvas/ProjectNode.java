package nextgen.st.canvas;

import org.piccolo2d.event.PInputEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;

public class ProjectNode extends nextgen.st.canvas.STNode {

	nextgen.st.model.Project project;

	public ProjectNode(nextgen.st.canvas.STCanvas canvas, nextgen.st.model.Project project) {
		super(canvas, project.getName(), java.util.UUID.fromString(project.getUuid()));
		this.project = project;
	}

	@Override
	public void addedToCanvas() {
	}

	@Override
	public void newNodeAdded(nextgen.st.canvas.STNode node) {
	}

	@Override
	protected void onNodeRightClick(PInputEvent event, JPopupMenu pop) {
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


}