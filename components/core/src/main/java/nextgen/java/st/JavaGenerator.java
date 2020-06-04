package nextgen.java.st;


public class JavaGenerator {

	private final org.stringtemplate.v4.STGroup stGroup;

	public JavaGenerator() { 
		this(new org.stringtemplate.v4.STGroupFile("templates/Java.stg"));
	}

	public JavaGenerator(java.io.File file) { 
		this(new org.stringtemplate.v4.STGroupFile(file.getAbsolutePath()));
	}

	public JavaGenerator(org.stringtemplate.v4.STGroup stGroup) { 
		this.stGroup = stGroup;
	}

	public java.lang.Object generate(Modifier model) { 
		return model;
	}

	public java.lang.Object generate(CatchClause model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("CatchClause");
		st.add("parameter", generate(model.getParameter()));
		st.add("body", generate(model.getBody()));
		return st.render();
	}

	public java.lang.Object generate(TypeParameter model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("TypeParameter");
		st.add("name", generate(model.getName()));
		model.getTypeBounds().forEach((element) -> st.add("typeBounds", generate(element)));
		return st.render();
	}

	public java.lang.Object generate(ArrayCreationLevel model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ArrayCreationLevel");
		st.add("dimension", generate(model.getDimension()));
		return st.render();
	}

	public java.lang.Object generate(ThisVariableExpression model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ThisVariableExpression");
		st.add("value", generate(model.getValue()));
		return st.render();
	}

	public java.lang.Object generate(ConditionalExpression model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ConditionalExpression");
		st.add("elseExpression", generate(model.getElseExpression()));
		st.add("thenExpression", generate(model.getThenExpression()));
		st.add("condition", generate(model.getCondition()));
		return st.render();
	}

	public java.lang.Object generate(EmptyStmt model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("EmptyStmt");
		return st.render();
	}

	public java.lang.Object generate(IfStmt model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("IfStmt");
		st.add("elseStmt", generate(model.getElseStmt()));
		st.add("condition", generate(model.getCondition()));
		st.add("then", generate(model.getThen()));
		return st.render();
	}

	public java.lang.Object generate(SuperExpression model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("SuperExpression");
		st.add("typeName", generate(model.getTypeName()));
		return st.render();
	}

	public java.lang.Object generate(AnnotationMemberDeclaration model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("AnnotationMemberDeclaration");
		st.add("defaultValue", generate(model.getDefaultValue()));
		st.add("type", generate(model.getType()));
		st.add("name", generate(model.getName()));
		return st.render();
	}

	public java.lang.Object generate(CompilationUnit model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("CompilationUnit");
		st.add("packageDeclaration", generate(model.getPackageDeclaration()));
		model.getTypes().forEach((element) -> st.add("types", generate(element)));
		model.getImportDeclaration().forEach((element) -> st.add("importDeclaration", generate(element)));
		return st.render();
	}

	public java.lang.Object generate(StringLiteralExpression model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("StringLiteralExpression");
		st.add("value", generate(model.getValue()));
		return st.render();
	}

	public java.lang.Object generate(LambdaExpression model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("LambdaExpression");
		model.getParameters().forEach((element) -> st.add("parameters", generate(element)));
		st.add("body", generate(model.getBody()));
		return st.render();
	}

	public java.lang.Object generate(MarkerAnnotationExpression model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("MarkerAnnotationExpression");
		st.add("name", generate(model.getName()));
		return st.render();
	}

	public java.lang.Object generate(ForStmt model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ForStmt");
		st.add("compare", generate(model.getCompare()));
		model.getUpdate().forEach((element) -> st.add("update", generate(element)));
		model.getInitialization().forEach((element) -> st.add("initialization", generate(element)));
		st.add("body", generate(model.getBody()));
		return st.render();
	}

	public java.lang.Object generate(StaticFinalFieldDeclaration model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("StaticFinalFieldDeclaration");
		st.add("initializer", generate(model.getInitializer()));
		st.add("name", generate(model.getName()));
		st.add("type", generate(model.getType()));
		return st.render();
	}

	public java.lang.Object generate(ReturnStmt model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ReturnStmt");
		st.add("expression", generate(model.getExpression()));
		return st.render();
	}

	public java.lang.Object generate(ExplicitConstructorInvocationStmt model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ExplicitConstructorInvocationStmt");
		model.getArguments().forEach((element) -> st.add("arguments", generate(element)));
		st.add("isThis", generate(model.isThis()));
		return st.render();
	}

	public java.lang.Object generate(BooleanLiteralExpression model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("BooleanLiteralExpression");
		st.add("value", generate(model.getValue()));
		return st.render();
	}

	public java.lang.Object generate(ArrayAccessExpression model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ArrayAccessExpression");
		st.add("index", generate(model.getIndex()));
		st.add("name", generate(model.getName()));
		return st.render();
	}

