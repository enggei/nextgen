package nextgen.st.stringtemplate;

public class StringTemplateST {

	private static final String stg = "delimiters \"~\", \"~\"\n" +
	"eom() ::= \"}\"\n" +
	"gt() ::= \">\"\n" +
	STDomain.st + "\n" + 
	NewEntityInstance.st + "\n" + 
	StgString.st + "\n" + 
	STDomainTests.st + "\n" + 
	TemplateTestMethod.st + "\n" + 
	STEntity.st + "\n" + 
	EntityKVListAccessors.st + "\n" + 
	EntityListAccessors.st + "\n" + 
	EntitySingleAccessors.st + "\n" + 
	STG.st + "\n" + 
	Template.st + "\n" ;

	public static org.stringtemplate.v4.STGroup defaultSTGroup() {
		org.stringtemplate.v4.STGroup stGroup = new org.stringtemplate.v4.STGroupString("StringTemplateST", stg, '~', '~');
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

	public static STDomain newSTDomain() {
		return new STDomain(stGroup);
	} 

	public static NewEntityInstance newNewEntityInstance() {
		return new NewEntityInstance(stGroup);
	} 

	public static StgString newStgString() {
		return new StgString(stGroup);
	} 

	public static STDomainTests newSTDomainTests() {
		return new STDomainTests(stGroup);
	} 

	public static TemplateTestMethod newTemplateTestMethod() {
		return new TemplateTestMethod(stGroup);
	} 

	public static STEntity newSTEntity() {
		return new STEntity(stGroup);
	} 

	public static EntityKVListAccessors newEntityKVListAccessors() {
		return new EntityKVListAccessors(stGroup);
	} 

	public static EntityListAccessors newEntityListAccessors() {
		return new EntityListAccessors(stGroup);
	} 

	public static EntitySingleAccessors newEntitySingleAccessors() {
		return new EntitySingleAccessors(stGroup);
	} 

	public static STG newSTG() {
		return new STG(stGroup);
	} 

	public static Template newTemplate() {
		return new Template(stGroup);
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