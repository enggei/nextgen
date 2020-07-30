package nextgen.st.importers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

import static nextgen.utils.FileUtil.tryToCreateFileIfNotExists;

public class AntlrGrammarsImporter extends BaseImporter {

    public static void main(String[] args) throws IOException {
        new AntlrGrammarsImporter();
    }

    public AntlrGrammarsImporter() throws IOException {

        final File grammarsRoot = new File("/home/goe/projects/grammars-v4");

        final LinkedHashSet<File> grammarFiles = new LinkedHashSet<>();
        findFiles(grammarsRoot, grammarFiles);

        for (File grammarFile : grammarFiles) {
            System.out.println(grammarFile.getAbsolutePath());
            final File language = grammarFile.getParentFile();
            final File newFile = tryToCreateFileIfNotExists(new File(new File("components/core/src/test/java/grammars", language.getName()), grammarFile.getName()));
            Files.copy(grammarFile.toPath(), newFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        }
    }

    public static void findFiles(File grammarsRoot, Set<File> grammarFiles) {
        Arrays.asList(Objects.requireNonNull(grammarsRoot.listFiles())).forEach(file -> {
            if (file.isDirectory()) {
                findFiles(file, grammarFiles);
            } else if (file.getName().endsWith(".g4")) {
                grammarFiles.add(file);
            }
        });
    }
}
