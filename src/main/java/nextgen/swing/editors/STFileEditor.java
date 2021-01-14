package nextgen.swing.editors;

import java.awt.*;

import nextgen.events.*;

public class STFileEditor extends nextgen.swing.BaseEditor<nextgen.model.STFile> {

	private final javax.swing.JTabbedPane editors = nextgen.swing.ComponentFactory.newJTabbedPane();
	private final nextgen.swing.forms.STFileForm form = new nextgen.swing.forms.STFileForm();

	public STFileEditor() {
		super();
	}

	public STFileEditor(nextgen.model.STFile model) {
		super(model, model.getUuid());
		setModel(model);
	}

	@Override
	public void setModel(nextgen.model.STFile model) {
		super.setModel(model);

		this.uuid = model.getUuid();
		form.modelToView(model);

		if (getComponentCount() == 0) {
			editors.add("Form", nextgen.swing.ComponentFactory.newJScrollPane(form));
			add(editors, BorderLayout.CENTER);
			invalidate();
		}
	}

	@Override
	protected void tryToSave() {
		if (model == null) return;
		form.viewToModel();
	}

	

}  