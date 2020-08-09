package nextgen.templates.nextgen;

public class NextgenST {

	private static final String stg = new StringBuilder("delimiters \"~\", \"~\"\n")
	.append("eom() ::= \"}\"\n")
	.append("gt() ::= \">\"\n")
	.append(Canvas.st + "\n")
	.append(BaseCanvasNode.st + "\n")
	.append(CanvasNode.st + "\n")
	.append(CanvasNodeAction.st + "\n")
	.append(BaseCanvasRelation.st + "\n")
	.append(CanvasRelation.st + "\n")
	.append(CanvasRelationAction.st + "\n")
	.append(CanvasAction.st + "\n")
	.append(TreeNavigator.st + "\n")
	.append(BaseTreeNode.st + "\n")
	.append(TreeNode.st + "\n")
	.append(TreeNodeAction.st + "\n")
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

	private static org.stringtemplate.v4.STGroup stGroup = decorate(new org.stringtemplate.v4.STGroupString("NextgenST", stg, '~', '~'));

	public static void setSTGroup(final String stgFile) {
		stGroup = decorate(new org.stringtemplate.v4.STGroupFile(stgFile, '~', '~'));
	}

	public static Canvas newCanvas() {
		return new Canvas(stGroup);
	}  

	public static BaseCanvasNode newBaseCanvasNode() {
		return new BaseCanvasNode(stGroup);
	}  

	public static CanvasNode newCanvasNode() {
		return new CanvasNode(stGroup);
	}  

	public static CanvasNodeAction newCanvasNodeAction() {
		return new CanvasNodeAction(stGroup);
	}  

	public static BaseCanvasRelation newBaseCanvasRelation() {
		return new BaseCanvasRelation(stGroup);
	}  

	public static CanvasRelation newCanvasRelation() {
		return new CanvasRelation(stGroup);
	}  

	public static CanvasRelationAction newCanvasRelationAction() {
		return new CanvasRelationAction(stGroup);
	}  

	public static CanvasAction newCanvasAction() {
		return new CanvasAction(stGroup);
	}  

	public static TreeNavigator newTreeNavigator() {
		return new TreeNavigator(stGroup);
	}  

	public static BaseTreeNode newBaseTreeNode() {
		return new BaseTreeNode(stGroup);
	}  

	public static TreeNode newTreeNode() {
		return new TreeNode(stGroup);
	}  

	public static TreeNodeAction newTreeNodeAction() {
		return new TreeNodeAction(stGroup);
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