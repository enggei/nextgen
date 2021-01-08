package nextgen.swing.forms;

import javax.swing.*;

import static nextgen.swing.ComponentFactory.*;

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
	JScrollPane values_JScrollPane;
	JCheckBox showDistinct_JCheckBox;

	public RegexpForm() {
		setLayout(new com.jgoodies.forms.layout.FormLayout("fill:pref:grow(.5), left:pref:grow(.2), fill:pref:grow(.5)", "top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, center:pref:none, center:pref:grow"));
	}

	public JComponent getSourceJComponent() {
		return source_JComponent;
	}

	public <T extends JComponent> T getSourceJComponent(java.util.function.Supplier<T> supplier) {
		if (this.source_JComponent == null) setSource(supplier.get());
   	return (T) this.source_JComponent;
	}

	public RegexpForm setSource(JComponent component) {
		if (component == null) return this;
		add(this.source_JComponent = component, new com.jgoodies.forms.layout.CellConstraints().xywh(1, 1, 1, 19, "FILL, FILL"));
		return this;
	}

	public JLabel getPatternJLabel() {
		return Pattern_JLabel;
	}

	public <T extends JLabel> T getPatternJLabel(java.util.function.Supplier<T> supplier) {
		if (this.Pattern_JLabel == null) setPattern(supplier.get());
   	return (T) this.Pattern_JLabel;
	}

	public RegexpForm setPattern(JLabel component) {
		if (component == null) return this;
		add(this.Pattern_JLabel = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 1, 1, 1, "FILL, TOP"));
		return this;
	}

	public JTextField getPatternJTextField() {
		return pattern_JTextField;
	}

	public <T extends JTextField> T getPatternJTextField(java.util.function.Supplier<T> supplier) {
		if (this.pattern_JTextField == null) setPattern(supplier.get());
   	return (T) this.pattern_JTextField;
	}

	public RegexpForm setPattern(JTextField component) {
		if (component == null) return this;
		add(this.pattern_JTextField = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 2, 1, 1, "FILL, TOP"));
		return this;
	}

	public JLabel getInsertJLabel() {
		return Insert_JLabel;
	}

	public <T extends JLabel> T getInsertJLabel(java.util.function.Supplier<T> supplier) {
		if (this.Insert_JLabel == null) setInsert(supplier.get());
   	return (T) this.Insert_JLabel;
	}

	public RegexpForm setInsert(JLabel component) {
		if (component == null) return this;
		add(this.Insert_JLabel = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 3, 1, 1, "LEFT, TOP"));
		return this;
	}

	public JTextField getInsertJTextField() {
		return insert_JTextField;
	}

	public <T extends JTextField> T getInsertJTextField(java.util.function.Supplier<T> supplier) {
		if (this.insert_JTextField == null) setInsert(supplier.get());
   	return (T) this.insert_JTextField;
	}

	public RegexpForm setInsert(JTextField component) {
		if (component == null) return this;
		add(this.insert_JTextField = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 4, 1, 1, "FILL, TOP"));
		return this;
	}

	public JRadioButton getReplaceJRadioButton() {
		return replace_JRadioButton;
	}

	public <T extends JRadioButton> T getReplaceJRadioButton(java.util.function.Supplier<T> supplier) {
		if (this.replace_JRadioButton == null) setReplace(supplier.get());
   	return (T) this.replace_JRadioButton;
	}

	public RegexpForm setReplace(JRadioButton component) {
		if (component == null) return this;
		add(this.replace_JRadioButton = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 5, 1, 1, "FILL, TOP"));
		return this;
	}

	public JRadioButton getInsertAfterJRadioButton() {
		return insertAfter_JRadioButton;
	}

	public <T extends JRadioButton> T getInsertAfterJRadioButton(java.util.function.Supplier<T> supplier) {
		if (this.insertAfter_JRadioButton == null) setInsertAfter(supplier.get());
   	return (T) this.insertAfter_JRadioButton;
	}

	public RegexpForm setInsertAfter(JRadioButton component) {
		if (component == null) return this;
		add(this.insertAfter_JRadioButton = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 6, 1, 1, "LEFT, TOP"));
		return this;
	}

	public JRadioButton getInsertBeforeJRadioButton() {
		return insertBefore_JRadioButton;
	}

	public <T extends JRadioButton> T getInsertBeforeJRadioButton(java.util.function.Supplier<T> supplier) {
		if (this.insertBefore_JRadioButton == null) setInsertBefore(supplier.get());
   	return (T) this.insertBefore_JRadioButton;
	}

	public RegexpForm setInsertBefore(JRadioButton component) {
		if (component == null) return this;
		add(this.insertBefore_JRadioButton = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 7, 1, 1, "LEFT, TOP"));
		return this;
	}

	public JComponent getTargetJComponent() {
		return target_JComponent;
	}

	public <T extends JComponent> T getTargetJComponent(java.util.function.Supplier<T> supplier) {
		if (this.target_JComponent == null) setTarget(supplier.get());
   	return (T) this.target_JComponent;
	}

	public RegexpForm setTarget(JComponent component) {
		if (component == null) return this;
		add(this.target_JComponent = component, new com.jgoodies.forms.layout.CellConstraints().xywh(3, 1, 1, 19, "FILL, FILL"));
		return this;
	}

	public JRadioButton getInsertLineAfterJRadioButton() {
		return insertLineAfter_JRadioButton;
	}

	public <T extends JRadioButton> T getInsertLineAfterJRadioButton(java.util.function.Supplier<T> supplier) {
		if (this.insertLineAfter_JRadioButton == null) setInsertLineAfter(supplier.get());
   	return (T) this.insertLineAfter_JRadioButton;
	}

	public RegexpForm setInsertLineAfter(JRadioButton component) {
		if (component == null) return this;
		add(this.insertLineAfter_JRadioButton = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 8, 1, 1, "LEFT, TOP"));
		return this;
	}

	public JRadioButton getInsertLineBeforeJRadioButton() {
		return insertLineBefore_JRadioButton;
	}

	public <T extends JRadioButton> T getInsertLineBeforeJRadioButton(java.util.function.Supplier<T> supplier) {
		if (this.insertLineBefore_JRadioButton == null) setInsertLineBefore(supplier.get());
   	return (T) this.insertLineBefore_JRadioButton;
	}

	public RegexpForm setInsertLineBefore(JRadioButton component) {
		if (component == null) return this;
		add(this.insertLineBefore_JRadioButton = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 9, 1, 1, "LEFT, TOP"));
		return this;
	}

	public JRadioButton getRemoveJRadioButton() {
		return remove_JRadioButton;
	}

	public <T extends JRadioButton> T getRemoveJRadioButton(java.util.function.Supplier<T> supplier) {
		if (this.remove_JRadioButton == null) setRemove(supplier.get());
   	return (T) this.remove_JRadioButton;
	}

	public RegexpForm setRemove(JRadioButton component) {
		if (component == null) return this;
		add(this.remove_JRadioButton = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 10, 1, 1, "LEFT, TOP"));
		return this;
	}

	public JRadioButton getRemoveLineJRadioButton() {
		return removeLine_JRadioButton;
	}

	public <T extends JRadioButton> T getRemoveLineJRadioButton(java.util.function.Supplier<T> supplier) {
		if (this.removeLine_JRadioButton == null) setRemoveLine(supplier.get());
   	return (T) this.removeLine_JRadioButton;
	}

	public RegexpForm setRemoveLine(JRadioButton component) {
		if (component == null) return this;
		add(this.removeLine_JRadioButton = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 11, 1, 1, "LEFT, TOP"));
		return this;
	}

	public JRadioButton getRemoveLineBeforeJRadioButton() {
		return removeLineBefore_JRadioButton;
	}

	public <T extends JRadioButton> T getRemoveLineBeforeJRadioButton(java.util.function.Supplier<T> supplier) {
		if (this.removeLineBefore_JRadioButton == null) setRemoveLineBefore(supplier.get());
   	return (T) this.removeLineBefore_JRadioButton;
	}

	public RegexpForm setRemoveLineBefore(JRadioButton component) {
		if (component == null) return this;
		add(this.removeLineBefore_JRadioButton = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 12, 1, 1, "LEFT, TOP"));
		return this;
	}

	public JRadioButton getRemoveLineAfterJRadioButton() {
		return removeLineAfter_JRadioButton;
	}

	public <T extends JRadioButton> T getRemoveLineAfterJRadioButton(java.util.function.Supplier<T> supplier) {
		if (this.removeLineAfter_JRadioButton == null) setRemoveLineAfter(supplier.get());
   	return (T) this.removeLineAfter_JRadioButton;
	}

	public RegexpForm setRemoveLineAfter(JRadioButton component) {
		if (component == null) return this;
		add(this.removeLineAfter_JRadioButton = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 13, 1, 1, "LEFT, TOP"));
		return this;
	}

	public JCheckBox getCompressLinesJCheckBox() {
		return compressLines_JCheckBox;
	}

	public <T extends JCheckBox> T getCompressLinesJCheckBox(java.util.function.Supplier<T> supplier) {
		if (this.compressLines_JCheckBox == null) setCompressLines(supplier.get());
   	return (T) this.compressLines_JCheckBox;
	}

	public RegexpForm setCompressLines(JCheckBox component) {
		if (component == null) return this;
		add(this.compressLines_JCheckBox = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 14, 1, 1, "LEFT, TOP"));
		return this;
	}

	public JCheckBox getShowDifferenceJCheckBox() {
		return showDifference_JCheckBox;
	}

	public <T extends JCheckBox> T getShowDifferenceJCheckBox(java.util.function.Supplier<T> supplier) {
		if (this.showDifference_JCheckBox == null) setShowDifference(supplier.get());
   	return (T) this.showDifference_JCheckBox;
	}

	public RegexpForm setShowDifference(JCheckBox component) {
		if (component == null) return this;
		add(this.showDifference_JCheckBox = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 15, 1, 1, "LEFT, TOP"));
		return this;
	}

	public JCheckBox getKeepOnlyMatchesJCheckBox() {
		return keepOnlyMatches_JCheckBox;
	}

	public <T extends JCheckBox> T getKeepOnlyMatchesJCheckBox(java.util.function.Supplier<T> supplier) {
		if (this.keepOnlyMatches_JCheckBox == null) setKeepOnlyMatches(supplier.get());
   	return (T) this.keepOnlyMatches_JCheckBox;
	}

	public RegexpForm setKeepOnlyMatches(JCheckBox component) {
		if (component == null) return this;
		add(this.keepOnlyMatches_JCheckBox = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 16, 1, 1, "LEFT, TOP"));
		return this;
	}

	public JButton getSetSourceJButton() {
		return setSource_JButton;
	}

	public <T extends JButton> T getSetSourceJButton(java.util.function.Supplier<T> supplier) {
		if (this.setSource_JButton == null) setSetSource(supplier.get());
   	return (T) this.setSource_JButton;
	}

	public RegexpForm setSetSource(JButton component) {
		if (component == null) return this;
		add(this.setSource_JButton = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 17, 1, 1, "FILL, TOP"));
		return this;
	}

	public JScrollPane getValuesJScrollPane() {
		return values_JScrollPane;
	}

	public <T extends JScrollPane> T getValuesJScrollPane(java.util.function.Supplier<T> supplier) {
		if (this.values_JScrollPane == null) setValues(supplier.get());
   	return (T) this.values_JScrollPane;
	}

	public RegexpForm setValues(JScrollPane component) {
		if (component == null) return this;
		add(this.values_JScrollPane = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 18, 1, 2, "FILL, FILL"));
		return this;
	}

	public JCheckBox getShowDistinctJCheckBox() {
		return showDistinct_JCheckBox;
	}

	public <T extends JCheckBox> T getShowDistinctJCheckBox(java.util.function.Supplier<T> supplier) {
		if (this.showDistinct_JCheckBox == null) setShowDistinct(supplier.get());
   	return (T) this.showDistinct_JCheckBox;
	}

	public RegexpForm setShowDistinct(JCheckBox component) {
		if (component == null) return this;
		add(this.showDistinct_JCheckBox = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 20, 1, 1, "CENTER, CENTER"));
		return this;
	}


	/*

	 columns 	3	"fill:pref:grow(.5), left:pref:grow(.2), fill:pref:grow(.5)"

	 rows 		20 	"top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, top:pref:none, center:pref:none, center:pref:grow"

	 col 2 1 FILL pref grow(.5)
	 col 3 1 LEFT pref grow(.2)
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
	 row 1 19 TOP pref none
	 row 1 20 CENTER pref none
	 row 1 21 CENTER pref grow
	 cell 2 2 19 1 FILL FILL Component source
	 cell 3 2 1 1 FILL TOP Label Pattern
	 cell 3 3 1 1 FILL TOP TextField pattern
	 cell 3 4 1 1 LEFT TOP Label Insert
	 cell 3 5 1 1 FILL TOP TextField insert
	 cell 3 6 1 1 FILL TOP RadioButton replace
	 cell 3 7 1 1 LEFT TOP RadioButton insertAfter
	 cell 3 8 1 1 LEFT TOP RadioButton insertBefore
	 cell 4 2 19 1 FILL FILL Component target
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
	 cell 3 19 2 1 FILL FILL ScrollPane values
	 cell 4 19 1 1 CENTER CENTER NONE null
	 cell 2 20 1 1 CENTER CENTER NONE null
	 cell 3 20 1 1 CENTER CENTER NONE null
	 cell 4 20 1 1 CENTER CENTER NONE null
	 cell 2 21 1 1 CENTER CENTER NONE null
	 cell 3 21 1 1 CENTER CENTER CheckBox showDistinct
	 cell 4 21 1 1 CENTER CENTER NONE null

	*/	
}