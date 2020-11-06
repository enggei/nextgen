package tmp;

import nextgen.templates.vertx.*;

public class AppConfigGenerator {

	public static JsonWrapper generate(){ 
		return VertxST.newJsonWrapper().setPackage("nextgen.swing.config").setName("AppConfig").addAccessors(VertxST.newPrimitiveAccessors().setClassName("AppConfig").setName("title").setType("String")).addAccessors(VertxST.newPrimitiveAccessors().setClassName("AppConfig").setName("navigatorWidth").setType("Integer")).addAccessors(VertxST.newPrimitiveAccessors().setClassName("AppConfig").setName("appHeight").setType("Integer")).addAccessors(VertxST.newPrimitiveAccessors().setClassName("AppConfig").setName("appWidth").setType("Integer")).addAccessors(VertxST.newPrimitiveAccessors().setClassName("AppConfig").setName("navigatorHeight").setType("Integer")).addAccessors(VertxST.newPrimitiveAccessors().setClassName("AppConfig").setName("workspaceWidth").setType("Integer")).addAccessors(VertxST.newPrimitiveAccessors().setClassName("AppConfig").setName("workspaceHeight").setType("Integer")).addAccessors(VertxST.newPrimitiveAccessors().setClassName("AppConfig").setName("editorHeight").setType("Integer")).addAccessors(VertxST.newPrimitiveAccessors().setClassName("AppConfig").setName("editorWidth").setType("Integer")).addAccessors(VertxST.newPrimitiveAccessors().setClassName("AppConfig").setName("rootDir").setType("String")).addAccessors(VertxST.newPrimitiveAccessors().setClassName("AppConfig").setName("dbDir").setType("String")).addAccessors(VertxST.newPrimitiveAccessors().setClassName("AppConfig").setName("outputPackage").setType("String")).addAccessors(VertxST.newPrimitiveAccessors().setClassName("AppConfig").setName("outputPath").setType("String")).addAccessors(VertxST.newPrimitiveAccessors().setClassName("AppConfig").setName("templateDir").setType("String")).addAccessors(VertxST.newPrimitiveAccessors().setClassName("AppConfig").setName("fontName").setType("String")).addAccessors(VertxST.newPrimitiveAccessors().setClassName("AppConfig").setName("fontSize").setType("Integer"));
	}
}