package templates.typescript;

import static nextgen.templates.typescript.TypeScriptST.*;

/**
 * Tests for TypeScriptST
 **/
public class TypeScriptSTTests {

	@org.junit.Test
	public void testAll() {
		testArrayInitializer();
		testArrayType();
		testEmbeddedExpression();
		testEnumDeclaration();
		testFunctionalTypeInterface();
		testInterface();
		testTupleType();
		testVariableDeclaration();
	}

	@org.junit.Test
	public void testArrayInitializer() {
		System.out.println("\n--- TEST ArrayInitializer:\n" + newArrayInitializer());
	} 

	@org.junit.Test
	public void testArrayType() {
		System.out.println("\n--- TEST ArrayType:\n" + newArrayType());
	} 

	@org.junit.Test
	public void testEmbeddedExpression() {
		System.out.println("\n--- TEST EmbeddedExpression:\n" + newEmbeddedExpression());
	} 

	@org.junit.Test
	public void testEnumDeclaration() {
		System.out.println("\n--- TEST EnumDeclaration:\n" + newEnumDeclaration());
	} 

	@org.junit.Test
	public void testFunctionalTypeInterface() {
		System.out.println("\n--- TEST FunctionalTypeInterface:\n" + newFunctionalTypeInterface());
	} 

	@org.junit.Test
	public void testInterface() {
		System.out.println("\n--- TEST Interface:\n" + newInterface());
	} 

	@org.junit.Test
	public void testTupleType() {
		System.out.println("\n--- TEST TupleType:\n" + newTupleType());
	} 

	@org.junit.Test
	public void testVariableDeclaration() {
		System.out.println("\n--- TEST VariableDeclaration:\n" + newVariableDeclaration());
	} 
} 