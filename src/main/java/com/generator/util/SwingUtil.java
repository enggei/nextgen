package com.generator.util;


import com.jgoodies.forms.builder.PanelBuilder;
import com.jgoodies.forms.debug.FormDebugPanel;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import org.jetbrains.annotations.Nullable;
import org.piccolo2d.event.PInputEvent;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.*;
import java.io.File;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SwingUtil {

	private static final Random random = new Random();

	private static final Color ODD_COLOR = new Color(240, 240, 224);
	public static final NumberFormat NUMBER_FORMAT = NumberFormat.getInstance();
	public static final DateFormat DATE_FORMAT = DateFormat.getDateInstance();

	public static JTextArea createTextPane(String fontName, int fontStyle, int fontSize, boolean editable, final boolean wordWrap) {
		final JTextArea txtPane = new JTextArea() {
			@Override
			public boolean getScrollableTracksViewportWidth() {
				return wordWrap ? super.getScrollableTracksViewportWidth() : false;
			}
		};
		Font font = new Font(fontName, fontStyle, fontSize);
		txtPane.setFont(font);
		txtPane.setEditable(editable);

		txtPane.setTabSize(3);

		final int CONTROL = 128;

		//todo not working correctly yet
		txtPane.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				final int modifiers = e.getModifiersEx();
				if (modifiers == CONTROL && KeyEvent.VK_D == e.getKeyCode()) {
					final String s = txtPane.getText();
					final int position = txtPane.getCaretPosition();
					final int end = s.indexOf("\r", position);
					if ((end - position) < 0) return;
					final String dup = s.substring(position, end);
					System.out.println("dup: |" + dup + "|");
					txtPane.setText(s.substring(0, position + 1) + "|" + dup + "|" + s.substring(end + 1));
					System.out.println(txtPane.getText());
					txtPane.setCaretPosition(position + dup.length());
				}
			}
		});

		return txtPane;
	}

	public static String tab(int no) {
		final StringBuilder out = new StringBuilder();
		for (int i = 0; i < no * 3; i++) out.append(' ');
		return out.toString();
	}

	public static String fromClipboard() {
		final Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		final Transferable contents = clipboard.getContents(null);
		if ((contents != null) && contents.isDataFlavorSupported(DataFlavor.stringFlavor)) {
			try {
				return (String) contents.getTransferData(DataFlavor.stringFlavor);
			} catch (Exception e) {
				e.printStackTrace();
				return e.getMessage();
			}
		}
		return "";
	}

	public static void showPanel(final JComponent component) {
		showPanel(component, null);
	}

	public static void showPanel(final JComponent component, Dimension size) {
		SwingUtil.setLookAndFeel_Nimbus();

		final JFrame frame = new JFrame();
		frame.getContentPane().add(component, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		if (size != null) {
			component.setPreferredSize(size);
			component.setSize(size);
		}
		show(frame);
	}

	public static void toClipboard(String content) {
		StringSelection stringSelection = new StringSelection(content);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, new ClipboardOwner() {
			@Override
			public void lostOwnership(Clipboard clipboard, Transferable contents) {
				// don't care ?
			}
		});
	}

	public static Component addBorderAndScroller(JComponent component, String title) {
		final JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(BorderFactory.createTitledBorder(title));
		final JScrollPane scroller = newScroller(component);
		panel.add(scroller, BorderLayout.CENTER);
		return panel;
	}

	public static JScrollPane newScroller(JComponent component) {
		final JScrollPane scroller = new JScrollPane(component);
		scroller.getViewport().setBackground(Color.WHITE);
		return scroller;
	}

	public static boolean confirm(String message, JComponent component) {
		return JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(component, message);
	}

	public static File showOpenFile(JComponent parent) {
		return showOpenFile(parent, null);
	}

	public static File showOpenDir(Component parent, String dir) {
		final JFileChooser fc = dir == null || (!new File(dir).isDirectory()) ? new JFileChooser() : new JFileChooser(dir);
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		final int result = fc.showOpenDialog(parent);
		return JFileChooser.APPROVE_OPTION == result ? fc.getSelectedFile() : null;
	}

	public static File showOpenFile(Component parent, String dir) {
		final JFileChooser fc = dir == null ? new JFileChooser() : new JFileChooser(new File(dir).isDirectory() ? new File(dir) : new File(dir).getParentFile());
		final int result = fc.showOpenDialog(parent);
		return JFileChooser.APPROVE_OPTION == result ? fc.getSelectedFile() : null;
	}

	public static File showSaveFile(Component parent, String dir) {
		final JFileChooser fc = dir == null || (!new File(dir).isDirectory()) ? new JFileChooser() : new JFileChooser(dir);
		final int result = fc.showSaveDialog(parent);
		return JFileChooser.APPROVE_OPTION == result ? fc.getSelectedFile() : null;
	}

	public static File showSaveFile(Component parent) {
		return showSaveFile(parent, null);
	}

	public static void showTextResult(String title, String text, Component component) {
		final JPanel panel = new JPanel(new BorderLayout());
		panel.add(new JLabel(title + " : "), BorderLayout.NORTH);
		final JScrollPane content = new JScrollPane(new JTextArea(text));
		content.setMaximumSize(new Dimension(800, 600));
		content.setPreferredSize(new Dimension(800, 600));
		content.setMinimumSize(new Dimension(800, 600));
		content.setSize(new Dimension(800, 600));
		panel.add(content, BorderLayout.CENTER);
		JOptionPane.showMessageDialog(component, panel, "Result", JOptionPane.INFORMATION_MESSAGE);
	}

	public static void showTextInput(String title, JTextArea textArea, Component component, OnSave onSave) {
		final JPanel panel = new JPanel(new BorderLayout(5, 5));
		panel.add(new JLabel(title + " : "), BorderLayout.NORTH);
		final JScrollPane content = new JScrollPane(textArea);
		content.setMaximumSize(new Dimension(800, 600));
		content.setPreferredSize(new Dimension(800, 600));
		content.setMinimumSize(new Dimension(800, 600));
		content.setSize(new Dimension(800, 600));
		panel.add(content, BorderLayout.CENTER);

		showDialog(panel, component, title, onSave);
	}

	public static void showException(String message, Throwable throwable, Component component) {

		final StringWriter stacktrace = new StringWriter();
		throwable.printStackTrace(new PrintWriter(stacktrace));

		if (component != null) {
			final JPanel panel = new JPanel(new BorderLayout());
			panel.add(new JLabel(message + " : "), BorderLayout.NORTH);
			final JScrollPane content = new JScrollPane(new JTextArea(stacktrace.toString()));
			content.setMaximumSize(new Dimension(800, 600));
			content.setPreferredSize(new Dimension(800, 600));
			content.setMinimumSize(new Dimension(800, 600));
			content.setSize(new Dimension(800, 600));
			panel.add(content, BorderLayout.CENTER);
			JOptionPane.showMessageDialog(component, panel, "Exception", JOptionPane.ERROR_MESSAGE);
		} else {
			System.out.println(stacktrace.toString());
		}
	}

	public static void showException(Throwable throwable, Component component) {
		showException("", throwable, component);
	}

	public static void showMessage(String message, Component component) {
		JOptionPane.showMessageDialog(component, message);
	}

	public static JFrame getFrame(Component child) {
		return (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, child);
	}


	public static void removeFromParent(Component component) {
		final Container parent = component.getParent();
		parent.remove(component);
	}

	public static void showDialog(final Component content, final Component owner, String title) {
		showDialog(content, owner, title, null);
	}

	// todo: combine showDialog and showDialogNoDefaultButton

	public static void showDialog(final Component content, final Component owner, String title, final OnSave onSave) {
		final JDialog dialog = new JDialog(SwingUtil.getFrame(owner), title, true);
		dialog.add(content, BorderLayout.CENTER);
		final JPanel commandPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

		if (onSave != null) {
			JButton btnSave;
			commandPanel.add(btnSave = new JButton(new AbstractAction("Save") {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						onSave.verifyAndSave();
						dialog.dispose();
					} catch (Exception e1) {
						SwingUtil.showException(e1, content);
					}
				}
			}));
			dialog.getRootPane().setDefaultButton(btnSave);
		}

		commandPanel.add(new JButton(new AbstractAction(onSave == null ? "Close" : "Cancel") {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						dialog.dispose();
					}
				});
			}
		}));
		dialog.add(commandPanel, BorderLayout.SOUTH);


		showDialog(dialog, owner);
	}

	public static void showDialogNoDefaultButton(final Component content, final Component owner, String title, final OnSave onSave) {
		final JDialog dialog = new JDialog(SwingUtil.getFrame(owner), title, true);
		dialog.add(content, BorderLayout.CENTER);
		final JPanel commandPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

		if (onSave != null) {
			JButton btnSave;
			commandPanel.add(btnSave = new JButton(new AbstractAction("Save") {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						onSave.verifyAndSave();
						dialog.dispose();
					} catch (Exception e1) {
						SwingUtil.showException(e1, content);
					}
				}
			}));
