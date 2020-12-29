package nextgen.templates.vertx;

public class VertxST {

	private static final String stg = new StringBuilder("delimiters \"~\", \"~\"\n")
	.append("eom() ::= \"}\"\n")
	.append("gt() ::= \">\"\n")
	.append(DomainVerticle.st + "\n")
	.append(DomainAction.st + "\n")
	.append(JsonFactory.st + "\n")
	.append(JsonWrapper.st + "\n")
	.append(EnumAccessors.st + "\n")
	.append(ExternalAccessors.st + "\n")
	.append(ListEnumAccessors.st + "\n")
	.append(ListPrimitiveAccessors.st + "\n")
	.append(ListReferenceAccessors.st + "\n")
	.append(PrimitiveAccessors.st + "\n")
	.append(ReferenceAccessors.st + "\n")
	.append(Server.st + "\n")
	.append(ServerConfig.st + "\n")
	.append(WebVerticle.st + "\n")
	.append(RequestHandler.st + "\n")
	.append(RouteHandler.st + "\n")
	.append(SendEventBusAction.st + "\n")
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

	private static org.stringtemplate.v4.STGroup stGroup = decorate(new org.stringtemplate.v4.STGroupString("VertxST", stg, '~', '~'));

	public static void setSTGroup(final String stgFile) {
		stGroup = decorate(new org.stringtemplate.v4.STGroupFile(stgFile, '~', '~'));
	}

	public static DomainVerticle newDomainVerticle() {
		return new DomainVerticle(stGroup);
	}  

	public static DomainAction newDomainAction() {
		return new DomainAction(stGroup);
	}  

	public static JsonFactory newJsonFactory() {
		return new JsonFactory(stGroup);
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

	public static ListEnumAccessors newListEnumAccessors() {
		return new ListEnumAccessors(stGroup);
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

	public static Server newServer() {
		return new Server(stGroup);
	}  

	public static ServerConfig newServerConfig() {
		return new ServerConfig(stGroup);
	}  

	public static WebVerticle newWebVerticle() {
		return new WebVerticle(stGroup);
	}  

	public static RequestHandler newRequestHandler() {
		return new RequestHandler(stGroup);
	}  

	public static RouteHandler newRouteHandler() {
		return new RouteHandler(stGroup);
	}  

	public static SendEventBusAction newSendEventBusAction() {
		return new SendEventBusAction(stGroup);
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