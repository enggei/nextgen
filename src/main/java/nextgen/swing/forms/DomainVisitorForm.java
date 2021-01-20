package nextgen.swing.forms;

import javax.swing.*;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.CellConstraints;

public class DomainVisitorForm extends JPanel {

	JLabel lblName = new JLabel("name");
	JTextField txtName = new JTextField("");
	JLabel lblOnDomain = new JLabel("onDomain");
	nextgen.swing.components.DomainVisitorTextArea txtOnDomain = new nextgen.swing.components.DomainVisitorTextArea("");
	JLabel lblOnEntity = new JLabel("onEntity");
	nextgen.swing.components.DomainVisitorTextArea txtOnEntity = new nextgen.swing.components.DomainVisitorTextArea("");
	JLabel lblOnRelation = new JLabel("onRelation");
	nextgen.swing.components.DomainVisitorTextArea txtOnRelation = new nextgen.swing.components.DomainVisitorTextArea("");
	JLabel lblOnComplete = new JLabel("onComplete");
	nextgen.swing.components.DomainVisitorTextArea txtOnComplete = new nextgen.swing.components.DomainVisitorTextArea("");
	JLabel lblTemplates = new JLabel("templates");
	nextgen.swing.table.STTemplateTable tblTemplates = new nextgen.swing.table.STTemplateTable();
	JLabel lblOnEntityEntity = new JLabel("onEntityEntity");
	nextgen.swing.components.DomainVisitorTextArea txtOnEntityEntity = new nextgen.swing.components.DomainVisitorTextArea("");
	JLabel lblOnEnumEntity = new JLabel("onEnumEntity");
	nextgen.swing.components.DomainVisitorTextArea txtOnEnumEntity = new nextgen.swing.components.DomainVisitorTextArea("");
	JLabel lblOnPrimitiveEntity = new JLabel("onPrimitiveEntity");
	nextgen.swing.components.DomainVisitorTextArea txtOnPrimitiveEntity = new nextgen.swing.components.DomainVisitorTextArea("");
	JLabel lblOnOneEntityRelation = new JLabel("onOneEntityRelation");
	nextgen.swing.components.DomainVisitorTextArea txtOnOneEntityRelation = new nextgen.swing.components.DomainVisitorTextArea("");
	JLabel lblOnOneEnumRelation = new JLabel("onOneEnumRelation");
	nextgen.swing.components.DomainVisitorTextArea txtOnOneEnumRelation = new nextgen.swing.components.DomainVisitorTextArea("");
	JLabel lblOnOnePrimitiveRelation = new JLabel("onOnePrimitiveRelation");
	nextgen.swing.components.DomainVisitorTextArea txtOnOnePrimitiveRelation = new nextgen.swing.components.DomainVisitorTextArea("");
	JLabel lblOnManyEntityRelation = new JLabel("onManyEntityRelation");
	nextgen.swing.components.DomainVisitorTextArea txtOnManyEntityRelation = new nextgen.swing.components.DomainVisitorTextArea("");
	JLabel lblOnManyEnumRelation = new JLabel("onManyEnumRelation");
	nextgen.swing.components.DomainVisitorTextArea txtOnManyEnumRelation = new nextgen.swing.components.DomainVisitorTextArea("");
	JLabel lblOnManyPrimitiveRelation = new JLabel("onManyPrimitiveRelation");
	nextgen.swing.components.DomainVisitorTextArea txtOnManyPrimitiveRelation = new nextgen.swing.components.DomainVisitorTextArea("");
	JLabel lblOnOptionalEntityRelation = new JLabel("onOptionalEntityRelation");
	nextgen.swing.components.DomainVisitorTextArea txtOnOptionalEntityRelation = new nextgen.swing.components.DomainVisitorTextArea("");
	JLabel lblOnOptionalEnumRelation = new JLabel("onOptionalEnumRelation");
	nextgen.swing.components.DomainVisitorTextArea txtOnOptionalEnumRelation = new nextgen.swing.components.DomainVisitorTextArea("");
	JLabel lblOnOptionalPrimitiveRelation = new JLabel("onOptionalPrimitiveRelation");
	nextgen.swing.components.DomainVisitorTextArea txtOnOptionalPrimitiveRelation = new nextgen.swing.components.DomainVisitorTextArea("");

