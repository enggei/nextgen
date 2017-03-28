package com.generator.domain;

import com.generator.editors.canvas.neo.NeoEditor;
import com.generator.editors.canvas.neo.NeoPNode;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.piccolo2d.event.PInputEvent;

import javax.swing.*;

/**
 * Created 18.03.17.
 */
public interface IDomain {

   String getName();

   Label[] values();

   NeoPNode newPNode(Node node, String nodetype, NeoEditor editor);

   void deleteNode(Node node) throws NeoEditor.ReferenceException;

   void addToDomainMenu(final PInputEvent event, final NeoEditor editor, JMenu domainMenu);

}