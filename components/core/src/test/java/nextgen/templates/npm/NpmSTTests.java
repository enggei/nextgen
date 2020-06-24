package nextgen.templates.npm;

import static nextgen.templates.npm.NpmST.*;

/**
 * Tests for NpmST
 **/
public class NpmSTTests {

	@org.junit.Test
	public void testAll() {
		testBabelrc();
		testDependency();
		testNpmProject();
		testPackageJson();
		testScript();
		testWebpackConfig();
	}

	@org.junit.Test
	public void testBabelrc() {
		System.out.println("\n--- TEST Babelrc:\n" + newBabelrc());
	} 

	@org.junit.Test
	public void testDependency() {
		System.out.println("\n--- TEST Dependency:\n" + newDependency());
	} 

	@org.junit.Test
	public void testNpmProject() {
		System.out.println("\n--- TEST NpmProject:\n" + newNpmProject());
	} 

	@org.junit.Test
	public void testPackageJson() {
		System.out.println("\n--- TEST PackageJson:\n" + newPackageJson());
	} 

	@org.junit.Test
	public void testScript() {
		System.out.println("\n--- TEST Script:\n" + newScript());
	} 

	@org.junit.Test
	public void testWebpackConfig() {
		System.out.println("\n--- TEST WebpackConfig:\n" + newWebpackConfig());
	} 
} 