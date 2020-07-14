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
		testDependencyManagement();
		testEntities();
		testDependencyGroup();
		testMavenProject();
		testModule();
		testProject();
		testExecution();
		testParent();
		testAntlr4();
		testCopyPlugin();
		testFrontEndMavenPlugin();
		testPlugin();
		testShadePlugin();
		testPom();
		testProperties();
		testMavenCompilerSource();
		testMavenCompilerTarget();
		testProjectBuildSourceEncoding();
		testProjectReportingOutputEncoding();
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
	public void testDependencyManagement() {
		System.out.println("\n--- TEST DependencyManagement:\n" + newDependencyManagement());
	} 

	@org.junit.Test
	public void testEntities() {
		System.out.println("\n--- TEST Entities:\n" + newEntities());
	} 

	@org.junit.Test
	public void testDependencyGroup() {
		System.out.println("\n--- TEST DependencyGroup:\n" + newDependencyGroup());
	} 

	@org.junit.Test
	public void testMavenProject() {
		System.out.println("\n--- TEST MavenProject:\n" + newMavenProject());
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
	public void testAntlr4() {
		System.out.println("\n--- TEST Antlr4:\n" + newAntlr4());
	} 

	@org.junit.Test
	public void testCopyPlugin() {
		System.out.println("\n--- TEST CopyPlugin:\n" + newCopyPlugin());
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
	public void testProperties() {
		System.out.println("\n--- TEST Properties:\n" + newProperties());
	} 

	@org.junit.Test
	public void testMavenCompilerSource() {
		System.out.println("\n--- TEST MavenCompilerSource:\n" + newMavenCompilerSource());
	} 

	@org.junit.Test
	public void testMavenCompilerTarget() {
		System.out.println("\n--- TEST MavenCompilerTarget:\n" + newMavenCompilerTarget());
	} 

	@org.junit.Test
	public void testProjectBuildSourceEncoding() {
		System.out.println("\n--- TEST ProjectBuildSourceEncoding:\n" + newProjectBuildSourceEncoding());
	} 

	@org.junit.Test
	public void testProjectReportingOutputEncoding() {
		System.out.println("\n--- TEST ProjectReportingOutputEncoding:\n" + newProjectReportingOutputEncoding());
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