	public java.lang.Object generate(SwitchEntryStmt model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("SwitchEntryStmt");
		model.getLabels().forEach((element) -> st.add("labels", generate(element)));
		model.getStatements().forEach((element) -> st.add("statements", generate(element)));
		return st.render();
	}

	public java.lang.Object generate(ContinueStmt model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ContinueStmt");
		st.add("label", generate(model.getLabel()));
		return st.render();
	}

	public java.lang.Object generate(VariableDeclaration model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("VariableDeclaration");
		st.add("type", generate(model.getType()));
		st.add("initializer", generate(model.getInitializer()));
		st.add("name", generate(model.getName()));
		return st.render();
	}

	public java.lang.Object generate(BreakStmt model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("BreakStmt");
		st.add("label", generate(model.getLabel()));
		return st.render();
	}

	public java.lang.Object generate(PublicFinalFieldDeclaration model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("PublicFinalFieldDeclaration");
		st.add("initializer", generate(model.getInitializer()));
		st.add("name", generate(model.getName()));
		st.add("type", generate(model.getType()));
		return st.render();
	}

	public java.lang.Object generate(ThisExpression model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ThisExpression");
		st.add("typeName", generate(model.getTypeName()));
		return st.render();
	}

	public java.lang.Object generate(ThrowStmt model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ThrowStmt");
		st.add("expression", generate(model.getExpression()));
		return st.render();
	}

	public java.lang.Object generate(PackageDeclaration model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("PackageDeclaration");
		st.add("name", generate(model.getName()));
		return st.render();
	}

	public java.lang.Object generate(LongExpression model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("LongExpression");
		st.add("value", generate(model.getValue()));
		return st.render();
	}

	public java.lang.Object generate(Parameter model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("Parameter");
		model.getModifiers().forEach((element) -> st.add("modifiers", generate(element)));
		model.getAnnotations().forEach((element) -> st.add("annotations", generate(element)));
		st.add("name", generate(model.getName()));
		st.add("type", generate(model.getType()));
		st.add("isVarargs", generate(model.isVarargs()));
		return st.render();
	}

	public java.lang.Object generate(NullLiteralExpression model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("NullLiteralExpression");
		st.add("value", generate(model.getValue()));
		return st.render();
	}

	public java.lang.Object generate(staticPublicFinalFieldDeclaration model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("staticPublicFinalFieldDeclaration");
		st.add("initializer", generate(model.getInitializer()));
		st.add("name", generate(model.getName()));
		st.add("type", generate(model.getType()));
		return st.render();
	}

	public java.lang.Object generate(MethodCallExpression model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("MethodCallExpression");
		st.add("name", generate(model.getName()));
		st.add("scope", generate(model.getScope()));
		model.getArguments().forEach((element) -> st.add("arguments", generate(element)));
		model.getTypeArguments().forEach((element) -> st.add("typeArguments", generate(element)));
		return st.render();
	}

	public java.lang.Object generate(InstanceOfExpression model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("InstanceOfExpression");
		st.add("type", generate(model.getType()));
		st.add("expression", generate(model.getExpression()));
		return st.render();
	}

	public java.lang.Object generate(BlockStmt model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("BlockStmt");
		model.getStatements().forEach((element) -> st.add("statements", generate(element)));
		return st.render();
	}

	public java.lang.Object generate(UnaryExpression model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("UnaryExpression");
		st.add("operator", generate(model.getOperator()));
		st.add("expression", generate(model.getExpression()));
		st.add("isPostfix", generate(model.isPostfix()));
		st.add("isPrefix", generate(model.isPrefix()));
		return st.render();
	}

	public java.lang.Object generate(ClassOrInterfaceType model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ClassOrInterfaceType");
		model.getNames().forEach((element) -> st.add("names", generate(element)));
		st.add("scope", generate(model.getScope()));
		model.getTypeArguments().forEach((element) -> st.add("typeArguments", generate(element)));
		st.add("isTyped", generate(model.isTyped()));
		st.add("isArrayType", generate(model.isArrayType()));
		return st.render();
	}

	public java.lang.Object generate(AnnotationDeclaration model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("AnnotationDeclaration");
		model.getMembers().forEach((element) -> st.add("members", generate(element)));
		model.getModifiers().forEach((element) -> st.add("modifiers", generate(element)));
		model.getAnnotations().forEach((element) -> st.add("annotations", generate(element)));
		st.add("name", generate(model.getName()));
		return st.render();
	}

	public java.lang.Object generate(CastExpression model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("CastExpression");
		st.add("type", generate(model.getType()));
		st.add("expression", generate(model.getExpression()));
		return st.render();
	}

