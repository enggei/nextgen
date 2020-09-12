package nextgen.projects;

import nextgen.st.STGenerator;
import static nextgen.utils.StringUtil.*;

import nextgen.templates.domain.*;
import nextgen.templates.DomainPatterns;

import nextgen.templates.nextgen.*;
import nextgen.templates.NextgenPatterns;

import nextgen.templates.maven.*;
import nextgen.templates.MavenPatterns;


import java.util.*;
import java.io.*;

public class NextgenProject {

	final File root = new File("/home/goe/projects/nextgen/components/core");

	final File mainJava = new File(root, "src/main/java");
	final File mainResources = new File(root, "src/main/resources");
	final File testJava = new File(root, "src/test/java");
	final File testResources = new File(root, "src/test/resources");


	private final nextgen.templates.java.PackageDeclaration corePackage = nextgen.templates.JavaPatterns.newPackageDeclaration("nextgen");
	private final nextgen.templates.java.PackageDeclaration metaDomainPackage = nextgen.templates.JavaPatterns.newPackageDeclaration(corePackage.getName() + "." + "domains.meta");
	private final nextgen.templates.java.PackageDeclaration stDomainPackage = nextgen.templates.JavaPatterns.newPackageDeclaration(corePackage.getName() + "." + "st.domain");
	private final nextgen.templates.java.PackageDeclaration stModelPackage = nextgen.templates.JavaPatterns.newPackageDeclaration(corePackage.getName() + "." + "st.model");
	private final nextgen.templates.java.PackageDeclaration canvasLayoutPackage = nextgen.templates.JavaPatterns.newPackageDeclaration(corePackage.getName() + "." + "st.canvas.layout");


	/**
	 * generateMetaDomain
	 * 
	 */
	@org.junit.Test
	public void generateMetaDomain() {
		// meta
		final Entity metaProperty = DomainPatterns.newEntity("MetaProperty")
				.addRelations(DomainPatterns.newStringField("uuid"))
				.addRelations(DomainPatterns.newStringField("name"))
				.addRelations(DomainPatterns.newStringField("type"))
				.addRelations(DomainPatterns.newStringField("defaultValue"));

		final Entity metaEntity = DomainPatterns.newEntity("MetaEntity")
				.addRelations(DomainPatterns.newStringField("uuid"))
				.addRelations(DomainPatterns.newStringField("name"))
				.addRelations(DomainPatterns.newOneToMany("properties", metaProperty));

		final Entity metaRelation = DomainPatterns.newEntity("MetaRelation")
				.addRelations(DomainPatterns.newStringField("uuid"))
				.addRelations(DomainPatterns.newStringField("name"))
				.addRelations(DomainPatterns.newEnumField("cardinality", "Cardinality", "ONE_TO_ONE,ONE_TO_MANY"))
				.addRelations(DomainPatterns.newOneToMany("dst", metaEntity))
				.addRelations(DomainPatterns.newOneToMany("properties", metaProperty));

		metaEntity.addRelations(DomainPatterns.newOneToMany("relations", metaRelation));

		final Entity domainVisitor = DomainPatterns.newEntity("DomainVisitor")
				.addRelations(DomainPatterns.newStringField("uuid"))
				.addRelations(DomainPatterns.newStringField("name"))
				.addRelations(DomainPatterns.newStringField("initStatements"))
				.addRelations(DomainPatterns.newStringField("endStatements"))
				.addRelations(DomainPatterns.newOneToMany("fields", DomainPatterns.newEntity("VisitorField")
						.addRelations(DomainPatterns.newStringField("uuid"))
						.addRelations(DomainPatterns.newStringField("name"))
						.addRelations(DomainPatterns.newStringField("type"))))
				.addRelations(DomainPatterns.newOneToMany("entityVisitors", DomainPatterns.newEntity("EntityVisitorMethod")
						.addRelations(DomainPatterns.newStringField("uuid"))
						.addRelations(DomainPatterns.newRef("_meta", metaEntity))
						.addRelations(DomainPatterns.newStringField("statements"))))
				.addRelations(DomainPatterns.newOneToMany("relationVisitors", DomainPatterns.newEntity("RelationVisitorMethod")
						.addRelations(DomainPatterns.newStringField("uuid"))
						.addRelations(DomainPatterns.newRef("_meta", metaRelation))
						.addRelations(DomainPatterns.newStringField("statements"))));

		final Entity metaDomain = DomainPatterns.newEntity("MetaDomain")
				.addRelations(DomainPatterns.newStringField("uuid"))
				.addRelations(DomainPatterns.newStringField("name"))
				.addRelations(DomainPatterns.newOneToMany("roots", metaEntity))
				.addRelations(DomainPatterns.newOneToMany("properties", metaProperty))
				.addRelations(DomainPatterns.newOneToMany("visitors", domainVisitor));

		// models
		final Entity domainEntity = DomainPatterns.newEntity("DomainEntity")
				.addRelations(DomainPatterns.newStringField("uuid"))
				.addRelations(DomainPatterns.newRef("_meta", metaEntity));

		final Domain domain = DomainPatterns.newDomain("MetaDomain")
				.addEntities(metaDomain)
				.addEntities(domainEntity)
				.addEntities(domainVisitor);
		DomainPatterns.writeNeo(mainJava, metaDomainPackage, domain);
	}

