public class ImportData {

   private static final java.util.List<io.vertx.core.json.JsonObject> stGroups = new java.util.ArrayList<>();

   public static void main(String[] args) {

      java.util.Arrays.stream(java.util.Objects.requireNonNull(new java.io.File("./src/main/resources/templates").listFiles(file -> file.getName().endsWith(".json"))))
            .forEach(file -> {
               try {
                  stGroups.add(new io.vertx.core.json.JsonObject(io.vertx.core.buffer.Buffer.buffer(java.nio.file.Files.readAllBytes(file.toPath()))));
               } catch (java.io.IOException e) {
                  System.out.println("Could not read stgroup file " + file.getAbsolutePath());
               }
            });

      final nextgen.model.STModelDB db = new nextgen.model.STModelDB("./db");

      db.doInTransaction(transaction -> db.findAllSTGroupModel().forEach(stGroupModel -> {
         stGroupModel.getEnums().forEach(ImportData::delete);
         stGroupModel.getInterfaces().forEach(ImportData::delete);
         stGroupModel.getTemplates().forEach(ImportData::delete);
         stGroupModel.delete();
      }));

      db.doInTransaction(transaction -> {
         stGroups.forEach(stGroupJS -> {

            final nextgen.model.STGroupModel groupModel = db.newSTGroupModel();
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

                     final nextgen.model.STInterface stInterface = db.newSTInterface();
                     stInterface.setUuid(stInterfaceJS.getString("uuid"));
                     stInterface.setName(stInterfaceJS.getString("name"));
                     groupModel.addInterfaces(stInterface);

                  });

            stGroupJS.getJsonArray("enums", new io.vertx.core.json.JsonArray())
                  .stream()
                  .map(o -> (io.vertx.core.json.JsonObject) o)
                  .forEach(stEnumJS -> {

                     final nextgen.model.STEnum stEnum = db.newSTEnum();
                     stEnum.setUuid(stEnumJS.getString("uuid"));
                     stEnum.setName(stEnumJS.getString("name"));
                     groupModel.addEnums(stEnum);

                     stEnumJS.getJsonArray("values", new io.vertx.core.json.JsonArray())
                           .stream()
                           .map(o -> (io.vertx.core.json.JsonObject) o)
                           .forEach(stEnumValueJS -> {

                              final nextgen.model.STEnumValue stEnumValue = db.newSTEnumValue();
                              stEnumValue.setUuid(stEnumValueJS.getString("uuid"));
                              stEnumValue.setName(stEnumValueJS.getString("name"));
                              stEnumValue.setLexical(stEnumValueJS.getString("lexical"));
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
                  final nextgen.model.STTemplate stTemplate = db.findSTTemplateByUuid(stTemplateUuid);
                  if (stTemplate == null) {
                     System.out.println(stTemplateUuid);
                     stModel.delete();
                  } else
                     stModel.setStTemplate(stTemplate);
               });

         db.findAllSTArgument()
               .forEach(stArgument -> {
                  final String stParameterUuid = stArgument.getNode().getProperty("stParameter").toString();
                  final nextgen.model.STParameter stParameter = db.findSTParameterByUuid(stParameterUuid);
                  if (stParameter == null) {
                     System.out.println("\t" + stParameterUuid);
                     stArgument.delete();
                  } else
                     stArgument.setStParameter(stParameter);
               });

         db.findAllSTArgumentKV()
               .forEach(stArgumentKV -> {
                  final String stParameterKeyUuid = stArgumentKV.getNode().getProperty("stParameterKey").toString();
                  final nextgen.model.STParameterKey stParameterKey = db.findSTParameterKeyByUuid(stParameterKeyUuid);

                  if (stParameterKey == null) {
                     System.out.println("\t\t" + stParameterKeyUuid);
                     stArgumentKV.delete();
                  } else
                     stArgumentKV.setStParameterKey(stParameterKey);
               });
      });
   }

   private static void print(String delim, nextgen.model.STTemplate stTemplate) {
//      System.out.println(delim + stTemplate.getName());
//      stTemplate.getChildren().forEach(child -> print(delim + "\t", child));
   }

   public static nextgen.model.STTemplate addStTemplate(nextgen.model.STModelDB db, io.vertx.core.json.JsonObject stTemplateJS) {

      final nextgen.model.STTemplate stTemplate = db.newSTTemplate()
            .setUuid(stTemplateJS.getString("uuid"))
            .setName(stTemplateJS.getString("name"))
            .setText(stTemplateJS.getString("text"));

      stTemplateJS.getJsonArray("parameters", new io.vertx.core.json.JsonArray())
            .stream()
            .map(o -> (io.vertx.core.json.JsonObject) o)
            .forEach(stParameterJS -> {

               final nextgen.model.STParameter stParameter = db.newSTParameter()
                     .setUuid(stParameterJS.getString("uuid"))
                     .setName(stParameterJS.getString("name"))
                     .setType(nextgen.model.STParameterType.valueOf(stParameterJS.getString("type")))
                     .setArgumentType(stParameterJS.getString("argumentType"));
               stTemplate.addParameters(stParameter);

               stParameterJS.getJsonArray("keys", new io.vertx.core.json.JsonArray())
                     .stream()
                     .map(o -> (io.vertx.core.json.JsonObject) o)
                     .forEach(parameterKeysJS -> {

                        final nextgen.model.STParameterKey stParameterKey = db.newSTParameterKey()
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

   public static void delete(nextgen.model.STTemplate stTemplate) {

      stTemplate.getChildren().forEach(ImportData::delete);

      stTemplate.getParameters().forEach(stParameter -> {
         stParameter.getKeys().forEach(nextgen.model.STParameterKey::delete);
         stParameter.delete();
      });

      stTemplate.delete();
   }

   private static void delete(nextgen.model.STEnum stEnum) {
      stEnum.getValues().forEach(nextgen.model.STEnumValue::delete);
      stEnum.delete();
   }

   private static void delete(nextgen.model.STInterface stInterface) {
      stInterface.delete();
   }
}