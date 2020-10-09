package nextgen.st;

import nextgen.st.domain.*;
import nextgen.st.model.STArgument;
import nextgen.st.model.STModel;

import javax.swing.*;
import java.awt.*;
import java.util.*;

import static nextgen.utils.SwingUtil.newTextField;

public class STModelEditorForm extends JPanel {

   public STModelEditorForm(STModel model) {
      super(new BorderLayout());
      final Map<String, JTextField> fieldMap = new LinkedHashMap<>();
      final Map<String, STParameter> parameterMap = new LinkedHashMap<>();
      final Map<String, STArgument> argumentMap = new LinkedHashMap<>();

      final STTemplate stTemplate = appModel().db.getSTTemplate(model);

      stTemplate.getParameters()
            .filter(stParameter -> stParameter.getType().equals(STParameterType.SINGLE))
            .filter(stParameter -> stParameter.getArgumentType().equals("String") || stParameter.getArgumentType().equals("Object"))
            .forEach(stParameter -> {
               final Optional<STArgument> argument = model.getArguments()
                     .filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
                     .findFirst();
               final String content = argument.isPresent() ? appModel().render(argument.get()) : "";
               final JTextField textField = newTextField(content, 15);
               fieldMap.put(stParameter.getName(), textField);
               parameterMap.put(stParameter.getName(), stParameter);
               argument.ifPresent(stArgument -> argumentMap.put(stParameter.getName(), stArgument));

               textField.addActionListener(actionEvent -> appModel().doInTransaction(transaction -> {
                  final STArgument stArgument = argumentMap.get(stParameter.getName());
                  if (stArgument == null) {
                     model.addArguments(appModel().newSTArgument(stParameter, appModel().newSTValue(textField.getText().trim())));
                  } else {
                     stArgument.getValue()
                           .setValue(textField.getText()
                                 .trim());
                  }
               }));
            });

      final JPanel inputPanel = new JPanel(new GridLayout(fieldMap.size(), 2));
      inputPanel.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
      for (Map.Entry<String, JTextField> fieldEntry : fieldMap.entrySet()) {
         inputPanel.add(new JLabel(fieldEntry.getKey()));
         inputPanel.add(fieldEntry.getValue());
      }

      add(inputPanel, BorderLayout.NORTH);
   }

   private STAppPresentationModel appModel() {
      return nextgen.swing.AppModel.getInstance().getSTAppPresentationModel();
   }
}