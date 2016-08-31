package com.generator.generators.templatesGraphStream;

import com.generator.generators.templatesNeo.TemplatesNeoGraphStream;
import com.generator.util.SwingUtil;
import com.generator.util.WrapLayout;
import org.graphstream.graph.Node;
import org.graphstream.ui.graphicGraph.GraphicElement;
import org.graphstream.ui.swingViewer.ViewPanel;
import org.graphstream.ui.view.Viewer;
import org.graphstream.ui.view.util.DefaultMouseManager;
import org.graphstream.ui.view.util.DefaultShortcutManager;
import org.junit.Test;
import sun.swing.SwingUtilities2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Random;

public class TemplatesGraphStreamTests {

	private static Node selectedNode;

	public static void main(String[] args) {
		// http://graphstream-project.org/doc/Tutorials/Graph-Visualisation/
		System.setProperty("sun.java2d.opengl", "True");
		System.setProperty("org.graphstream.ui.renderer", "org.graphstream.ui.j2dviewer.J2DGraphRenderer");


		final org.graphstream.graph.implementations.SingleGraph graph = new org.graphstream.graph.implementations.SingleGraph("Test");
		graph.addAttribute("ui.quality");
		graph.addAttribute("ui.antialias");


		final TemplatesNeoGraphStream graphStream = new TemplatesNeoGraphStream(graph);

		final Random random = new Random(System.currentTimeMillis());
		for (int i = 0; i < (random.nextInt(20) + 1); i++) {

			final String groupName = "Group" + i;

			final TemplatesNeoGraphStream.NeoGroupClassDeclarationNode neoGroupClassDeclarationNode = graphStream.newNeoGroupClassDeclaration();
			neoGroupClassDeclarationNode.setName(graphStream.newStringNode(groupName));
			neoGroupClassDeclarationNode.setPackageName(graphStream.newStringNode("com.generator.simple"));

			if (i == 0) selectedNode = neoGroupClassDeclarationNode.node();

			for (int j = 0; j < (random.nextInt(10) + 1); j++) {

				final String className = "Statement " + (j + 1);

				// key-value node
				neoGroupClassDeclarationNode.addStatementsValue(neoGroupClassDeclarationNode.newStatementsKeyValue().
					setDeclarationValue(
						graphStream.newDeclaration().                              // statement-node
							setGroupName(graphStream.newStringNode(groupName)).
							setName(graphStream.newStringNode(className)).node()).
					setNameValue(
						graphStream.newStringNode(className)).
					setNewInstanceValue(                     // string-node
						graphStream.newNewInstance().                                 // value-node
							setGroupName(graphStream.newStringNode(groupName)).
							setName(graphStream.newStringNode(className)).node()));

				for (int k = 0; k < (random.nextInt(3)); k++)
					neoGroupClassDeclarationNode.addCommentsValue(graphStream.newStringNode("Comment " + k));
			}
		}

//		graph.display();
		final JFrame frame = new JFrame();

		//If you intend to create some sort of simulation that runs a code continuously on the graph and uses the viewer to display its results, you should work in the Java main thread (created when you launch the program) and comunicate with the viewer GUI.
		//final Viewer viewer = new Viewer(graph, Viewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD);

		// If you plan to do a GUI only program, that is a program that only respond to GUI events (mous clicks, keyboard, etc.) you should work in the GUI thread, using listeners.
		final Viewer viewer = new Viewer(graph, Viewer.ThreadingModel.GRAPH_IN_GUI_THREAD);
		final ViewPanel view = viewer.addDefaultView(false);   // false indicates "no JFrame".

		//todo: remove top- panel, continue, and sort out craph offset later.
		//todo: create dynamic panel for adding (string,boolean,statement, list, keyvalue,list parameters to a template)
		//todo: render panels east of graph, and use graph for selecting one or more nodes/parameters/statements etc. The east-panel will update itself based on selection, for easy editing of properties
		//todo: add layouts to graph, for tree-layout, grid-layout, etc.
		//todo: create cypher- builder based on domain (and constraints)

		final JLabel lbl = new JLabel();
		view.setShortcutManager(new DefaultShortcutManager() {
			@Override
			public void keyPressed(KeyEvent event) {
				super.keyPressed(event);
			}
		});

		final DefaultMouseManager mouseManager = new DefaultMouseManager() {
			@Override
			public void mousePressed(MouseEvent event) {

				curElement = view.findNodeOrSpriteAt(event.getX(), event.getY());

				if (curElement != null) {
					mouseButtonPressOnElement(curElement, event);
				} else {
					x1 = event.getX();
					y1 = event.getY();
					mouseButtonPress(event);
					view.beginSelectionAt(x1, y1);
				}

				final GraphicElement nodeOrSpriteAt = view.findNodeOrSpriteAt(event.getX(), event.getY());
				System.out.println(nodeOrSpriteAt);
				if (nodeOrSpriteAt != null) {
					double pos[] = org.graphstream.algorithm.Toolkit.nodePosition((Node) nodeOrSpriteAt);
					System.out.println(pos[0] + ", " + pos[1] + ", " + pos[2]);
				}
			}
		};
		view.setMouseManager(mouseManager);

		final JPanel buttonPanel = new JPanel(new WrapLayout(FlowLayout.LEFT));
		buttonPanel.add(lbl);
		buttonPanel.setPreferredSize(new Dimension(200, 768));
		buttonPanel.setMaximumSize(new Dimension(200, 768));
		buttonPanel.add(new JButton(new AbstractAction("Set View Center") {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.getCamera().setViewCenter(2, 3, 4);
			}
		}));
		buttonPanel.add(new JButton(new AbstractAction("Set View Percent") {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.getCamera().setViewPercent(0.5);
			}
		}));
		buttonPanel.add(new JButton(new AbstractAction("Reset view") {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.getCamera().resetView();
			}
		}));
		buttonPanel.add(new JCheckBox(new AbstractAction("AutoLayout") {
			@Override
			public void actionPerformed(ActionEvent e) {
				final JCheckBox source = (JCheckBox) e.getSource();
				if (!source.isSelected())
					viewer.disableAutoLayout();
				else
					viewer.enableAutoLayout();
			}
		}));

		SwingUtil.setLookAndFeel_Nimbus();


		frame.getContentPane().add(view, BorderLayout.CENTER);
		frame.getContentPane().add(buttonPanel, BorderLayout.EAST);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(1024, 768));
		frame.setSize(new Dimension(1024, 768));
		SwingUtil.show(frame);
	}

	@Test
	public void testTemplatesGraphStreamGroup() throws IOException {

		System.setProperty("generator.path", "src/main/java/com/generator/generators");
		final TemplatesGraphStreamGroup group = new TemplatesGraphStreamGroup();

		// todo add TemplatesGraphStreamGroup- tests here;


	}

	@Test
	public void testTemplatesGraphStreamNeo() {

		final org.neo4j.graphdb.GraphDatabaseService db = new org.neo4j.graphdb.factory.GraphDatabaseFactory().newEmbeddedDatabase(new java.io.File("src/test/tests/db"));
		final com.generator.editors.domain.NeoModel model = new com.generator.editors.domain.NeoModel(db);

		model.doInTransaction(new com.generator.editors.domain.NeoModel.Committer() {
			@Override
			public void doAction(org.neo4j.graphdb.Transaction tx) throws Throwable {
			}

			@Override
			public void exception(Throwable throwable) {
				throw new RuntimeException(throwable);
			}
		});
	}

	;
} 