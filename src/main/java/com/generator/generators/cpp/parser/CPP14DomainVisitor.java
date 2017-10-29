package com.generator.generators.cpp.parser;

import org.neo4j.graphdb.*;

public abstract class CPP14DomainVisitor {

	protected final java.util.Set<Node> visited = new java.util.LinkedHashSet<>();

   public void visit(Node node) {
		if(hasLabel(node, "Enumname")) visitEnumname(node);
		else if(hasLabel(node, "Enumspecifier")) visitEnumspecifier(node);
		else if(hasLabel(node, "Enumhead")) visitEnumhead(node);
		else if(hasLabel(node, "Opaqueenumdeclaration")) visitOpaqueenumdeclaration(node);
		else if(hasLabel(node, "Enumkey")) visitEnumkey(node);
		else if(hasLabel(node, "Enumbase")) visitEnumbase(node);
		else if(hasLabel(node, "Enumeratorlist")) visitEnumeratorlist(node);
		else if(hasLabel(node, "Enumeratordefinition")) visitEnumeratordefinition(node);
		else if(hasLabel(node, "Enumerator")) visitEnumerator(node);
		else if(hasLabel(node, "Namespacename")) visitNamespacename(node);
		else if(hasLabel(node, "Originalnamespacename")) visitOriginalnamespacename(node);
		else if(hasLabel(node, "Namespacedefinition")) visitNamespacedefinition(node);
		else if(hasLabel(node, "Namednamespacedefinition")) visitNamednamespacedefinition(node);
		else if(hasLabel(node, "Originalnamespacedefinition")) visitOriginalnamespacedefinition(node);
		else if(hasLabel(node, "Extensionnamespacedefinition")) visitExtensionnamespacedefinition(node);
		else if(hasLabel(node, "Unnamednamespacedefinition")) visitUnnamednamespacedefinition(node);
		else if(hasLabel(node, "Namespacebody")) visitNamespacebody(node);
		else if(hasLabel(node, "Namespacealias")) visitNamespacealias(node);
		else if(hasLabel(node, "Namespacealiasdefinition")) visitNamespacealiasdefinition(node);
		else if(hasLabel(node, "Qualifiednamespacespecifier")) visitQualifiednamespacespecifier(node);
		else if(hasLabel(node, "Usingdeclaration")) visitUsingdeclaration(node);
		else if(hasLabel(node, "Usingdirective")) visitUsingdirective(node);
		else if(hasLabel(node, "Asmdefinition")) visitAsmdefinition(node);
		else if(hasLabel(node, "Linkagespecification")) visitLinkagespecification(node);
		else if(hasLabel(node, "Attributespecifierseq")) visitAttributespecifierseq(node);
		else if(hasLabel(node, "Attributespecifier")) visitAttributespecifier(node);
		else if(hasLabel(node, "Alignmentspecifier")) visitAlignmentspecifier(node);
		else if(hasLabel(node, "Attributelist")) visitAttributelist(node);
		else if(hasLabel(node, "Attribute")) visitAttribute(node);
		else if(hasLabel(node, "Attributetoken")) visitAttributetoken(node);
		else if(hasLabel(node, "Attributescopedtoken")) visitAttributescopedtoken(node);
		else if(hasLabel(node, "Attributenamespace")) visitAttributenamespace(node);
		else if(hasLabel(node, "Attributeargumentclause")) visitAttributeargumentclause(node);
		else if(hasLabel(node, "Balancedtokenseq")) visitBalancedtokenseq(node);
		else if(hasLabel(node, "Balancedtoken")) visitBalancedtoken(node);
		else if(hasLabel(node, "Initdeclaratorlist")) visitInitdeclaratorlist(node);
		else if(hasLabel(node, "Initdeclarator")) visitInitdeclarator(node);
		else if(hasLabel(node, "Declarator")) visitDeclarator(node);
		else if(hasLabel(node, "Ptrdeclarator")) visitPtrdeclarator(node);
		else if(hasLabel(node, "Noptrdeclarator")) visitNoptrdeclarator(node);
		else if(hasLabel(node, "Parametersandqualifiers")) visitParametersandqualifiers(node);
		else if(hasLabel(node, "Trailingreturntype")) visitTrailingreturntype(node);
		else if(hasLabel(node, "Ptroperator")) visitPtroperator(node);
		else if(hasLabel(node, "Cvqualifierseq")) visitCvqualifierseq(node);
		else if(hasLabel(node, "Cvqualifier")) visitCvqualifier(node);
		else if(hasLabel(node, "Refqualifier")) visitRefqualifier(node);
		else if(hasLabel(node, "Declaratorid")) visitDeclaratorid(node);
		else if(hasLabel(node, "Typeid")) visitTypeid(node);
		else if(hasLabel(node, "Abstractdeclarator")) visitAbstractdeclarator(node);
		else if(hasLabel(node, "Ptrabstractdeclarator")) visitPtrabstractdeclarator(node);
		else if(hasLabel(node, "Noptrabstractdeclarator")) visitNoptrabstractdeclarator(node);
		else if(hasLabel(node, "Abstractpackdeclarator")) visitAbstractpackdeclarator(node);
		else if(hasLabel(node, "Noptrabstractpackdeclarator")) visitNoptrabstractpackdeclarator(node);
		else if(hasLabel(node, "Parameterdeclarationclause")) visitParameterdeclarationclause(node);
		else if(hasLabel(node, "Parameterdeclarationlist")) visitParameterdeclarationlist(node);
		else if(hasLabel(node, "Parameterdeclaration")) visitParameterdeclaration(node);
		else if(hasLabel(node, "Functiondefinition")) visitFunctiondefinition(node);
		else if(hasLabel(node, "Functionbody")) visitFunctionbody(node);
		else if(hasLabel(node, "Initializer")) visitInitializer(node);
		else if(hasLabel(node, "Braceorequalinitializer")) visitBraceorequalinitializer(node);
		else if(hasLabel(node, "Initializerclause")) visitInitializerclause(node);
		else if(hasLabel(node, "Initializerlist")) visitInitializerlist(node);
		else if(hasLabel(node, "Bracedinitlist")) visitBracedinitlist(node);
		else if(hasLabel(node, "Classname")) visitClassname(node);
		else if(hasLabel(node, "Classspecifier")) visitClassspecifier(node);
		else if(hasLabel(node, "Classhead")) visitClasshead(node);
		else if(hasLabel(node, "Classheadname")) visitClassheadname(node);
		else if(hasLabel(node, "Classvirtspecifier")) visitClassvirtspecifier(node);
		else if(hasLabel(node, "Classkey")) visitClasskey(node);
		else if(hasLabel(node, "Memberspecification")) visitMemberspecification(node);
		else if(hasLabel(node, "Memberdeclaration")) visitMemberdeclaration(node);
		else if(hasLabel(node, "Memberdeclaratorlist")) visitMemberdeclaratorlist(node);
		else if(hasLabel(node, "Memberdeclarator")) visitMemberdeclarator(node);
		else if(hasLabel(node, "Virtspecifierseq")) visitVirtspecifierseq(node);
		else if(hasLabel(node, "Virtspecifier")) visitVirtspecifier(node);
		else if(hasLabel(node, "Purespecifier")) visitPurespecifier(node);
		else if(hasLabel(node, "Baseclause")) visitBaseclause(node);
		else if(hasLabel(node, "Basespecifierlist")) visitBasespecifierlist(node);
		else if(hasLabel(node, "Basespecifier")) visitBasespecifier(node);
		else if(hasLabel(node, "Classordecltype")) visitClassordecltype(node);
		else if(hasLabel(node, "Basetypespecifier")) visitBasetypespecifier(node);
		else if(hasLabel(node, "Accessspecifier")) visitAccessspecifier(node);
		else if(hasLabel(node, "Conversionfunctionid")) visitConversionfunctionid(node);
		else if(hasLabel(node, "Conversiontypeid")) visitConversiontypeid(node);
		else if(hasLabel(node, "Conversiondeclarator")) visitConversiondeclarator(node);
		else if(hasLabel(node, "Ctorinitializer")) visitCtorinitializer(node);
		else if(hasLabel(node, "Meminitializerlist")) visitMeminitializerlist(node);
		else if(hasLabel(node, "Meminitializer")) visitMeminitializer(node);
		else if(hasLabel(node, "Meminitializerid")) visitMeminitializerid(node);
		else if(hasLabel(node, "Operatorfunctionid")) visitOperatorfunctionid(node);
		else if(hasLabel(node, "Literaloperatorid")) visitLiteraloperatorid(node);
		else if(hasLabel(node, "Templatedeclaration")) visitTemplatedeclaration(node);
		else if(hasLabel(node, "Templateparameterlist")) visitTemplateparameterlist(node);
		else if(hasLabel(node, "Templateparameter")) visitTemplateparameter(node);
		else if(hasLabel(node, "Typeparameter")) visitTypeparameter(node);
		else if(hasLabel(node, "Simpletemplateid")) visitSimpletemplateid(node);
		else if(hasLabel(node, "Templateid")) visitTemplateid(node);
		else if(hasLabel(node, "Templatename")) visitTemplatename(node);
		else if(hasLabel(node, "Templateargumentlist")) visitTemplateargumentlist(node);
		else if(hasLabel(node, "Templateargument")) visitTemplateargument(node);
		else if(hasLabel(node, "Typenamespecifier")) visitTypenamespecifier(node);
		else if(hasLabel(node, "Explicitinstantiation")) visitExplicitinstantiation(node);
		else if(hasLabel(node, "Explicitspecialization")) visitExplicitspecialization(node);
		else if(hasLabel(node, "Tryblock")) visitTryblock(node);
		else if(hasLabel(node, "Functiontryblock")) visitFunctiontryblock(node);
		else if(hasLabel(node, "Handlerseq")) visitHandlerseq(node);
		else if(hasLabel(node, "Handler")) visitHandler(node);
		else if(hasLabel(node, "Exceptiondeclaration")) visitExceptiondeclaration(node);
		else if(hasLabel(node, "Throwexpression")) visitThrowexpression(node);
		else if(hasLabel(node, "Exceptionspecification")) visitExceptionspecification(node);
		else if(hasLabel(node, "Dynamicexceptionspecification")) visitDynamicexceptionspecification(node);
		else if(hasLabel(node, "Typeidlist")) visitTypeidlist(node);
		else if(hasLabel(node, "Noexceptspecification")) visitNoexceptspecification(node);
		else if(hasLabel(node, "RightShift")) visitRightShift(node);
		else if(hasLabel(node, "RightShiftAssign")) visitRightShiftAssign(node);
		else if(hasLabel(node, "Operator")) visitOperator(node);
		else if(hasLabel(node, "Booleanliteral")) visitBooleanliteral(node);
		else if(hasLabel(node, "Pointerliteral")) visitPointerliteral(node);
		else if(hasLabel(node, "Userdefinedliteral")) visitUserdefinedliteral(node);
		else if(hasLabel(node, "Literal")) visitLiteral(node);
		else if(hasLabel(node, "Translationunit")) visitTranslationunit(node);
		else if(hasLabel(node, "Primaryexpression")) visitPrimaryexpression(node);
		else if(hasLabel(node, "Idexpression")) visitIdexpression(node);
		else if(hasLabel(node, "Unqualifiedid")) visitUnqualifiedid(node);
		else if(hasLabel(node, "Qualifiedid")) visitQualifiedid(node);
		else if(hasLabel(node, "Nestednamespecifier")) visitNestednamespecifier(node);
		else if(hasLabel(node, "Lambdaexpression")) visitLambdaexpression(node);
		else if(hasLabel(node, "Lambdaintroducer")) visitLambdaintroducer(node);
		else if(hasLabel(node, "Lambdacapture")) visitLambdacapture(node);
		else if(hasLabel(node, "Capturedefault")) visitCapturedefault(node);
		else if(hasLabel(node, "Capturelist")) visitCapturelist(node);
		else if(hasLabel(node, "Capture")) visitCapture(node);
		else if(hasLabel(node, "Simplecapture")) visitSimplecapture(node);
		else if(hasLabel(node, "Initcapture")) visitInitcapture(node);
		else if(hasLabel(node, "Lambdadeclarator")) visitLambdadeclarator(node);
		else if(hasLabel(node, "Postfixexpression")) visitPostfixexpression(node);
		else if(hasLabel(node, "Expressionlist")) visitExpressionlist(node);
		else if(hasLabel(node, "Pseudodestructorname")) visitPseudodestructorname(node);
		else if(hasLabel(node, "Unaryexpression")) visitUnaryexpression(node);
		else if(hasLabel(node, "Unaryoperator")) visitUnaryoperator(node);
		else if(hasLabel(node, "Newexpression")) visitNewexpression(node);
		else if(hasLabel(node, "Newplacement")) visitNewplacement(node);
		else if(hasLabel(node, "Newtypeid")) visitNewtypeid(node);
		else if(hasLabel(node, "Newdeclarator")) visitNewdeclarator(node);
		else if(hasLabel(node, "Noptrnewdeclarator")) visitNoptrnewdeclarator(node);
		else if(hasLabel(node, "Newinitializer")) visitNewinitializer(node);
		else if(hasLabel(node, "Deleteexpression")) visitDeleteexpression(node);
		else if(hasLabel(node, "Noexceptexpression")) visitNoexceptexpression(node);
		else if(hasLabel(node, "Castexpression")) visitCastexpression(node);
		else if(hasLabel(node, "Pmexpression")) visitPmexpression(node);
		else if(hasLabel(node, "Multiplicativeexpression")) visitMultiplicativeexpression(node);
		else if(hasLabel(node, "Additiveexpression")) visitAdditiveexpression(node);
		else if(hasLabel(node, "Shiftexpression")) visitShiftexpression(node);
		else if(hasLabel(node, "Relationalexpression")) visitRelationalexpression(node);
		else if(hasLabel(node, "Equalityexpression")) visitEqualityexpression(node);
		else if(hasLabel(node, "Andexpression")) visitAndexpression(node);
		else if(hasLabel(node, "Exclusiveorexpression")) visitExclusiveorexpression(node);
		else if(hasLabel(node, "Inclusiveorexpression")) visitInclusiveorexpression(node);
		else if(hasLabel(node, "Logicalandexpression")) visitLogicalandexpression(node);
		else if(hasLabel(node, "Logicalorexpression")) visitLogicalorexpression(node);
		else if(hasLabel(node, "Conditionalexpression")) visitConditionalexpression(node);
		else if(hasLabel(node, "Assignmentexpression")) visitAssignmentexpression(node);
		else if(hasLabel(node, "Assignmentoperator")) visitAssignmentoperator(node);
		else if(hasLabel(node, "Expression")) visitExpression(node);
		else if(hasLabel(node, "Constantexpression")) visitConstantexpression(node);
		else if(hasLabel(node, "Statement")) visitStatement(node);
		else if(hasLabel(node, "Labeledstatement")) visitLabeledstatement(node);
		else if(hasLabel(node, "Expressionstatement")) visitExpressionstatement(node);
		else if(hasLabel(node, "Compoundstatement")) visitCompoundstatement(node);
		else if(hasLabel(node, "Statementseq")) visitStatementseq(node);
		else if(hasLabel(node, "Selectionstatement")) visitSelectionstatement(node);
		else if(hasLabel(node, "Condition")) visitCondition(node);
		else if(hasLabel(node, "Iterationstatement")) visitIterationstatement(node);
		else if(hasLabel(node, "Forinitstatement")) visitForinitstatement(node);
		else if(hasLabel(node, "Forrangedeclaration")) visitForrangedeclaration(node);
		else if(hasLabel(node, "Forrangeinitializer")) visitForrangeinitializer(node);
		else if(hasLabel(node, "Jumpstatement")) visitJumpstatement(node);
		else if(hasLabel(node, "Declarationstatement")) visitDeclarationstatement(node);
		else if(hasLabel(node, "Declarationseq")) visitDeclarationseq(node);
		else if(hasLabel(node, "Declaration")) visitDeclaration(node);
		else if(hasLabel(node, "Blockdeclaration")) visitBlockdeclaration(node);
		else if(hasLabel(node, "Aliasdeclaration")) visitAliasdeclaration(node);
		else if(hasLabel(node, "Simpledeclaration")) visitSimpledeclaration(node);
		else if(hasLabel(node, "Static_assertdeclaration")) visitStatic_assertdeclaration(node);
		else if(hasLabel(node, "Emptydeclaration")) visitEmptydeclaration(node);
		else if(hasLabel(node, "Attributedeclaration")) visitAttributedeclaration(node);
		else if(hasLabel(node, "Declspecifier")) visitDeclspecifier(node);
		else if(hasLabel(node, "Declspecifierseq")) visitDeclspecifierseq(node);
		else if(hasLabel(node, "Storageclassspecifier")) visitStorageclassspecifier(node);
		else if(hasLabel(node, "Functionspecifier")) visitFunctionspecifier(node);
		else if(hasLabel(node, "Typedefname")) visitTypedefname(node);
		else if(hasLabel(node, "Typespecifier")) visitTypespecifier(node);
		else if(hasLabel(node, "Trailingtypespecifier")) visitTrailingtypespecifier(node);
		else if(hasLabel(node, "Typespecifierseq")) visitTypespecifierseq(node);
		else if(hasLabel(node, "Trailingtypespecifierseq")) visitTrailingtypespecifierseq(node);
		else if(hasLabel(node, "Simpletypespecifier")) visitSimpletypespecifier(node);
		else if(hasLabel(node, "Typename")) visitTypename(node);
		else if(hasLabel(node, "Decltypespecifier")) visitDecltypespecifier(node);
		else if(hasLabel(node, "Elaboratedtypespecifier")) visitElaboratedtypespecifier(node);
   }

