package nextgen.swing.editors;

import java.awt.*;

import nextgen.events.*;

public class STModelEditor extends nextgen.swing.BaseEditor<nextgen.model.STModel> {

	private final javax.swing.JTabbedPane editors = nextgen.swing.ComponentFactory.newJTabbedPane();
	private final nextgen.swing.forms.STModelForm form = new nextgen.swing.forms.STModelForm();

	public STModelEditor() {
		super();
	}

	public STModelEditor(nextgen.model.STModel model) {
		super(model, model.getUuid());
		setModel(model);
	}

	@Override
	public void setModel(nextgen.model.STModel model) {
		super.setModel(model);

		this.uuid = model.getUuid();
		form.modelToView(model);

		if (getComponentCount() == 0) {
			editors.add("Form", form);
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