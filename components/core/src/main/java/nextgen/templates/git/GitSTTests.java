package nextgen.templates.git;

import static nextgen.templates.git.GitST.*;

/**
 * Tests for GitST
 **/
public class GitSTTests {

	@org.junit.Test
	public void testAll() {
		testGitignore();
		testRemoveDir();
		testRemoveFile();
	}

	@org.junit.Test
	public void testGitignore() {
		System.out.println("\n--- TEST Gitignore:\n" + newGitignore());
	}

	@org.junit.Test
	public void testRemoveDir() {
		System.out.println("\n--- TEST RemoveDir:\n" + newRemoveDir());
	}

	@org.junit.Test
	public void testRemoveFile() {
		System.out.println("\n--- TEST RemoveFile:\n" + newRemoveFile());
	}
}