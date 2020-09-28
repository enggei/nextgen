package nextgen.st;

import nextgen.st.domain.STAppModel;
import nextgen.st.domain.STGDirectory;
import nextgen.st.domain.STGroupModel;
import nextgen.st.domain.STJsonFactory;
import nextgen.utils.SwingUtil;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.Optional;

import static nextgen.st.STParser.readJsonObject;
import static nextgen.st.domain.STJsonFactory.newSTGDirectory;

public class STApp extends JFrame {

   final STAppPresentationModel presentationModel;
   final STTemplateNavigator navigator;
   final STModelNavigator stModelNavigator;
   final STWorkspace workspace;

   public STApp(STAppModel appModel) throws HeadlessException, IOException {
      super("ST Editor");

      presentationModel = new STAppPresentationModel(appModel);

      workspace = presentationModel.getWorkspace();
      navigator = new STTemplateNavigator(presentationModel, workspace);
      stModelNavigator = new STModelNavigator(presentationModel, workspace);

      final JPanel contentPanel = new JPanel(new BorderLayout());
      contentPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
      contentPanel.add(navigator, BorderLayout.WEST);
      contentPanel.add(workspace, BorderLayout.CENTER);
      contentPanel.add(stModelNavigator, BorderLayout.EAST);
      contentPanel.setSize(new Dimension(1600, 1200));
      add(contentPanel, BorderLayout.CENTER);

      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

   public static void main(String[] args) throws IOException {

      final File root = new File("./components/core");
      final File srcMain = new File(root, "src/main");
      final File srcTest = new File(root, "src/test");
      final File javaMain = new File(srcMain, "java");
      final File javaTest = new File(srcTest, "java");
      final File resources = new File(srcMain, "resources");
      final File templates = new File(resources, "templates");

      STAppModel config = loadConfig("appconfig.json", STJsonFactory.newSTAppModel()
                                                                    .setModelDb("./db")
                                                                    .setEditorFontSize(24)
                                                                    .setRootDir(javaMain.getAbsolutePath()));

      com.formdev.flatlaf.FlatDarculaLaf.install();
      //SwingUtil.printSwingDefaults(System.out);
      UIManager.put("Tree.font", new Font("InputMono", Font.PLAIN, config.getEditorFontSize()));
      UIManager.put("TextField.font", new Font("InputMono", Font.PLAIN, UIManager.getFont("Tree.font").getSize()));
      UIManager.put("TextArea.font", new Font("InputMono", Font.PLAIN, UIManager.getFont("Tree.font").getSize()));

      SwingUtil.show(new STApp(config.addDirectories(load(templates, javaMain, "nextgen.templates"))));
   }

   public static STGDirectory load(File path, File outputRoot, String outputPackage) {

      final STGDirectory root = newSTGDirectory()
            .setPath(path.getAbsolutePath())
            .setOutputPackage(outputPackage)
            .setOutputPath(outputRoot.getAbsolutePath());

      Optional.ofNullable(list(path, ".json"))
              .ifPresent(files -> {
                 for (File file : files) root.addGroups(new STGroupModel(readJsonObject(file)));
              });

      return root;
   }

   public static File[] list(File dir, String postfix) {
      final String s = postfix.toLowerCase();
      return dir.listFiles(pathname -> pathname.getAbsolutePath().toLowerCase().endsWith(s));
   }

   public static STAppModel loadConfig(String configFile, STAppModel defaultConfig) {
      final ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
      final URL url = classLoader.getResource(configFile);
      assert url != null;

      File file = new File(URI.create(url.toString()));

      try {
         return STJsonFactory.merge(defaultConfig, STJsonFactory.newSTAppModel(file));
      } catch (IOException ioE) {
         System.err.println("Could not load partial config from '" + configFile + "': " + ioE.getMessage());
      }

      return defaultConfig;
   }
}