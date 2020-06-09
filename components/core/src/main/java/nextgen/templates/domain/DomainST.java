package nextgen.templates.domain;

public class DomainST {

	private static final String stg = "delimiters \"~\", \"~\"\n" +
	"eom() ::= \"}\"\n" +
	"gt() ::= \">\"\n" +
	Domain.st + "\n" + 
	Entity.st + "\n" + 
	EnumField.st + "\n" + 
	ExternalReferenceField.st + "\n" + 
	ExternalReferenceList.st + "\n" + 
	PrimitiveField.st + "\n" + 
	PrimitiveList.st + "\n" + 
	ReferenceField.st + "\n" + 
	ReferenceList.st + "\n" ;

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

	private static org.stringtemplate.v4.STGroup stGroup = decorate(new org.stringtemplate.v4.STGroupString("DomainST", stg, '~', '~'));

	public static void setSTGroup(final String stgFile) {
		stGroup = decorate(new org.stringtemplate.v4.STGroupFile(stgFile, '~', '~'));
	}

	public static Domain newDomain() {
		return new Domain(stGroup);
	} 

	public static Entity newEntity() {
		return new Entity(stGroup);
	} 

	public static EnumField newEnumField() {
		return new EnumField(stGroup);
	} 

	public static ExternalReferenceField newExternalReferenceField() {
		return new ExternalReferenceField(stGroup);
	} 

	public static ExternalReferenceList newExternalReferenceList() {
		return new ExternalReferenceList(stGroup);
	} 

	public static PrimitiveField newPrimitiveField() {
		return new PrimitiveField(stGroup);
	} 

	public static PrimitiveList newPrimitiveList() {
		return new PrimitiveList(stGroup);
	} 

	public static ReferenceField newReferenceField() {
		return new ReferenceField(stGroup);
	} 

	public static ReferenceList newReferenceList() {
		return new ReferenceList(stGroup);
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