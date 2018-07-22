package com.nextgen.core.template;

import com.nextgen.core.NodeCanvas;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.piccolo2d.event.PInputEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Collections;

public class TemplateRemoteCanvasImpl extends TemplateRemoteCanvas {
    public TemplateRemoteCanvasImpl(Vertx vertx, Integer port, String host) {
        super(vertx, port, host);
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
                            protected void handleSuccess(String payload) {
                                log.info(payload);
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
}
