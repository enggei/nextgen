package nextgen.templates.kotlin;

public class KotlinST {

	private static final String stg = "delimiters \"~\", \"~\"\n" +
	"eom() ::= \"}\"\n" +
	"gt() ::= \">\"\n" +
	Poko.st + "\n" + 
	AnnotationDeclaration.st + "\n" + 
	AnnotationParam.st + "\n" + 
	ClassDeclaration.st + "\n" + 
	Extending.st + "\n" + 
	FieldDeclaration.st + "\n" + 
	PackageDeclaration.st + "\n" ;

	public static org.stringtemplate.v4.STGroup defaultSTGroup() {
		org.stringtemplate.v4.STGroup stGroup = new org.stringtemplate.v4.STGroupString("KotlinST", stg, '~', '~');
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

	private static org.stringtemplate.v4.STGroup stGroup = defaultSTGroup();

	public static void setSTGroup(final String stgFile) {
		stGroup = new org.stringtemplate.v4.STGroupFile(stgFile, '~', '~');
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
	}

	public static Poko newPoko() {
		return new Poko(stGroup);
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

	public static Extending newExtending() {
		return new Extending(stGroup);
	} 

	public static FieldDeclaration newFieldDeclaration() {
		return new FieldDeclaration(stGroup);
	} 

	public static PackageDeclaration newPackageDeclaration() {
		return new PackageDeclaration(stGroup);
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
				default:
					return o.toString();
			}
		}
	}
} 