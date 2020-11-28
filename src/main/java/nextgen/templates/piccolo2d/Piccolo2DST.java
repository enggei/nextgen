package nextgen.templates.piccolo2d;

public class Piccolo2DST {

	private static final String stg = new StringBuilder("delimiters \"~\", \"~\"\n")
	.append("eom() ::= \"}\"\n")
	.append("gt() ::= \">\"\n")
	.append(PCanvas.st + "\n")
	.append(CanvasAction.st + "\n")
	.append(LayoutVerticallyAction.st + "\n")
	.append(CanvasInputEventsHandler.st + "\n")
	.append(CanvasZoomHandler.st + "\n")
	.append(SelectEventsHandler.st + "\n")
	.append(PNode.st + "\n")
	.append(NodeAction.st + "\n")
	.append(AnonymousPNodeAction.st + "\n")
	.append(LayoutTreeAction.st + "\n")
	.append(PNodeImpl.st + "\n")
	.append(NodeMethod.st + "\n")
	.append(PNodeInputEventHandler.st + "\n")
	.append(PRelation.st + "\n")
	.append(PNodeChangeListener.st + "\n")
	.append(PRelationImpl.st + "\n")
	.append(RelationAction.st + "\n")
	.append(RelationInputEventHandler.st + "\n")
	.append(Readme.st + "\n")
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

	private static org.stringtemplate.v4.STGroup stGroup = decorate(new org.stringtemplate.v4.STGroupString("Piccolo2DST", stg, '~', '~'));

	public static void setSTGroup(final String stgFile) {
		stGroup = decorate(new org.stringtemplate.v4.STGroupFile(stgFile, '~', '~'));
	}

	public static PCanvas newPCanvas() {
		return new PCanvas(stGroup);
	}  

	public static CanvasAction newCanvasAction() {
		return new CanvasAction(stGroup);
	}  

	public static LayoutVerticallyAction newLayoutVerticallyAction() {
		return new LayoutVerticallyAction(stGroup);
	}  

	public static CanvasInputEventsHandler newCanvasInputEventsHandler() {
		return new CanvasInputEventsHandler(stGroup);
	}  

	public static CanvasZoomHandler newCanvasZoomHandler() {
		return new CanvasZoomHandler(stGroup);
	}  

	public static SelectEventsHandler newSelectEventsHandler() {
		return new SelectEventsHandler(stGroup);
	}  

	public static PNode newPNode() {
		return new PNode(stGroup);
	}  

	public static NodeAction newNodeAction() {
		return new NodeAction(stGroup);
	}  

	public static AnonymousPNodeAction newAnonymousPNodeAction() {
		return new AnonymousPNodeAction(stGroup);
	}  

	public static LayoutTreeAction newLayoutTreeAction() {
		return new LayoutTreeAction(stGroup);
	}  

	public static PNodeImpl newPNodeImpl() {
		return new PNodeImpl(stGroup);
	}  

	public static NodeMethod newNodeMethod() {
		return new NodeMethod(stGroup);
	}  

	public static PNodeInputEventHandler newPNodeInputEventHandler() {
		return new PNodeInputEventHandler(stGroup);
	}  

	public static PRelation newPRelation() {
		return new PRelation(stGroup);
	}  

	public static PNodeChangeListener newPNodeChangeListener() {
		return new PNodeChangeListener(stGroup);
	}  

	public static PRelationImpl newPRelationImpl() {
		return new PRelationImpl(stGroup);
	}  

	public static RelationAction newRelationAction() {
		return new RelationAction(stGroup);
	}  

	public static RelationInputEventHandler newRelationInputEventHandler() {
		return new RelationInputEventHandler(stGroup);
	}  

	public static Readme newReadme() {
		return new Readme(stGroup);
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