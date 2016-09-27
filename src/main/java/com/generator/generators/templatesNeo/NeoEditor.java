package com.generator.generators.templatesNeo;

import com.generator.editors.domain.BaseDomainVisitor;
import com.generator.editors.domain.NeoModel;
import com.generator.generators.DefaultAttributeRenderer;
import com.generator.generators.templates.domain.GeneratedFile;
import com.generator.generators.templates.domain.TemplateFile;
import com.generator.generators.templates.domain.TemplateParameter;
import com.generator.generators.templates.domain.TemplateStatement;
import com.generator.generators.templates.parser.TemplateFileParser;
import com.generator.util.FileUtil;
import com.generator.util.SwingUtil;
import org.neo4j.graphdb.*;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.piccolo2d.PLayer;
import org.piccolo2d.PNode;
import org.piccolo2d.event.PBasicInputEventHandler;
import org.piccolo2d.event.PDragEventHandler;
import org.piccolo2d.event.PInputEvent;
import org.piccolo2d.extras.pswing.PSwingCanvas;
import org.piccolo2d.nodes.PPath;
import org.piccolo2d.nodes.PText;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroupFile;

import javax.swing.*;
import javax.swing.text.DefaultHighlighter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.io.File;
import java.util.*;

import static com.generator.editors.domain.BaseDomainVisitor.*;
import static com.generator.generators.templatesNeo.TemplatesNeoNeo.TemplatesNeoLabels.StringNode;

/**
 * goe on 9/12/16.
 */
public class NeoEditor extends JPanel {

	private final PSwingCanvas canvas;

	private final PLayer nodeLayer;
	private final PLayer edgeLayer;

	private GraphDatabaseService graphDatabaseService;

	private final JTextArea txtOutput = new JTextArea(50, 120);
	private NeoModel neoModel;

	public NeoEditor(Dimension preferredSize) {
		super(new BorderLayout(), true);

		// todo: understand camera, and use different cameras as projections of nodes (each with their own coordinates)
		canvas = new PSwingCanvas();
		canvas.setPreferredSize(preferredSize);
		nodeLayer = canvas.getLayer();
		edgeLayer = new PLayer();
		canvas.getCamera().addLayer(0, edgeLayer);
		canvas.removeInputEventListener(canvas.getPanEventHandler());
		canvas.removeInputEventListener(canvas.getZoomEventHandler());
		canvas.addInputEventListener(new PDragEventHandler());

		txtOutput.setFont(new Font("Hack", Font.PLAIN, 10));
		txtOutput.setTabSize(3);
		txtOutput.setEditable(false);

		add(canvas, BorderLayout.CENTER);
		add(createCommandPanel(), BorderLayout.NORTH);
		add(new JScrollPane(txtOutput), BorderLayout.EAST);
	}

	private JPanel createCommandPanel() {

		final JPanel commandPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

		final JButton btnOpenGraph = new JButton(new AbstractAction("Open Graph") {
			@Override
			public void actionPerformed(ActionEvent e) {

				SwingUtilities.invokeLater(() -> {

					final File dbDir = SwingUtil.showOpenDir(commandPanel, "/home/goe/Documents/generatorTests");
					if (dbDir == null) return;

					setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

					FileUtil.tryToCreateDirIfNotExists(dbDir);

					graphDatabaseService = new GraphDatabaseFactory().
						newEmbeddedDatabaseBuilder(dbDir).
						newGraphDatabase();

					neoModel = new NeoModel(graphDatabaseService);

					// create a db-node to access actions for the db:
					final PNode dbNode = newDatabaseNode(commandPanel, dbDir);
					nodeLayer.addChild(dbNode);

					final Point2D.Double canvasCenterPoint = new Point2D.Double(canvas.getWidth() / 2d, canvas.getWidth() / 2d);
					layoutCircle(Collections.singleton(dbNode), canvasCenterPoint, 0);

					setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				});
			}
		});

		commandPanel.add(btnOpenGraph);
		return commandPanel;
	}

