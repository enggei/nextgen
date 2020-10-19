package nextgen.utils;

import nextgen.st.domain.STEnum;
import nextgen.st.domain.STGroupModel;
import nextgen.st.domain.STTemplate;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class STModelUtil {

   public static STEnum findSTEnumByName(String name, STGroupModel stGroupModel) {
      return stGroupModel.getEnums()
                         .filter(stEnum -> stEnum.getName().equals(name))
                         .findFirst()
                         .orElseGet(null);
   }

   public static Set<STTemplate> findSTInterfacesByName(String name, STGroupModel stGroupModel) {
      final Set<STTemplate> set = new LinkedHashSet<>();
      getAllSTTemplates(stGroupModel)
            .forEach(stTemplate -> {
               stTemplate.getImplements()
                         .filter(name::equals)
                         .findFirst()
                         .ifPresent(s -> set.add(stTemplate));
            });
      return set;
   }

   public static java.util.Optional<nextgen.st.domain.STTemplate> findSTTemplateByName(nextgen.st.domain.STGroupModel stGroupModel, String name) {
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


   public static final class STArgumentConsumer implements java.util.function.Consumer<nextgen.st.model.STArgument> {

      private final nextgen.st.domain.STParameter stParameter;

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

      public STArgumentConsumer(nextgen.st.domain.STParameter stParameter) {
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
                           .filter(stArgumentKV -> stArgumentKV
                                 .getStParameterKey()
                                 .equals(stParameterKey
                                       .getUuid()))
                           .filter(stArgumentKV -> stArgumentKV
                                 .getValue() != null)
                           .forEach(stArgumentKV -> {
                              final nextgen.st.model.STValue kvValue = stArgumentKV
                                    .getValue();
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

      public java.util.Collection<nextgen.st.model.STArgumentKV> getStArgumentKVS(nextgen.st.domain.STParameter stParameter, nextgen.st.model.STArgument stArgument) {
         final java.util.Collection<nextgen.st.model.STArgumentKV> kvSet = new LinkedHashSet<>();
         stParameter.getKeys()
                    .forEach(stParameterKey -> stArgument.getKeyValues()
                                                         .filter(stArgumentKV -> stArgumentKV.getStParameterKey().equals(stParameterKey.getUuid()))
                                                         .forEach(kvSet::add));
         return kvSet;
      }


   }
}
