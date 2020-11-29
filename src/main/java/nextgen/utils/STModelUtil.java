package nextgen.utils;

import nextgen.model.*;

import java.util.*;

public class STModelUtil {

   public static java.util.stream.Stream<nextgen.model.STTemplate> aggregateTemplates(nextgen.model.STGroupModel stGroup) {
      final List<STTemplate> templates = new java.util.ArrayList<>();
      stGroup.getTemplates().forEach(stTemplate -> aggregate(stTemplate, templates));
      return templates.stream().sorted((t1, t2) -> t1.getName().compareToIgnoreCase(t2.getName()));
   }

   public static void aggregate(nextgen.model.STTemplate parentTemplate, java.util.List<nextgen.model.STTemplate> templates) {
      templates.add(parentTemplate);
      parentTemplate.getChildren().forEach(childTemplate -> aggregate(childTemplate, templates));
   }

   public static Set<nextgen.model.STModel> aggregateModels(nextgen.model.STProject stProject) {

      java.util.Set<nextgen.model.STModel> models = new java.util.LinkedHashSet<>();

      stProject.getModels().forEach(stModel -> {
         models.add(stModel);
         models.addAll(aggregateModels(stModel));
      });

      return models;
   }

   public static java.util.Set<nextgen.model.STModel> aggregateModels(nextgen.model.STModel stModel) {
      java.util.Set<nextgen.model.STModel> models = new java.util.LinkedHashSet<>();

      stModel.getArguments().forEach(stArgument -> {
         final nextgen.model.STValue value = stArgument.getValue();
         if (value == null) return;

         if (nextgen.model.STValueType.STMODEL.equals(value.getType())) {
            final nextgen.model.STModel valueSTModel = value.getStModel();
            models.add(valueSTModel);
            models.addAll(aggregateModels(valueSTModel));
         }
      });

      return models;
   }

   public static Set<STTemplate> findSTTemplatesByInterface(String name, STGroupModel stGroupModel) {
      final Set<STTemplate> set = new LinkedHashSet<>();
      aggregateTemplates(stGroupModel)
            .forEach(stTemplate -> stTemplate.getImplements()
                  .filter(name::equals)
                  .findFirst()
                  .ifPresent(s -> set.add(stTemplate)));
      return set;
   }

   public static STEnum findSTEnumByName(String name, STGroupModel stGroupModel) {
      return stGroupModel.getEnums().filter(stEnum -> stEnum.getName().equals(name)).findFirst().orElse(null);
   }

   public static STEnum findSTEnumByArgumentType(nextgen.model.STParameter stParameter) {
      return findSTEnumByName(stParameter.getArgumentType(), getSTGroup(stParameter));
   }

   public static boolean isEnum(nextgen.model.STParameter stParameter) {
      return findSTEnumByName(stParameter.getArgumentType(), getSTGroup(stParameter)) != null;
   }

   public static Set<STTemplate> findSTInterfacesByName(String name, STGroupModel stGroupModel) {
      final Set<STTemplate> set = new LinkedHashSet<>();
      aggregateTemplates(stGroupModel).forEach(stTemplate -> stTemplate.getImplements().filter(name::equals).findFirst().ifPresent(s -> set.add(stTemplate)));
      return set;
   }

   public static java.util.Optional<nextgen.model.STTemplate> findSTTemplateByName(nextgen.model.STGroupModel stGroupModel, String name) {
      return aggregateTemplates(stGroupModel).filter(stTemplate -> stTemplate.getName().toLowerCase().equals(name.toLowerCase())).findAny();
   }

   public static Optional<String> isValidTemplateName(javax.swing.JComponent parent, STGroupModel stGroupModel, String name) {

      if (findSTTemplateByName(stGroupModel, name).isPresent()) {
         SwingUtil.showMessage(name + " already in use in this group", parent);
         return Optional.empty();
      }

      if (name.toLowerCase().equals("eom") || name.toLowerCase().equals("gt")) {
         SwingUtil.showMessage(name + " is a reserved name", parent);
         return Optional.empty();
      }

      if (!javax.lang.model.SourceVersion.isIdentifier(name)) {
         SwingUtil.showMessage(name + " is a reserved java keyword", parent);
         return Optional.empty();
      }

      return Optional.of(name);
   }

   public static String getSTModelValue(nextgen.model.STModel stModel, String parameterName, String defaultValue) {

      final nextgen.model.STTemplate stTemplate = stModel.getStTemplate();

      final java.util.Optional<nextgen.model.STParameter> foundParameter = stTemplate
            .getParameters()
            .filter(stParameter -> stParameter.getName().equals(parameterName))
            .findAny();
      if (!foundParameter.isPresent()) return defaultValue;

      return stModel
            .getArguments()
            .filter(stArgument -> stArgument.getStParameter().equals(foundParameter.get()))
            .map(stArgument -> stArgument.getValue().getValue())
            .findFirst()
            .orElse(defaultValue);
   }

   public static String getSTModelName(nextgen.model.STModel stModel, String defaultValue) {
      return getSTModelValue(stModel, "name", defaultValue);
   }

