package nextgen.templates.stringtemplate;

public class StringTemplateST {

	private static final String stg = new StringBuilder("delimiters \"~\", \"~\"\n")
	.append("eom() ::= \"}\"\n")
	.append("gt() ::= \">\"\n")
	.append(DomainVisitorRunner.st + "\n")
	.append(VisitNodeMethod.st + "\n")
	.append(VisitRelationMethod.st + "\n")
	.append(NeoDomain.st + "\n")
	.append(FindBy.st + "\n")
	.append(NeoEntity.st + "\n")
	.append(KVAccessors.st + "\n")
	.append(ListAccessors.st + "\n")
	.append(SingleAccessors.st + "\n")
	.append(ScriptRunner.st + "\n")
	.append(STDomain.st + "\n")
	.append(NewEntityInstance.st + "\n")
	.append(StgString.st + "\n")
	.append(STDomainTests.st + "\n")
	.append(TemplateTestMethod.st + "\n")
	.append(STEntity.st + "\n")
	.append(EntityKVListAccessors.st + "\n")
	.append(EntityListAccessors.st + "\n")
	.append(EntitySingleAccessors.st + "\n")
	.append(STEnum.st + "\n")
	.append(STEnumValue.st + "\n")
	.append(STInterface.st + "\n")
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

	private static org.stringtemplate.v4.STGroup stGroup = decorate(new org.stringtemplate.v4.STGroupString("StringTemplateST", stg, '~', '~'));

	public static void setSTGroup(final String stgFile) {
		stGroup = decorate(new org.stringtemplate.v4.STGroupFile(stgFile, '~', '~'));
	}

	public static DomainVisitorRunner newDomainVisitorRunner() {
		return new DomainVisitorRunner(stGroup);
	}  

	public static VisitNodeMethod newVisitNodeMethod() {
		return new VisitNodeMethod(stGroup);
	}  

	public static VisitRelationMethod newVisitRelationMethod() {
		return new VisitRelationMethod(stGroup);
	}  

	public static NeoDomain newNeoDomain() {
		return new NeoDomain(stGroup);
	}  

	public static FindBy newFindBy() {
		return new FindBy(stGroup);
	}  

	public static NeoEntity newNeoEntity() {
		return new NeoEntity(stGroup);
	}  

	public static KVAccessors newKVAccessors() {
		return new KVAccessors(stGroup);
	}  

	public static ListAccessors newListAccessors() {
		return new ListAccessors(stGroup);
	}  

	public static SingleAccessors newSingleAccessors() {
		return new SingleAccessors(stGroup);
	}  

	public static ScriptRunner newScriptRunner() {
		return new ScriptRunner(stGroup);
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

	public static STEnum newSTEnum() {
		return new STEnum(stGroup);
	}  

	public static STEnumValue newSTEnumValue() {
		return new STEnumValue(stGroup);
	}  

	public static STInterface newSTInterface() {
		return new STInterface(stGroup);
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