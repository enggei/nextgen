package nextgen.swing.forms;

import javax.swing.*;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.CellConstraints;

public class STEnumForm extends JPanel {

	JLabel lblName = new JLabel("name");
	JTextField txtName = new JTextField("");
	JLabel lblValues = new JLabel("values");
	nextgen.swing.table.STEnumValueTable tblValues = new nextgen.swing.table.STEnumValueTable();

	public STEnumForm() {
		setLayout(new FormLayout("left:1024:none", "center:pref:none, center:pref:none, center:200:grow"));
		final CellConstraints cc = new CellConstraints();
		add(lblName, cc.xywh(1, 1, 1, 1, "LEFT, TOP"));
		add(txtName, cc.xywh(1, 2, 1, 1, "FILL, FILL"));
		add(lblValues, cc.xywh(1, 3, 1, 1, "LEFT, TOP"));
		add(new JScrollPane(tblValues), cc.xywh(1, 3, 1, 1, "FILL, FILL"));
	}

	public JLabel getLblName() {
		return lblName;
	}

	public JTextField getTxtName() {
		return txtName;
	}

	public JLabel getLblValues() {
		return lblValues;
	}

	public nextgen.swing.table.STEnumValueTable getTblValues() {
		return tblValues;
	}


	public void modelToView(nextgen.model.STEnum model) { 
		txtName.setText(model.getName());
		tblValues.setContent(model.getValues());	
	}

	public void viewToModel(nextgen.model.STEnum model) {
		model.setName(txtName.getText());	
	}  
	/*

	columns 		"left:1024:none"

	rows 		 	"center:pref:none, center:pref:none, center:200:grow"

	*/
}  