package nextgen.templates.kotlin;

import static nextgen.templates.kotlin.KotlinST.*;

/**
 * Tests for KotlinST
 **/
public class KotlinSTTests {

	@org.junit.Test
	public void testAll() {
		testPoko();
		testArrayEqualsExpression();
		testCastExpression();
		testComplexStringExpression();
		testConstructorCallExpression();
		testEqualsExpression();
		testFunctionCallExpression();
		testFunctionCallParamExpression();
		testNullExpression();
		testScopeExpression();
		testSimpleStringExpression();
		testThisExpression();
		testToStringExpression();
		testVarExpression();
		testAnnotationDeclaration();
		testAnnotationParam();
		testClassDeclaration();
		testOverrideEquals();
		testOverrideHashCode();
		testOverrideToString();
		testExtending();
		testFieldDeclaration();
		testFunctionDeclaration();
		testFunctionParam();
		testPackageDeclaration();
		testImportStatement();
		testArrayInitializer();
		testEmptyArrayInitializer();
		testExpressionInitializer();
		testListInitializer();
		testMapInitializer();
		testNullInitializer();
		testKotlinFile();
		testArrayType();
		testListType();
		testMapType();
		testNamedType();
		testNullableType();
	}

	@org.junit.Test
	public void testPoko() {
		System.out.println("\n--- TEST Poko:\n" + newPoko());
	} 

	@org.junit.Test
	public void testArrayEqualsExpression() {
		System.out.println("\n--- TEST ArrayEqualsExpression:\n" + newArrayEqualsExpression());
	} 

	@org.junit.Test
	public void testCastExpression() {
		System.out.println("\n--- TEST CastExpression:\n" + newCastExpression());
	} 

	@org.junit.Test
	public void testComplexStringExpression() {
		System.out.println("\n--- TEST ComplexStringExpression:\n" + newComplexStringExpression());
	} 

	@org.junit.Test
	public void testConstructorCallExpression() {
		System.out.println("\n--- TEST ConstructorCallExpression:\n" + newConstructorCallExpression());
	} 

	@org.junit.Test
	public void testEqualsExpression() {
		System.out.println("\n--- TEST EqualsExpression:\n" + newEqualsExpression());
	} 

	@org.junit.Test
	public void testFunctionCallExpression() {
		System.out.println("\n--- TEST FunctionCallExpression:\n" + newFunctionCallExpression());
	} 

	@org.junit.Test
	public void testFunctionCallParamExpression() {
		System.out.println("\n--- TEST FunctionCallParamExpression:\n" + newFunctionCallParamExpression());
	} 

	@org.junit.Test
	public void testNullExpression() {
		System.out.println("\n--- TEST NullExpression:\n" + newNullExpression());
	} 

	@org.junit.Test
	public void testScopeExpression() {
		System.out.println("\n--- TEST ScopeExpression:\n" + newScopeExpression());
	} 

	@org.junit.Test
	public void testSimpleStringExpression() {
		System.out.println("\n--- TEST SimpleStringExpression:\n" + newSimpleStringExpression());
	} 

	@org.junit.Test
	public void testThisExpression() {
		System.out.println("\n--- TEST ThisExpression:\n" + newThisExpression());
	} 

	@org.junit.Test
	public void testToStringExpression() {
		System.out.println("\n--- TEST ToStringExpression:\n" + newToStringExpression());
	} 

	@org.junit.Test
	public void testVarExpression() {
		System.out.println("\n--- TEST VarExpression:\n" + newVarExpression());
	} 

	@org.junit.Test
	public void testAnnotationDeclaration() {
		System.out.println("\n--- TEST AnnotationDeclaration:\n" + newAnnotationDeclaration());
	} 

	@org.junit.Test
	public void testAnnotationParam() {
		System.out.println("\n--- TEST AnnotationParam:\n" + newAnnotationParam());
	} 

	@org.junit.Test
	public void testClassDeclaration() {
		System.out.println("\n--- TEST ClassDeclaration:\n" + newClassDeclaration());
	} 

	@org.junit.Test
	public void testOverrideEquals() {
		System.out.println("\n--- TEST OverrideEquals:\n" + newOverrideEquals());
	} 

	@org.junit.Test
	public void testOverrideHashCode() {
		System.out.println("\n--- TEST OverrideHashCode:\n" + newOverrideHashCode());
	} 

	@org.junit.Test
	public void testOverrideToString() {
		System.out.println("\n--- TEST OverrideToString:\n" + newOverrideToString());
	} 

	@org.junit.Test
	public void testExtending() {
		System.out.println("\n--- TEST Extending:\n" + newExtending());
	} 

	@org.junit.Test
	public void testFieldDeclaration() {
		System.out.println("\n--- TEST FieldDeclaration:\n" + newFieldDeclaration());
	} 

	@org.junit.Test
	public void testFunctionDeclaration() {
		System.out.println("\n--- TEST FunctionDeclaration:\n" + newFunctionDeclaration());
	} 

	@org.junit.Test
	public void testFunctionParam() {
		System.out.println("\n--- TEST FunctionParam:\n" + newFunctionParam());
	} 

	@org.junit.Test
	public void testPackageDeclaration() {
		System.out.println("\n--- TEST PackageDeclaration:\n" + newPackageDeclaration());
	} 

	@org.junit.Test
	public void testImportStatement() {
		System.out.println("\n--- TEST ImportStatement:\n" + newImportStatement());
	} 

	@org.junit.Test
	public void testArrayInitializer() {
		System.out.println("\n--- TEST ArrayInitializer:\n" + newArrayInitializer());
	} 

	@org.junit.Test
	public void testEmptyArrayInitializer() {
		System.out.println("\n--- TEST EmptyArrayInitializer:\n" + newEmptyArrayInitializer());
	} 

	@org.junit.Test
	public void testExpressionInitializer() {
		System.out.println("\n--- TEST ExpressionInitializer:\n" + newExpressionInitializer());
	} 

	@org.junit.Test
	public void testListInitializer() {
		System.out.println("\n--- TEST ListInitializer:\n" + newListInitializer());
	} 

	@org.junit.Test
	public void testMapInitializer() {
		System.out.println("\n--- TEST MapInitializer:\n" + newMapInitializer());
	} 

	@org.junit.Test
	public void testNullInitializer() {
		System.out.println("\n--- TEST NullInitializer:\n" + newNullInitializer());
	} 

	@org.junit.Test
	public void testKotlinFile() {
		System.out.println("\n--- TEST KotlinFile:\n" + newKotlinFile());
	} 

	@org.junit.Test
	public void testArrayType() {
		System.out.println("\n--- TEST ArrayType:\n" + newArrayType());
	} 

	@org.junit.Test
	public void testListType() {
		System.out.println("\n--- TEST ListType:\n" + newListType());
	} 

	@org.junit.Test
	public void testMapType() {
		System.out.println("\n--- TEST MapType:\n" + newMapType());
	} 

	@org.junit.Test
	public void testNamedType() {
		System.out.println("\n--- TEST NamedType:\n" + newNamedType());
	} 

	@org.junit.Test
	public void testNullableType() {
		System.out.println("\n--- TEST NullableType:\n" + newNullableType());
	} 
} 