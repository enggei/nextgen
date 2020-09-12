package nextgen.templates.java;

import static nextgen.templates.java.JavaST.*;

/**
 * Tests for JavaST
 **/
public class JavaSTTests {

	@org.junit.Test
	public void testAll() {
		testBean();
		testBoundedExternalListAccessors();
		testBoundedExternalReferenceAccessors();
		testBoundedListAccessors();
		testBoundedListReferenceAccessors();
		testBoundedPrimitiveAccessors();
		testBoundedReferenceAccessors();
		testEnum();
		testEnumValue();
		testPojo();
		testListAccessors();
		testPrimitiveAccessors();
		testReferenceAccessors();
		testPojoFactory();
		testScript();
		testValueObject();
		testArrayCreationLevel();
		testCompilationUnit();
		testClassOrInterfaceDeclaration();
		testConstructorDeclaration();
		testFieldDeclaration();
		testEnumDeclaration();
		testEnumConstant();
		testImportDeclaration();
		testAnnotationDeclaration();
		testAnnotationMemberDeclaration();
		testFinalFieldDeclaration();
		testMethodDeclaration();
		testParameter();
		testModuleDeclaration();
		testPackageDeclaration();
		testPrivateFieldDeclaration();
		testPrivateFinalFieldDeclaration();
		testPublicFinalFieldDeclaration();
		testStaticFinalFieldDeclaration();
		testStaticPrivateFinalFieldDeclaration();
		testStaticPublicFinalFieldDeclaration();
		testVariableDeclaration();
		testArrayAccessExpression();
		testArrayCreationExpression();
		testArrayInitializerExpression();
		testAssignExpression();
		testAssignThisVariableExpression();
		testBinaryExpression();
		testBooleanLiteralExpression();
		testCastExpression();
		testCharLiteralExpression();
		testClassExpression();
		testConditionalExpression();
		testDoubleLiteralExpression();
		testEnclosedExpression();
		testFieldAccessExpression();
		testInstanceOfExpression();
		testIntegerLiteralExpression();
		testLambdaExpression();
		testLongExpression();
		testMarkerAnnotationExpression();
		testMethodCallExpression();
		testMethodReferenceExpression();
		testNameExpression();
		testNormalAnnotationExpression();
		testNullLiteralExpression();
		testObjectCreationExpression();
		testSingleMemberAnnotationExpression();
		testStringLiteralExpression();
		testSuperExpression();
		testThisExpression();
		testThisVariableExpression();
		testUnaryExpression();
		testVariableDeclarationExpression();
		testJavaPackageInfo();
		testMemberValuePair();
		testQualifierName();
		testAssertStmt();
		testBlockStmt();
		testBreakStmt();
		testCatchClause();
		testContinueStmt();
		testDoStmt();
		testEmptyStmt();
		testExplicitConstructorInvocationStmt();
		testExpressionStmt();
		testForEachStmt();
		testForStmt();
		testIfStmt();
		testLabeledStmt();
		testReturnStmt();
		testSwitchEntryStmt();
		testSwitchStmt();
		testSynchronizedStmt();
		testThrowStmt();
		testTryStmt();
		testWhileStmt();
		testClassOrInterfaceType();
		testTypeParameter();
		testJavaLibrary();
		testJavaPackage();
		testJavaPatterns();
		testPasswordUtils();
	}

	@org.junit.Test
	public void testBean() {
		System.out.println("Bean:\n" + newBean());
	}  

	@org.junit.Test
	public void testBoundedExternalListAccessors() {
		System.out.println("BoundedExternalListAccessors:\n" + newBoundedExternalListAccessors());
	}  

	@org.junit.Test
	public void testBoundedExternalReferenceAccessors() {
		System.out.println("BoundedExternalReferenceAccessors:\n" + newBoundedExternalReferenceAccessors());
	}  

	@org.junit.Test
	public void testBoundedListAccessors() {
		System.out.println("BoundedListAccessors:\n" + newBoundedListAccessors());
	}  

	@org.junit.Test
	public void testBoundedListReferenceAccessors() {
		System.out.println("BoundedListReferenceAccessors:\n" + newBoundedListReferenceAccessors());
	}  

	@org.junit.Test
	public void testBoundedPrimitiveAccessors() {
		System.out.println("BoundedPrimitiveAccessors:\n" + newBoundedPrimitiveAccessors());
	}  

	@org.junit.Test
	public void testBoundedReferenceAccessors() {
		System.out.println("BoundedReferenceAccessors:\n" + newBoundedReferenceAccessors());
	}  

	@org.junit.Test
	public void testEnum() {
		System.out.println("Enum:\n" + newEnum());
	}  

