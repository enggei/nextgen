package nextgen.templates.domain;

public class DomainST {

	private static final String stg = new StringBuilder("delimiters \"~\", \"~\"\n")
	.append("eom() ::= \"}\"\n")
	.append("gt() ::= \">\"\n")
	.append(Domain.st + "\n")
	.append(DomainProcessor.st + "\n")
	.append(DomainDeclaration.st + "\n")
	.append(DomainEntityDeclaration.st + "\n")
	.append(TemplateTransformer.st + "\n")
	.append(TemplateTransformerImpl.st + "\n")
	.append(ToFactory.st + "\n")
	.append(DefaultFactoryImpl.st + "\n")
	.append(DefaultEntityImpl.st + "\n")
	.append(FactoryEntity.st + "\n")
	.append(ToForm.st + "\n")
	.append(ToInterfaces.st + "\n")
	.append(ToEnum.st + "\n")
	.append(ToInterface.st + "\n")
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

	private static org.stringtemplate.v4.STGroup stGroup = decorate(new org.stringtemplate.v4.STGroupString("DomainST", stg, '~', '~'));

	public static void setSTGroup(final String stgFile) {
		stGroup = decorate(new org.stringtemplate.v4.STGroupFile(stgFile, '~', '~'));
	}

	public static Domain newDomain() {
		return new Domain(stGroup);
	}  

	public static DomainProcessor newDomainProcessor() {
		return new DomainProcessor(stGroup);
	}  

	public static DomainDeclaration newDomainDeclaration() {
		return new DomainDeclaration(stGroup);
	}  

	public static DomainEntityDeclaration newDomainEntityDeclaration() {
		return new DomainEntityDeclaration(stGroup);
	}  

	public static TemplateTransformer newTemplateTransformer() {
		return new TemplateTransformer(stGroup);
	}  

	public static TemplateTransformerImpl newTemplateTransformerImpl() {
		return new TemplateTransformerImpl(stGroup);
	}  

	public static ToFactory newToFactory() {
		return new ToFactory(stGroup);
	}  

	public static DefaultFactoryImpl newDefaultFactoryImpl() {
		return new DefaultFactoryImpl(stGroup);
	}  

	public static DefaultEntityImpl newDefaultEntityImpl() {
		return new DefaultEntityImpl(stGroup);
	}  

	public static FactoryEntity newFactoryEntity() {
		return new FactoryEntity(stGroup);
	}  

	public static ToForm newToForm() {
		return new ToForm(stGroup);
	}  

	public static ToInterfaces newToInterfaces() {
		return new ToInterfaces(stGroup);
	}  

	public static ToEnum newToEnum() {
		return new ToEnum(stGroup);
	}  

	public static ToInterface newToInterface() {
		return new ToInterface(stGroup);
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