package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;
import java.util.stream.Collectors;

import org.stringtemplate.v4.*;

public class DomainVisitorAssistant extends nextgen.actions.TransactionAction {

   private final nextgen.model.DomainVisitor domainVisitor;
   private final org.fife.ui.rsyntaxtextarea.RSyntaxTextArea textArea;

	public DomainVisitorAssistant(nextgen.model.DomainVisitor domainVisitor, org.fife.ui.rsyntaxtextarea.RSyntaxTextArea textArea) {
		super("Insert");
		this.domainVisitor = domainVisitor;
		this.textArea = textArea;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("DomainVisitorAssistant" + " domainVisitor" + " textArea");

   	final java.util.Set<String> strings = new java.util.TreeSet<>();


		final nextgen.model.Domain domain = domainVisitor.getIncomingDomain();

		domainVisitor.getTemplates().forEach(stTemplate -> {

		});


		select(textArea, strings, s -> javax.swing.SwingUtilities.invokeLater(() -> textArea.append("\n" + s + "\n")));
	}
}