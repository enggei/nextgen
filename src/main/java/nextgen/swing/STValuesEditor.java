package nextgen.swing;

import nextgen.model.STValue;
import nextgen.model.STValueType;

import javax.swing.*;
import java.util.stream.Collectors;

public class STValuesEditor extends SearchReplaceEditor {

    public STValuesEditor() {
        super();
    }

    @Override
    protected java.util.stream.Stream<nextgen.model.STModel> getSTModels() {
        return java.util.stream.Stream.empty(); // ignored - overrides getSearchAction
    }

    @Override
    protected Action getSearchAction(JTextField txtSearch) {
        return appModel().newTransactionAction("Search", transaction -> {
            reset();
            resultsModel.setResult(appModel().db.findAllSTValue()
                  .filter(stValue -> stValue.getType() != null)
                  .filter(stValue -> stValue.getType().equals(STValueType.PRIMITIVE))
                  .filter(STValue::hasValue)
                  .filter(stValue -> stValue.getValue().contains(txtSearch.getText()))
                  .map(STValueElement::new)
                  .collect(Collectors.toList()));
        });
    }
}