package nextgen.swing.forms;

import javax.swing.*;

public class SearchForm extends JPanel {

	JLabel lblsearch_JLabel;
	JLabel lblreplace_JLabel;
	JScrollPane scrresult_JScrollPane;
	JTextField txtsearch_JTextField;
	JTextField txtreplace_JTextField;
	JButton btnsearch_JButton;
	JButton btnreplace_JButton;

	public SearchForm() {
		setLayout(new com.jgoodies.forms.layout.FormLayout("left:PREF:none, left:PREF:grow, left:PREF:none", "fill:PREF:none, fill:PREF:none, fill:PREF:grow"));
	}

	public SearchForm setLblsearch(JLabel component) {
		if (component == null) return this;
		add(this.lblsearch_JLabel = component, new com.jgoodies.forms.layout.CellConstraints().xywh(1, 1, 1, 1, "FILL, FILL"));
		return this;
	}

	public SearchForm setLblreplace(JLabel component) {
		if (component == null) return this;
		add(this.lblreplace_JLabel = component, new com.jgoodies.forms.layout.CellConstraints().xywh(1, 2, 1, 1, "FILL, FILL"));
		return this;
	}

	public SearchForm setScrresult(JScrollPane component) {
		if (component == null) return this;
		add(this.scrresult_JScrollPane = component, new com.jgoodies.forms.layout.CellConstraints().xywh(1, 3, 3, 1, "FILL, FILL"));
		return this;
	}

	public SearchForm setTxtsearch(JTextField component) {
		if (component == null) return this;
		add(this.txtsearch_JTextField = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 1, 1, 1, "FILL, FILL"));
		return this;
	}

	public SearchForm setTxtreplace(JTextField component) {
		if (component == null) return this;
		add(this.txtreplace_JTextField = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 2, 1, 1, "FILL, FILL"));
		return this;
	}

	public SearchForm setBtnsearch(JButton component) {
		if (component == null) return this;
		add(this.btnsearch_JButton = component, new com.jgoodies.forms.layout.CellConstraints().xywh(3, 1, 1, 1, "FILL, FILL"));
		return this;
	}

	public SearchForm setBtnreplace(JButton component) {
		if (component == null) return this;
		add(this.btnreplace_JButton = component, new com.jgoodies.forms.layout.CellConstraints().xywh(3, 2, 1, 1, "FILL, FILL"));
		return this;
	}



	/*

	 columns 	3	"left:PREF:none, left:PREF:grow, left:PREF:none"

	 rows 		3 	"fill:PREF:none, fill:PREF:none, fill:PREF:grow"

	 col 2 1 LEFT PREF none
	 col 3 1 LEFT PREF grow
	 col 4 1 LEFT PREF none
	 row 1 2 FILL PREF none
	 row 1 3 FILL PREF none
	 row 1 4 FILL PREF grow
	 cell 2 2 1 1 FILL FILL Label search
	 cell 2 3 1 1 FILL FILL Label replace
	 cell 2 4 1 3 FILL FILL ScrollPane result
	 cell 3 2 1 1 FILL FILL TextField search
	 cell 3 3 1 1 FILL FILL TextField replace
	 cell 4 2 1 1 FILL FILL Button search
	 cell 4 3 1 1 FILL FILL Button replace

	*/	
}