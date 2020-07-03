package nextgen.st.canvas;

import com.generator.util.SwingUtil;
import nextgen.st.domain.STParameterKey;
import nextgen.st.model.STArgumentKV;
import nextgen.st.model.STValue;
import nextgen.st.model.STValueType;
import org.piccolo2d.event.PInputEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static nextgen.st.STModelPatterns.*;

public class STModelNode extends STNode {

    nextgen.st.domain.STTemplate stTemplate;
    nextgen.st.model.STModel stModel;
    nextgen.st.STRenderer stRenderer;

    public STModelNode(STCanvas canvas, String initText, java.util.UUID uuid, nextgen.st.domain.STTemplate stTemplate, nextgen.st.model.STModel stModel, nextgen.st.STRenderer stRenderer) {
        super(canvas, initText, uuid);
        this.stTemplate = stTemplate;
        this.stModel = stModel;
        this.stRenderer = stRenderer;
        if (this.stModel != null)
            this.stModel.addPropertyChangeListener(this);
    }


    @Override
    protected void onNodeRightClick(PInputEvent event, JPopupMenu pop) {
        final java.util.List<STValueNode> stValueNodes = canvas.getSelectedNodes()
                .filter(stNode -> stNode instanceof STValueNode)
                .filter(stNode -> !stNode.getUuid().equals(getUuid()))
                .map(stNode -> (STValueNode) stNode)
                .collect(Collectors.toList());
        final java.util.List<STModelNode> stModelNodes = canvas.getSelectedNodes()
                .filter(stNode -> stNode instanceof STModelNode)
                .filter(stNode -> !stNode.getUuid().equals(getUuid()))
                .map(stNode -> (STModelNode) stNode)
                .collect(Collectors.toList());
        stTemplate.getParameters().forEach(stParameter -> {
            final JMenu stParameterMenu = new JMenu(stParameter.getName());
            switch (stParameter.getType()) {
                case SINGLE: {
                    stParameterMenu.add(new STNode.NodeAction<STModelNode>("Set " + stParameter.getName(), this, canvas, event) {
                        @Override
                        void actionPerformed(STModelNode node, STCanvas canvas, PInputEvent event, ActionEvent e) {
                            final String s = SwingUtil.showInputDialog(stParameter.getName(), canvas);
                            if (s == null || s.trim().length() == 0) return;
                            final nextgen.st.model.STValue stValue = newSTValue(s.trim());
                            setArgument(stTemplate, stModel, newSTArgument(stParameter, stValue));
                            setText(stRenderer.render(stModel));
                        }
                    });
                    stValueNodes.forEach(stNode -> {
                        final int end = Math.min(stNode.getText().length(), 50);
                        stParameterMenu.add(new STNode.NodeAction<STModelNode>("Set " + stParameter.getName() + " = " + stNode.getText().substring(0, end), this, canvas, event) {
                            @Override
                            void actionPerformed(STModelNode node, STCanvas canvas, PInputEvent event, ActionEvent e) {
                                setArgument(stTemplate, stModel, newSTArgument(stParameter, stNode.stValue));
                                setText(stRenderer.render(stModel));
                            }
                        });
                    });
                    stModelNodes.forEach(stNode -> {
                        final int end = Math.min(stNode.getText().length(), 50);
                        stParameterMenu.add(new STNode.NodeAction<STModelNode>("Set " + stParameter.getName() + " = " + stNode.getText().substring(0, end), this, canvas, event) {
                            @Override
                            void actionPerformed(STModelNode node, STCanvas canvas, PInputEvent event, ActionEvent e) {
                                setArgument(stTemplate, stModel, newSTArgument(stParameter, newSTValue(stNode.stModel)));
                                setText(stRenderer.render(stModel));
                            }
                        });
                    });
                    break;
                }
                case LIST: {
                    stParameterMenu.add(new STNode.NodeAction<STModelNode>("Add " + stParameter.getName(), this, canvas, event) {
                        @Override
                        void actionPerformed(STModelNode node, STCanvas canvas, PInputEvent event, ActionEvent e) {
                            final String s = SwingUtil.showInputDialog(stParameter.getName(), canvas);
                            if (s == null || s.trim().length() == 0) return;
                            final nextgen.st.model.STValue stValue = newSTValue(s.trim());
                            canvas.addNode(new STValueNode(canvas, s, stValue.getUuid(), stValue, node.stRenderer));
                            addArgument(stTemplate, stModel, newSTArgument(stParameter, stValue));
                            setText(stRenderer.render(stModel));
                        }
                    });
                    stValueNodes.forEach(stNode -> {
                        final int end = Math.min(stNode.getText().length(), 50);
                        stParameterMenu.add(new STNode.NodeAction<STModelNode>("Add " + stParameter.getName() + " = " + stNode.getText().substring(0, end), this, canvas, event) {
                            @Override
                            void actionPerformed(STModelNode node, STCanvas canvas, PInputEvent event, ActionEvent e) {
                                addArgument(stTemplate, stModel, newSTArgument(stParameter, stNode.stValue));
                                setText(stRenderer.render(stModel));
                            }
                        });
                    });
                    stModelNodes.forEach(stNode -> {
                        final int end = Math.min(stNode.getText().length(), 50);
                        stParameterMenu.add(new STNode.NodeAction<STModelNode>("Add " + stParameter.getName() + " = " + stNode.getText().substring(0, end), this, canvas, event) {
                            @Override
                            void actionPerformed(STModelNode node, STCanvas canvas, PInputEvent event, ActionEvent e) {
                                addArgument(stTemplate, stModel, newSTArgument(stParameter, newSTValue(stNode.stModel)));
                                setText(stRenderer.render(stModel));
                            }
                        });
                    });
                    break;
                }
                case KVLIST: {
                    stParameterMenu.add(new STNode.NodeAction<STModelNode>("Add " + stParameter.getName(), this, canvas, event) {
                        @Override
                        void actionPerformed(STModelNode node, STCanvas canvas, PInputEvent event, ActionEvent e) {
                            final Map<STParameterKey, JTextField> fieldMap = new LinkedHashMap<>();
                            stParameter.getKeys().forEach(stParameterKey -> fieldMap.put(stParameterKey, new JTextField(15)));
                            final JPanel inputPanel = new JPanel(new GridLayout(fieldMap.size(), 2));
                            inputPanel.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
                            for (Map.Entry<STParameterKey, JTextField> fieldEntry : fieldMap.entrySet()) {
                                inputPanel.add(new JLabel(fieldEntry.getKey().getName()));
                                inputPanel.add(fieldEntry.getValue());
                            }
                            SwingUtil.showDialog(inputPanel, canvas, stParameter.getName(), new SwingUtil.ConfirmAction() {
                                @Override
                                public void verifyAndCommit() throws Exception {
                                    final Collection<STArgumentKV> kvs = new ArrayList<>();
                                    for (Map.Entry<STParameterKey, JTextField> fieldEntry : fieldMap.entrySet()) {
                                        final String value = fieldEntry.getValue().getText().trim();
                                        if (value.length() == 0) continue;
                                        kvs.add(new STArgumentKV().setStParameterKey(fieldEntry.getKey()).setValue(newSTValue(value)));
                                    }
                                    addArgument(stTemplate, stModel, newSTArgument(stParameter, kvs));
                                    setText(stRenderer.render(stModel));
                                }
                            });
                        }
                    });
                    break;
                }
            }
            pop.add(stParameterMenu);
        });
        final JMenu open = new JMenu("Open");
        stModel.getArguments().forEach(stArgument -> {
            final String s = stRenderer.render(stArgument).toString();
            final int end = Math.min(s.length(), 50);
            open.add(new STNode.NodeAction<STModelNode>("Open " + s.substring(0, end), this, canvas, event) {
                @Override
                void actionPerformed(STModelNode node, STCanvas canvas, PInputEvent event, ActionEvent e) {
                    javax.swing.SwingUtilities.invokeLater(() -> {
                        final STValue stValue = stArgument.getValue();
                        switch (stValue.getType()) {
                            case STMODEL: {
                                final nextgen.st.model.STModel stModel = stValue.getStModel();
                                if (canvas.getNode(stModel.getUuid()) == null)
                                    canvas.addNode(new STModelNode(canvas, stRenderer.render(stModel), stModel.getUuid(), stModel.getStTemplate(), stModel, node.stRenderer));
                                break;
                            }
                            case PRIMITIVE: {
								if (canvas.getNode(stValue.getUuid()) == null)
                                	canvas.addNode(new STValueNode(canvas, stRenderer.render(stValue), stValue.getUuid(), stValue, node.stRenderer));
                                break;
                            }
                            case ENUM: {
								if (canvas.getNode(stValue.getUuid()) == null)
                                	canvas.addNode(new STValueNode(canvas, stRenderer.render(stValue), stValue.getUuid(), stValue, node.stRenderer));
                                break;
                            }
                        }
                    });
                }
            });
        });
        if (open.getMenuComponentCount() != 0) pop.add(open);
        final JMenu remove = new JMenu("Remove");
        stModel.getArguments().forEach(stArgument -> {
            final String s = stRenderer.render(stArgument).toString();
            final int end = Math.min(s.length(), 50);
            remove.add(new STNode.NodeAction<STModelNode>("Remove " + s.substring(0, end), this, canvas, event) {
                @Override
                void actionPerformed(STModelNode node, STCanvas canvas, PInputEvent event, ActionEvent e) {
                    stModel.removeArguments(stArgument);
                    setText(stRenderer.render(stModel));
                }
            });
        });
        if (remove.getMenuComponentCount() != 0) pop.add(remove);
        pop.add(new ToClipboard(this, canvas, event));
        pop.add(new Delete(this, canvas, event));
        pop.add(new AddFileSink(this, canvas, event));
        pop.add(new OpenFileSink(this, canvas, event));
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
        setText(stRenderer.render(stModel));
    }

