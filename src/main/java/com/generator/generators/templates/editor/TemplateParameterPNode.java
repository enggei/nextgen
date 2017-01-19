package com.generator.generators.templates.editor;

import com.generator.editors.canvas.neo.NeoEditor;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.piccolo2d.event.PInputEvent;

import javax.swing.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

import static com.generator.editors.BaseDomainVisitor.getString;
import static com.generator.editors.BaseDomainVisitor.incoming;
import static com.generator.editors.BaseDomainVisitor.other;
import static com.generator.editors.NeoModel.uuidOf;
import static com.generator.generators.templates.editor.TemplateDomain.TemplateRelations.TEMPLATE_PARAMETER;

/**
 * Created 10.01.17.
 */
class TemplateParameterPNode extends TemplateDomainPNode {

    TemplateParameterPNode(Node node, TemplateDomain.TemplateLabels nodeType, String property, NeoEditor editor) {
        super(node, nodeType, property, "64, 64, 64".split(", "), editor);
    }

    @Override
    public void showNodeActions(JPopupMenu pop, PInputEvent event) {
        // not allowed to delete node
        pop.add(hideNode());
    }

    @Override
    public void expand() {
        final Map<UUID, Label> pNodes = new LinkedHashMap<>();
        incoming(node, TEMPLATE_PARAMETER).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), TemplateDomain.TemplateLabels.valueOf(getString(relationship, TemplateDomain.TemplateProperties.relationType.name()))));
        editor.showAndLayout(pNodes, pNode);
    }
}
