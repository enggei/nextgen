package nextgen.swing.forms;

import javax.swing.*;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.CellConstraints;

public class STArgumentForm extends JPanel {

	JLabel lblKeyValues = new JLabel("keyValues");
	nextgen.swing.table.STArgumentKVTable tblKeyValues = new nextgen.swing.table.STArgumentKVTable();

	public STArgumentForm() {
		setLayout(new FormLayout("left:2400:none", "center:200:grow"));
		final CellConstraints cc = new CellConstraints();
		add(lblKeyValues, cc.xywh(1, 1, 1, 1, "LEFT, TOP"));
		add(new JScrollPane(tblKeyValues), cc.xywh(1, 1, 1, 1, "FILL, FILL"));
	}

	public JLabel getLblKeyValues() {
		return lblKeyValues;
	}

	public nextgen.swing.table.STArgumentKVTable getTblKeyValues() {
		return tblKeyValues;
	}


	public void modelToView(nextgen.model.STArgument model) { 
		tblKeyValues.setContent(model.getKeyValues());	
	}

	public void viewToModel(nextgen.model.STArgument model) {
		
	}  
	/*

	columns 		"left:2400:none"

	rows 		 	"center:200:grow"

	*/
}  