	public java.lang.Object generate(ObjectCreationExpression model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ObjectCreationExpression");
		model.getAnonymousClassBodies().forEach((element) -> st.add("anonymousClassBodies", generate(element)));
		model.getTypeArguments().forEach((element) -> st.add("typeArguments", generate(element)));
		model.getArguments().forEach((element) -> st.add("arguments", generate(element)));
		st.add("type", generate(model.getType()));
		st.add("scope", generate(model.getScope()));
		return st.render();
	}

	public java.lang.Object generate(BinaryExpression model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("BinaryExpression");
		st.add("left", generate(model.getLeft()));
		st.add("operator", generate(model.getOperator()));
		st.add("right", generate(model.getRight()));
		return st.render();
	}

	public java.lang.Object generate(ExpressionStmt model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ExpressionStmt");
		st.add("expression", generate(model.getExpression()));
		st.add("comment", generate(model.getComment()));
		return st.render();
	}

	public java.lang.Object generate(DoubleLiteralExpression model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("DoubleLiteralExpression");
		st.add("value", generate(model.getValue()));
		return st.render();
	}

	public java.lang.Object generate(PrivateFieldDeclaration model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("PrivateFieldDeclaration");
		st.add("initializer", generate(model.getInitializer()));
		st.add("name", generate(model.getName()));
		st.add("type", generate(model.getType()));
		return st.render();
	}

	public java.lang.Object generate(EnumConstant model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("EnumConstant");
		model.getMethods().forEach((element) -> st.add("methods", generate(element)));
		st.add("name", generate(model.getName()));
		model.getArguments().forEach((element) -> st.add("arguments", generate(element)));
		model.getAnnotations().forEach((element) -> st.add("annotations", generate(element)));
		return st.render();
	}

	public java.lang.Object generate(NormalAnnotationExpression model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("NormalAnnotationExpression");
		st.add("name", generate(model.getName()));
		model.getMemberValues().forEach((element) -> st.add("memberValues", generate(element)));
		return st.render();
	}

	public java.lang.Object generate(AssignExpression model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("AssignExpression");
		st.add("value", generate(model.getValue()));
		st.add("operator", generate(model.getOperator()));
		st.add("target", generate(model.getTarget()));
		return st.render();
	}

	public java.lang.Object generate(WhileStmt model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("WhileStmt");
		st.add("body", generate(model.getBody()));
		st.add("condition", generate(model.getCondition()));
		return st.render();
	}

	public java.lang.Object generate(EnclosedExpression model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("EnclosedExpression");
		st.add("expression", generate(model.getExpression()));
		return st.render();
	}

	public java.lang.Object generate(MemberValuePair model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("MemberValuePair");
		st.add("name", generate(model.getName()));
		st.add("value", generate(model.getValue()));
		return st.render();
	}

	public java.lang.Object generate(DoStmt model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("DoStmt");
		st.add("condition", generate(model.getCondition()));
		st.add("body", generate(model.getBody()));
		return st.render();
	}

	public java.lang.Object generate(ForEachStmt model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ForEachStmt");
		st.add("iterable", generate(model.getIterable()));
		st.add("variable", generate(model.getVariable()));
		st.add("body", generate(model.getBody()));
		return st.render();
	}

	public java.lang.Object generate(QualifierName model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("QualifierName");
		model.getValue().forEach((element) -> st.add("value", generate(element)));
		return st.render();
	}

	public java.lang.Object generate(ConstructorDeclaration model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ConstructorDeclaration");
		model.getTypeParameters().forEach((element) -> st.add("typeParameters", generate(element)));
		model.getParameters().forEach((element) -> st.add("parameters", generate(element)));
		model.getAnnotations().forEach((element) -> st.add("annotations", generate(element)));
		st.add("name", generate(model.getName()));
		model.getModifiers().forEach((element) -> st.add("modifiers", generate(element)));
		model.getThrownExceptions().forEach((element) -> st.add("thrownExceptions", generate(element)));
		st.add("blockStmt", generate(model.getBlockStmt()));
		return st.render();
	}

	public java.lang.Object generate(IntegerLiteralExpression model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("IntegerLiteralExpression");
		st.add("value", generate(model.getValue()));
		return st.render();
	}

	public java.lang.Object generate(SwitchStmt model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("SwitchStmt");
		model.getEntries().forEach((element) -> st.add("entries", generate(element)));
		st.add("selector", generate(model.getSelector()));
		return st.render();
	}

	public java.lang.Object generate(FinalFieldDeclaration model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("FinalFieldDeclaration");
		st.add("initializer", generate(model.getInitializer()));
		st.add("name", generate(model.getName()));
		st.add("type", generate(model.getType()));
		return st.render();
	}

