package com.generator.editors;

import com.generator.editors.domain.MetaDomain;
import com.generator.editors.domain.NeoModel;
import com.generator.editors.graph.d2.GraphNode2D;
import com.generator.generators.easyFlow.*;
import com.generator.generators.generatorDomain.Generator;
import com.generator.generators.generatorDomain.GeneratorDomain;
import com.generator.generators.pante.Pante;
import com.generator.generators.pante.PanteEditor;
import com.generator.generators.protobuf.Protobuf;
import com.generator.generators.protobuf.ProtobufDomain;
import com.generator.generators.protobuf.ProtobufDomainEditor;
import com.generator.generators.templates.editors.TemplateFileEditor;
import com.generator.generators.vertxWeb.vertxWeb;
import com.generator.generators.vertxWeb.vertxWebEditor;
import com.generator.util.FileUtil;
import com.generator.util.SwingUtil;
import org.neo4j.graphdb.Transaction;

import javax.swing.*;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyVetoException;
import java.io.File;

/**
 * goe on 11/2/15.
 */
public class EditorDesktop extends JFrame {

	public static void main(String[] args) {
		System.setProperty("generator.root", args.length < 1 ? "src/main/java/" : args[0]);
		System.setProperty("generator.path", args.length < 1 ? (System.getProperty("generator.root") + "com/generator/generators") : args[0]);
		System.setProperty("generator.db", args.length < 2 ? "src/test/tests/db" : args[1]);
		SwingUtil.setLookAndFeel_Nimbus();
		final EditorDesktop app = new EditorDesktop();
		app.setDefaultCloseOperation(EXIT_ON_CLOSE);
		SwingUtil.show(app);
	}

	private final AppState state = new AppState();

