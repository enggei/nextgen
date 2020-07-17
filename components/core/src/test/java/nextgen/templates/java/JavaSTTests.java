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
	}

	@org.junit.Test
	public void testBean() {
		System.out.println("\n--- TEST Bean:\n" + newBean());
	} 

	@org.junit.Test
	public void testBoundedExternalListAccessors() {
		System.out.println("\n--- TEST BoundedExternalListAccessors:\n" + newBoundedExternalListAccessors());
	} 

	@org.junit.Test
	public void testBoundedExternalReferenceAccessors() {
		System.out.println("\n--- TEST BoundedExternalReferenceAccessors:\n" + newBoundedExternalReferenceAccessors());
	} 

	@org.junit.Test
	public void testBoundedListAccessors() {
		System.out.println("\n--- TEST BoundedListAccessors:\n" + newBoundedListAccessors());
	} 

	@org.junit.Test
	public void testBoundedListReferenceAccessors() {
		System.out.println("\n--- TEST BoundedListReferenceAccessors:\n" + newBoundedListReferenceAccessors());
	} 

	@org.junit.Test
	public void testBoundedPrimitiveAccessors() {
		System.out.println("\n--- TEST BoundedPrimitiveAccessors:\n" + newBoundedPrimitiveAccessors());
	} 

	@org.junit.Test
	public void testBoundedReferenceAccessors() {
		System.out.println("\n--- TEST BoundedReferenceAccessors:\n" + newBoundedReferenceAccessors());
	} 

	@org.junit.Test
	public void testEnum() {
		System.out.println("\n--- TEST Enum:\n" + newEnum());
	} 

	@org.junit.Test
	public void testEnumValue() {
		System.out.println("\n--- TEST EnumValue:\n" + newEnumValue());
	} 

	@org.junit.Test
	public void testPojo() {
		System.out.println("\n--- TEST Pojo:\n" + newPojo());
	} 

	@org.junit.Test
	public void testListAccessors() {
		System.out.println("\n--- TEST ListAccessors:\n" + newListAccessors());
	} 

	@org.junit.Test
	public void testPrimitiveAccessors() {
		System.out.println("\n--- TEST PrimitiveAccessors:\n" + newPrimitiveAccessors());
	} 

	@org.junit.Test
	public void testReferenceAccessors() {
		System.out.println("\n--- TEST ReferenceAccessors:\n" + newReferenceAccessors());
	} 

	@org.junit.Test
	public void testPojoFactory() {
		System.out.println("\n--- TEST PojoFactory:\n" + newPojoFactory());
	} 

	@org.junit.Test
	public void testArrayCreationLevel() {
		System.out.println("\n--- TEST ArrayCreationLevel:\n" + newArrayCreationLevel());
	} 

	@org.junit.Test
	public void testCompilationUnit() {
		System.out.println("\n--- TEST CompilationUnit:\n" + newCompilationUnit());
	} 

	@org.junit.Test
	public void testClassOrInterfaceDeclaration() {
		System.out.println("\n--- TEST ClassOrInterfaceDeclaration:\n" + newClassOrInterfaceDeclaration());
	} 

	@org.junit.Test
	public void testConstructorDeclaration() {
		System.out.println("\n--- TEST ConstructorDeclaration:\n" + newConstructorDeclaration());
	} 

	@org.junit.Test
	public void testFieldDeclaration() {
		System.out.println("\n--- TEST FieldDeclaration:\n" + newFieldDeclaration());
	} 

	@org.junit.Test
	public void testEnumDeclaration() {
		System.out.println("\n--- TEST EnumDeclaration:\n" + newEnumDeclaration());
	} 

	@org.junit.Test
	public void testEnumConstant() {
		System.out.println("\n--- TEST EnumConstant:\n" + newEnumConstant());
	} 

	@org.junit.Test
	public void testImportDeclaration() {
		System.out.println("\n--- TEST ImportDeclaration:\n" + newImportDeclaration());
	} 

	@org.junit.Test
	public void testAnnotationDeclaration() {
		System.out.println("\n--- TEST AnnotationDeclaration:\n" + newAnnotationDeclaration());
	} 

	@org.junit.Test
	public void testAnnotationMemberDeclaration() {
		System.out.println("\n--- TEST AnnotationMemberDeclaration:\n" + newAnnotationMemberDeclaration());
	} 

	@org.junit.Test
	public void testFinalFieldDeclaration() {
		System.out.println("\n--- TEST FinalFieldDeclaration:\n" + newFinalFieldDeclaration());
	} 

	@org.junit.Test
	public void testMethodDeclaration() {
		System.out.println("\n--- TEST MethodDeclaration:\n" + newMethodDeclaration());
	} 

	@org.junit.Test
	public void testParameter() {
		System.out.println("\n--- TEST Parameter:\n" + newParameter());
	} 

	@org.junit.Test
	public void testModuleDeclaration() {
		System.out.println("\n--- TEST ModuleDeclaration:\n" + newModuleDeclaration());
	} 

	@org.junit.Test
	public void testPackageDeclaration() {
		System.out.println("\n--- TEST PackageDeclaration:\n" + newPackageDeclaration());
	} 

	@org.junit.Test
	public void testPrivateFieldDeclaration() {
		System.out.println("\n--- TEST PrivateFieldDeclaration:\n" + newPrivateFieldDeclaration());
	} 

	@org.junit.Test
	public void testPrivateFinalFieldDeclaration() {
		System.out.println("\n--- TEST PrivateFinalFieldDeclaration:\n" + newPrivateFinalFieldDeclaration());
	} 

	@org.junit.Test
	public void testPublicFinalFieldDeclaration() {
		System.out.println("\n--- TEST PublicFinalFieldDeclaration:\n" + newPublicFinalFieldDeclaration());
	} 

	@org.junit.Test
	public void testStaticFinalFieldDeclaration() {
		System.out.println("\n--- TEST StaticFinalFieldDeclaration:\n" + newStaticFinalFieldDeclaration());
	} 

	@org.junit.Test
	public void testStaticPrivateFinalFieldDeclaration() {
		System.out.println("\n--- TEST StaticPrivateFinalFieldDeclaration:\n" + newStaticPrivateFinalFieldDeclaration());
	} 

	@org.junit.Test
	public void testStaticPublicFinalFieldDeclaration() {
		System.out.println("\n--- TEST StaticPublicFinalFieldDeclaration:\n" + newStaticPublicFinalFieldDeclaration());
	} 

	@org.junit.Test
	public void testVariableDeclaration() {
		System.out.println("\n--- TEST VariableDeclaration:\n" + newVariableDeclaration());
	} 

	@org.junit.Test
	public void testArrayAccessExpression() {
		System.out.println("\n--- TEST ArrayAccessExpression:\n" + newArrayAccessExpression());
	} 

	@org.junit.Test
	public void testArrayCreationExpression() {
		System.out.println("\n--- TEST ArrayCreationExpression:\n" + newArrayCreationExpression());
	} 

	@org.junit.Test
	public void testArrayInitializerExpression() {
		System.out.println("\n--- TEST ArrayInitializerExpression:\n" + newArrayInitializerExpression());
	} 

	@org.junit.Test
	public void testAssignExpression() {
		System.out.println("\n--- TEST AssignExpression:\n" + newAssignExpression());
	} 

	@org.junit.Test
	public void testAssignThisVariableExpression() {
		System.out.println("\n--- TEST AssignThisVariableExpression:\n" + newAssignThisVariableExpression());
	} 

	@org.junit.Test
	public void testBinaryExpression() {
		System.out.println("\n--- TEST BinaryExpression:\n" + newBinaryExpression());
	} 

	@org.junit.Test
	public void testBooleanLiteralExpression() {
		System.out.println("\n--- TEST BooleanLiteralExpression:\n" + newBooleanLiteralExpression());
	} 

	@org.junit.Test
	public void testCastExpression() {
		System.out.println("\n--- TEST CastExpression:\n" + newCastExpression());
	} 

	@org.junit.Test
	public void testCharLiteralExpression() {
		System.out.println("\n--- TEST CharLiteralExpression:\n" + newCharLiteralExpression());
	} 

	@org.junit.Test
	public void testClassExpression() {
		System.out.println("\n--- TEST ClassExpression:\n" + newClassExpression());
	} 

	@org.junit.Test
	public void testConditionalExpression() {
		System.out.println("\n--- TEST ConditionalExpression:\n" + newConditionalExpression());
	} 

	@org.junit.Test
	public void testDoubleLiteralExpression() {
		System.out.println("\n--- TEST DoubleLiteralExpression:\n" + newDoubleLiteralExpression());
	} 

	@org.junit.Test
	public void testEnclosedExpression() {
		System.out.println("\n--- TEST EnclosedExpression:\n" + newEnclosedExpression());
	} 

	@org.junit.Test
	public void testFieldAccessExpression() {
		System.out.println("\n--- TEST FieldAccessExpression:\n" + newFieldAccessExpression());
	} 

	@org.junit.Test
	public void testInstanceOfExpression() {
		System.out.println("\n--- TEST InstanceOfExpression:\n" + newInstanceOfExpression());
	} 

	@org.junit.Test
	public void testIntegerLiteralExpression() {
		System.out.println("\n--- TEST IntegerLiteralExpression:\n" + newIntegerLiteralExpression());
	} 

	@org.junit.Test
	public void testLambdaExpression() {
		System.out.println("\n--- TEST LambdaExpression:\n" + newLambdaExpression());
	} 

	@org.junit.Test
	public void testLongExpression() {
		System.out.println("\n--- TEST LongExpression:\n" + newLongExpression());
	} 

	@org.junit.Test
	public void testMarkerAnnotationExpression() {
		System.out.println("\n--- TEST MarkerAnnotationExpression:\n" + newMarkerAnnotationExpression());
	} 

	@org.junit.Test
	public void testMethodCallExpression() {
		System.out.println("\n--- TEST MethodCallExpression:\n" + newMethodCallExpression());
	} 

	@org.junit.Test
	public void testMethodReferenceExpression() {
		System.out.println("\n--- TEST MethodReferenceExpression:\n" + newMethodReferenceExpression());
	} 

	@org.junit.Test
	public void testNameExpression() {
		System.out.println("\n--- TEST NameExpression:\n" + newNameExpression());
	} 

	@org.junit.Test
	public void testNormalAnnotationExpression() {
		System.out.println("\n--- TEST NormalAnnotationExpression:\n" + newNormalAnnotationExpression());
	} 

	@org.junit.Test
	public void testNullLiteralExpression() {
		System.out.println("\n--- TEST NullLiteralExpression:\n" + newNullLiteralExpression());
	} 

	@org.junit.Test
	public void testObjectCreationExpression() {
		System.out.println("\n--- TEST ObjectCreationExpression:\n" + newObjectCreationExpression());
	} 

	@org.junit.Test
	public void testSingleMemberAnnotationExpression() {
		System.out.println("\n--- TEST SingleMemberAnnotationExpression:\n" + newSingleMemberAnnotationExpression());
	} 

	@org.junit.Test
	public void testStringLiteralExpression() {
		System.out.println("\n--- TEST StringLiteralExpression:\n" + newStringLiteralExpression());
	} 

	@org.junit.Test
	public void testSuperExpression() {
		System.out.println("\n--- TEST SuperExpression:\n" + newSuperExpression());
	} 

	@org.junit.Test
	public void testThisExpression() {
		System.out.println("\n--- TEST ThisExpression:\n" + newThisExpression());
	} 

	@org.junit.Test
	public void testThisVariableExpression() {
		System.out.println("\n--- TEST ThisVariableExpression:\n" + newThisVariableExpression());
	} 

	@org.junit.Test
	public void testUnaryExpression() {
		System.out.println("\n--- TEST UnaryExpression:\n" + newUnaryExpression());
	} 

	@org.junit.Test
	public void testVariableDeclarationExpression() {
		System.out.println("\n--- TEST VariableDeclarationExpression:\n" + newVariableDeclarationExpression());
	} 

	@org.junit.Test
	public void testJavaPackageInfo() {
		System.out.println("\n--- TEST JavaPackageInfo:\n" + newJavaPackageInfo());
	} 

	@org.junit.Test
	public void testMemberValuePair() {
		System.out.println("\n--- TEST MemberValuePair:\n" + newMemberValuePair());
	} 

	@org.junit.Test
	public void testQualifierName() {
		System.out.println("\n--- TEST QualifierName:\n" + newQualifierName());
	} 

	@org.junit.Test
	public void testAssertStmt() {
		System.out.println("\n--- TEST AssertStmt:\n" + newAssertStmt());
	} 

	@org.junit.Test
	public void testBlockStmt() {
		System.out.println("\n--- TEST BlockStmt:\n" + newBlockStmt());
	} 

	@org.junit.Test
	public void testBreakStmt() {
		System.out.println("\n--- TEST BreakStmt:\n" + newBreakStmt());
	} 

	@org.junit.Test
	public void testCatchClause() {
		System.out.println("\n--- TEST CatchClause:\n" + newCatchClause());
	} 

	@org.junit.Test
	public void testContinueStmt() {
		System.out.println("\n--- TEST ContinueStmt:\n" + newContinueStmt());
	} 

	@org.junit.Test
	public void testDoStmt() {
		System.out.println("\n--- TEST DoStmt:\n" + newDoStmt());
	} 

	@org.junit.Test
	public void testEmptyStmt() {
		System.out.println("\n--- TEST EmptyStmt:\n" + newEmptyStmt());
	} 

	@org.junit.Test
	public void testExplicitConstructorInvocationStmt() {
		System.out.println("\n--- TEST ExplicitConstructorInvocationStmt:\n" + newExplicitConstructorInvocationStmt());
	} 

	@org.junit.Test
	public void testExpressionStmt() {
		System.out.println("\n--- TEST ExpressionStmt:\n" + newExpressionStmt());
	} 

	@org.junit.Test
	public void testForEachStmt() {
		System.out.println("\n--- TEST ForEachStmt:\n" + newForEachStmt());
	} 

	@org.junit.Test
	public void testForStmt() {
		System.out.println("\n--- TEST ForStmt:\n" + newForStmt());
	} 

	@org.junit.Test
	public void testIfStmt() {
		System.out.println("\n--- TEST IfStmt:\n" + newIfStmt());
	} 

	@org.junit.Test
	public void testLabeledStmt() {
		System.out.println("\n--- TEST LabeledStmt:\n" + newLabeledStmt());
	} 

	@org.junit.Test
	public void testReturnStmt() {
		System.out.println("\n--- TEST ReturnStmt:\n" + newReturnStmt());
	} 

	@org.junit.Test
	public void testSwitchEntryStmt() {
		System.out.println("\n--- TEST SwitchEntryStmt:\n" + newSwitchEntryStmt());
	} 

	@org.junit.Test
	public void testSwitchStmt() {
		System.out.println("\n--- TEST SwitchStmt:\n" + newSwitchStmt());
	} 

	@org.junit.Test
	public void testSynchronizedStmt() {
		System.out.println("\n--- TEST SynchronizedStmt:\n" + newSynchronizedStmt());
	} 

	@org.junit.Test
	public void testThrowStmt() {
		System.out.println("\n--- TEST ThrowStmt:\n" + newThrowStmt());
	} 

	@org.junit.Test
	public void testTryStmt() {
		System.out.println("\n--- TEST TryStmt:\n" + newTryStmt());
	} 

	@org.junit.Test
	public void testWhileStmt() {
		System.out.println("\n--- TEST WhileStmt:\n" + newWhileStmt());
	} 

	@org.junit.Test
	public void testClassOrInterfaceType() {
		System.out.println("\n--- TEST ClassOrInterfaceType:\n" + newClassOrInterfaceType());
	} 

	@org.junit.Test
	public void testTypeParameter() {
		System.out.println("\n--- TEST TypeParameter:\n" + newTypeParameter());
	} 

	@org.junit.Test
	public void testJavaLibrary() {
		System.out.println("\n--- TEST JavaLibrary:\n" + newJavaLibrary());
	} 

	@org.junit.Test
	public void testJavaPackage() {
		System.out.println("\n--- TEST JavaPackage:\n" + newJavaPackage());
	} 

	@org.junit.Test
	public void testJavaPatterns() {
		System.out.println("\n--- TEST JavaPatterns:\n" + newJavaPatterns());
	} 
} 