	public java.lang.Object generate(EnumDeclaration model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("EnumDeclaration");
		model.getAnnotations().forEach((element) -> st.add("annotations", generate(element)));
		model.getEntries().forEach((element) -> st.add("entries", generate(element)));
		model.getMembers().forEach((element) -> st.add("members", generate(element)));
		st.add("name", generate(model.getName()));
		model.getExtend().forEach((element) -> st.add("extend", generate(element)));
		model.getModifiers().forEach((element) -> st.add("modifiers", generate(element)));
		model.getImplementedTypes().forEach((element) -> st.add("implementedTypes", generate(element)));
		return st.render();
	}

	public java.lang.Object generate(NameExpression model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("NameExpression");
		st.add("value", generate(model.getValue()));
		return st.render();
	}

	public java.lang.Object generate(MethodDeclaration model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("MethodDeclaration");
		model.getAnnotations().forEach((element) -> st.add("annotations", generate(element)));
		st.add("type", generate(model.getType()));
		model.getModifiers().forEach((element) -> st.add("modifiers", generate(element)));
		model.getTypeParameters().forEach((element) -> st.add("typeParameters", generate(element)));
		model.getParameters().forEach((element) -> st.add("parameters", generate(element)));
		model.getThrownExceptions().forEach((element) -> st.add("thrownExceptions", generate(element)));
		st.add("name", generate(model.getName()));
		st.add("blockStmt", generate(model.getBlockStmt()));
		st.add("isInterfaceDeclaration", generate(model.isInterfaceDeclaration()));
		return st.render();
	}

	public java.lang.Object generate(ClassExpression model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ClassExpression");
		st.add("type", generate(model.getType()));
		return st.render();
	}

	public java.lang.Object generate(SynchronizedStmt model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("SynchronizedStmt");
		st.add("body", generate(model.getBody()));
		st.add("expression", generate(model.getExpression()));
		return st.render();
	}

	public java.lang.Object generate(LabeledStmt model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("LabeledStmt");
		st.add("statement", generate(model.getStatement()));
		st.add("label", generate(model.getLabel()));
		return st.render();
	}

	public java.lang.Object generate(MethodReferenceExpression model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("MethodReferenceExpression");
		st.add("identifier", generate(model.getIdentifier()));
		st.add("scope", generate(model.getScope()));
		return st.render();
	}

	public java.lang.Object generate(TryStmt model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("TryStmt");
		model.getResources().forEach((element) -> st.add("resources", generate(element)));
		st.add("finalClause", generate(model.getFinalClause()));
		st.add("tryBlock", generate(model.getTryBlock()));
		model.getCatchClauses().forEach((element) -> st.add("catchClauses", generate(element)));
		return st.render();
	}

	public java.lang.Object generate(FieldDeclaration model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("FieldDeclaration");
		model.getAnnotations().forEach((element) -> st.add("annotations", generate(element)));
		model.getModifiers().forEach((element) -> st.add("modifiers", generate(element)));
		model.getVariables().forEach((element) -> st.add("variables", generate(element)));
		return st.render();
	}

	public java.lang.Object generate(AssertStmt model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("AssertStmt");
		st.add("expression", generate(model.getExpression()));
		st.add("message", generate(model.getMessage()));
		return st.render();
	}

	public java.lang.Object generate(FieldAccessExpression model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("FieldAccessExpression");
		st.add("name", generate(model.getName()));
		st.add("scope", generate(model.getScope()));
		return st.render();
	}

	public java.lang.Object generate(ArrayCreationExpression model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ArrayCreationExpression");
		model.getLevels().forEach((element) -> st.add("levels", generate(element)));
		st.add("initializer", generate(model.getInitializer()));
		st.add("type", generate(model.getType()));
		return st.render();
	}

	public java.lang.Object generate(ArrayInitializerExpression model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ArrayInitializerExpression");
		model.getValues().forEach((element) -> st.add("values", generate(element)));
		return st.render();
	}

	public java.lang.Object generate(VariableDeclarationExpression model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("VariableDeclarationExpression");
		model.getModifiers().forEach((element) -> st.add("modifiers", generate(element)));
		model.getVariables().forEach((element) -> st.add("variables", generate(element)));
		return st.render();
	}

	public java.lang.Object generate(AssignThisVariableExpression model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("AssignThisVariableExpression");
		st.add("value", generate(model.getValue()));
		return st.render();
	}

	public java.lang.Object generate(JavaPackageInfo model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("JavaPackageInfo");
		model.getInterfaces().forEach((element) -> st.add("interfaces", generate(element)));
		st.add("packageName", generate(model.getPackageName()));
		model.getClasses().forEach((element) -> st.add("classes", generate(element)));
		return st.render();
	}

	public java.lang.Object generate(ModuleDeclaration model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ModuleDeclaration");
		st.add("name", generate(model.getName()));
		model.getExportsDirective().forEach((element) -> st.add("exportsDirective", generate(element)));
		model.getProvidesDirective().forEach((element) -> st.add("providesDirective", generate(element)));
		model.getOpens().forEach((element) -> st.add("opens", generate(element)));
		model.getRequiresDirective().forEach((element) -> st.add("requiresDirective", generate(element)));
		model.getUsesDirective().forEach((element) -> st.add("usesDirective", generate(element)));
		return st.render();
	}

