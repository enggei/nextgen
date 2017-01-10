package com.generator.generators.templates.editor;

import com.generator.editors.canvas.neo.NeoEditor;
import com.generator.util.SwingUtil;
import org.neo4j.graphdb.*;
import org.piccolo2d.event.PInputEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

import static com.generator.editors.BaseDomainVisitor.other;
import static com.generator.editors.BaseDomainVisitor.outgoing;
import static com.generator.editors.NeoModel.uuidOf;
import static com.generator.generators.templates.editor.TemplateDomain.TemplateLabels.Directory;
import static com.generator.generators.templates.editor.TemplateDomain.TemplateLabels.Project;
import static com.generator.generators.templates.editor.TemplateDomain.TemplateRelations.PROJECT_DIRECTORY;

/**
 * Created 10.01.17.
 */
class ProjectPNode extends TemplateDomainPNode {

    private String lastDir = System.getProperty("user.home");

    ProjectPNode(Node node, String[] defaultColor, NeoEditor editor) {
        super(node, Project, TemplateDomain.TemplateProperties.name.name(), defaultColor, editor);
        pNode.setFont(new Font("Hack", Font.BOLD, 12));
    }

    @Override
    public void expand() {

        final Map<UUID, org.neo4j.graphdb.Label> pNodes = new LinkedHashMap<>();

        outgoing(node, PROJECT_DIRECTORY).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), TemplateDomain.TemplateLabels.Directory));

        editor.showAndLayout(pNodes, pNode);
    }

    @Override
    public void showNodeActions(JPopupMenu pop, PInputEvent event) {
        pop.add(new SetName(TemplateDomain.TemplateProperties.name.name()));
        pop.add(new AddDirectory(event));
        super.showNodeActions(pop, event);
    }

    private class SetName extends NeoEditor.TransactionAction {

        SetName(String name) {
            super("Set " + name, editor.getGraph(), editor.canvas);
        }

        @Override
        public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final String newValue = SwingUtil.showInputDialog("Name", editor.canvas);
            if (newValue == null) return;

            updateView();
        }
    }

    private class AddDirectory extends NeoEditor.TransactionAction {

        private final PInputEvent event;

        AddDirectory(PInputEvent event) {
            super("Add Directory", editor.getGraph(), editor.canvas);
            this.event = event;
        }

        @Override
        public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final File dir = SwingUtil.showOpenDir(editor.canvas, lastDir);
            if (dir == null) return;

            final Node newDirectoryNode = TemplateDomain.newDirectory(editor.getGraph(), dir.getAbsolutePath());
            node.createRelationshipTo(newDirectoryNode, PROJECT_DIRECTORY);

            lastDir = dir.getAbsolutePath();

            editor.show(uuidOf(newDirectoryNode), Directory.name()).
                    setOffset(event);

            updateView();
        }
    }
}
