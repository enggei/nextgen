package com.generator.generators.java.parser;

import org.neo4j.graphdb.*;

public abstract class JavaParserDomainVisitor {

	protected final java.util.Set<Node> visited = new java.util.LinkedHashSet<>();

   public void visit(Node node) {
		if(hasLabel(node, "Block")) visitBlock(node);
		else if(hasLabel(node, "Expression")) visitExpression(node);
		else if(hasLabel(node, "Statement")) visitStatement(node);
		else if(hasLabel(node, "Literal")) visitLiteral(node);
		else if(hasLabel(node, "IntegerLiteral")) visitIntegerLiteral(node);
		else if(hasLabel(node, "FormalParameterList")) visitFormalParameterList(node);
		else if(hasLabel(node, "Arguments")) visitArguments(node);
		else if(hasLabel(node, "ExpressionList")) visitExpressionList(node);
		else if(hasLabel(node, "TypeList")) visitTypeList(node);
		else if(hasLabel(node, "CompilationUnit")) visitCompilationUnit(node);
		else if(hasLabel(node, "PackageDeclaration")) visitPackageDeclaration(node);
		else if(hasLabel(node, "ImportDeclaration")) visitImportDeclaration(node);
		else if(hasLabel(node, "TypeDeclaration")) visitTypeDeclaration(node);
		else if(hasLabel(node, "Modifier")) visitModifier(node);
		else if(hasLabel(node, "ClassOrInterfaceModifier")) visitClassOrInterfaceModifier(node);
		else if(hasLabel(node, "VariableModifier")) visitVariableModifier(node);
		else if(hasLabel(node, "ClassDeclaration")) visitClassDeclaration(node);
		else if(hasLabel(node, "TypeParameters")) visitTypeParameters(node);
		else if(hasLabel(node, "TypeParameter")) visitTypeParameter(node);
		else if(hasLabel(node, "TypeBound")) visitTypeBound(node);
		else if(hasLabel(node, "EnumDeclaration")) visitEnumDeclaration(node);
		else if(hasLabel(node, "EnumConstants")) visitEnumConstants(node);
		else if(hasLabel(node, "EnumConstant")) visitEnumConstant(node);
		else if(hasLabel(node, "EnumBodyDeclarations")) visitEnumBodyDeclarations(node);
		else if(hasLabel(node, "InterfaceDeclaration")) visitInterfaceDeclaration(node);
		else if(hasLabel(node, "ClassBody")) visitClassBody(node);
		else if(hasLabel(node, "InterfaceBody")) visitInterfaceBody(node);
		else if(hasLabel(node, "ClassBodyDeclaration")) visitClassBodyDeclaration(node);
		else if(hasLabel(node, "MemberDeclaration")) visitMemberDeclaration(node);
		else if(hasLabel(node, "MethodDeclaration")) visitMethodDeclaration(node);
		else if(hasLabel(node, "MethodBody")) visitMethodBody(node);
		else if(hasLabel(node, "TypeTypeOrVoid")) visitTypeTypeOrVoid(node);
		else if(hasLabel(node, "GenericMethodDeclaration")) visitGenericMethodDeclaration(node);
		else if(hasLabel(node, "GenericConstructorDeclaration")) visitGenericConstructorDeclaration(node);
		else if(hasLabel(node, "ConstructorDeclaration")) visitConstructorDeclaration(node);
		else if(hasLabel(node, "FieldDeclaration")) visitFieldDeclaration(node);
		else if(hasLabel(node, "InterfaceBodyDeclaration")) visitInterfaceBodyDeclaration(node);
		else if(hasLabel(node, "InterfaceMemberDeclaration")) visitInterfaceMemberDeclaration(node);
		else if(hasLabel(node, "ConstDeclaration")) visitConstDeclaration(node);
		else if(hasLabel(node, "ConstantDeclarator")) visitConstantDeclarator(node);
		else if(hasLabel(node, "InterfaceMethodDeclaration")) visitInterfaceMethodDeclaration(node);
		else if(hasLabel(node, "InterfaceMethodModifier")) visitInterfaceMethodModifier(node);
		else if(hasLabel(node, "GenericInterfaceMethodDeclaration")) visitGenericInterfaceMethodDeclaration(node);
		else if(hasLabel(node, "VariableDeclarators")) visitVariableDeclarators(node);
		else if(hasLabel(node, "VariableDeclarator")) visitVariableDeclarator(node);
		else if(hasLabel(node, "VariableDeclaratorId")) visitVariableDeclaratorId(node);
		else if(hasLabel(node, "VariableInitializer")) visitVariableInitializer(node);
		else if(hasLabel(node, "ArrayInitializer")) visitArrayInitializer(node);
		else if(hasLabel(node, "ClassOrInterfaceType")) visitClassOrInterfaceType(node);
		else if(hasLabel(node, "TypeArgument")) visitTypeArgument(node);
		else if(hasLabel(node, "QualifiedNameList")) visitQualifiedNameList(node);
		else if(hasLabel(node, "FormalParameters")) visitFormalParameters(node);
		else if(hasLabel(node, "FormalParameter")) visitFormalParameter(node);
		else if(hasLabel(node, "LastFormalParameter")) visitLastFormalParameter(node);
		else if(hasLabel(node, "QualifiedName")) visitQualifiedName(node);
		else if(hasLabel(node, "Annotation")) visitAnnotation(node);
		else if(hasLabel(node, "ElementValuePairs")) visitElementValuePairs(node);
		else if(hasLabel(node, "ElementValuePair")) visitElementValuePair(node);
		else if(hasLabel(node, "ElementValue")) visitElementValue(node);
		else if(hasLabel(node, "ElementValueArrayInitializer")) visitElementValueArrayInitializer(node);
		else if(hasLabel(node, "AnnotationTypeDeclaration")) visitAnnotationTypeDeclaration(node);
		else if(hasLabel(node, "AnnotationTypeBody")) visitAnnotationTypeBody(node);
		else if(hasLabel(node, "AnnotationTypeElementDeclaration")) visitAnnotationTypeElementDeclaration(node);
		else if(hasLabel(node, "AnnotationTypeElementRest")) visitAnnotationTypeElementRest(node);
		else if(hasLabel(node, "AnnotationMethodOrConstantRest")) visitAnnotationMethodOrConstantRest(node);
		else if(hasLabel(node, "AnnotationMethodRest")) visitAnnotationMethodRest(node);
		else if(hasLabel(node, "AnnotationConstantRest")) visitAnnotationConstantRest(node);
		else if(hasLabel(node, "DefaultValue")) visitDefaultValue(node);
		else if(hasLabel(node, "BlockStatement")) visitBlockStatement(node);
		else if(hasLabel(node, "LocalVariableDeclaration")) visitLocalVariableDeclaration(node);
		else if(hasLabel(node, "CatchClause")) visitCatchClause(node);
		else if(hasLabel(node, "CatchType")) visitCatchType(node);
		else if(hasLabel(node, "FinallyBlock")) visitFinallyBlock(node);
		else if(hasLabel(node, "ResourceSpecification")) visitResourceSpecification(node);
		else if(hasLabel(node, "Resources")) visitResources(node);
		else if(hasLabel(node, "Resource")) visitResource(node);
		else if(hasLabel(node, "SwitchBlockStatementGroup")) visitSwitchBlockStatementGroup(node);
		else if(hasLabel(node, "SwitchLabel")) visitSwitchLabel(node);
		else if(hasLabel(node, "ForControl")) visitForControl(node);
		else if(hasLabel(node, "ForInit")) visitForInit(node);
		else if(hasLabel(node, "EnhancedForControl")) visitEnhancedForControl(node);
		else if(hasLabel(node, "ParExpression")) visitParExpression(node);
		else if(hasLabel(node, "LambdaExpression")) visitLambdaExpression(node);
		else if(hasLabel(node, "LambdaParameters")) visitLambdaParameters(node);
		else if(hasLabel(node, "LambdaBody")) visitLambdaBody(node);
		else if(hasLabel(node, "Primary")) visitPrimary(node);
		else if(hasLabel(node, "MethodReference")) visitMethodReference(node);
		else if(hasLabel(node, "ClassType")) visitClassType(node);
		else if(hasLabel(node, "Creator")) visitCreator(node);
		else if(hasLabel(node, "CreatedName")) visitCreatedName(node);
		else if(hasLabel(node, "InnerCreator")) visitInnerCreator(node);
		else if(hasLabel(node, "ArrayCreatorRest")) visitArrayCreatorRest(node);
		else if(hasLabel(node, "ClassCreatorRest")) visitClassCreatorRest(node);
		else if(hasLabel(node, "ExplicitGenericInvocation")) visitExplicitGenericInvocation(node);
		else if(hasLabel(node, "TypeArgumentsOrDiamond")) visitTypeArgumentsOrDiamond(node);
		else if(hasLabel(node, "NonWildcardTypeArgumentsOrDiamond")) visitNonWildcardTypeArgumentsOrDiamond(node);
		else if(hasLabel(node, "NonWildcardTypeArguments")) visitNonWildcardTypeArguments(node);
		else if(hasLabel(node, "TypeType")) visitTypeType(node);
		else if(hasLabel(node, "PrimitiveType")) visitPrimitiveType(node);
		else if(hasLabel(node, "TypeArguments")) visitTypeArguments(node);
		else if(hasLabel(node, "SuperSuffix")) visitSuperSuffix(node);
		else if(hasLabel(node, "ExplicitGenericInvocationSuffix")) visitExplicitGenericInvocationSuffix(node);
   }

