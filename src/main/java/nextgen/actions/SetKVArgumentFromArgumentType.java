package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;

import nextgen.model.*;

import javax.swing.*;

import org.neo4j.graphdb.Transaction;

import java.awt.event.ActionEvent;

public class SetKVArgumentFromArgumentType extends TransactionAction {

   private final STModel stModel;
   private final STArgument stArgument;
   private final STParameterKey stParameterKey;
   private final JComponent owner;

   public SetKVArgumentFromArgumentType(STModel stModel, STArgument stArgument, STParameterKey stParameterKey, JComponent owner) {
      super("Set " + stParameterKey.getName());
      this.stModel = stModel;
      this.stArgument = stArgument;
      this.stParameterKey = stParameterKey;
      this.owner = owner;
   }

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
      log.info("SetKVArgumentFromArgumentType" + " stModel" + " stArgument" + " stParameterKey" + " owner");

      final String argumentType = stParameterKey.getArgumentType();
      final STParameter stParameter = stArgument.getStParameter();

      final boolean argumentIsDefault = argumentType == null || argumentType.equals("Object") || argumentType.equals("String");
      if (argumentIsDefault) {
         final java.util.Optional<STTemplate> stTemplate = appModel().findFirstTemplateInArguments(stModel, stParameter);
         if (stTemplate.isPresent())
            appModel().setArgumentKV(stModel, stArgument, stParameterKey, appModel().newSTValue(stTemplate.get()));
         else
            input(owner, "New value", s -> appModel().setArgumentKV(stModel, stArgument, stParameterKey, s));
         return;
      }

      final STGroupModel stGroupModel = appModel().getSTGroup(stModel);
      final java.util.Optional<STTemplate> stTemplate = appModel().findSTTemplateFromArgumentType(argumentType, stGroupModel);
      if (stTemplate.isPresent()) {

         final java.util.List<STModel> stModelList = appModel().getModelsFor(stTemplate.get());
         if (stModelList.isEmpty())
            appModel().setArgumentKV(stModel, stArgument, stParameterKey, appModel().newSTValue(stTemplate.get()));
         else
            showEditor(owner, getSelectOrAddSTModelValue(stTemplate.get(), stModelList), (dialog, model) -> {
               appModel().setArgumentKV(stModel, stArgument, stParameterKey, model);
               dialog.dispose();
            });
         return;
      }

      final java.util.Set<STTemplate> stTemplatesWithInterface = appModel().findSTTemplatesWithInterface(argumentType, stGroupModel);
      if (stTemplatesWithInterface.isEmpty()) {

         final STEnum stEnum = appModel().findSTEnumByName(argumentType, stGroupModel);
         if (stEnum == null)
            input(owner, "New value", s -> appModel().setArgumentKV(stModel, stArgument, stParameterKey, s));
         else
            select(owner, stEnum.getValues().collect(java.util.stream.Collectors.toSet()), value -> appModel().setArgumentKV(stModel, stArgument, stParameterKey, value));
         return;
      }

      if (stTemplatesWithInterface.size() > 1)
         showEditor(owner, new nextgen.swing.SelectSTTemplate(stTemplatesWithInterface), (dialog, model) -> {
            appModel().setArgumentKV(stModel, stArgument, stParameterKey, model);
            dialog.dispose();
         });
      else
         appModel().setArgumentKV(stModel, stArgument, stParameterKey, stTemplatesWithInterface.iterator().next());
   }

}