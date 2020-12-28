package nextgen.swing.forms;

import javax.swing.*;

public class TextAreaCrudPanel extends JPanel {

	JScrollPane scrtextArea;
	JButton btndelete;
	JButton btntoClipboard;
	JButton btnfromClipboard;

	public TextAreaCrudPanel() {
		setLayout(new com.jgoodies.forms.layout.FormLayout("fill:120:none, fill:120:none, fill:120:none, left:pref:grow", "top:pref:none, top:pref:none"));
	}

	public TextAreaCrudPanel setScrtextArea(JScrollPane component) {
		add(this.scrtextArea = component, new com.jgoodies.forms.layout.CellConstraints().xywh(1, 1, 4, 1, "FILL, CENTER"));
		return this;
	}

	public TextAreaCrudPanel setBtndelete(JButton component) {
		add(this.btndelete = component, new com.jgoodies.forms.layout.CellConstraints().xywh(1, 2, 1, 1, "FILL, FILL"));
		return this;
	}

	public TextAreaCrudPanel setBtntoClipboard(JButton component) {
		add(this.btntoClipboard = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 2, 1, 1, "FILL, FILL"));
		return this;
	}

	public TextAreaCrudPanel setBtnfromClipboard(JButton component) {
		add(this.btnfromClipboard = component, new com.jgoodies.forms.layout.CellConstraints().xywh(3, 2, 1, 1, "FILL, FILL"));
		return this;
	}



	/*

	 columns 	4	"fill:120:none, fill:120:none, fill:120:none, left:pref:grow"

	 rows 		2 	"top:pref:none, top:pref:none"

	 col 2 1 FILL 120 none
	 col 3 1 FILL 120 none
	 col 4 1 FILL 120 none
	 col 5 1 LEFT pref grow
	 row 1 2 TOP pref none
	 row 1 3 TOP pref none
	 cell 2 2 1 4 FILL CENTER ScrollPane textArea
	 cell 2 3 1 1 FILL FILL Button delete
	 cell 3 2 1 1 CENTER CENTER NONE null
	 cell 3 3 1 1 FILL FILL Button toClipboard
	 cell 4 2 1 1 CENTER CENTER NONE null
	 cell 4 3 1 1 FILL FILL Button fromClipboard
	 cell 5 2 1 1 CENTER CENTER NONE null
	 cell 5 3 1 1 CENTER CENTER NONE null

	*/	
}