	public EditorDesktop() throws HeadlessException {
		super("G e n e r a t o r");

		final JDesktopPane desktop = new JDesktopPane();

		final JMenuBar mainMenu = new JMenuBar();
		final JMenu databaseMenu = new JMenu("Database");
		final JMenuItem itmSelectDatabase = new JMenuItem(new SelectDatabaseAction(desktop));
		databaseMenu.add(itmSelectDatabase);
		mainMenu.add(databaseMenu);

		final JMenu domainMenu = new JMenu("Domains");
		domainMenu.add(new JMenuItem(new AddFrameAction(desktop, "Domain") {
			@Override
			JComponent newDomainEditor() {
				// external
				return Generator.newGeneratorDomainEditor(new GeneratorDomain(state.model));
			}
		}));

		domainMenu.add(new JMenuItem(new AddFrameAction(desktop, "Pante") {
			@Override
			JComponent newDomainEditor() {
				// external
				return new PanteEditor(new Pante(state.model));
			}
		}));

		domainMenu.add(new JMenuItem(new AddFrameAction(desktop, "Protobuf") {
			@Override
			JComponent newDomainEditor() {
				// external
				return Protobuf.newProtobufDomainEditor(new ProtobufDomain(state.model));
			}
		}));

		domainMenu.add(new JMenuItem(new AddFrameAction(desktop, "EasyFlow") {
			@Override
			JComponent newDomainEditor() {
				// anonymous
				return new EasyFlowDomainEditor(new EasyFlowDomain(state.model)) {
					@Override
					public void rightClickNoSelect(MouseEvent e, JPopupMenu popupMenu) {
						super.rightClickNoSelect(e, popupMenu);
						popupMenu.add(new ParseEasyFlowFileAction(this));
					}

					@Override
					protected void rightClickFlow(MouseEvent mouseEvent, JPopupMenu popupMenu, GraphNode2D targetNode) {

						popupMenu.add(new AbstractAction("Set root") {
							@Override
							public void actionPerformed(ActionEvent e) {

								final String root = SwingUtil.showInputDialog("Set root", popupMenu, System.getProperty("generator.root"));
								if (root == null || root.length() == 0) return;

								domain.commit(new MetaDomain.Committer() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										targetNode.node().setProperty("root", root);
									}

									@Override
									public void exception(Throwable throwable) {
										SwingUtil.showException(popupMenu, throwable);
									}
								});
							}
						});

						addVisitor(popupMenu, targetNode, new EasyFlowJavaGenerator(this));
						addVisitor(popupMenu, targetNode, new EasyFlowTemplateGenerator(this));
					}
				};
			}
		}));

		domainMenu.add(new JMenuItem(new AddFrameAction(desktop, "VertxWeb") {
			@Override
			JComponent newDomainEditor() {
				return new vertxWebEditor(new vertxWeb(state.model));
			}
		}));

		domainMenu.setEnabled(state.model != null);
		mainMenu.add(domainMenu);

		final JMenu toolsMenu = new JMenu("Tools");
		toolsMenu.add(new JMenuItem(new AddFrameAction(desktop, "TemplateEditor") {
			@Override
			JComponent newDomainEditor() {
				return new TemplateFileEditor(state.model);
			}
		}));
		mainMenu.add(toolsMenu);

		mainMenu.add(Box.createHorizontalGlue());

		final JLabel lblDatabase = new JLabel("No Database");
		lblDatabase.setFont(lblDatabase.getFont().deriveFont(Font.BOLD, 10));
		mainMenu.add(lblDatabase);
		state.addDatabaseListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(final PropertyChangeEvent evt) {
				SwingUtilities.invokeLater(() -> {
					lblDatabase.setText(((AppState) evt.getSource()).currentDir);
					domainMenu.setEnabled(state.model != null);
				});
			}
		});

		setJMenuBar(mainMenu);

		setPreferredSize(new Dimension(2048, 1024));
		setSize(new Dimension(2048, 1024));
		add(desktop);
	}

	public final class AppState {

		private String currentDir = System.getProperty("generator.db");
		private NeoModel model;

		private final PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

		public void setModel(NeoModel model) {
			this.model = model;
		}

		public void setCurrentDir(String currentDir) {
			changeSupport.firePropertyChange("currentDir", "", this.currentDir = currentDir);
		}

		public void addDatabaseListener(PropertyChangeListener propertyChangeListener) {
			changeSupport.addPropertyChangeListener(propertyChangeListener);
		}

		public Dimension getFrameSize() {
			return new Dimension(800, 600);
		}
	}

	private class SelectDatabaseAction extends AbstractAction {

		private final JDesktopPane desktop;

		public SelectDatabaseAction(JDesktopPane desktop) {
			super("Select database");
			this.desktop = desktop;
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			final File selectedDir = SwingUtil.showOpenDir(desktop, state.currentDir);
			if (selectedDir == null) return;

			SwingUtilities.invokeLater(() -> {

				if (state.model != null) state.model.close();

				FileUtil.tryToCreateDirIfNotExists(selectedDir);
				state.setCurrentDir(selectedDir.getAbsolutePath());
				state.model = new NeoModel(new org.neo4j.graphdb.factory.GraphDatabaseFactory().newEmbeddedDatabase(selectedDir.getAbsolutePath()));
			});
		}
	}

	private abstract class AddFrameAction extends AbstractAction {

		private final String title;
		private final JDesktopPane desktop;

		public AddFrameAction(JDesktopPane desktop, String title) {
			super(title);
			this.title = title;
			this.desktop = desktop;
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			final JInternalFrame[] allFrames = desktop.getAllFrames();
			for (final JInternalFrame desktopFrame : allFrames) {
				if (desktopFrame.getTitle().equals(title)) {
					showFrame(desktopFrame);
					return;
				}
			}


			final JComponent editor = newDomainEditor();

			final JInternalFrame frame = new JInternalFrame(title, true, true, true, true);

			if (editor instanceof KeyListener) {
				frame.addInternalFrameListener(new InternalFrameAdapter() {
					final KeyEventDispatcher dispatcher = e1 -> {
						switch (e1.getID()) {
							case KeyEvent.KEY_PRESSED:
								((KeyListener) editor).keyPressed(e1);
								break;
							case KeyEvent.KEY_RELEASED:
								((KeyListener) editor).keyReleased(e1);
								break;
						}
						return false;
					};

					@Override
					public void internalFrameActivated(InternalFrameEvent e) {
						KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(dispatcher);
					}

					@Override
					public void internalFrameDeactivated(InternalFrameEvent e) {
						KeyboardFocusManager.getCurrentKeyboardFocusManager().removeKeyEventDispatcher(dispatcher);
					}

					@Override
					public void internalFrameClosing(InternalFrameEvent e) {
						KeyboardFocusManager.getCurrentKeyboardFocusManager().removeKeyEventDispatcher(dispatcher);
					}
				});
			}

			if (editor instanceof MouseListener)
				frame.addMouseListener((MouseListener) editor);

			frame.getContentPane().setBackground(Color.WHITE);
			frame.getContentPane().add(editor, BorderLayout.CENTER);

			final Dimension frameSize = state.getFrameSize();
			frame.setPreferredSize(frameSize);
			frame.setMinimumSize(frameSize);
			frame.setSize(frameSize);

			SwingUtilities.invokeLater(() -> {

				frame.setVisible(true);
				desktop.add(frame);

				try {
					frame.setSelected(true);
				} catch (PropertyVetoException e1) {
					e1.printStackTrace();
				}
			});
		}

		private void showFrame(final JInternalFrame desktopFrame) {
			SwingUtilities.invokeLater(() -> {
				try {
					desktopFrame.setSelected(true);
				} catch (PropertyVetoException e1) {
					e1.printStackTrace();
				}
			});
		}

		abstract JComponent newDomainEditor();
	}
}