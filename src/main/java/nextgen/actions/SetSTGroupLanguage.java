package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class SetSTGroupLanguage extends TransactionAction {

   private final JComponent owner;
   private final STGroupModel stGroup;

	public SetSTGroupLanguage(JComponent owner, STGroupModel stGroup) {
		super("Set Language");
		this.owner = owner;
		this.stGroup = stGroup;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("SetSTGroupLanguage" + " owner" + " stGroup");

      select(owner, appModel().getLanguageTypes(), stGroup::setLanguage);
   }

}