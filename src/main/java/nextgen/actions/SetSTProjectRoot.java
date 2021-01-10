package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class SetSTProjectRoot extends nextgen.actions.TransactionAction {

   private final STProject stProject;
   private final JComponent owner;

	public SetSTProjectRoot(STProject stProject, JComponent owner) {
		super("Change root");
		this.stProject = stProject;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("SetSTProjectRoot" + " stProject" + " owner");

      input(owner, "New Root", s -> {
         stProject.setRoot(s);
         appModel().setAllModelPaths(stProject, s.trim());
      });
   }

}