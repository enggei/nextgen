package nextgen.swing.forms;

import javax.swing.*;

public class SearchForm extends JPanel {

	JLabel search_JLabel;
	JLabel replace_JLabel;
	JScrollPane result_JScrollPane;
	JTextField search_JTextField;
	JTextField replace_JTextField;
	JButton search_JButton;
	JButton replace_JButton;

	public SearchForm() {
		setLayout(new com.jgoodies.forms.layout.FormLayout("left:PREF:none, left:PREF:grow, left:PREF:none", "fill:PREF:none, fill:PREF:none, fill:PREF:grow"));
	}

	public SearchForm setSearch(JLabel component) {
		if (component == null) return this;
		add(this.search_JLabel = component, new com.jgoodies.forms.layout.CellConstraints().xywh(1, 1, 1, 1, "FILL, FILL"));
		return this;
	}

	public SearchForm setReplace(JLabel component) {
		if (component == null) return this;
		add(this.replace_JLabel = component, new com.jgoodies.forms.layout.CellConstraints().xywh(1, 2, 1, 1, "FILL, FILL"));
		return this;
	}

	public SearchForm setResult(JScrollPane component) {
		if (component == null) return this;
		add(this.result_JScrollPane = component, new com.jgoodies.forms.layout.CellConstraints().xywh(1, 3, 3, 1, "FILL, TOP"));
		return this;
	}

	public SearchForm setSearch(JTextField component) {
		if (component == null) return this;
		add(this.search_JTextField = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 1, 1, 1, "FILL, FILL"));
		return this;
	}

	public SearchForm setReplace(JTextField component) {
		if (component == null) return this;
		add(this.replace_JTextField = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 2, 1, 1, "FILL, FILL"));
		return this;
	}

	public SearchForm setSearch(JButton component) {
		if (component == null) return this;
		add(this.search_JButton = component, new com.jgoodies.forms.layout.CellConstraints().xywh(3, 1, 1, 1, "FILL, FILL"));
		return this;
	}

	public SearchForm setReplace(JButton component) {
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
	 cell 2 4 1 3 FILL TOP ScrollPane result
	 cell 3 2 1 1 FILL FILL TextField search
	 cell 3 3 1 1 FILL FILL TextField replace
	 cell 4 2 1 1 FILL FILL Button search
	 cell 4 3 1 1 FILL FILL Button replace

	*/	
}