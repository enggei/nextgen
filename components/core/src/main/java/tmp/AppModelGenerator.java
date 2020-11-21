package tmp;

import nextgen.templates.java.*;

public class AppModelGenerator {

	public static Singleton generate(){ 
		return JavaST.newSingleton().setPackageName("nextgen.swing").setName("AppModel").addFields("String", "title", null).addFields("java.awt.Dimension", "appSize", null).addFields("java.awt.Dimension", "navigatorSize", null).addFields("java.awt.Dimension", "workspaceSize", null).addFields("String", "rootDir", null).addFields("String", "dbDir", null).addFields("String", "outputPackage", null).addFields("String", "outputPath", null).addFields("String", "templateDir", null).addFields("String", "stDelimiter", null).addFields("Integer", "fontSize", null).addFields("String", "fontName", null).addFields("javax.swing.JFrame", "frame", null).addFields("nextgen.swing.STAppPresentationModel", "sTAppPresentationModel", null);
	}
}