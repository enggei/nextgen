package nextgen.templates.javaswing;

public class JavaSwingST {

	private static final String stg = new StringBuilder("delimiters \"~\", \"~\"\n")
	.append("eom() ::= \"}\"\n")
	.append("gt() ::= \">\"\n")
	.append(Actions.st + "\n")
	.append(EntityAction.st + "\n")
	.append(TransactionAction.st + "\n")
	.append(App.st + "\n")
	.append(JPanel.st + "\n")
	.append(Editor.st + "\n")
	.append(ModelEditor.st + "\n")
	.append(JTabbedPane.st + "\n")
	.append(ButtonTab.st + "\n")
	.append(JTree.st + "\n")
	.append(BaseTreeNode.st + "\n")
	.append(TreeModel.st + "\n")
	.append(TreeNode.st + "\n")
	.append(GetTreeNodeAction.st + "\n")
	.append(SwingUtil.st + "\n")
	.toString()  ;

	public static org.stringtemplate.v4.STGroup decorate(final org.stringtemplate.v4.STGroup stGroup) {
		stGroup.registerRenderer(Object.class, new DefaultAttributeRenderer());
		stGroup.setListener(new org.stringtemplate.v4.STErrorListener() {
			@Override
			public void compileTimeError(org.stringtemplate.v4.misc.STMessage stMessage) {
				System.out.println("compileTimeError " + stMessage.toString());
			}

			@Override
			public void runTimeError(org.stringtemplate.v4.misc.STMessage stMessage) {
				final org.stringtemplate.v4.misc.STRuntimeMessage stRuntimeMessage = (org.stringtemplate.v4.misc.STRuntimeMessage) stMessage;
				System.out.println("runTimeError " + stMessage.self.getName() + " " + stRuntimeMessage.getSourceLocation());
			}

			@Override
			public void IOError(org.stringtemplate.v4.misc.STMessage stMessage) {
				System.out.println("IOError " + stMessage.toString());
			}

			@Override
			public void internalError(org.stringtemplate.v4.misc.STMessage stMessage) {
				System.out.println("internalError " + stMessage.toString());
			}
		});

		return stGroup;
	}

	private static org.stringtemplate.v4.STGroup stGroup = decorate(new org.stringtemplate.v4.STGroupString("JavaSwingST", stg, '~', '~'));

	public static void setSTGroup(final String stgFile) {
		stGroup = decorate(new org.stringtemplate.v4.STGroupFile(stgFile, '~', '~'));
	}

	public static Actions newActions() {
		return new Actions(stGroup);
	}  

	public static EntityAction newEntityAction() {
		return new EntityAction(stGroup);
	}  

	public static TransactionAction newTransactionAction() {
		return new TransactionAction(stGroup);
	}  

	public static App newApp() {
		return new App(stGroup);
	}  

	public static JPanel newJPanel() {
		return new JPanel(stGroup);
	}  

	public static Editor newEditor() {
		return new Editor(stGroup);
	}  

	public static ModelEditor newModelEditor() {
		return new ModelEditor(stGroup);
	}  

	public static JTabbedPane newJTabbedPane() {
		return new JTabbedPane(stGroup);
	}  

	public static ButtonTab newButtonTab() {
		return new ButtonTab(stGroup);
	}  

	public static JTree newJTree() {
		return new JTree(stGroup);
	}  

	public static BaseTreeNode newBaseTreeNode() {
		return new BaseTreeNode(stGroup);
	}  

	public static TreeModel newTreeModel() {
		return new TreeModel(stGroup);
	}  

	public static TreeNode newTreeNode() {
		return new TreeNode(stGroup);
	}  

	public static GetTreeNodeAction newGetTreeNodeAction() {
		return new GetTreeNodeAction(stGroup);
	}  

	public static SwingUtil newSwingUtil() {
		return new SwingUtil(stGroup);
	}  

	private static final class DefaultAttributeRenderer implements org.stringtemplate.v4.AttributeRenderer {

		@Override
		public String toString(Object o, String formatString, java.util.Locale locale) {

			final String text = o.toString();
			if (formatString == null) return text;

			final String s = text.length() > 1 ? text.substring(1) : "";

			switch (formatString) {
				case "capitalize":
					return Character.toUpperCase(text.charAt(0)) + s;
				case "toUpper":
					return text.toUpperCase();
				case "lowFirst":
					return Character.toLowerCase(text.charAt(0)) + s;
				case "toLower":
					return text.toLowerCase();
				case "dotToCap":
					final StringBuilder formatted = new StringBuilder();
					final char[] chars = o.toString().toCharArray();
					for (int i = 0; i < chars.length; i++)
            		if (chars[i] != '.')
							formatted.append(i == 0 || chars[i - 1] == '.' ? Character.toUpperCase(chars[i]) : chars[i]);
					return formatted.toString().trim();
				default:
					return o.toString();
			}
		}
	}
}  