	public java.lang.Object generate(ImportDeclaration model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ImportDeclaration");
		st.add("name", generate(model.getName()));
		st.add("isAsterisk", generate(model.isAsterisk()));
		st.add("isStatic", generate(model.isStatic()));
		return st.render();
	}

	public java.lang.Object generate(StaticPrivateFinalFieldDeclaration model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("StaticPrivateFinalFieldDeclaration");
		st.add("initializer", generate(model.getInitializer()));
		st.add("name", generate(model.getName()));
		st.add("type", generate(model.getType()));
		return st.render();
	}

	public java.lang.Object generate(ClassOrInterfaceDeclaration model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ClassOrInterfaceDeclaration");
		model.getImplementedTypes().forEach((element) -> st.add("implementedTypes", generate(element)));
		model.getComments().forEach((element) -> st.add("comments", generate(element)));
		model.getTypeParameters().forEach((element) -> st.add("typeParameters", generate(element)));
		st.add("name", generate(model.getName()));
		model.getExtend().forEach((element) -> st.add("extend", generate(element)));
		model.getFields().forEach((element) -> st.add("fields", generate(element)));
		model.getAnnotations().forEach((element) -> st.add("annotations", generate(element)));
		model.getMembers().forEach((element) -> st.add("members", generate(element)));
		model.getModifiers().forEach((element) -> st.add("modifiers", generate(element)));
		st.add("isInterface", generate(model.isInterface()));
		return st.render();
	}

	public java.lang.Object generate(CharLiteralExpression model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("CharLiteralExpression");
		st.add("value", generate(model.getValue()));
		return st.render();
	}

	public java.lang.Object generate(PrivateFinalFieldDeclaration model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("PrivateFinalFieldDeclaration");
		st.add("initializer", generate(model.getInitializer()));
		st.add("name", generate(model.getName()));
		st.add("type", generate(model.getType()));
		return st.render();
	}

	public java.lang.Object generate(SingleMemberAnnotationExpression model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("SingleMemberAnnotationExpression");
		model.getMembers().forEach((element) -> st.add("members", generate(element)));
		st.add("name", generate(model.getName()));
		return st.render();
	}

	public java.lang.Object generate(CompilationUnitMember model) { 
		if (model instanceof EnumDeclaration) return generate((EnumDeclaration) model);
		if (model instanceof ClassOrInterfaceDeclaration) return generate((ClassOrInterfaceDeclaration) model);
		return model;
	}

	public java.lang.Object generate(ClassOrInterfaceMember model) { 
		if (model instanceof ConstructorDeclaration) return generate((ConstructorDeclaration) model);
		if (model instanceof EnumDeclaration) return generate((EnumDeclaration) model);
		if (model instanceof MethodDeclaration) return generate((MethodDeclaration) model);
		if (model instanceof ClassOrInterfaceDeclaration) return generate((ClassOrInterfaceDeclaration) model);
		return model;
	}

	public java.lang.Object generate(AnnotationExpression model) { 
		if (model instanceof MarkerAnnotationExpression) return generate((MarkerAnnotationExpression) model);
		if (model instanceof NormalAnnotationExpression) return generate((NormalAnnotationExpression) model);
		if (model instanceof SingleMemberAnnotationExpression) return generate((SingleMemberAnnotationExpression) model);
		return model;
	}

	public java.lang.Object generate(Statement model) { 
		if (model instanceof EmptyStmt) return generate((EmptyStmt) model);
		if (model instanceof IfStmt) return generate((IfStmt) model);
		if (model instanceof ForStmt) return generate((ForStmt) model);
		if (model instanceof ReturnStmt) return generate((ReturnStmt) model);
		if (model instanceof ExplicitConstructorInvocationStmt) return generate((ExplicitConstructorInvocationStmt) model);
		if (model instanceof SwitchEntryStmt) return generate((SwitchEntryStmt) model);
		if (model instanceof ContinueStmt) return generate((ContinueStmt) model);
		if (model instanceof BreakStmt) return generate((BreakStmt) model);
		if (model instanceof ThrowStmt) return generate((ThrowStmt) model);
		if (model instanceof BlockStmt) return generate((BlockStmt) model);
		if (model instanceof ExpressionStmt) return generate((ExpressionStmt) model);
		if (model instanceof WhileStmt) return generate((WhileStmt) model);
		if (model instanceof DoStmt) return generate((DoStmt) model);
		if (model instanceof ForEachStmt) return generate((ForEachStmt) model);
		if (model instanceof SwitchStmt) return generate((SwitchStmt) model);
		if (model instanceof SynchronizedStmt) return generate((SynchronizedStmt) model);
		if (model instanceof LabeledStmt) return generate((LabeledStmt) model);
		if (model instanceof TryStmt) return generate((TryStmt) model);
		if (model instanceof AssertStmt) return generate((AssertStmt) model);
		return model;
	}