//			dialog.getRootPane().setDefaultButton(btnSave);
		}

		commandPanel.add(new JButton(new AbstractAction(onSave == null ? "Close" : "Cancel") {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						dialog.dispose();
					}
				});
			}
		}));
		dialog.add(commandPanel, BorderLayout.SOUTH);


		showDialog(dialog, owner);
	}

	public static void showApplySaveDialog(final Component content, final Component owner, String title, final OnSave onSave) {
		showDialog(content, owner, title, onSave, true);
	}

	public static void showDialog(final Component content, final Component owner, String title, final OnSave onSave, boolean showApplyButton) {
		final JDialog dialog = new JDialog(SwingUtil.getFrame(owner), title, true);
		dialog.add(content, BorderLayout.CENTER);
		final JPanel commandPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

		if (onSave != null) {

			JButton defaultButton;

			if (showApplyButton) {
				commandPanel.add(defaultButton = new JButton(new AbstractAction("Apply") {
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							onSave.verifyAndSave();
						} catch (Exception e1) {
							SwingUtil.showException(e1, content);
						}
					}
				}));

				commandPanel.add(new JButton(new AbstractAction("Save") {
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							onSave.verifyAndSave();
							dialog.dispose();
						} catch (Exception e1) {
							SwingUtil.showException(e1, content);
						}
					}
				}));

			} else {
				commandPanel.add(defaultButton = new JButton(new AbstractAction("Save") {
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							onSave.verifyAndSave();
							dialog.dispose();
						} catch (Exception e1) {
							SwingUtil.showException(e1, content);
						}
					}
				}));
			}

			dialog.getRootPane().setDefaultButton(defaultButton);
		}

		commandPanel.add(new JButton(new AbstractAction(onSave == null ? "Close" : "Cancel") {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						dialog.dispose();
					}
				});
			}
		}));
		dialog.add(commandPanel, BorderLayout.SOUTH);


		showDialog(dialog, owner);
	}

	public static void showApplyCloseDialog(final Component content, final Component owner, String title, final OnSave onSave) {
		final JDialog dialog = new JDialog(SwingUtil.getFrame(owner), title, true);
		dialog.add(content, BorderLayout.CENTER);
		final JPanel commandPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));


		JButton defaultButton;

		commandPanel.add(defaultButton = new JButton(new AbstractAction("Apply") {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					onSave.verifyAndSave();
				} catch (Exception e1) {
					SwingUtil.showException(e1, content);
				}
			}
		}));

		dialog.getRootPane().setDefaultButton(defaultButton);

		commandPanel.add(new JButton(new AbstractAction("Close") {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(() -> dialog.dispose());
			}
		}));
		dialog.add(commandPanel, BorderLayout.SOUTH);

		showDialog(dialog, owner);
	}

	public static void showDialog(final JDialog dialog, final Component owner) {
		SwingUtilities.invokeLater(() -> {
			dialog.pack();
			dialog.setLocationRelativeTo(owner);
			dialog.setVisible(true);
		});
	}

	public static JDialog getDialog(Component child) {
		return (JDialog) SwingUtilities.getAncestorOfClass(JDialog.class, child);
	}

	public static void tryToCloseDialogFor(Component component) {
		final JDialog dialog = SwingUtil.getDialog(component);
		if (dialog != null) {
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					dialog.dispose();
				}
			});
		}
	}

	public static boolean showConfirmDialog(String s, JMenu fileMenu) {
		return JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(fileMenu, s, "Confirm", JOptionPane.OK_CANCEL_OPTION);
	}

	public static String showInputDialog(String message, Component owner) {
		return JOptionPane.showInputDialog(owner, message);
	}

	public static String showInputDialog(String message, Component owner, String defaultValue) {
		return JOptionPane.showInputDialog(owner, message, defaultValue);
	}

	public static JMenu createMenu(String name, int mnemonic, JMenuBar bar) {
		final JMenu menu = new JMenu(name);
		menu.setMnemonic(mnemonic);
		bar.add(menu);
		return menu;
	}

	public static JMenuItem createMenuItem(String name, int mnemonic, int keyKode, ActionListener actionListener) {
		final JMenuItem menuItem = (mnemonic != -1) ? new JMenuItem(name, mnemonic) : new JMenuItem(name);
		if (keyKode != -1) menuItem.setAccelerator(KeyStroke.getKeyStroke(keyKode, ActionEvent.ALT_MASK));
		menuItem.addActionListener(actionListener);
		return menuItem;
	}

	public static int showConfirm(Component parent, String message, String title) {
		return JOptionPane.showConfirmDialog(parent, message, title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
	}

	public static void showException(Component parent, Throwable t) {
		t.printStackTrace();
		JOptionPane.showMessageDialog(parent, t.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
	}

	public static void showExceptionNoStack(Component parent, Throwable t) {
		JOptionPane.showMessageDialog(parent, t.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
	}

	public static void setLookAndFeel_Nimbus() {
		setLookAndFeel("Nimbus");
	}


	public static void setLookAndFeel(String name) {
		for (UIManager.LookAndFeelInfo laf : UIManager.getInstalledLookAndFeels()) {
			if (name.equals(laf.getName())) {
				try {
					UIManager.setLookAndFeel(laf.getClassName());
				} catch (Exception e) {
					System.err.println("Could not set look and feel '" + name + "': " + e.getMessage());
				}
			}
		}
	}

	public static void printSwingDefaults(PrintStream out) {

		final UIDefaults uid = UIManager.getDefaults();
		final Enumeration uidKeys = uid.keys();
		final String cr = System.getProperty("line.separator");
		final TreeMap<Object, Object> sortedMap = new TreeMap<Object, Object>();

		Object uidKey;
		while (uidKeys.hasMoreElements()) {
			uidKey = uidKeys.nextElement();
			sortedMap.put(uidKey.toString(), uid.get(uidKey));
		}

		for (Object key : sortedMap.keySet()) out.print(key + "=" + sortedMap.get(key) + cr);


		UIManager.put("OptionPane.cancelButtonText", "Cancel");
		UIManager.put("OptionPane.noButtonText", "No");
		UIManager.put("OptionPane.okButtonText", "Confirm");
		UIManager.put("OptionPane.yesButtonText", "Yes");

		System.out.println(UIManager.getString("OptionPane.yesButtonTest"));
		JOptionPane.showConfirmDialog(new JFrame(), "Message", "Test", JOptionPane.OK_CANCEL_OPTION);
	}

	public static void showDialog(final JDialog dialog, final Component relativeTo, final Component contentPane, final JButton confirmAction, final JButton cancelAction, final JButton defaultAction) {
		dialog.add(contentPane, BorderLayout.CENTER);
		final JPanel commandPane = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		commandPane.add(confirmAction);
		commandPane.add(cancelAction);
		dialog.add(commandPane, BorderLayout.SOUTH);
		dialog.getRootPane().setDefaultButton(defaultAction);
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				dialog.pack();
				if (relativeTo != null) dialog.setLocationRelativeTo(relativeTo);
				dialog.setVisible(true);
			}
		});
	}

	public static void main(String[] args) {
		printSwingDefaults(System.out);
	}

	public static void show(final JFrame frame) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				frame.pack();
				frame.setLocationByPlatform(true);
				frame.setVisible(true);
			}
		});
	}

	public static void showPopup(final JPopupMenu pop, final Component invoker, final MouseEvent e) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				pop.setInvoker(invoker);
				pop.show(invoker, e.getX(), e.getY());
			}
		});
	}

	public static boolean showConfirmDialog(Component parent, String message) {
		return JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(parent, message);
	}

	@SuppressWarnings("unchecked")
	public static <T> T showInputDialog(Component parent, String message, String title, java.util.List<T> values) {
		return (T) JOptionPane.showInputDialog(parent, message, title, JOptionPane.OK_CANCEL_OPTION, null, values.toArray(), values.get(0));
	}

	public static JButton createCommandButton(Action action) {
		final JButton button = new JButton(action);
		button.setMargin(new Insets(0, 0, 0, 0));
		return button;
	}

	public static JToggleButton createMenuButton(final JPanel contentPanel, final String name, final Icon icon, ButtonGroup group, boolean selected) {
		final JToggleButton button = new JToggleButton(new AbstractAction(null, icon) {
			public void actionPerformed(ActionEvent e) {
				((CardLayout) contentPanel.getLayout()).show(contentPanel, name);
			}
		});
		button.setSelected(selected);
		button.setMargin(new Insets(0, 0, 0, 0));
		group.add(button);
		return button;
	}

	public static JTable formatTable(JTable table) {

		table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
				super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				setBackground(isSelected ? table.getSelectionBackground() : (row % 2 == 0 ? table.getBackground() : ODD_COLOR));
				return this;
			}
		});

		table.setDefaultRenderer(Number.class, new DefaultTableCellRenderer() {
			public int getHorizontalAlignment() {
				return JLabel.RIGHT;
			}

			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
				super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				setBackground(isSelected ? table.getSelectionBackground() : (row % 2 == 0 ? table.getBackground() : ODD_COLOR));
				return this;
			}
		});

		table.setDefaultRenderer(Float.class, new DefaultTableCellRenderer() {
			protected void setValue(Object value) {
				setText((value == null) ? "" : NUMBER_FORMAT.format(value));
			}

			public int getHorizontalAlignment() {
				return JLabel.RIGHT;
			}

			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
				super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				setBackground(isSelected ? table.getSelectionBackground() : (row % 2 == 0 ? table.getBackground() : ODD_COLOR));
				return this;
			}
		});

		table.setDefaultRenderer(Double.class, new DefaultTableCellRenderer() {
			protected void setValue(Object value) {
				setText((value == null) ? "" : NUMBER_FORMAT.format(value));
			}

			public int getHorizontalAlignment() {
				return JLabel.RIGHT;
			}

			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
				super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				setBackground(isSelected ? table.getSelectionBackground() : (row % 2 == 0 ? table.getBackground() : ODD_COLOR));
				return this;
			}
		});

		table.setDefaultRenderer(Date.class, new DefaultTableCellRenderer() {
			protected void setValue(Object value) {
				setText((value == null) ? "" : DATE_FORMAT.format(value));
			}

			public int getHorizontalAlignment() {
				return JLabel.RIGHT;
			}

			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
				super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				setBackground(isSelected ? table.getSelectionBackground() : (row % 2 == 0 ? table.getBackground() : ODD_COLOR));
				return this;
			}
		});

		table.setDefaultRenderer(Icon.class, new DefaultTableCellRenderer() {
			protected void setValue(Object value) {
				setIcon((value instanceof Icon) ? (Icon) value : null);
			}

			public int getHorizontalAlignment() {
				return JLabel.CENTER;
			}

			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
				super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				setBackground(isSelected ? table.getSelectionBackground() : (row % 2 == 0 ? table.getBackground() : ODD_COLOR));
				return this;
			}
		});

		table.setDefaultRenderer(ImageIcon.class, new DefaultTableCellRenderer() {
			protected void setValue(Object value) {
				setIcon((value instanceof Icon) ? (Icon) value : null);
			}

			public int getHorizontalAlignment() {
				return JLabel.CENTER;
			}

			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
				super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				setBackground(isSelected ? table.getSelectionBackground() : (row % 2 == 0 ? table.getBackground() : ODD_COLOR));
				return this;
			}
		});


		return table;
	}

	public static void showDialog(final JDialog dialog, final Dimension size, final Component owner) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					if (size == null) dialog.pack();
					else dialog.setSize(size);
					dialog.setLocationRelativeTo(owner);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void insertWordIntoText(final JTextComponent textComponent, final String word) {
		String oldText = textComponent.getText();

		int position = textComponent.getCaretPosition();
		final Highlighter.Highlight[] highlights = textComponent.getHighlighter().getHighlights();
		if (highlights.length > 0) {
			for (int i = highlights.length - 1; i >= 0; i--) {
				oldText = StringUtil.insert(oldText, highlights[i].getStartOffset(), highlights[i].getEndOffset(), word);
				position = highlights[i].getStartOffset();
			}
		} else {
			oldText = StringUtil.insert(oldText, position, position, word);
		}

		final String finalText = oldText;
		final int finalPosition = position;
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				textComponent.setText(finalText);
				textComponent.setCaretPosition(finalPosition + word.length());
			}
		});
	}

	public static void ensureEventDispatchThread(final Runnable runnable) {
		if (SwingUtilities.isEventDispatchThread()) {
			runnable.run();
		} else {
			SwingUtilities.invokeLater(runnable);
		}
	}

	public static String showStringDialog(Component component, String message) {
		return JOptionPane.showInputDialog(component, message);
	}

	public static <T> T showSelectDialog(Component parent, T[] available) {
		return (T) JOptionPane.showInputDialog(parent, "Available ", "Select", JOptionPane.OK_CANCEL_OPTION, null, available, available.length == 0 ? null : available[0]);
	}

	public static <T> T showSelectDialog(Component parent, T[] available, T selected) {
		return (T) JOptionPane.showInputDialog(parent, "Available ", "Select", JOptionPane.OK_CANCEL_OPTION, null, available, selected);
	}

	public static <T> T showSelectDialog(Component parent, Collection<T> list) {
		if (list == null || list.size() == 0) return null;

		final T[] available = (T[]) list.toArray();
		return (T) JOptionPane.showInputDialog(parent, "Available: ", "Select", JOptionPane.OK_CANCEL_OPTION, null, available, available.length == 0 ? null : available[0]);
	}

	public static <T> T showSelectDialog(Component parent, Iterable<T> list) {
		final Set<T> values = asSet(list);
		if (values == null) return null;
		if(values.isEmpty()) return null;

		return showSelectDialog(parent, values);
	}

	@Nullable
	private static <T> Set<T> asSet(Iterable<T> list) {
		if (list == null ) return null;
		final Iterator<T> iterator = list.iterator();

		final Set<T> values = new LinkedHashSet<T>();
		while(iterator.hasNext())
			values.add(iterator.next());
		return values;
	}

	public static <T> T showSelectDialog(Component parent, String message, String title, Iterable<T> list) {
		final Set<T> values = asSet(list);
		if (values == null) return null;
		if(values.isEmpty()) return null;

		return showSelectDialog(parent, message, title, values);
	}

	public static <T> T showSelectDialog(Component parent, String message, String title, Collection<T> list) {
		if (list == null || list.size() == 0) return null;
		final T[] available = (T[]) list.toArray();
		return (T) JOptionPane.showInputDialog(parent, message, title, JOptionPane.OK_CANCEL_OPTION, null, available, available.length == 0 ? null : available[0]);
	}

	public static <T> T showSelectDialog(Component parent, String message, String title, Collection<T> list, SelectRenderer<T> renderer) {
		if (list == null || list.size() == 0) return null;

		final T[] available = (T[]) list.toArray();
		final String[] renderedValues = new String[available.length];
		final Map<String, T> map = new LinkedHashMap<String, T>();
		for (int i = 0; i < available.length; i++) {
			T t = available[i];
			final String renderedValue = renderer.render(t);
			map.put(renderedValue, t);
			renderedValues[i] = renderedValue;
		}

		final String selected = (String) JOptionPane.showInputDialog(parent, message, title, JOptionPane.OK_CANCEL_OPTION, null, renderedValues, renderedValues.length == 0 ? null : renderedValues[0]);
		return map.get(selected);
	}

	public static Color randomColor() {

		int r = 0, g = 0, b = 0;

		while (r + g + b < 100 && (r + g + b) < 600) {
			r = random.nextInt(255);
			g = random.nextInt(255);
			b = random.nextInt(255);
		}

		return new Color(r, g, b);
	}

	public static void tryToSleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	public interface SelectRenderer<T> {
		String render(T value);
	}

	public interface OnSave {
		void verifyAndSave() throws Exception;
	}


	public static class DebugFormPanel extends FormDebugPanel {

		private PanelBuilder builder;
		private final CellConstraints cc;
		private final CellConstraints.Alignment colAlign;
		private final CellConstraints.Alignment rowAlign;

		public DebugFormPanel() {
			this("", "");
		}

		public DebugFormPanel(String columns, String rows) {
			this(columns, rows, CellConstraints.FILL, CellConstraints.FILL);
		}

		public DebugFormPanel(String columns, String rows, CellConstraints.Alignment colAlign, CellConstraints.Alignment rowAlign) {
			this.cc = new CellConstraints();
			this.builder = new PanelBuilder(new FormLayout(columns, rows), this);
			this.colAlign = colAlign;
			this.rowAlign = rowAlign;
		}

		public void add(Component component, int column, int row) {
			this.add(component, column, row, 1, 1);
		}

		public void add(Component component, int column, int row, CellConstraints.Alignment colAlign, CellConstraints.Alignment rowAlign) {
			this.add(component, column, row, 1, 1, colAlign, rowAlign);
		}

		public void add(Component component, int column, int row, int colSpan, int rowSpan) {
			this.add(component, column, row, colSpan, rowSpan, this.colAlign, this.rowAlign);
		}

		public void addLabel(String text, int column, int row) {
			this.addLabel(text, column, row, this.colAlign, this.rowAlign);
		}

		public void addLabel(String text, int column, int row, CellConstraints.Alignment colAlign, CellConstraints.Alignment rowAlign) {
			this.addLabel(text, column, row, 1, 1, colAlign, rowAlign);
		}

		public void addLabel(String text, int column, int row, int colSpan, int rowSpan) {
			this.add(new JLabel(text), column, row, colSpan, rowSpan, this.colAlign, this.rowAlign);
		}

		public void addLabel(String text, int column, int row, int colSpan, int rowSpan, CellConstraints.Alignment colAlign, CellConstraints.Alignment rowAlign) {
			this.add(new JLabel(text), column, row, colSpan, rowSpan, colAlign, rowAlign);
		}

		public void addScrollPane(Component component, int column, int row, int colSpan, int rowSpan) {
			this.add(new JScrollPane(component), column, row, colSpan, rowSpan, this.colAlign, this.rowAlign);
		}

		public void addSeparator(String text, int column, int row, int colSpan, int rowSpan) {
			this.builder.addSeparator(text, this.cc.xywh(column, row, colSpan, rowSpan));
		}

		public void add(Component component, int column, int row, int colSpan, int rowSpan, CellConstraints.Alignment colAlign, CellConstraints.Alignment rowAlign) {
			this.builder.add(component, this.cc.xywh(column, row, colSpan, rowSpan, colAlign, rowAlign));
		}

		protected void setTitledBorder(String title) {
			this.setBorder(BorderFactory.createTitledBorder(" " + title + " "));
		}
	}

	public static class FormPanel extends JPanel {
		private PanelBuilder builder;
		private final CellConstraints cc;
		private final CellConstraints.Alignment colAlign;
		private final CellConstraints.Alignment rowAlign;
		private static final int COLSPAN = 1;
		private static final int ROWSPAN = 1;

		public FormPanel() {
			this("", "");
		}

		public FormPanel(String columns, String rows) {
			this(columns, rows, CellConstraints.FILL, CellConstraints.FILL);
		}

		public FormPanel(String columns, String rows, CellConstraints.Alignment colAlign, CellConstraints.Alignment rowAlign) {
			this.cc = new CellConstraints();
			this.builder = new PanelBuilder(new FormLayout(columns, rows), this);
			this.colAlign = colAlign;
			this.rowAlign = rowAlign;
		}

		public void add(Component component, int column, int row) {
			this.add(component, column, row, 1, 1);
		}

		public void add(Component component, int column, int row, CellConstraints.Alignment colAlign, CellConstraints.Alignment rowAlign) {
			this.add(component, column, row, 1, 1, colAlign, rowAlign);
		}

		public void add(Component component, int column, int row, int colSpan, int rowSpan) {
			this.add(component, column, row, colSpan, rowSpan, this.colAlign, this.rowAlign);
		}

		public JLabel addLabel(String text, int column, int row) {
			return this.addLabel(text, column, row, this.colAlign, this.rowAlign);
		}

		public JLabel addLabel(String text, int column, int row, CellConstraints.Alignment colAlign, CellConstraints.Alignment rowAlign) {
			return this.addLabel(text, column, row, 1, 1, colAlign, rowAlign);
		}

		public JLabel addLabel(String text, int column, int row, int colSpan, int rowSpan, CellConstraints.Alignment colAlign, CellConstraints.Alignment rowAlign) {
			final JLabel label = new JLabel(text);
			this.add(label, column, row, colSpan, rowSpan, colAlign, rowAlign);
			return label;
		}

		public void addScrollPane(Component component, int column, int row, int colSpan, int rowSpan) {
			this.add(new JScrollPane(component), column, row, colSpan, rowSpan, this.colAlign, this.rowAlign);
		}

		public void addSeparator(String text, int column, int row, int colSpan, int rowSpan) {
			this.builder.addSeparator(text, this.cc.xywh(column, row, colSpan, rowSpan));
		}

		public void add(Component component, int column, int row, int colSpan, int rowSpan, CellConstraints.Alignment colAlign, CellConstraints.Alignment rowAlign) {
			this.builder.add(component, this.cc.xywh(column, row, colSpan, rowSpan, colAlign, rowAlign));
		}

		protected void setTitledBorder(String title) {
			this.setBorder(BorderFactory.createTitledBorder(" " + title + " "));
		}
	}

	public static void tryToHighlight(JTextComponent txtEditor,  final List<String> selectedText, final Highlighter.HighlightPainter highlightPainter) {
		SwingUtilities.invokeLater(() -> highLight(txtEditor, selectedText, highlightPainter));
	}

	public static void highLight(JTextComponent textComp, Iterable<String> pattern, Highlighter.HighlightPainter highlightPainter) {

		removeHighlights(textComp);

		try {

			// escape '$' if its used in patterns:
			final StringBuilder out = new StringBuilder();
			boolean first = true;
			for (String item : pattern) {
				if (!first) out.append("|");
				first = false;
				out.append(item.replaceAll("\\$", "\\\\\\$").replaceAll("\\(", "\\\\\\(").replaceAll("\\)", "\\\\\\)"));
			}

			final Pattern r = Pattern.compile(out.toString());
			final Matcher matcher = r.matcher(textComp.getText());
			final Highlighter highlighter = textComp.getHighlighter();
			while (matcher.find()) {
				highlighter.addHighlight(matcher.start(), matcher.end(), highlightPainter);
			}

		} catch (BadLocationException ignored) {
			ignored.printStackTrace();
		}
	}

	public static void removeHighlights(JTextComponent textComp) {
		final Highlighter highlighter = textComp.getHighlighter();
		final Highlighter.Highlight[] highlights = highlighter.getHighlights();
		for (Highlighter.Highlight highlight : highlights) {
			if (highlight.getPainter() instanceof DefaultHighlighter.DefaultHighlightPainter) {
				highlighter.removeHighlight(highlight);
			}
		}
	}
}