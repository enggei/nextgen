package nextgen.st;

import nextgen.st.domain.STGroupModel;
import nextgen.templates.stringtemplate.KVAccessors;
import nextgen.templates.stringtemplate.NeoDomain;
import nextgen.templates.stringtemplate.NeoEntity;
import nextgen.templates.stringtemplate.StringTemplateST;
import nextgen.utils.StringUtil;

import java.io.File;

public class STNeoGenerator {

   private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STNeoGenerator.class);

   public void generateSTGroup(STGroupModel stGroupModel, String packageDeclaration, String rootPath) {

      final File root = new File(rootPath);

      final String className = nextgen.utils.StringUtil.capitalize(stGroupModel.getName()) + "Neo";

      final NeoDomain factory = StringTemplateST.newNeoDomain()
            .setPackage(packageDeclaration)
            .setName(className);

      stGroupModel.getTemplates()
            .forEach(stTemplate -> visitSTTemplate(factory, stGroupModel.getUuid(), stTemplate, packageDeclaration, root));

      STGenerator.writeJavaFile(factory, packageDeclaration, factory.getName().toString(), root);
   }

   public void visitSTTemplate(NeoDomain factory, String groupModelUuid, nextgen.st.domain.STTemplate stTemplate, String packageDeclaration, File root) {

      final String className = StringUtil.capitalize(stTemplate.getName()) + "Model";

      factory.addEntities(className);

      final NeoEntity entityClass = StringTemplateST.newNeoEntity()
            .setPackage(packageDeclaration)
            .setName(className)
            .setStGroupModel(groupModelUuid)
            .setStTemplate(stTemplate.getUuid());

      //entityClass.setEntity(StringUtil.capitalize(stTemplate.getName()));

      stTemplate.getParameters().forEach(stParameter -> {
         switch (stParameter.getType()) {
            case SINGLE:

               entityClass.addSingleAccessors(StringTemplateST.newSingleAccessors()
                     .setEntity(className)
                     .setName(stParameter.getName()));

               factory.addFinders(StringTemplateST.newFindBy()
                     .setEntity(className)
                     .setName(stParameter.getName()));

               break;

            case LIST:

               entityClass.addListAccessors(StringTemplateST.newListAccessors()
                     .setEntity(className)
                     .setName(stParameter.getName()));
               break;

            case KVLIST:

               KVAccessors kvAccessors = StringTemplateST.newKVAccessors()
                     .setEntity(className)
                     .setName(stParameter.getName());

               stParameter.getKeys()
                     .forEach(stParameterKey -> kvAccessors.addKeys(stParameterKey.getName()));

               entityClass.addKvAccessors(kvAccessors);
               break;
         }
      });

      STGenerator.writeJavaFile(entityClass, packageDeclaration, className, root);

      stTemplate.getChildren()
            .forEach(stTemplate1 -> visitSTTemplate(factory, groupModelUuid, stTemplate1, packageDeclaration, root));
   }
}