package nextgen.st;

import nextgen.st.domain.STParameter;
import nextgen.st.domain.STParameterKey;
import nextgen.st.domain.STTemplate;
import nextgen.st.model.*;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class STVisitor {

   protected final STModelDB db;

   public STVisitor(STModelDB db) {
      this.db = db;
   }

   public final void visit(STModel stModel) {

      if (stModel == null) return;

      final STTemplate stTemplate = db.findSTTemplateByUuid(stModel.getStTemplate());
      if (stTemplate == null) return;

      stTemplate.getParameters().forEach(stParameter ->
            stModel.getArgumentsSorted()
                   .filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
                   .forEach(stArgument -> {
                      switch (stParameter.getType()) {
                         case SINGLE:
                            visitSingle(stModel, stParameter, stArgument);
                            break;
                         case LIST:
                            visitList(stModel, stParameter, stArgument);
                            break;
                         case KVLIST:
                            visitKVList(stModel, stParameter, stArgument);
                            break;
                      }
                   }));
   }

   public final void visitSingle(STModel stModel, STParameter stParameter, STArgument stArgument) {

      final STValue value = stArgument.getValue();
      if (value == null) return;

      switch (value.getType()) {
         case STMODEL:
            if (value.getStModel() == null) return;
            visitSingleSTModel(stModel, stParameter, stArgument, value.getStModel());
            break;
         case PRIMITIVE:
            if (value.getValue() == null) return;
            visitSinglePrimitive(stModel, stParameter, stArgument, value.getValue());
            break;
         case ENUM:
            if (value.getValue() == null) return;
            visitSingleEnum(stModel, stParameter, stArgument, value.getValue());
            break;
      }
   }

   public final void visitList(STModel stModel, STParameter stParameter, STArgument stArgument) {

      final STValue value = stArgument.getValue();
      if (value == null) return;

      switch (value.getType()) {
         case STMODEL:
            if (value.getStModel() == null) return;
            visitListSTModel(stModel, stParameter, stArgument, value.getStModel());
            break;
         case PRIMITIVE:
            if (value.getValue() == null) return;
            visitListPrimitive(stModel, stParameter, stArgument, value.getValue());
            break;
         case ENUM:
            if (value.getValue() == null) return;
            visitListEnum(stModel, stParameter, stArgument, value.getValue());
            break;
      }
   }

   public final void visitKVList(STModel stModel, STParameter stParameter, STArgument stArgument) {
      final java.util.Map<nextgen.st.domain.STParameterKey, nextgen.st.model.STArgumentKV> kvMap = getStParameterKeySTArgumentKVMap(stParameter, stArgument);

      kvMap.forEach((stParameterKey, stArgumentKV) -> {

         final STValue value = stArgumentKV.getValue();
         if (value == null) return;

         switch (value.getType()) {
            case STMODEL:
               if (value.getStModel() == null) return;
               visitKVEntrySTModel(stModel, stParameter, stArgument, stParameterKey, stArgumentKV, value.getStModel());
               break;
            case PRIMITIVE:
               if (value.getValue() == null) return;
               visitKVEntryPrimitive(stModel, stParameter, stArgument, stParameterKey, stArgumentKV, value.getValue());
               break;
            case ENUM:
               if (value.getValue() == null) return;
               visitKVEntryEnum(stModel, stParameter, stArgument, stParameterKey, stArgumentKV, value.getValue());
               break;
         }
      });
   }

   protected void visitSingleSTModel(STModel stModel, STParameter stParameter, STArgument stArgument, STModel valueStModel) {

   }

   protected void visitSinglePrimitive(STModel stModel, STParameter stParameter, STArgument stArgument, String value) {

   }

   protected void visitSingleEnum(STModel stModel, STParameter stParameter, STArgument stArgument, String value) {

   }

   protected void visitListSTModel(STModel stModel, STParameter stParameter, STArgument stArgument, STModel valueStModel) {

   }

   protected void visitListPrimitive(STModel stModel, STParameter stParameter, STArgument stArgument, String value) {

   }

   protected void visitListEnum(STModel stModel, STParameter stParameter, STArgument stArgument, String value) {

   }

   protected void visitKVEntrySTModel(STModel stModel, STParameter stParameter, STArgument stArgument, STParameterKey stParameterKey, STArgumentKV stArgumentKV, STModel kvSTModel) {

   }

   protected void visitKVEntryPrimitive(STModel stModel, STParameter stParameter, STArgument stArgument, STParameterKey stParameterKey, STArgumentKV stArgumentKV, String kvValue) {

   }

   protected void visitKVEntryEnum(STModel stModel, STParameter stParameter, STArgument stArgument, STParameterKey stParameterKey, STArgumentKV stArgumentKV, String kvValue) {

   }

   private Map<STParameterKey, STArgumentKV> getStParameterKeySTArgumentKVMap(STParameter stParameter, STArgument stArgument) {
      final Set<STParameterKey> stParameterKeys = stParameter.getKeys().collect(Collectors.toSet());
      final Map<STParameterKey, STArgumentKV> stArgumentKVMap = new LinkedHashMap<>();
      stParameterKeys.forEach(stParameterKey -> stArgument.getKeyValues()
                                                          .filter(stArgumentKV -> stArgumentKV.getStParameterKey().equals(stParameterKey.getUuid()))
                                                          .findFirst()
                                                          .ifPresent(stArgumentKV -> stArgumentKVMap.put(stParameterKey, stArgumentKV)));
      return stArgumentKVMap;
   }
}