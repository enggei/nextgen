package nextgen.swing.forms;

import javax.swing.*;

public class RegexpForm extends JPanel {

	/*

	 columns 	3	"left:PREF:none, left:PREF:grow, left:PREF:none"

	 rows 		3 	"fill:PREF:none, fill:PREF:none, fill:PREF:none"

	 col 2 1 LEFT PREF none
	 col 3 1 LEFT PREF grow
	 col 4 1 LEFT PREF none
	 row 1 2 FILL PREF none
	 row 1 3 FILL PREF none
	 row 1 4 FILL PREF none
	 cell 2 2 1 1 FILL FILL Label search
	 cell 2 3 1 1 FILL FILL Label replace
	 cell 2 4 1 3 FILL FILL ScrollPane result
	 cell 3 2 1 1 FILL FILL TextField search
	 cell 3 3 1 1 FILL FILL TextField replace
	 cell 3 4 1 1 FILL FILL NONE null
	 cell 4 2 1 1 FILL FILL Button search
	 cell 4 3 1 1 FILL FILL Button replace
	 cell 4 4 1 1 FILL FILL NONE null

	*/	
	JLabel lblsearch;
	JLabel lblreplace;
	JScrollPane scrresult;
	JTextField txtsearch;
	JTextField txtreplace;
	JButton btnsearch;
	JButton btnreplace;

	public RegexpForm() {
		setLayout(new com.jgoodies.forms.layout.FormLayout("left:PREF:none, left:PREF:grow, left:PREF:none", "fill:PREF:none, fill:PREF:none, fill:PREF:none"));
	}

	public RegexpForm setLblsearch(JLabel component) {
		add(this.lblsearch = component, new com.jgoodies.forms.layout.CellConstraints().xywh(1, 1, 1, 1, "FILL, FILL"));
		return this;
	}

	public RegexpForm setLblreplace(JLabel component) {
		add(this.lblreplace = component, new com.jgoodies.forms.layout.CellConstraints().xywh(1, 2, 1, 1, "FILL, FILL"));
		return this;
	}

	public RegexpForm setScrresult(JScrollPane component) {
		add(this.scrresult = component, new com.jgoodies.forms.layout.CellConstraints().xywh(1, 3, 3, 1, "FILL, FILL"));
		return this;
	}

	public RegexpForm setTxtsearch(JTextField component) {
		add(this.txtsearch = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 1, 1, 1, "FILL, FILL"));
		return this;
	}

	public RegexpForm setTxtreplace(JTextField component) {
		add(this.txtreplace = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 2, 1, 1, "FILL, FILL"));
		return this;
	}

	public RegexpForm setBtnsearch(JButton component) {
		add(this.btnsearch = component, new com.jgoodies.forms.layout.CellConstraints().xywh(3, 1, 1, 1, "FILL, FILL"));
		return this;
	}

	public RegexpForm setBtnreplace(JButton component) {
		add(this.btnreplace = component, new com.jgoodies.forms.layout.CellConstraints().xywh(3, 2, 1, 1, "FILL, FILL"));
		return this;
	}

}