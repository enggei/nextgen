package nextgen.actions;

public class OpenTemplate extends TransactionAction {


   private final nextgen.st.domain.STTemplate stTemplate;

	public OpenTemplate(nextgen.st.domain.STTemplate stTemplate) {
		super("Open");
		this.stTemplate = stTemplate;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      nextgen.events.OpenSTTemplate.post(stTemplate);
   }

}