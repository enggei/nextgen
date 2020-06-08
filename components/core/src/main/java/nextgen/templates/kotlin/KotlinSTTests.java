package nextgen.templates.kotlin;

import static nextgen.templates.kotlin.KotlinST.*;

/**
 * Tests for KotlinST
 **/
public class KotlinSTTests {

	@org.junit.Test
	public void testAll() {
		testPoko();
		testAnnotationDeclaration();
		testAnnotationParam();
		testClassDeclaration();
		testExtending();
		testFieldDeclaration();
		testPackageDeclaration();
	}

	@org.junit.Test
	public void testPoko() {
		System.out.println("\n--- TEST Poko:\n" + newPoko());
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
	public void testExtending() {
		System.out.println("\n--- TEST Extending:\n" + newExtending());
	} 

	@org.junit.Test
	public void testFieldDeclaration() {
		System.out.println("\n--- TEST FieldDeclaration:\n" + newFieldDeclaration());
	} 

	@org.junit.Test
	public void testPackageDeclaration() {
		System.out.println("\n--- TEST PackageDeclaration:\n" + newPackageDeclaration());
	} 
} 