	public DomainVisitorForm() {
		setLayout(new FormLayout("left:2400:none", "center:pref:none, center:pref:none, center:pref:none, center:150:grow, center:pref:none, center:150:grow, center:pref:none, center:150:grow, center:pref:none, center:150:grow, center:200:grow, center:pref:none, center:150:grow, center:pref:none, center:150:grow, center:pref:none, center:150:grow, center:pref:none, center:150:grow, center:pref:none, center:150:grow, center:pref:none, center:150:grow, center:pref:none, center:150:grow, center:pref:none, center:150:grow, center:pref:none, center:150:grow, center:pref:none, center:150:grow, center:pref:none, center:150:grow, center:pref:none, center:150:grow"));
		final CellConstraints cc = new CellConstraints();
		add(lblName, cc.xywh(1, 1, 1, 1, "LEFT, TOP"));
		add(txtName, cc.xywh(1, 2, 1, 1, "FILL, FILL"));
		add(lblOnDomain, cc.xywh(1, 3, 1, 1, "LEFT, TOP"));
		add(new org.fife.ui.rtextarea.RTextScrollPane(txtOnDomain), cc.xywh(1, 4, 1, 1, "FILL, FILL"));
		add(lblOnEntity, cc.xywh(1, 5, 1, 1, "LEFT, TOP"));
		add(new org.fife.ui.rtextarea.RTextScrollPane(txtOnEntity), cc.xywh(1, 6, 1, 1, "FILL, FILL"));
		add(lblOnRelation, cc.xywh(1, 7, 1, 1, "LEFT, TOP"));
		add(new org.fife.ui.rtextarea.RTextScrollPane(txtOnRelation), cc.xywh(1, 8, 1, 1, "FILL, FILL"));
		add(lblOnComplete, cc.xywh(1, 9, 1, 1, "LEFT, TOP"));
		add(new org.fife.ui.rtextarea.RTextScrollPane(txtOnComplete), cc.xywh(1, 10, 1, 1, "FILL, FILL"));
		add(lblTemplates, cc.xywh(1, 11, 1, 1, "LEFT, TOP"));
		add(new JScrollPane(tblTemplates), cc.xywh(1, 11, 1, 1, "FILL, FILL"));
		add(lblOnEntityEntity, cc.xywh(1, 12, 1, 1, "LEFT, TOP"));
		add(new org.fife.ui.rtextarea.RTextScrollPane(txtOnEntityEntity), cc.xywh(1, 13, 1, 1, "FILL, FILL"));
		add(lblOnEnumEntity, cc.xywh(1, 14, 1, 1, "LEFT, TOP"));
		add(new org.fife.ui.rtextarea.RTextScrollPane(txtOnEnumEntity), cc.xywh(1, 15, 1, 1, "FILL, FILL"));
		add(lblOnPrimitiveEntity, cc.xywh(1, 16, 1, 1, "LEFT, TOP"));
		add(new org.fife.ui.rtextarea.RTextScrollPane(txtOnPrimitiveEntity), cc.xywh(1, 17, 1, 1, "FILL, FILL"));
		add(lblOnOneEntityRelation, cc.xywh(1, 18, 1, 1, "LEFT, TOP"));
		add(new org.fife.ui.rtextarea.RTextScrollPane(txtOnOneEntityRelation), cc.xywh(1, 19, 1, 1, "FILL, FILL"));
		add(lblOnOneEnumRelation, cc.xywh(1, 20, 1, 1, "LEFT, TOP"));
		add(new org.fife.ui.rtextarea.RTextScrollPane(txtOnOneEnumRelation), cc.xywh(1, 21, 1, 1, "FILL, FILL"));
		add(lblOnOnePrimitiveRelation, cc.xywh(1, 22, 1, 1, "LEFT, TOP"));
		add(new org.fife.ui.rtextarea.RTextScrollPane(txtOnOnePrimitiveRelation), cc.xywh(1, 23, 1, 1, "FILL, FILL"));
		add(lblOnManyEntityRelation, cc.xywh(1, 24, 1, 1, "LEFT, TOP"));
		add(new org.fife.ui.rtextarea.RTextScrollPane(txtOnManyEntityRelation), cc.xywh(1, 25, 1, 1, "FILL, FILL"));
		add(lblOnManyEnumRelation, cc.xywh(1, 26, 1, 1, "LEFT, TOP"));
		add(new org.fife.ui.rtextarea.RTextScrollPane(txtOnManyEnumRelation), cc.xywh(1, 27, 1, 1, "FILL, FILL"));
		add(lblOnManyPrimitiveRelation, cc.xywh(1, 28, 1, 1, "LEFT, TOP"));
		add(new org.fife.ui.rtextarea.RTextScrollPane(txtOnManyPrimitiveRelation), cc.xywh(1, 29, 1, 1, "FILL, FILL"));
		add(lblOnOptionalEntityRelation, cc.xywh(1, 30, 1, 1, "LEFT, TOP"));
		add(new org.fife.ui.rtextarea.RTextScrollPane(txtOnOptionalEntityRelation), cc.xywh(1, 31, 1, 1, "FILL, FILL"));
		add(lblOnOptionalEnumRelation, cc.xywh(1, 32, 1, 1, "LEFT, TOP"));
		add(new org.fife.ui.rtextarea.RTextScrollPane(txtOnOptionalEnumRelation), cc.xywh(1, 33, 1, 1, "FILL, FILL"));
		add(lblOnOptionalPrimitiveRelation, cc.xywh(1, 34, 1, 1, "LEFT, TOP"));
		add(new org.fife.ui.rtextarea.RTextScrollPane(txtOnOptionalPrimitiveRelation), cc.xywh(1, 35, 1, 1, "FILL, FILL"));
	}