   public static boolean isBoolean(nextgen.model.STParameter model) {
      return model.getName().startsWith("is") || model.getName().startsWith("has");
   }

   public static boolean isValidPrimitive(nextgen.model.STValue stValue) {
      return stValue.getType() != null &&
            stValue.getValue() != null &&
            stValue.getType().equals(nextgen.model.STValueType.PRIMITIVE);
   }

   public static String getSTModelPackage(nextgen.model.STModel stModel, String defaultValue) {
      final String found = getSTModelValue(stModel, "package", null);
      if (found != null) return found;
      return getSTModelValue(stModel, "packageName", defaultValue);
   }

   public static nextgen.model.STGroupModel getSTGroup(nextgen.model.STParameter stParameter) {
      return stParameter.getIncomingParametersSTTemplate()
            .findFirst()
            .map(nextgen.utils.STModelUtil::getSTGroup)
            .orElse(null);
   }

   public static nextgen.model.STGroupModel getSTGroup(nextgen.model.STTemplate stTemplate) {

      final java.util.Optional<nextgen.model.STGroupModel> stGroupModel = stTemplate.getIncomingTemplatesSTGroupModel().findAny();
      if (stGroupModel.isPresent()) return stGroupModel.get();

      final java.util.Optional<nextgen.model.STTemplate> parent = stTemplate.getIncomingChildrenSTTemplate().findAny();
      return parent.map(nextgen.utils.STModelUtil::getSTGroup).orElse(null);
   }

   public static nextgen.model.STGroupModel getSTGroup(nextgen.model.STModel stModel) {
      return getSTGroup(stModel.getStTemplate());
   }

   public static nextgen.model.STArgument findSTArgument(nextgen.model.STParameter stParameter, nextgen.model.STModel stModel) {
      return stModel.getArguments()
            .filter(stArgument -> stArgument.getStParameter().equals(stParameter))
            .findFirst()
            .orElse(null);
   }

   public static java.util.stream.Stream<nextgen.model.STParameter> getSingleEnumsOrPrimitiveParameters(nextgen.model.STTemplate stTemplate) {
      return stTemplate.getParameters()
            .filter(stParameter -> stParameter.getType().equals(nextgen.model.STParameterType.SINGLE))
            .filter(stParameter -> stParameter.getArgumentType() != null)
            .filter(stParameter -> nextgen.utils.STModelUtil.isEnum(stParameter) || stParameter.getArgumentType().equals("String") || stParameter.getArgumentType().equals("Object"));
   }

   public static nextgen.model.STArgument getArgument(nextgen.model.STParameter stParameter, nextgen.model.STModel model) {
      return model.getArguments()
            .filter(stArgument -> stArgument.getStParameter().equals(stParameter))
            .findFirst()
            .orElse(null);
   }

   public static java.util.stream.Stream<nextgen.model.STValue> getSTModelValues(nextgen.model.STModel model) {
      return model.getArguments()
            .filter(stArgument -> stArgument.getValue() != null)
            .map(nextgen.model.STArgument::getValue)
            .filter(stValue -> stValue.getType() != null)
            .filter(stValue -> stValue.getType().equals(nextgen.model.STValueType.STMODEL))
            .filter(stValue -> stValue.getStModel() != null);
   }

   public static final class STArgumentConsumer implements java.util.function.Consumer<nextgen.model.STArgument> {

      private final nextgen.model.STParameter stParameter;

      private java.util.function.BiConsumer<nextgen.model.STArgument, nextgen.model.STValue> onSingleSTValueConsumer = (stArgument, stValue) -> {
      };
      private java.util.function.BiConsumer<nextgen.model.STArgument, nextgen.model.STValue> onSingleSTModelConsumer = (stArgument, stValue) -> {
      };
      private java.util.function.BiConsumer<nextgen.model.STArgument, nextgen.model.STValue> onSingleEnumConsumer = (stArgument, stValue) -> {
      };

      private java.util.function.BiConsumer<nextgen.model.STArgument, nextgen.model.STValue> onListSTValueConsumer = (stArgument, stValue) -> {
      };
      private java.util.function.BiConsumer<nextgen.model.STArgument, nextgen.model.STValue> onListSTModelConsumer = (stArgument, stValue) -> {
      };
      private java.util.function.BiConsumer<nextgen.model.STArgument, nextgen.model.STValue> onListEnumConsumer = (stArgument, stValue) -> {
      };

      private java.util.function.BiConsumer<nextgen.model.STArgument, java.util.Collection<nextgen.model.STArgumentKV>> onKVListConsumer = (stArgument, stArgumentKVS) -> {
      };
      private java.util.function.BiConsumer<nextgen.model.STArgumentKV, nextgen.model.STValue> onKVListSTValueConsumer = (stArgumentKV, stValue) -> {

      };
      private java.util.function.BiConsumer<nextgen.model.STArgumentKV, nextgen.model.STValue> onKVListSTModelConsumer = (stArgumentKV, stValue) -> {

      };
      private java.util.function.BiConsumer<nextgen.model.STArgumentKV, nextgen.model.STValue> onKVListEnumConsumer = (stArgumentKV, stValue) -> {

      };