	private PNode newDatabaseNode(final JPanel commandPanel, File dbDir) {
		final PNode dbNode = new PText(dbDir.getName());
		dbNode.addInputEventListener(new BaseNodeInputHandler(dbNode) {
			@Override
			protected void addPopupActions(JPopupMenu pop, PInputEvent event) {
				pop.add(new GraphTransactionAction(commandPanel, "Open TemplateFiles") {
					@Override
					public void doAction(Transaction tx) throws Throwable {

						final Set<PNode> nodeSet = new LinkedHashSet<>();

						for (Node templateFileNeoNode : neoModel.getAll("TemplateFile")) {

							final File templateFile = new File(templateFileNeoNode.getProperty("fileReference").toString());
							if (!templateFile.exists()) {
								System.out.println(templateFile.getAbsolutePath() + " does not exist. Not able to create template-file-node.");
								continue;
							}

							final PNode templateFileNode = newTemplateFileNode(new TemplateFileParser().parse(templateFile), templateFileNeoNode);
							nodeLayer.addChild(templateFileNode);
							addLink(dbNode, templateFileNode);

							nodeSet.add(templateFileNode);
						}

						layoutCircle(nodeSet, dbNode.getFullBounds().getCenter2D(), 150d);
					}
				});

				pop.add(new GraphTransactionAction(commandPanel, "Add TemplateFiles") {
					@Override
					public void doAction(Transaction tx) throws Throwable {

						final File searchRoot = SwingUtil.showOpenDir(commandPanel, System.getProperty("generator.root") == null ? System.getProperty("user.home") : System.getProperty("generator.root"));
						if (searchRoot == null) return;

						setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

						final Set<PNode> templateNodes = new LinkedHashSet<>();

						doInTransaction(new SwingCommitter(commandPanel) {
							@Override
							public void doAction(Transaction tx) throws Throwable {

								for (File file : FileUtil.findAllFilesWhichEndsWith(searchRoot.getAbsolutePath(), ".stg")) {

									// see if file is already in database, if so, ignore and continue
									if (!neoModel.getAll("TemplateFile", "fileReference", file.getAbsolutePath()).isEmpty())
										continue;

									// file not found in database:

									// try to parse
									TemplateFile templateFile = new TemplateFileParser().parse(file);
									if (templateFile == null) {
										System.err.println(file.getAbsolutePath() + " is unparseable");
										continue;
									}

									// add to database
									final Node templateFileNeoNode = graphDatabaseService.createNode(Label.label("TemplateFile"));
									templateFileNeoNode.setProperty("fileName", file.getName());
									templateFileNeoNode.setProperty("fileReference", file.getAbsolutePath());

									// add as node
									final PNode templateFileNode = newTemplateFileNode(templateFile, templateFileNeoNode);
									nodeLayer.addChild(templateFileNode);

									addLink(dbNode, templateFileNode);

									templateNodes.add(templateFileNode);
								}
							}
						});

						// layout nodes:
						layoutCircle(templateNodes, dbNode.getFullBounds().getCenter2D(), 150d);

						setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
					}
				});

			}
		});
		return dbNode;
	}

	private PNode newTemplateFileNode(final TemplateFile templateFile, final Node templateFileNeoNode) {

		final PNode templateFileNode = new PText(templateFileNeoNode.getProperty("fileName").toString());

		templateFileNode.addInputEventListener(new BaseNodeInputHandler(templateFileNode) {

			@Override
			protected void addPopupActions(JPopupMenu pop, PInputEvent event) {

				doInTransaction(new SwingCommitter(canvas) {
					@Override
					public void doAction(Transaction tx) throws Throwable {
						for (TemplateStatement templateStatement : templateFile.getStatements()) {

							pop.add(new GraphTransactionAction(canvas, "Load " + templateStatement.getName()) {

								@Override
								public void doAction(Transaction tx) throws Throwable {

									// todo: add check for node already existing:
									for (Node templateNeoNode : neoModel.getAll("TemplateStatement", "statementName", templateStatement.getName())) {
										final PNode graphNode = newNeoStatementNode(templateNeoNode, templateStatement, event, templateFileNeoNode);

										nodeLayer.addChild(graphNode);
										addLink(graphNode, graphNode);
									}
								}
							});

							pop.add(new GraphTransactionAction(canvas, "New " + templateStatement.getName()) {

								@Override
								public void doAction(Transaction tx) throws Throwable {

									final Node templateNeoNode = neoModel.newNode("TemplateStatement");
									templateNeoNode.setProperty("statementName", templateStatement.getName());
									// todo: add uuid for instance

									final PNode graphNode = newNeoStatementNode(templateNeoNode, templateStatement, event, templateFileNeoNode);
									nodeLayer.addChild(graphNode);
									addLink(templateFileNode, graphNode);
								}
							});
						}
					}
				});
			}
		});
		return templateFileNode;
	}

