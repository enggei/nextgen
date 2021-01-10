package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class GenerateSTGroupFromFile extends nextgen.actions.TransactionAction {

   private final STGroupFile stGroupFile;
   private final JComponent owner;

	public GenerateSTGroupFromFile(STGroupFile stGroupFile, JComponent owner) {
		super("Generate");
		this.stGroupFile = stGroupFile;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("GenerateSTGroupFromFile" + " stGroupFile" + " owner");

      stGroupFile.getIncomingFilesSTGroupModel().findFirst().ifPresent(stGroupModel -> {
      	final nextgen.model.parser.ParseResult parseResult = nextgen.st.STParser.parse(nextgen.st.STGenerator.toSTGroup(stGroupModel));

      	if (parseResult.getErrors().isEmpty()) {
      		final String packageName = stGroupFile.getPackageName().getValue();
      		final String path = stGroupFile.getPath().getValue();
      		new nextgen.st.STGenerator(appModel().getGeneratorSTGroup()).generateSTGroup(stGroupModel, packageName, path);

      	} else {
      		final StringBuilder errors = new StringBuilder();
      		parseResult.getErrors().forEach(stgError -> errors.append("\n").append(stgError.getType()).append(" ").append(stgError.getCharPosition()).append(" at line ").append(stgError.getLine()));
      		showError(owner, errors.toString());
      	}	
      });
   }

}