package tmp.maven;

import javax.swing.JComponent;

public class ImportDependency extends nextgen.actions.TransactionAction {

   private final JComponent owner;

	public ImportDependency(JComponent owner) {
		super("ImportDependency");
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
   	log.info("ImportDependency" + " owner");

      input(owner, "Dependency", xml -> {
         final nextgen.model.STTemplate stTemplate = appModel().db.findSTTemplateByUuid("68f2245d-08e1-42db-aafa-7245a5eda5b0");
         final nextgen.model.STModel stModel = appModel().db.newSTModel().setStTemplate(stTemplate);
         stTemplate.getParameters().forEach(stParameter -> {
            final String value = parseDependency(stParameter.getName(), xml);
            if (value == null) return;

            final nextgen.model.STValue stValue = appModel().db.newSTValue(value);
            final nextgen.model.STArgument stArgument = appModel().db.newSTArgument(stParameter, stValue);
            stModel.addArguments(stArgument);
         });
         nextgen.events.NewSTModel.post(stModel, appModel().getSTGroup(stTemplate), stTemplate);
      });
   }

   private static String parseDependency(String element, String text) {
      final java.util.regex.Pattern compile = java.util.regex.Pattern.compile("<" + element + ">(.+)</" + element + ">", java.util.regex.Pattern.CASE_INSENSITIVE);
      final java.util.regex.Matcher matcher = compile.matcher(text.trim().toLowerCase());
      if (matcher.find()) return matcher.group(1);
      return null;
   }
}