package com.generator.generators.javaparser;

import com.generator.generators.templates.domain.GeneratedFile;
import com.generator.util.FileUtil;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.PackageDeclaration;
import com.github.javaparser.ast.body.*;
import com.github.javaparser.ast.expr.*;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.type.ReferenceType;
import com.github.javaparser.ast.type.Type;
import com.github.javaparser.ast.type.VoidType;

import java.io.IOException;
import java.util.Stack;

/**
 * goe on 9/5/16.
 * generates Compilation-unit code from parsed class
 */
public class BuilderGenerator extends DebugVisitorAdapter {

	private final JavaparserGroup group = new JavaparserGroup();

	private final JavaparserGroup.JavaParserBuilderST javaParserBuilderST;

	private final String packageName;
	private final String className;
	private final StringBuilder log;

	private Stack<Integer> parameterOrdinals = new Stack<>();
	private Stack<JavaparserGroup.JavaparserGroupTemplate> adapters = new Stack<>();

	public BuilderGenerator(CompilationUnit cu) {
		this(cu, new StringBuilder());
	}

	public BuilderGenerator(CompilationUnit cu, StringBuilder log) {

		this.log = log;

		final TypeDeclaration typeDeclaration = cu.getTypes().iterator().next();   // todo: check how this works with inner classes etc:

		this.packageName = cu.getPackage().getPackageName();
		this.className = typeDeclaration.getName() + "Builder";

		javaParserBuilderST = group.newJavaParserBuilder().
			setPackageName(packageName).
			setName(className);

		visit(cu, null);

		//System.out.println(javaParserBuilderST);
	}

	private static String asString(Object value) {
		return "\"" + value + "\"";
	}

	public BuilderGenerator writeToFile(String root) throws IOException {
		FileUtil.writeFile(javaParserBuilderST, GeneratedFile.newJavaFile(root, packageName, className).getFile());
		return this;
	}

	@Override
	public void visit(PackageDeclaration arg0, Object arg) {

		final JavaparserGroup.packageDeclarationST template = group.newpackageDeclaration();
		adapters.push(template);
		super.visit(arg0, arg);
		template.setNameExpr(adapters.pop());
		System.out.println(template);
		log.append("\n\t\t").append(template).append(";");
	}

	@Override
	public void visit(ClassOrInterfaceDeclaration arg0, Object arg) {
		final JavaparserGroup.classOrInterfaceDeclarationST template = group.newclassOrInterfaceDeclaration().
			setClassname(asString(arg0.getName())).
			setScope(getModifierScope(arg0.getModifiers())).
			setIsInterface(arg0.isInterface());

		System.out.println(template);
		log.append("\n\t\t").append(template).append(";");

		super.visit(arg0, arg);
	}

	@Override
	public void visit(MethodDeclaration arg0, Object arg) {
		final JavaparserGroup.methodDeclarationST template = group.newmethodDeclaration().
			setScope(getModifierScope(arg0.getModifiers())).
			setType(getType(arg0.getType()));

		parameterOrdinals.push(0);

		super.visit(arg0, arg);
		template.setName(adapters.pop());
		template.setBlockStmt(adapters.pop());
		parameterOrdinals.pop();
		System.out.println(template);
		log.append("\n\t\t").append(template).append(";");
	}

	@Override
	public void visit(ConstructorDeclaration arg0, Object arg) {
		final JavaparserGroup.constructorDeclarationST template = group.newconstructorDeclaration().
			setName(arg0.getName()).
			setScope(getModifierScope(arg0.getModifiers()));

		//todo: why not NameExpr in new new ConstructorDeclaration ??
		parameterOrdinals.push(0);

		super.visit(arg0, arg);
		parameterOrdinals.pop();
		System.out.println(template);
		log.append("\n\t\t").append(template).append(";");
	}

	@Override
	public void visit(Parameter arg0, Object arg) {

		final JavaparserGroup.parameterST template = group.newparameter().
			setName(arg0.getName()).
			setType(arg0.getType()).
			setOrdinal(parameterOrdinals.peek());

		System.out.println(template);
		log.append("\n\t\t").append(template).append(";");

		final Integer ordinal = parameterOrdinals.pop();
		parameterOrdinals.push(ordinal + 1);
		super.visit(arg0, arg);
	}

	@Override
	public void visit(BlockStmt arg0, Object arg) {
		final JavaparserGroup.blockStmtST template = group.newblockStmt();
		System.out.println(template);
		adapters.push(template);

		super.visit(arg0, arg);
	}

	@Override
	public void visit(NameExpr arg0, Object arg) {
		final JavaparserGroup.nameExprST template = group.newnameExpr().
			setName(arg0.getName());
		adapters.push(template);

		super.visit(arg0, arg);
	}

	@Override
	public void visit(QualifiedNameExpr arg0, Object arg) {
		final JavaparserGroup.qualifiedNameExprST template = group.newqualifiedNameExpr().
			setName(arg0.getName());
		adapters.push(template);

		super.visit(arg0, arg);
		template.setScope(adapters.pop());
	}

	@Override
	public void visit(FieldAccessExpr arg0, Object arg) {

		// todo check scope here: (Expression) can this be better ?
		final JavaparserGroup.fieldAccessExprST template = group.newfieldAccessExpr().
			setName(arg0.getField());

		super.visit(arg0, arg);
		template.setScope(adapters.pop());
		System.out.println(template);
		log.append("\n\t\t").append(template).append(";");
	}


	@Override
	public void visit(MethodCallExpr arg0, Object arg) {

		final JavaparserGroup.methodCallExprST template = group.newmethodCallExpr().
			setName(arg0.getName());

		super.visit(arg0, arg);
		template.setScope(adapters.pop());
		System.out.println(template);
		log.append("\n\t\t").append(template).append(";");
	}

	@Override
	public void visit(StringLiteralExpr arg0, Object arg) {

		final JavaparserGroup.stringLiteralExprST template = group.newstringLiteralExpr().
			setValue(arg0.getValue());
		adapters.push(template);

		super.visit(arg0, arg);
	}

	private static Object getModifierScope(int modifiers) {
		if (ModifierSet.isPublic(modifiers))
			return "PUBLIC";
		else if (ModifierSet.isPrivate(modifiers))
			return "PRIVATE";
		else if (ModifierSet.isProtected(modifiers))
			return "PROTECTED";
		return "";   // package
	}

	private static Object getType(Type type) {

		if (type instanceof VoidType)
			return "ASTHelper.VOID_TYPE";
		else if(type instanceof ReferenceType)
			return "ASTHelper.createReferenceType(\"" + type + "\", 0)";	// todo: what is arrayCount (0) in this
		else if(type instanceof com.github.javaparser.ast.type.PrimitiveType)
			return "ASTHelper." + ((com.github.javaparser.ast.type.PrimitiveType)type).getType().name().toUpperCase() + "_TYPE";

		System.out.println("verify: " + type);
		return type.toString();
	}
}