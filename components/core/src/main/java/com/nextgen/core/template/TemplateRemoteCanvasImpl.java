package com.nextgen.core.template;

import com.generator.util.FileUtil;
import com.nextgen.core.NodeCanvas;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import org.piccolo2d.event.PInputEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Set;

public class TemplateRemoteCanvasImpl extends TemplateRemoteCanvas {

    public TemplateRemoteCanvasImpl(Vertx vertx, Integer port, String host) {
        super(vertx, port, host);
    }

    @Override
    protected void onKeyPressed(PInputEvent event) {

        switch (event.getKeyCode()) {
            case KeyEvent.VK_E:
                getAllSTGroup();
                break;
        }

        super.onKeyPressed(event);
    }

    @Override
    protected void addContextMenuActions(PInputEvent event, JPopupMenu pop, Set<BasePNode> selectedNodes, Point mousePosition, NodeCanvas canvas) {

        pop.add(new SwingAction("Import stg text") {

            @Override
            protected void onActionPerformed(ActionEvent e) {

                final JTextArea textArea = newTextArea();
                textArea.setText(fromClipboard().trim());

                showTextInput("STG", textArea, canvas, new ConfirmAction() {
                    @Override
                    public void verifyAndCommit() throws IOException {

                        final String stgName = showInputDialog("STG name", canvas);
                        if (stgName == null || stgName.trim().length() == 0) return;

                        importSTG(stgName, textArea.getText().trim(), new ImportSTGHandler() {

                            @Override
                            public void onSuccess(String delimiter, String uuid, String name) {
                                addNode(newSTGroupNode(new JsonObject().put("delimiter", delimiter).put("uuid", uuid).put("name", name)), new LayoutAtPosition(mousePosition));
                            }
                        });
                    }
                });
            }
        });

        pop.add(new SwingAction("Import stg file") {

            @Override
            protected void onActionPerformed(ActionEvent e) {

                final File file = showOpenFile(canvas, "/home/goe/projects/nextgen/components/core/src/main/java/com/generator/generators/junit");
                if (file == null || !file.getName().toLowerCase().endsWith(".stg")) return;

                final String stgName = file.getName().substring(0, file.getName().length() - 4);

                importSTG(stgName, FileUtil.readIntact(file), new ImportSTGHandler() {

                    @Override
                    public void onSuccess(String delimiter, String uuid, String name) {
                        addNode(newSTGroupNode(new JsonObject().put("delimiter", delimiter).put("uuid", uuid).put("name", name)), new LayoutAtPosition(mousePosition));
                    }
                });
            }
        });

        pop.add(new SwingAction("Import group") {

            @Override
            protected void onActionPerformed(ActionEvent e) {

                final JTextArea textArea = newTextArea();
                textArea.setText(fromClipboard().trim());

                showTextInput("Import", textArea, canvas, new ConfirmAction() {
                    @Override
                    public void verifyAndCommit() throws IOException {

                        final JsonObject jsonObject = new JsonObject(textArea.getText());
                        importGroup(jsonObject.getJsonArray("relations"), jsonObject.getJsonArray("nodes"), new ImportGroupHandler() {

                            @Override
                            public void onSuccess() {
                                showMessage("Import successfull", canvas);
                            }
                        });
                    }
                });
            }
        });

        super.addContextMenuActions(event, pop, selectedNodes, mousePosition, canvas);
    }

    @Override
    public STGroupNode newSTGroupNode(JsonObject jsonObject) {
        return new STGroupNode(jsonObject) {
            @Override
            protected void onRightClick(PInputEvent event, JPopupMenu pop, NodeCanvas canvas, Point mousePosition) {

                pop.add(new SwingAction("Render") {
                    @Override
                    protected void onActionPerformed(ActionEvent e) {

                        final String packageName = showInputDialog("package", canvas, "com.test");
                        if (packageName == null) return;

                        renderSTGroup(packageName, getUUID().toString(), new RenderSTGroupHandler() {

                            @Override
                            public void onSuccess() {

                            }

                            @Override
                            protected void handleSuccess(String payload) {
                                log.info(payload);
                            }
                        });
                    }
                });

                pop.add(new SwingAction("Export") {
                    @Override
                    protected void onActionPerformed(ActionEvent e) {

                        exportGroup(getUUID().toString(), new ExportGroupHandler() {
                            @Override
                            public void onSuccess(JsonObject jsonObject) {

                                toClipboard(jsonObject.encodePrettily());
                            }
                        });
                    }
                });

                super.onRightClick(event, pop, canvas, mousePosition);
            }
        };
    }


    @Override
    public STTemplateNode newSTTemplateNode(JsonObject jsonObject) {
        return new STTemplateNode(jsonObject) {
            @Override
            protected void onRightClick(PInputEvent event, JPopupMenu pop, NodeCanvas canvas, Point mousePosition) {

                super.onRightClick(event, pop, canvas, mousePosition);
            }
        };
    }

    private void tryToParseSTGFile(String name, File file, NodeCanvas canvas, Point mousePosition) {


    }
}
