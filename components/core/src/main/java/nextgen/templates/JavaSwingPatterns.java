package nextgen.templates;

import nextgen.templates.java.PackageDeclaration;
import nextgen.templates.javaswing.*;

public class JavaSwingPatterns extends JavaSwingST {

   public static TreeNode newTreeNode(PackageDeclaration packageDeclaration, BaseTreeNode baseTreeNode) {
      return newTreeNode()
            .setPackageName(packageDeclaration.getName())
            .setBaseTreeNode(baseTreeNode.getName());
   }

   public static EntityAction newEntityAction(PackageDeclaration packageDeclaration, String name, String appModelType) {
      return newEntityAction()
            .setPackageName(packageDeclaration.getName())
            .setName(name)
            .setAppModelType(appModelType);
   }

   public static JPanel newJPanel(String name) {
      return newJPanel()
            .setName(name);
   }
}