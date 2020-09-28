package nextgen.templates.materialui.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class AutocompleteElementModel {

	public static final String stGroupModelUuid = "321c04de-dca6-45c6-bbff-ebdcf1e62d5d";
	public static final String stTemplateUuid = "15831b65-1da9-4bce-9615-6d321f650428";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public AutocompleteElementModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public AutocompleteElementModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public AutocompleteElementModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public AutocompleteElementModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		AutocompleteElementModel that = (AutocompleteElementModel) o;
		return stModel.equals(that.stModel);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(stModel);
	}

	public String getUuid() {
		return stModel.getUuid();
	}

	public STValue asSTValue () {
		return db.newSTValue(stModel);
	}

	public AutocompleteElementModel setAutoComplete(String value) {
		return setAutoComplete(db.newSTValue(value));
	}

	public AutocompleteElementModel setAutoComplete(STValue value) {
		return set(value, "autoComplete");
	}

	public STValue getAutoComplete() {
		return get("autoComplete");
	}

	public STArgument getAutoCompleteArgument() {
		return getArgument("autoComplete");
	}

	public AutocompleteElementModel removeAutoComplete() {
		return removeArgument("autoComplete");
	}

	public AutocompleteElementModel setAutoHighlight(String value) {
		return setAutoHighlight(db.newSTValue(value));
	}

	public AutocompleteElementModel setAutoHighlight(STValue value) {
		return set(value, "autoHighlight");
	}

	public STValue getAutoHighlight() {
		return get("autoHighlight");
	}

	public STArgument getAutoHighlightArgument() {
		return getArgument("autoHighlight");
	}

	public AutocompleteElementModel removeAutoHighlight() {
		return removeArgument("autoHighlight");
	}

	public AutocompleteElementModel setAutoSelect(String value) {
		return setAutoSelect(db.newSTValue(value));
	}

	public AutocompleteElementModel setAutoSelect(STValue value) {
		return set(value, "autoSelect");
	}

	public STValue getAutoSelect() {
		return get("autoSelect");
	}

	public STArgument getAutoSelectArgument() {
		return getArgument("autoSelect");
	}

	public AutocompleteElementModel removeAutoSelect() {
		return removeArgument("autoSelect");
	}

	public AutocompleteElementModel setBlurOnSelect(String value) {
		return setBlurOnSelect(db.newSTValue(value));
	}

	public AutocompleteElementModel setBlurOnSelect(STValue value) {
		return set(value, "blurOnSelect");
	}

	public STValue getBlurOnSelect() {
		return get("blurOnSelect");
	}

	public STArgument getBlurOnSelectArgument() {
		return getArgument("blurOnSelect");
	}

	public AutocompleteElementModel removeBlurOnSelect() {
		return removeArgument("blurOnSelect");
	}

	public AutocompleteElementModel setChipProps(String value) {
		return setChipProps(db.newSTValue(value));
	}

	public AutocompleteElementModel setChipProps(STValue value) {
		return set(value, "ChipProps");
	}

	public STValue getChipProps() {
		return get("ChipProps");
	}

	public STArgument getChipPropsArgument() {
		return getArgument("ChipProps");
	}

	public AutocompleteElementModel removeChipProps() {
		return removeArgument("ChipProps");
	}

	public AutocompleteElementModel setClasses(String value) {
		return setClasses(db.newSTValue(value));
	}

	public AutocompleteElementModel setClasses(STValue value) {
		return set(value, "classes");
	}

	public STValue getClasses() {
		return get("classes");
	}

	public STArgument getClassesArgument() {
		return getArgument("classes");
	}

	public AutocompleteElementModel removeClasses() {
		return removeArgument("classes");
	}

	public AutocompleteElementModel setClassName(String value) {
		return setClassName(db.newSTValue(value));
	}

	public AutocompleteElementModel setClassName(STValue value) {
		return set(value, "className");
	}

	public STValue getClassName() {
		return get("className");
	}

	public STArgument getClassNameArgument() {
		return getArgument("className");
	}

	public AutocompleteElementModel removeClassName() {
		return removeArgument("className");
	}

	public AutocompleteElementModel setClearOnBlur(String value) {
		return setClearOnBlur(db.newSTValue(value));
	}

	public AutocompleteElementModel setClearOnBlur(STValue value) {
		return set(value, "clearOnBlur");
	}

	public STValue getClearOnBlur() {
		return get("clearOnBlur");
	}

	public STArgument getClearOnBlurArgument() {
		return getArgument("clearOnBlur");
	}

	public AutocompleteElementModel removeClearOnBlur() {
		return removeArgument("clearOnBlur");
	}

	public AutocompleteElementModel setClearOnEscape(String value) {
		return setClearOnEscape(db.newSTValue(value));
	}

	public AutocompleteElementModel setClearOnEscape(STValue value) {
		return set(value, "clearOnEscape");
	}

	public STValue getClearOnEscape() {
		return get("clearOnEscape");
	}

	public STArgument getClearOnEscapeArgument() {
		return getArgument("clearOnEscape");
	}

	public AutocompleteElementModel removeClearOnEscape() {
		return removeArgument("clearOnEscape");
	}

	public AutocompleteElementModel setClearText(String value) {
		return setClearText(db.newSTValue(value));
	}

	public AutocompleteElementModel setClearText(STValue value) {
		return set(value, "clearText");
	}

	public STValue getClearText() {
		return get("clearText");
	}

	public STArgument getClearTextArgument() {
		return getArgument("clearText");
	}

	public AutocompleteElementModel removeClearText() {
		return removeArgument("clearText");
	}

	public AutocompleteElementModel setCloseIcon(String value) {
		return setCloseIcon(db.newSTValue(value));
	}

	public AutocompleteElementModel setCloseIcon(STValue value) {
		return set(value, "closeIcon");
	}

	public STValue getCloseIcon() {
		return get("closeIcon");
	}

	public STArgument getCloseIconArgument() {
		return getArgument("closeIcon");
	}

	public AutocompleteElementModel removeCloseIcon() {
		return removeArgument("closeIcon");
	}

	public AutocompleteElementModel setCloseText(String value) {
		return setCloseText(db.newSTValue(value));
	}

	public AutocompleteElementModel setCloseText(STValue value) {
		return set(value, "closeText");
	}

	public STValue getCloseText() {
		return get("closeText");
	}

	public STArgument getCloseTextArgument() {
		return getArgument("closeText");
	}

	public AutocompleteElementModel removeCloseText() {
		return removeArgument("closeText");
	}

	public AutocompleteElementModel setDebug(String value) {
		return setDebug(db.newSTValue(value));
	}

	public AutocompleteElementModel setDebug(STValue value) {
		return set(value, "debug");
	}

	public STValue getDebug() {
		return get("debug");
	}

	public STArgument getDebugArgument() {
		return getArgument("debug");
	}

	public AutocompleteElementModel removeDebug() {
		return removeArgument("debug");
	}

	public AutocompleteElementModel setDefaultValue(String value) {
		return setDefaultValue(db.newSTValue(value));
	}

	public AutocompleteElementModel setDefaultValue(STValue value) {
		return set(value, "defaultValue");
	}

	public STValue getDefaultValue() {
		return get("defaultValue");
	}

	public STArgument getDefaultValueArgument() {
		return getArgument("defaultValue");
	}

	public AutocompleteElementModel removeDefaultValue() {
		return removeArgument("defaultValue");
	}

	public AutocompleteElementModel setDisableClearable(String value) {
		return setDisableClearable(db.newSTValue(value));
	}

	public AutocompleteElementModel setDisableClearable(STValue value) {
		return set(value, "disableClearable");
	}

	public STValue getDisableClearable() {
		return get("disableClearable");
	}

	public STArgument getDisableClearableArgument() {
		return getArgument("disableClearable");
	}

	public AutocompleteElementModel removeDisableClearable() {
		return removeArgument("disableClearable");
	}

	public AutocompleteElementModel setDisableCloseOnSelect(String value) {
		return setDisableCloseOnSelect(db.newSTValue(value));
	}

	public AutocompleteElementModel setDisableCloseOnSelect(STValue value) {
		return set(value, "disableCloseOnSelect");
	}

	public STValue getDisableCloseOnSelect() {
		return get("disableCloseOnSelect");
	}

	public STArgument getDisableCloseOnSelectArgument() {
		return getArgument("disableCloseOnSelect");
	}

	public AutocompleteElementModel removeDisableCloseOnSelect() {
		return removeArgument("disableCloseOnSelect");
	}

	public AutocompleteElementModel setDisabled(String value) {
		return setDisabled(db.newSTValue(value));
	}

	public AutocompleteElementModel setDisabled(STValue value) {
		return set(value, "disabled");
	}

	public STValue getDisabled() {
		return get("disabled");
	}

	public STArgument getDisabledArgument() {
		return getArgument("disabled");
	}

	public AutocompleteElementModel removeDisabled() {
		return removeArgument("disabled");
	}

	public AutocompleteElementModel setDisabledItemsFocusable(String value) {
		return setDisabledItemsFocusable(db.newSTValue(value));
	}

	public AutocompleteElementModel setDisabledItemsFocusable(STValue value) {
		return set(value, "disabledItemsFocusable");
	}

	public STValue getDisabledItemsFocusable() {
		return get("disabledItemsFocusable");
	}

	public STArgument getDisabledItemsFocusableArgument() {
		return getArgument("disabledItemsFocusable");
	}

	public AutocompleteElementModel removeDisabledItemsFocusable() {
		return removeArgument("disabledItemsFocusable");
	}

	public AutocompleteElementModel setDisableListWrap(String value) {
		return setDisableListWrap(db.newSTValue(value));
	}

	public AutocompleteElementModel setDisableListWrap(STValue value) {
		return set(value, "disableListWrap");
	}

	public STValue getDisableListWrap() {
		return get("disableListWrap");
	}

	public STArgument getDisableListWrapArgument() {
		return getArgument("disableListWrap");
	}

	public AutocompleteElementModel removeDisableListWrap() {
		return removeArgument("disableListWrap");
	}

	public AutocompleteElementModel setDisablePortal(String value) {
		return setDisablePortal(db.newSTValue(value));
	}

	public AutocompleteElementModel setDisablePortal(STValue value) {
		return set(value, "disablePortal");
	}

	public STValue getDisablePortal() {
		return get("disablePortal");
	}

	public STArgument getDisablePortalArgument() {
		return getArgument("disablePortal");
	}

	public AutocompleteElementModel removeDisablePortal() {
		return removeArgument("disablePortal");
	}

	public AutocompleteElementModel setFilterOptions(String value) {
		return setFilterOptions(db.newSTValue(value));
	}

	public AutocompleteElementModel setFilterOptions(STValue value) {
		return set(value, "filterOptions");
	}

	public STValue getFilterOptions() {
		return get("filterOptions");
	}

	public STArgument getFilterOptionsArgument() {
		return getArgument("filterOptions");
	}

	public AutocompleteElementModel removeFilterOptions() {
		return removeArgument("filterOptions");
	}

	public AutocompleteElementModel setFilterSelectedOptions(String value) {
		return setFilterSelectedOptions(db.newSTValue(value));
	}

	public AutocompleteElementModel setFilterSelectedOptions(STValue value) {
		return set(value, "filterSelectedOptions");
	}

	public STValue getFilterSelectedOptions() {
		return get("filterSelectedOptions");
	}

	public STArgument getFilterSelectedOptionsArgument() {
		return getArgument("filterSelectedOptions");
	}

	public AutocompleteElementModel removeFilterSelectedOptions() {
		return removeArgument("filterSelectedOptions");
	}

	public AutocompleteElementModel setForcePopupIcon(String value) {
		return setForcePopupIcon(db.newSTValue(value));
	}

	public AutocompleteElementModel setForcePopupIcon(STValue value) {
		return set(value, "forcePopupIcon");
	}

	public STValue getForcePopupIcon() {
		return get("forcePopupIcon");
	}

	public STArgument getForcePopupIconArgument() {
		return getArgument("forcePopupIcon");
	}

	public AutocompleteElementModel removeForcePopupIcon() {
		return removeArgument("forcePopupIcon");
	}

	public AutocompleteElementModel setFreeSolo(String value) {
		return setFreeSolo(db.newSTValue(value));
	}

	public AutocompleteElementModel setFreeSolo(STValue value) {
		return set(value, "freeSolo");
	}

	public STValue getFreeSolo() {
		return get("freeSolo");
	}

	public STArgument getFreeSoloArgument() {
		return getArgument("freeSolo");
	}

	public AutocompleteElementModel removeFreeSolo() {
		return removeArgument("freeSolo");
	}

	public AutocompleteElementModel setFullWidth(String value) {
		return setFullWidth(db.newSTValue(value));
	}

	public AutocompleteElementModel setFullWidth(STValue value) {
		return set(value, "fullWidth");
	}

	public STValue getFullWidth() {
		return get("fullWidth");
	}

	public STArgument getFullWidthArgument() {
		return getArgument("fullWidth");
	}

	public AutocompleteElementModel removeFullWidth() {
		return removeArgument("fullWidth");
	}

	public AutocompleteElementModel setGetLimitTagsText(String value) {
		return setGetLimitTagsText(db.newSTValue(value));
	}

	public AutocompleteElementModel setGetLimitTagsText(STValue value) {
		return set(value, "getLimitTagsText");
	}

	public STValue getGetLimitTagsText() {
		return get("getLimitTagsText");
	}

	public STArgument getGetLimitTagsTextArgument() {
		return getArgument("getLimitTagsText");
	}

	public AutocompleteElementModel removeGetLimitTagsText() {
		return removeArgument("getLimitTagsText");
	}

	public AutocompleteElementModel setGetOptionDisabled(String value) {
		return setGetOptionDisabled(db.newSTValue(value));
	}

	public AutocompleteElementModel setGetOptionDisabled(STValue value) {
		return set(value, "getOptionDisabled");
	}

	public STValue getGetOptionDisabled() {
		return get("getOptionDisabled");
	}

	public STArgument getGetOptionDisabledArgument() {
		return getArgument("getOptionDisabled");
	}

	public AutocompleteElementModel removeGetOptionDisabled() {
		return removeArgument("getOptionDisabled");
	}

	public AutocompleteElementModel setGetOptionLabel(String value) {
		return setGetOptionLabel(db.newSTValue(value));
	}

	public AutocompleteElementModel setGetOptionLabel(STValue value) {
		return set(value, "getOptionLabel");
	}

	public STValue getGetOptionLabel() {
		return get("getOptionLabel");
	}

	public STArgument getGetOptionLabelArgument() {
		return getArgument("getOptionLabel");
	}

	public AutocompleteElementModel removeGetOptionLabel() {
		return removeArgument("getOptionLabel");
	}

	public AutocompleteElementModel setGetOptionSelected(String value) {
		return setGetOptionSelected(db.newSTValue(value));
	}

	public AutocompleteElementModel setGetOptionSelected(STValue value) {
		return set(value, "getOptionSelected");
	}

	public STValue getGetOptionSelected() {
		return get("getOptionSelected");
	}

	public STArgument getGetOptionSelectedArgument() {
		return getArgument("getOptionSelected");
	}

	public AutocompleteElementModel removeGetOptionSelected() {
		return removeArgument("getOptionSelected");
	}

	public AutocompleteElementModel setGroupBy(String value) {
		return setGroupBy(db.newSTValue(value));
	}

	public AutocompleteElementModel setGroupBy(STValue value) {
		return set(value, "groupBy");
	}

	public STValue getGroupBy() {
		return get("groupBy");
	}

	public STArgument getGroupByArgument() {
		return getArgument("groupBy");
	}

	public AutocompleteElementModel removeGroupBy() {
		return removeArgument("groupBy");
	}

	public AutocompleteElementModel setHandleHomeEndKeys(String value) {
		return setHandleHomeEndKeys(db.newSTValue(value));
	}

	public AutocompleteElementModel setHandleHomeEndKeys(STValue value) {
		return set(value, "handleHomeEndKeys");
	}

	public STValue getHandleHomeEndKeys() {
		return get("handleHomeEndKeys");
	}

	public STArgument getHandleHomeEndKeysArgument() {
		return getArgument("handleHomeEndKeys");
	}

	public AutocompleteElementModel removeHandleHomeEndKeys() {
		return removeArgument("handleHomeEndKeys");
	}

	public AutocompleteElementModel setId(String value) {
		return setId(db.newSTValue(value));
	}

	public AutocompleteElementModel setId(STValue value) {
		return set(value, "id");
	}

	public STValue getId() {
		return get("id");
	}

	public STArgument getIdArgument() {
		return getArgument("id");
	}

	public AutocompleteElementModel removeId() {
		return removeArgument("id");
	}

	public AutocompleteElementModel setIncludeInputInList(String value) {
		return setIncludeInputInList(db.newSTValue(value));
	}

	public AutocompleteElementModel setIncludeInputInList(STValue value) {
		return set(value, "includeInputInList");
	}

	public STValue getIncludeInputInList() {
		return get("includeInputInList");
	}

	public STArgument getIncludeInputInListArgument() {
		return getArgument("includeInputInList");
	}

	public AutocompleteElementModel removeIncludeInputInList() {
		return removeArgument("includeInputInList");
	}

	public AutocompleteElementModel setInputValue(String value) {
		return setInputValue(db.newSTValue(value));
	}

	public AutocompleteElementModel setInputValue(STValue value) {
		return set(value, "inputValue");
	}

	public STValue getInputValue() {
		return get("inputValue");
	}

	public STArgument getInputValueArgument() {
		return getArgument("inputValue");
	}

	public AutocompleteElementModel removeInputValue() {
		return removeArgument("inputValue");
	}

	public AutocompleteElementModel setKey(String value) {
		return setKey(db.newSTValue(value));
	}

	public AutocompleteElementModel setKey(STValue value) {
		return set(value, "key");
	}

	public STValue getKey() {
		return get("key");
	}

	public STArgument getKeyArgument() {
		return getArgument("key");
	}

	public AutocompleteElementModel removeKey() {
		return removeArgument("key");
	}

	public AutocompleteElementModel setLimitTags(String value) {
		return setLimitTags(db.newSTValue(value));
	}

	public AutocompleteElementModel setLimitTags(STValue value) {
		return set(value, "limitTags");
	}

	public STValue getLimitTags() {
		return get("limitTags");
	}

	public STArgument getLimitTagsArgument() {
		return getArgument("limitTags");
	}

	public AutocompleteElementModel removeLimitTags() {
		return removeArgument("limitTags");
	}

	public AutocompleteElementModel setListboxComponent(String value) {
		return setListboxComponent(db.newSTValue(value));
	}

	public AutocompleteElementModel setListboxComponent(STValue value) {
		return set(value, "ListboxComponent");
	}

	public STValue getListboxComponent() {
		return get("ListboxComponent");
	}

	public STArgument getListboxComponentArgument() {
		return getArgument("ListboxComponent");
	}

	public AutocompleteElementModel removeListboxComponent() {
		return removeArgument("ListboxComponent");
	}

	public AutocompleteElementModel setListboxProps(String value) {
		return setListboxProps(db.newSTValue(value));
	}

	public AutocompleteElementModel setListboxProps(STValue value) {
		return set(value, "ListboxProps");
	}

	public STValue getListboxProps() {
		return get("ListboxProps");
	}

	public STArgument getListboxPropsArgument() {
		return getArgument("ListboxProps");
	}

	public AutocompleteElementModel removeListboxProps() {
		return removeArgument("ListboxProps");
	}

	public AutocompleteElementModel setLoading(String value) {
		return setLoading(db.newSTValue(value));
	}

	public AutocompleteElementModel setLoading(STValue value) {
		return set(value, "loading");
	}

	public STValue getLoading() {
		return get("loading");
	}

	public STArgument getLoadingArgument() {
		return getArgument("loading");
	}

	public AutocompleteElementModel removeLoading() {
		return removeArgument("loading");
	}

	public AutocompleteElementModel setLoadingText(String value) {
		return setLoadingText(db.newSTValue(value));
	}

	public AutocompleteElementModel setLoadingText(STValue value) {
		return set(value, "loadingText");
	}

	public STValue getLoadingText() {
		return get("loadingText");
	}

	public STArgument getLoadingTextArgument() {
		return getArgument("loadingText");
	}

	public AutocompleteElementModel removeLoadingText() {
		return removeArgument("loadingText");
	}

	public AutocompleteElementModel setMultiple(String value) {
		return setMultiple(db.newSTValue(value));
	}

	public AutocompleteElementModel setMultiple(STValue value) {
		return set(value, "multiple");
	}

	public STValue getMultiple() {
		return get("multiple");
	}

	public STArgument getMultipleArgument() {
		return getArgument("multiple");
	}

	public AutocompleteElementModel removeMultiple() {
		return removeArgument("multiple");
	}

	public AutocompleteElementModel setNoOptionsText(String value) {
		return setNoOptionsText(db.newSTValue(value));
	}

	public AutocompleteElementModel setNoOptionsText(STValue value) {
		return set(value, "noOptionsText");
	}

	public STValue getNoOptionsText() {
		return get("noOptionsText");
	}

	public STArgument getNoOptionsTextArgument() {
		return getArgument("noOptionsText");
	}

	public AutocompleteElementModel removeNoOptionsText() {
		return removeArgument("noOptionsText");
	}

	public AutocompleteElementModel setOnChange(String value) {
		return setOnChange(db.newSTValue(value));
	}

	public AutocompleteElementModel setOnChange(STValue value) {
		return set(value, "onChange");
	}

	public STValue getOnChange() {
		return get("onChange");
	}

	public STArgument getOnChangeArgument() {
		return getArgument("onChange");
	}

	public AutocompleteElementModel removeOnChange() {
		return removeArgument("onChange");
	}

	public AutocompleteElementModel setOnClose(String value) {
		return setOnClose(db.newSTValue(value));
	}

	public AutocompleteElementModel setOnClose(STValue value) {
		return set(value, "onClose");
	}

	public STValue getOnClose() {
		return get("onClose");
	}

	public STArgument getOnCloseArgument() {
		return getArgument("onClose");
	}

	public AutocompleteElementModel removeOnClose() {
		return removeArgument("onClose");
	}

	public AutocompleteElementModel setOnHighlightChange(String value) {
		return setOnHighlightChange(db.newSTValue(value));
	}

	public AutocompleteElementModel setOnHighlightChange(STValue value) {
		return set(value, "onHighlightChange");
	}

	public STValue getOnHighlightChange() {
		return get("onHighlightChange");
	}

	public STArgument getOnHighlightChangeArgument() {
		return getArgument("onHighlightChange");
	}

	public AutocompleteElementModel removeOnHighlightChange() {
		return removeArgument("onHighlightChange");
	}

	public AutocompleteElementModel setOnInputChange(String value) {
		return setOnInputChange(db.newSTValue(value));
	}

	public AutocompleteElementModel setOnInputChange(STValue value) {
		return set(value, "onInputChange");
	}

	public STValue getOnInputChange() {
		return get("onInputChange");
	}

	public STArgument getOnInputChangeArgument() {
		return getArgument("onInputChange");
	}

	public AutocompleteElementModel removeOnInputChange() {
		return removeArgument("onInputChange");
	}

	public AutocompleteElementModel setOnOpen(String value) {
		return setOnOpen(db.newSTValue(value));
	}

	public AutocompleteElementModel setOnOpen(STValue value) {
		return set(value, "onOpen");
	}

	public STValue getOnOpen() {
		return get("onOpen");
	}

	public STArgument getOnOpenArgument() {
		return getArgument("onOpen");
	}

	public AutocompleteElementModel removeOnOpen() {
		return removeArgument("onOpen");
	}

	public AutocompleteElementModel setOpen(String value) {
		return setOpen(db.newSTValue(value));
	}

	public AutocompleteElementModel setOpen(STValue value) {
		return set(value, "open");
	}

	public STValue getOpen() {
		return get("open");
	}

	public STArgument getOpenArgument() {
		return getArgument("open");
	}

	public AutocompleteElementModel removeOpen() {
		return removeArgument("open");
	}

	public AutocompleteElementModel setOpenOnFocus(String value) {
		return setOpenOnFocus(db.newSTValue(value));
	}

	public AutocompleteElementModel setOpenOnFocus(STValue value) {
		return set(value, "openOnFocus");
	}

	public STValue getOpenOnFocus() {
		return get("openOnFocus");
	}

	public STArgument getOpenOnFocusArgument() {
		return getArgument("openOnFocus");
	}

	public AutocompleteElementModel removeOpenOnFocus() {
		return removeArgument("openOnFocus");
	}

	public AutocompleteElementModel setOpenText(String value) {
		return setOpenText(db.newSTValue(value));
	}

	public AutocompleteElementModel setOpenText(STValue value) {
		return set(value, "openText");
	}

	public STValue getOpenText() {
		return get("openText");
	}

	public STArgument getOpenTextArgument() {
		return getArgument("openText");
	}

	public AutocompleteElementModel removeOpenText() {
		return removeArgument("openText");
	}

	public AutocompleteElementModel setOptions(String value) {
		return setOptions(db.newSTValue(value));
	}

	public AutocompleteElementModel setOptions(STValue value) {
		return set(value, "options");
	}

	public STValue getOptions() {
		return get("options");
	}

	public STArgument getOptionsArgument() {
		return getArgument("options");
	}

	public AutocompleteElementModel removeOptions() {
		return removeArgument("options");
	}

	public AutocompleteElementModel setPaperComponent(String value) {
		return setPaperComponent(db.newSTValue(value));
	}

	public AutocompleteElementModel setPaperComponent(STValue value) {
		return set(value, "PaperComponent");
	}

	public STValue getPaperComponent() {
		return get("PaperComponent");
	}

	public STArgument getPaperComponentArgument() {
		return getArgument("PaperComponent");
	}

	public AutocompleteElementModel removePaperComponent() {
		return removeArgument("PaperComponent");
	}

	public AutocompleteElementModel setPopperComponent(String value) {
		return setPopperComponent(db.newSTValue(value));
	}

	public AutocompleteElementModel setPopperComponent(STValue value) {
		return set(value, "PopperComponent");
	}

	public STValue getPopperComponent() {
		return get("PopperComponent");
	}

	public STArgument getPopperComponentArgument() {
		return getArgument("PopperComponent");
	}

	public AutocompleteElementModel removePopperComponent() {
		return removeArgument("PopperComponent");
	}

	public AutocompleteElementModel setPopupIcon(String value) {
		return setPopupIcon(db.newSTValue(value));
	}

	public AutocompleteElementModel setPopupIcon(STValue value) {
		return set(value, "popupIcon");
	}

	public STValue getPopupIcon() {
		return get("popupIcon");
	}

	public STArgument getPopupIconArgument() {
		return getArgument("popupIcon");
	}

	public AutocompleteElementModel removePopupIcon() {
		return removeArgument("popupIcon");
	}

	public AutocompleteElementModel setRenderGroup(String value) {
		return setRenderGroup(db.newSTValue(value));
	}

	public AutocompleteElementModel setRenderGroup(STValue value) {
		return set(value, "renderGroup");
	}

	public STValue getRenderGroup() {
		return get("renderGroup");
	}

	public STArgument getRenderGroupArgument() {
		return getArgument("renderGroup");
	}

	public AutocompleteElementModel removeRenderGroup() {
		return removeArgument("renderGroup");
	}

	public AutocompleteElementModel setRenderInput(String value) {
		return setRenderInput(db.newSTValue(value));
	}

	public AutocompleteElementModel setRenderInput(STValue value) {
		return set(value, "renderInput");
	}

	public STValue getRenderInput() {
		return get("renderInput");
	}

	public STArgument getRenderInputArgument() {
		return getArgument("renderInput");
	}

	public AutocompleteElementModel removeRenderInput() {
		return removeArgument("renderInput");
	}

	public AutocompleteElementModel setRenderOption(String value) {
		return setRenderOption(db.newSTValue(value));
	}

	public AutocompleteElementModel setRenderOption(STValue value) {
		return set(value, "renderOption");
	}

	public STValue getRenderOption() {
		return get("renderOption");
	}

	public STArgument getRenderOptionArgument() {
		return getArgument("renderOption");
	}

	public AutocompleteElementModel removeRenderOption() {
		return removeArgument("renderOption");
	}

	public AutocompleteElementModel setRenderTags(String value) {
		return setRenderTags(db.newSTValue(value));
	}

	public AutocompleteElementModel setRenderTags(STValue value) {
		return set(value, "renderTags");
	}

	public STValue getRenderTags() {
		return get("renderTags");
	}

	public STArgument getRenderTagsArgument() {
		return getArgument("renderTags");
	}

	public AutocompleteElementModel removeRenderTags() {
		return removeArgument("renderTags");
	}

	public AutocompleteElementModel setSelectOnFocus(String value) {
		return setSelectOnFocus(db.newSTValue(value));
	}

	public AutocompleteElementModel setSelectOnFocus(STValue value) {
		return set(value, "selectOnFocus");
	}

	public STValue getSelectOnFocus() {
		return get("selectOnFocus");
	}

	public STArgument getSelectOnFocusArgument() {
		return getArgument("selectOnFocus");
	}

	public AutocompleteElementModel removeSelectOnFocus() {
		return removeArgument("selectOnFocus");
	}

	public AutocompleteElementModel setSize(String value) {
		return setSize(db.newSTValue(value));
	}

	public AutocompleteElementModel setSize(STValue value) {
		return set(value, "size");
	}

	public STValue getSize() {
		return get("size");
	}

	public STArgument getSizeArgument() {
		return getArgument("size");
	}

	public AutocompleteElementModel removeSize() {
		return removeArgument("size");
	}

	public AutocompleteElementModel setStyle(String value) {
		return setStyle(db.newSTValue(value));
	}

	public AutocompleteElementModel setStyle(STValue value) {
		return set(value, "style");
	}

	public STValue getStyle() {
		return get("style");
	}

	public STArgument getStyleArgument() {
		return getArgument("style");
	}

	public AutocompleteElementModel removeStyle() {
		return removeArgument("style");
	}

	public AutocompleteElementModel setValue(String value) {
		return setValue(db.newSTValue(value));
	}

	public AutocompleteElementModel setValue(STValue value) {
		return set(value, "value");
	}

	public STValue getValue() {
		return get("value");
	}

	public STArgument getValueArgument() {
		return getArgument("value");
	}

	public AutocompleteElementModel removeValue() {
		return removeArgument("value");
	}


	public AutocompleteElementModel addAttribute(String _name, String _value) {
		return addAttribute(db.newSTValue(_name), db.newSTValue(_value));
	}

	public AutocompleteElementModel addAttribute(AutocompleteElementModel_Attribute value) {
		return addAttribute(value.getName(), value.getValue());
	}

	public AutocompleteElementModel addAttribute(STValue _name, STValue _value) {
		findParameter("attribute")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_value, stParameter, kvs, "value");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<AutocompleteElementModel_Attribute> streamAttribute() {
		return findParameter("attribute")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new AutocompleteElementModel_Attribute(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class AutocompleteElementModel_Attribute {

		STArgument stArgument;
		STParameter stParameter;

		public AutocompleteElementModel_Attribute(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public AutocompleteElementModel_Attribute setName(String value) {
			return setName(db.newSTValue(value));
		}

		public AutocompleteElementModel_Attribute setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public AutocompleteElementModel_Attribute setValue(String value) {
			return setValue(db.newSTValue(value));
		}

		public AutocompleteElementModel_Attribute setValue(STValue value) {
			return setKVValue("value", value);
		}

		public STValue getValue() {
			return getKVValue("value");
		}


		private AutocompleteElementModel_Attribute setKVValue(String name, STValue value) {

			stParameter.getKeys()
					.filter(stParameterKey -> stParameterKey.getName().equals(name))
					.findAny()
					.ifPresent(stParameterKey -> {

						stArgument.getKeyValues()
								.filter(stArgumentKV -> stArgumentKV.getStParameterKey().equals(stParameterKey.getUuid()))
								.findAny()
								.ifPresent(stArgumentKV -> stArgument.removeKeyValues(stArgumentKV));

						stArgument.addKeyValues(db.newSTArgumentKV(stParameterKey, value));
					});

			return this;
		}

		private STValue getKVValue(String name) {
			final AtomicReference<STValue> value = new AtomicReference<>();
			stParameter.getKeys()
					.filter(param -> param.getName().equals(name))
					.findFirst().flatMap(stParameter -> stArgument.getKeyValues()
					.filter(stArgument -> stArgument.getStParameterKey().equals(stParameter.getUuid()))
					.findAny()).ifPresent(stArgument -> value.set(stArgument.getValue()));

			return value.get();
		}
	}

	private AutocompleteElementModel set(STValue value, String name) {
		findParameter(name)
				.ifPresent(stParameter -> {

					stModel.getArguments()
							.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
							.findAny()
							.ifPresent(stModel::removeArguments);

					stModel.addArguments(db.newSTArgument(stParameter, value));
				});
		return this;
	}

	private STValue get(String name) {
		final AtomicReference<STValue> value = new AtomicReference<>();
		findParameter(name).flatMap(stParameter -> stModel.getArguments()
				.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
				.findAny()).ifPresent(stArgument -> value.set(stArgument.getValue()));
		return value.get();
	}

	private STArgument getArgument(String name) {
		final AtomicReference<STArgument> value = new AtomicReference<>();
		findParameter(name).flatMap(stParameter -> stModel.getArguments()
				.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
				.findAny()).ifPresent(value::set);
		return value.get();
	}

	private AutocompleteElementModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private AutocompleteElementModel add(STValue value, String name) {
		findParameter(name)
				.ifPresent(stParameter -> stModel.addArguments(db.newSTArgument(stParameter, value)));
		return this;
	}

	private Stream<STValue> stream(String name) {
		return findParameter(name)
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(STArgument::getValue)).orElseGet(Stream::empty);
	}

	private Optional<STParameter> findParameter(String name) {
		return stTemplate.getParameters()
				.filter(param -> param.getName().equals(name))
				.findFirst();
	}

	private void addKV(STValue _type, STParameter stParameter, Collection<STArgumentKV> kvs, String type) {
		stParameter.getKeys()
				.filter(stParameterKey -> stParameterKey.getName().equals(type))
				.findFirst()
				.ifPresent(stParameterKey -> kvs.add(db.newSTArgumentKV(stParameterKey, _type)));
	}
}