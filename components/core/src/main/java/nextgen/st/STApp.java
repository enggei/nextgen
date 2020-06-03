package nextgen.st;

import com.generator.util.FileUtil;
import com.generator.util.SwingUtil;
import io.vertx.core.json.JsonObject;
import nextgen.st.domain.STGroupModel;
import nextgen.st.domain.STJsonFactory;
import nextgen.st.domain.STGDirectory;
import nextgen.st.domain.STGParseResult;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Optional;

public class STApp extends JFrame {

    final STNavigator navigator;
    final JTabbedPane tabbedPane = new JTabbedPane();

    public STApp(STGDirectory root) throws HeadlessException {
        super("ST Editor");

        navigator = new STNavigator(root, tabbedPane);
        tabbedPane.setPreferredSize(new Dimension(800, 600));

        final JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        contentPanel.add(navigator, BorderLayout.WEST);
        contentPanel.add(tabbedPane, BorderLayout.CENTER);
        add(contentPanel, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SwingUtil.show(new STApp(load("/home/goe/projects/nextgen/components/core/src/main/resources/templates")));
    }

    public static STGDirectory load(String dir) {

        final STGDirectory root = STJsonFactory.newSTGDirectory()
                .setPath(new File(dir).getPath())
                .setOutputPackage("tmp.st")
                .setOutputPath("/home/goe/projects/nextgen/components/core/src/test/java/");

        Optional.ofNullable(FileUtil.list(dir, ".json"))
                .ifPresent(files -> {
                    for (File file : files) {
                        root.addGroups(new STGroupModel(new JsonObject(FileUtil.read(file))));
                    }
                });

        Optional.ofNullable(FileUtil.list(dir, ".stg"))
                .ifPresent(stgFiles -> {
                    for (File stgFile : stgFiles) {

                        final Optional<STGroupModel> first = root.getGroups().filter(stGroupModel -> stGroupModel.getStgFile().equals(stgFile.getAbsolutePath())).findFirst();
                        if (first.isPresent()) continue;

                        final STGParseResult parseResult = STParser.parse(stgFile);
                        if (parseResult.getErrors().count() == 0) {
                            root.addGroups(parseResult.getParsed());
                        } else
                            parseResult.getErrors().forEach(stgError -> System.out.println(stgFile.getName() + " : " + stgError.getType() + " " + stgError.getMessage()));
                    }
                });

        return root;
    }
}