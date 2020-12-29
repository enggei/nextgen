package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class RunInTerminal extends TransactionAction {

   private final STModel stModel;
   private final JComponent owner;

	public RunInTerminal(STModel stModel, JComponent owner) {
		super("Run in Terminal");
		this.stModel = stModel;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("RunInTerminal" + " stModel" + " owner");

      final String command = appModel().render(stModel);
      final java.io.File tempScript = createTempScript(command);

      SwingUtilities.invokeLater(() -> {
         try {
            log.info(tempScript.getAbsolutePath());

            final ProcessBuilder pb = new ProcessBuilder("bash", tempScript.toString());
            pb.inheritIO();
            Process process = pb.start();
            process.waitFor();
         } catch (java.io.IOException | InterruptedException e) {
            showError(owner, e);
         } finally {
            final boolean deleted = tempScript.delete();
            if (!deleted) log.info("Could not delete " + tempScript.getAbsolutePath());
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