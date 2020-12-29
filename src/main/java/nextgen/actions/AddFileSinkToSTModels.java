package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class AddFileSinkToSTModels extends TransactionAction {

   private final STTemplate stTemplate;
   private final java.util.List<STModel> stModels;
   private final JComponent owner;

	public AddFileSinkToSTModels(STTemplate stTemplate, java.util.List<STModel> stModels, JComponent owner) {
		super("Add File Sink");
		this.stTemplate = stTemplate;
		this.stModels = stModels;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("AddFileSinkToSTModels" + " stTemplate" + " stModels" + " owner");

      final String[] fileTypes = appModel().getFileTypes();
      final String[] pathTypes = appModel().getAllPathTypes();

      final java.util.Map<String, STParameter> parameterMap = new java.util.LinkedHashMap<>();
      final java.util.List<String> nameOptions = stTemplate.getParametersSorted()
            .filter(stParameter -> stParameter.getType().equals(STParameterType.SINGLE))
            .map(stParameter -> {
               parameterMap.put(stParameter.getName(), stParameter);
               return stParameter.getName();
            })
            .sorted(String::compareToIgnoreCase)
            .collect(java.util.stream.Collectors.toList());

      final java.util.LinkedHashMap<String, JTextField> fieldMap = new java.util.LinkedHashMap<>();
      fieldMap.put("name", newTextField("", 15, nameOptions, 0));
      fieldMap.put("type", newTextField(15, fileTypes));
      fieldMap.put("path", newTextField(15, pathTypes));
      fieldMap.put("package", newTextField("", 15));

      final JPanel inputPanel = nextgen.swing.ComponentFactory.newJPanel(new java.awt.GridLayout(fieldMap.size(), 2));
      inputPanel.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));

      for (java.util.Map.Entry<String, JTextField> fieldEntry : fieldMap.entrySet()) {
         inputPanel.add(newLabel(fieldEntry.getKey()));
         inputPanel.add(fieldEntry.getValue());
      }

      showDialog(owner, inputPanel, "New FileSink", jDialog -> {
         final STParameter stParameter = parameterMap.get(fieldMap.get("name").getText().trim());
         final String type = fieldMap.get("type").getText().trim();
         final String path = fieldMap.get("path").getText().trim();
         final String packageName = fieldMap.get("package").getText().trim();

         for (STModel stModel : stModels) {
            stModel.getArgumentsSorted()
                  .filter(stArgument -> stArgument.getStParameter().equals(stParameter))
                  .findFirst()
                  .ifPresent(stArgument -> appModel().addFile(stModel, appModel().newSTFile(appModel().render(stArgument), packageName, path, type)));
         }
         SwingUtilities.invokeLater(jDialog::dispose);
      });
   }

}