package nextgen.swing.forms;

import javax.swing.*;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.CellConstraints;

public class STProjectForm extends JPanel {

	JLabel lblName = new JLabel("name");
	JTextField txtName = new JTextField("");
	JLabel lblRoot = new JLabel("root");
	JTextField txtRoot = new JTextField("");
	JLabel lblModels = new JLabel("models");
	nextgen.swing.table.STModelTable tblModels = new nextgen.swing.table.STModelTable();
	JLabel lblValues = new JLabel("values");
	nextgen.swing.table.STValueTable tblValues = new nextgen.swing.table.STValueTable();

	public STProjectForm() {
		setLayout(new FormLayout("left:1024:none", "center:pref:none, center:pref:none, center:pref:none, center:pref:none, center:200:grow, center:200:grow"));
		final CellConstraints cc = new CellConstraints();
		add(lblName, cc.xywh(1, 1, 1, 1, "LEFT, TOP"));
		add(txtName, cc.xywh(1, 2, 1, 1, "FILL, FILL"));
		add(lblRoot, cc.xywh(1, 3, 1, 1, "LEFT, TOP"));
		add(txtRoot, cc.xywh(1, 4, 1, 1, "FILL, FILL"));
		add(lblModels, cc.xywh(1, 5, 1, 1, "LEFT, TOP"));
		add(new JScrollPane(tblModels), cc.xywh(1, 5, 1, 1, "FILL, FILL"));
		add(lblValues, cc.xywh(1, 6, 1, 1, "LEFT, TOP"));
		add(new JScrollPane(tblValues), cc.xywh(1, 6, 1, 1, "FILL, FILL"));
	}

	public JLabel getLblName() {
		return lblName;
	}

	public JTextField getTxtName() {
		return txtName;
	}

	public JLabel getLblRoot() {
		return lblRoot;
	}

	public JTextField getTxtRoot() {
		return txtRoot;
	}

	public JLabel getLblModels() {
		return lblModels;
	}

	public nextgen.swing.table.STModelTable getTblModels() {
		return tblModels;
	}

	public JLabel getLblValues() {
		return lblValues;
	}

	public nextgen.swing.table.STValueTable getTblValues() {
		return tblValues;
	}


	public void modelToView(nextgen.model.STProject model) { 
		txtName.setText(model.getName());
		txtRoot.setText(model.getRoot());
		tblModels.setContent(model.getModels());
		tblValues.setContent(model.getValues());	
	}

	public void viewToModel(nextgen.model.STProject model) {
		model.setName(txtName.getText());
		model.setRoot(txtRoot.getText());	
	}  
	/*

	columns 		"left:1024:none"

	rows 		 	"center:pref:none, center:pref:none, center:pref:none, center:pref:none, center:200:grow, center:200:grow"

	*/
}  