package nextgen.templates.git;

import static nextgen.templates.git.GitST.*;

/**
 * Tests for GitST
 **/
public class GitSTTests {

	@org.junit.Test
	public void testAll() {
		testGitignore();
	}

	@org.junit.Test
	public void testGitignore() {
		System.out.println("\n--- TEST Gitignore:\n" + newGitignore());
	} 
} 