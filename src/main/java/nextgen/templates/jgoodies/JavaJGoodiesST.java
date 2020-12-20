package nextgen.templates.jgoodies;

public class JavaJGoodiesST {

	private static final String stg = new StringBuilder("delimiters \"~\", \"~\"\n")
	.append("eom() ::= \"}\"\n")
	.append("gt() ::= \">\"\n")
	.append(Grammar.st + "\n")
	.append(BoundedSize.st + "\n")
	.append(ColSpan.st + "\n")
	.append(Column.st + "\n")
	.append(ColumnSpec.st + "\n")
	.append(ColumnSpecs.st + "\n")
	.append(ConstantSize.st + "\n")
	.append(Constraints.st + "\n")
	.append(Grow.st + "\n")
	.append(ResizeBehavior.st + "\n")
	.append(Row.st + "\n")
	.append(RowSpan.st + "\n")
	.append(RowSpec.st + "\n")
	.append(RowSpecs.st + "\n")
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

	private static org.stringtemplate.v4.STGroup stGroup = decorate(new org.stringtemplate.v4.STGroupString("JavaJGoodiesST", stg, '~', '~'));

	public static void setSTGroup(final String stgFile) {
		stGroup = decorate(new org.stringtemplate.v4.STGroupFile(stgFile, '~', '~'));
	}

	public static Grammar newGrammar() {
		return new Grammar(stGroup);
	}  

	public static BoundedSize newBoundedSize() {
		return new BoundedSize(stGroup);
	}  

	public static ColSpan newColSpan() {
		return new ColSpan(stGroup);
	}  

	public static Column newColumn() {
		return new Column(stGroup);
	}  

	public static ColumnSpec newColumnSpec() {
		return new ColumnSpec(stGroup);
	}  

	public static ColumnSpecs newColumnSpecs() {
		return new ColumnSpecs(stGroup);
	}  

	public static ConstantSize newConstantSize() {
		return new ConstantSize(stGroup);
	}  

	public static Constraints newConstraints() {
		return new Constraints(stGroup);
	}  

	public static Grow newGrow() {
		return new Grow(stGroup);
	}  

	public static ResizeBehavior newResizeBehavior() {
		return new ResizeBehavior(stGroup);
	}  

	public static Row newRow() {
		return new Row(stGroup);
	}  

	public static RowSpan newRowSpan() {
		return new RowSpan(stGroup);
	}  

	public static RowSpec newRowSpec() {
		return new RowSpec(stGroup);
	}  

	public static RowSpecs newRowSpecs() {
		return new RowSpecs(stGroup);
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