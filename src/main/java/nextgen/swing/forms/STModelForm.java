package nextgen.swing.forms;

import javax.swing.*;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.CellConstraints;

public class STModelForm extends JPanel {

	JLabel lblFiles = new JLabel("files");
	nextgen.swing.table.STFileTable tblFiles = new nextgen.swing.table.STFileTable();
	JLabel lblArguments = new JLabel("arguments");
	nextgen.swing.table.STArgumentTable tblArguments = new nextgen.swing.table.STArgumentTable();

	public STModelForm() {
		setLayout(new FormLayout("left:1024:none", "center:200:grow, center:200:grow"));
		final CellConstraints cc = new CellConstraints();
		add(lblFiles, cc.xywh(1, 1, 1, 1, "LEFT, TOP"));
		add(new JScrollPane(tblFiles), cc.xywh(1, 1, 1, 1, "FILL, FILL"));
		add(lblArguments, cc.xywh(1, 2, 1, 1, "LEFT, TOP"));
		add(new JScrollPane(tblArguments), cc.xywh(1, 2, 1, 1, "FILL, FILL"));
	}

	public JLabel getLblFiles() {
		return lblFiles;
	}

	public nextgen.swing.table.STFileTable getTblFiles() {
		return tblFiles;
	}

	public JLabel getLblArguments() {
		return lblArguments;
	}

	public nextgen.swing.table.STArgumentTable getTblArguments() {
		return tblArguments;
	}


	public void modelToView(nextgen.model.STModel model) { 
		tblFiles.setContent(model.getFiles());
		tblArguments.setContent(model.getArguments());	
	}

	public void viewToModel(nextgen.model.STModel model) {
		
	}  
	/*

	columns 		"left:1024:none"

	rows 		 	"center:200:grow, center:200:grow"

	*/
}  