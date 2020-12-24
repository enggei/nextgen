package nextgen.swing.forms;

public class SearchForm extends javax.swing.JPanel {

	javax.swing.JLabel lblsearch;
	javax.swing.JLabel lblreplace;
	javax.swing.JScrollPane spresult;
	javax.swing.JTextField txtsearch;
	javax.swing.JTextField txtreplace;
	javax.swing.JButton btnsearch;
	javax.swing.JButton btnreplace;

	public SearchForm() {
		setLayout(new com.jgoodies.forms.layout.FormLayout("left:pref:none, fill:pref:grow, fill:pref:none", "top:pref:none, top:pref:none, top:pref:grow"));
		setBackground(javax.swing.UIManager.getColor("Panel.background"));
	}

	public SearchForm setLblsearch(javax.swing.JLabel component) {
		this.lblsearch = component;
		add(lblsearch, new com.jgoodies.forms.layout.CellConstraints().xywh(1, 1, 1, 1, "left, center"));
		return this;
	}

	public SearchForm setLblreplace(javax.swing.JLabel component) {
		this.lblreplace = component;
		add(lblreplace, new com.jgoodies.forms.layout.CellConstraints().xywh(1, 2, 1, 1, "left, top"));
		return this;
	}

	public SearchForm setSpresult(javax.swing.JScrollPane component) {
		this.spresult = component;
		add(spresult, new com.jgoodies.forms.layout.CellConstraints().xywh(1, 3, 3, 1, "fill, fill"));
		return this;
	}

	public SearchForm setTxtsearch(javax.swing.JTextField component) {
		this.txtsearch = component;
		add(txtsearch, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 1, 1, 1, "fill, center"));
		return this;
	}

	public SearchForm setTxtreplace(javax.swing.JTextField component) {
		this.txtreplace = component;
		add(txtreplace, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 2, 1, 1, "fill, top"));
		return this;
	}

	public SearchForm setBtnsearch(javax.swing.JButton component) {
		this.btnsearch = component;
		add(btnsearch, new com.jgoodies.forms.layout.CellConstraints().xywh(3, 1, 1, 1, "fill, center"));
		return this;
	}

	public SearchForm setBtnreplace(javax.swing.JButton component) {
		this.btnreplace = component;
		add(btnreplace, new com.jgoodies.forms.layout.CellConstraints().xywh(3, 2, 1, 1, "fill, top"));
		return this;
	}


	public SearchForm decorateLblsearch(java.util.function.Consumer<javax.swing.JLabel> consumer) {
		consumer.accept(this.lblsearch);
		return this;
	}

	public SearchForm decorateLblreplace(java.util.function.Consumer<javax.swing.JLabel> consumer) {
		consumer.accept(this.lblreplace);
		return this;
	}

	public SearchForm decorateSpresult(java.util.function.Consumer<javax.swing.JScrollPane> consumer) {
		consumer.accept(this.spresult);
		return this;
	}

	public SearchForm decorateTxtsearch(java.util.function.Consumer<javax.swing.JTextField> consumer) {
		consumer.accept(this.txtsearch);
		return this;
	}

	public SearchForm decorateTxtreplace(java.util.function.Consumer<javax.swing.JTextField> consumer) {
		consumer.accept(this.txtreplace);
		return this;
	}

	public SearchForm decorateBtnsearch(java.util.function.Consumer<javax.swing.JButton> consumer) {
		consumer.accept(this.btnsearch);
		return this;
	}

	public SearchForm decorateBtnreplace(java.util.function.Consumer<javax.swing.JButton> consumer) {
		consumer.accept(this.btnreplace);
		return this;
	}


	public javax.swing.JLabel getLblsearch() {
		return lblsearch;
	}

	public javax.swing.JLabel getLblreplace() {
		return lblreplace;
	}

	public javax.swing.JScrollPane getSpresult() {
		return spresult;
	}

	public javax.swing.JTextField getTxtsearch() {
		return txtsearch;
	}

	public javax.swing.JTextField getTxtreplace() {
		return txtreplace;
	}

	public javax.swing.JButton getBtnsearch() {
		return btnsearch;
	}

	public javax.swing.JButton getBtnreplace() {
		return btnreplace;
	}


	public static void main(String[] args) throws Throwable {
		final java.awt.Font font = new java.awt.Font("InputMono", java.awt.Font.PLAIN, 24);
		javax.swing.UIManager.put("TextField.font", font);
		javax.swing.UIManager.put("TextArea.font", font);


		nextgen.utils.SwingUtil.showPanel(new SearchForm());
	}
}