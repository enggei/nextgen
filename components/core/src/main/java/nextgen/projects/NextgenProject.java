package nextgen.projects;

import nextgen.templates.DomainPatterns;
import nextgen.templates.domain.Domain;
import nextgen.templates.domain.Entity;
import org.junit.Test;

import static nextgen.templates.DomainPatterns.*;

public class NextgenProject {

   final java.io.File root = new java.io.File("/home/goe/projects/nextgen/components/core");

   final java.io.File mainJava = new java.io.File(root, "src/main/java");
   final java.io.File mainResources = new java.io.File(root, "src/main/resources");
   final java.io.File testJava = new java.io.File(root, "src/test/java");
   final java.io.File testResources = new java.io.File(root, "src/test/resources");

   protected static void log(Object log) {
      System.out.println(log);
   }

   @Test
   public void generateMetaDomain() {
      DomainPatterns.writeNeo(mainJava, "nextgen.domains.meta", metaDomain());
   }

   @Test
   public void generateSTTemplateDomain() {
      writeJsonWrapper(mainJava, "nextgen.st.domain", stTemplateDomain());
   }

   @Test
   public void generateSTModelDomain() {
      writeNeo(mainJava, "nextgen.st.model", stModelDomain());
   }

   @Test
   public void generateCanvasLayoutDomain() {
      writeNeo(mainJava, "nextgen.st.canvas.layout", layoutDomain());
   }

   private static Domain stTemplateDomain() {

      final Entity stGroupModel = newEntity("STGroupModel")
            .addRelations(newStringField("name", true))
            .addRelations(newStringField("delimiter"))
            .addRelations(newStringField("icon"))
            .addRelations(newStringField("tags"))
            .addRelations(newOneToMany("templates", newEntity("STTemplate")
                  .addRelations(newStringField("name", true))
                  .addRelations(newStringField("text"))
                  .addRelations(newOneToManyString("implements"))
                  .addRelations(newOneToMany("parameters", newEntity("STParameter")
                        .addRelations(newStringField("name", true))
                        .addRelations(newEnumField("type", newEnum("STParameterType", "SINGLE,LIST,KVLIST")))
                        .addRelations(newOneToMany("keys", newEntity("STParameterKey")
                              .addRelations(newStringField("name"))
                              .addRelations(newStringField("argumentType"))))
                        .addRelations(newStringField("argumentType"))))
                  .addRelations(newOneToManySelf("children"))))
            .addRelations(newOneToMany("interfaces", newEntity("STInterface")
                  .addRelations(newStringField("name"))))
            .addRelations(newOneToMany("enums", newEntity("STEnum")
                  .addRelations(newStringField("name", true))
                  .addRelations(newOneToMany("values", newEntity("STEnumValue")
                        .addRelations(newStringField("name", true))
                        .addRelations(newStringField("lexical"))))));

      return newDomain("ST")
            .addEntities(newEntity("STAppModel")
                  .addRelations(newStringField("modelDb"))
                  .addRelations(newStringField("rootDir"))
                  .addRelations(newIntegerField("editorFontSize"))
                  .addRelations(newStringField("generatorRoot"))
                  .addRelations(newStringField("generatorPackage"))
                  .addRelations(newStringField("generatorName"))
                  .addRelations(newOneToMany("directories", newEntity("STGDirectory")
                        .addRelations(newStringField("path"))
                        .addRelations(newStringField("outputPackage"))
                        .addRelations(newStringField("outputPath"))
                        .addRelations(newOneToMany("groups", stGroupModel)))))
            .addEntities(newEntity("STGParseResult")
                  .addRelations(newOneToOne("parsed", stGroupModel))
                  .addRelations(newOneToMany("errors", newEntity("STGError")
                        .addRelations(newEnumField("type", newEnum("STGErrorType", "COMPILE,RUNTIME,IO,INTERNAL")))
                        .addRelations(newStringField("message"))
                        .addRelations(newIntegerField("line"))
                        .addRelations(newIntegerField("charPosition")))));
   }

