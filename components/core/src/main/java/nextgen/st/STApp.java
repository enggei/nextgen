package nextgen.st;

import com.generator.util.FileUtil;
import com.generator.util.SwingUtil;
import nextgen.st.domain.STFactory;
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

    private static STGDirectory load(String dir) {

        final STGDirectory root = STFactory.newSTGDirectory()
                .setPath(new File(dir));

        final Optional<File[]> files = Optional.ofNullable(FileUtil.list(dir, ".stg"));
        files.ifPresent(stgFiles -> {
            for (File stgFile : stgFiles) {
                final STGParseResult parseResult = STParser.parse(stgFile);
                if (parseResult.getErrors().isEmpty())
                    root.addGroups(parseResult.getParsed());
                else
                    parseResult.getErrors().forEach(stgError -> System.out.println(stgFile.getName() + " : " + stgError.getType() + " " + stgError.getMessage()));
            }
        });

        return root;
    }
}