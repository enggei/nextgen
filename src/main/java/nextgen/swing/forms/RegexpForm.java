package nextgen.swing.forms;

import javax.swing.*;

public class RegexpForm extends JPanel {

	JTextArea txtAreasource;
	JLabel lblPattern;
	JTextField txtpattern;
	JLabel lblInsert;
	JTextField txtinsert;
	JRadioButton rdreplace;
	JRadioButton rdinsertAfter;
	JRadioButton rdinsertBefore;
	JTextArea txtAreatarget;
	JRadioButton rdinsertLineAfter;
	JRadioButton rdinsertLineBefore;
	JRadioButton rdremove;
	JRadioButton rdremoveLine;
	JRadioButton rdremoveLineBefore;
	JRadioButton rdremoveLineAfter;
	JCheckBox chkcompressLines;
	JCheckBox chkshowDifference;
	JCheckBox chkkeepOnlyMatches;
	JButton btnsetSource;

	public RegexpForm() {
		setLayout(new com.jgoodies.forms.layout.FormLayout("left:pref:none, left:pref:none, left:pref:none", "top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none"));
	}

	public RegexpForm setTxtAreasource(JTextArea component) {
		add(this.txtAreasource = component, new com.jgoodies.forms.layout.CellConstraints().xywh(1, 1, 1, 17, "LEFT, TOP"));
		return this;
	}

	public RegexpForm setLblPattern(JLabel component) {
		add(this.lblPattern = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 1, 1, 1, "LEFT, TOP"));
		return this;
	}

	public RegexpForm setTxtpattern(JTextField component) {
		add(this.txtpattern = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 2, 1, 1, "LEFT, TOP"));
		return this;
	}

	public RegexpForm setLblInsert(JLabel component) {
		add(this.lblInsert = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 3, 1, 1, "LEFT, TOP"));
		return this;
	}

	public RegexpForm setTxtinsert(JTextField component) {
		add(this.txtinsert = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 4, 1, 1, "LEFT, TOP"));
		return this;
	}

	public RegexpForm setRdreplace(JRadioButton component) {
		add(this.rdreplace = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 5, 1, 1, "LEFT, TOP"));
		return this;
	}

	public RegexpForm setRdinsertAfter(JRadioButton component) {
		add(this.rdinsertAfter = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 6, 1, 1, "LEFT, TOP"));
		return this;
	}

	public RegexpForm setRdinsertBefore(JRadioButton component) {
		add(this.rdinsertBefore = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 7, 1, 1, "LEFT, TOP"));
		return this;
	}

	public RegexpForm setTxtAreatarget(JTextArea component) {
		add(this.txtAreatarget = component, new com.jgoodies.forms.layout.CellConstraints().xywh(3, 1, 1, 17, "LEFT, TOP"));
		return this;
	}

	public RegexpForm setRdinsertLineAfter(JRadioButton component) {
		add(this.rdinsertLineAfter = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 8, 1, 1, "LEFT, TOP"));
		return this;
	}

	public RegexpForm setRdinsertLineBefore(JRadioButton component) {
		add(this.rdinsertLineBefore = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 9, 1, 1, "LEFT, TOP"));
		return this;
	}

	public RegexpForm setRdremove(JRadioButton component) {
		add(this.rdremove = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 10, 1, 1, "LEFT, TOP"));
		return this;
	}

	public RegexpForm setRdremoveLine(JRadioButton component) {
		add(this.rdremoveLine = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 11, 1, 1, "LEFT, TOP"));
		return this;
	}

	public RegexpForm setRdremoveLineBefore(JRadioButton component) {
		add(this.rdremoveLineBefore = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 12, 1, 1, "LEFT, TOP"));
		return this;
	}

	public RegexpForm setRdremoveLineAfter(JRadioButton component) {
		add(this.rdremoveLineAfter = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 13, 1, 1, "LEFT, TOP"));
		return this;
	}

	public RegexpForm setChkcompressLines(JCheckBox component) {
		add(this.chkcompressLines = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 14, 1, 1, "LEFT, TOP"));
		return this;
	}

	public RegexpForm setChkshowDifference(JCheckBox component) {
		add(this.chkshowDifference = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 15, 1, 1, "LEFT, TOP"));
		return this;
	}

	public RegexpForm setChkkeepOnlyMatches(JCheckBox component) {
		add(this.chkkeepOnlyMatches = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 16, 1, 1, "LEFT, TOP"));
		return this;
	}

	public RegexpForm setBtnsetSource(JButton component) {
		add(this.btnsetSource = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 17, 1, 1, "FILL, TOP"));
		return this;
	}



	/*

	 columns 	3	"left:pref:none, left:pref:none, left:pref:none"

	 rows 		17 	"top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none"

	 col 2 1 LEFT pref none
	 col 3 1 LEFT pref none
	 col 4 1 LEFT pref none
	 row 1 2 TOP pref none
	 row 1 3 TOP pref none
	 row 1 4 TOP pref none
	 row 1 5 TOP pref none
	 row 1 6 TOP pref none
	 row 1 7 TOP pref none
	 row 1 8 TOP pref none
	 row 1 9 TOP pref none
	 row 1 10 TOP pref none
	 row 1 11 TOP pref none
	 row 1 12 TOP pref none
	 row 1 13 TOP pref none
	 row 1 14 TOP pref none
	 row 1 15 TOP pref none
	 row 1 16 TOP pref none
	 row 1 17 TOP pref none
	 row 1 18 TOP pref none
	 cell 2 2 17 1 LEFT TOP TextArea source
	 cell 3 2 1 1 LEFT TOP Label Pattern
	 cell 3 3 1 1 LEFT TOP TextField pattern
	 cell 3 4 1 1 LEFT TOP Label Insert
	 cell 3 5 1 1 LEFT TOP TextField insert
	 cell 3 6 1 1 LEFT TOP RadioButton replace
	 cell 3 7 1 1 LEFT TOP RadioButton insertAfter
	 cell 3 8 1 1 LEFT TOP RadioButton insertBefore
	 cell 4 2 17 1 LEFT TOP TextArea target
	 cell 3 9 1 1 LEFT TOP RadioButton insertLineAfter
	 cell 3 10 1 1 LEFT TOP RadioButton insertLineBefore
	 cell 3 11 1 1 LEFT TOP RadioButton remove
	 cell 3 12 1 1 LEFT TOP RadioButton removeLine
	 cell 3 13 1 1 LEFT TOP RadioButton removeLineBefore
	 cell 3 14 1 1 LEFT TOP RadioButton removeLineAfter
	 cell 3 15 1 1 LEFT TOP CheckBox compressLines
	 cell 3 16 1 1 LEFT TOP CheckBox showDifference
	 cell 3 17 1 1 LEFT TOP CheckBox keepOnlyMatches
	 cell 3 18 1 1 FILL TOP Button setSource

	*/	
}