   private Domain metaDomain() {

      // meta
      final Entity metaProperty = newEntity("MetaProperty")
            .addRelations(newStringField("uuid"))
            .addRelations(newStringField("name"))
            .addRelations(newStringField("type"))
            .addRelations(newStringField("defaultValue"));

      final Entity metaEntity = newEntity("MetaEntity")
            .addRelations(newStringField("uuid"))
            .addRelations(newStringField("name"))
            .addRelations(newOneToMany("properties", metaProperty));

      final Entity metaRelation = newEntity("MetaRelation")
            .addRelations(newStringField("uuid"))
            .addRelations(newStringField("name"))
            .addRelations(newEnumField("cardinality", "Cardinality", "ONE_TO_ONE,ONE_TO_MANY"))
            .addRelations(newOneToMany("dst", metaEntity))
            .addRelations(newOneToMany("properties", metaProperty));

      metaEntity.addRelations(newOneToMany("relations", metaRelation));

      final Entity domainVisitor = newEntity("DomainVisitor")
            .addRelations(newStringField("uuid"))
            .addRelations(newStringField("name"))
            .addRelations(newStringField("initStatements"))
            .addRelations(newStringField("endStatements"))
            .addRelations(newOneToMany("fields", newEntity("VisitorField")
                  .addRelations(newStringField("uuid"))
                  .addRelations(newStringField("name"))
                  .addRelations(newStringField("type"))))
            .addRelations(newOneToMany("entityVisitors", newEntity("EntityVisitorMethod")
                  .addRelations(newStringField("uuid"))
                  .addRelations(newRef("_meta", metaEntity))
                  .addRelations(newStringField("statements"))))
            .addRelations(newOneToMany("relationVisitors", newEntity("RelationVisitorMethod")
                  .addRelations(newStringField("uuid"))
                  .addRelations(newRef("_meta", metaRelation))
                  .addRelations(newStringField("statements"))));

      final Entity metaDomain = newEntity("MetaDomain")
            .addRelations(newStringField("uuid"))
            .addRelations(newStringField("name"))
            .addRelations(newOneToMany("roots", metaEntity))
            .addRelations(newOneToMany("properties", metaProperty))
            .addRelations(newOneToMany("visitors", domainVisitor));

      // models
      final Entity domainEntity = newEntity("DomainEntity")
            .addRelations(newStringField("uuid"))
            .addRelations(newRef("_meta", metaEntity));

      return newDomain("MetaDomain")
            .addEntities(metaDomain)
            .addEntities(domainEntity)
            .addEntities(domainVisitor);
   }

   private Domain stModelDomain() {

      final Entity stValueNeo = newEntity("STValue")
            .setObservable(true)
            .addRelations(newStringField("uuid"))
            .addRelations(newStringField("value"))
            .addRelations(newEnumField("type", newEnum("STValueType", "STMODEL,PRIMITIVE,ENUM")));

      final Entity stFile = newEntity("STFile")
            .setObservable(true)
            .addRelations(newStringField("uuid"))
            .addRelations(newOneToOne("name", stValueNeo))
            .addRelations(newOneToOne("type", stValueNeo))
            .addRelations(newOneToOne("packageName", stValueNeo))
            .addRelations(newOneToOne("path", stValueNeo));

      final Entity stModelNeo = newEntity("STModel")
            .setObservable(true)
            .addRelations(newStringField("uuid"))
            .addRelations(newStringField("stGroup"))
            .addRelations(newStringField("stTemplate"))
            .addRelations(newOneToMany("files", stFile))
            .addRelations(newOneToMany("arguments", newEntity("STArgument")
                  .setObservable(true)
                  .addRelations(newStringField("uuid"))
                  .addRelations(newStringField("stParameter"))
                  .addRelations(newOneToOne("value", stValueNeo))
                  .addRelations(newOneToMany("keyValues", newEntity("STArgumentKV")
                        .setObservable(true)
                        .addRelations(newStringField("uuid"))
                        .addRelations(newStringField("stParameterKey"))
                        .addRelations(newOneToOne("value", stValueNeo))))));

      stValueNeo.addRelations(newOneToOne("stModel", stModelNeo));

      final Entity script = newEntity("Script")
            .setObservable(true)
            .addRelations(newStringField("uuid"))
            .addRelations(newStringField("name"))
            .addRelations(newOneToOne("script", stValueNeo));

      final Entity project = newEntity("Project")
            .setObservable(true)
            .addRelations(newStringField("uuid"))
            .addRelations(newStringField("name"))
            .addRelations(newOneToMany("files", stFile))
            .addRelations(newOneToMany("models", stModelNeo))
            .addRelations(newOneToMany("values", stValueNeo))
            .addRelations(newOneToMany("scripts", script));

      return newDomain("STModel")
            .addEntities(stModelNeo)
            .addEntities(script)
            .addEntities(project);
   }

   private static Domain layoutDomain() {

      final Entity layoutDomain = newEntity("Layout")
            .addRelations(newStringField("uuid"))
            .addRelations(newStringField("name"))
            .addRelations(newOneToMany("nodes", newEntity("LayoutNode")
                  .addRelations(newStringField("uuid"))
                  .addRelations(newDoubleField("x"))
                  .addRelations(newDoubleField("y"))));

      return newDomain("Layout")
            .addEntities(layoutDomain);
   }
}