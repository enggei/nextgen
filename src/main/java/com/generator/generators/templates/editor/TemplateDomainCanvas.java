package com.generator.generators.templates.editor;

import com.generator.editors.NeoModel;
import com.generator.editors.canvas.neo.NeoEditor;
import com.generator.editors.canvas.neo.NeoPNode;
import com.generator.editors.canvas.neo.NeoRelationshipPath;
import com.generator.generators.templateGroup.TemplateGroupGroup;
import com.generator.generators.templates.domain.*;
import com.generator.generators.templates.parser.TemplateFileParser;
import com.generator.util.SwingUtil;
import com.jgoodies.forms.layout.CellConstraints;
import org.neo4j.graphdb.*;
import org.piccolo2d.PNode;
import org.piccolo2d.event.PInputEvent;
import org.piccolo2d.nodes.PText;
import org.piccolo2d.util.PPickPath;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.AbstractTableModel;
import javax.swing.text.DefaultHighlighter;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static com.generator.editors.BaseDomainVisitor.*;
import static com.generator.editors.NeoModel.debugNode;
import static com.generator.editors.NeoModel.uuidOf;
import static com.generator.generators.templates.editor.TemplateDomain.TemplateLabels.*;
import static com.generator.generators.templates.editor.TemplateDomain.TemplateRelations.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import static org.neo4j.graphdb.Direction.INCOMING;
import static org.neo4j.graphdb.Direction.OUTGOING;

/**
 * goe on 12/29/16.
 */
final class TemplateDomainCanvas extends NeoEditor {

	private static String[] getColor(int index) {
		return new String[][]{
			"247, 247, 247".split(", "),
			"64, 64, 64".split(", "),
			"64, 64, 64".split(", "),
			"64, 64, 64".split(", "),
			"64, 64, 64".split(", "),
			"0, 109, 44".split(", "),
			"5, 112, 176".split(", "),
			"0, 68, 27".split(", "),
			"153, 52, 4".split(", ")
		}[index];
	}

	public TemplateDomainCanvas() {

		canvas.setBackground(new Color(Integer.valueOf(getColor(0)[0]), Integer.valueOf(getColor(0)[1]), Integer.valueOf(getColor(0)[2])));

		for (TemplateDomain.TemplateLabels label : TemplateDomain.TemplateLabels.values())
			nodesByLabel.put(label.name(), new LinkedHashSet<>());
	}

	private static void renderProjectMember(final Node node, NeoEditor editor) {
		outgoing(node, DIRECTORY_MEMBER).forEach(new Consumer<Relationship>() {
			@Override
			public void accept(Relationship projectRelation) {

				final String root = getString(node, TemplateDomain.TemplateProperties.name.name());
				final String outputFormat = getString(projectRelation, TemplateDomain.TemplateProperties.outputFormat.name());

				final Node statementNode = other(node, projectRelation);

				switch (outputFormat) {

					case "java": {

						final String packageParameter = getString(projectRelation, TemplateDomain.TemplateProperties.packageName.name());
						final String nameParameter = getString(projectRelation, TemplateDomain.TemplateProperties.name.name());

						new StatementVisitor() {

							private String nameValue;
							private String packageValue;

							@Override
							protected void onSingleValue(String name, Node referenceNode, TemplateDomain.TemplateLabels referenceNodeType) {
								if (nameParameter.equals(name))
									nameValue = TemplateDomain.renderReferenceNode(referenceNode, referenceNodeType);
								else if (packageParameter.equals(name))
									packageValue = TemplateDomain.renderReferenceNode(referenceNode, referenceNodeType);
							}

							@Override
							protected void onStatementEnd() {
								final GeneratedFile generatedFile = GeneratedFile.newJavaFile(root, packageValue, nameValue);
								try {
									generatedFile.write(TemplateDomain.render(statementNode));
								} catch (IOException e1) {
									SwingUtil.showException(editor.canvas, e1);
								}
							}
						}.visitStatement(statementNode);

						break;
					}

					case "other": {

						final String filename = getString(projectRelation, TemplateDomain.TemplateProperties.name.name());

						final GeneratedFile generatedFile = new GeneratedFile(new File(root, filename));
						try {
							generatedFile.write(TemplateDomain.render(statementNode));
						} catch (IOException e1) {
							SwingUtil.showException(editor.canvas, e1);
						}
						break;
					}
				}
			}
		});
	}

	@Override
	public NeoPNode newNode(Node node, String nodetype) {

		if (nodetype == null || nodesByLabel.get(nodetype) == null) return super.newNode(node, null);

		nodesByLabel.get(nodetype).add(uuidOf(node));

		final String[] colorOne = getColor(2);
		final String[] colorTwo = getColor(3);
		final String[] colorThree = getColor(4);
		final String[] colorFour = getColor(5);
		final String[] colorFive = getColor(6);
		final String[] colorSix = getColor(7);
		final String[] colorSeven = getColor(8);

		switch (TemplateDomain.TemplateLabels.valueOf(nodetype)) {

			case TemplateGroup:
				return new TemplateGroupPNode(node, colorOne, TemplateDomainCanvas.this);
			case TemplateStatement:
				return new TemplateStatementPNode(node, colorTwo, TemplateDomainCanvas.this);
			case SingleTemplateParameter:
				return new TemplateParameterPNode(node, SingleTemplateParameter, TemplateDomain.TemplateProperties.name.name(), colorThree, TemplateDomainCanvas.this);
			case ListTemplateParameter:
				return new TemplateParameterPNode(node, ListTemplateParameter, TemplateDomain.TemplateProperties.name.name(), colorThree, TemplateDomainCanvas.this);
			case KeyValueTemplateParameter:
				return new TemplateParameterPNode(node, KeyValueTemplateParameter, TemplateDomain.TemplateProperties.name.name(), colorThree, TemplateDomainCanvas.this);
			case Statement:
				return new StatementPNode(node, other(node, singleOutgoing(node, TEMPLATE_STATEMENT)), colorFive, TemplateDomainCanvas.this);
			case SingleValue:
				return new SingleValuePNode(node, colorFour, TemplateDomainCanvas.this);
			case KeyValueSet:
				return new KeyValueSetPNode(node, new CompositePText(), colorSix, TemplateDomainCanvas.this, other(node, singleOutgoing(node, TEMPLATE_PARAMETER)));
			case Project:
				return new ProjectPNode(node, colorSeven, TemplateDomainCanvas.this);
			case Directory:
				return new DirectoryPNode(node, colorSeven, TemplateDomainCanvas.this);
		}

		throw new IllegalArgumentException("unsupported nodetype: " + nodetype);
	}

	@Override
	protected void addToMenu(JPopupMenu pop, PInputEvent event) {

		final JMenu newMenu = new JMenu("New");
		newMenu.add(new NewProject(event));
		newMenu.add(new NewTestGroup(event));
		newMenu.add(new NewTemplateGroup(event));
		newMenu.add(new ParseTemplateGroup(event));
		pop.add(newMenu);

		final JMenu showMenu = new JMenu("Show");
		graph.getAllLabelsInUse().forEach(new Consumer<org.neo4j.graphdb.Label>() {
			@Override
			public void accept(org.neo4j.graphdb.Label label) {
				showMenu.add(showAllNodesByLabel(label, event));
			}
		});
		pop.add(showMenu);

		final JMenu hideMenu = new JMenu("Hide");
		for (Map.Entry<String, Set<UUID>> entry : nodesByLabel.entrySet()) {
			if (entry.getValue().isEmpty()) continue;
			hideMenu.add(new HideByLabels(TemplateDomain.TemplateLabels.valueOf(entry.getKey())));
		}
		if (hideMenu.getMenuComponentCount() > 0) pop.add(hideMenu);

		super.addToMenu(pop, event);
	}

	private static Relationship setSingleReference(Node referencedNode, Node node, RelationshipType type, NeoEditor editor) throws NeoEditor.CircularStatementException {

		final Relationship existingRelationship = singleOutgoing(node, type);
		if (existingRelationship != null) {
			// if exact relationship already exists, just return this:
			if (existingRelationship.getStartNode().equals(node) && existingRelationship.getEndNode().equals(referencedNode) && type.equals(existingRelationship.getType()))
				return existingRelationship;

			final Node oldReferencedNode = other(node, existingRelationship);
			existingRelationship.delete(); // Neo-editor will catch deleted relationships and update canvas
			// try to delete old node (if its not referenced by anything else anymore)
			try {
				editor.deleteNode(oldReferencedNode);
			} catch (NeoEditor.ReferenceException e) {
				System.out.println("debug: could not remove old single referenced node : " + e.getMessage());
				// ignore
			}
		}

		return addNodeReference(referencedNode, node, type, editor);
	}

	static Relationship addNodeReference(Node referencedNode, Node node, RelationshipType type, NeoEditor editor) throws NeoEditor.CircularStatementException {

		if (referencedNode.hasLabel(Statement) || referencedNode.hasLabel(SingleValue)) {
			// check existing relations and return this if already exists:
			Relationship existingRelation = null;
			for (Relationship relationship : outgoing(node, type)) {
				if (other(node, relationship).equals(referencedNode)) {
					existingRelation = relationship;
					break;
				}
			}
			if (existingRelation != null) return existingRelation;

			// constrain circular statement-relations
			if (node.hasLabel(Statement) && referencedNode.hasLabel(Statement)) {
				for (Relationship relationship : referencedNode.getRelationships(OUTGOING)) {
					if (other(referencedNode, relationship).equals(node))
						throw new NeoEditor.CircularStatementException(node, referencedNode);
				}
			}

			final Relationship newRelationship = node.createRelationshipTo(referencedNode, type);
			newRelationship.setProperty(TemplateDomain.TemplateProperties.relationType.name(), referencedNode.hasLabel(Statement) ? Statement.name() : SingleValue.name());
			return newRelationship;
		}

		throw new IllegalArgumentException("illegal reference type: " + NeoModel.getNameOrLabelFrom(referencedNode));
	}