	public java.lang.Object generate(Expression model) { 
		if (model instanceof ThisVariableExpression) return generate((ThisVariableExpression) model);
		if (model instanceof ConditionalExpression) return generate((ConditionalExpression) model);
		if (model instanceof SuperExpression) return generate((SuperExpression) model);
		if (model instanceof StringLiteralExpression) return generate((StringLiteralExpression) model);
		if (model instanceof LambdaExpression) return generate((LambdaExpression) model);
		if (model instanceof MarkerAnnotationExpression) return generate((MarkerAnnotationExpression) model);
		if (model instanceof BooleanLiteralExpression) return generate((BooleanLiteralExpression) model);
		if (model instanceof ArrayAccessExpression) return generate((ArrayAccessExpression) model);
		if (model instanceof VariableDeclaration) return generate((VariableDeclaration) model);
		if (model instanceof ThisExpression) return generate((ThisExpression) model);
		if (model instanceof LongExpression) return generate((LongExpression) model);
		if (model instanceof NullLiteralExpression) return generate((NullLiteralExpression) model);
		if (model instanceof MethodCallExpression) return generate((MethodCallExpression) model);
		if (model instanceof InstanceOfExpression) return generate((InstanceOfExpression) model);
		if (model instanceof UnaryExpression) return generate((UnaryExpression) model);
		if (model instanceof CastExpression) return generate((CastExpression) model);
		if (model instanceof ObjectCreationExpression) return generate((ObjectCreationExpression) model);
		if (model instanceof BinaryExpression) return generate((BinaryExpression) model);
		if (model instanceof DoubleLiteralExpression) return generate((DoubleLiteralExpression) model);
		if (model instanceof NormalAnnotationExpression) return generate((NormalAnnotationExpression) model);
		if (model instanceof AssignExpression) return generate((AssignExpression) model);
		if (model instanceof EnclosedExpression) return generate((EnclosedExpression) model);
		if (model instanceof IntegerLiteralExpression) return generate((IntegerLiteralExpression) model);
		if (model instanceof NameExpression) return generate((NameExpression) model);
		if (model instanceof ClassExpression) return generate((ClassExpression) model);
		if (model instanceof MethodReferenceExpression) return generate((MethodReferenceExpression) model);
		if (model instanceof FieldAccessExpression) return generate((FieldAccessExpression) model);
		if (model instanceof ArrayCreationExpression) return generate((ArrayCreationExpression) model);
		if (model instanceof ArrayInitializerExpression) return generate((ArrayInitializerExpression) model);
		if (model instanceof VariableDeclarationExpression) return generate((VariableDeclarationExpression) model);
		if (model instanceof AssignThisVariableExpression) return generate((AssignThisVariableExpression) model);
		if (model instanceof CharLiteralExpression) return generate((CharLiteralExpression) model);
		if (model instanceof SingleMemberAnnotationExpression) return generate((SingleMemberAnnotationExpression) model);
		return model;
	}

