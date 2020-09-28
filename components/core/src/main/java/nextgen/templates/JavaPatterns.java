package nextgen.templates;

import nextgen.templates.java.*;

public class JavaPatterns extends JavaST {

   public static PackageDeclaration newPackageDeclaration(String packageName) {
      return newPackageDeclaration().setName(packageName);
   }

   public static PackageDeclaration newPackageDeclaration(PackageDeclaration parent, String packageName) {
      return newPackageDeclaration().setName(parent.getName() + "." + packageName);
   }

   public static ImportDeclaration newImportDeclaration(String name) {
      return newImportDeclaration().setName(name);
   }
}