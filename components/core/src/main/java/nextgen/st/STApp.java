package nextgen.st;

import com.generator.util.SwingUtil;
import io.vertx.core.json.JsonObject;
import nextgen.st.domain.STGDirectory;
import nextgen.st.domain.STGroupModel;
import nextgen.st.domain.STJsonFactory;
import org.stringtemplate.v4.STGroupFile;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
        final STGDirectory stgDirectory = load("/home/goe/projects/nextgen/components/core/src/main/resources/templates");


        stgDirectory.getGroups().filter(stGroupModel -> stGroupModel.getName().equals("StringTemplate")).findFirst().ifPresent(stGroupModel -> {

            final STGenerator stGenerator = new STGenerator(new STGroupFile("/home/goe/projects/nextgen/components/core/src/test/java/tmp/st/stringtemplate/StringTemplate.stg", '~', '~'));
            stGenerator.generateSTGroup(stGroupModel, "tmp.st.stringtemplate2", "/home/goe/projects/nextgen/components/core/src/test/java/");

        });

        SwingUtil.show(new STApp(stgDirectory));
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
                        root.addGroups(new STGroupModel(new JsonObject(read(file)))); // todo: add a String-parameter constructor to remove JsonObject from this class
                    }
                });

        return root;
    }

    public static File[] list(String dir, String postfix) {
        final String s = postfix.toLowerCase();
        return new File(dir).listFiles(pathname -> pathname.getAbsolutePath().toLowerCase().endsWith(s));
    }

    public static String read(File file) {
        if (!file.exists()) return "";
        try {
            final StringBuilder content = new StringBuilder();
            final BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) content.append(line);
            in.close();
            return content.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return "ERROR: " + e.getMessage();
        }
    }
}