	/**
	 * generateSTTemplateDomain
	 * 
	 */
	@org.junit.Test
	public void generateSTTemplateDomain() {
	}

	/**
	 * generateSTModelDomain
	 * 
	 */
	@org.junit.Test
	public void generateSTModelDomain() {
		final Entity stParameterKey = DomainPatterns.newEntity("STParameterKey")
				.addRelations(DomainPatterns.newStringField("uuid"))
				.addRelations(DomainPatterns.newStringField("name"))
				.addRelations(DomainPatterns.newStringField("argumentType"));

		final Entity stParameter = DomainPatterns.newEntity("STParameter")
				.addRelations(DomainPatterns.newStringField("uuid"))
				.addRelations(DomainPatterns.newStringField("name", true))
				.addRelations(DomainPatterns.newEnumField("type", DomainPatterns.newEnum("STParameterType", "SINGLE,LIST,KVLIST")))
				.addRelations(DomainPatterns.newOneToMany("keys", stParameterKey))
				.addRelations(DomainPatterns.newStringField("argumentType"));

		final Entity stTemplate = DomainPatterns.newEntity("STTemplate")
				.addRelations(DomainPatterns.newStringField("uuid"))
				.addRelations(DomainPatterns.newStringField("name", true))
				.addRelations(DomainPatterns.newStringField("text"))
				.addRelations(DomainPatterns.newOneToManyString("implements"))
				.addRelations(DomainPatterns.newOneToMany("parameters", stParameter))
				.addRelations(DomainPatterns.newOneToManySelf("children"));

		final Entity stInterface = DomainPatterns.newEntity("STInterface")
				.addRelations(DomainPatterns.newStringField("uuid"))
				.addRelations(DomainPatterns.newStringField("name"));

		final Entity stEnumValue = DomainPatterns.newEntity("STEnumValue")
				.addRelations(DomainPatterns.newStringField("uuid"))
				.addRelations(DomainPatterns.newStringField("name", true))
				.addRelations(DomainPatterns.newStringField("lexical"));

		final Entity stEnum = DomainPatterns.newEntity("STEnum")
				.addRelations(DomainPatterns.newStringField("uuid"))
				.addRelations(DomainPatterns.newStringField("name", true))
				.addRelations(DomainPatterns.newOneToMany("values", stEnumValue));

		final Entity stGroupModel = DomainPatterns.newEntity("STGroupModel")
				.addRelations(DomainPatterns.newStringField("name", true))
				.addRelations(DomainPatterns.newStringField("uuid"))
				.addRelations(DomainPatterns.newStringField("delimiter"))
				.addRelations(DomainPatterns.newStringField("icon"))
				.addRelations(DomainPatterns.newStringField("tags"))
				.addRelations(DomainPatterns.newOneToMany("templates", stTemplate))
				.addRelations(DomainPatterns.newOneToMany("interfaces", stInterface))
				.addRelations(DomainPatterns.newOneToMany("enums", stEnum));

		final Entity stValue = DomainPatterns.newEntity("STValue")
				.setObservable(true)
				.addRelations(DomainPatterns.newStringField("uuid"))
				.addRelations(DomainPatterns.newStringField("value"))
				.addRelations(DomainPatterns.newEnumField("type", DomainPatterns.newEnum("STValueType", "STMODEL,PRIMITIVE,ENUM")));

		final Entity stFile = DomainPatterns.newEntity("STFile")
				.setObservable(true)
				.addRelations(DomainPatterns.newStringField("uuid"))
				.addRelations(DomainPatterns.newOneToOne("name", stValue))
				.addRelations(DomainPatterns.newOneToOne("type", stValue))
				.addRelations(DomainPatterns.newOneToOne("packageName", stValue))
				.addRelations(DomainPatterns.newOneToOne("path", stValue));

		final Entity stArgumentKV = DomainPatterns.newEntity("STArgumentKV")
				.setObservable(true)
				.addRelations(DomainPatterns.newStringField("uuid"))
				.addRelations(DomainPatterns.newOneToOne("stParameterKey", stParameterKey))
				.addRelations(DomainPatterns.newOneToOne("value", stValue));

		final Entity stArgument = DomainPatterns.newEntity("STArgument")
				.setObservable(true)
				.addRelations(DomainPatterns.newStringField("uuid"))
				.addRelations(DomainPatterns.newOneToOne("stParameter", stParameter))
				.addRelations(DomainPatterns.newOneToOne("value", stValue))
				.addRelations(DomainPatterns.newOneToMany("keyValues", stArgumentKV));

		final Entity stModelNeo = DomainPatterns.newEntity("STModel")
				.setObservable(true)
				.addRelations(DomainPatterns.newStringField("uuid"))
				.addRelations(DomainPatterns.newOneToOne("stTemplate", stTemplate))
				.addRelations(DomainPatterns.newOneToMany("files", stFile))
				.addRelations(DomainPatterns.newOneToMany("arguments", stArgument));

		stValue.addRelations(DomainPatterns.newOneToOne("stModel", stModelNeo));

		final Entity script = DomainPatterns.newEntity("Script")
				.setObservable(true)
				.addRelations(DomainPatterns.newStringField("uuid"))
				.addRelations(DomainPatterns.newStringField("name"))
				.addRelations(DomainPatterns.newOneToOne("script", stValue));

		final Entity project = DomainPatterns.newEntity("Project")
				.setObservable(true)
				.addRelations(DomainPatterns.newStringField("uuid"))
				.addRelations(DomainPatterns.newStringField("name"))
				.addRelations(DomainPatterns.newOneToMany("files", stFile))
				.addRelations(DomainPatterns.newOneToMany("models", stModelNeo))
				.addRelations(DomainPatterns.newOneToMany("values", stValue))
				.addRelations(DomainPatterns.newOneToMany("scripts", script));

		final Domain domain = DomainPatterns.newDomain("STModel")
				.addEntities(stGroupModel)
				.addEntities(stModelNeo)
				.addEntities(script)
				.addEntities(project);
		DomainPatterns.writeNeo(mainJava, stModelPackage, domain);
	}

