public class ImportData {

   private static final java.util.List<io.vertx.core.json.JsonObject> stGroups = new java.util.ArrayList<>();

   public static void main(String[] args) {

      java.util.Arrays.stream(java.util.Objects.requireNonNull(new java.io.File("/home/goe/projects/nextgen/components/core/src/main/resources/templates").listFiles(file -> file.getName().endsWith(".json"))))
            .forEach(file -> {
               try {
                  stGroups.add(new io.vertx.core.json.JsonObject(io.vertx.core.buffer.Buffer.buffer(java.nio.file.Files.readAllBytes(file.toPath()))));
               } catch (java.io.IOException e) {
                  System.out.println("Could not read stgroup file " + file.getAbsolutePath());
               }
            });

      final nextgen.st.model.STModelDB db = new nextgen.st.model.STModelDB("/home/goe/projects/nextgen/db");

      db.doInTransaction(transaction -> db.findAllSTGroupModel().forEach(stGroupModel -> {
         stGroupModel.getTemplates().forEach(ImportData::delete);
         stGroupModel.delete();
      }));

      db.doInTransaction(transaction -> {
         stGroups.forEach(stGroupJS -> {

            final nextgen.st.model.STGroupModel groupModel = db.newSTGroupModel();
            groupModel.setUuid(stGroupJS.getString("uuid"));
            groupModel.setName(stGroupJS.getString("name"));
            groupModel.setDelimiter(stGroupJS.getString("delimiter"));

            stGroupJS.getJsonArray("templates", new io.vertx.core.json.JsonArray())
                  .stream()
                  .map(o -> (io.vertx.core.json.JsonObject) o)
                  .forEach(stTemplateJS -> groupModel.addTemplates(addStTemplate(db, stTemplateJS)));

            stGroupJS.getJsonArray("interfaces", new io.vertx.core.json.JsonArray())
                  .stream()
                  .map(o -> (io.vertx.core.json.JsonObject) o)
                  .forEach(stInterfaceJS -> {

                     final nextgen.st.model.STInterface stInterface = db.newSTInterface();
                     stInterface.setUuid(stInterfaceJS.getString("uuid"));
                     stInterface.setName(stInterfaceJS.getString("name"));
                     groupModel.addInterfaces(stInterface);

                  });

            stGroupJS.getJsonArray("enums", new io.vertx.core.json.JsonArray())
                  .stream()
                  .map(o -> (io.vertx.core.json.JsonObject) o)
                  .forEach(stEnumJS -> {

                     final nextgen.st.model.STEnum stEnum = db.newSTEnum();
                     stEnum.setUuid(stEnumJS.getString("uuid"));
                     stEnum.setName(stEnumJS.getString("name"));
                     groupModel.addEnums(stEnum);

                     stGroupJS.getJsonArray("values", new io.vertx.core.json.JsonArray())
                           .stream()
                           .map(o -> (io.vertx.core.json.JsonObject) o)
                           .forEach(stEnumValueJS -> {

                              final nextgen.st.model.STEnumValue stEnumValue = db.newSTEnumValue();
                              stEnumValue.setUuid(stEnumJS.getString("uuid"));
                              stEnumValue.setName(stEnumJS.getString("name"));
                              stEnumValue.setLexical(stEnumJS.getString("lexical"));
                              stEnum.addValues(stEnumValue);
                           });
                  });
         });
      });

      db.doInTransaction(transaction -> {

         db.findAllSTGroupModel().forEach(stGroupModel -> {
            System.out.println(stGroupModel.getName());
            stGroupModel.getTemplates().forEach(stTemplate -> print("\t", stTemplate));
         });

         db.findAllSTModel()
               .forEach(stModel -> {
                  final String stTemplateUuid = stModel.getNode().getProperty("stTemplate").toString();
                  final nextgen.st.model.STTemplate stTemplate = db.findSTTemplateByUuid(stTemplateUuid);
                  if (stTemplate == null) {
                     System.out.println(stTemplateUuid);
                     stModel.delete();
                  } else
                     stModel.setStTemplate(stTemplate);
               });

         db.findAllSTArgument()
               .forEach(stArgument -> {
                  final String stParameterUuid = stArgument.getNode().getProperty("stParameter").toString();
                  final nextgen.st.model.STParameter stParameter = db.findSTParameterByUuid(stParameterUuid);
                  if (stParameter == null) {
                     System.out.println("\t" + stParameterUuid);
                     stArgument.delete();
                  } else
                     stArgument.setStParameter(stParameter);
               });

         db.findAllSTArgumentKV()
               .forEach(stArgumentKV -> {
                  final String stParameterKeyUuid = stArgumentKV.getNode().getProperty("stParameterKey").toString();
                  final nextgen.st.model.STParameterKey stParameterKey = db.findSTParameterKeyByUuid(stParameterKeyUuid);

                  if (stParameterKey == null) {
                     System.out.println("\t\t" + stParameterKeyUuid);
                     stArgumentKV.delete();
                  } else
                     stArgumentKV.setStParameterKey(stParameterKey);
               });
      });
   }

