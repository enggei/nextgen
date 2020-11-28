package nextgen.templates;

import nextgen.st.STGenerator;
import nextgen.templates.git.GitST;
import nextgen.templates.git.Gitignore;

import java.io.File;

public class GitPatterns extends GitST {

    public static void write(File root, Gitignore gitignore) {
        STGenerator.writeToFile(gitignore, null, ".gitignore", null, root);
    }

}