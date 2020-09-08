package nextgen.projects;

import nextgen.templates.domain.*;
import nextgen.templates.DomainPatterns;



import java.io.File;

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
		final Entity stGroupModel = DomainPatterns.newEntity("STGroupModel")
				.addRelations(DomainPatterns.newStringField("name", true))
				.addRelations(DomainPatterns.newStringField("delimiter"))
				.addRelations(DomainPatterns.newStringField("icon"))
				.addRelations(DomainPatterns.newStringField("tags"))
				.addRelations(DomainPatterns.newOneToMany("templates", DomainPatterns.newEntity("STTemplate")
						.addRelations(DomainPatterns.newStringField("name", true))
						.addRelations(DomainPatterns.newStringField("text"))
						.addRelations(DomainPatterns.newOneToManyString("implements"))
						.addRelations(DomainPatterns.newOneToMany("parameters", DomainPatterns.newEntity("STParameter")
								.addRelations(DomainPatterns.newStringField("name", true))
								.addRelations(DomainPatterns.newEnumField("type", DomainPatterns.newEnum("STParameterType", "SINGLE,LIST,KVLIST")))
								.addRelations(DomainPatterns.newOneToMany("keys", DomainPatterns.newEntity("STParameterKey")
										.addRelations(DomainPatterns.newStringField("name"))
										.addRelations(DomainPatterns.newStringField("argumentType"))))
								.addRelations(DomainPatterns.newStringField("argumentType"))))
						.addRelations(DomainPatterns.newOneToManySelf("children"))))
				.addRelations(DomainPatterns.newOneToMany("interfaces", DomainPatterns.newEntity("STInterface")
						.addRelations(DomainPatterns.newStringField("name"))))
				.addRelations(DomainPatterns.newOneToMany("enums", DomainPatterns.newEntity("STEnum")
						.addRelations(DomainPatterns.newStringField("name", true))
						.addRelations(DomainPatterns.newOneToMany("values", DomainPatterns.newEntity("STEnumValue")
								.addRelations(DomainPatterns.newStringField("name", true))
								.addRelations(DomainPatterns.newStringField("lexical"))))));

		final Domain domain = DomainPatterns.newDomain("ST")
				.addEntities(DomainPatterns.newEntity("STAppModel")
						.addRelations(DomainPatterns.newStringField("modelDb"))
						.addRelations(DomainPatterns.newStringField("rootDir"))
						.addRelations(DomainPatterns.newIntegerField("editorFontSize"))
						.addRelations(DomainPatterns.newStringField("generatorRoot"))
						.addRelations(DomainPatterns.newStringField("generatorPackage"))
						.addRelations(DomainPatterns.newStringField("generatorName"))
						.addRelations(DomainPatterns.newOneToMany("directories", DomainPatterns.newEntity("STGDirectory")
								.addRelations(DomainPatterns.newStringField("path"))
								.addRelations(DomainPatterns.newStringField("outputPackage"))
								.addRelations(DomainPatterns.newStringField("outputPath"))
								.addRelations(DomainPatterns.newOneToMany("groups", stGroupModel)))))
				.addEntities(DomainPatterns.newEntity("STGParseResult")
						.addRelations(DomainPatterns.newOneToOne("parsed", stGroupModel))
						.addRelations(DomainPatterns.newOneToMany("errors", DomainPatterns.newEntity("STGError")
								.addRelations(DomainPatterns.newEnumField("type", DomainPatterns.newEnum("STGErrorType", "COMPILE,RUNTIME,IO,INTERNAL")))
								.addRelations(DomainPatterns.newStringField("message"))
								.addRelations(DomainPatterns.newIntegerField("line"))
								.addRelations(DomainPatterns.newIntegerField("charPosition")))));
		DomainPatterns.writeJsonWrapper(mainJava, stDomainPackage, domain);
	}

	/**
	 * generateSTModelDomain
	 * 
	 */
	@org.junit.Test
	public void generateSTModelDomain() {
		final Entity stValueNeo = DomainPatterns.newEntity("STValue")
				.setObservable(true)
				.addRelations(DomainPatterns.newStringField("uuid"))
				.addRelations(DomainPatterns.newStringField("value"))
				.addRelations(DomainPatterns.newEnumField("type", DomainPatterns.newEnum("STValueType", "STMODEL,PRIMITIVE,ENUM")));

		final Entity stFile = DomainPatterns.newEntity("STFile")
				.setObservable(true)
				.addRelations(DomainPatterns.newStringField("uuid"))
				.addRelations(DomainPatterns.newOneToOne("name", stValueNeo))
				.addRelations(DomainPatterns.newOneToOne("type", stValueNeo))
				.addRelations(DomainPatterns.newOneToOne("packageName", stValueNeo))
				.addRelations(DomainPatterns.newOneToOne("path", stValueNeo));

		final Entity stModelNeo = DomainPatterns.newEntity("STModel")
				.setObservable(true)
				.addRelations(DomainPatterns.newStringField("uuid"))
				.addRelations(DomainPatterns.newStringField("stGroup"))
				.addRelations(DomainPatterns.newStringField("stTemplate"))
				.addRelations(DomainPatterns.newOneToMany("files", stFile))
				.addRelations(DomainPatterns.newOneToMany("arguments", DomainPatterns.newEntity("STArgument")
						.setObservable(true)
						.addRelations(DomainPatterns.newStringField("uuid"))
						.addRelations(DomainPatterns.newStringField("stParameter"))
						.addRelations(DomainPatterns.newOneToOne("value", stValueNeo))
						.addRelations(DomainPatterns.newOneToMany("keyValues", DomainPatterns.newEntity("STArgumentKV")
								.setObservable(true)
								.addRelations(DomainPatterns.newStringField("uuid"))
								.addRelations(DomainPatterns.newStringField("stParameterKey"))
								.addRelations(DomainPatterns.newOneToOne("value", stValueNeo))))));

		stValueNeo.addRelations(DomainPatterns.newOneToOne("stModel", stModelNeo));

		final Entity script = DomainPatterns.newEntity("Script")
				.setObservable(true)
				.addRelations(DomainPatterns.newStringField("uuid"))
				.addRelations(DomainPatterns.newStringField("name"))
				.addRelations(DomainPatterns.newOneToOne("script", stValueNeo));

		final Entity project = DomainPatterns.newEntity("Project")
				.setObservable(true)
				.addRelations(DomainPatterns.newStringField("uuid"))
				.addRelations(DomainPatterns.newStringField("name"))
				.addRelations(DomainPatterns.newOneToMany("files", stFile))
				.addRelations(DomainPatterns.newOneToMany("models", stModelNeo))
				.addRelations(DomainPatterns.newOneToMany("values", stValueNeo))
				.addRelations(DomainPatterns.newOneToMany("scripts", script));

		final Domain domain = DomainPatterns.newDomain("STModel")
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