	public JLabel getLblName() {
		return lblName;
	}

	public JTextField getTxtName() {
		return txtName;
	}

	public JLabel getLblOnDomain() {
		return lblOnDomain;
	}

	public nextgen.swing.components.DomainVisitorTextArea getTxtOnDomain() {
		return txtOnDomain;
	}

	public JLabel getLblOnEntity() {
		return lblOnEntity;
	}

	public nextgen.swing.components.DomainVisitorTextArea getTxtOnEntity() {
		return txtOnEntity;
	}

	public JLabel getLblOnRelation() {
		return lblOnRelation;
	}

	public nextgen.swing.components.DomainVisitorTextArea getTxtOnRelation() {
		return txtOnRelation;
	}

	public JLabel getLblOnComplete() {
		return lblOnComplete;
	}

	public nextgen.swing.components.DomainVisitorTextArea getTxtOnComplete() {
		return txtOnComplete;
	}

	public JLabel getLblTemplates() {
		return lblTemplates;
	}

	public nextgen.swing.table.STTemplateTable getTblTemplates() {
		return tblTemplates;
	}

	public JLabel getLblOnEntityEntity() {
		return lblOnEntityEntity;
	}

	public nextgen.swing.components.DomainVisitorTextArea getTxtOnEntityEntity() {
		return txtOnEntityEntity;
	}

	public JLabel getLblOnEnumEntity() {
		return lblOnEnumEntity;
	}

	public nextgen.swing.components.DomainVisitorTextArea getTxtOnEnumEntity() {
		return txtOnEnumEntity;
	}

	public JLabel getLblOnPrimitiveEntity() {
		return lblOnPrimitiveEntity;
	}

	public nextgen.swing.components.DomainVisitorTextArea getTxtOnPrimitiveEntity() {
		return txtOnPrimitiveEntity;
	}

	public JLabel getLblOnOneEntityRelation() {
		return lblOnOneEntityRelation;
	}

	public nextgen.swing.components.DomainVisitorTextArea getTxtOnOneEntityRelation() {
		return txtOnOneEntityRelation;
	}

	public JLabel getLblOnOneEnumRelation() {
		return lblOnOneEnumRelation;
	}

	public nextgen.swing.components.DomainVisitorTextArea getTxtOnOneEnumRelation() {
		return txtOnOneEnumRelation;
	}

	public JLabel getLblOnOnePrimitiveRelation() {
		return lblOnOnePrimitiveRelation;
	}

	public nextgen.swing.components.DomainVisitorTextArea getTxtOnOnePrimitiveRelation() {
		return txtOnOnePrimitiveRelation;
	}

	public JLabel getLblOnManyEntityRelation() {
		return lblOnManyEntityRelation;
	}

	public nextgen.swing.components.DomainVisitorTextArea getTxtOnManyEntityRelation() {
		return txtOnManyEntityRelation;
	}

	public JLabel getLblOnManyEnumRelation() {
		return lblOnManyEnumRelation;
	}

	public nextgen.swing.components.DomainVisitorTextArea getTxtOnManyEnumRelation() {
		return txtOnManyEnumRelation;
	}

	public JLabel getLblOnManyPrimitiveRelation() {
		return lblOnManyPrimitiveRelation;
	}

