package nextgen.templates.test;

import static nextgen.templates.test.TestST.*;

/**
 * Tests for TestST
 **/
public class TestSTTests {

	@org.junit.Test
	public void testAll() {
		testKv();
		testList();
		testSingle();
		testParameterTests();
		testAllTypes();
		testComplex();
		testConditional();
		testEmbeddedKVConditional();
		testPatterns();
		testTemp();
	}

	@org.junit.Test
	public void testKv() {
		System.out.println("Kv:\n" + newKv());
	}  

	@org.junit.Test
	public void testList() {
		System.out.println("List:\n" + newList());
	}  

	@org.junit.Test
	public void testSingle() {
		System.out.println("Single:\n" + newSingle());
	}  

	@org.junit.Test
	public void testParameterTests() {
		System.out.println("ParameterTests:\n" + newParameterTests());
	}  

	@org.junit.Test
	public void testAllTypes() {
		System.out.println("AllTypes:\n" + newAllTypes());
	}  

	@org.junit.Test
	public void testComplex() {
		System.out.println("Complex:\n" + newComplex());
	}  

	@org.junit.Test
	public void testConditional() {
		System.out.println("Conditional:\n" + newConditional());
	}  

	@org.junit.Test
	public void testEmbeddedKVConditional() {
		System.out.println("EmbeddedKVConditional:\n" + newEmbeddedKVConditional());
	}  

	@org.junit.Test
	public void testPatterns() {
		System.out.println("Patterns:\n" + newPatterns());
	}  

	@org.junit.Test
	public void testTemp() {
		System.out.println("Temp:\n" + newTemp());
	}  
} 