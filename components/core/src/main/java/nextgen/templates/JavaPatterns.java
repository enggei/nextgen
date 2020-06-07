package nextgen.templates;

import nextgen.templates.java.JavaST;
import nextgen.templates.java.PackageDeclaration;

public class JavaPatterns extends JavaST {


    public static PackageDeclaration newPackageDeclaration(String packageName) {
        return newPackageDeclaration().setName(packageName);
    }

    public static PackageDeclaration newPackageDeclaration(PackageDeclaration parent, String packageName) {
        return newPackageDeclaration().setName(parent.getName() + "." + packageName);
    }
}