	public void visitBlock(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitExpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitStatement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitLiteral(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitIntegerLiteral(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitFormalParameterList(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitArguments(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitExpressionList(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTypeList(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitCompilationUnit(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitPackageDeclaration(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitImportDeclaration(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTypeDeclaration(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitModifier(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitClassOrInterfaceModifier(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitVariableModifier(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitClassDeclaration(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTypeParameters(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTypeParameter(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTypeBound(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitEnumDeclaration(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitEnumConstants(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitEnumConstant(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitEnumBodyDeclarations(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitInterfaceDeclaration(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitClassBody(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitInterfaceBody(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitClassBodyDeclaration(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitMemberDeclaration(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitMethodDeclaration(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitMethodBody(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTypeTypeOrVoid(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitGenericMethodDeclaration(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitGenericConstructorDeclaration(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitConstructorDeclaration(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitFieldDeclaration(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitInterfaceBodyDeclaration(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitInterfaceMemberDeclaration(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitConstDeclaration(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitConstantDeclarator(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitInterfaceMethodDeclaration(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitInterfaceMethodModifier(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitGenericInterfaceMethodDeclaration(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitVariableDeclarators(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitVariableDeclarator(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitVariableDeclaratorId(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitVariableInitializer(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitArrayInitializer(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitClassOrInterfaceType(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTypeArgument(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitQualifiedNameList(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitFormalParameters(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitFormalParameter(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitLastFormalParameter(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitQualifiedName(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAnnotation(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitElementValuePairs(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitElementValuePair(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitElementValue(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitElementValueArrayInitializer(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAnnotationTypeDeclaration(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAnnotationTypeBody(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAnnotationTypeElementDeclaration(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAnnotationTypeElementRest(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAnnotationMethodOrConstantRest(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAnnotationMethodRest(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAnnotationConstantRest(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitDefaultValue(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitBlockStatement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitLocalVariableDeclaration(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitCatchClause(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitCatchType(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitFinallyBlock(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitResourceSpecification(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitResources(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitResource(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSwitchBlockStatementGroup(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSwitchLabel(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitForControl(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitForInit(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitEnhancedForControl(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitParExpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitLambdaExpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitLambdaParameters(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitLambdaBody(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitPrimary(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitMethodReference(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitClassType(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitCreator(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitCreatedName(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitInnerCreator(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitArrayCreatorRest(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitClassCreatorRest(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitExplicitGenericInvocation(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTypeArgumentsOrDiamond(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitNonWildcardTypeArgumentsOrDiamond(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitNonWildcardTypeArguments(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTypeType(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitPrimitiveType(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTypeArguments(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSuperSuffix(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitExplicitGenericInvocationSuffix(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	private boolean hasLabel(Node node, String label) {
   	for (org.neo4j.graphdb.Label lbl : node.getLabels())
      	if (lbl.name().equals(label)) return true;
      return false;
   }

	protected Iterable<Relationship> outgoing(Node node, RelationshipType type) {
     	return node == null ? java.util.Collections.emptyList() : sort(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, type));
   }

	protected Iterable<Relationship> outgoing(Node node) {
     	return node == null ? java.util.Collections.emptyList() : sort(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING));
   }

	protected static Iterable<Relationship> sort(Iterable<Relationship> relationships) {
		final java.util.Set<Relationship> relations = new java.util.TreeSet<>(java.util.Comparator.comparingLong(Relationship::getId));
		for (Relationship relationship : relationships)
			relations.add(relationship);
		return relations;
	}

	protected Node other(Node node, Relationship relationship) {
     	return relationship == null ? null : relationship.getOtherNode(node);
   }
}