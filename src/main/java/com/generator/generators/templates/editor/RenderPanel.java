package com.generator.generators.templates.editor;

import com.generator.editors.canvas.BasePNode;
import com.generator.editors.canvas.neo.NeoEditor;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import static com.generator.editors.BaseDomainVisitor.get;

/**
* goe on 12/29/16.
*/
final class RenderPanel extends JPanel implements PropertyChangeListener {

	private final JTextArea txtEditor = new JTextArea(25, 110);
	private final NeoEditor editor;

	public RenderPanel(NeoEditor editor) {
		super(new BorderLayout());

		this.editor = editor;

		txtEditor.setFont(new Font("Hack", Font.PLAIN, 10));
		txtEditor.setTabSize(3);
		txtEditor.setEditable(false);
		add(new JScrollPane(txtEditor), BorderLayout.CENTER);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		switch (evt.getPropertyName()) {

			case BasePNode.NODE_HIGHLIGHTED: {

				final BasePNode pNode = (BasePNode) evt.getNewValue();

				if (pNode instanceof TemplateDomainCanvas.TemplateDomainPNode) {

					final TemplateDomainCanvas.TemplateDomainPNode templateDomainNode = (TemplateDomainCanvas.TemplateDomainPNode) evt.getNewValue();
					switch (TemplateDomain.TemplateLabels.valueOf(templateDomainNode.getNodeType())) {

						case TemplateGroup:
							editor.doInTransaction(tx -> {
								txtEditor.setText(TemplateDomain.asSTGString(templateDomainNode.node));
								txtEditor.setCaretPosition(0);
							});
							break;

						case TemplateStatement:
							editor.doInTransaction(tx -> {
								txtEditor.setText(get(templateDomainNode.node, TemplateDomain.TemplateProperties.text.name()));
								txtEditor.setCaretPosition(0);
							});
							break;
						case SingleTemplateParameter:
							break;
						case ListTemplateParameter:
							break;
						case KeyValueTemplateParameter:
							break;

						case Statement:
							editor.doInTransaction(tx -> {
								txtEditor.setText(TemplateDomain.render(templateDomainNode.node));
								txtEditor.setCaretPosition(0);
							});
							break;

						case SingleValue:
							break;

						case KeyValueSet:
							break;

						case Project:
							break;

						case Directory:
							break;
					}

				} else {
					txtEditor.setText(pNode.getNodeType());
					txtEditor.setCaretPosition(0);
				}
				break;
			}
		}
	}
}