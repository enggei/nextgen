package nextgen.react.st;


public class ReactGenerator {

	private final org.stringtemplate.v4.STGroup stGroup;

	public ReactGenerator() { 
		this(new org.stringtemplate.v4.STGroupFile("templates/React.stg"));
	}

	public ReactGenerator(java.io.File file) { 
		this(new org.stringtemplate.v4.STGroupFile(file.getAbsolutePath()));
	}

	public ReactGenerator(org.stringtemplate.v4.STGroup stGroup) { 
		this.stGroup = stGroup;
	}

	public java.lang.Object generate(DestructorProp model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("DestructorProp");
		st.add("child", generate(model.getChild()));
		model.getProp().forEach((element) -> st.add("prop", generate(element)));
		return st.render();
	}

	public java.lang.Object generate(FunctionalComponent model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("FunctionalComponent");
		model.getInject().forEach((element) -> st.add("inject", generate(element)));
		st.add("wrapper", generate(model.getWrapper()));
		model.getDependencies().forEach((element) -> st.add("dependencies", generate(element)));
		st.add("name", generate(model.getName()));
		st.add("element", generate(model.getElement()));
		model.getLocalImports().forEach((element) -> st.add("localImports", generate(element)));
		return st.render();
	}

	public java.lang.Object generate(MenuItem model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("MenuItem");
		st.add("name", generate(model.getName()));
		st.add("title", generate(model.getTitle()));
		return st.render();
	}

	public java.lang.Object generate(returnStatement model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("returnStatement");
		st.add("element", generate(model.getElement()));
		st.add("condition", generate(model.getCondition()));
		return st.render();
	}

	public java.lang.Object generate(Prop model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("Prop");
		st.add("value", generate(model.getValue()));
		st.add("name", generate(model.getName()));
		return st.render();
	}

	public java.lang.Object generate(ForwardRef model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ForwardRef");
		st.add("forward", generate(model.getForward()));
		st.add("name", generate(model.getName()));
		return st.render();
	}

	public java.lang.Object generate(Function model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("Function");
		st.add("name", generate(model.getName()));
		st.add("body", generate(model.getBody()));
		model.getParameters().forEach((element) -> st.add("parameters", generate(element)));
		return st.render();
	}

	public java.lang.Object generate(MobX model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("MobX");
		return st.render();
	}

	public java.lang.Object generate(StyleComponent model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("StyleComponent");
		model.getElements().forEach((element) -> st.add("elements", generate(element)));
		return st.render();
	}

	public java.lang.Object generate(GlobalStyle model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("GlobalStyle");
		st.add("name", generate(model.getName()));
		model.getProperties().forEach((element) -> st.addAggr("properties.{key,value}", generate(element.getKey()), generate(element.getValue())));
		return st.render();
	}

	public java.lang.Object generate(Decorator model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("Decorator");
		st.add("name", generate(model.getName()));
		model.getParameters().forEach((element) -> st.add("parameters", generate(element)));
		return st.render();
	}

	public java.lang.Object generate(If model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("If");
		st.add("blockStmt", generate(model.getBlockStmt()));
		st.add("condition", generate(model.getCondition()));
		return st.render();
	}

	public java.lang.Object generate(Inject model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("Inject");
		model.getValues().forEach((element) -> st.add("values", generate(element)));
		return st.render();
	}

	public java.lang.Object generate(SimpleMenu model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("SimpleMenu");
		model.getMenuItems().forEach((element) -> st.addAggr("menuItems.{name,to,target}", generate(element.getName()), generate(element.getTo()), generate(element.getTarget())));
		model.getMenuComponents().forEach((element) -> st.add("menuComponents", generate(element)));
		return st.render();
	}

	public java.lang.Object generate(defaultImport model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("defaultImport");
		st.add("name", generate(model.getName()));
		return st.render();
	}

	public java.lang.Object generate(Style model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("Style");
		model.getProperties().forEach((element) -> st.addAggr("properties.{key,value}", generate(element.getKey()), generate(element.getValue())));
		st.add("name", generate(model.getName()));
		return st.render();
	}

	public java.lang.Object generate(JsonObject model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("JsonObject");
		model.getValues().forEach((element) -> st.add("values", generate(element)));
		return st.render();
	}

	public java.lang.Object generate(Element model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("Element");
		model.getProps().forEach((element) -> st.add("props", generate(element)));
		model.getChildren().forEach((element) -> st.add("children", generate(element)));
		st.add("name", generate(model.getName()));
		return st.render();
	}

	public java.lang.Object generate(MethodDeclaration model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("MethodDeclaration");
		st.add("name", generate(model.getName()));
		st.add("parameter", generate(model.getParameter()));
		model.getStatements().forEach((element) -> st.add("statements", generate(element)));
		return st.render();
	}

	public java.lang.Object generate(NameValue model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("NameValue");
		st.add("value", generate(model.getValue()));
		st.add("name", generate(model.getName()));
		return st.render();
	}