    @Override
    public void propertyChange(java.beans.PropertyChangeEvent evt) {
        setText(stRenderer.render(stModel));
    }

    private static final class ToClipboard extends NodeAction<STModelNode> {

        ToClipboard(STModelNode node, STCanvas canvas, PInputEvent event) {
            super("To Clipboard", node, canvas, event);
        }

        @Override
        void actionPerformed(STModelNode node, STCanvas canvas, PInputEvent event, ActionEvent e) {
            com.generator.util.SwingUtil.toClipboard(node.stRenderer.render(node.stModel));
        }
    }

    private static final class Delete extends NodeAction<STModelNode> {

        Delete(STModelNode node, STCanvas canvas, PInputEvent event) {
            super("Delete", node, canvas, event);
        }

        @Override
        void actionPerformed(STModelNode node, STCanvas canvas, PInputEvent event, ActionEvent e) {
            javax.swing.SwingUtilities.invokeLater(() -> canvas.modelDb.doInTransaction(tx -> {
                canvas.modelDb.remove(node.stModel);
                canvas.removeNode(node.getUuid());
            }));
        }
    }

    private static final class AddFileSink extends NodeAction<STModelNode> {

        AddFileSink(STModelNode node, STCanvas canvas, PInputEvent event) {
            super("Add File Sink", node, canvas, event);
        }