   private static void print(String delim, nextgen.st.model.STTemplate stTemplate) {
//      System.out.println(delim + stTemplate.getName());
//      stTemplate.getChildren().forEach(child -> print(delim + "\t", child));
   }

   public static nextgen.st.model.STTemplate addStTemplate(nextgen.st.model.STModelDB db, io.vertx.core.json.JsonObject stTemplateJS) {

      final nextgen.st.model.STTemplate stTemplate = db.newSTTemplate()
            .setUuid(stTemplateJS.getString("uuid"))
            .setName(stTemplateJS.getString("name"))
            .setText(stTemplateJS.getString("text"));

      stTemplateJS.getJsonArray("parameters", new io.vertx.core.json.JsonArray())
            .stream()
            .map(o -> (io.vertx.core.json.JsonObject) o)
            .forEach(stParameterJS -> {

               final nextgen.st.model.STParameter stParameter = db.newSTParameter()
                     .setUuid(stParameterJS.getString("uuid"))
                     .setName(stParameterJS.getString("name"))
                     .setType(nextgen.st.model.STParameterType.valueOf(stParameterJS.getString("type")))
                     .setArgumentType(stParameterJS.getString("argumentType"));
               stTemplate.addParameters(stParameter);

               stParameterJS.getJsonArray("keys", new io.vertx.core.json.JsonArray())
                     .stream()
                     .map(o -> (io.vertx.core.json.JsonObject) o)
                     .forEach(parameterKeysJS -> {

                        final nextgen.st.model.STParameterKey stParameterKey = db.newSTParameterKey()
                              .setUuid(parameterKeysJS.getString("uuid"))
                              .setName(parameterKeysJS.getString("name"))
                              .setArgumentType(parameterKeysJS.getString("argumentType"));
                        stParameter.addKeys(stParameterKey);

                     });
            });

      stTemplateJS.getJsonArray("children", new io.vertx.core.json.JsonArray())
            .stream()
            .map(o -> (io.vertx.core.json.JsonObject) o)
            .forEach(childTemplateST -> stTemplate.addChildren(addStTemplate(db, childTemplateST)));

      stTemplateJS.getJsonArray("implements", new io.vertx.core.json.JsonArray())
            .stream()
            .map(o -> (String) o)
            .forEach(stTemplate::addImplements);

      return stTemplate;
   }

   public static void delete(nextgen.st.model.STTemplate stTemplate) {

      stTemplate.getChildren().forEach(ImportData::delete);

      stTemplate.getParameters().forEach(stParameter -> {
         stParameter.getKeys().forEach(nextgen.st.model.STParameterKey::delete);
         stParameter.delete();
      });

      stTemplate.delete();
   }
}