	/**
	 * generateCanvasLayoutDomain
	 * 
	 */
	@org.junit.Test
	public void generateCanvasLayoutDomain() {
		final Entity layoutDomain = DomainPatterns.newEntity("Layout")
				.addRelations(DomainPatterns.newStringField("uuid"))
				.addRelations(DomainPatterns.newStringField("name"))
				.addRelations(DomainPatterns.newOneToMany("nodes", DomainPatterns.newEntity("LayoutNode")
						.addRelations(DomainPatterns.newStringField("uuid"))
						.addRelations(DomainPatterns.newDoubleField("x"))
						.addRelations(DomainPatterns.newDoubleField("y"))));

		final Domain domain = DomainPatterns.newDomain("Layout")
				.addEntities(layoutDomain);
		DomainPatterns.writeNeo(mainJava, canvasLayoutPackage, domain);
	}

	/**
	 * generateAppEvents
	 * 
	 */
	@org.junit.Test
	public void generateAppEvents() {
		final AppEvents appEvents = NextgenST.newAppEvents()
				.setPackageName("nextgen.st")
				.setName("STAppEvents")
				.addEvents(NextgenST.newAppEvent()
						.setName("NewMetaDomain")
						.addFields("nextgen.domains.meta.MetaDomain", "metaDomain"))
				.addEvents(NextgenST.newAppEvent()
						.setName("NewMetaEntity")
						.addFields("nextgen.domains.meta.MetaEntity", "metaEntity"))
				.addEvents(NextgenST.newAppEvent()
						.setName("NewMetaProperty")
						.addFields("nextgen.domains.meta.MetaProperty", "metaProperty"))
				.addEvents(NextgenST.newAppEvent()
						.setName("NewMetaRelation")
						.addFields("nextgen.domains.meta.MetaRelation", "metaRelation"))
				.addEvents(NextgenST.newAppEvent()
						.setName("CanvasSTModelClicked")
						.addFields("nextgen.st.model.STModel", "stModel"))
				.addEvents(NextgenST.newAppEvent()
						.setName("STModelUpdated")
						.addFields("nextgen.st.model.STModel", "stModel"))
				.addEvents(NextgenST.newAppEvent()
						.setName("NewDomainEntity")
						.addFields("nextgen.domains.meta.DomainEntity", "domainEntity"))
				.addEvents(NextgenST.newAppEvent()
						.setName("OpenMetaDomain")
						.addFields("nextgen.domains.meta.MetaDomain", "metaDomain"))
				.addEvents(NextgenST.newAppEvent()
						.setName("OpenMetaEntity")
						.addFields("nextgen.domains.meta.MetaEntity", "metaEntity"))
				.addEvents(NextgenST.newAppEvent()
						.setName("OpenMetaProperty")
						.addFields("nextgen.domains.meta.MetaProperty", "metaProperty"))
				.addEvents(NextgenST.newAppEvent()
						.setName("OpenMetaRelation")
						.addFields("nextgen.domains.meta.MetaRelation", "metaRelation"))
				.addEvents(NextgenST.newNewOpenRemovedEvents()
						.setName("DomainVisitor")
						.setType("nextgen.domains.meta.DomainVisitor"))
				.addEvents(NextgenST.newNewOpenRemovedEvents().setName("Project").setType("nextgen.st.model.Project"))
				.addEvents(NextgenST.newNewOpenRemovedEvents().setName("STModel").setType("nextgen.st.model.STModel"))
				.addEvents(NextgenST.newNewOpenRemovedEvents().setName("STValue").setType("nextgen.st.model.STValue"))
				.addEvents(NextgenST.newNewOpenRemovedEvents().setName("Script").setType("nextgen.st.model.Script"))
				.addEvents(NextgenST.newNewOpenRemovedEvents()
						.setName("STTemplate")
						.setType("nextgen.st.domain.STTemplate"))
				.addEvents(NextgenST.newAppEvent()
						.setName("STModelTreeNodeClicked")
						.addFields("nextgen.st.model.STModel", "stModel"));

		STGenerator.writeJavaFile(appEvents, appEvents.getPackageName().toString(), appEvents.getName().toString(), mainJava);
	}