	@org.junit.Test
	public void testEnumValue() {
		System.out.println("EnumValue:\n" + newEnumValue());
	}  

	@org.junit.Test
	public void testPojo() {
		System.out.println("Pojo:\n" + newPojo());
	}  

	@org.junit.Test
	public void testListAccessors() {
		System.out.println("ListAccessors:\n" + newListAccessors());
	}  

	@org.junit.Test
	public void testPrimitiveAccessors() {
		System.out.println("PrimitiveAccessors:\n" + newPrimitiveAccessors());
	}  

	@org.junit.Test
	public void testReferenceAccessors() {
		System.out.println("ReferenceAccessors:\n" + newReferenceAccessors());
	}  

	@org.junit.Test
	public void testPojoFactory() {
		System.out.println("PojoFactory:\n" + newPojoFactory());
	}  

	@org.junit.Test
	public void testScript() {
		System.out.println("Script:\n" + newScript());
	}  

	@org.junit.Test
	public void testValueObject() {
		System.out.println("ValueObject:\n" + newValueObject());
	}  

	@org.junit.Test
	public void testArrayCreationLevel() {
		System.out.println("ArrayCreationLevel:\n" + newArrayCreationLevel());
	}  

	@org.junit.Test
	public void testCompilationUnit() {
		System.out.println("CompilationUnit:\n" + newCompilationUnit());
	}  

	@org.junit.Test
	public void testClassOrInterfaceDeclaration() {
		System.out.println("ClassOrInterfaceDeclaration:\n" + newClassOrInterfaceDeclaration());
	}  

	@org.junit.Test
	public void testConstructorDeclaration() {
		System.out.println("ConstructorDeclaration:\n" + newConstructorDeclaration());
	}  

	@org.junit.Test
	public void testFieldDeclaration() {
		System.out.println("FieldDeclaration:\n" + newFieldDeclaration());
	}  

	@org.junit.Test
	public void testEnumDeclaration() {
		System.out.println("EnumDeclaration:\n" + newEnumDeclaration());
	}  

	@org.junit.Test
	public void testEnumConstant() {
		System.out.println("EnumConstant:\n" + newEnumConstant());
	}  

	@org.junit.Test
	public void testImportDeclaration() {
		System.out.println("ImportDeclaration:\n" + newImportDeclaration());
	}  

	@org.junit.Test
	public void testAnnotationDeclaration() {
		System.out.println("AnnotationDeclaration:\n" + newAnnotationDeclaration());
	}  

	@org.junit.Test
	public void testAnnotationMemberDeclaration() {
		System.out.println("AnnotationMemberDeclaration:\n" + newAnnotationMemberDeclaration());
	}  

	@org.junit.Test
	public void testFinalFieldDeclaration() {
		System.out.println("FinalFieldDeclaration:\n" + newFinalFieldDeclaration());
	}  

	@org.junit.Test
	public void testMethodDeclaration() {
		System.out.println("MethodDeclaration:\n" + newMethodDeclaration());
	}  

	@org.junit.Test
	public void testParameter() {
		System.out.println("Parameter:\n" + newParameter());
	}  

	@org.junit.Test
	public void testModuleDeclaration() {
		System.out.println("ModuleDeclaration:\n" + newModuleDeclaration());
	}  

	@org.junit.Test
	public void testPackageDeclaration() {
		System.out.println("PackageDeclaration:\n" + newPackageDeclaration());
	}  

	@org.junit.Test
	public void testPrivateFieldDeclaration() {
		System.out.println("PrivateFieldDeclaration:\n" + newPrivateFieldDeclaration());
	}  

	@org.junit.Test
	public void testPrivateFinalFieldDeclaration() {
		System.out.println("PrivateFinalFieldDeclaration:\n" + newPrivateFinalFieldDeclaration());
	}  

	@org.junit.Test
	public void testPublicFinalFieldDeclaration() {
		System.out.println("PublicFinalFieldDeclaration:\n" + newPublicFinalFieldDeclaration());
	}  

	@org.junit.Test
	public void testStaticFinalFieldDeclaration() {
		System.out.println("StaticFinalFieldDeclaration:\n" + newStaticFinalFieldDeclaration());
	}  

	@org.junit.Test
	public void testStaticPrivateFinalFieldDeclaration() {
		System.out.println("StaticPrivateFinalFieldDeclaration:\n" + newStaticPrivateFinalFieldDeclaration());
	}  

	@org.junit.Test
	public void testStaticPublicFinalFieldDeclaration() {
		System.out.println("StaticPublicFinalFieldDeclaration:\n" + newStaticPublicFinalFieldDeclaration());
	}  

