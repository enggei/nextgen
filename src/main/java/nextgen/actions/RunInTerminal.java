package nextgen.actions;

public class RunInTerminal extends nextgen.actions.TransactionAction {

   private final nextgen.model.STModel stModel;
   private final javax.swing.JComponent owner;

	public RunInTerminal(nextgen.model.STModel stModel, javax.swing.JComponent owner) {
		super("Run in Terminal");
		this.stModel = stModel;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      final String command = appModel().render(stModel);
      final java.io.File tempScript = createTempScript(command);

      javax.swing.SwingUtilities.invokeLater(() -> {
         try {
            System.out.println(tempScript.getAbsolutePath());

            final ProcessBuilder pb = new ProcessBuilder("bash", tempScript.toString());
            pb.inheritIO();
            Process process = pb.start();
            process.waitFor();
         } catch (java.io.IOException | InterruptedException e) {
            showError(owner, e);
         } finally {
            tempScript.delete();
         }
      });
   }

   public java.io.File createTempScript(String command) {

      try {
         java.io.File tempScript = java.io.File.createTempFile("script", null);
         java.io.Writer streamWriter = new java.io.OutputStreamWriter(new java.io.FileOutputStream(tempScript));
         java.io.PrintWriter printWriter = new java.io.PrintWriter(streamWriter);

         printWriter.println("#!/bin/bash");
         printWriter.println(command);
         printWriter.close();
         return tempScript;

      } catch (java.io.IOException e) {
         return null;
      }
   }
}