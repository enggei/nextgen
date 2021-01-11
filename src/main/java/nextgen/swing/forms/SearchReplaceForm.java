package nextgen.swing.forms;

import javax.swing.*;

import static nextgen.swing.ComponentFactory.*;

public class SearchReplaceForm extends JPanel {

	JLabel search_JLabel;
	JLabel replace_JLabel;
	JScrollPane result_JScrollPane;
	JTextField search_JTextField;
	JTextField replace_JTextField;
	JButton search_JButton;
	JButton replace_JButton;

	public SearchReplaceForm() {
		setLayout(new com.jgoodies.forms.layout.FormLayout("left:PREF:none, left:PREF:grow, left:PREF:none", "fill:PREF:none, fill:PREF:none, fill:PREF:grow"));
	}

	public <T extends JLabel> T getSearchJLabel() {
		return (T) search_JLabel;
	}

	public <T extends JLabel> T getSearchJLabel(java.util.function.Supplier<T> supplier) {
		if (this.search_JLabel == null) setSearch(supplier.get());
   	return (T) this.search_JLabel;
	}

	public SearchReplaceForm setSearch(JLabel component) {
		if (component == null) return this;
		add(this.search_JLabel = component, new com.jgoodies.forms.layout.CellConstraints().xywh(1, 1, 1, 1, "FILL, FILL"));
		return this;
	}

	public <T extends JLabel> T getReplaceJLabel() {
		return (T) replace_JLabel;
	}

	public <T extends JLabel> T getReplaceJLabel(java.util.function.Supplier<T> supplier) {
		if (this.replace_JLabel == null) setReplace(supplier.get());
   	return (T) this.replace_JLabel;
	}

	public SearchReplaceForm setReplace(JLabel component) {
		if (component == null) return this;
		add(this.replace_JLabel = component, new com.jgoodies.forms.layout.CellConstraints().xywh(1, 2, 1, 1, "FILL, FILL"));
		return this;
	}

	public <T extends JScrollPane> T getResultJScrollPane() {
		return (T) result_JScrollPane;
	}

	public <T extends JScrollPane> T getResultJScrollPane(java.util.function.Supplier<T> supplier) {
		if (this.result_JScrollPane == null) setResult(supplier.get());
   	return (T) this.result_JScrollPane;
	}

	public SearchReplaceForm setResult(JScrollPane component) {
		if (component == null) return this;
		add(this.result_JScrollPane = component, new com.jgoodies.forms.layout.CellConstraints().xywh(1, 3, 3, 1, "FILL, FILL"));
		return this;
	}

	public <T extends JTextField> T getSearchJTextField() {
		return (T) search_JTextField;
	}

	public <T extends JTextField> T getSearchJTextField(java.util.function.Supplier<T> supplier) {
		if (this.search_JTextField == null) setSearch(supplier.get());
   	return (T) this.search_JTextField;
	}

	public SearchReplaceForm setSearch(JTextField component) {
		if (component == null) return this;
		add(this.search_JTextField = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 1, 1, 1, "FILL, FILL"));
		return this;
	}

	public <T extends JTextField> T getReplaceJTextField() {
		return (T) replace_JTextField;
	}

	public <T extends JTextField> T getReplaceJTextField(java.util.function.Supplier<T> supplier) {
		if (this.replace_JTextField == null) setReplace(supplier.get());
   	return (T) this.replace_JTextField;
	}

	public SearchReplaceForm setReplace(JTextField component) {
		if (component == null) return this;
		add(this.replace_JTextField = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 2, 1, 1, "FILL, FILL"));
		return this;
	}

	public <T extends JButton> T getSearchJButton() {
		return (T) search_JButton;
	}

	public <T extends JButton> T getSearchJButton(java.util.function.Supplier<T> supplier) {
		if (this.search_JButton == null) setSearch(supplier.get());
   	return (T) this.search_JButton;
	}

	public SearchReplaceForm setSearch(JButton component) {
		if (component == null) return this;
		add(this.search_JButton = component, new com.jgoodies.forms.layout.CellConstraints().xywh(3, 1, 1, 1, "FILL, FILL"));
		return this;
	}

	public <T extends JButton> T getReplaceJButton() {
		return (T) replace_JButton;
	}

	public <T extends JButton> T getReplaceJButton(java.util.function.Supplier<T> supplier) {
		if (this.replace_JButton == null) setReplace(supplier.get());
   	return (T) this.replace_JButton;
	}

	public SearchReplaceForm setReplace(JButton component) {
		if (component == null) return this;
		add(this.replace_JButton = component, new com.jgoodies.forms.layout.CellConstraints().xywh(3, 2, 1, 1, "FILL, FILL"));
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