package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class GenerateSTGroup extends TransactionAction {

   private final JComponent owner;
   private final STGroupModel stGroup;

	public GenerateSTGroup(JComponent owner, STGroupModel stGroup) {
		super("Generate STGroup");
		setIcon("gen");
		this.owner = owner;
		this.stGroup = stGroup;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("GenerateSTGroup" + " owner" + " stGroup");

      final nextgen.model.parser.ParseResult parseResult = nextgen.st.STParser.parse(nextgen.st.STGenerator.toSTGroup(stGroup));

      if (parseResult.getErrors().isEmpty()) {
         final nextgen.st.STGenerator stGenerator = new nextgen.st.STGenerator(appModel().getGeneratorSTGroup());
         stGroup.getFiles().forEach(stGroupFile -> {
            final String packageName = stGroupFile.getPackageName().getValue();
            final String path = stGroupFile.getPath().getValue();
            stGenerator.generateSTGroup(stGroup, packageName, path);
         });

      } else {
         final StringBuilder errors = new StringBuilder();
         parseResult.getErrors().forEach(stgError -> errors.append("\n").append(stgError.getType()).append(" ").append(stgError.getCharPosition()).append(" at line ").append(stgError.getLine()));
         showError(owner, errors.toString());
      }
   }

}