        @Override
        void actionPerformed(STModelNode node, STCanvas canvas, PInputEvent event, ActionEvent e) {
            final Map<String, JTextField> fieldMap = new java.util.LinkedHashMap<>();
            fieldMap.put("name", new JTextField(getSTModelValue(node.stModel, "name", ""), 15));
            fieldMap.put("type", new JTextField(15));
            fieldMap.put("path", new JTextField(15));
            fieldMap.put("package", new JTextField(getSTModelPackage(node.stModel, ""), 15));
            final JPanel inputPanel = new JPanel(new GridLayout(fieldMap.size(), 2));
            inputPanel.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
            for (Map.Entry<String, JTextField> fieldEntry : fieldMap.entrySet()) {
                inputPanel.add(new JLabel(fieldEntry.getKey()));
                inputPanel.add(fieldEntry.getValue());
            }
            com.generator.util.SwingUtil.showDialog(inputPanel, canvas, "New File sink", new com.generator.util.SwingUtil.ConfirmAction() {
                @Override
                public void verifyAndCommit() throws Exception {
                    final String name = fieldMap.get("name").getText().trim();
                    final String type = fieldMap.get("type").getText().trim();
                    final String path = fieldMap.get("path").getText().trim();
                    final String packageName = fieldMap.get("package").getText().trim();
                    javax.swing.SwingUtilities.invokeLater(() -> {
                        final nextgen.st.model.STFile stFile = newSTFile(name, type, path, packageName);
                        node.stModel.setFile(stFile);
                        canvas.addNode(new STFileNode(canvas, nextgen.st.STGenerator.asFile(stFile).getAbsolutePath(), stFile.getUuid(), stFile, node.stModel, node.stRenderer));
                    });
                }
            });
        }
    }

    private static final class OpenFileSink extends NodeAction<STModelNode> {

        OpenFileSink(STModelNode node, STCanvas canvas, PInputEvent event) {
            super("Open File Sink", node, canvas, event);
        }

        @Override
        void actionPerformed(STModelNode node, STCanvas canvas, PInputEvent event, ActionEvent e) {
            javax.swing.SwingUtilities.invokeLater(() -> {
                final nextgen.st.model.STFile stFile = node.stModel.getFile();
                if (stFile == null) return;
                canvas.addNode(new STFileNode(canvas, nextgen.st.STGenerator.asFile(stFile).getAbsolutePath(), stFile.getUuid(), stFile, node.stModel, node.stRenderer));
            });
        }
    }
}