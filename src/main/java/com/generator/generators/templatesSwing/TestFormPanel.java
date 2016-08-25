package com.generator.generators.templatesSwing;

import com.generator.util.SwingUtil;

import javax.swing.*;
import java.text.DateFormat;

/**
 * goe on 8/25/16.
 */
public class TestFormPanel extends SwingUtil.FormPanel {

	private JFormattedTextField txtFrom = new JFormattedTextField(DateFormat.getDateInstance());
	private JFormattedTextField txtTo = new JFormattedTextField(DateFormat.getDateInstance());
	private JButton btnFrom = new JButton("From");
	private JButton btnTo = new JButton("To");

	public TestFormPanel() {
		super("50dlu, 4dlu, 50dlu, 4dlu, 50dlu", "pref, 4dlu, pref");

		setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

		int row = 1;
		this.addLabel("From", 1, row);
		this.add(this.txtFrom, 3, row);
		this.add(this.btnFrom, 5, row);
		row+=2;
		this.addLabel("To", 1, row);
		this.add(this.txtTo, 3, row);
		this.add(this.btnTo, 5, row);
	}

	public static void main(String[] args) {
		SwingUtil.showPanel(new TestFormPanel());
	}
}