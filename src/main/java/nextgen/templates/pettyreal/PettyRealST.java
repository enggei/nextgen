package nextgen.templates.pettyreal;

public class PettyRealST {

	private static final String stg = new StringBuilder("delimiters \"~\", \"~\"\n")
	.append("eom() ::= \"}\"\n")
	.append("gt() ::= \">\"\n")
	.append(Copyright.st + "\n")
	.append(ListErrors.st + "\n")
	.append(LoginForm.st + "\n")
	.append(LogoutForm.st + "\n")
	.append(NavigationBar.st + "\n")
	.append(UserMenu.st + "\n")
	.append(Page.st + "\n")
	.append(RenderConst.st + "\n")
	.append(LoginPage.st + "\n")
	.append(LogoutPage.st + "\n")
	.append(AppStore.st + "\n")
	.append(AuthStore.st + "\n")
	.append(UserStore.st + "\n")
	.append(SystemDescription.st + "\n")
	.append(SystemPage.st + "\n")
	.append(WebVerticle.st + "\n")
	.append(EndpointHandler.st + "\n")
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

	private static org.stringtemplate.v4.STGroup stGroup = decorate(new org.stringtemplate.v4.STGroupString("PettyRealST", stg, '~', '~'));

	public static void setSTGroup(final String stgFile) {
		stGroup = decorate(new org.stringtemplate.v4.STGroupFile(stgFile, '~', '~'));
	}

	public static Copyright newCopyright() {
		return new Copyright(stGroup);
	}  

	public static ListErrors newListErrors() {
		return new ListErrors(stGroup);
	}  

	public static LoginForm newLoginForm() {
		return new LoginForm(stGroup);
	}  

	public static LogoutForm newLogoutForm() {
		return new LogoutForm(stGroup);
	}  

	public static NavigationBar newNavigationBar() {
		return new NavigationBar(stGroup);
	}  

	public static UserMenu newUserMenu() {
		return new UserMenu(stGroup);
	}  

	public static Page newPage() {
		return new Page(stGroup);
	}  

	public static RenderConst newRenderConst() {
		return new RenderConst(stGroup);
	}  

	public static LoginPage newLoginPage() {
		return new LoginPage(stGroup);
	}  

	public static LogoutPage newLogoutPage() {
		return new LogoutPage(stGroup);
	}  

	public static AppStore newAppStore() {
		return new AppStore(stGroup);
	}  

	public static AuthStore newAuthStore() {
		return new AuthStore(stGroup);
	}  

	public static UserStore newUserStore() {
		return new UserStore(stGroup);
	}  

	public static SystemDescription newSystemDescription() {
		return new SystemDescription(stGroup);
	}  

	public static SystemPage newSystemPage() {
		return new SystemPage(stGroup);
	}  

	public static WebVerticle newWebVerticle() {
		return new WebVerticle(stGroup);
	}  

	public static EndpointHandler newEndpointHandler() {
		return new EndpointHandler(stGroup);
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