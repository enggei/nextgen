package nextgen.templates.vertx;

public class VertxST {

	private static final String stg = "delimiters \"~\", \"~\"\n" +
	"eom() ::= \"}\"\n" +
	"gt() ::= \">\"\n" +
	JsonWrapper.st + "\n" + 
	EnumAccessors.st + "\n" + 
	ExternalAccessors.st + "\n" + 
	ListPrimitiveAccessors.st + "\n" + 
	ListReferenceAccessors.st + "\n" + 
	PrimitiveAccessors.st + "\n" + 
	ReferenceAccessors.st + "\n" + 
	JsonArrayType.st + "\n" ;

	public static org.stringtemplate.v4.STGroup defaultSTGroup() {
		org.stringtemplate.v4.STGroup stGroup = new org.stringtemplate.v4.STGroupString("VertxST", stg, '~', '~');
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

	public static JsonWrapper newJsonWrapper() {
		return new JsonWrapper(stGroup);
	} 

	public static EnumAccessors newEnumAccessors() {
		return new EnumAccessors(stGroup);
	} 

	public static ExternalAccessors newExternalAccessors() {
		return new ExternalAccessors(stGroup);
	} 

	public static ListPrimitiveAccessors newListPrimitiveAccessors() {
		return new ListPrimitiveAccessors(stGroup);
	} 

	public static ListReferenceAccessors newListReferenceAccessors() {
		return new ListReferenceAccessors(stGroup);
	} 

	public static PrimitiveAccessors newPrimitiveAccessors() {
		return new PrimitiveAccessors(stGroup);
	} 

	public static ReferenceAccessors newReferenceAccessors() {
		return new ReferenceAccessors(stGroup);
	} 

	public static JsonArrayType newJsonArrayType() {
		return new JsonArrayType(stGroup);
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