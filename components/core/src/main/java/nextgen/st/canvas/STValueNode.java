package nextgen.st.canvas;

import org.piccolo2d.event.PInputEvent;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.*;

public class STValueNode extends nextgen.st.canvas.STNode {

    nextgen.st.model.STValue stValue;

    public STValueNode(STModelCanvas canvas, nextgen.st.model.STValue stValue) {
        super(canvas, canvas.presentationModel.render(stValue), java.util.UUID.fromString(stValue.getUuid()));
        this.stValue = stValue;
    }

    @Override
    public void addedToCanvas() {
        canvas.presentationModel.getSTModel(stValue)
                .filter(stModel -> canvas.getNode(UUID.fromString(stModel.getUuid())) != null)
                .map(stModel -> (STModelNode) canvas.getNode(UUID.fromString(stModel.getUuid())))
                .ifPresent(stModelNode -> canvas.addRelation(stModelNode.getUuid(), canvas.newSTValueModelRelation(STValueNode.this, stModelNode)));


    }

    @Override
    public void newNodeAdded(nextgen.st.canvas.STNode node) {
        if (stValue.getType().equals(nextgen.st.model.STValueType.STMODEL)) {
            final UUID uuid = UUID.fromString(stValue.getStModel().getUuid());
            if (uuid.equals(node.getUuid())) {
                canvas.addRelation(node.getUuid(), canvas.newSTValueModelRelation(STValueNode.this, (STModelNode) node));
            }
        }
    }

    @Override
    protected void onNodeRightClick(PInputEvent event, JPopupMenu pop) {
        pop.add(new EditSTValue(this, canvas, event));
        pop.add(new ToClipboard(this, canvas, event));
        pop.add(new Delete(this, canvas, event));
        pop.add(new OpenIncoming(this, canvas, event));
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
    }


    private static final class EditSTValue extends NodeAction<STValueNode> {


        EditSTValue(STValueNode node, STModelCanvas canvas, PInputEvent event) {
            super("Edit", node, canvas, event);
        }

        @Override
        void actionPerformed(STValueNode node, STModelCanvas canvas, PInputEvent event, ActionEvent e) {
            nextgen.utils.SwingUtil.showInputDialog("Edit", canvas, canvas.presentationModel.db.get(() -> node.stValue.getValue()), s -> canvas.presentationModel.doLaterInTransaction(tx -> {
                node.stValue.setValue(s);
                node.setText(node.stValue.getValue());
            }));
        }
    }

    private static final class ToClipboard extends NodeAction<STValueNode> {


        ToClipboard(STValueNode node, STModelCanvas canvas, PInputEvent event) {
            super("To Clipboard", node, canvas, event);
        }

        @Override
        void actionPerformed(STValueNode node, STModelCanvas canvas, PInputEvent event, ActionEvent e) {
            canvas.presentationModel.doInTransaction(tx -> nextgen.utils.SwingUtil.toClipboard(canvas.presentationModel.render(node.stValue)));
        }
    }

    private static final class Delete extends NodeAction<STValueNode> {


        Delete(STValueNode node, STModelCanvas canvas, PInputEvent event) {
            super("Delete", node, canvas, event);
        }

        @Override
        void actionPerformed(STValueNode node, STModelCanvas canvas, PInputEvent event, ActionEvent e) {
            if (!nextgen.utils.SwingUtil.showConfirmDialog(canvas, "Delete value ?")) return;
            canvas.presentationModel.doLaterInTransaction(tx -> {
                node.close();
                canvas.presentationModel.db.remove(node.stValue);
            });
        }
    }

    private static final class OpenIncoming extends NodeAction<STValueNode> {


        OpenIncoming(STValueNode node, STModelCanvas canvas, PInputEvent event) {
            super("Open Incoming", node, canvas, event);
        }

        @Override
        void actionPerformed(STValueNode node, STModelCanvas canvas, PInputEvent event, ActionEvent e) {
            canvas.presentationModel.doLaterInTransaction(transaction -> {

                canvas.presentationModel.getIncomingSTArguments(node.stValue)
                        .forEach(stArgument -> {
                            stArgument.getIncomingArguments().forEach(stModel -> {
                                final nextgen.st.domain.STTemplate stTemplateByUuid = canvas.presentationModel.findSTTemplateByUuid(stModel.getStTemplate());
                                if (stTemplateByUuid == null) return;
                                stTemplateByUuid.getParameters()
                                        .filter(stParameter -> stParameter.getUuid().equals(stArgument.getStParameter()))
                                        .findFirst()
                                        .ifPresent(stParameter -> {
                                            final STModelNode stModelNode = canvas.addNode(stModel.getUuid(), canvas.newSTNode(stModel));
                                            canvas.addRelation(stArgument.getUuid(), canvas.newSTArgumentRelation(stModelNode, node, stArgument, stParameter));
                                        });
                            });
                        });

                canvas.presentationModel.getIncomingSTArgumentKVs(node.stValue)
                        .forEach(stArgumentKV -> {
                            stArgumentKV.getIncomingKeyValues().forEach(stArgument -> {
                                stArgument.getIncomingArguments().forEach(stModel -> {
                                    final nextgen.st.domain.STTemplate stTemplateByUuid = canvas.presentationModel.findSTTemplateByUuid(stModel.getStTemplate());
                                    if (stTemplateByUuid == null) return;
                                    stTemplateByUuid.getParameters()
                                            .filter(stParameter -> stParameter.uuid().equals(stArgument.getStParameter()))
                                            .findFirst()
                                            .ifPresent(stParameter -> {
                                                final STModelNode stModelNode = canvas.addNode(stModel.getUuid(), canvas.newSTNode(stModel));
                                                final STKVNode stkvNode = canvas.addNode(stArgument.getUuid(), canvas.newSTNode(stParameter, stArgument));
                                                canvas.addRelation(stArgument.getUuid(), canvas.newSTArgumentRelation(stModelNode, stkvNode, stArgument, stParameter));
                                            });
                                });
                            });
                        });
            });
        }
    }
}