package nextgen.templates.javascript;

public class JavaScriptST {

	private static final String stg = new StringBuilder("delimiters \"~\", \"~\"\n")
	.append("eom() ::= \"}\"\n")
	.append("gt() ::= \">\"\n")
	.append(BlockStmt.st + "\n")
	.append(Conditional.st + "\n")
	.append(If.st + "\n")
	.append(Decorator.st + "\n")
	.append(ArrowFunction.st + "\n")
	.append(Function.st + "\n")
	.append(FunctionCall.st + "\n")
	.append(FunctionExpression.st + "\n")
	.append(ReturnStmt.st + "\n")
	.append(JsonArray.st + "\n")
	.append(JsonObject.st + "\n")
	.append(NameArray.st + "\n")
	.append(NameValue.st + "\n")
	.append(App.st + "\n")
	.append(IndexCSS.st + "\n")
	.append(IndexHtml.st + "\n")
	.append(IndexJS.st + "\n")
	.append(JSX.st + "\n")
	.append(ClassComponent.st + "\n")
	.append(Dependency.st + "\n")
	.append(DestructorProp.st + "\n")
	.append(Div.st + "\n")
	.append(Element.st + "\n")
	.append(Form.st + "\n")
	.append(Ul.st + "\n")
	.append(FunctionalComponent.st + "\n")
	.append(MapProperty.st + "\n")
	.append(MethodDeclaration.st + "\n")
	.append(NamedImport.st + "\n")
	.append(Prop.st + "\n")
	.append(ReturnStatement.st + "\n")
	.append(State.st + "\n")
	.append(ForwardRef.st + "\n")
	.append(Link.st + "\n")
	.append(ReactRouterLinkImport.st + "\n")
	.append(WithRouterImport.st + "\n")
	.append(Statement.st + "\n")
	.append(Superagent.st + "\n")
	.append(AgentDeclaration.st + "\n")
	.append(AgentEndpoint.st + "\n")
	.append(AgentRequest.st + "\n")
	.append(ConstVariable.st + "\n")
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

	private static org.stringtemplate.v4.STGroup stGroup = decorate(new org.stringtemplate.v4.STGroupString("JavaScriptST", stg, '~', '~'));

	public static void setSTGroup(final String stgFile) {
		stGroup = decorate(new org.stringtemplate.v4.STGroupFile(stgFile, '~', '~'));
	}

	public static BlockStmt newBlockStmt() {
		return new BlockStmt(stGroup);
	}  

	public static Conditional newConditional() {
		return new Conditional(stGroup);
	}  

	public static If newIf() {
		return new If(stGroup);
	}  

	public static Decorator newDecorator() {
		return new Decorator(stGroup);
	}  

	public static ArrowFunction newArrowFunction() {
		return new ArrowFunction(stGroup);
	}  

	public static Function newFunction() {
		return new Function(stGroup);
	}  

	public static FunctionCall newFunctionCall() {
		return new FunctionCall(stGroup);
	}  

	public static FunctionExpression newFunctionExpression() {
		return new FunctionExpression(stGroup);
	}  

	public static ReturnStmt newReturnStmt() {
		return new ReturnStmt(stGroup);
	}  

	public static JsonArray newJsonArray() {
		return new JsonArray(stGroup);
	}  

	public static JsonObject newJsonObject() {
		return new JsonObject(stGroup);
	}  

	public static NameArray newNameArray() {
		return new NameArray(stGroup);
	}  

	public static NameValue newNameValue() {
		return new NameValue(stGroup);
	}  

	public static App newApp() {
		return new App(stGroup);
	}  

	public static IndexCSS newIndexCSS() {
		return new IndexCSS(stGroup);
	}  

	public static IndexHtml newIndexHtml() {
		return new IndexHtml(stGroup);
	}  

	public static IndexJS newIndexJS() {
		return new IndexJS(stGroup);
	}  

	public static JSX newJSX() {
		return new JSX(stGroup);
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

	public static Div newDiv() {
		return new Div(stGroup);
	}  

	public static Element newElement() {
		return new Element(stGroup);
	}  

	public static Form newForm() {
		return new Form(stGroup);
	}  

	public static Ul newUl() {
		return new Ul(stGroup);
	}  

	public static FunctionalComponent newFunctionalComponent() {
		return new FunctionalComponent(stGroup);
	}  

	public static MapProperty newMapProperty() {
		return new MapProperty(stGroup);
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

	public static ForwardRef newForwardRef() {
		return new ForwardRef(stGroup);
	}  

	public static Link newLink() {
		return new Link(stGroup);
	}  

	public static ReactRouterLinkImport newReactRouterLinkImport() {
		return new ReactRouterLinkImport(stGroup);
	}  

	public static WithRouterImport newWithRouterImport() {
		return new WithRouterImport(stGroup);
	}  

	public static Statement newStatement() {
		return new Statement(stGroup);
	}  

	public static Superagent newSuperagent() {
		return new Superagent(stGroup);
	}  

	public static AgentDeclaration newAgentDeclaration() {
		return new AgentDeclaration(stGroup);
	}  

	public static AgentEndpoint newAgentEndpoint() {
		return new AgentEndpoint(stGroup);
	}  

	public static AgentRequest newAgentRequest() {
		return new AgentRequest(stGroup);
	}  

	public static ConstVariable newConstVariable() {
		return new ConstVariable(stGroup);
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