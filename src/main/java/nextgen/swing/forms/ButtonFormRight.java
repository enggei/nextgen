package nextgen.swing.forms;

import javax.swing.*;

public class ButtonFormRight extends JPanel {

	JComponent one_JComponent;
	JButton two_JButton;
	JButton three_JButton;

	public ButtonFormRight() {
		setLayout(new com.jgoodies.forms.layout.FormLayout("fill:pref:grow, fill:pref:none, fill:pref:none, fill:pref:none", "top:pref:none"));
	}

	public ButtonFormRight setOne(JComponent component) {
		if (component == null) return this;
		add(this.one_JComponent = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 1, 1, 1, "FILL, CENTER"));
		return this;
	}

	public ButtonFormRight setTwo(JButton component) {
		if (component == null) return this;
		add(this.two_JButton = component, new com.jgoodies.forms.layout.CellConstraints().xywh(3, 1, 1, 1, "FILL, CENTER"));
		return this;
	}

	public ButtonFormRight setThree(JButton component) {
		if (component == null) return this;
		add(this.three_JButton = component, new com.jgoodies.forms.layout.CellConstraints().xywh(4, 1, 1, 1, "FILL, CENTER"));
		return this;
	}



	/*

	 columns 	4	"fill:pref:grow, fill:pref:none, fill:pref:none, fill:pref:none"

	 rows 		1 	"top:pref:none"

	 col 2 1 FILL pref grow
	 col 3 1 FILL pref none
	 col 4 1 FILL pref none
	 col 5 1 FILL pref none
	 row 1 2 TOP pref none
	 cell 2 2 1 1 FILL FILL NONE value
	 cell 3 2 1 1 FILL CENTER Component one
	 cell 4 2 1 1 FILL CENTER Button two
	 cell 5 2 1 1 FILL CENTER Button three

	*/	
}