	@org.junit.Test
	public void testVariableDeclaration() {
		System.out.println("VariableDeclaration:\n" + newVariableDeclaration());
	}  

	@org.junit.Test
	public void testArrayAccessExpression() {
		System.out.println("ArrayAccessExpression:\n" + newArrayAccessExpression());
	}  

	@org.junit.Test
	public void testArrayCreationExpression() {
		System.out.println("ArrayCreationExpression:\n" + newArrayCreationExpression());
	}  

	@org.junit.Test
	public void testArrayInitializerExpression() {
		System.out.println("ArrayInitializerExpression:\n" + newArrayInitializerExpression());
	}  

	@org.junit.Test
	public void testAssignExpression() {
		System.out.println("AssignExpression:\n" + newAssignExpression());
	}  

	@org.junit.Test
	public void testAssignThisVariableExpression() {
		System.out.println("AssignThisVariableExpression:\n" + newAssignThisVariableExpression());
	}  

	@org.junit.Test
	public void testBinaryExpression() {
		System.out.println("BinaryExpression:\n" + newBinaryExpression());
	}  

	@org.junit.Test
	public void testBooleanLiteralExpression() {
		System.out.println("BooleanLiteralExpression:\n" + newBooleanLiteralExpression());
	}  

	@org.junit.Test
	public void testCastExpression() {
		System.out.println("CastExpression:\n" + newCastExpression());
	}  

	@org.junit.Test
	public void testCharLiteralExpression() {
		System.out.println("CharLiteralExpression:\n" + newCharLiteralExpression());
	}  

	@org.junit.Test
	public void testClassExpression() {
		System.out.println("ClassExpression:\n" + newClassExpression());
	}  

	@org.junit.Test
	public void testConditionalExpression() {
		System.out.println("ConditionalExpression:\n" + newConditionalExpression());
	}  

	@org.junit.Test
	public void testDoubleLiteralExpression() {
		System.out.println("DoubleLiteralExpression:\n" + newDoubleLiteralExpression());
	}  

	@org.junit.Test
	public void testEnclosedExpression() {
		System.out.println("EnclosedExpression:\n" + newEnclosedExpression());
	}  

	@org.junit.Test
	public void testFieldAccessExpression() {
		System.out.println("FieldAccessExpression:\n" + newFieldAccessExpression());
	}  

	@org.junit.Test
	public void testInstanceOfExpression() {
		System.out.println("InstanceOfExpression:\n" + newInstanceOfExpression());
	}  

	@org.junit.Test
	public void testIntegerLiteralExpression() {
		System.out.println("IntegerLiteralExpression:\n" + newIntegerLiteralExpression());
	}  

	@org.junit.Test
	public void testLambdaExpression() {
		System.out.println("LambdaExpression:\n" + newLambdaExpression());
	}  

	@org.junit.Test
	public void testLongExpression() {
		System.out.println("LongExpression:\n" + newLongExpression());
	}  

	@org.junit.Test
	public void testMarkerAnnotationExpression() {
		System.out.println("MarkerAnnotationExpression:\n" + newMarkerAnnotationExpression());
	}  

	@org.junit.Test
	public void testMethodCallExpression() {
		System.out.println("MethodCallExpression:\n" + newMethodCallExpression());
	}  

	@org.junit.Test
	public void testMethodReferenceExpression() {
		System.out.println("MethodReferenceExpression:\n" + newMethodReferenceExpression());
	}  

	@org.junit.Test
	public void testNameExpression() {
		System.out.println("NameExpression:\n" + newNameExpression());
	}  

	@org.junit.Test
	public void testNormalAnnotationExpression() {
		System.out.println("NormalAnnotationExpression:\n" + newNormalAnnotationExpression());
	}  

	@org.junit.Test
	public void testNullLiteralExpression() {
		System.out.println("NullLiteralExpression:\n" + newNullLiteralExpression());
	}  

	@org.junit.Test
	public void testObjectCreationExpression() {
		System.out.println("ObjectCreationExpression:\n" + newObjectCreationExpression());
	}  

	@org.junit.Test
	public void testSingleMemberAnnotationExpression() {
		System.out.println("SingleMemberAnnotationExpression:\n" + newSingleMemberAnnotationExpression());
	}  

	@org.junit.Test
	public void testStringLiteralExpression() {
		System.out.println("StringLiteralExpression:\n" + newStringLiteralExpression());
	}  

	@org.junit.Test
	public void testSuperExpression() {
		System.out.println("SuperExpression:\n" + newSuperExpression());
	}  

	@org.junit.Test
	public void testThisExpression() {
		System.out.println("ThisExpression:\n" + newThisExpression());
	}  

