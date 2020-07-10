package nextgen.templates.domain;

import static nextgen.templates.domain.DomainST.*;

/**
 * Tests for DomainST
 **/
public class DomainSTTests {

	@org.junit.Test
	public void testAll() {
		testDomain();
		testEntity();
		testJavaProject();
		testJavaCorePackage();
		testJavaLibrary();
		testJavaPackage();
		testExtendedNameEntity();
		testMethodCallExpression();
		testJavaSwingPackage();
		testNeo4JPackage();
		testRelation();
	}

	@org.junit.Test
	public void testDomain() {
		System.out.println("\n--- TEST Domain:\n" + newDomain());
	} 

	@org.junit.Test
	public void testEntity() {
		System.out.println("\n--- TEST Entity:\n" + newEntity());
	} 

	@org.junit.Test
	public void testJavaProject() {
		System.out.println("\n--- TEST JavaProject:\n" + newJavaProject());
	} 

	@org.junit.Test
	public void testJavaCorePackage() {
		System.out.println("\n--- TEST JavaCorePackage:\n" + newJavaCorePackage());
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
	public void testExtendedNameEntity() {
		System.out.println("\n--- TEST ExtendedNameEntity:\n" + newExtendedNameEntity());
	} 

	@org.junit.Test
	public void testMethodCallExpression() {
		System.out.println("\n--- TEST MethodCallExpression:\n" + newMethodCallExpression());
	} 

	@org.junit.Test
	public void testJavaSwingPackage() {
		System.out.println("\n--- TEST JavaSwingPackage:\n" + newJavaSwingPackage());
	} 

	@org.junit.Test
	public void testNeo4JPackage() {
		System.out.println("\n--- TEST Neo4JPackage:\n" + newNeo4JPackage());
	} 

	@org.junit.Test
	public void testRelation() {
		System.out.println("\n--- TEST Relation:\n" + newRelation());
	} 
} 