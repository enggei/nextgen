package nextgen.utils;

import nextgen.st.model.STEnum;
import nextgen.st.model.STGroupModel;
import nextgen.st.model.STTemplate;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class STModelUtil {

   public static Set<nextgen.st.model.STModel> aggregateModels(nextgen.st.model.STProject stProject) {

      java.util.Set<nextgen.st.model.STModel> models = new java.util.LinkedHashSet<>();

      stProject.getModels().forEach(stModel -> {
         models.add(stModel);
         models.addAll(aggregateModels(stModel));
      });

      return models;
   }

   public static java.util.Set<nextgen.st.model.STModel> aggregateModels(nextgen.st.model.STModel stModel) {
      java.util.Set<nextgen.st.model.STModel> models = new java.util.LinkedHashSet<>();

      stModel.getArguments().forEach(stArgument -> {
         final nextgen.st.model.STValue value = stArgument.getValue();
         if (value == null) return;

         if (nextgen.st.model.STValueType.STMODEL.equals(value.getType())) {
            final nextgen.st.model.STModel valueSTModel = value.getStModel();
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

   public static java.util.stream.Stream<nextgen.st.model.STTemplate> aggregateTemplates(nextgen.st.model.STGroupModel stGroup) {
      final List<STTemplate> templates = new java.util.ArrayList<>();
      stGroup.getTemplates().forEach(stTemplate -> aggregate(stTemplate, templates));
      return templates.stream().sorted((t1, t2) -> t1.getName().compareToIgnoreCase(t2.getName()));
   }

   public static void aggregate(nextgen.st.model.STTemplate stTemplate, java.util.List<nextgen.st.model.STTemplate> templates) {
      templates.add(stTemplate);
      stTemplate.getChildren().forEach(stTemplate1 -> aggregate(stTemplate1, templates));
   }

   public static STEnum findSTEnumByName(String name, STGroupModel stGroupModel) {
      return stGroupModel.getEnums().filter(stEnum -> stEnum.getName().equals(name)).findFirst().orElse(null);
   }

   public static Set<STTemplate> findSTInterfacesByName(String name, STGroupModel stGroupModel) {
      final Set<STTemplate> set = new LinkedHashSet<>();
      getAllSTTemplates(stGroupModel).forEach(stTemplate -> stTemplate.getImplements().filter(name::equals).findFirst().ifPresent(s -> set.add(stTemplate)));
      return set;
   }

   public static java.util.Optional<nextgen.st.model.STTemplate> findSTTemplateByName(nextgen.st.model.STGroupModel stGroupModel, String name) {
      return getAllSTTemplates(stGroupModel).stream().filter(stTemplate -> stTemplate.getName().toLowerCase().equals(name.toLowerCase())).findAny();
   }

   public static List<STTemplate> getAllSTTemplates(STGroupModel stGroupModel) {
      final List<STTemplate> list = new ArrayList<>();
      stGroupModel.getTemplates().forEach(stTemplate -> {
         list.add(stTemplate);
         list.addAll(getAllSTTemplates(stTemplate));
      });
      return list;
   }

   public static List<STTemplate> getAllSTTemplates(STTemplate stTemplate) {
      final List<STTemplate> list = new ArrayList<>();
      stTemplate.getChildren().forEach(stTemplate1 -> {
         list.add(stTemplate1);
         list.addAll(getAllSTTemplates(stTemplate1));
      });
      return list;
   }

   public static String getSTModelValue(nextgen.st.model.STModel stModel, String parameterName, String defaultValue) {

      final nextgen.st.model.STTemplate stTemplate = stModel.getStTemplate();

      final java.util.Optional<nextgen.st.model.STParameter> foundParameter = stTemplate
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

   public static String getSTModelName(nextgen.st.model.STModel stModel, String defaultValue) {
      return getSTModelValue(stModel, "name", defaultValue);
   }

   public static String getSTModelPackage(nextgen.st.model.STModel stModel, String defaultValue) {
      final String found = getSTModelValue(stModel, "package", null);
      if (found != null) return found;
      return getSTModelValue(stModel, "packageName", defaultValue);
   }

   public static nextgen.st.model.STGroupModel getSTGroup(nextgen.st.model.STTemplate stTemplate) {

      final java.util.Optional<nextgen.st.model.STGroupModel> stGroupModel = stTemplate.getIncomingTemplatesSTGroupModel().findAny();
      if (stGroupModel.isPresent()) return stGroupModel.get();

      final java.util.Optional<nextgen.st.model.STTemplate> parent = stTemplate.getIncomingChildrenSTTemplate().findAny();
      return parent.map(nextgen.utils.STModelUtil::getSTGroup).orElse(null);
   }

   public static nextgen.st.model.STArgument findSTArgument(nextgen.st.model.STParameter stParameter, nextgen.st.model.STModel stModel) {
      return stModel.getArguments()
            .filter(stArgument -> stArgument.getStParameter().equals(stParameter))
            .findFirst()
            .orElse(null);
   }

   public static final class STArgumentConsumer implements java.util.function.Consumer<nextgen.st.model.STArgument> {

      private final nextgen.st.model.STParameter stParameter;

      private java.util.function.BiConsumer<nextgen.st.model.STArgument, nextgen.st.model.STValue> onSingleSTValueConsumer = (stArgument, stValue) -> {
      };
      private java.util.function.BiConsumer<nextgen.st.model.STArgument, nextgen.st.model.STValue> onSingleSTModelConsumer = (stArgument, stValue) -> {
      };
      private java.util.function.BiConsumer<nextgen.st.model.STArgument, nextgen.st.model.STValue> onSingleEnumConsumer = (stArgument, stValue) -> {
      };

      private java.util.function.BiConsumer<nextgen.st.model.STArgument, nextgen.st.model.STValue> onListSTValueConsumer = (stArgument, stValue) -> {
      };
      private java.util.function.BiConsumer<nextgen.st.model.STArgument, nextgen.st.model.STValue> onListSTModelConsumer = (stArgument, stValue) -> {
      };
      private java.util.function.BiConsumer<nextgen.st.model.STArgument, nextgen.st.model.STValue> onListEnumConsumer = (stArgument, stValue) -> {
      };

      private java.util.function.BiConsumer<nextgen.st.model.STArgument, java.util.Collection<nextgen.st.model.STArgumentKV>> onKVListConsumer = (stArgument, stArgumentKVS) -> {
      };
      private java.util.function.BiConsumer<nextgen.st.model.STArgumentKV, nextgen.st.model.STValue> onKVListSTValueConsumer = (stArgumentKV, stValue) -> {

      };
      private java.util.function.BiConsumer<nextgen.st.model.STArgumentKV, nextgen.st.model.STValue> onKVListSTModelConsumer = (stArgumentKV, stValue) -> {

      };
      private java.util.function.BiConsumer<nextgen.st.model.STArgumentKV, nextgen.st.model.STValue> onKVListEnumConsumer = (stArgumentKV, stValue) -> {

      };

      public STArgumentConsumer(nextgen.st.model.STParameter stParameter) {
         this.stParameter = stParameter;
      }

      @Override
      public void accept(nextgen.st.model.STArgument stArgument) {
         final nextgen.st.model.STValue value = stArgument.getValue();
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
                              final nextgen.st.model.STValue kvValue = stArgumentKV.getValue();
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

      public STArgumentConsumer onKVListConsumer(java.util.function.BiConsumer<nextgen.st.model.STArgument, java.util.Collection<nextgen.st.model.STArgumentKV>> consumer) {
         this.onKVListConsumer = consumer;
         return this;
      }

      public STArgumentConsumer onKVListEnum(java.util.function.BiConsumer<nextgen.st.model.STArgumentKV, nextgen.st.model.STValue> consumer) {
         this.onKVListEnumConsumer = consumer;
         return this;
      }

      public STArgumentConsumer onKVListSTModel(java.util.function.BiConsumer<nextgen.st.model.STArgumentKV, nextgen.st.model.STValue> consumer) {
         this.onKVListSTModelConsumer = consumer;
         return this;
      }

      public STArgumentConsumer onKVListSTValue(java.util.function.BiConsumer<nextgen.st.model.STArgumentKV, nextgen.st.model.STValue> consumer) {
         this.onKVListSTValueConsumer = consumer;
         return this;
      }

      public STArgumentConsumer onListEnum(java.util.function.BiConsumer<nextgen.st.model.STArgument, nextgen.st.model.STValue> consumer) {
         this.onListEnumConsumer = consumer;
         return this;
      }

      public STArgumentConsumer onListSTModel(java.util.function.BiConsumer<nextgen.st.model.STArgument, nextgen.st.model.STValue> consumer) {
         this.onListSTModelConsumer = consumer;
         return this;
      }

      public STArgumentConsumer onListSTValue(java.util.function.BiConsumer<nextgen.st.model.STArgument, nextgen.st.model.STValue> consumer) {
         this.onListSTValueConsumer = consumer;
         return this;
      }

      public STArgumentConsumer onSingleEnum(java.util.function.BiConsumer<nextgen.st.model.STArgument, nextgen.st.model.STValue> consumer) {
         this.onSingleEnumConsumer = consumer;
         return this;
      }

      public STArgumentConsumer onSingleSTModel(java.util.function.BiConsumer<nextgen.st.model.STArgument, nextgen.st.model.STValue> consumer) {
         this.onSingleSTModelConsumer = consumer;
         return this;
      }

      public STArgumentConsumer onSingleSTValue(java.util.function.BiConsumer<nextgen.st.model.STArgument, nextgen.st.model.STValue> consumer) {
         this.onSingleSTValueConsumer = consumer;
         return this;
      }

      public java.util.Collection<nextgen.st.model.STArgumentKV> getStArgumentKVS(nextgen.st.model.STParameter stParameter, nextgen.st.model.STArgument stArgument) {
         final java.util.Collection<nextgen.st.model.STArgumentKV> kvSet = new LinkedHashSet<>();
         stParameter.getKeys().forEach(stParameterKey -> stArgument.getKeyValues().filter(stArgumentKV -> stArgumentKV.getStParameterKey().equals(stParameterKey)).forEach(kvSet::add));
         return kvSet;
      }
   }
}