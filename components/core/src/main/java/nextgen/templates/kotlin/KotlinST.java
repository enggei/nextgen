package nextgen.templates.kotlin;

public class KotlinST {

	private static final String stg = "delimiters \"~\", \"~\"\n" +
	"eom() ::= \"}\"\n" +
	"gt() ::= \">\"\n" +
	Poko.st + "\n" + 
	CastExpression.st + "\n" + 
	FunctionCallExpression.st + "\n" + 
	NullExpression.st + "\n" + 
	VarExpression.st + "\n" + 
	AnnotationDeclaration.st + "\n" + 
	AnnotationParam.st + "\n" + 
	ClassDeclaration.st + "\n" + 
	OverrideEquals.st + "\n" + 
	OverrideHashCode.st + "\n" + 
	Extending.st + "\n" + 
	FieldDeclaration.st + "\n" + 
	FunctionDeclaration.st + "\n" + 
	PackageDeclaration.st + "\n" + 
	ArrayInitializer.st + "\n" + 
	EmptyArrayInitializer.st + "\n" + 
	ExpressionInitializer.st + "\n" + 
	ListInitializer.st + "\n" + 
	MapInitializer.st + "\n" + 
	NullInitializer.st + "\n" + 
	ArrayType.st + "\n" + 
	ListType.st + "\n" + 
	MapType.st + "\n" + 
	NamedType.st + "\n" ;

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

	private static org.stringtemplate.v4.STGroup stGroup = decorate(new org.stringtemplate.v4.STGroupString("KotlinST", stg, '~', '~'));

	public static void setSTGroup(final String stgFile) {
		stGroup = decorate(new org.stringtemplate.v4.STGroupFile(stgFile, '~', '~'));
	}

	public static Poko newPoko() {
		return new Poko(stGroup);
	} 

	public static CastExpression newCastExpression() {
		return new CastExpression(stGroup);
	} 

	public static FunctionCallExpression newFunctionCallExpression() {
		return new FunctionCallExpression(stGroup);
	} 

	public static NullExpression newNullExpression() {
		return new NullExpression(stGroup);
	} 

	public static VarExpression newVarExpression() {
		return new VarExpression(stGroup);
	} 

	public static AnnotationDeclaration newAnnotationDeclaration() {
		return new AnnotationDeclaration(stGroup);
	} 

	public static AnnotationParam newAnnotationParam() {
		return new AnnotationParam(stGroup);
	} 

	public static ClassDeclaration newClassDeclaration() {
		return new ClassDeclaration(stGroup);
	} 

	public static OverrideEquals newOverrideEquals() {
		return new OverrideEquals(stGroup);
	} 

	public static OverrideHashCode newOverrideHashCode() {
		return new OverrideHashCode(stGroup);
	} 

	public static Extending newExtending() {
		return new Extending(stGroup);
	} 

	public static FieldDeclaration newFieldDeclaration() {
		return new FieldDeclaration(stGroup);
	} 

	public static FunctionDeclaration newFunctionDeclaration() {
		return new FunctionDeclaration(stGroup);
	} 

	public static PackageDeclaration newPackageDeclaration() {
		return new PackageDeclaration(stGroup);
	} 

	public static ArrayInitializer newArrayInitializer() {
		return new ArrayInitializer(stGroup);
	} 

	public static EmptyArrayInitializer newEmptyArrayInitializer() {
		return new EmptyArrayInitializer(stGroup);
	} 

	public static ExpressionInitializer newExpressionInitializer() {
		return new ExpressionInitializer(stGroup);
	} 

	public static ListInitializer newListInitializer() {
		return new ListInitializer(stGroup);
	} 

	public static MapInitializer newMapInitializer() {
		return new MapInitializer(stGroup);
	} 

	public static NullInitializer newNullInitializer() {
		return new NullInitializer(stGroup);
	} 

	public static ArrayType newArrayType() {
		return new ArrayType(stGroup);
	} 

	public static ListType newListType() {
		return new ListType(stGroup);
	} 

	public static MapType newMapType() {
		return new MapType(stGroup);
	} 

	public static NamedType newNamedType() {
		return new NamedType(stGroup);
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