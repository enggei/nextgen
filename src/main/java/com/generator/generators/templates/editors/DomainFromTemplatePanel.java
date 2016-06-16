package com.generator.generators.templates.editors;

import com.generator.generators.generatorDomain.GeneratorDomainGroup;
import com.generator.generators.templates.domain.TemplateFile;
import com.generator.generators.templates.domain.TemplateParameter;
import com.generator.generators.templates.domain.TemplateStatement;

import javax.swing.*;
import java.awt.*;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

import static com.generator.generators.templates.domain.GeneratedFile.newJavaFile;
import static com.generator.generators.templates.domain.GeneratedFile.pathToPackage;
import static com.generator.util.FileUtil.write;
import static com.generator.util.StringUtil.capitalize;
import static com.generator.util.StringUtil.indexAfter;

/**
 * goe on 6/14/16.
 */
public class DomainFromTemplatePanel extends JPanel {

	private final TemplateFile templateFile;

	private final JTextField txtRoot = new JTextField(15);
	private final JTextField txtPackage = new JTextField(15);
	private final JTextField txtComments = new JTextField(15);

	private final Map<String, StatementPanel> statementPanels = new ConcurrentHashMap<>();

	public DomainFromTemplatePanel(TemplateFile templateFile, String root) {
		super(new BorderLayout());

		this.templateFile = templateFile;

		txtRoot.setText(root);
		final String path = templateFile.getFile().getAbsolutePath();
		txtPackage.setText(pathToPackage(path.substring(indexAfter(root, path), path.lastIndexOf(templateFile.getName()) - 1)));

		final JPanel north = new JPanel(new com.generator.util.WrapLayout());
		north.add(new JLabel("Root"));
		north.add(txtRoot);
		north.add(new JLabel("Package"));
		north.add(txtPackage);
		north.add(new JLabel("Comments"));
		north.add(txtComments);
		add(north, BorderLayout.NORTH);

		final ButtonGroup rootGroup = new ButtonGroup();
		final JTabbedPane center = new JTabbedPane();
		for (TemplateStatement templateStatement : templateFile.getStatements()) {
			statementPanels.put(templateStatement.getName(), new StatementPanel(templateStatement, rootGroup));
			center.add(templateStatement.getName(), statementPanels.get(templateStatement.getName()));
		}
		add(center, BorderLayout.CENTER);
	}

	public void generateDomain() {

		final GeneratorDomainGroup group = new GeneratorDomainGroup();

		final String groupName = capitalize(templateFile.getName().substring(0, templateFile.getName().length() - 4));
		final String domainName = groupName + "Domain";

		final GeneratorDomainGroup.domainST domainST = group.newdomain().
			setName(domainName).
			setPackage(txtPackage.getText()).
			setComments(txtComments.getText());

		final GeneratorDomainGroup.editorST editorST = group.neweditor().
			setName(domainName).
			setPackage(txtPackage.getText()).
			setComments(txtComments.getText());

		for (StatementPanel statementPanel : statementPanels.values()) {
			statementPanel.generateDomain(group, domainST);
			statementPanel.generateEditor(group, editorST, groupName);
		}

		write(domainST, newJavaFile(txtRoot.getText(), txtPackage.getText(), domainName).getFile());
		write(editorST, newJavaFile(txtRoot.getText(), txtPackage.getText(), domainName + "Editor").getFile());
	}

	private final class StatementPanel extends JPanel {

		private final TemplateStatement templateStatement;
		private final JRadioButton isRoot;

		public StatementPanel(TemplateStatement templateStatement, ButtonGroup rootGroup) {
			super(new BorderLayout());
			this.templateStatement = templateStatement;

			isRoot = new JRadioButton("Root", rootGroup.getButtonCount() == 0);
			rootGroup.add(isRoot);
			add(isRoot, BorderLayout.NORTH);

			final JPanel center = new JPanel(new GridLayout(templateStatement.getParameters().size(), 1));
			for (TemplateParameter parameter : templateStatement.getParameters()) {
				final JPanel parameterPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
				parameterPanel.add(new JLabel(parameter.getDomainEntityType() + " : "));
				parameterPanel.add(new JLabel(parameter.getPropertyName()));

				switch (parameter.getDomainEntityType()) {

					case STRINGPROPERTY:
						break;

					case LISTPROPERTY:

						final Vector<TemplateStatement> templateStatements = new Vector<>(templateFile.getStatements());
						final JComboBox<TemplateStatement> statements = new JComboBox<>(templateStatements);
						statements.setRenderer(new DefaultListCellRenderer() {
							@Override
							public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
								final JLabel lbl = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
								lbl.setText(((TemplateStatement)value).getName());
								return lbl;
							}
						});
						parameterPanel.add(statements);

						break;

					case KEYVALUELISTPROPERTY:
						break;

					case STATEMENTPROPERTY:
						break;
				}

				center.add(parameterPanel);
			}
			add(center, BorderLayout.CENTER);
		}

		public void generateDomain(GeneratorDomainGroup stGroup, GeneratorDomainGroup.domainST domainST) {

			if (isRoot.isSelected()) domainST.setRoot(templateStatement.getName());

			final GeneratorDomainGroup.addEntityST addEntityST = stGroup.newaddEntity().
				setName(templateStatement.getName());

			final GeneratorDomainGroup.entityDeclarationST declaration_ = stGroup.newentityDeclaration().
				setName(templateStatement.getName());

			for (TemplateParameter templateParameter : templateStatement.getParameters()) {

				switch (templateParameter.getDomainEntityType()) {

					case STRINGPROPERTY:
						final String propertyName = templateParameter.getPropertyName();
						addEntityST.addPropertiesValue(propertyName);
						declaration_.addPropertiesValue(stGroup.newpropertyInstantiation().setName(propertyName).setType("String"));
						break;

					case LISTPROPERTY:
						// todo
						break;

					case KEYVALUELISTPROPERTY:
						// todo
						break;

					case STATEMENTPROPERTY:
						// todo

						break;
				}
			}

			domainST.addEntitiesValue(addEntityST, declaration_, null, null, templateStatement.getName());
		}

		public void generateEditor(GeneratorDomainGroup stGroup, GeneratorDomainGroup.editorST editorST, String groupName) {

			final GeneratorDomainGroup.entityGraphNodeDeclarationST declarationST = stGroup.newentityGraphNodeDeclaration().
				setName(templateStatement.getName());

			final GeneratorDomainGroup.graphEditorDeclarationST editorDeclarationST = stGroup.newgraphEditorDeclaration().
				setName(templateStatement.getName());

			final GeneratorDomainGroup.entityEditorImplementationST editorImplementationST = stGroup.newentityEditorImplementation().
				setName(templateStatement.getName()).
				setDomain(groupName + "Domain");

			final GeneratorDomainGroup.entityGraphNodeImplementationST implementationST = stGroup.newentityGraphNodeImplementation().
				setDomain(groupName + "Domain").
				setName(templateStatement.getName()).
				setGBackground("#8dd3c7").
				setGSelBackground("#8dd3c7").
				setGLabelColor("#b30000").
				setGSelLabelColor("#fee8c8").
				setWidth("22").
				setHeight("20");

			final GeneratorDomainGroup.entityRightClickST rightClickST = stGroup.newentityRightClick().
				setDomain(groupName + "Domain").
				setName(templateStatement.getName());

			editorST.addEntitiesValue(editorDeclarationST, editorImplementationST, declarationST, implementationST, templateStatement.getName(), rightClickST);
		}
	}
}