	@org.junit.Test
	public void testThisVariableExpression() {
		System.out.println("ThisVariableExpression:\n" + newThisVariableExpression());
	}  

	@org.junit.Test
	public void testUnaryExpression() {
		System.out.println("UnaryExpression:\n" + newUnaryExpression());
	}  

	@org.junit.Test
	public void testVariableDeclarationExpression() {
		System.out.println("VariableDeclarationExpression:\n" + newVariableDeclarationExpression());
	}  

	@org.junit.Test
	public void testJavaPackageInfo() {
		System.out.println("JavaPackageInfo:\n" + newJavaPackageInfo());
	}  

	@org.junit.Test
	public void testMemberValuePair() {
		System.out.println("MemberValuePair:\n" + newMemberValuePair());
	}  

	@org.junit.Test
	public void testQualifierName() {
		System.out.println("QualifierName:\n" + newQualifierName());
	}  

	@org.junit.Test
	public void testAssertStmt() {
		System.out.println("AssertStmt:\n" + newAssertStmt());
	}  

	@org.junit.Test
	public void testBlockStmt() {
		System.out.println("BlockStmt:\n" + newBlockStmt());
	}  

	@org.junit.Test
	public void testBreakStmt() {
		System.out.println("BreakStmt:\n" + newBreakStmt());
	}  

	@org.junit.Test
	public void testCatchClause() {
		System.out.println("CatchClause:\n" + newCatchClause());
	}  

	@org.junit.Test
	public void testContinueStmt() {
		System.out.println("ContinueStmt:\n" + newContinueStmt());
	}  

	@org.junit.Test
	public void testDoStmt() {
		System.out.println("DoStmt:\n" + newDoStmt());
	}  

	@org.junit.Test
	public void testEmptyStmt() {
		System.out.println("EmptyStmt:\n" + newEmptyStmt());
	}  

	@org.junit.Test
	public void testExplicitConstructorInvocationStmt() {
		System.out.println("ExplicitConstructorInvocationStmt:\n" + newExplicitConstructorInvocationStmt());
	}  

	@org.junit.Test
	public void testExpressionStmt() {
		System.out.println("ExpressionStmt:\n" + newExpressionStmt());
	}  

	@org.junit.Test
	public void testForEachStmt() {
		System.out.println("ForEachStmt:\n" + newForEachStmt());
	}  

	@org.junit.Test
	public void testForStmt() {
		System.out.println("ForStmt:\n" + newForStmt());
	}  

	@org.junit.Test
	public void testIfStmt() {
		System.out.println("IfStmt:\n" + newIfStmt());
	}  

	@org.junit.Test
	public void testLabeledStmt() {
		System.out.println("LabeledStmt:\n" + newLabeledStmt());
	}  

	@org.junit.Test
	public void testReturnStmt() {
		System.out.println("ReturnStmt:\n" + newReturnStmt());
	}  

	@org.junit.Test
	public void testSwitchEntryStmt() {
		System.out.println("SwitchEntryStmt:\n" + newSwitchEntryStmt());
	}  

	@org.junit.Test
	public void testSwitchStmt() {
		System.out.println("SwitchStmt:\n" + newSwitchStmt());
	}  

	@org.junit.Test
	public void testSynchronizedStmt() {
		System.out.println("SynchronizedStmt:\n" + newSynchronizedStmt());
	}  

	@org.junit.Test
	public void testThrowStmt() {
		System.out.println("ThrowStmt:\n" + newThrowStmt());
	}  

	@org.junit.Test
	public void testTryStmt() {
		System.out.println("TryStmt:\n" + newTryStmt());
	}  

	@org.junit.Test
	public void testWhileStmt() {
		System.out.println("WhileStmt:\n" + newWhileStmt());
	}  

	@org.junit.Test
	public void testClassOrInterfaceType() {
		System.out.println("ClassOrInterfaceType:\n" + newClassOrInterfaceType());
	}  

	@org.junit.Test
	public void testTypeParameter() {
		System.out.println("TypeParameter:\n" + newTypeParameter());
	}  

	@org.junit.Test
	public void testJavaLibrary() {
		System.out.println("JavaLibrary:\n" + newJavaLibrary());
	}  

	@org.junit.Test
	public void testJavaPackage() {
		System.out.println("JavaPackage:\n" + newJavaPackage());
	}  

	@org.junit.Test
	public void testJavaPatterns() {
		System.out.println("JavaPatterns:\n" + newJavaPatterns());
	}  

	@org.junit.Test
	public void testPasswordUtils() {
		System.out.println("PasswordUtils:\n" + newPasswordUtils());
	}  
} 