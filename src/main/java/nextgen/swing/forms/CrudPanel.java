package nextgen.swing.forms;

import javax.swing.*;

public class CrudPanel extends JPanel {

	JTextField value_JTextField;
	JButton delete_JButton;
	JButton toClipboard_JButton;
	JButton fromClipboard_JButton;

	public CrudPanel() {
		setLayout(new com.jgoodies.forms.layout.FormLayout("fill:pref:grow, fill:75:none, fill:75:none, fill:75:none", "top:pref:none"));
	}

	public CrudPanel setValue(JTextField component) {
		if (component == null) return this;
		add(this.value_JTextField = component, new com.jgoodies.forms.layout.CellConstraints().xywh(1, 1, 1, 1, "FILL, FILL"));
		return this;
	}

	public CrudPanel setDelete(JButton component) {
		if (component == null) return this;
		add(this.delete_JButton = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 1, 1, 1, "FILL, TOP"));
		return this;
	}

	public CrudPanel setToClipboard(JButton component) {
		if (component == null) return this;
		add(this.toClipboard_JButton = component, new com.jgoodies.forms.layout.CellConstraints().xywh(3, 1, 1, 1, "FILL, TOP"));
		return this;
	}

	public CrudPanel setFromClipboard(JButton component) {
		if (component == null) return this;
		add(this.fromClipboard_JButton = component, new com.jgoodies.forms.layout.CellConstraints().xywh(4, 1, 1, 1, "FILL, TOP"));
		return this;
	}



	/*

	 columns 	4	"fill:pref:grow, fill:75:none, fill:75:none, fill:75:none"

	 rows 		1 	"top:pref:none"

	 col 2 1 FILL pref grow
	 col 3 1 FILL 75 none
	 col 4 1 FILL 75 none
	 col 5 1 FILL 75 none
	 row 1 2 TOP pref none
	 cell 2 2 1 1 FILL FILL TextField value
	 cell 3 2 1 1 FILL TOP Button delete
	 cell 4 2 1 1 FILL TOP Button toClipboard
	 cell 5 2 1 1 FILL TOP Button fromClipboard

	*/	
}