	@Override
	public void deleteNode(Node node) throws ReferenceException {
		final Set<Relationship> constraints = new LinkedHashSet<>();
		final Consumer<Relationship> constraintVisitor = relationship -> {
			if (relationship.isType(NeoEditor.layoutMember)) return;
			constraints.add(relationship);
		};

		debugRelationsFor(node);

		if (node.hasLabel(TemplateGroup)) {

			node.getRelationships(INCOMING, TEMPLATE_GROUP).forEach(constraintVisitor);
			if (!constraints.isEmpty())
				throw new NeoEditor.ReferenceException(node, constraints);

			// delete all imports
			node.getRelationships(OUTGOING, IMPORT).forEach(new Consumer<Relationship>() {
				@Override
				public void accept(Relationship relationship) {
					relationship.delete();
				}
			});

		} else if (node.hasLabel(TemplateStatement)) {

			final Set<Node> parameterNodes = new LinkedHashSet<>();
			new TemplateGroupVisitor() {
				@Override
				protected void onTemplateStatementStart(String name, String text, Node templateStatement) {
					templateStatement.getRelationships(INCOMING, TEMPLATE_STATEMENT).forEach(constraintVisitor);
				}

				@Override
				protected void onSingleTemplateParameter(String name, Node parameterNode) {
					parameterNode.getRelationships(INCOMING, TEMPLATE_PARAMETER).forEach(constraintVisitor);
					parameterNodes.add(parameterNode);
				}

				@Override
				protected void onListTemplateParameter(String name, Node parameterNode) {
					parameterNode.getRelationships(INCOMING, TEMPLATE_PARAMETER).forEach(constraintVisitor);
					parameterNodes.add(parameterNode);
				}

				@Override
				protected void onKeyValueTemplateParameter(String name, String keys, Node parameterNode) {
					parameterNode.getRelationships(INCOMING, TEMPLATE_PARAMETER).forEach(constraintVisitor);
					parameterNodes.add(parameterNode);
				}
			}.visitTemplateStatement(node);

			if (!constraints.isEmpty())
				throw new NeoEditor.ReferenceException(node, constraints);

			for (Node parameterNode : parameterNodes) {
				singleOutgoing(parameterNode, TEMPLATE_PARAMETER).delete();
				deleteNode(parameterNode);
			}
			singleOutgoing(node, TEMPLATE_GROUP).delete();

		} else if (node.hasLabel(Directory)) {

			incoming(node, DIRECTORY_MEMBER).forEach(Relationship::delete);
			outgoing(node, DIRECTORY_MEMBER).forEach(Relationship::delete);

		} else if (node.hasLabel(Statement)) {

			node.getRelationships(INCOMING).forEach(constraintVisitor);
			if (!constraints.isEmpty())
				throw new NeoEditor.ReferenceException(node, constraints);

			// this will remove all parameter-relations (and recursively try to delete each value, if its only referenced by this statement (not shared))
			// this will also remove the TEMPLATE_STATEMENT reference for this statement
			node.getRelationships(Direction.OUTGOING).forEach(new Consumer<Relationship>() {
				@Override
				public void accept(Relationship relationship) {
					final Node other = other(node, relationship);
					relationship.delete();

					// try to delete any of the parameters for this statement, (if they are only referenced by this)
					if (other.hasLabel(SingleValue) || other.hasLabel(KeyValueSet) || other.hasLabel(Statement)) {
						try {
							deleteNode(other);
						} catch (NeoEditor.ReferenceException e) {
							System.out.println("other node is used elsewhere, ignore " + debugNode(other));
						}
					}
				}
			});

		} else if (node.hasLabel(SingleValue)) {

			node.getRelationships(INCOMING).forEach(constraintVisitor);
			if (!constraints.isEmpty())
				throw new NeoEditor.ReferenceException(node, constraints);

			final Relationship templateRelationship = singleOutgoing(node, TEMPLATE_PARAMETER);
			if (templateRelationship != null) {
				final Node templateParameter = other(node, templateRelationship);
				assert templateParameter != null;

				final RelationshipType parameterType = RelationshipType.withName(get(templateParameter, TemplateDomain.TemplateProperties.name.name()));
				final Relationship relationship = singleIncoming(node, parameterType);
				templateRelationship.delete();
				relationship.delete();
			}

		} else if (node.hasLabel(KeyValueSet)) {

			final Relationship templateRelationship = singleOutgoing(node, TEMPLATE_PARAMETER);
			final Node templateParameter = other(node, templateRelationship);
			assert templateParameter != null;

			templateRelationship.delete();
			final RelationshipType parameterType = RelationshipType.withName(get(templateParameter, TemplateDomain.TemplateProperties.name.name()));
			final Relationship parameterRelation = singleIncoming(node, parameterType);
			if (parameterRelation != null) parameterRelation.delete();

			for (String key : getString(templateParameter, TemplateDomain.TemplateProperties.keys.name()).split(" ")) {
				final Relationship relationship = singleOutgoing(node, RelationshipType.withName(key));
				if (relationship == null) continue;

				final Node other = other(node, relationship);
				relationship.delete();

				// try to delete any of the parameters for this statement, (if they are only referenced by this)
				if (other.hasLabel(SingleValue) || other.hasLabel(KeyValueSet) || other.hasLabel(Statement)) {
					try {
						deleteNode(other);
					} catch (NeoEditor.ReferenceException e) {
						System.out.println("other node is used elsewhere, ignore " + debugNode(other));
					}
				}
			}
		}

		// delete from layouts:
		for (Relationship layout : incoming(node, NeoEditor.layoutMember))
			layout.delete();

		debugRelationsFor(node);

		node.delete();
	}

	private static void debugRelationsFor(final Node node) {
		node.getRelationships(Direction.OUTGOING).forEach(new Consumer<Relationship>() {
			@Override
			public void accept(Relationship relationship) {
				System.out.println(uuidOf(node) + "(" + NeoModel.getNameOrLabelFrom(node) + ") has OUTGOING '" + relationship.getType() + "' to " + NeoModel.getNameOrLabelFrom(other(node, relationship)));
			}
		});

		node.getRelationships(Direction.INCOMING).forEach(new Consumer<Relationship>() {
			@Override
			public void accept(Relationship relationship) {
				if (NeoEditor.layoutMember.equals(relationship.getType())) return;
				System.out.println(uuidOf(node) + "(" + NeoModel.getNameOrLabelFrom(node) + ") has INCOMING '" + relationship.getType() + "' from " + NeoModel.getNameOrLabelFrom(other(node, relationship)));
			}
		});
	}

	private NeoPNode parseTemplateGroupFile(File file, PInputEvent event) {
		final TemplateFile templateFile = new TemplateFileParser().parse(file);

		// create new or use existing node with same name as templategroup:
		final String name = templateFile.getName().replaceAll(".stg", "");
		final Iterator<Node> iterator = getGraph().getAll(TemplateGroup.name(), TemplateDomain.TemplateProperties.name.name(), name).iterator();
		if (iterator.hasNext()) {
			final NeoPNode newTemplateGroupNode = show(uuidOf(iterator.next()), TemplateGroup.name());
			newTemplateGroupNode.setOffset(event);
			return newTemplateGroupNode;
		}

		final Node templateGroup = TemplateDomain.newTemplateGroup(graph, name, templateFile.getDelimiter() + "");

		for (TemplateImport templateImport : templateFile.getImports()) {
			final File templateFileImport = new File(file.getParentFile(), templateImport.getName() + ".stg");
			final NeoPNode imported = parseTemplateGroupFile(templateFileImport, event);
			templateGroup.createRelationshipTo(imported.node, IMPORT);
			show(uuidOf(imported.node), TemplateGroup.name());
		}

		for (com.generator.generators.templates.domain.TemplateStatement templateStatement : templateFile.getStatements())
			importTemplateStatement(templateGroup, templateStatement, this);

		final NeoPNode newTemplateGroupNode = show(uuidOf(templateGroup), TemplateGroup.name());
		newTemplateGroupNode.setOffset(event);
		return newTemplateGroupNode;
	}

	public static Node importTemplateStatement(Node templateGroup, TemplateStatement templateStatement, NeoEditor editor) {

		for (Node next : editor.getGraph().getAll(TemplateStatement.name(), TemplateDomain.TemplateProperties.name.name(), templateStatement.getName())) {
			final Node otherTemplateGroup = other(next, singleOutgoing(next, TEMPLATE_GROUP));
			assert otherTemplateGroup != null;
			if (otherTemplateGroup.equals(templateGroup))
				return next;   // return if template-group is same, and name is same:
		}

		final Node templateStatementNode = TemplateDomain.newTemplateStatement(editor.getGraph(), templateGroup, templateStatement.getName(), templateStatement.getText());

		for (TemplateParameter templateParameter : templateStatement.getParameters()) {
			switch (templateParameter.getDomainEntityType()) {
				case STRINGPROPERTY:
				case BOOLEANPROPERTY:
				case STATEMENTPROPERTY:
					TemplateDomain.newSingleTemplateParameter(editor.getGraph(), templateStatementNode, templateParameter.getPropertyName());
					break;
				case LISTPROPERTY:
					TemplateDomain.newListTemplateParameter(editor.getGraph(), templateStatementNode, templateParameter.getPropertyName());
					break;
				case KEYVALUELISTPROPERTY:
					TemplateDomain.newKeyValueListTemplateParameter(editor.getGraph(), templateStatementNode, templateParameter.getPropertyName(), templateParameter.getKvNames().toArray(new String[templateParameter.getKvNames().size()]));
					break;
			}
		}

		return templateStatementNode;
	}

	static class TemplateDomainPNode extends NeoPNode<PText> {

		protected final Color selectedColor = Color.RED;
		protected final Color defaultColor;
		private final String property;
		final TemplateDomain.TemplateLabels nodeType;

		protected TemplateDomainPNode(Node node, TemplateDomain.TemplateLabels nodeType, String property, String[] defaultColor, NeoEditor editor) {
			super(node, new PText(node.getProperty(property).toString()), nodeType.name(), editor);
			this.defaultColor = new Color(Integer.valueOf(defaultColor[0]), Integer.valueOf(defaultColor[1]), Integer.valueOf(defaultColor[2]));
			this.property = property;
			this.nodeType = nodeType;
			pNode.setTextPaint(this.defaultColor);
			pNode.setFont(new Font("Hack", Font.BOLD, 12));
		}

		protected TemplateDomainPNode(Node node, PText representation, TemplateDomain.TemplateLabels nodeType, String[] defaultColor, NeoEditor editor) {
			super(node, representation, nodeType.name(), editor);
			this.defaultColor = new Color(Integer.valueOf(defaultColor[0]), Integer.valueOf(defaultColor[1]), Integer.valueOf(defaultColor[2]));
			this.property = null;
			this.nodeType = nodeType;
			pNode.setTextPaint(this.defaultColor);
			pNode.setFont(new Font("Hack", Font.PLAIN, 12));
		}

		@Override
		public String getNodeType() {
			return nodeType.name();
		}

		@Override
		public void expand() {

		}

		@Override
		public void showDependents() {

		}

		@Override
		public void keyPressed(PInputEvent event) {
			super.keyPressed(event);
		}

		@Override
		public void updateView() {
			if (property == null) System.out.println("override updateView: property not set");
			pNode.setText(property == null ? "?" : node.getProperty(property).toString());
		}

		@Override
		public void onSelect() {
			pNode.setTextPaint(selectedColor);
		}

		@Override
		public void onUnselect() {
			pNode.setTextPaint(defaultColor);
		}

		@Override
		public void onStartHighlight() {
			pNode.setTextPaint(Color.ORANGE);
		}

		@Override
		public void onEndHighlight() {
			pNode.setTextPaint(selected.get() ? selectedColor : defaultColor);
		}

		@Override
		public void showNodeActions(JPopupMenu pop, PInputEvent event) {

			pop.add(new TransactionAction("Select all " + nodeType, editor.getGraph(), editor.canvas) {
				@Override
				public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
					editor.getAllNodes().forEach(new Consumer<NeoPNode>() {
						@Override
						public void accept(NeoPNode neoPNode) {
							if (neoPNode.getNodeType().equals(nodeType.name()) && !neoPNode.selected.get())
								neoPNode.select();
						}
					});
				}
			});
			pop.add(new TransactionAction("Hide all " + nodeType, editor.getGraph(), editor.canvas) {
				@Override
				public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
					final Set<UUID> hide = new LinkedHashSet<>();
					editor.getAllNodes().forEach(new Consumer<NeoPNode>() {
						@Override
						public void accept(NeoPNode pNode) {
							if (pNode.getNodeType().equals(nodeType.name())) hide.add(pNode.uuid);
						}
					});
					hide.forEach(editor::removeNodeFromCanvas);
				}
			});