	private PNode newNeoStatementNode(final Node templateNeoNode, final TemplateStatement templateStatement, PInputEvent event, final Node templateFileNeoNode) {

		final PNode graphNode = new PText(templateStatement.getName());
		graphNode.setOffset(event.getPosition());

		graphNode.addInputEventListener(new BaseNodeInputHandler(graphNode) {

			@Override
			protected void leftClick(PInputEvent event) {
				doInTransaction(new SwingCommitter(txtOutput) {
					@Override
					public void doAction(Transaction tx) throws Throwable {

						final String text = render(templateFileNeoNode, templateNeoNode, templateStatement);

						SwingUtilities.invokeLater(() -> {
							txtOutput.setText(text);
							txtOutput.setCaretPosition(0);
						});
					}
				});
			}

			@Override
			public void mouseDragged(PInputEvent event) {
				doInTransaction(new Committer() {
					@Override
					public void doAction(Transaction tx) throws Throwable {
						// todo: make this camera- dependent ? (so a node can have multiple positions)
						final Point2D canvasPosition = event.getCanvasPosition();
						templateNeoNode.setProperty("canvas.position.x", canvasPosition.getX());
						templateNeoNode.setProperty("canvas.position.y", canvasPosition.getY());
					}

					@Override
					public void exception(Throwable throwable) {
						throwable.printStackTrace();
					}
				});
			}

			@Override
			protected void addPopupActions(JPopupMenu pop, PInputEvent event) {

				for (TemplateParameter templateParameter : templateStatement.getParameters()) {
					switch (templateParameter.getDomainEntityType()) {

						case KEYVALUELISTPROPERTY:
							pop.add(new AbstractAction("Add " + templateParameter.getPropertyName()) {
								@Override
								public void actionPerformed(ActionEvent e) {


								}
							});
							break;
						case STRINGPROPERTY:
							pop.add(new AbstractAction("Set " + templateParameter.getPropertyName()) {
								@Override
								public void actionPerformed(ActionEvent e) {

									// attach to existing node somewhere else ?

									// set a singleton-value, either attach to existing node, or make a new:
									SwingUtilities.invokeLater(() -> {

										final String value = SwingUtil.showInputDialog(templateParameter.getPropertyName(), canvas);
										if (value == null) return;

										doInTransaction(new SwingCommitter(canvas) {
											@Override
											public void doAction(Transaction tx) throws Throwable {

												// check if exists, if so, remove
												final RelationshipType relationshipType = RelationshipType.withName(templateStatement.getName() + "_" + templateParameter.getPropertyName());
												if (hasOutgoing(templateNeoNode, relationshipType)) {
													final Relationship relationship = singleOutgoing(templateNeoNode, relationshipType);
													tryToDeleteNode(other(templateNeoNode, relationship));
												}

												final PNode pNode = newStringValueNode(relationshipType, graphNode.getFullBounds().getCenter2D(), value, templateNeoNode);
												nodeLayer.addChild(pNode);
												addLink(graphNode, pNode);

												SwingUtilities.invokeLater(() -> {
													txtOutput.setText(render(templateFileNeoNode, templateNeoNode, templateStatement));
													txtOutput.setCaretPosition(0);
												});
											}
										});
									});
								}
							});
							break;

						case BOOLEANPROPERTY:

							pop.add(new AbstractAction("Set " + templateParameter.getPropertyName()) {
								@Override
								public void actionPerformed(ActionEvent e) {


								}
							});
							break;

						case STATEMENTPROPERTY:

							pop.add(new AbstractAction("Set " + templateParameter.getPropertyName()) {
								@Override
								public void actionPerformed(ActionEvent e) {


								}
							});
							break;

						case LISTPROPERTY:

							pop.add(new AbstractAction("Add " + templateParameter.getPropertyName()) {
								@Override
								public void actionPerformed(ActionEvent e) {


								}
							});
							break;
					}
				}

				pop.add(new AbstractAction("Show template") {
					@Override
					public void actionPerformed(ActionEvent e) {
						SwingUtilities.invokeLater(() -> SwingUtil.showTextResult("Code", templateStatement.toString(), canvas));
					}
				});

				pop.add(new GraphTransactionAction(canvas, "Set root") {
					@Override
					public void doAction(Transaction tx) throws Throwable {
						final String rootDir = BaseDomainVisitor.has(templateNeoNode, "outputDir") ? BaseDomainVisitor.getString(templateNeoNode, "outputDir") : System.getProperty("user.home");
						final File dir = SwingUtil.showOpenDir(canvas, rootDir);
						if (dir == null) return;

						templateNeoNode.setProperty("outputDir", dir.getAbsolutePath());
					}
				});

				// if has root, then generate, if not, set root
				if (BaseDomainVisitor.has(templateNeoNode, "outputDir")) {
					pop.add(new GraphTransactionAction(pop, "Generate") {
						@Override
						public void doAction(Transaction tx) throws Throwable {

							final String text = render(templateFileNeoNode, templateNeoNode, templateStatement);
							final String outputDir = BaseDomainVisitor.getString(templateNeoNode, "outputDir");

							if (BaseDomainVisitor.hasLabel(templateNeoNode, "Java")) {
								final String packageName = BaseDomainVisitor.hasOutgoing(templateNeoNode, RelationshipType.withName("packageName")) ? BaseDomainVisitor.getOtherProperty(templateNeoNode, RelationshipType.withName("packageName"), "value").toString() : "";
								final String className = BaseDomainVisitor.hasOutgoing(templateNeoNode, RelationshipType.withName("className")) ? BaseDomainVisitor.getOtherProperty(templateNeoNode, RelationshipType.withName("name"), "value").toString() : null;
								if (className == null)
									throw new IllegalStateException("className relation must be set for Java-file");
								GeneratedFile.newJavaFile(outputDir, packageName, className).write(text);
							}

							// render as what file ?
						}
					});
				}
			}
		});
		return graphNode;
	}