	public nextgen.swing.components.DomainVisitorTextArea getTxtOnManyPrimitiveRelation() {
		return txtOnManyPrimitiveRelation;
	}

	public JLabel getLblOnOptionalEntityRelation() {
		return lblOnOptionalEntityRelation;
	}

	public nextgen.swing.components.DomainVisitorTextArea getTxtOnOptionalEntityRelation() {
		return txtOnOptionalEntityRelation;
	}

	public JLabel getLblOnOptionalEnumRelation() {
		return lblOnOptionalEnumRelation;
	}

	public nextgen.swing.components.DomainVisitorTextArea getTxtOnOptionalEnumRelation() {
		return txtOnOptionalEnumRelation;
	}

	public JLabel getLblOnOptionalPrimitiveRelation() {
		return lblOnOptionalPrimitiveRelation;
	}

	public nextgen.swing.components.DomainVisitorTextArea getTxtOnOptionalPrimitiveRelation() {
		return txtOnOptionalPrimitiveRelation;
	}


	public void modelToView(nextgen.model.DomainVisitor model) { 
		txtName.setText(model.getName());
		txtOnDomain.setText(model.getOnDomain());
		txtOnEntity.setText(model.getOnEntity());
		txtOnRelation.setText(model.getOnRelation());
		txtOnComplete.setText(model.getOnComplete());
		tblTemplates.setContent(model.getTemplates());
		txtOnEntityEntity.setText(model.getOnEntityEntity());
		txtOnEnumEntity.setText(model.getOnEnumEntity());
		txtOnPrimitiveEntity.setText(model.getOnPrimitiveEntity());
		txtOnOneEntityRelation.setText(model.getOnOneEntityRelation());
		txtOnOneEnumRelation.setText(model.getOnOneEnumRelation());
		txtOnOnePrimitiveRelation.setText(model.getOnOnePrimitiveRelation());
		txtOnManyEntityRelation.setText(model.getOnManyEntityRelation());
		txtOnManyEnumRelation.setText(model.getOnManyEnumRelation());
		txtOnManyPrimitiveRelation.setText(model.getOnManyPrimitiveRelation());
		txtOnOptionalEntityRelation.setText(model.getOnOptionalEntityRelation());
		txtOnOptionalEnumRelation.setText(model.getOnOptionalEnumRelation());
		txtOnOptionalPrimitiveRelation.setText(model.getOnOptionalPrimitiveRelation());	
	}

	public void viewToModel(nextgen.model.DomainVisitor model) {
		model.setName(txtName.getText());
		model.setOnDomain(txtOnDomain.getText());
		model.setOnEntity(txtOnEntity.getText());
		model.setOnRelation(txtOnRelation.getText());
		model.setOnComplete(txtOnComplete.getText());
		model.setOnEntityEntity(txtOnEntityEntity.getText());
		model.setOnEnumEntity(txtOnEnumEntity.getText());
		model.setOnPrimitiveEntity(txtOnPrimitiveEntity.getText());
		model.setOnOneEntityRelation(txtOnOneEntityRelation.getText());
		model.setOnOneEnumRelation(txtOnOneEnumRelation.getText());
		model.setOnOnePrimitiveRelation(txtOnOnePrimitiveRelation.getText());
		model.setOnManyEntityRelation(txtOnManyEntityRelation.getText());
		model.setOnManyEnumRelation(txtOnManyEnumRelation.getText());
		model.setOnManyPrimitiveRelation(txtOnManyPrimitiveRelation.getText());
		model.setOnOptionalEntityRelation(txtOnOptionalEntityRelation.getText());
		model.setOnOptionalEnumRelation(txtOnOptionalEnumRelation.getText());
		model.setOnOptionalPrimitiveRelation(txtOnOptionalPrimitiveRelation.getText());	
	}  
	/*

	columns 		"left:2400:none"

	rows 		 	"center:pref:none, center:pref:none, center:pref:none, center:150:grow, center:pref:none, center:150:grow, center:pref:none, center:150:grow, center:pref:none, center:150:grow, center:200:grow, center:pref:none, center:150:grow, center:pref:none, center:150:grow, center:pref:none, center:150:grow, center:pref:none, center:150:grow, center:pref:none, center:150:grow, center:pref:none, center:150:grow, center:pref:none, center:150:grow, center:pref:none, center:150:grow, center:pref:none, center:150:grow, center:pref:none, center:150:grow, center:pref:none, center:150:grow, center:pref:none, center:150:grow"

	*/
}  