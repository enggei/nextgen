package nextgen.swing.forms;

import javax.swing.*;

public class RegexpForm extends JPanel {

	JComponent compsource;
	JLabel lblPattern;
	JTextField txtpattern;
	JLabel lblInsert;
	JTextField txtinsert;
	JRadioButton rdreplace;
	JRadioButton rdinsertAfter;
	JRadioButton rdinsertBefore;
	JComponent comptarget;
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
		setLayout(new com.jgoodies.forms.layout.FormLayout("fill:pref:grow(.5), left:pref:none, fill:pref:grow(.5)", "top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:grow"));
	}

	public RegexpForm setCompsource(JComponent component) {
		if (component == null) return this;
		add(this.compsource = component, new com.jgoodies.forms.layout.CellConstraints().xywh(1, 1, 1, 18, "FILL, FILL"));
		return this;
	}

	public RegexpForm setLblPattern(JLabel component) {
		if (component == null) return this;
		add(this.lblPattern = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 1, 1, 1, "LEFT, TOP"));
		return this;
	}

	public RegexpForm setTxtpattern(JTextField component) {
		if (component == null) return this;
		add(this.txtpattern = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 2, 1, 1, "LEFT, TOP"));
		return this;
	}

	public RegexpForm setLblInsert(JLabel component) {
		if (component == null) return this;
		add(this.lblInsert = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 3, 1, 1, "LEFT, TOP"));
		return this;
	}

	public RegexpForm setTxtinsert(JTextField component) {
		if (component == null) return this;
		add(this.txtinsert = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 4, 1, 1, "LEFT, TOP"));
		return this;
	}

	public RegexpForm setRdreplace(JRadioButton component) {
		if (component == null) return this;
		add(this.rdreplace = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 5, 1, 1, "LEFT, TOP"));
		return this;
	}

	public RegexpForm setRdinsertAfter(JRadioButton component) {
		if (component == null) return this;
		add(this.rdinsertAfter = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 6, 1, 1, "LEFT, TOP"));
		return this;
	}

	public RegexpForm setRdinsertBefore(JRadioButton component) {
		if (component == null) return this;
		add(this.rdinsertBefore = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 7, 1, 1, "LEFT, TOP"));
		return this;
	}

	public RegexpForm setComptarget(JComponent component) {
		if (component == null) return this;
		add(this.comptarget = component, new com.jgoodies.forms.layout.CellConstraints().xywh(3, 1, 1, 18, "FILL, FILL"));
		return this;
	}

	public RegexpForm setRdinsertLineAfter(JRadioButton component) {
		if (component == null) return this;
		add(this.rdinsertLineAfter = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 8, 1, 1, "LEFT, TOP"));
		return this;
	}

	public RegexpForm setRdinsertLineBefore(JRadioButton component) {
		if (component == null) return this;
		add(this.rdinsertLineBefore = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 9, 1, 1, "LEFT, TOP"));
		return this;
	}

	public RegexpForm setRdremove(JRadioButton component) {
		if (component == null) return this;
		add(this.rdremove = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 10, 1, 1, "LEFT, TOP"));
		return this;
	}

	public RegexpForm setRdremoveLine(JRadioButton component) {
		if (component == null) return this;
		add(this.rdremoveLine = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 11, 1, 1, "LEFT, TOP"));
		return this;
	}

	public RegexpForm setRdremoveLineBefore(JRadioButton component) {
		if (component == null) return this;
		add(this.rdremoveLineBefore = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 12, 1, 1, "LEFT, TOP"));
		return this;
	}

	public RegexpForm setRdremoveLineAfter(JRadioButton component) {
		if (component == null) return this;
		add(this.rdremoveLineAfter = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 13, 1, 1, "LEFT, TOP"));
		return this;
	}

	public RegexpForm setChkcompressLines(JCheckBox component) {
		if (component == null) return this;
		add(this.chkcompressLines = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 14, 1, 1, "LEFT, TOP"));
		return this;
	}

	public RegexpForm setChkshowDifference(JCheckBox component) {
		if (component == null) return this;
		add(this.chkshowDifference = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 15, 1, 1, "LEFT, TOP"));
		return this;
	}

	public RegexpForm setChkkeepOnlyMatches(JCheckBox component) {
		if (component == null) return this;
		add(this.chkkeepOnlyMatches = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 16, 1, 1, "LEFT, TOP"));
		return this;
	}

	public RegexpForm setBtnsetSource(JButton component) {
		if (component == null) return this;
		add(this.btnsetSource = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 17, 1, 1, "FILL, TOP"));
		return this;
	}



	/*

	 columns 	3	"fill:pref:grow(.5), left:pref:none, fill:pref:grow(.5)"

	 rows 		18 	"top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:grow"

	 col 2 1 FILL pref grow(.5)
	 col 3 1 LEFT pref none
	 col 4 1 FILL pref grow(.5)
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
	 row 1 19 TOP pref grow
	 cell 2 2 18 1 FILL FILL Component source
	 cell 3 2 1 1 LEFT TOP Label Pattern
	 cell 3 3 1 1 LEFT TOP TextField pattern
	 cell 3 4 1 1 LEFT TOP Label Insert
	 cell 3 5 1 1 LEFT TOP TextField insert
	 cell 3 6 1 1 LEFT TOP RadioButton replace
	 cell 3 7 1 1 LEFT TOP RadioButton insertAfter
	 cell 3 8 1 1 LEFT TOP RadioButton insertBefore
	 cell 4 2 18 1 FILL FILL Component target
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
	 cell 2 19 1 1 CENTER CENTER NONE null
	 cell 3 19 1 1 CENTER CENTER NONE null
	 cell 4 19 1 1 CENTER CENTER NONE null

	*/	
}