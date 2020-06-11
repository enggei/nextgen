package nextgen.templates.typescript;

import nextgen.templates.TypeScriptPatterns;

import static nextgen.templates.typescript.TypeScriptST.*;

/**
 * Tests for TypeScriptST
 **/
public class TypeScriptSTTests {

	@org.junit.Test
	public void testAll() {
		System.out.println(TypeScriptPatterns.newBoolean("aBoolean"));
	}

	@org.junit.Test
	public void testVariableDeclaration() {
		System.out.println("\n--- TEST VariableDeclaration:\n" + newVariableDeclaration());
	} 
} 