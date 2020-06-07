package nextgen.templates.maven;

import static nextgen.templates.maven.MavenST.*;

/**
 * Tests for MavenST
 **/
public class MavenSTTests {

	@org.junit.Test
	public void testAll() {
		testBuild();
		testDependency();
		testDependencyGroup();
		testModule();
		testProject();
		testExecution();
		testParent();
		testFrontEndMavenPlugin();
		testPlugin();
		testShadePlugin();
		testPom();
		testPropertyReference();
		testRepository();
	}

	@org.junit.Test
	public void testBuild() {
		System.out.println("\n--- TEST Build:\n" + newBuild());
	} 

	@org.junit.Test
	public void testDependency() {
		System.out.println("\n--- TEST Dependency:\n" + newDependency());
	} 

	@org.junit.Test
	public void testDependencyGroup() {
		System.out.println("\n--- TEST DependencyGroup:\n" + newDependencyGroup());
	} 

	@org.junit.Test
	public void testModule() {
		System.out.println("\n--- TEST Module:\n" + newModule());
	} 

	@org.junit.Test
	public void testProject() {
		System.out.println("\n--- TEST Project:\n" + newProject());
	} 

	@org.junit.Test
	public void testExecution() {
		System.out.println("\n--- TEST Execution:\n" + newExecution());
	} 

	@org.junit.Test
	public void testParent() {
		System.out.println("\n--- TEST Parent:\n" + newParent());
	} 

	@org.junit.Test
	public void testFrontEndMavenPlugin() {
		System.out.println("\n--- TEST FrontEndMavenPlugin:\n" + newFrontEndMavenPlugin());
	} 

	@org.junit.Test
	public void testPlugin() {
		System.out.println("\n--- TEST Plugin:\n" + newPlugin());
	} 

	@org.junit.Test
	public void testShadePlugin() {
		System.out.println("\n--- TEST ShadePlugin:\n" + newShadePlugin());
	} 

	@org.junit.Test
	public void testPom() {
		System.out.println("\n--- TEST Pom:\n" + newPom());
	} 

	@org.junit.Test
	public void testPropertyReference() {
		System.out.println("\n--- TEST PropertyReference:\n" + newPropertyReference());
	} 

	@org.junit.Test
	public void testRepository() {
		System.out.println("\n--- TEST Repository:\n" + newRepository());
	} 
} 