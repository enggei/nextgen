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

   private final javax.swing.JSplitPane west;
   private final javax.swing.JSplitPane center;

   public STApp() throws HeadlessException {
      super("ST Editor");

      workspace = AppModel.getInstance().getSTAppPresentationModel().db.getInTransaction(transaction -> new STWorkspace(this));
      AppModel.getInstance().setWorkspace(workspace);

      west = new javax.swing.JSplitPane(javax.swing.JSplitPane.HORIZONTAL_SPLIT, workspace.getTemplateNavigator(), workspace);
      center = new javax.swing.JSplitPane(javax.swing.JSplitPane.HORIZONTAL_SPLIT, west, workspace.getModelNavigator());
      add(center, BorderLayout.CENTER);

      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

   public void maximizeCenter() {
      SwingUtilities.invokeLater(() -> {
         west.setDividerLocation(0.1);
         center.setDividerLocation(0.9);
      });
   }

   public void normalizeSplits() {
      SwingUtilities.invokeLater(() -> {
         west.setDividerLocation(0.2);
         center.setDividerLocation(0.8);
      });
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
            .setDbDir(appConfig.getDbDir("/home/goe/dbs/db"))
            .setRootDir(appConfig.getRootDir("."))
            .setTitle(appConfig.getTitle("STApp"));

      return AppModel
            .getInstance()
            .setSTAppPresentationModel(new STAppPresentationModel());
   }
}