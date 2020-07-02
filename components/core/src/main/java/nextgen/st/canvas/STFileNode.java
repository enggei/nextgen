package nextgen.st.canvas;

import nextgen.st.STModelPatterns;
import nextgen.st.model.STModel;
import org.piccolo2d.event.PInputEvent;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.util.stream.Collectors;

public class STFileNode extends STNode {

    nextgen.st.model.STFile stFile;
    nextgen.st.model.STModel stModel;
    nextgen.st.STRenderer stRenderer;

    public STFileNode(STCanvas canvas, String initText, java.util.UUID uuid, nextgen.st.model.STFile stFile, nextgen.st.model.STModel stModel, nextgen.st.STRenderer stRenderer) {
        super(canvas, initText, uuid);
        this.stFile = stFile;
        this.stModel = stModel;
        this.stRenderer = stRenderer;
        if (this.stModel != null)
            this.stModel.addPropertyChangeListener(this);

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        final Object source = evt.getSource();
        if (source instanceof STModel) {
			System.out.println("STModel changed");
            final STModel stModel = (STModel) source;
            this.stFile.setName(STModelPatterns.getSTModelValue(stModel, "name", this.stFile.getName()));
            this.stFile.setPackageName(STModelPatterns.getSTModelPackage(stModel, this.stFile.getPackageName()));
        }
    }

    @Override
    protected void onNodeRightClick(PInputEvent event, JPopupMenu pop) {
        final java.util.List<STModelNode> stModelNodes = canvas.getSelectedNodes()
                .filter(stNode -> stNode instanceof STModelNode)
                .filter(stNode -> !stNode.getUuid().equals(getUuid()))
                .map(stNode -> (STModelNode) stNode)
                .collect(Collectors.toList());
        final JMenu sourceMenu = new JMenu("STModels");
        stModelNodes.forEach(stNode -> {
            final int end = Math.min(stNode.getText().length(), 50);
            sourceMenu.add(new STNode.NodeAction<STFileNode>("Set source to " + stNode.getText().substring(0, end), this, canvas, event) {
                @Override
                void actionPerformed(STFileNode node, STCanvas canvas, PInputEvent event, ActionEvent e) {
                    node.stModel = stNode.stModel;
                }
            });
        });
        pop.add(sourceMenu);
        pop.add(new OpenFile(this, canvas, event));
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
        if (stRenderer == null || stModel == null) return;
        nextgen.st.STGenerator.writeToFile(stRenderer.render(stModel), stFile.getPackageName(), stFile.getName(), stFile.getType(), new java.io.File(stFile.getPath()));
    }

    private static final class OpenFile extends NodeAction<STFileNode> {

        OpenFile(STFileNode node, STCanvas canvas, PInputEvent event) {
            super("Open", node, canvas, event);
        }

        @Override
        void actionPerformed(STFileNode node, STCanvas canvas, PInputEvent event, ActionEvent e) {
            try {
                java.awt.Desktop.getDesktop().open(nextgen.st.STGenerator.asFile(node.stFile));
            } catch (java.io.IOException ex) {
                com.generator.util.SwingUtil.showException(canvas, ex);
            }
        }
    }
}