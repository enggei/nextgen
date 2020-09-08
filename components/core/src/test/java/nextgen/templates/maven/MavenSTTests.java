package nextgen.templates.maven;

import static nextgen.templates.maven.MavenST.*;

/**
 * Tests for MavenST
 **/
public class MavenSTTests {

	@org.junit.Test
	public void testAll() {
		testDependencyManagement();
		testAntlr4();
		testAntlr4Simple();
		testCopyPlugin();
		testFrontEndMavenPlugin();
		testNpmScript();
		testPlugin();
		testShadePlugin();
		testPom();
		testBuild();
		testDependency();
		testDependencyGroup();
		testExecution();
		testParent();
		testProperties();
		testMavenCompilerSource();
		testMavenCompilerTarget();
		testProjectBuildSourceEncoding();
		testProjectReportingOutputEncoding();
		testPropertyReference();
		testRepository();
		testProject();
		testProjectGenerator();
		testProjectPackage();
	}

	@org.junit.Test
	public void testDependencyManagement() {
		System.out.println("DependencyManagement:\n" + newDependencyManagement());
	}  

	@org.junit.Test
	public void testAntlr4() {
		System.out.println("Antlr4:\n" + newAntlr4());
	}  

	@org.junit.Test
	public void testAntlr4Simple() {
		System.out.println("Antlr4Simple:\n" + newAntlr4Simple());
	}  

	@org.junit.Test
	public void testCopyPlugin() {
		System.out.println("CopyPlugin:\n" + newCopyPlugin());
	}  

	@org.junit.Test
	public void testFrontEndMavenPlugin() {
		System.out.println("FrontEndMavenPlugin:\n" + newFrontEndMavenPlugin());
	}  

	@org.junit.Test
	public void testNpmScript() {
		System.out.println("NpmScript:\n" + newNpmScript());
	}  

	@org.junit.Test
	public void testPlugin() {
		System.out.println("Plugin:\n" + newPlugin());
	}  

	@org.junit.Test
	public void testShadePlugin() {
		System.out.println("ShadePlugin:\n" + newShadePlugin());
	}  

	@org.junit.Test
	public void testPom() {
		System.out.println("Pom:\n" + newPom());
	}  

	@org.junit.Test
	public void testBuild() {
		System.out.println("Build:\n" + newBuild());
	}  

	@org.junit.Test
	public void testDependency() {
		System.out.println("Dependency:\n" + newDependency());
	}  

	@org.junit.Test
	public void testDependencyGroup() {
		System.out.println("DependencyGroup:\n" + newDependencyGroup());
	}  

	@org.junit.Test
	public void testExecution() {
		System.out.println("Execution:\n" + newExecution());
	}  

	@org.junit.Test
	public void testParent() {
		System.out.println("Parent:\n" + newParent());
	}  

	@org.junit.Test
	public void testProperties() {
		System.out.println("Properties:\n" + newProperties());
	}  

	@org.junit.Test
	public void testMavenCompilerSource() {
		System.out.println("MavenCompilerSource:\n" + newMavenCompilerSource());
	}  

	@org.junit.Test
	public void testMavenCompilerTarget() {
		System.out.println("MavenCompilerTarget:\n" + newMavenCompilerTarget());
	}  

	@org.junit.Test
	public void testProjectBuildSourceEncoding() {
		System.out.println("ProjectBuildSourceEncoding:\n" + newProjectBuildSourceEncoding());
	}  

	@org.junit.Test
	public void testProjectReportingOutputEncoding() {
		System.out.println("ProjectReportingOutputEncoding:\n" + newProjectReportingOutputEncoding());
	}  

	@org.junit.Test
	public void testPropertyReference() {
		System.out.println("PropertyReference:\n" + newPropertyReference());
	}  

	@org.junit.Test
	public void testRepository() {
		System.out.println("Repository:\n" + newRepository());
	}  

	@org.junit.Test
	public void testProject() {
		System.out.println("Project:\n" + newProject());
	}  

	@org.junit.Test
	public void testProjectGenerator() {
		System.out.println("ProjectGenerator:\n" + newProjectGenerator());
	}  

	@org.junit.Test
	public void testProjectPackage() {
		System.out.println("ProjectPackage:\n" + newProjectPackage());
	}  
} 