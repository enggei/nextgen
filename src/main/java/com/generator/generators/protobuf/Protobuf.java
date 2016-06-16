package com.generator.generators.protobuf;

import com.generator.editors.graph.d2.GraphNode2D;

import javax.swing.*;
import java.awt.event.MouseEvent;

/**
 * goe on 3/26/15.
 */
public class Protobuf {

    public static ProtobufDomainEditor newProtobufDomainEditor(final ProtobufDomain domain) {
        return new ProtobufDomainEditor(domain) {
            @Override
            public void rightClickNoSelect(MouseEvent e, JPopupMenu popupMenu) {
                super.rightClickNoSelect(e, popupMenu);
                popupMenu.add(new ParseProtoFileAction(this));
            }

            @Override
            protected void rightClickFile(MouseEvent mouseEvent, JPopupMenu popupMenu, GraphNode2D targetNode) {
                addVisitor(popupMenu, targetNode, new ProtoFileGenerator(this));
                addVisitor(popupMenu, targetNode, new JavaScriptRequireGenerator(this));
            }
        };
    }
}