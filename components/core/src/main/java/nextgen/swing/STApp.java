package nextgen.swing;

import nextgen.st.STAppPresentationModel;
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
   final STWorkspace workspace;

   public STApp(AppModel appModel) throws HeadlessException {
      super("ST Editor");

      presentationModel = appModel.getSTAppPresentationModel();

      workspace = presentationModel.getWorkspace();

      final JPanel contentPanel = new JPanel(new BorderLayout());
      contentPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
      contentPanel.add(workspace.getTemplateNavigator(), BorderLayout.WEST);

      final JSplitPane splitPane = new javax.swing.JSplitPane(javax.swing.JSplitPane.HORIZONTAL_SPLIT, workspace, workspace.getModelNavigator());

      contentPanel.add(splitPane, BorderLayout.CENTER);
//      contentPanel.add(workspace, BorderLayout.CENTER);
//      contentPanel.add(workspace.getModelNavigator(), BorderLayout.EAST);
//      contentPanel.setSize(new Dimension(2400, 1200));
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

   public static AppModel loadConfig(String[] args) throws IOException {

      final AppConfig appConfig = args.length == 0 ? AppConfigJsonFactory.newAppConfig() : AppConfigJsonFactory.newAppConfig(new File(args[0]));
      final String root = "/home/goe/projects/nextgen/components/core";

      AppModel
            .getInstance()
            .setFontSize(appConfig.getFontSize(24))
            .setFontName(appConfig.getFontName("InputMono"))
            .setAppSize(new Dimension(appConfig.getAppWidth(2400), appConfig.getAppHeight(1200)))
            .setNavigatorSize(new Dimension(appConfig.getNavigatorWidth(400), appConfig.getNavigatorHeight(1200)))
            .setWorkspaceSize(new Dimension(appConfig.getWorkspaceWidth(1200), appConfig.getWorkspaceHeight(1200)))
            .setOutputPackage(appConfig.getOutputPackage("nextgen.templates"))
            .setOutputPath(appConfig.getOutputPath(new File(root, "src/main/java").getAbsolutePath()))
            .setTemplateDir(appConfig.getTemplateDir(new File(root, "src/main/resources/templates").getAbsolutePath()))
            .setDbDir(appConfig.getDbDir("./db"))
            .setRootDir(appConfig.getRootDir("."))
            .setTitle(appConfig.getTitle("STApp"));

      return AppModel
            .getInstance()
            .setSTAppPresentationModel(new STAppPresentationModel());
   }
}