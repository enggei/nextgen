package nextgen.swing.forms;

import javax.swing.*;

public class SearchForm extends javax.swing.JPanel {

	// columns 	3	"left:PREF:none, left:PREF:grow, left:PREF:none"
	// rows 		3 	"fill:PREF:none, fill:PREF:none, fill:PREF:none"

	JLabel lblsearch;
	JLabel lblreplace;
	JScrollPane scrresult;
	JTextField txtsearch;
	JTextField txtreplace;
	JButton btnsearch;
	JButton btnreplace;

	public SearchForm() {
		setLayout(new com.jgoodies.forms.layout.FormLayout("left:PREF:none, left:PREF:grow, left:PREF:none", "fill:PREF:none, fill:PREF:none, fill:PREF:none"));
	}

	public SearchForm setLblsearch(JLabel component) {
		add(this.lblsearch = component, new com.jgoodies.forms.layout.CellConstraints().xywh(1, 1, 1, 1, "fill, fill"));
		return this;
	}

	public SearchForm setLblreplace(JLabel component) {
		add(this.lblreplace = component, new com.jgoodies.forms.layout.CellConstraints().xywh(1, 2, 1, 1, "fill, fill"));
		return this;
	}

	public SearchForm setScrresult(JScrollPane component) {
		add(this.scrresult = component, new com.jgoodies.forms.layout.CellConstraints().xywh(1, 3, 3, 1, "fill, fill"));
		return this;
	}

	public SearchForm setTxtsearch(JTextField component) {
		add(this.txtsearch = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 1, 1, 1, "fill, fill"));
		return this;
	}

	public SearchForm setTxtreplace(JTextField component) {
		add(this.txtreplace = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 2, 1, 1, "fill, fill"));
		return this;
	}

	public SearchForm setBtnsearch(JButton component) {
		add(this.btnsearch = component, new com.jgoodies.forms.layout.CellConstraints().xywh(3, 1, 1, 1, "fill, fill"));
		return this;
	}

	public SearchForm setBtnreplace(JButton component) {
		add(this.btnreplace = component, new com.jgoodies.forms.layout.CellConstraints().xywh(3, 2, 1, 1, "fill, fill"));
		return this;
	}

}