	private String render(Node templateFileNeoNode, Node templateNeoNode, TemplateStatement templateStatement) {

		// start at template-node, traverse, using Group-code to generate:
		final STGroupFile stGroup = new STGroupFile(templateFileNeoNode.getProperty("fileReference").toString());
		stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());

		final ST template = stGroup.getInstanceOf(templateNeoNode.getProperty("statementName").toString());

		for (TemplateParameter templateParameter : templateStatement.getParameters()) {

			switch (templateParameter.getDomainEntityType()) {
				case KEYVALUELISTPROPERTY:

					break;

				case STRINGPROPERTY:

					// check if exists, if so, remove
					final RelationshipType relationshipType = RelationshipType.withName(templateStatement.getName() + "_" + templateParameter.getPropertyName());
					if (hasOutgoing(templateNeoNode, relationshipType)) {

						// assume this is a stringnode, and get its value:
						final NeoEditor.StringNode stringNode = newStringNode(BaseDomainVisitor.other(templateNeoNode, singleOutgoing(templateNeoNode, relationshipType)));
						template.add(templateParameter.getPropertyName(), stringNode.getValue());
					}

					break;

				case BOOLEANPROPERTY:

					break;

				case STATEMENTPROPERTY:

					break;

				case LISTPROPERTY:

					break;
			}
		}

