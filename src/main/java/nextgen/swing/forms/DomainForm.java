package nextgen.swing.forms;

import javax.swing.*;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.CellConstraints;

public class DomainForm extends JPanel {

	JLabel lblName = new JLabel("name");
	JTextField txtName = new JTextField("");
	JLabel lblEntities = new JLabel("entities");
	nextgen.swing.table.DomainEntityTable tblEntities = new nextgen.swing.table.DomainEntityTable();
	JLabel lblRelations = new JLabel("relations");
	nextgen.swing.table.DomainRelationTable tblRelations = new nextgen.swing.table.DomainRelationTable();
	JLabel lblVisitors = new JLabel("visitors");
	nextgen.swing.table.DomainVisitorTable tblVisitors = new nextgen.swing.table.DomainVisitorTable();

	public DomainForm() {
		setLayout(new FormLayout("left:2400:none", "center:pref:none, center:pref:none, center:200:grow, center:200:grow, center:200:grow"));
		final CellConstraints cc = new CellConstraints();
		add(lblName, cc.xywh(1, 1, 1, 1, "LEFT, TOP"));
		add(txtName, cc.xywh(1, 2, 1, 1, "FILL, FILL"));
		add(lblEntities, cc.xywh(1, 3, 1, 1, "LEFT, TOP"));
		add(new JScrollPane(tblEntities), cc.xywh(1, 3, 1, 1, "FILL, FILL"));
		add(lblRelations, cc.xywh(1, 4, 1, 1, "LEFT, TOP"));
		add(new JScrollPane(tblRelations), cc.xywh(1, 4, 1, 1, "FILL, FILL"));
		add(lblVisitors, cc.xywh(1, 5, 1, 1, "LEFT, TOP"));
		add(new JScrollPane(tblVisitors), cc.xywh(1, 5, 1, 1, "FILL, FILL"));
	}

	public JLabel getLblName() {
		return lblName;
	}

	public JTextField getTxtName() {
		return txtName;
	}

	public JLabel getLblEntities() {
		return lblEntities;
	}

	public nextgen.swing.table.DomainEntityTable getTblEntities() {
		return tblEntities;
	}

	public JLabel getLblRelations() {
		return lblRelations;
	}

	public nextgen.swing.table.DomainRelationTable getTblRelations() {
		return tblRelations;
	}

	public JLabel getLblVisitors() {
		return lblVisitors;
	}

	public nextgen.swing.table.DomainVisitorTable getTblVisitors() {
		return tblVisitors;
	}


	public void modelToView(nextgen.model.Domain model) { 
		txtName.setText(model.getName());
		tblEntities.setContent(model.getEntities());
		tblRelations.setContent(model.getRelations());
		tblVisitors.setContent(model.getVisitors());	
	}

	public void viewToModel(nextgen.model.Domain model) {
		model.setName(txtName.getText());	
	}  
	/*

	columns 		"left:2400:none"

	rows 		 	"center:pref:none, center:pref:none, center:200:grow, center:200:grow, center:200:grow"

	*/
}  