	public java.lang.Object generate(LambdaBody model) { 
		if (model instanceof ThisVariableExpression) return generate((ThisVariableExpression) model);
		if (model instanceof ConditionalExpression) return generate((ConditionalExpression) model);
		if (model instanceof EmptyStmt) return generate((EmptyStmt) model);
		if (model instanceof IfStmt) return generate((IfStmt) model);
		if (model instanceof SuperExpression) return generate((SuperExpression) model);
		if (model instanceof StringLiteralExpression) return generate((StringLiteralExpression) model);
		if (model instanceof LambdaExpression) return generate((LambdaExpression) model);
		if (model instanceof MarkerAnnotationExpression) return generate((MarkerAnnotationExpression) model);
		if (model instanceof ForStmt) return generate((ForStmt) model);
		if (model instanceof ReturnStmt) return generate((ReturnStmt) model);
		if (model instanceof ExplicitConstructorInvocationStmt) return generate((ExplicitConstructorInvocationStmt) model);
		if (model instanceof BooleanLiteralExpression) return generate((BooleanLiteralExpression) model);
		if (model instanceof ArrayAccessExpression) return generate((ArrayAccessExpression) model);
		if (model instanceof SwitchEntryStmt) return generate((SwitchEntryStmt) model);
		if (model instanceof ContinueStmt) return generate((ContinueStmt) model);
		if (model instanceof BreakStmt) return generate((BreakStmt) model);
		if (model instanceof ThisExpression) return generate((ThisExpression) model);
		if (model instanceof ThrowStmt) return generate((ThrowStmt) model);
		if (model instanceof LongExpression) return generate((LongExpression) model);
		if (model instanceof NullLiteralExpression) return generate((NullLiteralExpression) model);
		if (model instanceof MethodCallExpression) return generate((MethodCallExpression) model);
		if (model instanceof InstanceOfExpression) return generate((InstanceOfExpression) model);
		if (model instanceof BlockStmt) return generate((BlockStmt) model);
		if (model instanceof UnaryExpression) return generate((UnaryExpression) model);
		if (model instanceof CastExpression) return generate((CastExpression) model);
		if (model instanceof ObjectCreationExpression) return generate((ObjectCreationExpression) model);
		if (model instanceof BinaryExpression) return generate((BinaryExpression) model);
		if (model instanceof ExpressionStmt) return generate((ExpressionStmt) model);
		if (model instanceof DoubleLiteralExpression) return generate((DoubleLiteralExpression) model);
		if (model instanceof NormalAnnotationExpression) return generate((NormalAnnotationExpression) model);
		if (model instanceof AssignExpression) return generate((AssignExpression) model);
		if (model instanceof WhileStmt) return generate((WhileStmt) model);
		if (model instanceof EnclosedExpression) return generate((EnclosedExpression) model);
		if (model instanceof DoStmt) return generate((DoStmt) model);
		if (model instanceof ForEachStmt) return generate((ForEachStmt) model);
		if (model instanceof IntegerLiteralExpression) return generate((IntegerLiteralExpression) model);
		if (model instanceof SwitchStmt) return generate((SwitchStmt) model);
		if (model instanceof NameExpression) return generate((NameExpression) model);
		if (model instanceof ClassExpression) return generate((ClassExpression) model);
		if (model instanceof SynchronizedStmt) return generate((SynchronizedStmt) model);
		if (model instanceof LabeledStmt) return generate((LabeledStmt) model);
		if (model instanceof MethodReferenceExpression) return generate((MethodReferenceExpression) model);
		if (model instanceof TryStmt) return generate((TryStmt) model);
		if (model instanceof AssertStmt) return generate((AssertStmt) model);
		if (model instanceof FieldAccessExpression) return generate((FieldAccessExpression) model);
		if (model instanceof ArrayCreationExpression) return generate((ArrayCreationExpression) model);
		if (model instanceof ArrayInitializerExpression) return generate((ArrayInitializerExpression) model);
		if (model instanceof VariableDeclarationExpression) return generate((VariableDeclarationExpression) model);
		if (model instanceof AssignThisVariableExpression) return generate((AssignThisVariableExpression) model);
		if (model instanceof CharLiteralExpression) return generate((CharLiteralExpression) model);
		if (model instanceof SingleMemberAnnotationExpression) return generate((SingleMemberAnnotationExpression) model);
		return model;
	}