      public STArgumentConsumer(nextgen.model.STParameter stParameter) {
         this.stParameter = stParameter;
      }

      @Override
      public void accept(nextgen.model.STArgument stArgument) {
         final nextgen.model.STValue value = stArgument.getValue();
         switch (stParameter.getType()) {
            case SINGLE:
               if (value == null || value.getType() == null)
                  break;
               switch (value.getType()) {
                  case STMODEL:
                     if (value.getStModel() != null)
                        onSingleSTModelConsumer.accept(stArgument, value);
                     break;
                  case PRIMITIVE:
                     onSingleSTValueConsumer.accept(stArgument, value);
                     break;
                  case ENUM:
                     onSingleEnumConsumer.accept(stArgument, value);
                     break;
               }
               break;
            case LIST:
               if (value == null || value.getType() == null)
                  break;
               switch (value.getType()) {
                  case STMODEL:
                     if (value.getStModel() != null)
                        onListSTModelConsumer.accept(stArgument, value);
                     break;
                  case PRIMITIVE:
                     onListSTValueConsumer.accept(stArgument, value);
                     break;
                  case ENUM:
                     onListEnumConsumer.accept(stArgument, value);
                     break;
               }
               break;
            case KVLIST:

               onKVListConsumer.accept(stArgument, getStArgumentKVS(stParameter, stArgument));

               stParameter
                     .getKeys()
                     .forEach(stParameterKey -> stArgument
                           .getKeyValues()
                           .filter(stArgumentKV -> stArgumentKV.getStParameterKey().equals(stParameterKey))
                           .filter(stArgumentKV -> stArgumentKV.getValue() != null)
                           .forEach(stArgumentKV -> {
                              final nextgen.model.STValue kvValue = stArgumentKV.getValue();
                              switch (kvValue.getType()) {
                                 case STMODEL:
                                    if (kvValue.getStModel() != null)
                                       onKVListSTModelConsumer
                                             .accept(stArgumentKV, kvValue);
                                    break;
                                 case PRIMITIVE:
                                    onKVListSTValueConsumer
                                          .accept(stArgumentKV, kvValue);
                                    break;
                                 case ENUM:
                                    onKVListEnumConsumer
                                          .accept(stArgumentKV, kvValue);
                                    break;
                              }
                           }));

               break;
         }
      }

      public STArgumentConsumer onKVListConsumer(java.util.function.BiConsumer<nextgen.model.STArgument, java.util.Collection<nextgen.model.STArgumentKV>> consumer) {
         this.onKVListConsumer = consumer;
         return this;
      }

      public STArgumentConsumer onKVListEnum(java.util.function.BiConsumer<nextgen.model.STArgumentKV, nextgen.model.STValue> consumer) {
         this.onKVListEnumConsumer = consumer;
         return this;
      }

      public STArgumentConsumer onKVListSTModel(java.util.function.BiConsumer<nextgen.model.STArgumentKV, nextgen.model.STValue> consumer) {
         this.onKVListSTModelConsumer = consumer;
         return this;
      }

      public STArgumentConsumer onKVListSTValue(java.util.function.BiConsumer<nextgen.model.STArgumentKV, nextgen.model.STValue> consumer) {
         this.onKVListSTValueConsumer = consumer;
         return this;
      }

      public STArgumentConsumer onListEnum(java.util.function.BiConsumer<nextgen.model.STArgument, nextgen.model.STValue> consumer) {
         this.onListEnumConsumer = consumer;
         return this;
      }

      public STArgumentConsumer onListSTModel(java.util.function.BiConsumer<nextgen.model.STArgument, nextgen.model.STValue> consumer) {
         this.onListSTModelConsumer = consumer;
         return this;
      }

      public STArgumentConsumer onListSTValue(java.util.function.BiConsumer<nextgen.model.STArgument, nextgen.model.STValue> consumer) {
         this.onListSTValueConsumer = consumer;
         return this;
      }

      public STArgumentConsumer onSingleEnum(java.util.function.BiConsumer<nextgen.model.STArgument, nextgen.model.STValue> consumer) {
         this.onSingleEnumConsumer = consumer;
         return this;
      }

      public STArgumentConsumer onSingleSTModel(java.util.function.BiConsumer<nextgen.model.STArgument, nextgen.model.STValue> consumer) {
         this.onSingleSTModelConsumer = consumer;
         return this;
      }

      public STArgumentConsumer onSingleSTValue(java.util.function.BiConsumer<nextgen.model.STArgument, nextgen.model.STValue> consumer) {
         this.onSingleSTValueConsumer = consumer;
         return this;
      }

      public java.util.Collection<nextgen.model.STArgumentKV> getStArgumentKVS(nextgen.model.STParameter stParameter, nextgen.model.STArgument stArgument) {
         final java.util.Collection<nextgen.model.STArgumentKV> kvSet = new LinkedHashSet<>();
         stParameter.getKeys().forEach(stParameterKey -> stArgument.getKeyValues().filter(stArgumentKV -> stArgumentKV.getStParameterKey().equals(stParameterKey)).forEach(kvSet::add));
         return kvSet;
      }
   }
}