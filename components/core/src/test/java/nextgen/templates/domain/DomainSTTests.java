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
		testRelation();
		testJavaProject();
		testJavaLibrary();
		testJavaPackage();
		testModel();
	}

	@org.junit.Test
	public void testDomain() {
		System.out.println("Domain:\n" + newDomain());
	}  

	@org.junit.Test
	public void testEntity() {
		System.out.println("Entity:\n" + newEntity());
	}  

	@org.junit.Test
	public void testRelation() {
		System.out.println("Relation:\n" + newRelation());
	}  

	@org.junit.Test
	public void testJavaProject() {
		System.out.println("JavaProject:\n" + newJavaProject());
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
	public void testModel() {
		System.out.println("Model:\n" + newModel());
	}  
} 