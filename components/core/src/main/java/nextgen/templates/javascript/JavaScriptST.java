package nextgen.templates.javascript;

public class JavaScriptST {

	private static final String stg = "delimiters \"~\", \"~\"\n" +
	"eom() ::= \"}\"\n" +
	"gt() ::= \">\"\n" +
	App.st + "\n" + 
	Agent.st + "\n" + 
	AgentDeclaration.st + "\n" + 
	AgentEndpoint.st + "\n" + 
	IndexJS.st + "\n" + 
	LoginForm.st + "\n" + 
	LogoutForm.st + "\n" + 
	NavigationBar.st + "\n" + 
	SimpleMenu.st + "\n" + 
	UserMenu.st + "\n" + 
	ArrowFunction.st + "\n" + 
	BlockStmt.st + "\n" + 
	Decorator.st + "\n" + 
	ExpressionStmt.st + "\n" + 
	Function.st + "\n" + 
	If.st + "\n" + 
	IndexHtml.st + "\n" + 
	Inject.st + "\n" + 
	JsonObject.st + "\n" + 
	ClassComponent.st + "\n" + 
	Dependency.st + "\n" + 
	DestructorProp.st + "\n" + 
	Element.st + "\n" + 
	ForwardRef.st + "\n" + 
	FunctionalComponent.st + "\n" + 
	MethodDeclaration.st + "\n" + 
	NamedImport.st + "\n" + 
	Prop.st + "\n" + 
	ReturnStatement.st + "\n" + 
	State.st + "\n" + 
	GlobalStyle.st + "\n" + 
	MenuItem.st + "\n" + 
	Style.st + "\n" + 
	StyleComponent.st + "\n" + 
	WithStyles.st + "\n" + 
	MethodCall.st + "\n" + 
	MobX.st + "\n" + 
	Action.st + "\n" + 
	MobXStore.st + "\n" + 
	Observable.st + "\n" + 
	Reaction.st + "\n" + 
	NameArray.st + "\n" + 
	NameValue.st + "\n" + 
	Link.st + "\n" + 
	ReturnStmt.st + "\n" ;

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

	private static org.stringtemplate.v4.STGroup stGroup = decorate(new org.stringtemplate.v4.STGroupString("JavaScriptST", stg, '~', '~'));

	public static void setSTGroup(final String stgFile) {
		stGroup = decorate(new org.stringtemplate.v4.STGroupFile(stgFile, '~', '~'));
	}

	public static App newApp() {
		return new App(stGroup);
	} 

	public static Agent newAgent() {
		return new Agent(stGroup);
	} 

	public static AgentDeclaration newAgentDeclaration() {
		return new AgentDeclaration(stGroup);
	} 

	public static AgentEndpoint newAgentEndpoint() {
		return new AgentEndpoint(stGroup);
	} 

	public static IndexJS newIndexJS() {
		return new IndexJS(stGroup);
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

	public static SimpleMenu newSimpleMenu() {
		return new SimpleMenu(stGroup);
	} 

	public static UserMenu newUserMenu() {
		return new UserMenu(stGroup);
	} 

	public static ArrowFunction newArrowFunction() {
		return new ArrowFunction(stGroup);
	} 

	public static BlockStmt newBlockStmt() {
		return new BlockStmt(stGroup);
	} 

	public static Decorator newDecorator() {
		return new Decorator(stGroup);
	} 

	public static ExpressionStmt newExpressionStmt() {
		return new ExpressionStmt(stGroup);
	} 

	public static Function newFunction() {
		return new Function(stGroup);
	} 

	public static If newIf() {
		return new If(stGroup);
	} 

	public static IndexHtml newIndexHtml() {
		return new IndexHtml(stGroup);
	} 

	public static Inject newInject() {
		return new Inject(stGroup);
	} 

	public static JsonObject newJsonObject() {
		return new JsonObject(stGroup);
	} 

	public static ClassComponent newClassComponent() {
		return new ClassComponent(stGroup);
	} 

	public static Dependency newDependency() {
		return new Dependency(stGroup);
	} 

	public static DestructorProp newDestructorProp() {
		return new DestructorProp(stGroup);
	} 

	public static Element newElement() {
		return new Element(stGroup);
	} 

	public static ForwardRef newForwardRef() {
		return new ForwardRef(stGroup);
	} 

	public static FunctionalComponent newFunctionalComponent() {
		return new FunctionalComponent(stGroup);
	} 

	public static MethodDeclaration newMethodDeclaration() {
		return new MethodDeclaration(stGroup);
	} 

	public static NamedImport newNamedImport() {
		return new NamedImport(stGroup);
	} 

	public static Prop newProp() {
		return new Prop(stGroup);
	} 

	public static ReturnStatement newReturnStatement() {
		return new ReturnStatement(stGroup);
	} 

	public static State newState() {
		return new State(stGroup);
	} 

	public static GlobalStyle newGlobalStyle() {
		return new GlobalStyle(stGroup);
	} 

	public static MenuItem newMenuItem() {
		return new MenuItem(stGroup);
	} 

	public static Style newStyle() {
		return new Style(stGroup);
	} 

	public static StyleComponent newStyleComponent() {
		return new StyleComponent(stGroup);
	} 

	public static WithStyles newWithStyles() {
		return new WithStyles(stGroup);
	} 

	public static MethodCall newMethodCall() {
		return new MethodCall(stGroup);
	} 

	public static MobX newMobX() {
		return new MobX(stGroup);
	} 

	public static Action newAction() {
		return new Action(stGroup);
	} 

	public static MobXStore newMobXStore() {
		return new MobXStore(stGroup);
	} 

	public static Observable newObservable() {
		return new Observable(stGroup);
	} 

	public static Reaction newReaction() {
		return new Reaction(stGroup);
	} 

	public static NameArray newNameArray() {
		return new NameArray(stGroup);
	} 

	public static NameValue newNameValue() {
		return new NameValue(stGroup);
	} 

	public static Link newLink() {
		return new Link(stGroup);
	} 

	public static ReturnStmt newReturnStmt() {
		return new ReturnStmt(stGroup);
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