		return template.render();
	}

	private PNode newStringValueNode(RelationshipType relationshipType, Point2D graphNodeCenter, String value, Node neoNode) {

		final Node stringNeoNode = newStringNode(value, graphDatabaseService);
		neoNode.createRelationshipTo(stringNeoNode, relationshipType);

		final PNode stringNode = new PText(value);
		stringNode.setOffset(graphNodeCenter);
		stringNode.addInputEventListener(new BaseNodeInputHandler(stringNode) {
			@Override
			protected void leftClick(PInputEvent event) {
				SwingUtil.tryToHighlight(txtOutput, Collections.singletonList(value), new DefaultHighlighter.DefaultHighlightPainter(new Color(255, 127, 0)));
			}
		});

		return stringNode;
	}

	private static void layoutCircle(Collection<PNode> pNodes, Point2D centerPoint, double radius) {

		double currentArc = Math.PI;
		double childRadians = (Math.PI * 2 / pNodes.size());

		for (PNode pNode : pNodes) {
			final double sin = Math.sin(currentArc + (childRadians / 2));
			final double cos = Math.cos(currentArc + (childRadians / 2));
			pNode.setOffset(new Point2D.Double(centerPoint.getX() + (radius * sin), centerPoint.getY() + (radius * cos)));
			currentArc += childRadians;
		}
	}

	private void addLink(PNode parent, PNode child) {

		final PPath link = PPath.createLine(parent.getX(), parent.getY(), child.getX(), child.getY());
		link.setPickable(false);
		edgeLayer.addChild(link);

		parent.addPropertyChangeListener(PNode.PROPERTY_FULL_BOUNDS, arg0 -> updateLink(parent, child, link));
		child.addPropertyChangeListener(PNode.PROPERTY_FULL_BOUNDS, arg0 -> updateLink(parent, child, link));
	}

	public void updateLink(PNode node1, PNode node2, PPath link) {
		final Point2D p1 = node1.getFullBoundsReference().getCenter2D();
		final Point2D p2 = node2.getFullBoundsReference().getCenter2D();
		final Line2D line = new Line2D.Double(p1.getX(), p1.getY(), p2.getX(), p2.getY());
		link.reset();
		link.append(line, false);
		link.closePath();
	}

	// base neoNode-input handler
	abstract class BaseNodeInputHandler extends PBasicInputEventHandler {

		private final PNode node;
		protected boolean fIsPressed = false;

		BaseNodeInputHandler(PNode node) {
			this.node = node;
		}

		@Override
		public void keyPressed(PInputEvent event) {
			super.keyPressed(event);
			System.out.println("keypressed");
		}

		@Override
		public void keyReleased(PInputEvent event) {
			super.mousePressed(event);
			fIsPressed = false;
			node.invalidatePaint(); // this tells the framework that the neoNode
			// needs to be redisplayed.
		}

		@Override
		public void keyTyped(PInputEvent event) {
			super.keyTyped(event);
		}

		@Override
		public void mouseClicked(PInputEvent event) {
			super.mouseClicked(event);
		}

		@Override
		public void mousePressed(PInputEvent event) {
			super.mousePressed(event);

			if (event.isRightMouseButton()) {
				SwingUtilities.invokeLater(() -> {
					final JPopupMenu pop = new JPopupMenu();
					addPopupActions(pop, event);

					// transform coordinates:
					final Point2D canvasPosition = event.getCanvasPosition();
					pop.show(canvas, (int) canvasPosition.getX(), (int) canvasPosition.getY());
				});

			} else if (event.isLeftMouseButton()) {
				fIsPressed = true;
				node.invalidatePaint(); // this tells the framework that the neoNode needs to be redisplayed.
				SwingUtilities.invokeLater(() -> leftClick(event));
			}
		}

		protected void leftClick(PInputEvent event) {

		}

		protected void addPopupActions(JPopupMenu pop, PInputEvent event) {

		}

		@Override
		public void mouseDragged(PInputEvent event) {
			super.mouseDragged(event);
		}

		@Override
		public void mouseEntered(PInputEvent event) {
			super.mouseEntered(event);
		}

		@Override
		public void mouseExited(PInputEvent event) {
			super.mouseExited(event);
		}

		@Override
		public void mouseMoved(PInputEvent event) {
			super.mouseMoved(event);
		}

		@Override
		public void mouseReleased(PInputEvent event) {
			super.mouseReleased(event);
		}

		@Override
		public void mouseWheelRotated(PInputEvent event) {
			super.mouseWheelRotated(event);
			System.out.println("rotated");
		}

		@Override
		public void mouseWheelRotatedByBlock(PInputEvent event) {
			super.mouseWheelRotatedByBlock(event);
			System.out.println("rotatedByBlock");
		}

		@Override
		public void keyboardFocusGained(PInputEvent event) {
			super.keyboardFocusGained(event);
			System.out.println("focusGainedKeyboard");
		}

		@Override
		public void keyboardFocusLost(PInputEvent event) {
			super.keyboardFocusLost(event);
			System.out.print("focusGainedKeyboard");
		}
	}

	// action executed in a graph-transaction
	abstract class GraphTransactionAction extends AbstractAction implements Committer {

		private final Component parent;

		GraphTransactionAction(Component parent, String name) {
			super(name);
			this.parent = parent;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			SwingUtilities.invokeLater(() -> doInTransaction(GraphTransactionAction.this));
		}

		@Override
		public void exception(Throwable throwable) {
			SwingUtil.showException(parent, throwable);
		}
	}

	// convenience class which shows exception as dialog over the component
	abstract static class SwingCommitter implements Committer {

		final Component component;

		SwingCommitter(Component component) {
			this.component = component;
		}

		@Override
		public void exception(Throwable throwable) {
			SwingUtil.showException(throwable, component);
		}
	}

	interface Committer {

		void doAction(Transaction tx) throws Throwable;

		void exception(Throwable throwable);
	}

	void doInTransaction(Committer committer) {
		try (Transaction tx = graphDatabaseService.beginTx()) {
			try {
				setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
				committer.doAction(tx);
				tx.success();
				setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			} catch (Throwable throwable) {
				setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				committer.exception(throwable);
				tx.failure();
			}
		}
	}

	// convenience-method for instantiating a new StringNode, and setting the value
	public Node newStringNode(String value, GraphDatabaseService graph) {
		if (value == null) throw new IllegalArgumentException("value for newStringNode cannot be null");

		final Node node = graph.createNode(StringNode);
		node.setProperty("uuid", UUID.randomUUID().toString());
		return newStringNode(node).setValue(value).node();
	}

	public static StringNode newStringNode(Node node) {
		if (node == null) throw new IllegalArgumentException("node for newStringNode cannot be null");

		final UUID uuid = UUID.fromString(getString(node, "uuid"));

		return new StringNode() {
			@Override
			public StringNode setValue(String value) {
				node.setProperty("value", value);
				return this;
			}

			@Override
			public String getValue() {
				return getString(node, "value");
			}

			@Override
			public Node node() {
				return node;
			}

			@Override
			public UUID getUuid() {
				return uuid;
			}

			@Override
			public boolean equals(Object o) {
				if (this == o) return true;
				if (o == null || getClass() != o.getClass()) return false;
				StringNode that = (StringNode) o;
				return uuid.equals(that.getUuid());
			}

			@Override
			public int hashCode() {
				return uuid.hashCode();
			}

			@Override
			public String toString() {
				return getValue();
			}
		};
	}

	public interface StringNode {

		public StringNode setValue(String value);

		public String getValue();

		public Node node();

		public UUID getUuid();
	}

	public static void main(String[] args) {
		System.setProperty("generator.root", "src/main/java/com/generator/generators");
		SwingUtil.showPanel(new NeoEditor(new Dimension(1024, 768)));
	}
}