	/**
	 * generateProjectFiles
	 * 
	 */
	@org.junit.Test
	public void generateProjectFiles() {
		Pom projectPom = MavenST.newPom().setParent("<parent>\n" +
				"	<artifactId>components</artifactId>\n" +
				"	<groupId>com.nextgen</groupId>\n" +
				"	<version>1.0</version>\n" +
				"</parent>").setName("Core").setArtifactId("core").addDependencies("<dependency>\n" +
				"	<groupId>com.fifesoft</groupId>\n" +
				"	<artifactId>rsyntaxtextarea</artifactId>\n" +
				"	<version>3.0.3</version>\n" +
				"</dependency>").addDependencies("<dependency>\n" +
				"	<groupId>com.formdev</groupId>\n" +
				"	<artifactId>flatlaf</artifactId>\n" +
				"	<version>0.40</version>\n" +
				"</dependency>").addDependencies("<dependency>\n" +
				"	<groupId>org.neo4j</groupId>\n" +
				"	<artifactId>neo4j</artifactId>\n" +
				"	<version>${neo4j.version}</version>\n" +
				"</dependency>").addDependencies("<dependency>\n" +
				"	<groupId>org.antlr</groupId>\n" +
				"	<artifactId>antlr4</artifactId>\n" +
				"	<version>${antlr.version}</version>\n" +
				"</dependency>").addDependencies("<dependency>\n" +
				"	<groupId>com.jgoodies</groupId>\n" +
				"	<artifactId>jgoodies-forms</artifactId>\n" +
				"	<version>${jgoodies.version}</version>\n" +
				"</dependency>").addDependencies("<dependency>\n" +
				"	<groupId>org.piccolo2d</groupId>\n" +
				"	<artifactId>piccolo2d-core</artifactId>\n" +
				"	<version>${piccolo2d.version}</version>\n" +
				"</dependency>").addDependencies("<dependency>\n" +
				"	<groupId>org.piccolo2d</groupId>\n" +
				"	<artifactId>piccolo2d-extras</artifactId>\n" +
				"	<version>${piccolo2d.version}</version>\n" +
				"</dependency>").addDependencies("<dependency>\n" +
				"	<groupId>org.abego.treelayout</groupId>\n" +
				"	<artifactId>org.abego.treelayout.core</artifactId>\n" +
				"	<version>1.0.3</version>\n" +
				"</dependency>").addDependencies("<dependency>\n" +
				"	<groupId>io.vertx</groupId>\n" +
				"	<artifactId>vertx-core</artifactId>\n" +
				"	<version>${vertx.version}</version>\n" +
				"</dependency>").addDependencies("<dependency>\n" +
				"	<groupId>org.jsoup</groupId>\n" +
				"	<artifactId>jsoup</artifactId>\n" +
				"	<version>1.12.1</version>\n" +
				"</dependency>").addDependencies("<dependency>\n" +
				"	<groupId>com.github.kklisura.cdt</groupId>\n" +
				"	<artifactId>cdt-java-client</artifactId>\n" +
				"	<version>2.1.0</version>\n" +
				"</dependency>").addDependencies("<dependency>\n" +
				"	<groupId>net.openhft</groupId>\n" +
				"	<artifactId>compiler</artifactId>\n" +
				"	<version>2.3.1</version>\n" +
				"</dependency>").addDependencies("<dependency>\n" +
				"	<groupId>junit</groupId>\n" +
				"	<artifactId>junit</artifactId>\n" +
				"	<version>${junit.version}</version>\n" +
				"</dependency>").addDependencies("<dependency>\n" +
				"	<groupId>org.javatuples</groupId>\n" +
				"	<artifactId>javatuples</artifactId>\n" +
				"	<version>1.2</version>\n" +
				"</dependency>");

		MavenPatterns.generate(MavenPatterns.newProject()
			.setName("Nextgen")
			.setRoot(root.getAbsolutePath()), projectPom);
	}

	/**
	 * test2
	 * 
	 */
	@org.junit.Test
	public void test2() {
	}


	protected static void log(Object log) {
		System.out.println(log);
	}

	class JavaType {

		final nextgen.templates.java.ClassOrInterfaceType type;

		JavaType(String packageDeclaration, String name) {
			this.type = nextgen.templates.java.JavaST.newClassOrInterfaceType()
					.setScope(packageDeclaration)
					.addNames(name);
		}

		JavaType(nextgen.templates.java.PackageDeclaration packageDeclaration, String name) {
			this(packageDeclaration.getName(), name);
		}
	}
}