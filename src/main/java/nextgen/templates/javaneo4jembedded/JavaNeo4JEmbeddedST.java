package nextgen.templates.javaneo4jembedded;

public class JavaNeo4JEmbeddedST {

	private static final String stg = new StringBuilder("delimiters \"~\", \"~\"\n")
	.append("eom() ::= \"}\"\n")
	.append("gt() ::= \">\"\n")
	.append(NeoFactory.st + "\n")
	.append(NeoFactoryAccessors.st + "\n")
	.append(NeoFactoryPropertyAccessors.st + "\n")
	.append(NodeWrapper.st + "\n")
	.append(DeleteNode.st + "\n")
	.append(EnumAccessors.st + "\n")
	.append(EnumListAccessors.st + "\n")
	.append(ExternalAccessors.st + "\n")
	.append(IncomingOptionalReference.st + "\n")
	.append(IncomingReference.st + "\n")
	.append(IncomingReferenceStream.st + "\n")
	.append(ListPrimitiveAccessors.st + "\n")
	.append(ListReferenceAccessors.st + "\n")
	.append(NodeToJsonObject.st + "\n")
	.append(PrimitiveAccessors.st + "\n")
	.append(PrimitiveOptionalAccessors.st + "\n")
	.append(ReferenceAccessors.st + "\n")
	.append(ReferenceOptionalAccessors.st + "\n")
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

	private static org.stringtemplate.v4.STGroup stGroup = decorate(new org.stringtemplate.v4.STGroupString("JavaNeo4JEmbeddedST", stg, '~', '~'));

	public static void setSTGroup(final String stgFile) {
		stGroup = decorate(new org.stringtemplate.v4.STGroupFile(stgFile, '~', '~'));
	}

	public static NeoFactory newNeoFactory() {
		return new NeoFactory(stGroup);
	}  

	public static NeoFactoryAccessors newNeoFactoryAccessors() {
		return new NeoFactoryAccessors(stGroup);
	}  

	public static NeoFactoryPropertyAccessors newNeoFactoryPropertyAccessors() {
		return new NeoFactoryPropertyAccessors(stGroup);
	}  

	public static NodeWrapper newNodeWrapper() {
		return new NodeWrapper(stGroup);
	}  

	public static DeleteNode newDeleteNode() {
		return new DeleteNode(stGroup);
	}  

	public static EnumAccessors newEnumAccessors() {
		return new EnumAccessors(stGroup);
	}  

	public static EnumListAccessors newEnumListAccessors() {
		return new EnumListAccessors(stGroup);
	}  

	public static ExternalAccessors newExternalAccessors() {
		return new ExternalAccessors(stGroup);
	}  

	public static IncomingOptionalReference newIncomingOptionalReference() {
		return new IncomingOptionalReference(stGroup);
	}  

	public static IncomingReference newIncomingReference() {
		return new IncomingReference(stGroup);
	}  

	public static IncomingReferenceStream newIncomingReferenceStream() {
		return new IncomingReferenceStream(stGroup);
	}  

	public static ListPrimitiveAccessors newListPrimitiveAccessors() {
		return new ListPrimitiveAccessors(stGroup);
	}  

	public static ListReferenceAccessors newListReferenceAccessors() {
		return new ListReferenceAccessors(stGroup);
	}  

	public static NodeToJsonObject newNodeToJsonObject() {
		return new NodeToJsonObject(stGroup);
	}  

	public static PrimitiveAccessors newPrimitiveAccessors() {
		return new PrimitiveAccessors(stGroup);
	}  

	public static PrimitiveOptionalAccessors newPrimitiveOptionalAccessors() {
		return new PrimitiveOptionalAccessors(stGroup);
	}  

	public static ReferenceAccessors newReferenceAccessors() {
		return new ReferenceAccessors(stGroup);
	}  

	public static ReferenceOptionalAccessors newReferenceOptionalAccessors() {
		return new ReferenceOptionalAccessors(stGroup);
	}  

	private static final class DefaultAttributeRenderer implements org.stringtemplate.v4.AttributeRenderer {

		@Override
		public String toString(Object o, String formatString, java.util.Locale locale) {

			final String text = o.toString();
			if (formatString == null) return text;

			final String s = text.length() > 1 ? text.substring(1) : "";

			switch (formatString) {
				case "simpleName":
					final int lastIndex = text.lastIndexOf(".");
               if (lastIndex == -1) return text;
               return text.substring(lastIndex + 1);
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