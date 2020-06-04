package nextgen.st;

import com.generator.util.SwingUtil;
import io.vertx.core.json.JsonObject;
import nextgen.st.domain.STAppModel;
import nextgen.st.domain.STGDirectory;
import nextgen.st.domain.STGroupModel;
import nextgen.st.domain.STJsonFactory;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Optional;

public class STApp extends JFrame {

    final STNavigator navigator;
    final JTabbedPane tabbedPane = new JTabbedPane();

    public STApp(STAppModel appModel) throws HeadlessException {
        super("ST Editor");

        navigator = new STNavigator(appModel, tabbedPane);
        tabbedPane.setPreferredSize(new Dimension(800, 600));

        final JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        contentPanel.add(navigator, BorderLayout.WEST);
        contentPanel.add(tabbedPane, BorderLayout.CENTER);
        add(contentPanel, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        final String root = "/home/goe/projects/nextgen/components/core/src/main";

        SwingUtil.show(new STApp(STJsonFactory.newSTAppModel()
                .setGeneratorRoot(root + File.separator + "java")
                .setGeneratorPackage("nextgen.st")
                .setGeneratorName("StringTemplate")
                .addDirectories(load(root + File.separator + "resources" + File.separator + "templates"))));
    }

    public static STGDirectory load(String dir) {

        final STGDirectory root = STJsonFactory.newSTGDirectory()
                .setPath(new File(dir).getPath())
                .setOutputPackage("tmp.st")
                .setOutputPath("/home/goe/projects/nextgen/components/core/src/test/java/");

        Optional.ofNullable(list(dir, ".json"))
                .ifPresent(files -> {
                    for (File file : files) {
                        System.out.println("// todo: add a String-parameter constructor to remove JsonObject from this class");
                        root.addGroups(new STGroupModel(new JsonObject(STParser.read(file)))); // todo: add a String-parameter constructor to remove JsonObject from this class
                    }
                });

        return root;
    }

    public static File[] list(String dir, String postfix) {
        final String s = postfix.toLowerCase();
        return new File(dir).listFiles(pathname -> pathname.getAbsolutePath().toLowerCase().endsWith(s));
    }
}