	public java.lang.Object generate(java.lang.Object model) { 
		if (model instanceof CatchClause) return generate((CatchClause) model);
		if (model instanceof TypeParameter) return generate((TypeParameter) model);
		if (model instanceof ArrayCreationLevel) return generate((ArrayCreationLevel) model);
		if (model instanceof ThisVariableExpression) return generate((ThisVariableExpression) model);
		if (model instanceof ConditionalExpression) return generate((ConditionalExpression) model);
		if (model instanceof EmptyStmt) return generate((EmptyStmt) model);
		if (model instanceof IfStmt) return generate((IfStmt) model);
		if (model instanceof SuperExpression) return generate((SuperExpression) model);
		if (model instanceof AnnotationMemberDeclaration) return generate((AnnotationMemberDeclaration) model);
		if (model instanceof CompilationUnit) return generate((CompilationUnit) model);
		if (model instanceof StringLiteralExpression) return generate((StringLiteralExpression) model);
		if (model instanceof LambdaExpression) return generate((LambdaExpression) model);
		if (model instanceof MarkerAnnotationExpression) return generate((MarkerAnnotationExpression) model);
		if (model instanceof ForStmt) return generate((ForStmt) model);
		if (model instanceof StaticFinalFieldDeclaration) return generate((StaticFinalFieldDeclaration) model);
		if (model instanceof ReturnStmt) return generate((ReturnStmt) model);
		if (model instanceof ExplicitConstructorInvocationStmt) return generate((ExplicitConstructorInvocationStmt) model);
		if (model instanceof BooleanLiteralExpression) return generate((BooleanLiteralExpression) model);
		if (model instanceof ArrayAccessExpression) return generate((ArrayAccessExpression) model);
		if (model instanceof SwitchEntryStmt) return generate((SwitchEntryStmt) model);
		if (model instanceof ContinueStmt) return generate((ContinueStmt) model);
		if (model instanceof VariableDeclaration) return generate((VariableDeclaration) model);
		if (model instanceof BreakStmt) return generate((BreakStmt) model);
		if (model instanceof PublicFinalFieldDeclaration) return generate((PublicFinalFieldDeclaration) model);
		if (model instanceof ThisExpression) return generate((ThisExpression) model);
		if (model instanceof ThrowStmt) return generate((ThrowStmt) model);
		if (model instanceof PackageDeclaration) return generate((PackageDeclaration) model);
		if (model instanceof LongExpression) return generate((LongExpression) model);
		if (model instanceof Parameter) return generate((Parameter) model);
		if (model instanceof NullLiteralExpression) return generate((NullLiteralExpression) model);
		if (model instanceof staticPublicFinalFieldDeclaration) return generate((staticPublicFinalFieldDeclaration) model);
		if (model instanceof MethodCallExpression) return generate((MethodCallExpression) model);
		if (model instanceof InstanceOfExpression) return generate((InstanceOfExpression) model);
		if (model instanceof BlockStmt) return generate((BlockStmt) model);
		if (model instanceof UnaryExpression) return generate((UnaryExpression) model);
		if (model instanceof ClassOrInterfaceType) return generate((ClassOrInterfaceType) model);
		if (model instanceof AnnotationDeclaration) return generate((AnnotationDeclaration) model);
		if (model instanceof CastExpression) return generate((CastExpression) model);
		if (model instanceof ObjectCreationExpression) return generate((ObjectCreationExpression) model);
		if (model instanceof BinaryExpression) return generate((BinaryExpression) model);
		if (model instanceof ExpressionStmt) return generate((ExpressionStmt) model);
		if (model instanceof DoubleLiteralExpression) return generate((DoubleLiteralExpression) model);
		if (model instanceof PrivateFieldDeclaration) return generate((PrivateFieldDeclaration) model);
		if (model instanceof EnumConstant) return generate((EnumConstant) model);
		if (model instanceof NormalAnnotationExpression) return generate((NormalAnnotationExpression) model);
		if (model instanceof AssignExpression) return generate((AssignExpression) model);
		if (model instanceof WhileStmt) return generate((WhileStmt) model);
		if (model instanceof EnclosedExpression) return generate((EnclosedExpression) model);
		if (model instanceof MemberValuePair) return generate((MemberValuePair) model);
		if (model instanceof DoStmt) return generate((DoStmt) model);
		if (model instanceof ForEachStmt) return generate((ForEachStmt) model);
		if (model instanceof QualifierName) return generate((QualifierName) model);
		if (model instanceof ConstructorDeclaration) return generate((ConstructorDeclaration) model);
		if (model instanceof IntegerLiteralExpression) return generate((IntegerLiteralExpression) model);
		if (model instanceof SwitchStmt) return generate((SwitchStmt) model);
		if (model instanceof FinalFieldDeclaration) return generate((FinalFieldDeclaration) model);
		if (model instanceof EnumDeclaration) return generate((EnumDeclaration) model);
		if (model instanceof NameExpression) return generate((NameExpression) model);
		if (model instanceof MethodDeclaration) return generate((MethodDeclaration) model);
		if (model instanceof ClassExpression) return generate((ClassExpression) model);
		if (model instanceof SynchronizedStmt) return generate((SynchronizedStmt) model);
		if (model instanceof LabeledStmt) return generate((LabeledStmt) model);
		if (model instanceof MethodReferenceExpression) return generate((MethodReferenceExpression) model);
		if (model instanceof TryStmt) return generate((TryStmt) model);
		if (model instanceof FieldDeclaration) return generate((FieldDeclaration) model);
		if (model instanceof AssertStmt) return generate((AssertStmt) model);
		if (model instanceof FieldAccessExpression) return generate((FieldAccessExpression) model);
		if (model instanceof ArrayCreationExpression) return generate((ArrayCreationExpression) model);
		if (model instanceof ArrayInitializerExpression) return generate((ArrayInitializerExpression) model);
		if (model instanceof VariableDeclarationExpression) return generate((VariableDeclarationExpression) model);
		if (model instanceof AssignThisVariableExpression) return generate((AssignThisVariableExpression) model);
		if (model instanceof JavaPackageInfo) return generate((JavaPackageInfo) model);
		if (model instanceof ModuleDeclaration) return generate((ModuleDeclaration) model);
		if (model instanceof ImportDeclaration) return generate((ImportDeclaration) model);
		if (model instanceof StaticPrivateFinalFieldDeclaration) return generate((StaticPrivateFinalFieldDeclaration) model);
		if (model instanceof ClassOrInterfaceDeclaration) return generate((ClassOrInterfaceDeclaration) model);
		if (model instanceof CharLiteralExpression) return generate((CharLiteralExpression) model);
		if (model instanceof PrivateFinalFieldDeclaration) return generate((PrivateFinalFieldDeclaration) model);
		if (model instanceof SingleMemberAnnotationExpression) return generate((SingleMemberAnnotationExpression) model);
		return model;
	}
}