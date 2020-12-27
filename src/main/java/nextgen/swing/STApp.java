package nextgen.swing;

import com.github.weisj.darklaf.LafManager;
import com.github.weisj.darklaf.theme.DarculaTheme;
import nextgen.utils.SwingUtil;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class STApp extends JFrame {

   final STWorkspace workspace;

   public STApp() throws HeadlessException {
      super("ST Editor");

      workspace = AppModel.getInstance().getSTAppPresentationModel().db.getInTransaction(transaction -> new STWorkspace());
      AppModel.getInstance().setWorkspace(workspace);

      final JSplitPane west = new javax.swing.JSplitPane(javax.swing.JSplitPane.HORIZONTAL_SPLIT, workspace.getTemplateNavigator(), workspace);
      final JSplitPane center = new javax.swing.JSplitPane(javax.swing.JSplitPane.HORIZONTAL_SPLIT, west, workspace.getModelNavigator());
      add(center, BorderLayout.CENTER);

      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

   public static void main(String[] args) throws IOException {

      loadConfig(args);

      ComponentFactory.applyLaf();

      org.fife.ui.rsyntaxtextarea.RSyntaxTextArea.setTemplatesEnabled(true);

      SwingUtil.show(new STApp());
   }

   public static AppModel loadConfig(String[] args) throws IOException {

      final AppConfig appConfig = args.length == 0 ? new nextgen.swing.AppConfig() : new nextgen.swing.AppConfig(new File(args[0]));
      final String root = ".";

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