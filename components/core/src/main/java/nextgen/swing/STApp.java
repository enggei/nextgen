package nextgen.swing;

import nextgen.st.STAppPresentationModel;
import nextgen.st.STModelNavigator;
import nextgen.st.STTemplateNavigator;
import nextgen.st.STWorkspace;
import nextgen.swing.config.AppConfig;
import nextgen.swing.config.AppConfigJsonFactory;
import nextgen.utils.SwingUtil;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class STApp extends JFrame {

   final STAppPresentationModel presentationModel;
   final STTemplateNavigator navigator;
   final STModelNavigator stModelNavigator;
   final STWorkspace workspace;

   public STApp(AppModel appModel) throws HeadlessException {
      super("ST Editor");

      presentationModel = appModel.getSTAppPresentationModel();

      workspace = presentationModel.getWorkspace();
      navigator = new STTemplateNavigator(workspace);
      stModelNavigator = new STModelNavigator(workspace);

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

      final AppModel config = loadConfig(args);

      com.formdev.flatlaf.FlatDarculaLaf.install();

      final Font font = new Font(config.getFontName(), Font.PLAIN, config.getFontSize());
      //UIManager.put("Tree.font", font);
      UIManager.put("TextField.font", font);
      UIManager.put("TextArea.font", font);

      SwingUtil.show(new STApp(config));
   }

   private static AppModel loadConfig(String[] args) throws IOException {

      final AppConfig appConfig = args.length == 0 ? AppConfigJsonFactory.newAppConfig() : AppConfigJsonFactory.newAppConfig(new File(args[0]));
      final String root = "/home/goe/projects/nextgen/components/core";

      AppModel.getInstance()
            .setFontSize(appConfig.getFontSize(24))
            .setFontName(appConfig.getFontName("InputMono"))
            .setAppSize(new Dimension(appConfig.getAppWidth(1600), appConfig.getAppHeight(1200)))
            .setNavigatorSize(new Dimension(appConfig.getNavigatorWidth(400), appConfig.getNavigatorHeight(1200)))
            .setWorkspaceSize(new Dimension(appConfig.getWorkspaceWidth(1200), appConfig.getWorkspaceHeight(1200)))
            .setOutputPackage(appConfig.getOutputPackage("nextgen.templates"))
            .setOutputPath(appConfig.getOutputPath(new File(root, "src/main/java").getAbsolutePath()))
            .setTemplateDir(appConfig.getTemplateDir(new File(root, "src/main/resources/templates").getAbsolutePath()))
            .setDbDir(appConfig.getDbDir("./db"))
            .setRootDir(appConfig.getRootDir("."))
            .setTitle(appConfig.getTitle("STApp"));

      return AppModel.getInstance().setSTAppPresentationModel(new STAppPresentationModel());
   }
}