			pop.add(retainNode());
			pop.add(hideNode());
			pop.add(deleteNode());
		}
	}

	private static class CompositePText extends PText {

		@Override
		public void layoutChildren() {
			layoutHorizontal();
		}

		private void layoutHorizontal() {
			double xOffset = 0;
			final double yOffset = 0;

			final Iterator i = getChildrenIterator();
			while (i.hasNext()) {
				final PNode each = (PNode) i.next();
				each.setOffset(xOffset, yOffset);
				xOffset += each.getWidth() + 5;
			}
		}

		@Override
		public boolean fullPick(PPickPath pickPath) {
			if (super.fullPick(pickPath)) {
				PNode picked = pickPath.getPickedNode();
				// this code won't work with internal cameras, because it doesn't
				// pop the cameras view transform.
				while (picked != this) {
					pickPath.popTransform(picked.getTransformReference(false));
					pickPath.popNode(picked);
					picked = pickPath.getPickedNode();
				}
				return true;
			}
			return false;
		}
	}

	private class NewProject extends TransactionAction {

		private final PInputEvent event;

		public NewProject(PInputEvent event) {
			super("New Project", graph, canvas);
			this.event = event;
		}

		@Override
		public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

			final String name = SwingUtil.showInputDialog("Name", canvas);
			if (name == null) return;

			show(uuidOf(TemplateDomain.newProject(graph, name)), Project.name()).
				setOffset(event);
		}
	}

	private class NewTestGroup extends TransactionAction {

		private final PInputEvent event;

		public NewTestGroup(PInputEvent event) {
			super("New Testgroup", graph, canvas);
			this.event = event;
		}

		@Override
		public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

			final Node templateGroup = TemplateDomain.newTemplateGroup(graph, "TestGroup", "~");

			// create first templateStatement
			final Node templateStatement1 = TemplateDomain.newTemplateStatement(graph, templateGroup, "TEMPLATE_STATEMENT_1", "Testing single value: [~singleValue~]");
			TemplateDomain.newSingleTemplateParameter(graph, templateStatement1, "singleValue");

			// create second templatestatement
			final Node templateStatement2 = TemplateDomain.newTemplateStatement(graph, templateGroup, "TEMPLATE_STATEMENT_2", "Testing list: [~elements:{it|~it~};separator=\",\"~]");
			TemplateDomain.newListTemplateParameter(graph, templateStatement2, "elements");

			// create third templatestatement
			final Node templateStatement3 = TemplateDomain.newTemplateStatement(graph, templateGroup, "TEMPLATE_STATEMENT_3", "Testing keyvalues: [~keyValues:{it|~it.name~=~it.value~};separator=\",\"~]");
			TemplateDomain.newKeyValueListTemplateParameter(graph, templateStatement3, "keyValues", "name value".split(" "));

			final Node templateStatement4 = TemplateDomain.newTemplateStatement(graph, templateGroup, "TEMPLATE_STATEMENT_4", "keyvalues: [~keyValues:{it|~it.name~=~it.value~};separator=\",\"~]\nlist: [~elements:{it|~it~};separator=\",\"~]\nsingle: [~singleValue~]");
			TemplateDomain.newSingleTemplateParameter(graph, templateStatement4, "singleValue");
			TemplateDomain.newListTemplateParameter(graph, templateStatement4, "elements");
			TemplateDomain.newKeyValueListTemplateParameter(graph, templateStatement4, "keyValues", "name value".split(" "));

			final NeoPNode pNode = show(uuidOf(templateGroup), TemplateGroup.name());
			pNode.setOffset(event);
			pNode.expand();
		}
	}

	private class NewTemplateGroup extends TransactionAction {
		private final PInputEvent event;

		public NewTemplateGroup(PInputEvent event) {
			super("New TemplateGroup", graph, canvas);
			this.event = event;
		}

		@Override
		public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

			final String name = SwingUtil.showInputDialog("Name and delimiter", canvas);
			if (name == null) return;

			if (!name.contains(" ")) {
				SwingUtil.showMessage("Please use [name] [delimiter]\n E.g. java ~", canvas);
				return;
			}

			show(uuidOf(TemplateDomain.newTemplateGroup(graph, name.split(" ")[0], name.split(" ")[1])), TemplateGroup.name()).
				setOffset(event);
		}
	}

	private class ParseTemplateGroup extends TransactionAction {
		private final PInputEvent event;

		public ParseTemplateGroup(PInputEvent event) {
			super("Parse TemplateGroup", graph, canvas);
			this.event = event;
		}

		@Override
		public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

			final File file = SwingUtil.showOpenFile(canvas, "/media/storage/nextgen/src/test/java/com/generator/generators/templates");
			if (file == null || !file.getName().toLowerCase().endsWith(".stg")) return;

			parseTemplateGroupFile(file, event).expand();
		}
	}

	private class HideByLabels extends TransactionAction {
		private final org.neo4j.graphdb.Label label;

		public HideByLabels(org.neo4j.graphdb.Label label) {
			super("Hide " + label, graph, canvas);
			this.label = label;
		}

		@Override
		public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

			final Set<UUID> hide = new LinkedHashSet<>();
			layerNodes.values().forEach(new Consumer<NeoPNode>() {
				@Override
				public void accept(NeoPNode pNode) {
					if (pNode.node.hasLabel(label)) hide.add(pNode.uuid);
				}
			});
			hide.forEach(TemplateDomainCanvas.this::removeNodeFromCanvas);
		}
	}

	protected static class TemplateGroupPNode extends TemplateDomainPNode {

		protected TemplateGroupPNode(Node node, String[] defaultColor, NeoEditor editor) {
			super(node, TemplateGroup, TemplateDomain.TemplateProperties.name.name(), defaultColor, editor);
		}

		@Override
		public void expand() {

			final Map<UUID, org.neo4j.graphdb.Label> pNodes = new LinkedHashMap<>();

			new TemplateGroupVisitor() {
				@Override
				protected void onTemplateStatementStart(String name, String text, Node templateStatement) {
					pNodes.put(uuidOf(templateStatement), TemplateStatement);
				}
			}.visitTemplateGroup(node);

			editor.showAndLayout(pNodes, pNode);
		}

		@Override
		public void showNodeActions(JPopupMenu pop, PInputEvent event) {
			pop.add(new TemplateGroupPNode.NewTemplateStatement(event));
			pop.add(new TemplateGroupPNode.CreateGroupFile());
			pop.add(new TemplateGroupPNode.ToSTGGroup());
			pop.add(new TemplateGroupPNode.ExpandTemplateGroup());
			super.showNodeActions(pop, event);
		}

		private class NewTemplateStatement extends TransactionAction {

			private final PInputEvent event;

			public NewTemplateStatement(PInputEvent event) {
				super("New Templatestatement", editor.getGraph(), editor.canvas);
				this.event = event;
			}

			@Override
			public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
				final String delimiter = get(node, TemplateDomain.TemplateProperties.delimiter.name());
				final TemplateEditor statementEditorPanel = new TemplateEditor(delimiter, "", "", null);
				SwingUtil.showDialogNoDefaultButton(statementEditorPanel, editor.canvas, "Statement", () -> {

					if (statementEditorPanel.txtStatementName.getText().trim().length() == 0)
						throw new IllegalStateException("Statement must have a name");

					final TemplateStatement templateStatement = statementEditorPanel.parseAndValidate(delimiter);
					editor.doInTransaction(tx1 -> {
						final Node importTemplateStatement = importTemplateStatement(node, templateStatement, editor);
						editor.show(uuidOf(importTemplateStatement), TemplateStatement.name()).
							setOffset(event);
					});
				});
			}
		}

		private class CreateGroupFile extends TransactionAction {

			public CreateGroupFile() {
				super("Create group-file", editor.getGraph(), editor.canvas);
			}

			@Override
			public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

				final String packageName = SwingUtil.showInputDialog("Package", editor.canvas, getString(node, TemplateDomain.TemplateProperties.packageName.name()));
				node.setProperty(TemplateDomain.TemplateProperties.packageName.name(), packageName);

				final String groupName = getString(node, TemplateDomain.TemplateProperties.name.name()) + "Group";

				//use pattern in JunitGroup (stGroupString) and create a self-standing group-file, containing the template. no need for generator.path anymore

				// todo: make templategroup part of neo-graph, and traverse this to render graph (!)
				System.setProperty("generator.path", "src/main/java/com/generator/generators");
				final TemplateGroupGroup group = new TemplateGroupGroup();

				new TemplateGroupVisitor() {

					private TemplateGroupGroup.GroupClassDeclarationST groupClassDeclaration;
					private TemplateGroupGroup.NewStatementDeclarationST declarationST;
					private String statementName;
					private Object setter;

					@Override
					protected void onTemplateGroupStart(String name, String delimiter, Node templateGroup) {
						groupClassDeclaration = group.newGroupClassDeclaration().
							setName(groupName).
							setDomain(name).
							setGroupString(TemplateDomain.asSTGString(templateGroup)).
							setPackageName(packageName);
					}

					@Override
					protected void onTemplateStatementStart(String name, String text, Node templateStatement) {
						declarationST = group.newNewStatementDeclaration().setGroupname(groupName);
						statementName = name;
					}

					@Override
					protected void onTemplateParameterStart(String name) {
						setter = null;
					}

					@Override
					protected void onSingleTemplateParameter(String name, Node parameterNode) {
						setter = group.newStatementStringPropertySetter().setPropertyName(name).setStatementName(statementName);
					}

					@Override
					protected void onListTemplateParameter(String name, Node parameterNode) {
						setter = group.newStatementListPropertySetter().setPropertyName(name).setStatementName(statementName);
					}

					@Override
					protected void onKeyValueTemplateParameter(String name, String keys, Node parameterNode) {
						final TemplateGroupGroup.StatementKeyValueListPropertySetterST kvSetter = group.newStatementKeyValueListPropertySetter().
							setPropertyName(name).
							setStatementName(statementName);
						for (String key : keys.split(" ")) kvSetter.addKvNamesValue(key);
						setter = kvSetter;
					}

					@Override
					protected void onTemplateParameterEnd(String name) {
						declarationST.addPropertiesValue(name, setter);
					}

					@Override
					protected void onTemplateStatementEnd(String name, String text, Node templateStatement) {
						groupClassDeclaration.addStatementsValue(declarationST.setName(statementName), group.newNewStatementInstance().setName(statementName));
					}

					@Override
					protected void onTemplateGroupEnd() {
						SwingUtil.toClipboard(groupClassDeclaration.toString());
					}
				}.visitTemplateGroup(node);
			}
		}

		private class ToSTGGroup extends TransactionAction {

			public ToSTGGroup() {
				super("As STGroup", editor.getGraph(), editor.canvas);
			}

			@Override
			public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
				SwingUtil.toClipboard(TemplateDomain.asSTGString(node));
			}
		}

		private class ExpandTemplateGroup extends TransactionAction {

			public ExpandTemplateGroup() {
				super("Expand", editor.getGraph(), editor.canvas);
			}

			@Override
			public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
				expand();
			}
		}

	}

	private static class TemplateParameterPNode extends TemplateDomainPNode {

		public TemplateParameterPNode(Node node, TemplateDomain.TemplateLabels nodeType, String property, String[] defaultColor, NeoEditor editor) {
			super(node, nodeType, property, defaultColor, editor);
		}

		@Override
		public void showNodeActions(JPopupMenu pop, PInputEvent event) {
			// not allowed to delete node
			pop.add(hideNode());
		}

		@Override
		public void expand() {
			final Map<UUID, org.neo4j.graphdb.Label> pNodes = new LinkedHashMap<>();
			incoming(node, TEMPLATE_PARAMETER).forEach(new Consumer<Relationship>() {
				@Override
				public void accept(Relationship relationship) {
					pNodes.put(uuidOf(other(node, relationship)), TemplateDomain.TemplateLabels.valueOf(getString(relationship, TemplateDomain.TemplateProperties.relationType.name())));
				}
			});
			editor.showAndLayout(pNodes, pNode);
		}
	}

	private static class TemplateStatementPNode extends TemplateDomainPNode {

		public TemplateStatementPNode(Node templateStatement, String[] color, NeoEditor editor) {
			super(templateStatement, TemplateStatement, TemplateDomain.TemplateProperties.name.name(), color, editor);
		}

		@Override
		public void expand() {
			final Map<UUID, org.neo4j.graphdb.Label> pNodes = new LinkedHashMap<>();
			for (Relationship relationship : incoming(node, TEMPLATE_STATEMENT))
				pNodes.put(uuidOf(other(node, relationship)), Statement);
			editor.showAndLayout(pNodes, pNode);
		}

		@Override
		public void showDependents() {
			final Map<UUID, org.neo4j.graphdb.Label> pNodes = new LinkedHashMap<>();
			pNodes.put(uuidOf(other(node, singleOutgoing(node, TEMPLATE_GROUP))), TemplateGroup);
			editor.showAndLayout(pNodes, pNode);
		}

		@Override
		public void showNodeActions(JPopupMenu pop, PInputEvent event) {
			pop.add(new TemplateStatementPNode.NewStatement());
			pop.add(new TemplateStatementPNode.EditTemplateStatment());
			pop.add(new TemplateStatementPNode.ShowStatements());
			pop.add(new TemplateStatementPNode.ShowTemplateGroup());
			pop.add(new TemplateStatementPNode.ShowTemplateParameters());
			pop.add(new TemplateStatementPNode.HideParameters());
			super.showNodeActions(pop, event);
		}

		private class EditTemplateStatment extends TransactionAction {

			public EditTemplateStatment() {
				super("Edit", editor.getGraph(), editor.canvas);
			}

			@Override
			public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

				final Node templateGroup = other(node, singleOutgoing(node, TEMPLATE_GROUP));
				assert templateGroup != null;
				final String delimiter = get(templateGroup, TemplateDomain.TemplateProperties.delimiter.name());
				final String name = getString(node, TemplateDomain.TemplateProperties.name.name());
				final String text = getString(node, TemplateDomain.TemplateProperties.text.name());
				final String statementLabel = getString(node, TemplateDomain.TemplateProperties.statementLabel.name());

				final TemplateEditor statementEditorPanel = new TemplateEditor(delimiter, name, text, statementLabel);
				final JDialog dialog = new JDialog(SwingUtil.getFrame(editor.canvas), "Edit statement", true);
				dialog.add(statementEditorPanel, BorderLayout.CENTER);
				final JPanel commandPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
				commandPanel.add(new JButton(new AbstractAction("Save") {
					@Override
					public void actionPerformed(ActionEvent e) {
						editor.getGraph().doInTransaction(new NeoModel.Committer() {
							@Override
							public void doAction(Transaction tx) throws Throwable {

								if (statementEditorPanel.txtStatementName.getText().trim().length() == 0)
									throw new IllegalStateException("Statement must have a name");

								final TemplateStatement editedStatement = statementEditorPanel.parseAndValidate(delimiter);

								final java.util.List<TemplateParameter> parameters = editedStatement.getParameters();
								final Set<Node> oldParametersToDelete = new LinkedHashSet<>();
								final Set<TemplateParameter> newParameters = new LinkedHashSet<>();
								final Map<Node, String> updatedKeySets = new LinkedHashMap<>();
								final StringBuilder constraints = new StringBuilder();
								new TemplateGroupVisitor() {

									@Override
									protected void onSingleTemplateParameter(String name, Node parameterNode) {

										TemplateParameter found = null;
										for (TemplateParameter templateParameter : parameters) {
											if (!templateParameter.getPropertyName().equals(name)) continue;
											found = templateParameter;

											// same name: check if same type and no dependencies:
											switch (templateParameter.getDomainEntityType()) {
												case LISTPROPERTY:
												case KEYVALUELISTPROPERTY:
													// type changed: only allow if no dependencies:
													if (!hasDependents(parameterNode, constraints)) {
														oldParametersToDelete.add(parameterNode);
														newParameters.add(templateParameter);
													}
													break;
											}
										}

										if (found != null)
											parameters.remove(found);
										else if (!hasDependents(parameterNode, constraints))
											oldParametersToDelete.add(parameterNode);
									}

									@Override
									protected void onListTemplateParameter(String name, Node parameterNode) {

										TemplateParameter found = null;
										for (TemplateParameter templateParameter : parameters) {
											if (!templateParameter.getPropertyName().equals(name)) continue;
											found = templateParameter;

											// same name: check if same type and no dependencies:
											switch (templateParameter.getDomainEntityType()) {
												case STRINGPROPERTY:
												case BOOLEANPROPERTY:
												case STATEMENTPROPERTY:
												case KEYVALUELISTPROPERTY:
													// type changed: only allow if no dependencies:
													if (!hasDependents(parameterNode, constraints)) {
														oldParametersToDelete.add(parameterNode);
														newParameters.add(templateParameter);
													}
													break;
											}
										}

										if (found != null)
											parameters.remove(found);
										else if (!hasDependents(parameterNode, constraints))
											oldParametersToDelete.add(parameterNode);
									}

									@Override
									protected void onKeyValueTemplateParameter(String name, String keys, Node parameterNode) {

										TemplateParameter found = null;
										for (TemplateParameter templateParameter : parameters) {
											if (!templateParameter.getPropertyName().equals(name)) continue;
											found = templateParameter;

											// same name: check if same type and no dependencies:
											switch (templateParameter.getDomainEntityType()) {
												case STRINGPROPERTY:
												case BOOLEANPROPERTY:
												case STATEMENTPROPERTY:
												case LISTPROPERTY:
													// type changed: only allow if no dependencies:
													if (!hasDependents(parameterNode, constraints)) {
														oldParametersToDelete.add(parameterNode);
														newParameters.add(templateParameter);
													}
													break;

												case KEYVALUELISTPROPERTY:

													final Set<String> newKeySet = new LinkedHashSet<>();
													final Set<String> templateKeySet = new LinkedHashSet<>(templateParameter.getKvNames());
													boolean isValid = true;
													for (String oldKey : keys.split(" ")) {

														if (templateKeySet.contains(oldKey)) {
															newKeySet.add(oldKey);
															templateKeySet.remove(oldKey);
															continue;
														}

														// old key missing, only allow if no dependencies:
														if (hasDependents(parameterNode, constraints, oldKey)) {
															isValid = false;
														}
													}

													if (isValid) {
														newKeySet.addAll(templateKeySet);
														final StringBuilder serialized = new StringBuilder();
														for (String newKey : newKeySet)
															serialized.append(" ").append(newKey);
														updatedKeySets.put(parameterNode, serialized.toString().trim());
													}
													break;
											}
										}

										if (found != null)
											parameters.remove(found);
										else if (!hasDependents(parameterNode, constraints))
											oldParametersToDelete.add(parameterNode);
									}
								}.visitTemplateStatement(node);

								if (constraints.length() > 0)
									throw new IllegalArgumentException("cannot change template as it has parameters in use that is not compatible with new parameters: " + constraints);

								// update new key-sets:
								for (Map.Entry<Node, String> kvEntry : updatedKeySets.entrySet())
									kvEntry.getKey().setProperty(TemplateDomain.TemplateProperties.keys.name(), kvEntry.getValue());

								newParameters.addAll(parameters.stream().collect(Collectors.toList()));

								for (TemplateParameter templateParameter : newParameters) {
									switch (templateParameter.getDomainEntityType()) {
										case STRINGPROPERTY:
										case BOOLEANPROPERTY:
										case STATEMENTPROPERTY:
											TemplateDomain.newSingleTemplateParameter(editor.getGraph(), node, templateParameter.getPropertyName());
											break;

										case LISTPROPERTY:
											TemplateDomain.newListTemplateParameter(editor.getGraph(), node, templateParameter.getPropertyName());
											break;

										case KEYVALUELISTPROPERTY:
											TemplateDomain.newKeyValueListTemplateParameter(editor.getGraph(), node, templateParameter.getPropertyName(), templateParameter.getKvNames().toArray(new String[templateParameter.getKvNames().size()]));
											break;
									}
								}

								// delete old parameters
								for (Node oldParameter : oldParametersToDelete) {
									singleOutgoing(oldParameter, TEMPLATE_PARAMETER).delete();
									oldParameter.delete();
								}

								node.setProperty(TemplateDomain.TemplateProperties.name.name(), editedStatement.getName());
								node.setProperty(TemplateDomain.TemplateProperties.text.name(), editedStatement.getText().trim());

								boolean foundStatementLabelParameter = false;
								for (TemplateParameter parameter : editedStatement.getParameters()) {
									if (parameter.getPropertyName().equals(statementEditorPanel.statementLabel)) {
										foundStatementLabelParameter = true;
										node.setProperty(TemplateDomain.TemplateProperties.statementLabel.name(), statementEditorPanel.statementLabel);
										break;
									}
								}
								if (!foundStatementLabelParameter)
									node.removeProperty(TemplateDomain.TemplateProperties.statementLabel.name());

								updateView();
								// for each dependent statement of this template
								incoming(node, TEMPLATE_STATEMENT).forEach(relationship -> {
									final Node statementNode = other(node, relationship);

									incoming(statementNode, DIRECTORY_MEMBER).forEach(projectRelationship -> {
										renderProjectMember(other(statementNode, projectRelationship), editor);
									});
								});

								SwingUtilities.invokeLater(dialog::dispose);
							}

							@Override
							public void exception(Throwable throwable) {
								SwingUtil.showExceptionNoStack(dialog, throwable);
							}
						});
					}
				}));
				commandPanel.add(new JButton(new AbstractAction("Cancel") {
					@Override
					public void actionPerformed(ActionEvent e) {
						SwingUtilities.invokeLater(dialog::dispose);
					}
				}));
				dialog.add(commandPanel, BorderLayout.SOUTH);

				SwingUtil.showDialog(dialog, editor.canvas);
			}

			//todo use Constraints-exception
			// todo turn into Set<Relationship> constraints like deleteNode pattern
			private boolean hasDependents(final Node parameterNode, StringBuilder constraints) {
				final String constraintsAtStart = constraints.toString();
				incoming(parameterNode, TEMPLATE_PARAMETER).forEach(new Consumer<Relationship>() {
					@Override
					public void accept(Relationship relationship) {
						final Node dependentValue = other(parameterNode, relationship);
						constraints.append("\n").append(NeoModel.getNameOrLabelFrom(parameterNode)).append(" (").append(uuidOf(parameterNode)).append(") is used by ").append(NeoModel.getNameOrLabelFrom(dependentValue)).append(" (").append(uuidOf(dependentValue)).append(")");
					}
				});
				return !constraintsAtStart.equals(constraints.toString());
			}

			private boolean hasDependents(final Node parameterNode, StringBuilder constraints, String key) {
				final String constraintsAtStart = constraints.toString();
				incoming(parameterNode, TEMPLATE_PARAMETER).forEach(new Consumer<Relationship>() {
					@Override
					public void accept(Relationship relationship) {
						final Node dependentValue = other(parameterNode, relationship);
						if (dependentValue.hasProperty(key))
							constraints.append("\n").append(NeoModel.getNameOrLabelFrom(parameterNode)).append(" (").append(uuidOf(parameterNode)).append(").").append(key).append(" is used by ").append(NeoModel.getNameOrLabelFrom(dependentValue)).append(" (").append(uuidOf(dependentValue)).append(")");
					}
				});
				return !constraintsAtStart.equals(constraints.toString());
			}
		}

		private class NewStatement extends TransactionAction {

			public NewStatement() {
				super("New " + get(node, TemplateDomain.TemplateProperties.name.name()), editor.getGraph(), editor.canvas);
			}

			@Override
			public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
				editor.
					show(uuidOf(TemplateDomain.newStatement(editor.getGraph(), node)), TemplateDomain.TemplateLabels.Statement.name()).
					setOffset(getRandomPosition());
			}
		}

		private class ShowTemplateGroup extends TransactionAction {

			public ShowTemplateGroup() {
				super("Show TemplateGroup", editor.getGraph(), editor.canvas);
			}

			@Override
			public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
				editor.
					show(uuidOf(other(node, singleOutgoing(node, TEMPLATE_GROUP))), TemplateDomain.TemplateLabels.TemplateGroup.name()).
					setOffset(getRandomPosition());
			}
		}

		private class ShowTemplateParameters extends TransactionAction {

			public ShowTemplateParameters() {
				super("Show parameters", editor.getGraph(), editor.canvas);
			}

			@Override
			public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

				final Map<UUID, org.neo4j.graphdb.Label> pNodes = new LinkedHashMap<>();

				// show parameters
				new TemplateGroupVisitor() {
					@Override
					protected void onSingleTemplateParameter(String name, Node parameterNode) {
						pNodes.put(uuidOf(parameterNode), SingleTemplateParameter);
					}

					@Override
					protected void onListTemplateParameter(String name, Node parameterNode) {
						pNodes.put(uuidOf(parameterNode), ListTemplateParameter);
					}

					@Override
					protected void onKeyValueTemplateParameter(String name, String keys, Node parameterNode) {
						pNodes.put(uuidOf(parameterNode), KeyValueTemplateParameter);
					}

				}.visitTemplateStatement(node);

				editor.showAndLayout(pNodes, pNode);
			}
		}

		private class ShowStatements extends TransactionAction {
			public ShowStatements() {
				super("Expand", editor.getGraph(), editor.canvas);
			}

			@Override
			public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
				expand();
			}
		}

		private class HideParameters extends TransactionAction {
			public HideParameters() {
				super("Hide parameters", editor.getGraph(), editor.canvas);
			}

			@Override
			public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

				new TemplateGroupVisitor() {
					@Override
					protected void onSingleTemplateParameter(String name, Node parameterNode) {
						editor.removeNodeFromCanvas(uuidOf(parameterNode));
					}

					@Override
					protected void onListTemplateParameter(String name, Node parameterNode) {
						editor.removeNodeFromCanvas(uuidOf(parameterNode));
					}

					@Override
					protected void onKeyValueTemplateParameter(String name, String keys, Node parameterNode) {
						editor.removeNodeFromCanvas(uuidOf(parameterNode));
					}

				}.visitTemplateStatement(node);
			}
		}
	}

	private static class StatementPNode extends TemplateDomainPNode {

		private final Node templateStatement;

		public StatementPNode(Node statement, Node templateStatement, String[] color, NeoEditor editor) {
			super(statement, new PText(getString(templateStatement, TemplateDomain.TemplateProperties.name.name())), Statement, color, editor);
			pNode.setFont(new Font("Hack", Font.PLAIN, 11));
			this.templateStatement = templateStatement;
			updateView();
		}

		@Override
		public void updateView() {

			final String property = getString(templateStatement, TemplateDomain.TemplateProperties.statementLabel.name());
			if (property == null) {
				pNode.setText(getString(templateStatement, TemplateDomain.TemplateProperties.name.name()));
				return;
			}

			new StatementVisitor() {

				String label = null;

				@Override
				protected void onSingleValue(String name, Node referenceNode, TemplateDomain.TemplateLabels referenceNodeType) {
					if (property.equals(name))
						pNode.setText(label = TemplateDomain.renderReferenceNode(referenceNode, referenceNodeType));
				}

				@Override
				protected void onStatementEnd() {
					if (label == null)
						pNode.setText(getString(templateStatement, TemplateDomain.TemplateProperties.name.name()));
				}
			}.visitStatement(node);
		}

		@Override
		public void expand() {

			final Map<UUID, org.neo4j.graphdb.Label> pNodes = new LinkedHashMap<>();

			new StatementVisitor() {

				@Override
				protected void onSingleValue(String name, Node referenceNode, TemplateDomain.TemplateLabels referenceNodeType) {
					pNodes.put(uuidOf(referenceNode), referenceNodeType);
				}

				@Override
				protected void onListValue(String name, Node referenceNode, TemplateDomain.TemplateLabels referenceNodeType) {
					pNodes.put(uuidOf(referenceNode), referenceNodeType);
				}

				@Override
				protected void onStartKeyValueSet(String name, Node keyValueNode) {
					pNodes.put(uuidOf(keyValueNode), KeyValueSet);
				}
			}.visitStatement(node);

			editor.showAndLayout(pNodes, pNode);
		}

		@Override
		public void showDependents() {

			final Map<UUID, org.neo4j.graphdb.Label> pNodes = new LinkedHashMap<>();

			for (Relationship relationship : node.getRelationships(INCOMING)) {
				if (layoutMember.equals(relationship.getType())) continue;
				final Node other = other(node, relationship);
				if (hasLabel(other, TemplateDomain.TemplateLabels.Directory.name()))
					pNodes.put(uuidOf(other(node, relationship)), TemplateDomain.TemplateLabels.Directory);
				else
					System.out.println(other.getLabels().iterator().next());
			}

			// also show TemplateStatement (makes logic sense)
			final Relationship relationship = singleOutgoing(node, TEMPLATE_STATEMENT);
			pNodes.put(uuidOf(other(node, relationship)), TemplateDomain.TemplateLabels.TemplateStatement);

			editor.showAndLayout(pNodes, pNode);
		}

		@Override
		public void showNodeActions(JPopupMenu pop, PInputEvent event) {

			final JMenu setMenu = new JMenu("Set");
			final JMenu addMenu = new JMenu("Add");
			final JMenu removeMenu = new JMenu("Remove");
			final AtomicBoolean hasEditableParameters = new AtomicBoolean(false);
			new TemplateGroupVisitor() {
				@Override
				protected void onSingleTemplateParameter(String name, Node templateParameter) {
					setMenu.add(new StatementPNode.SetSingleValue(name, event, templateParameter));
					hasEditableParameters.set(true);
				}

				@Override
				protected void onListTemplateParameter(String name, Node templateParameter) {
					addMenu.add(new StatementPNode.AddListValues(name, templateParameter));
				}

				@Override
				protected void onKeyValueTemplateParameter(String name, String keys, Node templateParameter) {
					addMenu.add(new StatementPNode.AddKeyValueSets(name, event, templateParameter));
				}
			}.visitTemplateStatement(templateStatement);

			new StatementVisitor() {

				@Override
				protected void onSingleValue(String name, Node referenceNode, TemplateDomain.TemplateLabels referenceNodeType) {
					removeMenu.add(new StatementPNode.DetachReference(name, referenceNode, referenceNodeType));
				}

				@Override
				protected void onListValue(String name, Node referenceNode, TemplateDomain.TemplateLabels referenceNodeType) {
					removeMenu.add(new StatementPNode.DetachReference(name, referenceNode, referenceNodeType));
				}
			}.visitStatement(node);

			if (addMenu.getMenuComponentCount() > 0) pop.add(addMenu);
			if (setMenu.getMenuComponentCount() > 0) pop.add(setMenu);
			if (removeMenu.getMenuComponentCount() > 0) pop.add(removeMenu);

			if (hasEditableParameters.get())
				pop.add(new StatementPNode.Edit(event));
			pop.add(new StatementPNode.ExpandStatement());

			pop.add(new StatementPNode.RenderToClipboard());
			pop.add(new StatementPNode.ShowTemplate(event));

			super.showNodeActions(pop, event);
		}

		@Override
		public void showTargetActions(JPopupMenu pop, PInputEvent event) {

			final Collection<NeoPNode> selectedNodes = editor.getSelectedNodes();

			if (selectedNodes.size() != 1) return;

			new TemplateGroupVisitor() {
				@Override
				protected void onSingleTemplateParameter(String name, Node templateParameter) {
					final Node selectedNode = selectedNodes.iterator().next().node;
					if (selectedNode.hasLabel(Statement) || selectedNode.hasLabel(SingleValue))
						pop.add(new StatementPNode.SetSingleReference(name, templateParameter, selectedNode));
				}

				@Override
				protected void onListTemplateParameter(String name, Node templateParameter) {
					final Node selectedNode = selectedNodes.iterator().next().node;
					if (selectedNode.hasLabel(Statement) || selectedNode.hasLabel(SingleValue))
						pop.add(new StatementPNode.AddListReference(name, templateParameter, selectedNode));
				}
			}.visitTemplateStatement(templateStatement);
		}

		private class ExpandStatement extends TransactionAction {

			public ExpandStatement() {
				super("Expand", editor.getGraph(), editor.canvas);
			}

			@Override
			public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
				expand();
			}
		}

		private class SetSingleValue extends TransactionAction {
			private final PInputEvent event;
			private final Node templateParameter;

			public SetSingleValue(String name, PInputEvent event, Node templateParameter) {
				super("Set " + name, editor.getGraph(), editor.canvas);
				this.event = event;
				this.templateParameter = templateParameter;
			}

			@Override
			public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

				final String newValue = SwingUtil.showInputDialog("Value", editor.canvas);
				if (newValue == null) return;

				final Node newSingleValue = TemplateDomain.newSingleValue(editor.getGraph(), newValue);
				setSingleReference(newSingleValue, node, RelationshipType.withName(get(templateParameter, TemplateDomain.TemplateProperties.name.name())), editor);
				// no need for editor.addRelation, as show-method will ensure its visible
				editor.
					show(uuidOf(newSingleValue), SingleValue.name()).
					setOffset(event);
			}
		}

		private class AddListValues extends TransactionAction {
			private final Node templateParameter;

			public AddListValues(String name, Node templateParameter) {
				super(name, editor.getGraph(), editor.canvas);
				this.templateParameter = templateParameter;
			}

			@Override
			public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

				final String newValues = SwingUtil.showInputDialog("Value (for multiple values, separate by space)", editor.canvas);
				if (newValues == null) return;

				final Map<UUID, org.neo4j.graphdb.Label> pNodes = new LinkedHashMap<>();
				for (String newValue : newValues.split(" ")) {

					final Node newListValue = TemplateDomain.newSingleValue(editor.getGraph(), newValue);
					addNodeReference(newListValue, node, RelationshipType.withName(get(templateParameter, TemplateDomain.TemplateProperties.name.name())), editor);
					// no need for editor.addRelation, as show-method will ensure its visible
					pNodes.put(uuidOf(newListValue), SingleValue);
				}

				editor.showAndLayout(pNodes, pNode);
			}
		}

		private class DetachReference extends TransactionAction {

			private final Node referencedNode;

			public DetachReference(String name, Node referencedNode, TemplateDomain.TemplateLabels nodeType) {
				super("Remove " + name + " : " + TemplateDomain.renderReferenceNode(referencedNode, nodeType), editor.getGraph(), editor.canvas);
				this.referencedNode = referencedNode;
			}

			@Override
			public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
				node.getRelationships(Direction.OUTGOING).forEach(new Consumer<Relationship>() {
					@Override
					public void accept(Relationship relationship) {
						if (other(node, relationship).equals(referencedNode))
							relationship.delete();
					}
				});
			}
		}

		private class AddKeyValueSets extends TransactionAction {
			private final PInputEvent event;
			private final Node templateParameter;

			public AddKeyValueSets(String name, PInputEvent event, Node templateParameter) {
				super(name, editor.getGraph(), editor.canvas);
				this.event = event;
				this.templateParameter = templateParameter;
			}

			@Override
			public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

				final String[] keys = getString(templateParameter, TemplateDomain.TemplateProperties.keys.name()).split(" ");
				final java.util.List<Map<String, String>> valueMap = new ArrayList<>(8);
				for (int i = 0; i < 8; i++) valueMap.add(new LinkedHashMap<>());

				final JTable tblValues = new JTable(new AbstractTableModel() {
					@Override
					public int getRowCount() {
						return valueMap.size();
					}

					@Override
					public int getColumnCount() {
						return keys.length;
					}

					@Override
					public Object getValueAt(int rowIndex, int columnIndex) {
						return valueMap.get(rowIndex).get(keys[columnIndex]);
					}

					@Override
					public String getColumnName(int column) {
						return keys[column];
					}

					@Override
					public boolean isCellEditable(int rowIndex, int columnIndex) {
						return true;
					}

					@Override
					public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
						valueMap.get(rowIndex).put(keys[columnIndex], aValue == null ? null : aValue.toString().trim());
						fireTableCellUpdated(rowIndex, columnIndex);
					}

					@Override
					public Class<?> getColumnClass(int columnIndex) {
						return String.class;
					}
				});

				final JPanel contentPanel = new JPanel(new BorderLayout());
				contentPanel.add(new JLabel("Add " + getString(templateParameter, TemplateDomain.TemplateProperties.name.name())));
				contentPanel.add(new JScrollPane(tblValues), BorderLayout.CENTER);
				contentPanel.setPreferredSize(new Dimension(640, 320));
				SwingUtil.showDialog(contentPanel, editor.canvas, "", () -> editor.doInTransaction(tx1 -> {

					final Set<UUID> newKeyValueSets = new LinkedHashSet<>();
					for (Map<String, String> map : valueMap) {

						final Map<String, String> validMap = new LinkedHashMap<>();
						for (String key : keys) {
							final String value = map.get(key);
							if (value == null || value.trim().length() == 0) continue;
							validMap.put(key, value.trim());
						}
						if (validMap.isEmpty()) continue;

						final Node newKeyValueSet = TemplateDomain.newKeyValueSet(editor.getGraph(), node, templateParameter);
						for (Map.Entry<String, String> entry : validMap.entrySet())
							setSingleReference(TemplateDomain.newSingleValue(editor.getGraph(), entry.getValue()), newKeyValueSet, RelationshipType.withName(entry.getKey()), editor);
						newKeyValueSets.add(uuidOf(newKeyValueSet));
					}

					for (UUID newKeyValueSet : newKeyValueSets) {
						editor.
							show(newKeyValueSet, KeyValueSet.name()).
							setOffset(event);
					}

					updateView();
				}));
			}
		}

		private class Edit extends TransactionAction {

			private final PInputEvent event;

			public Edit(PInputEvent event) {
				super("Edit", editor.getGraph(), editor.canvas);
				this.event = event;
			}

			@Override
			public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

				final Node templateStatement = other(node, singleOutgoing(node, TEMPLATE_STATEMENT));

				final Map<String, JTextField> singleValues = new LinkedHashMap<>();
				final Map<String, String> existingValues = new LinkedHashMap<>();
				final Map<String, Node> templateParameters = new LinkedHashMap<>();
				final StringBuilder rows = new StringBuilder();
				final AtomicInteger i = new AtomicInteger(0);
				new TemplateGroupVisitor() {
					@Override
					protected void onSingleTemplateParameter(String name, Node templateParameter) {
						if (i.get() >= 1) rows.append(", 4dlu, ");
						rows.append("pref");
						singleValues.put(name, new JTextField());
						existingValues.put(name, "");
						templateParameters.put(name, templateParameter);
						i.incrementAndGet();
					}
				}.visitTemplateStatement(templateStatement);

				final SwingUtil.FormPanel form = new SwingUtil.FormPanel("50dlu, 4dlu, 150dlu:grow", rows.toString().trim());
				form.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
				new StatementVisitor() {
					@Override
					protected void onSingleValue(String name, Node referenceNode, TemplateDomain.TemplateLabels referenceNodeType) {
						final String value = TemplateDomain.renderReferenceNode(referenceNode, referenceNodeType);
						singleValues.get(name).setText(value);
						existingValues.put(name, value);
					}
				}.visitStatement(node);

				int row = 1;
				for (String key : singleValues.keySet()) {
					form.addLabel(key, 1, row);
					form.add(singleValues.get(key), 3, row);
					row += 2;
				}

				SwingUtil.showDialogNoDefaultButton(form, editor.canvas, "Statement", () -> editor.doInTransaction(tx1 -> {
					for (String singleValueName : singleValues.keySet()) {
						final String newValue = singleValues.get(singleValueName).getText();
						if (!newValue.equals(existingValues.get(singleValueName))) {

							final Node newSingleValue = TemplateDomain.newSingleValue(editor.getGraph(), newValue);
							setSingleReference(newSingleValue, node, RelationshipType.withName(get(templateParameters.get(singleValueName), TemplateDomain.TemplateProperties.name.name())), editor);
							// no need for editor.addRelation, as show-method will ensure its visible
							editor.
								show(uuidOf(newSingleValue), SingleValue.name()).
								setOffset(event);
						}
					}
				}));
			}
		}

		private class ShowTemplate extends TransactionAction {
			private final PInputEvent event;

			public ShowTemplate(PInputEvent event) {
				super("Show Template", editor.getGraph(), editor.canvas);
				this.event = event;
			}

			@Override
			public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
				final Relationship relationship = singleOutgoing(node, TEMPLATE_STATEMENT);
				editor.
					show(uuidOf(other(node, relationship)), TemplateStatement.name()).
					setOffset(event);
			}
		}

		private class RenderToClipboard extends TransactionAction {
			public RenderToClipboard() {
				super("Copy to clipboard", editor.getGraph(), editor.canvas);
			}

			@Override
			public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
				SwingUtil.toClipboard(TemplateDomain.render(node));
			}
		}

		private class SetSingleReference extends TransactionAction {
			private final Node templateParameter;
			private final Node selectedNode;

			public SetSingleReference(String name, Node templateParameter, Node selectedNode) {
				super("Set " + name, editor.getGraph(), editor.canvas);
				this.templateParameter = templateParameter;
				this.selectedNode = selectedNode;
			}

			@Override
			public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
				editor.addRelation(setSingleReference(selectedNode, node, RelationshipType.withName(get(templateParameter, TemplateDomain.TemplateProperties.name.name())), editor));
				updateView();
			}
		}

		private class AddListReference extends TransactionAction {
			private final Node templateParameter;
			private final Node selectedNode;

			public AddListReference(String name, Node templateParameter, Node selectedNode) {
				super("Add " + name, editor.getGraph(), editor.canvas);
				this.templateParameter = templateParameter;
				this.selectedNode = selectedNode;
			}

			@Override
			public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
				editor.addRelation(addNodeReference(selectedNode, node, RelationshipType.withName(get(templateParameter, TemplateDomain.TemplateProperties.name.name())), editor));
				editor.clearMousePosition();
			}
		}
	}

	private static class SingleValuePNode extends TemplateDomainPNode {

		public SingleValuePNode(Node valueNode, String[] color, NeoEditor editor) {
			super(valueNode, new PText(), SingleValue, color, editor);
			pNode.setFont(new Font("Hack", Font.PLAIN, 11));
			updateView();
		}

		@Override
		public void showDependents() {
			final Map<UUID, org.neo4j.graphdb.Label> pNodes = new LinkedHashMap<>();

			for (Relationship relationship : node.getRelationships(INCOMING)) {
				if (layoutMember.equals(relationship.getType())) continue;
				final Node other = other(node, relationship);
				if (hasLabel(other, TemplateDomain.TemplateLabels.Statement.name()))
					pNodes.put(uuidOf(other(node, relationship)), TemplateDomain.TemplateLabels.Statement);
				else if (hasLabel(other, TemplateDomain.TemplateLabels.KeyValueSet.name()))
					pNodes.put(uuidOf(other(node, relationship)), TemplateDomain.TemplateLabels.KeyValueSet);
				else
					System.out.println(other.getLabels().iterator().next());
			}

			editor.showAndLayout(pNodes, pNode);
		}

		@Override
		public void updateView() {
			final String value = getString(node, TemplateDomain.TemplateProperties.value.name());
			pNode.setText(value == null ? SingleValue.name() : (value.length() == 0 ? "EMPTY" : value));
		}

		@Override
		public void showNodeActions(JPopupMenu pop, PInputEvent event) {
			pop.add(new SingleValuePNode.SetValue());
			super.showNodeActions(pop, event);
		}

		private class SetValue extends TransactionAction {
			public SetValue() {
				super("Edit value", editor.getGraph(), editor.canvas);
			}

			@Override
			public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

				final String defaultValue = get(node, TemplateDomain.TemplateProperties.value.name());
				final String newValue = SwingUtil.showInputDialog("Value", editor.canvas, defaultValue);
				if (newValue == null || newValue.trim().equals(defaultValue)) return;

				node.setProperty(TemplateDomain.TemplateProperties.value.name(), newValue.trim());

				// notify any nodes referencing this
				editor.visitRelations(new Consumer<NeoRelationshipPath>() {
					@Override
					public void accept(NeoRelationshipPath neoRelationshipPath) {
						if (!neoRelationshipPath.target.node.equals(node)) return;
						// node is being referred by another visible node, update view on this node:
						neoRelationshipPath.source.updateView();
					}
				});

				updateView();
			}
		}
	}

	private static class KeyValueSetPNode extends TemplateDomainPNode {

		private final Node templateParameter;
		private final Color defaultColor;

		public KeyValueSetPNode(Node keyValueNode, PText pText, String[] color, NeoEditor editor, Node templateParameter) {
			super(keyValueNode, pText, KeyValueSet, color, editor);
			pNode.setFont(new Font("Hack", Font.PLAIN, 11));
			this.templateParameter = templateParameter;

			defaultColor = new Color(Integer.valueOf(color[0]), Integer.valueOf(color[1]), Integer.valueOf(color[2]));
			updateView();
		}

		@Override
		public void expand() {
			final Map<UUID, org.neo4j.graphdb.Label> pNodes = new LinkedHashMap<>();
			for (String key : getString(templateParameter, TemplateDomain.TemplateProperties.keys.name()).split(" ")) {
				final Relationship kvRelation = singleOutgoing(node, RelationshipType.withName(key));
				if (kvRelation == null) continue;
				pNodes.put(uuidOf(other(node, kvRelation)), TemplateDomain.TemplateLabels.valueOf(getString(kvRelation, TemplateDomain.TemplateProperties.relationType.name())));
			}
			editor.showAndLayout(pNodes, pNode);
		}

		@Override
		public void onSelect() {
			super.onSelect();
			for (Object o : pNode.getChildrenReference()) ((PText) o).setTextPaint(selectedColor);
		}

		@Override
		public void onUnselect() {
			super.onUnselect();
			for (Object o : pNode.getChildrenReference()) ((PText) o).setTextPaint(defaultColor);
		}

		@Override
		public void onStartHighlight() {
			super.onStartHighlight();
			for (Object o : pNode.getChildrenReference()) ((PText) o).setTextPaint(Color.ORANGE);
		}

		@Override
		public void onEndHighlight() {
			super.onEndHighlight();
			final Color textPaint = selected.get() ? selectedColor : defaultColor;
			for (Object o : pNode.getChildrenReference()) ((PText) o).setTextPaint(textPaint);
		}

		@Override
		public void updateView() {
			pNode.removeAllChildren();

			for (String key : getString(templateParameter, TemplateDomain.TemplateProperties.keys.name()).split(" ")) {
				final PText keyName = new PText();
				keyName.setFont(new Font("Hack", Font.PLAIN, 11));
				keyName.setTextPaint(selected.get() ? selectedColor : defaultColor);
				pNode.addChild(keyName);

				final Relationship kvRelation = singleOutgoing(node, RelationshipType.withName(key));
				if (kvRelation == null) {
					keyName.setText("[" + key + "]");
					continue;
				}
				keyName.setText(TemplateDomain.renderReferenceNode(other(node, kvRelation), TemplateDomain.TemplateLabels.valueOf(getString(kvRelation, TemplateDomain.TemplateProperties.relationType.name()))));
			}
		}

		@Override
		public void showNodeActions(JPopupMenu pop, PInputEvent event) {

			final JMenu setMenu = new JMenu("Set");
			final JMenu removeMenu = new JMenu("Remove");
			final String[] keys = getString(templateParameter, TemplateDomain.TemplateProperties.keys.name()).split(" ");
			for (String key : keys) {
				setMenu.add(new KeyValueSetPNode.SetKeyValue(key));

				final Relationship kvRelation = singleOutgoing(node, RelationshipType.withName(key));
				if (kvRelation == null) continue;

				final Node kvValue = other(node, kvRelation);
				removeMenu.add(new KeyValueSetPNode.DetachReference(key, kvValue));
			}
			pop.add(setMenu);
			if (removeMenu.getMenuComponentCount() > 0) pop.add(removeMenu);

			pop.add(new KeyValueSetPNode.Expand());
			pop.add(new KeyValueSetPNode.Edit(keys));
			super.showNodeActions(pop, event);
		}

		@Override
		public void showTargetActions(JPopupMenu pop, PInputEvent event) {

			final Collection<NeoPNode> selectedNodes = editor.getSelectedNodes();

			for (String key : getString(templateParameter, TemplateDomain.TemplateProperties.keys.name()).split(" ")) {
				if (selectedNodes.size() == 1) {
					final Node selectedNode = selectedNodes.iterator().next().node;
					if (selectedNode.hasLabel(Statement) || selectedNode.hasLabel(SingleValue)) {
						pop.add(new TransactionAction("Set " + key, editor.getGraph(), editor.canvas) {
							@Override
							public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
								editor.addRelation(setSingleReference(selectedNode, node, RelationshipType.withName(key), editor));
								updateView();
								editor.clearMousePosition();
							}
						});
					}
				}
			}
		}

		private class Expand extends TransactionAction {

			public Expand() {
				super("Expand", editor.getGraph(), editor.canvas);
			}

			@Override
			public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
				expand();
			}
		}

		private class SetKeyValue extends TransactionAction {
			private final String key;

			public SetKeyValue(String key) {
				super("Set " + key, editor.getGraph(), editor.canvas);
				this.key = key;
			}

			@Override
			public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

				final String newValue = SwingUtil.showInputDialog(key + " value", editor.canvas);
				if (newValue == null) return;

				final Node newSingleValue = TemplateDomain.newSingleValue(editor.getGraph(), newValue);
				editor.addRelation(setSingleReference(newSingleValue, node, RelationshipType.withName(key), editor));
				updateView();
			}
		}

		private class DetachReference extends TransactionAction {

			private final Node referencedNode;

			public DetachReference(String key, Node referencedNode) {
				super("Detach " + key, editor.getGraph(), editor.canvas);
				this.referencedNode = referencedNode;
			}

			@Override
			public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
				node.getRelationships(Direction.OUTGOING).forEach(new Consumer<Relationship>() {
					@Override
					public void accept(Relationship relationship) {
						if (other(node, relationship).equals(referencedNode))
							relationship.delete();
					}
				});
				updateView();
			}
		}

		private class Edit extends TransactionAction {

			private final String[] keys;

			public Edit(String[] keys) {
				super("Edit ", editor.getGraph(), editor.canvas);
				this.keys = keys;
			}

			@Override
			public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

				final Map<String, JTextField> txtKeyValues = new LinkedHashMap<>();
				final Map<String, String> existingValues = new LinkedHashMap<>();
				final StringBuilder rows = new StringBuilder();
				for (int i = 0; i < keys.length; i++) {
					if (i >= 1) rows.append(", 4dlu, ");
					rows.append("pref");
					txtKeyValues.put(keys[i], new JTextField());
					existingValues.put(keys[i], "");
				}
				final SwingUtil.FormPanel form = new SwingUtil.FormPanel("50dlu, 4dlu, 150dlu:grow", rows.toString().trim());
				form.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

				for (String key : keys) {
					final Relationship kvRelation = singleOutgoing(node, RelationshipType.withName(key));
					if (kvRelation == null) continue;

					final Node kvValue = other(node, kvRelation);
					final String textValue = TemplateDomain.renderReferenceNode(kvValue, TemplateDomain.TemplateLabels.valueOf(getString(kvRelation, TemplateDomain.TemplateProperties.relationType.name())));
					txtKeyValues.get(key).setText(textValue);
					existingValues.put(key, textValue);
				}

				int row = 1;
				for (String key : keys) {
					form.addLabel(key, 1, row);
					form.add(txtKeyValues.get(key), 3, row);
					row += 2;
				}

				SwingUtil.showDialog(form, editor.canvas, "Edit", () -> editor.doInTransaction(tx1 -> {
					for (String key : keys) {
						final String newValue = txtKeyValues.get(key).getText().trim();
						if (newValue.equals(existingValues.get(key))) continue;

						final Node newSingleValue = TemplateDomain.newSingleValue(editor.getGraph(), newValue);
						editor.addRelation(setSingleReference(newSingleValue, node, RelationshipType.withName(key), editor));
					}

					updateView();
				}));
			}
		}
	}

	protected static class ProjectPNode extends TemplateDomainPNode {

		private String lastDir = System.getProperty("user.home");

		protected ProjectPNode(Node node, String[] defaultColor, NeoEditor editor) {
			super(node, Project, TemplateDomain.TemplateProperties.name.name(), defaultColor, editor);
			pNode.setFont(new Font("Hack", Font.BOLD, 12));
		}

		@Override
		public void expand() {

			final Map<UUID, org.neo4j.graphdb.Label> pNodes = new LinkedHashMap<>();

			outgoing(node, DIRECTORY_MEMBER).forEach(new Consumer<Relationship>() {
				@Override
				public void accept(Relationship relationship) {
					pNodes.put(uuidOf(other(node, relationship)), TemplateDomain.TemplateLabels.Directory);
				}
			});

			editor.showAndLayout(pNodes, pNode);
		}

		@Override
		public void showNodeActions(JPopupMenu pop, PInputEvent event) {
			pop.add(new ProjectPNode.SetName(TemplateDomain.TemplateProperties.name.name()));
			pop.add(new ProjectPNode.AddDirectory(event));
			super.showNodeActions(pop, event);
		}

		private class SetName extends TransactionAction {

			public SetName(String name) {
				super("Set " + name, editor.getGraph(), editor.canvas);
			}

			@Override
			public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

				final String newValue = SwingUtil.showInputDialog("Name", editor.canvas);
				if (newValue == null) return;

				updateView();
			}
		}

		private class AddDirectory extends TransactionAction {

			private final PInputEvent event;

			public AddDirectory(PInputEvent event) {
				super("Add Directory", editor.getGraph(), editor.canvas);
				this.event = event;
			}

			@Override
			public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

				final File dir = SwingUtil.showOpenDir(editor.canvas, lastDir);
				if (dir == null) return;

				final Node newDirectoryNode = TemplateDomain.newDirectory(editor.getGraph(), dir.getAbsolutePath());
				node.createRelationshipTo(newDirectoryNode, DIRECTORY_MEMBER);

				lastDir = dir.getAbsolutePath();

				editor.show(uuidOf(newDirectoryNode), Directory.name()).
					setOffset(event);

				updateView();
			}
		}
	}

	protected static class DirectoryPNode extends TemplateDomainPNode {

		protected DirectoryPNode(Node node, String[] defaultColor, NeoEditor editor) {
			super(node, Directory, TemplateDomain.TemplateProperties.name.name(), defaultColor, editor);
			pNode.setFont(new Font("Hack", Font.BOLD, 12));
		}

		@Override
		public void expand() {

			final Map<UUID, org.neo4j.graphdb.Label> pNodes = new LinkedHashMap<>();

			outgoing(node, DIRECTORY_MEMBER).forEach(new Consumer<Relationship>() {
				@Override
				public void accept(Relationship relationship) {
					pNodes.put(uuidOf(other(node, relationship)), TemplateDomain.TemplateLabels.Statement);
				}
			});

			editor.showAndLayout(pNodes, pNode);
		}

		@Override
		public void showDependents() {
			final Map<UUID, org.neo4j.graphdb.Label> pNodes = new LinkedHashMap<>();

			for (Relationship relationship : node.getRelationships(INCOMING)) {
				if (layoutMember.equals(relationship.getType())) continue;
				final Node other = other(node, relationship);
				if (hasLabel(other, TemplateDomain.TemplateLabels.Project.name()))
					pNodes.put(uuidOf(other(node, relationship)), TemplateDomain.TemplateLabels.Project);
				else
					System.out.println(other.getLabels().iterator().next());
			}

			editor.showAndLayout(pNodes, pNode);
		}

		@Override
		public void showNodeActions(JPopupMenu pop, PInputEvent event) {
			pop.add(new DirectoryPNode.Render());
			pop.add(new DirectoryPNode.CopyPath());
			pop.add(new DirectoryPNode.SetPath());

			outgoing(node, DIRECTORY_MEMBER).forEach(relationship -> {
				final Node statementNode = other(node, relationship);
				pop.add(new TransactionAction("Detach " + NeoModel.getNameOrLabelFrom(statementNode), editor.getGraph(), editor.canvas) {
					@Override
					public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
						relationship.delete();
					}
				});

			});

			super.showNodeActions(pop, event);
		}

		@Override
		public void showTargetActions(JPopupMenu pop, PInputEvent event) {

			editor.getSelectedNodes().
				stream().
				filter(selectedPNode -> selectedPNode.node.hasLabel(Statement)).
				forEach(selectedPNode -> setFileTypes(selectedPNode.node, null));

			SwingUtilities.invokeLater(editor.canvas::repaint);
		}

		private void setFileTypes(Node statementNode, final Relationship generatorRelation) {

			final String outputFormat = SwingUtil.showSelectDialog(editor.canvas, "Output format", "File outputFormat", Arrays.asList("java", "other"));
			if (outputFormat == null) return;

			switch (outputFormat) {

				case "java": {

					final Set<String> paramsName = new TreeSet<>();
					new TemplateGroupVisitor() {
						@Override
						protected void onSingleTemplateParameter(String name, Node parameterNode) {
							paramsName.add(name);
						}
					}.visitTemplateStatement(other(statementNode, singleOutgoing(statementNode, TEMPLATE_STATEMENT)));

					final String packageParam = SwingUtil.showSelectDialog(editor.canvas, "Package", "Select parameter value", paramsName);
					if (packageParam == null) return;

					final String classnameParam = SwingUtil.showSelectDialog(editor.canvas, "Classname", "Select parameter value", paramsName);
					if (classnameParam == null) return;

					if (generatorRelation == null)
						editor.addRelation(setRenderJavaFile(packageParam, classnameParam, node.createRelationshipTo(statementNode, DIRECTORY_MEMBER)));
					else
						setRenderJavaFile(packageParam, classnameParam, generatorRelation);
					break;
				}

				case "other": {

					final String filename = SwingUtil.showInputDialog("Filename, with extension", editor.canvas);
					if (filename == null) return;

					if (generatorRelation == null)
						editor.addRelation(setRenderOtherFile(filename, node.createRelationshipTo(statementNode, DIRECTORY_MEMBER)));
					else
						setRenderOtherFile(filename, generatorRelation);
					break;
				}
			}
		}

		private static Relationship setRenderOtherFile(String filename, Relationship newRelation) {
			newRelation.setProperty(TemplateDomain.TemplateProperties.outputFormat.name(), "other");
			newRelation.setProperty(TemplateDomain.TemplateProperties.name.name(), filename);
			return newRelation;
		}

		private static Relationship setRenderJavaFile(String packageParam, String classnameParam, Relationship newRelation) {
			newRelation.setProperty(TemplateDomain.TemplateProperties.outputFormat.name(), "java");
			newRelation.setProperty(TemplateDomain.TemplateProperties.packageName.name(), packageParam);
			newRelation.setProperty(TemplateDomain.TemplateProperties.name.name(), classnameParam);
			return newRelation;
		}

		private class SetPath extends TransactionAction {

			public SetPath() {
				super("Set path ", editor.getGraph(), editor.canvas);
			}

			@Override
			public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

				final File dir = SwingUtil.showOpenDir(editor.canvas, getString(node, TemplateDomain.TemplateProperties.name.name()));
				if (dir == null) return;

				node.setProperty(TemplateDomain.TemplateProperties.name.name(), dir.getAbsolutePath());

				updateView();
			}
		}

		private class CopyPath extends TransactionAction {

			public CopyPath() {
				super("Copy path ", editor.getGraph(), editor.canvas);
			}

			@Override
			public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
				SwingUtil.toClipboard(getString(node, TemplateDomain.TemplateProperties.name.name()));
			}
		}

		private class Render extends TransactionAction {

			public Render() {
				super("Render", editor.getGraph(), editor.canvas);
			}

			@Override
			public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
				renderProjectMember(node, editor);
			}
		}
	}

	private static class TemplateEditor extends SwingUtil.FormPanel {

		final JTextField txtStatementName = new JTextField();
		final JTextArea txtEditor = new JTextArea();
		final Border defaultBorder = txtEditor.getBorder();
		final JTable tblParameters = new JTable();
		final JButton btnSetStatementLabel = new JButton();
		final java.util.List<TemplateParameter> parameters = new ArrayList<>();

		private String statementLabel;

		public TemplateEditor(String delimiter, String name, String text, String initLabel) {
			super("50dlu, 4dlu, 350dlu:grow", "pref, 4dlu, 225dlu:grow, 4dlu, 66dlu, 4dlu, pref");

			int row = 1;
			addLabel("Name", 1, row);
			add(txtStatementName, 3, row);

			row += 2;
			addLabel("Text", 1, row, CellConstraints.LEFT, CellConstraints.TOP);
			addScrollPane(txtEditor, 3, row, 1, 1);

			row += 2;
			addLabel("Parameters", 1, row, CellConstraints.LEFT, CellConstraints.TOP);
			addScrollPane(tblParameters, 3, row, 1, 1);

			row += 2;
			addLabel("Label", 1, row).setToolTipText("Which Parameter-value to use as label for statements based on this template");
			add(btnSetStatementLabel, 3, row);

			txtEditor.setFont(new Font("Hack", Font.PLAIN, 10));
			txtEditor.setTabSize(3);
			txtStatementName.setText(name);
			txtEditor.setText(text);
			txtEditor.setCaretPosition(0);

			this.statementLabel = initLabel;
			btnSetStatementLabel.setText(this.statementLabel == null ? "NOT SET" : this.statementLabel);
			btnSetStatementLabel.setToolTipText("Select Parameter to use as label for statement based on this template");

			final DefaultHighlighter.DefaultHighlightPainter paramsHighlighter = new DefaultHighlighter.DefaultHighlightPainter(new Color(255, 127, 0));

			txtEditor.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent ke) {

					if (ke.getKeyCode() == KeyEvent.VK_ENTER && ke.getModifiers() == KeyEvent.CTRL_MASK) {
						try {
							parseAndValidate(delimiter);
						} catch (Exception e) {
							SwingUtil.showException(txtEditor, e);
						}

					} else if (ke.getKeyCode() == KeyEvent.VK_L && ke.getModifiers() == KeyEvent.CTRL_MASK) {
						insertListProperty();

					} else if (ke.getKeyCode() == KeyEvent.VK_I && ke.getModifiers() == KeyEvent.CTRL_MASK) {
						insertIf();

					} else if (ke.getKeyCode() == KeyEvent.VK_SPACE && ke.getModifiers() == KeyEvent.CTRL_MASK) {
						insertSimpleProperty();

					} else if (ke.getKeyCode() == KeyEvent.VK_R && ke.getModifiers() == KeyEvent.CTRL_MASK) {
						replaceAndInsertProperty();

					} else if (ke.getKeyCode() == KeyEvent.VK_M && ke.getModifiers() == KeyEvent.CTRL_MASK) {
						makeMethod();

					} else if (ke.getKeyCode() == KeyEvent.VK_DELETE && ke.getModifiers() == KeyEvent.SHIFT_MASK) {
						deleteCurrentLine();
					}
				}

				private void makeMethod() {
					final String selected = txtEditor.getSelectedText();
					if (selected == null || selected.length() < 1) return;
					System.out.println(selected);
				}

				private void replaceAndInsertProperty() {
					final String selected = txtEditor.getSelectedText();
					if (selected == null || selected.length() < 1) return;

					final String propertyName = SwingUtil.showInputDialog("propertyName", txtEditor);
					if (propertyName == null) return;

					final String replacement = delimiter + propertyName + delimiter;
					txtEditor.setText(txtEditor.getText().replaceAll(selected, (delimiter.equals("$") ? replacement.replaceAll("\\$", "\\\\\\$") : replacement)));
					SwingUtil.tryToHighlight(txtEditor, Arrays.asList(replacement), paramsHighlighter);
				}

				private void insertSimpleProperty() {
					SwingUtilities.invokeLater(() -> {

						removeSelectedTextIfAny();

						final int caretPosition = txtEditor.getCaretPosition();
						txtEditor.insert(delimiter + "" + delimiter, caretPosition);
						txtEditor.setCaretPosition(caretPosition + 1);
					});
				}

				private void insertListProperty() {

					final String input = SwingUtil.showInputDialog(TemplateDomain.TemplateProperties.name.name(), txtEditor);
					if (input == null) return;

					final String name = input.contains(" ") ? input.split(" ")[0] : input.trim();
					final String separator = input.contains(" ") ? input.split(" ")[1] : null;

					SwingUtilities.invokeLater(() -> {

						removeSelectedTextIfAny();

						final int caretPosition = txtEditor.getCaretPosition();
						final String pre = delimiter + name + ":{it|";
						final String sep = separator == null ? "" : ";separator=\"" + separator + "\"";
						final String list = pre + "}" + sep + delimiter;
						txtEditor.insert(list, caretPosition);
						txtEditor.setCaretPosition(caretPosition + pre.length());
					});
				}

				private void removeSelectedTextIfAny() {
					if (txtEditor.getSelectedText() != null) {
						final int selectionStart = txtEditor.getSelectionStart();
						txtEditor.replaceRange("", selectionStart, txtEditor.getSelectionEnd());
						txtEditor.setCaretPosition(selectionStart);
					}
				}

				private void insertIf() {

					final String input = SwingUtil.showInputDialog("condition", txtEditor);
					if (input == null) return;

					final String name = input.trim();

					SwingUtilities.invokeLater(() -> {

						removeSelectedTextIfAny();

						final int caretPosition = txtEditor.getCaretPosition();
						final String pre = delimiter + "if(" + name + ")" + delimiter;
						final String list = pre + delimiter + "endif" + delimiter;
						txtEditor.insert(list, caretPosition);
						txtEditor.setCaretPosition(caretPosition + pre.length());
					});
				}

				private void deleteCurrentLine() {
					final String txt = txtEditor.getText();
					int startOfLine = txtEditor.getCaretPosition();
					while (startOfLine > 0) {

						startOfLine--;

						if (startOfLine < 0) {
							startOfLine++;
							break;
						}

						if (txt.charAt(startOfLine) == '\n') {
							startOfLine++;
							break;
						}
					}

					int endOfLine = startOfLine;
					while (endOfLine < txt.length()) {

						if (endOfLine >= txt.length()) {
							endOfLine = txt.length() - 1;
							break;
						}

						if (txt.charAt(endOfLine) == '\n') {
							break;
						}

						endOfLine++;
					}

					if (endOfLine == startOfLine) {
						endOfLine++;
						if (endOfLine >= txt.length())
							endOfLine = txt.length() - 1;
					}

					if (endOfLine <= startOfLine) return;

					txtEditor.replaceRange("", startOfLine, endOfLine);
				}
			});

			tblParameters.setModel(new AbstractTableModel() {
				@Override
				public int getRowCount() {
					return parameters.size();
				}

				@Override
				public int getColumnCount() {
					return 2;
				}

				@Override
				public Object getValueAt(int rowIndex, int columnIndex) {
					final TemplateParameter templateParameter = parameters.get(rowIndex);
					switch (columnIndex) {
						case 0:
							return parameters.get(rowIndex).getPropertyName();
						case 1:
							return parameters.get(rowIndex).getDomainEntityType();
					}

					return templateParameter;
				}

				@Override
				public String getColumnName(int column) {
					switch (column) {
						case 0:
							return "Name";
						case 1:
							return "Type";
					}
					throw new IllegalArgumentException("Illegal column " + column);
				}
			});

			tblParameters.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					final int selectedRow = tblParameters.getSelectedRow();
					if (selectedRow == -1) return;

					final TemplateParameter templateParameter = parameters.get(selectedRow);

					final String name = templateParameter.getPropertyName();
					final String simple = delimiter + name + delimiter;
					final String formatted = delimiter + name + ";";
					final String list = delimiter + name + ":";
					final String methodCall = delimiter + name + "(";
					final String methodParam = "=" + name;
					final String ifName = delimiter + "if(" + name + ")" + delimiter;
					SwingUtil.tryToHighlight(txtEditor, Arrays.asList(simple, formatted, list, methodCall, methodParam, ifName), paramsHighlighter);
				}
			});

			btnSetStatementLabel.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					SwingUtilities.invokeLater(() -> {
						final Set<String> legalParameters = parameters.stream().filter(parameter -> TemplateEntities.STRINGPROPERTY.equals(parameter.getDomainEntityType())).map(TemplateParameter::getPropertyName).collect(Collectors.toCollection(TreeSet::new));
						final String s = SwingUtil.showSelectDialog(txtEditor, "Select parameter to use as label:", "Parameter label", legalParameters);
						if (s == null) return;
						statementLabel = s;
						btnSetStatementLabel.setText(statementLabel = s);
					});
				}
			});

			// try to parse if default text:
			if (text.length() > 0) {
				try {
					parseAndValidate(delimiter);
				} catch (Exception e) {
					txtEditor.setBorder(BorderFactory.createLineBorder(Color.RED));
				}
			}
		}

		private TemplateStatement parseAndValidate(String delimiter) throws Exception {

			final int oldCaret = txtEditor.getCaretPosition();
			txtEditor.setBorder(defaultBorder);

			final String text = txtEditor.getText();

			// 2 bugfixes: } inside anonymous key-value list
			// and >> inside statement

			final TemplateStatement parsed = new TemplateFileParser().parse(delimiter, txtStatementName.getText().trim(), text);
			if (parsed == null)
				throw new Exception("Unparseable template. Check properties and try again.");

			SwingUtilities.invokeLater(() -> {

				parameters.clear();
				parameters.addAll(parsed.getParameters().stream().collect(Collectors.toList()));

				((AbstractTableModel) tblParameters.getModel()).fireTableDataChanged();

				txtEditor.setText(parsed.getText().trim());
				txtEditor.setCaretPosition(Math.min(text.length(), Math.max(0, oldCaret)));
			});

			return parsed;
		}
	}

	public static void main(String[] args) {

		SwingUtil.setLookAndFeel_Nimbus();

		final JFrame frame = new JFrame();
		final TemplateDomainCanvas contentPanel = new TemplateDomainCanvas();
		final RenderPanel renderPanel = new RenderPanel(contentPanel);
		contentPanel.addPropertyChangeListener(renderPanel);

		frame.getContentPane().add(contentPanel.getCanvas(), BorderLayout.CENTER);
		frame.getContentPane().add(new JScrollPane(renderPanel), BorderLayout.EAST);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.addWindowFocusListener(new WindowAdapter() {
			@Override
			public void windowGainedFocus(WindowEvent e) {
				contentPanel.getCanvas().requestFocusInWindow();
			}
		});

		SwingUtil.show(frame);
	}
}