	public void visitEnumname(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitEnumspecifier(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitEnumhead(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitOpaqueenumdeclaration(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitEnumkey(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitEnumbase(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitEnumeratorlist(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitEnumeratordefinition(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitEnumerator(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitNamespacename(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitOriginalnamespacename(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitNamespacedefinition(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitNamednamespacedefinition(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitOriginalnamespacedefinition(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitExtensionnamespacedefinition(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitUnnamednamespacedefinition(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitNamespacebody(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitNamespacealias(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitNamespacealiasdefinition(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitQualifiednamespacespecifier(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitUsingdeclaration(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitUsingdirective(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAsmdefinition(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitLinkagespecification(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAttributespecifierseq(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAttributespecifier(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAlignmentspecifier(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAttributelist(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAttribute(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAttributetoken(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAttributescopedtoken(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAttributenamespace(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAttributeargumentclause(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitBalancedtokenseq(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitBalancedtoken(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitInitdeclaratorlist(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitInitdeclarator(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitDeclarator(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitPtrdeclarator(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitNoptrdeclarator(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitParametersandqualifiers(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTrailingreturntype(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitPtroperator(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitCvqualifierseq(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitCvqualifier(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitRefqualifier(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitDeclaratorid(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTypeid(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAbstractdeclarator(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitPtrabstractdeclarator(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitNoptrabstractdeclarator(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAbstractpackdeclarator(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitNoptrabstractpackdeclarator(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitParameterdeclarationclause(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitParameterdeclarationlist(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitParameterdeclaration(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitFunctiondefinition(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitFunctionbody(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitInitializer(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitBraceorequalinitializer(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitInitializerclause(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitInitializerlist(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitBracedinitlist(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitClassname(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitClassspecifier(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitClasshead(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitClassheadname(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitClassvirtspecifier(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitClasskey(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitMemberspecification(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitMemberdeclaration(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitMemberdeclaratorlist(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitMemberdeclarator(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitVirtspecifierseq(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitVirtspecifier(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitPurespecifier(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitBaseclause(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitBasespecifierlist(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitBasespecifier(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitClassordecltype(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitBasetypespecifier(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAccessspecifier(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitConversionfunctionid(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitConversiontypeid(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitConversiondeclarator(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitCtorinitializer(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitMeminitializerlist(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitMeminitializer(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitMeminitializerid(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitOperatorfunctionid(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitLiteraloperatorid(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTemplatedeclaration(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTemplateparameterlist(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTemplateparameter(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTypeparameter(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSimpletemplateid(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTemplateid(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTemplatename(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTemplateargumentlist(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTemplateargument(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTypenamespecifier(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitExplicitinstantiation(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitExplicitspecialization(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTryblock(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitFunctiontryblock(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitHandlerseq(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitHandler(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitExceptiondeclaration(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitThrowexpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitExceptionspecification(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitDynamicexceptionspecification(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTypeidlist(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitNoexceptspecification(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitRightShift(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitRightShiftAssign(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitOperator(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitBooleanliteral(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitPointerliteral(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitUserdefinedliteral(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitLiteral(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTranslationunit(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitPrimaryexpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitIdexpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitUnqualifiedid(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitQualifiedid(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitNestednamespecifier(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitLambdaexpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitLambdaintroducer(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitLambdacapture(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitCapturedefault(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitCapturelist(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitCapture(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSimplecapture(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitInitcapture(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitLambdadeclarator(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitPostfixexpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitExpressionlist(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitPseudodestructorname(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitUnaryexpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitUnaryoperator(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitNewexpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitNewplacement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitNewtypeid(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitNewdeclarator(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitNoptrnewdeclarator(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitNewinitializer(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitDeleteexpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitNoexceptexpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitCastexpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitPmexpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitMultiplicativeexpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAdditiveexpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitShiftexpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitRelationalexpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitEqualityexpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAndexpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitExclusiveorexpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitInclusiveorexpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitLogicalandexpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitLogicalorexpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitConditionalexpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAssignmentexpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAssignmentoperator(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitExpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitConstantexpression(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitStatement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitLabeledstatement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitExpressionstatement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitCompoundstatement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitStatementseq(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSelectionstatement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitCondition(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitIterationstatement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitForinitstatement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitForrangedeclaration(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitForrangeinitializer(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitJumpstatement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitDeclarationstatement(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitDeclarationseq(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitDeclaration(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitBlockdeclaration(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAliasdeclaration(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSimpledeclaration(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitStatic_assertdeclaration(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitEmptydeclaration(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitAttributedeclaration(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitDeclspecifier(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitDeclspecifierseq(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitStorageclassspecifier(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitFunctionspecifier(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTypedefname(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTypespecifier(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTrailingtypespecifier(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTypespecifierseq(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTrailingtypespecifierseq(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitSimpletypespecifier(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitTypename(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitDecltypespecifier(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitElaboratedtypespecifier(Node node) {
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