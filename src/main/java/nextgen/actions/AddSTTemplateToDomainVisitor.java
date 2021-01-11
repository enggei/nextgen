package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;
import java.util.stream.Collectors;

public class AddSTTemplateToDomainVisitor extends nextgen.actions.TransactionAction {

   private final nextgen.model.DomainVisitor domainVisitor;
   private final JComponent owner;

	public AddSTTemplateToDomainVisitor(nextgen.model.DomainVisitor domainVisitor, JComponent owner) {
		super("Add Template");
		this.domainVisitor = domainVisitor;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("AddSTTemplateToDomainVisitor" + " domainVisitor" + " owner");

      final javax.swing.JTextField txtSearch = newTextField();
      final nextgen.swing.table.STTemplateTable result = new nextgen.swing.table.STTemplateTable();

      final nextgen.swing.forms.SearchForm searchForm = new nextgen.swing.forms.SearchForm();
      searchForm.setSearch(newLabel("Search"));
      searchForm.setSearch(txtSearch);
      searchForm.setResult(newJScrollPane(result));
      searchForm.setSearch(newButton("Search", tx -> {
         
         result.clear();
         
         final String searchTerm = txtSearch.getText().trim().toLowerCase();
         final java.util.List<STTemplate> stTemplates = new java.util.ArrayList<>();
         appModel().db.findAllSTTemplate().filter(stTemplate -> stTemplate.getName().toLowerCase().contains(searchTerm)).forEach(stTemplates::add);
         
         result.setContent(stTemplates);
      }));

      showDialog(owner, searchForm,  "Search for STTemplate", jDialog -> {
         result.getSelectedValues().forEach(stTemplate -> appModel().add(domainVisitor, stTemplate));
         jDialog.dispose();
      });
   }

}