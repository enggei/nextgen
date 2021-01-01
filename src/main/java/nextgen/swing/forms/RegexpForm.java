package nextgen.swing.forms;

import javax.swing.*;

public class RegexpForm extends JPanel {

	JComponent source_JComponent;
	JLabel Pattern_JLabel;
	JTextField pattern_JTextField;
	JLabel Insert_JLabel;
	JTextField insert_JTextField;
	JRadioButton replace_JRadioButton;
	JRadioButton insertAfter_JRadioButton;
	JRadioButton insertBefore_JRadioButton;
	JComponent target_JComponent;
	JRadioButton insertLineAfter_JRadioButton;
	JRadioButton insertLineBefore_JRadioButton;
	JRadioButton remove_JRadioButton;
	JRadioButton removeLine_JRadioButton;
	JRadioButton removeLineBefore_JRadioButton;
	JRadioButton removeLineAfter_JRadioButton;
	JCheckBox compressLines_JCheckBox;
	JCheckBox showDifference_JCheckBox;
	JCheckBox keepOnlyMatches_JCheckBox;
	JButton setSource_JButton;

	public RegexpForm() {
		setLayout(new com.jgoodies.forms.layout.FormLayout("fill:pref:grow(.5), left:pref:none, fill:pref:grow(.5)", "top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:grow"));
	}

	public RegexpForm setSource(JComponent component) {
		if (component == null) return this;
		add(this.source_JComponent = component, new com.jgoodies.forms.layout.CellConstraints().xywh(1, 1, 1, 18, "FILL, FILL"));
		return this;
	}

	public RegexpForm setPattern(JLabel component) {
		if (component == null) return this;
		add(this.Pattern_JLabel = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 1, 1, 1, "LEFT, TOP"));
		return this;
	}

	public RegexpForm setPattern(JTextField component) {
		if (component == null) return this;
		add(this.pattern_JTextField = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 2, 1, 1, "LEFT, TOP"));
		return this;
	}

	public RegexpForm setInsert(JLabel component) {
		if (component == null) return this;
		add(this.Insert_JLabel = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 3, 1, 1, "LEFT, TOP"));
		return this;
	}

	public RegexpForm setInsert(JTextField component) {
		if (component == null) return this;
		add(this.insert_JTextField = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 4, 1, 1, "LEFT, TOP"));
		return this;
	}

	public RegexpForm setReplace(JRadioButton component) {
		if (component == null) return this;
		add(this.replace_JRadioButton = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 5, 1, 1, "LEFT, TOP"));
		return this;
	}

	public RegexpForm setInsertAfter(JRadioButton component) {
		if (component == null) return this;
		add(this.insertAfter_JRadioButton = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 6, 1, 1, "LEFT, TOP"));
		return this;
	}

	public RegexpForm setInsertBefore(JRadioButton component) {
		if (component == null) return this;
		add(this.insertBefore_JRadioButton = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 7, 1, 1, "LEFT, TOP"));
		return this;
	}

	public RegexpForm setTarget(JComponent component) {
		if (component == null) return this;
		add(this.target_JComponent = component, new com.jgoodies.forms.layout.CellConstraints().xywh(3, 1, 1, 18, "FILL, FILL"));
		return this;
	}

	public RegexpForm setInsertLineAfter(JRadioButton component) {
		if (component == null) return this;
		add(this.insertLineAfter_JRadioButton = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 8, 1, 1, "LEFT, TOP"));
		return this;
	}

	public RegexpForm setInsertLineBefore(JRadioButton component) {
		if (component == null) return this;
		add(this.insertLineBefore_JRadioButton = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 9, 1, 1, "LEFT, TOP"));
		return this;
	}

	public RegexpForm setRemove(JRadioButton component) {
		if (component == null) return this;
		add(this.remove_JRadioButton = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 10, 1, 1, "LEFT, TOP"));
		return this;
	}

	public RegexpForm setRemoveLine(JRadioButton component) {
		if (component == null) return this;
		add(this.removeLine_JRadioButton = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 11, 1, 1, "LEFT, TOP"));
		return this;
	}

	public RegexpForm setRemoveLineBefore(JRadioButton component) {
		if (component == null) return this;
		add(this.removeLineBefore_JRadioButton = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 12, 1, 1, "LEFT, TOP"));
		return this;
	}

	public RegexpForm setRemoveLineAfter(JRadioButton component) {
		if (component == null) return this;
		add(this.removeLineAfter_JRadioButton = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 13, 1, 1, "LEFT, TOP"));
		return this;
	}

	public RegexpForm setCompressLines(JCheckBox component) {
		if (component == null) return this;
		add(this.compressLines_JCheckBox = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 14, 1, 1, "LEFT, TOP"));
		return this;
	}

	public RegexpForm setShowDifference(JCheckBox component) {
		if (component == null) return this;
		add(this.showDifference_JCheckBox = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 15, 1, 1, "LEFT, TOP"));
		return this;
	}

	public RegexpForm setKeepOnlyMatches(JCheckBox component) {
		if (component == null) return this;
		add(this.keepOnlyMatches_JCheckBox = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 16, 1, 1, "LEFT, TOP"));
		return this;
	}

	public RegexpForm setSetSource(JButton component) {
		if (component == null) return this;
		add(this.setSource_JButton = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 17, 1, 1, "FILL, TOP"));
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