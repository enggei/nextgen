package nextgen.swing.forms;

import javax.swing.*;

import com.jgoodies.binding.adapter.Bindings;
import com.jgoodies.binding.value.AbstractValueModel;
import com.jgoodies.binding.value.ValueModel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.CellConstraints;

import nextgen.swing.ComponentFactory;
import static nextgen.swing.ComponentFactory.*;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;

public class DomainEntityForm extends JPanel {

	nextgen.model.DomainEntity model;
	JLabel name_JLabel = newJLabel("name");
	JTextField name_JTextField = newJTextField("name");
	JLabel enums_JLabel = newJLabel("enums");
	RSyntaxTextArea enums_RSyntaxTextArea = newRSyntaxTextArea("enums");
	JTextFieldModel nameModel = new JTextFieldModel(getNameJTextField());
	RSyntaxTextAreaModel enumsModel = new RSyntaxTextAreaModel(getEnumsRSyntaxTextArea());

	public DomainEntityForm() {
		setLayout(new FormLayout("center:max(50dlu;pref):none, fill:pref:grow", "center:pref:none, center:pref:none"));
		add(this.name_JLabel, new CellConstraints().xywh(1, 1, 1, 1, "LEFT, TOP"));
		add(this.name_JTextField, new CellConstraints().xywh(2, 1, 1, 1, "FILL, FILL"));
		add(newJScrollPane(this.enums_JLabel), new CellConstraints().xywh(1, 2, 1, 1, "LEFT, TOP"));
		add(newJScrollPane(this.enums_RSyntaxTextArea), new CellConstraints().xywh(2, 2, 1, 1, "FILL, FILL"));
	}

	public <T extends JLabel> T getNameJLabel() {
		return (T) name_JLabel;
	}

	public <T extends JTextField> T getNameJTextField() {
		return (T) name_JTextField;
	}

	public <T extends JLabel> T getEnumsJLabel() {
		return (T) enums_JLabel;
	}

	public <T extends RSyntaxTextArea> T getEnumsRSyntaxTextArea() {
		return (T) enums_RSyntaxTextArea;
	}


	public void modelToView(nextgen.model.DomainEntity model) {
		this.model = model;
		nameModel.setValue(model.getName());
		enumsModel.setValue(model.getEnums());
	}

	public void modelToView() {
		nameModel.setValue(model.getName());
		enumsModel.setValue(model.getEnums());
	}

	public nextgen.model.DomainEntity viewToModel() {
		model.setName((String) nameModel.getValue());
		model.setEnums((String) enumsModel.getValue());
		return model;
	}


	/*

	columns 		"center:max(50dlu;pref):none, fill:pref:grow"

	rows 		 	"center:pref:none, center:pref:none"


	*/	

	public static final class JTextFieldModel extends AbstractValueModel {

		private String value;
		private final ValueModel valueModel = new AbstractValueModel() {

			@Override
			public Object getValue() { return value; }

			@Override
			public void setValue(Object o) { 
				String old = value;
				value = o == null ? null : o.toString();
				fireValueChange(old, value);
			}
		};

		public JTextFieldModel(JTextField component) {
			Bindings.bind(component, valueModel);
		}

		@Override
		public Object getValue() {
			return valueModel.getValue();
		}

		@Override
		public void setValue(Object o) {
			Object old = getValue();
			valueModel.setValue(o);
			fireValueChange(old, valueModel.getValue());
		}
	}

	public static final class RSyntaxTextAreaModel extends AbstractValueModel {

		private String value;
		private final ValueModel valueModel = new AbstractValueModel() {

			@Override
			public Object getValue() { return value; }

			@Override
			public void setValue(Object o) {
				String old = value;
				value = o == null ? null : o.toString();
				fireValueChange(old, value);
			}
		};

		public RSyntaxTextAreaModel(RSyntaxTextArea component) {
			Bindings.bind(component, valueModel);
		}

		@Override
		public Object getValue() {
			return valueModel.getValue();
		}

		@Override
		public void setValue(Object o) {
			Object old = getValue();
			valueModel.setValue(o);
			fireValueChange(old, valueModel.getValue());
		}
	}
}  