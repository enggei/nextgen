package nextgen.swing;

import nextgen.actions.*;
import nextgen.events.ModelNavigatorSTModelTreeNodeClicked;
import nextgen.model.*;

import javax.swing.*;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import static nextgen.utils.SwingUtil.*;

public class STModelEditorText extends BaseEditor<STModel> {

   private final org.fife.ui.rsyntaxtextarea.RSyntaxTextArea txtEditor = newRSyntaxTextArea(20, 80);

   public STModelEditorText() {

      txtEditor.setEditable(false);
      txtEditor.addKeyListener(getEditorKeyListener());

      add(newRTextScrollPane(txtEditor), java.awt.BorderLayout.CENTER);

      addComponentListener(new java.awt.event.ComponentAdapter() {
         @Override
         public void componentShown(java.awt.event.ComponentEvent e) {
            if (getModel() == null) return;
            setModel(getModel());
         }
      });
   }

   @Override
   public void setModel(STModel stModel) {
      txtEditor.setText(appModel().render(stModel));
      txtEditor.setCaretPosition(0);
      txtEditor.setEditable(false);
      txtEditor.setSyntaxEditingStyle(appModel().getSTGroup(stModel).getLanguage("text/plain"));

      final javax.swing.JPopupMenu pop = txtEditor.getPopupMenu();
      pop.removeAll();
      pop.add(newAction("To Clipboard", actionEvent -> toClipboard()));

      JMenu menu = new JMenu("Values");
      pop.add(menu);
      addToMenu(menu, stModel);
   }

   private void addToMenu(JMenu menu, STModel stModel) {

      menu.add(newAction("Open", actionEvent -> appModel().doLaterInTransaction(tx -> {
         nextgen.events.STModelSelected.post(stModel);
         ModelNavigatorSTModelTreeNodeClicked.post(stModel);
      })));

      appModel().getSTParameters(stModel).forEach(parameterArguments -> {

         final STParameter stParameter = parameterArguments.parameter();
         final List<STArgument> arguments = parameterArguments.arguments();
         final boolean hasArguments = !arguments.isEmpty();

         final JMenu parameterMenu = new JMenu(stParameter.getName());
         switch (stParameter.getType()) {
            case SINGLE:
               if (hasArguments) parameterMenu.add(new nextgen.actions.STValueToClipboard(arguments.get(0).getValue()).setName(appModel().render(arguments.get(0), 30)));
               parameterMenu.add(new nextgen.actions.SetArgumentFromArgumentType(stModel, stParameter, txtEditor));
               parameterMenu.add(new nextgen.actions.SetArgumentFromInput(stModel, stParameter, txtEditor));
               parameterMenu.add(new nextgen.actions.SetArgumentFromClipboard(stModel, stParameter));
               if (appModel().isBoolean(stParameter)) parameterMenu.add(new nextgen.actions.SetArgumentToTrue(stModel, stParameter));
               if (hasArguments) parameterMenu.add(new nextgen.actions.DeleteSTArgument(arguments.get(0), txtEditor));
               break;
            case LIST:
               parameterMenu.add(new nextgen.actions.AddArgumentFromArgumentType(stModel, stParameter, txtEditor));
               parameterMenu.add(new nextgen.actions.AddArgumentFromInput(stModel, stParameter, txtEditor));
               parameterMenu.add(new nextgen.actions.AddArgumentFromClipboard(stModel, stParameter));
               parameterMenu.add(new nextgen.actions.DeleteSTArguments(txtEditor, stParameter, stModel));

               final AtomicInteger listIndex = new AtomicInteger(0);
               arguments.stream().filter(stArgument -> stArgument.getValue()!=null).forEach(stArgument -> {
                  listIndex.incrementAndGet();
                  final JMenu listArgumentMenu = new JMenu(listIndex.toString());
                  switch (stArgument.getValue().getType()) {
                     case STMODEL:
                        addToMenu(listArgumentMenu, stArgument.getValue().getStModel());
                        break;
                     case PRIMITIVE:
                        listArgumentMenu.add(new nextgen.actions.STValueToClipboard(stArgument.getValue()).setName(appModel().render(stArgument.getValue(), 30)));
                        listArgumentMenu.add(new DeleteSTArgument(stArgument, txtEditor));
                        break;
                     case ENUM:
                        break;
                  }
                  parameterMenu.add(listArgumentMenu);
               });
               break;
            case KVLIST:
               parameterMenu.add(new nextgen.actions.AddKVArguments(stParameter, stModel, txtEditor));
               final AtomicInteger kvListIndex = new AtomicInteger(0);
               arguments.forEach(stArgument -> {
                  kvListIndex.incrementAndGet();
                  final JMenu kvListArgument = new JMenu(kvListIndex.toString());

                  stParameter.getKeysSorted().forEach(stParameterKey -> {
                     final JMenu parameterKeyMenu = new JMenu(stParameterKey.getName());
                     final Optional<STArgumentKV> argumentKV = stArgument.getKeyValues().filter(stArgumentKV -> stArgumentKV.getStParameterKey().equals(stParameterKey)).findFirst();
                     if (argumentKV.isPresent() && argumentKV.get().getValue() != null) {
                        switch (argumentKV.get().getValue().getType()) {

                           case STMODEL:
                              addToMenu(kvListArgument, argumentKV.get().getValue().getStModel());
                              break;
                           case PRIMITIVE:
                              parameterKeyMenu.add(new nextgen.actions.STValueToClipboard(argumentKV.get().getValue()).setName(appModel().render(argumentKV.get(), 30)));
                              parameterKeyMenu.add(new DeleteKV(argumentKV.get(), txtEditor));
                              break;
                           case ENUM:
                              break;
                        }
                     } else {
                        parameterKeyMenu.add(new SetKVArgumentFromArgumentType(stModel, stArgument, stParameterKey, txtEditor));
                        parameterKeyMenu.add(new SetKVArgumentFromInput(stModel, stArgument, stParameterKey, txtEditor));
                        parameterKeyMenu.add(new SetKVArgumentFromClipboard(stModel, stArgument, stParameterKey));
                     }
                     kvListArgument.add(parameterKeyMenu);
                  });

                  kvListArgument.add(new DeleteSTArgument(stArgument, txtEditor));
                  parameterMenu.add(kvListArgument);
               });
               break;
         }

         menu.add(parameterMenu);
      });
   }

   private void toClipboard() {
      nextgen.utils.SwingUtil.toClipboard(txtEditor.getText().trim());
   }

}