	public java.lang.Object generate(withStyles model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("withStyles");
		return st.render();
	}

	public java.lang.Object generate(namedImport model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("namedImport");
		model.getNames().forEach((element) -> st.add("names", generate(element)));
		return st.render();
	}

	public java.lang.Object generate(NameArray model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("NameArray");
		st.add("name", generate(model.getName()));
		model.getValues().forEach((element) -> st.add("values", generate(element)));
		return st.render();
	}

	public java.lang.Object generate(ClassComponent model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ClassComponent");
		model.getMethods().forEach((element) -> st.add("methods", generate(element)));
		model.getComponents().forEach((element) -> st.add("components", generate(element)));
		model.getEvents().forEach((element) -> st.addAggr("events.{methodName}", generate(element.getMethodName())));
		st.add("name", generate(model.getName()));
		model.getState().forEach((element) -> st.add("state", generate(element)));
		model.getRenderConstants().forEach((element) -> st.add("renderConstants", generate(element)));
		model.getDecorators().forEach((element) -> st.add("decorators", generate(element)));
		model.getDependencies().forEach((element) -> st.add("dependencies", generate(element)));
		model.getReturnStatements().forEach((element) -> st.add("returnStatements", generate(element)));
		return st.render();
	}

	public java.lang.Object generate(MaterialUI model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("MaterialUI");
		return st.render();
	}

	public java.lang.Object generate(State model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("State");
		model.getValues().forEach((element) -> st.addAggr("values.{name,value}", generate(element.getName()), generate(element.getValue())));
		return st.render();
	}

	public java.lang.Object generate(MaterialUIGroup model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("MaterialUIGroup");
		model.getElements().forEach((element) -> st.add("elements", generate(element)));
		st.add("packageName", generate(model.getPackageName()));
		return st.render();
	}

	public java.lang.Object generate(App model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("App");
		model.getComponents().forEach((element) -> st.addAggr("components.{path,name}", generate(element.getPath()), generate(element.getName())));
		return st.render();
	}

	public java.lang.Object generate(Dependency model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("Dependency");
		st.add("value", generate(model.getValue()));
		st.add("packageName", generate(model.getPackageName()));
		return st.render();
	}

	public java.lang.Object generate(BlockStmt model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("BlockStmt");
		model.getChildren().forEach((element) -> st.add("children", generate(element)));
		st.add("stmt", generate(model.getStmt()));
		return st.render();
	}

	public java.lang.Object generate(cssProp model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("cssProp");
		st.add("name", generate(model.getName()));
		st.add("value", generate(model.getValue()));
		return st.render();
	}

	public java.lang.Object generate(Link model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("Link");
		st.add("to", generate(model.getTo()));
		return st.render();
	}

	public java.lang.Object generate(java.lang.Object model) { 
		if (model instanceof DestructorProp) return generate((DestructorProp) model);
		if (model instanceof FunctionalComponent) return generate((FunctionalComponent) model);
		if (model instanceof MenuItem) return generate((MenuItem) model);
		if (model instanceof returnStatement) return generate((returnStatement) model);
		if (model instanceof Prop) return generate((Prop) model);
		if (model instanceof ForwardRef) return generate((ForwardRef) model);
		if (model instanceof Function) return generate((Function) model);
		if (model instanceof MobX) return generate((MobX) model);
		if (model instanceof StyleComponent) return generate((StyleComponent) model);
		if (model instanceof GlobalStyle) return generate((GlobalStyle) model);
		if (model instanceof Decorator) return generate((Decorator) model);
		if (model instanceof If) return generate((If) model);
		if (model instanceof Inject) return generate((Inject) model);
		if (model instanceof SimpleMenu) return generate((SimpleMenu) model);
		if (model instanceof defaultImport) return generate((defaultImport) model);
		if (model instanceof Style) return generate((Style) model);
		if (model instanceof JsonObject) return generate((JsonObject) model);
		if (model instanceof Element) return generate((Element) model);
		if (model instanceof MethodDeclaration) return generate((MethodDeclaration) model);
		if (model instanceof NameValue) return generate((NameValue) model);
		if (model instanceof withStyles) return generate((withStyles) model);
		if (model instanceof namedImport) return generate((namedImport) model);
		if (model instanceof NameArray) return generate((NameArray) model);
		if (model instanceof ClassComponent) return generate((ClassComponent) model);
		if (model instanceof MaterialUI) return generate((MaterialUI) model);
		if (model instanceof State) return generate((State) model);
		if (model instanceof MaterialUIGroup) return generate((MaterialUIGroup) model);
		if (model instanceof App) return generate((App) model);
		if (model instanceof Dependency) return generate((Dependency) model);
		if (model instanceof BlockStmt) return generate((BlockStmt) model);
		if (model instanceof cssProp) return generate((cssProp) model);
		if (model instanceof Link) return generate((Link) model);
		return model;
	}
}