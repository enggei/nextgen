package nextgen.swing.forms;

import javax.swing.*;

public class CrudPanel extends JPanel {

	JTextField txtvalue;
	JButton btndelete;
	JButton btntoClipboard;
	JButton btnfromClipboard;

	public CrudPanel() {
		setLayout(new com.jgoodies.forms.layout.FormLayout("fill:pref:grow, fill:120:none, fill:120:none, fill:120:none", "top:pref:none"));
	}

	public CrudPanel setTxtvalue(JTextField component) {
		add(this.txtvalue = component, new com.jgoodies.forms.layout.CellConstraints().xywh(1, 1, 1, 1, "FILL, FILL"));
		return this;
	}

	public CrudPanel setBtndelete(JButton component) {
		add(this.btndelete = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 1, 1, 1, "FILL, TOP"));
		return this;
	}

	public CrudPanel setBtntoClipboard(JButton component) {
		add(this.btntoClipboard = component, new com.jgoodies.forms.layout.CellConstraints().xywh(3, 1, 1, 1, "FILL, TOP"));
		return this;
	}

	public CrudPanel setBtnfromClipboard(JButton component) {
		add(this.btnfromClipboard = component, new com.jgoodies.forms.layout.CellConstraints().xywh(4, 1, 1, 1, "FILL, TOP"));
		return this;
	}



	/*

	 columns 	4	"fill:pref:grow, fill:120:none, fill:120:none, fill:120:none"

	 rows 		1 	"top:pref:none"

	 col 2 1 FILL pref grow
	 col 3 1 FILL 120 none
	 col 4 1 FILL 120 none
	 col 5 1 FILL 120 none
	 row 1 2 TOP pref none
	 cell 2 2 1 1 FILL FILL TextField value
	 cell 3 2 1 1 FILL TOP Button delete
	 cell 4 2 1 1 FILL TOP Button toClipboard
	 cell 5 2 1 1 FILL TOP Button fromClipboard

	*/	
}