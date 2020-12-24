package nextgen.swing.forms;

public class TestPanel extends javax.swing.JPanel {

	javax.swing.JLabel lblhhhhhhh;
	javax.swing.JButton btnbt;
	javax.swing.JTextArea txtAreaTextArea_42;

	public TestPanel() {
		setLayout(new com.jgoodies.forms.layout.FormLayout("left:pref:none, left:pref:none, left:pref:none", "top:pref:none, top:pref:none, top:pref:none"));
		setBackground(javax.swing.UIManager.getColor("Panel.background"));
	}

	public TestPanel setLblhhhhhhh(javax.swing.JLabel component) {
		this.lblhhhhhhh = component;
		add(lblhhhhhhh, new com.jgoodies.forms.layout.CellConstraints().xywh(1, 1, 1, 1, "left, top"));
		return this;
	}

	public TestPanel setBtnbt(javax.swing.JButton component) {
		this.btnbt = component;
		add(btnbt, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 1, 1, 1, "left, top"));
		return this;
	}

	public TestPanel setTxtAreaTextArea_42(javax.swing.JTextArea component) {
		this.txtAreaTextArea_42 = component;
		add(txtAreaTextArea_42, new com.jgoodies.forms.layout.CellConstraints().xywh(3, 1, 1, 1, "left, top"));
		return this;
	}


	public TestPanel decorateLblhhhhhhh(java.util.function.Consumer<javax.swing.JLabel> consumer) {
		consumer.accept(this.lblhhhhhhh);
		return this;
	}

	public TestPanel decorateBtnbt(java.util.function.Consumer<javax.swing.JButton> consumer) {
		consumer.accept(this.btnbt);
		return this;
	}

	public TestPanel decorateTxtAreaTextArea_42(java.util.function.Consumer<javax.swing.JTextArea> consumer) {
		consumer.accept(this.txtAreaTextArea_42);
		return this;
	}


	public javax.swing.JLabel getLblhhhhhhh() {
		return lblhhhhhhh;
	}

	public javax.swing.JButton getBtnbt() {
		return btnbt;
	}

	public javax.swing.JTextArea getTxtAreaTextArea_42() {
		return txtAreaTextArea_42;
	}


	public static void main(String[] args) throws Throwable {
		final java.awt.Font font = new java.awt.Font("InputMono", java.awt.Font.PLAIN, 24);
		javax.swing.UIManager.put("TextField.font", font);
		javax.swing.UIManager.put("TextArea.font", font);


		nextgen.utils.SwingUtil.showPanel(new TestPanel());
	}
}