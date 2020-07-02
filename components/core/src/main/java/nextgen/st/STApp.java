package nextgen.st;

import com.generator.util.SwingUtil;
import nextgen.st.domain.STAppModel;
import nextgen.st.domain.STGDirectory;
import nextgen.st.domain.STGroupModel;
import nextgen.st.domain.STJsonFactory;
import nextgen.st.model.neo.STModelDB;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Optional;

import static nextgen.st.STParser.readJsonObject;
import static nextgen.st.domain.STJsonFactory.newSTGDirectory;

public class STApp extends JFrame {

    final STNavigator navigator;
    final JTabbedPane tabbedPane = new JTabbedPane();

    public STApp(STAppModel appModel) throws HeadlessException {
        super("ST Editor");

        navigator = new STNavigator(appModel, tabbedPane);
        tabbedPane.setPreferredSize(new Dimension(1170, 1024));

        final JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        contentPanel.add(navigator, BorderLayout.WEST);
        contentPanel.add(tabbedPane, BorderLayout.CENTER);
        add(contentPanel, BorderLayout.CENTER);

        tabbedPane.addTab("Canvas", new nextgen.st.canvas.STCanvas(navigator.stRenderer, navigator.db));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        for (UIManager.LookAndFeelInfo laf : UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(laf.getName())) {
                try {
                    UIManager.setLookAndFeel(laf.getClassName());
                } catch (Exception e) {
                    System.err.println("Could not set look and feel '" + "Nimbus" + "': " + e.getMessage());
                }
            }
        }

        final File root = new File("./components/core");
        final File srcMain = new File(root, "src/main");
        final File srcTest = new File(root, "src/test");
        final File javaMain = new File(srcMain, "java");
        final File javaTest = new File(srcTest, "java");
        final File resources = new File(srcMain, "resources");
        final File templates = new File(resources, "templates");

        SwingUtil.show(new STApp(STJsonFactory.newSTAppModel()
                .setModelDb("./db")
                .setGeneratorRoot(javaMain.getAbsolutePath())
                .setGeneratorPackage("nextgen.st")
                .setGeneratorName("StringTemplate")
                .addDirectories(load(templates, javaMain, "nextgen.templates"))));
    }

    public static STGDirectory load(File path, File outputRoot, String outputPackage) {

        final STGDirectory root = newSTGDirectory()
                .setPath(path.getAbsolutePath())
                .setOutputPackage(outputPackage)
                .setOutputPath(outputRoot.getAbsolutePath());

        Optional.ofNullable(list(path, ".json"))
                .ifPresent(files -> {
                    for (File file : files) {
                        root.addGroups(new STGroupModel(readJsonObject(file)));
                    }
                });

        return root;
    }

    public static File[] list(File dir, String postfix) {
        final String s = postfix.toLowerCase();
        return dir.listFiles(pathname -> pathname.getAbsolutePath().toLowerCase().endsWith(s));
    }
}