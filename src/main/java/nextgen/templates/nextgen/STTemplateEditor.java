package nextgen.templates.nextgen;

public class STTemplateEditor {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private Object _packageName;

	STTemplateEditor(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("STTemplateEditor");
		st.add("name", _name);
		st.add("packageName", _packageName);
		return st.render().trim();
	}

	public STTemplateEditor setName(Object value) {
		this._name = value;
		return this;
	}

	public Object getName() {
		return this._name;
	}

	public Object getName(Object defaultValue) {
		return this._name == null ? defaultValue : this._name;
	}

	public boolean hasName() {
		return this._name != null;
	}

	public STTemplateEditor removeName() {
		this._name = null;
		return this;
	} 

	public STTemplateEditor setPackageName(Object value) {
		this._packageName = value;
		return this;
	}

	public Object getPackageName() {
		return this._packageName;
	}

	public Object getPackageName(Object defaultValue) {
		return this._packageName == null ? defaultValue : this._packageName;
	}

	public boolean hasPackageName() {
		return this._packageName != null;
	}

	public STTemplateEditor removePackageName() {
		this._packageName = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		STTemplateEditor that = (STTemplateEditor) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "STTemplateEditor(name,packageName) ::= <<package ~packageName~;\n" + 
				"\n" + 
				"import nextgen.DomainFacade;\n" + 
				"import nextgen.stparser.*;\n" + 
				"import nextgen.swing.AppModel;\n" + 
				"import nextgen.swing.SwingUtil;\n" + 
				"import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;\n" + 
				"import org.fife.ui.rtextarea.*;\n" + 
				"\n" + 
				"import javax.swing.*;\n" + 
				"import javax.swing.border.Border;\n" + 
				"import java.awt.*;\n" + 
				"import java.awt.event.ActionEvent;\n" + 
				"import java.util.function.Consumer;\n" + 
				"import java.util.stream.Stream;\n" + 
				"\n" + 
				"public class ~name~ extends javax.swing.JPanel {\n" + 
				"\n" + 
				"	private RSyntaxTextArea textArea;\n" + 
				"	private nextgen.domain.STTemplate model;\n" + 
				"	private String startText;\n" + 
				"	private String delim;\n" + 
				"	private Color uneditedColor = UIManager.getColor(\"Panel.background\");\n" + 
				"	private Color editedColor = UIManager.getColor(\"Panel.background\").brighter();\n" + 
				"	private Color errorColor = Color.decode(\"#e66101\");\n" + 
				"	private Border defaultBorder;\n" + 
				"	private STEditorCommandPanel commandPanel = new STEditorCommandPanel();\n" + 
				"	private STEditorInfoPanel infoPanel = new STEditorInfoPanel();\n" + 
				"\n" + 
				"	public ~name~(nextgen.domain.STTemplate model) {\n" + 
				"		super(new java.awt.BorderLayout());\n" + 
				"\n" + 
				"		textArea = new RSyntaxTextArea(80, 40);\n" + 
				"		textArea.setTabSize(3);\n" + 
				"		textArea.setHighlightCurrentLine(false);\n" + 
				"		textArea.setSelectionColor(Color.decode(\"#2b8cbe\"));\n" + 
				"		textArea.setBackground(UIManager.getColor(\"Panel.background\"));\n" + 
				"		textArea.setForeground(UIManager.getColor(\"Tree.foreground\"));\n" + 
				"		textArea.setFont(UIManager.getFont(\"TextField.font\"));\n" + 
				"\n" + 
				"		startText = model.getText();\n" + 
				"		delim = DomainFacade.getSTGroup(model).getDelimiter();\n" + 
				"		defaultBorder = textArea.getBorder();\n" + 
				"		textArea.setText(startText);\n" + 
				"\n" + 
				"		final JPopupMenu pop = textArea.getPopupMenu();\n" + 
				"		pop.addSeparator();\n" + 
				"		pop.add(newAction(\"Insert Single\", actionEvent -> insertSingle()));\n" + 
				"		pop.add(newAction(\"Insert Single Capitalized\", actionEvent -> insertCapitalized()));\n" + 
				"		pop.add(newAction(\"Insert List\", actionEvent -> insertList()));\n" + 
				"		pop.add(newAction(\"Insert If\", actionEvent -> insertIf()));\n" + 
				"		pop.add(newAction(\"Insert If-else\", actionEvent -> insertIfElse()));\n" + 
				"		pop.add(newAction(\"Replace text and insert Single\", actionEvent -> replaceAndInsertSingle()));\n" + 
				"		pop.add(newAction(\"Replace text\", actionEvent -> replace()));\n" + 
				"		pop.add(newAction(\"Save\", actionEvent -> commit()));\n" + 
				"		pop.add(newAction(\"Generate\", actionEvent -> generate()));\n" + 
				"\n" + 
				"		final RTextScrollPane scrollPane = new RTextScrollPane(textArea);\n" + 
				"		scrollPane.setBackground(UIManager.getColor(\"Panel.background\"));\n" + 
				"		scrollPane.getGutter().setBackground(scrollPane.getBackground());\n" + 
				"		scrollPane.getGutter().setForeground(UIManager.getColor(\"TextField.foreground\"));\n" + 
				"		scrollPane.getGutter().setFont(UIManager.getFont(\"TextField.font\").deriveFont(29f));\n" + 
				"		add(scrollPane, BorderLayout.CENTER);\n" + 
				"		add(commandPanel, BorderLayout.NORTH);\n" + 
				"		add(infoPanel, BorderLayout.SOUTH);\n" + 
				"	}\n" + 
				"\n" + 
				"	private Action newAction(String name, Consumer<ActionEvent> consumer) {\n" + 
				"		return new AbstractAction(name) {\n" + 
				"			@Override\n" + 
				"			public void actionPerformed(ActionEvent e) {\n" + 
				"				consumer.accept(e);\n" + 
				"			}\n" + 
				"		};\n" + 
				"	}\n" + 
				"\n" + 
				"	private void insertSingle() {\n" + 
				"		SwingUtilities.invokeLater(() -> {\n" + 
				"			removeSelectedTextIfAny();\n" + 
				"			final int caretPosition = textArea.getCaretPosition();\n" + 
				"			textArea.insert(delim(\"\"), caretPosition);\n" + 
				"			textArea.setCaretPosition(caretPosition + 1);\n" + 
				"			textArea.setBackground(startText.trim().equals(textArea.getText().trim()) ? uneditedColor : editedColor);\n" + 
				"		});\n" + 
				"	}\n" + 
				"\n" + 
				"	private void insertCapitalized() {\n" + 
				"		SwingUtilities.invokeLater(() -> {\n" + 
				"			removeSelectedTextIfAny();\n" + 
				"			final int caretPosition = textArea.getCaretPosition();\n" + 
				"			textArea.insert(delim(\";format=\\\"capitalize\\\"\"), caretPosition);\n" + 
				"			textArea.setCaretPosition(caretPosition + 1);\n" + 
				"			textArea.setBackground(startText.trim().equals(textArea.getText().trim()) ? uneditedColor : editedColor);\n" + 
				"		});\n" + 
				"	}\n" + 
				"\n" + 
				"	private void insertList() {\n" + 
				"		final String input = SwingUtil.showInputDialog(\"name\", textArea);\n" + 
				"		if (input == null) return;\n" + 
				"		final String name = input.contains(\" \") ? input.split(\" \")[0] : input;\n" + 
				"		final String separator = input.contains(\" \") ? input.split(\" \")[1] : null;\n" + 
				"		SwingUtilities.invokeLater(() -> {\n" + 
				"			removeSelectedTextIfAny();\n" + 
				"			final int caretPosition = textArea.getCaretPosition();\n" + 
				"			final String pre = name + \":{it|\";\n" + 
				"			final String sep = separator == null ? \"\" : \";separator=\\\"\" + separator + \"\\\"\";\n" + 
				"			final String list = pre + \"}\" + sep;\n" + 
				"			textArea.insert(delim(list), caretPosition);\n" + 
				"			textArea.setCaretPosition(caretPosition + pre.length() + 1);\n" + 
				"			textArea.setBackground(startText.trim().equals(textArea.getText().trim()) ? uneditedColor : editedColor);\n" + 
				"		});\n" + 
				"	}\n" + 
				"\n" + 
				"	private void insertIf() {\n" + 
				"		final String input = SwingUtil.showInputDialog(\"condition\", textArea);\n" + 
				"		if (input == null) return;\n" + 
				"		final String name = input.trim();\n" + 
				"		SwingUtilities.invokeLater(() -> {\n" + 
				"			removeSelectedTextIfAny();\n" + 
				"			final int caretPosition = textArea.getCaretPosition();\n" + 
				"			final String pre = delim(\"if(\" + name + \")\");\n" + 
				"			final String list = pre + delim(\"endif\");\n" + 
				"			textArea.insert(list, caretPosition);\n" + 
				"			textArea.setCaretPosition(caretPosition + pre.length());\n" + 
				"			textArea.setBackground(startText.trim().equals(textArea.getText().trim()) ? uneditedColor : editedColor);\n" + 
				"		});\n" + 
				"	}\n" + 
				"\n" + 
				"	private void insertIfElse() {\n" + 
				"		final String input = SwingUtil.showInputDialog(\"condition\", textArea);\n" + 
				"		if (input == null) return;\n" + 
				"		final String name = input.trim();\n" + 
				"		SwingUtilities.invokeLater(() -> {\n" + 
				"			removeSelectedTextIfAny();\n" + 
				"			final int caretPosition = textArea.getCaretPosition();\n" + 
				"			final String pre = delim(\"if(\" + name + \")\");\n" + 
				"			final String list = pre + delim(\"else\") + delim(\"endif\");\n" + 
				"			textArea.insert(list, caretPosition);\n" + 
				"			textArea.setCaretPosition(caretPosition + pre.length());\n" + 
				"			textArea.setBackground(startText.trim().equals(textArea.getText().trim()) ? uneditedColor : editedColor);\n" + 
				"		});\n" + 
				"	}\n" + 
				"\n" + 
				"	private void replaceAndInsertSingle() {\n" + 
				"		final String selected = textArea.getSelectedText();\n" + 
				"		if (selected == null || selected.length() < 1) return;\n" + 
				"		final String propertyName = SwingUtil.showInputDialog(\"name\", textArea);\n" + 
				"		if (propertyName == null || propertyName.trim().length() == 0) return;\n" + 
				"\n" + 
				"		SwingUtilities.invokeLater(() -> {\n" + 
				"			final String replacement = delim(propertyName);\n" + 
				"			final SearchContext context = new SearchContext();\n" + 
				"			context.setSearchFor(selected);\n" + 
				"			context.setReplaceWith(replacement);\n" + 
				"			context.setMatchCase(true);\n" + 
				"			context.setSearchForward(true);\n" + 
				"			context.setWholeWord(false);\n" + 
				"			SearchEngine.replaceAll(textArea, context);\n" + 
				"			textArea.setBackground(startText.trim().equals(textArea.getText().trim()) ? uneditedColor : editedColor);\n" + 
				"		});\n" + 
				"	}\n" + 
				"\n" + 
				"	private void replace() {\n" + 
				"		final String selected = textArea.getSelectedText();\n" + 
				"		if (selected == null || selected.length() < 1) return;\n" + 
				"		final String replaceWith = SwingUtil.showInputDialog(\"value\", textArea);\n" + 
				"		if (replaceWith == null || replaceWith.trim().length() == 0) return;\n" + 
				"\n" + 
				"		SwingUtilities.invokeLater(() -> {\n" + 
				"			final SearchContext context = new SearchContext();\n" + 
				"			context.setSearchFor(selected);\n" + 
				"			context.setReplaceWith(replaceWith);\n" + 
				"			context.setMatchCase(true);\n" + 
				"			context.setSearchForward(true);\n" + 
				"			context.setWholeWord(false);\n" + 
				"			SearchEngine.replaceAll(textArea, context);\n" + 
				"			textArea.setBackground(startText.trim().equals(textArea.getText().trim()) ? uneditedColor : editedColor);\n" + 
				"		});\n" + 
				"	}\n" + 
				"\n" + 
				"	private void commit() {\n" + 
				"		SwingUtilities.invokeLater(() -> {\n" + 
				"			textArea.setBorder(defaultBorder);\n" + 
				"			final String text = textArea.getText().trim();\n" + 
				"			final STGParseResult parseResult = STParser.parseTemplate(text);\n" + 
				"			if (parseResult.getErrors().isEmpty()) {\n" + 
				"				AppModel.getInstance().getDomain().mergeTemplate(parseResult, model);\n" + 
				"				startText = text.trim();\n" + 
				"				textArea.setBackground(startText.trim().equals(textArea.getText().trim()) ? uneditedColor : editedColor);\n" + 
				"				infoPanel.clear();\n" + 
				"			} else {\n" + 
				"				textArea.setBorder(BorderFactory.createLineBorder(errorColor));\n" + 
				"				infoPanel.showParseErrors(parseResult.getErrors());\n" + 
				"			}\n" + 
				"		});\n" + 
				"	}\n" + 
				"\n" + 
				"	private void generate() {\n" + 
				"		commit();\n" + 
				"		AppModel.getInstance().getDomain().generateSTGroup(DomainFacade.getSTGroup(model));\n" + 
				"	}\n" + 
				"\n" + 
				"	private void removeSelectedTextIfAny() {\n" + 
				"		if (textArea.getSelectedText() != null) {\n" + 
				"			final int selectionStart = textArea.getSelectionStart();\n" + 
				"			textArea.replaceRange(\"\", selectionStart, textArea.getSelectionEnd());\n" + 
				"			textArea.setCaretPosition(selectionStart);\n" + 
				"			textArea.setBackground(startText.trim().equals(textArea.getText().trim()) ? uneditedColor : editedColor);\n" + 
				"		}\n" + 
				"	}\n" + 
				"\n" + 
				"	private String delim(String expression) {\n" + 
				"		return delim + expression + delim;\n" + 
				"	}\n" + 
				"\n" + 
				"	private class STEditorCommandPanel extends JPanel {\n" + 
				"\n" + 
				"		public STEditorCommandPanel() {\n" + 
				"			super(new FlowLayout(FlowLayout.LEFT));\n" + 
				"\n" + 
				"			add(nextgen.swing.ComponentFactory.newJButton(newAction(\"Insert Single\", actionEvent -> {\n" +
				"				insertSingle();\n" + 
				"				textArea.requestFocusInWindow();\n" + 
				"			})));\n" + 
				"\n" + 
				"			add(nextgen.swing.ComponentFactory.newJButton(newAction(\"Insert Single Capitalized\", actionEvent -> {\n" +
				"				insertCapitalized();\n" + 
				"				textArea.requestFocusInWindow();\n" + 
				"			})));\n" + 
				"			add(nextgen.swing.ComponentFactory.newJButton(newAction(\"Insert List\", actionEvent -> {\n" +
				"				insertList();\n" + 
				"				textArea.requestFocusInWindow();\n" + 
				"			})));\n" + 
				"			add(nextgen.swing.ComponentFactory.newJButton(newAction(\"Insert If\", actionEvent -> {\n" +
				"				insertIf();\n" + 
				"				textArea.requestFocusInWindow();\n" + 
				"			})));\n" + 
				"			add(nextgen.swing.ComponentFactory.newJButton(newAction(\"Insert If-else\", actionEvent -> {\n" +
				"				insertIfElse();\n" + 
				"				textArea.requestFocusInWindow();\n" + 
				"			})));\n" + 
				"			add(nextgen.swing.ComponentFactory.newJButton(newAction(\"Replace text and insert Single\", actionEvent -> {\n" +
				"				replaceAndInsertSingle();\n" + 
				"				textArea.requestFocusInWindow();\n" + 
				"			})));\n" + 
				"			add(nextgen.swing.ComponentFactory.newJButton(newAction(\"Save\", actionEvent -> {\n" +
				"				commit();\n" + 
				"				textArea.requestFocusInWindow();\n" + 
				"			})));\n" + 
				"			add(nextgen.swing.ComponentFactory.newJButton(newAction(\"Generate\", actionEvent -> {\n" +
				"				generate();\n" + 
				"				textArea.requestFocusInWindow();\n" + 
				"			})));\n" + 
				"		}\n" + 
				"	}\n" + 
				"\n" + 
				"	private class STEditorInfoPanel extends JPanel {\n" + 
				"\n" + 
				"		private final JTextArea textArea = nextgen.swing.ComponentFactory.newJTextArea();\n" +
				"\n" + 
				"		public STEditorInfoPanel() {\n" + 
				"			super(new BorderLayout());\n" + 
				"\n" + 
				"			this.textArea.setTabSize(3);\n" + 
				"			this.textArea.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));\n" + 
				"\n" + 
				"			add(nextgen.swing.ComponentFactory.newJScrollPane(textArea), BorderLayout.CENTER);\n" +
				"			setPreferredSize(new Dimension(800, 200));\n" + 
				"		}\n" + 
				"\n" + 
				"		public void clear() {\n" + 
				"			SwingUtilities.invokeLater(() -> {\n" + 
				"				textArea.setText(\"\");\n" + 
				"				textArea.setToolTipText(\"\");\n" + 
				"			});\n" + 
				"		}\n" + 
				"\n" + 
				"		public void showParseErrors(java.util.List<STGError> errors) {\n" + 
				"			final StringBuilder info = new StringBuilder(\"Parsing errors:\");\n" + 
				"\n" + 
				"			errors.forEach(stgError -> {\n" + 
				"\n" + 
				"				info.append(\"\\n\").append(stgError.getType());\n" + 
				"\n" + 
				"				switch (stgError.getType()) {\n" + 
				"					case COMPILE: {\n" + 
				"						info.append(\"\\n\\tline					\").append(stgError.getLine());\n" + 
				"						info.append(\"\\n\\tpos					 \").append(stgError.getCharPosition());\n" + 
				"						info.append(\"\\n\\tmessage				\").append(stgError.getMessage());\n" + 
				"\n" + 
				"						if (stgError.getMessage().contains(\"expecting RDELIM\")) {\n" + 
				"							info.append(\"\\n\\tpossible cause	  \")\n" + 
				"									.append(\"This is probably a '}' being interpreted as end-of a kv-iteration.\");\n" + 
				"							info.append(\"\\n\\tpossible solution  \")\n" + 
				"									.append(\"Try escaping the previous '}' (i.e from '}' to '\\\\\\\\}')\");\n" + 
				"						} else if (stgError.getMessage().contains(\"invalid character '>'\")) {\n" + 
				"							info.append(\"\\n\\tpossible cause	  \")\n" + 
				"									.append(\"This is probably a '>' being interpreted as end-of template.\");\n" + 
				"							info.append(\"\\n\\tpossible solution  \")\n" + 
				"									.append(\"Try changing the last '>' to '\")\n" + 
				"									.append(delim)\n" + 
				"									.append(\"gt()\")\n" + 
				"									.append(delim)\n" + 
				"									.append(\"'\");\n" + 
				"						}\n" + 
				"						break;\n" + 
				"					}\n" + 
				"\n" + 
				"					case RUNTIME:\n" + 
				"						break;\n" + 
				"\n" + 
				"					case IO:\n" + 
				"						break;\n" + 
				"\n" + 
				"					case INTERNAL:\n" + 
				"						break;\n" + 
				"				}\n" + 
				"			});\n" + 
				"\n" + 
				"			textArea.setText(info.toString().trim());\n" + 
				"			textArea.setCaretPosition(0);\n" + 
				"		}\n" + 
				"	}\n" + 
				"} >>";
}  