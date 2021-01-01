package nextgen.swing.forms;

import javax.swing.*;

import static nextgen.swing.ComponentFactory.*;

public class TextAreaCrudForm extends JPanel {

	JComponent textArea_JComponent;
	JButton delete_JButton;
	JButton toClipboard_JButton;
	JButton fromClipboard_JButton;

	public TextAreaCrudForm() {
		setLayout(new com.jgoodies.forms.layout.FormLayout("fill:75:grow, fill:75:none, fill:75:none, left:75:none", "top:pref:none, top:pref:none"));
	}

	public JComponent getTextAreaJComponent() {
		return textArea_JComponent;
	}

	public TextAreaCrudForm setTextArea(JComponent component) {
		if (component == null) return this;
		add(this.textArea_JComponent = component, new com.jgoodies.forms.layout.CellConstraints().xywh(1, 1, 4, 1, "FILL, CENTER"));
		return this;
	}

	public JButton getDeleteJButton() {
		return delete_JButton;
	}

	public TextAreaCrudForm setDelete(JButton component) {
		if (component == null) return this;
		add(this.delete_JButton = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 2, 1, 1, "FILL, FILL"));
		return this;
	}

	public JButton getToClipboardJButton() {
		return toClipboard_JButton;
	}

	public TextAreaCrudForm setToClipboard(JButton component) {
		if (component == null) return this;
		add(this.toClipboard_JButton = component, new com.jgoodies.forms.layout.CellConstraints().xywh(3, 2, 1, 1, "FILL, FILL"));
		return this;
	}

	public JButton getFromClipboardJButton() {
		return fromClipboard_JButton;
	}

	public TextAreaCrudForm setFromClipboard(JButton component) {
		if (component == null) return this;
		add(this.fromClipboard_JButton = component, new com.jgoodies.forms.layout.CellConstraints().xywh(4, 2, 1, 1, "FILL, FILL"));
		return this;
	}


	public void setModel(nextgen.model.STValue model, java.awt.event.KeyListener keyListener) {
		final org.fife.ui.rsyntaxtextarea.RSyntaxTextArea component = newRSyntaxTextArea(model.getValue(), keyListener);
		setTextArea(component);
		component.setEditable(model.getType().equals(nextgen.model.STValueType.PRIMITIVE));
	}

	public void onSave(nextgen.model.STValue model) {
		model.setValue(((JTextArea)this.textArea_JComponent).getText().trim());
	}

	/*

	 columns 	4	"fill:75:grow, fill:75:none, fill:75:none, left:75:none"

	 rows 		2 	"top:pref:none, top:pref:none"

	 col 2 1 FILL 75 grow
	 col 3 1 FILL 75 none
	 col 4 1 FILL 75 none
	 col 5 1 LEFT 75 none
	 row 1 2 TOP pref none
	 row 1 3 TOP pref none
	 cell 2 2 1 4 FILL CENTER Component textArea
	 cell 2 3 1 1 FILL FILL NONE null
	 cell 3 2 1 1 CENTER CENTER NONE null
	 cell 3 3 1 1 FILL FILL Button delete
	 cell 4 2 1 1 CENTER CENTER NONE null
	 cell 4 3 1 1 FILL FILL Button toClipboard
	 cell 5 2 1 1 CENTER CENTER NONE null
	 cell 5 3 1 1 FILL FILL Button fromClipboard

	*/	
}