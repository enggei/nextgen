package nextgen.templates.materialui;

public class AutocompleteElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _autoComplete;
	private Object _autoHighlight;
	private Object _autoSelect;
	private Object _blurOnSelect;
	private Object _ChipProps;
	private Object _classes;
	private Object _className;
	private Object _clearOnBlur;
	private Object _clearOnEscape;
	private Object _clearText;
	private Object _closeIcon;
	private Object _closeText;
	private Object _debug;
	private Object _defaultValue;
	private Object _disableClearable;
	private Object _disableCloseOnSelect;
	private Object _disabled;
	private Object _disabledItemsFocusable;
	private Object _disableListWrap;
	private Object _disablePortal;
	private Object _filterOptions;
	private Object _filterSelectedOptions;
	private Object _forcePopupIcon;
	private Object _freeSolo;
	private Object _fullWidth;
	private Object _getLimitTagsText;
	private Object _getOptionDisabled;
	private Object _getOptionLabel;
	private Object _getOptionSelected;
	private Object _groupBy;
	private Object _handleHomeEndKeys;
	private Object _id;
	private Object _includeInputInList;
	private Object _inputValue;
	private Object _limitTags;
	private Object _ListboxComponent;
	private Object _ListboxProps;
	private Object _loading;
	private Object _loadingText;
	private Object _multiple;
	private Object _noOptionsText;
	private Object _onChange;
	private Object _onClose;
	private Object _onHighlightChange;
	private Object _onInputChange;
	private Object _onOpen;
	private Object _open;
	private Object _openOnFocus;
	private Object _openText;
	private Object _options;
	private Object _PaperComponent;
	private Object _PopperComponent;
	private Object _popupIcon;
	private Object _renderGroup;
	private Object _renderInput;
	private Object _renderOption;
	private Object _renderTags;
	private Object _selectOnFocus;
	private Object _size;
	private Object _value;

	AutocompleteElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Deprecated
	public java.util.UUID uuid() {
		return uuid;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("AutocompleteElement");
		st.add("autoComplete", _autoComplete);
		st.add("autoHighlight", _autoHighlight);
		st.add("autoSelect", _autoSelect);
		st.add("blurOnSelect", _blurOnSelect);
		st.add("ChipProps", _ChipProps);
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("clearOnBlur", _clearOnBlur);
		st.add("clearOnEscape", _clearOnEscape);
		st.add("clearText", _clearText);
		st.add("closeIcon", _closeIcon);
		st.add("closeText", _closeText);
		st.add("debug", _debug);
		st.add("defaultValue", _defaultValue);
		st.add("disableClearable", _disableClearable);
		st.add("disableCloseOnSelect", _disableCloseOnSelect);
		st.add("disabled", _disabled);
		st.add("disabledItemsFocusable", _disabledItemsFocusable);
		st.add("disableListWrap", _disableListWrap);
		st.add("disablePortal", _disablePortal);
		st.add("filterOptions", _filterOptions);
		st.add("filterSelectedOptions", _filterSelectedOptions);
		st.add("forcePopupIcon", _forcePopupIcon);
		st.add("freeSolo", _freeSolo);
		st.add("fullWidth", _fullWidth);
		st.add("getLimitTagsText", _getLimitTagsText);
		st.add("getOptionDisabled", _getOptionDisabled);
		st.add("getOptionLabel", _getOptionLabel);
		st.add("getOptionSelected", _getOptionSelected);
		st.add("groupBy", _groupBy);
		st.add("handleHomeEndKeys", _handleHomeEndKeys);
		st.add("id", _id);
		st.add("includeInputInList", _includeInputInList);
		st.add("inputValue", _inputValue);
		st.add("limitTags", _limitTags);
		st.add("ListboxComponent", _ListboxComponent);
		st.add("ListboxProps", _ListboxProps);
		st.add("loading", _loading);
		st.add("loadingText", _loadingText);
		st.add("multiple", _multiple);
		st.add("noOptionsText", _noOptionsText);
		st.add("onChange", _onChange);
		st.add("onClose", _onClose);
		st.add("onHighlightChange", _onHighlightChange);
		st.add("onInputChange", _onInputChange);
		st.add("onOpen", _onOpen);
		st.add("open", _open);
		st.add("openOnFocus", _openOnFocus);
		st.add("openText", _openText);
		st.add("options", _options);
		st.add("PaperComponent", _PaperComponent);
		st.add("PopperComponent", _PopperComponent);
		st.add("popupIcon", _popupIcon);
		st.add("renderGroup", _renderGroup);
		st.add("renderInput", _renderInput);
		st.add("renderOption", _renderOption);
		st.add("renderTags", _renderTags);
		st.add("selectOnFocus", _selectOnFocus);
		st.add("size", _size);
		st.add("value", _value);
		return st.render().trim();
	}

	public AutocompleteElement setAutoComplete(Object value) {
		this._autoComplete = value;
		return this;
	}

	public Object getAutoComplete() {
		return this._autoComplete;
	}

	public Object getAutoComplete(Object defaultValue) {
		return this._autoComplete == null ? defaultValue : this._autoComplete;
	}

	public boolean hasAutoComplete() {
		return this._autoComplete != null;
	}

	public AutocompleteElement removeAutoComplete() {
		this._autoComplete = null;
		return this;
	} 

	public AutocompleteElement setAutoHighlight(Object value) {
		this._autoHighlight = value;
		return this;
	}

	public Object getAutoHighlight() {
		return this._autoHighlight;
	}

	public Object getAutoHighlight(Object defaultValue) {
		return this._autoHighlight == null ? defaultValue : this._autoHighlight;
	}

	public boolean hasAutoHighlight() {
		return this._autoHighlight != null;
	}

	public AutocompleteElement removeAutoHighlight() {
		this._autoHighlight = null;
		return this;
	} 

	public AutocompleteElement setAutoSelect(Object value) {
		this._autoSelect = value;
		return this;
	}

	public Object getAutoSelect() {
		return this._autoSelect;
	}

	public Object getAutoSelect(Object defaultValue) {
		return this._autoSelect == null ? defaultValue : this._autoSelect;
	}

	public boolean hasAutoSelect() {
		return this._autoSelect != null;
	}

	public AutocompleteElement removeAutoSelect() {
		this._autoSelect = null;
		return this;
	} 

	public AutocompleteElement setBlurOnSelect(Object value) {
		this._blurOnSelect = value;
		return this;
	}

	public Object getBlurOnSelect() {
		return this._blurOnSelect;
	}

	public Object getBlurOnSelect(Object defaultValue) {
		return this._blurOnSelect == null ? defaultValue : this._blurOnSelect;
	}

	public boolean hasBlurOnSelect() {
		return this._blurOnSelect != null;
	}

	public AutocompleteElement removeBlurOnSelect() {
		this._blurOnSelect = null;
		return this;
	} 

	public AutocompleteElement setChipProps(Object value) {
		this._ChipProps = value;
		return this;
	}

	public Object getChipProps() {
		return this._ChipProps;
	}

	public Object getChipProps(Object defaultValue) {
		return this._ChipProps == null ? defaultValue : this._ChipProps;
	}

	public boolean hasChipProps() {
		return this._ChipProps != null;
	}

	public AutocompleteElement removeChipProps() {
		this._ChipProps = null;
		return this;
	} 

	public AutocompleteElement setClasses(Object value) {
		this._classes = value;
		return this;
	}

	public Object getClasses() {
		return this._classes;
	}

	public Object getClasses(Object defaultValue) {
		return this._classes == null ? defaultValue : this._classes;
	}

	public boolean hasClasses() {
		return this._classes != null;
	}

	public AutocompleteElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public AutocompleteElement setClassName(Object value) {
		this._className = value;
		return this;
	}

	public Object getClassName() {
		return this._className;
	}

	public Object getClassName(Object defaultValue) {
		return this._className == null ? defaultValue : this._className;
	}

	public boolean hasClassName() {
		return this._className != null;
	}

	public AutocompleteElement removeClassName() {
		this._className = null;
		return this;
	} 

	public AutocompleteElement setClearOnBlur(Object value) {
		this._clearOnBlur = value;
		return this;
	}

	public Object getClearOnBlur() {
		return this._clearOnBlur;
	}

	public Object getClearOnBlur(Object defaultValue) {
		return this._clearOnBlur == null ? defaultValue : this._clearOnBlur;
	}

	public boolean hasClearOnBlur() {
		return this._clearOnBlur != null;
	}

	public AutocompleteElement removeClearOnBlur() {
		this._clearOnBlur = null;
		return this;
	} 

	public AutocompleteElement setClearOnEscape(Object value) {
		this._clearOnEscape = value;
		return this;
	}

	public Object getClearOnEscape() {
		return this._clearOnEscape;
	}

	public Object getClearOnEscape(Object defaultValue) {
		return this._clearOnEscape == null ? defaultValue : this._clearOnEscape;
	}

	public boolean hasClearOnEscape() {
		return this._clearOnEscape != null;
	}

	public AutocompleteElement removeClearOnEscape() {
		this._clearOnEscape = null;
		return this;
	} 

	public AutocompleteElement setClearText(Object value) {
		this._clearText = value;
		return this;
	}

	public Object getClearText() {
		return this._clearText;
	}

	public Object getClearText(Object defaultValue) {
		return this._clearText == null ? defaultValue : this._clearText;
	}

	public boolean hasClearText() {
		return this._clearText != null;
	}

	public AutocompleteElement removeClearText() {
		this._clearText = null;
		return this;
	} 

	public AutocompleteElement setCloseIcon(Object value) {
		this._closeIcon = value;
		return this;
	}

	public Object getCloseIcon() {
		return this._closeIcon;
	}

	public Object getCloseIcon(Object defaultValue) {
		return this._closeIcon == null ? defaultValue : this._closeIcon;
	}

	public boolean hasCloseIcon() {
		return this._closeIcon != null;
	}

	public AutocompleteElement removeCloseIcon() {
		this._closeIcon = null;
		return this;
	} 

	public AutocompleteElement setCloseText(Object value) {
		this._closeText = value;
		return this;
	}

	public Object getCloseText() {
		return this._closeText;
	}

	public Object getCloseText(Object defaultValue) {
		return this._closeText == null ? defaultValue : this._closeText;
	}

	public boolean hasCloseText() {
		return this._closeText != null;
	}

	public AutocompleteElement removeCloseText() {
		this._closeText = null;
		return this;
	} 

	public AutocompleteElement setDebug(Object value) {
		this._debug = value;
		return this;
	}

	public Object getDebug() {
		return this._debug;
	}

	public Object getDebug(Object defaultValue) {
		return this._debug == null ? defaultValue : this._debug;
	}

	public boolean hasDebug() {
		return this._debug != null;
	}

	public AutocompleteElement removeDebug() {
		this._debug = null;
		return this;
	} 

	public AutocompleteElement setDefaultValue(Object value) {
		this._defaultValue = value;
		return this;
	}

	public Object getDefaultValue() {
		return this._defaultValue;
	}

	public Object getDefaultValue(Object defaultValue) {
		return this._defaultValue == null ? defaultValue : this._defaultValue;
	}

	public boolean hasDefaultValue() {
		return this._defaultValue != null;
	}

	public AutocompleteElement removeDefaultValue() {
		this._defaultValue = null;
		return this;
	} 

	public AutocompleteElement setDisableClearable(Object value) {
		this._disableClearable = value;
		return this;
	}

	public Object getDisableClearable() {
		return this._disableClearable;
	}

	public Object getDisableClearable(Object defaultValue) {
		return this._disableClearable == null ? defaultValue : this._disableClearable;
	}

	public boolean hasDisableClearable() {
		return this._disableClearable != null;
	}

	public AutocompleteElement removeDisableClearable() {
		this._disableClearable = null;
		return this;
	} 

	public AutocompleteElement setDisableCloseOnSelect(Object value) {
		this._disableCloseOnSelect = value;
		return this;
	}

	public Object getDisableCloseOnSelect() {
		return this._disableCloseOnSelect;
	}

	public Object getDisableCloseOnSelect(Object defaultValue) {
		return this._disableCloseOnSelect == null ? defaultValue : this._disableCloseOnSelect;
	}

	public boolean hasDisableCloseOnSelect() {
		return this._disableCloseOnSelect != null;
	}

	public AutocompleteElement removeDisableCloseOnSelect() {
		this._disableCloseOnSelect = null;
		return this;
	} 

	public AutocompleteElement setDisabled(Object value) {
		this._disabled = value;
		return this;
	}

	public Object getDisabled() {
		return this._disabled;
	}

	public Object getDisabled(Object defaultValue) {
		return this._disabled == null ? defaultValue : this._disabled;
	}

	public boolean hasDisabled() {
		return this._disabled != null;
	}

	public AutocompleteElement removeDisabled() {
		this._disabled = null;
		return this;
	} 

	public AutocompleteElement setDisabledItemsFocusable(Object value) {
		this._disabledItemsFocusable = value;
		return this;
	}

	public Object getDisabledItemsFocusable() {
		return this._disabledItemsFocusable;
	}

	public Object getDisabledItemsFocusable(Object defaultValue) {
		return this._disabledItemsFocusable == null ? defaultValue : this._disabledItemsFocusable;
	}

	public boolean hasDisabledItemsFocusable() {
		return this._disabledItemsFocusable != null;
	}

	public AutocompleteElement removeDisabledItemsFocusable() {
		this._disabledItemsFocusable = null;
		return this;
	} 

	public AutocompleteElement setDisableListWrap(Object value) {
		this._disableListWrap = value;
		return this;
	}

	public Object getDisableListWrap() {
		return this._disableListWrap;
	}

	public Object getDisableListWrap(Object defaultValue) {
		return this._disableListWrap == null ? defaultValue : this._disableListWrap;
	}

	public boolean hasDisableListWrap() {
		return this._disableListWrap != null;
	}

	public AutocompleteElement removeDisableListWrap() {
		this._disableListWrap = null;
		return this;
	} 

	public AutocompleteElement setDisablePortal(Object value) {
		this._disablePortal = value;
		return this;
	}

	public Object getDisablePortal() {
		return this._disablePortal;
	}

	public Object getDisablePortal(Object defaultValue) {
		return this._disablePortal == null ? defaultValue : this._disablePortal;
	}

	public boolean hasDisablePortal() {
		return this._disablePortal != null;
	}

	public AutocompleteElement removeDisablePortal() {
		this._disablePortal = null;
		return this;
	} 

	public AutocompleteElement setFilterOptions(Object value) {
		this._filterOptions = value;
		return this;
	}

	public Object getFilterOptions() {
		return this._filterOptions;
	}

	public Object getFilterOptions(Object defaultValue) {
		return this._filterOptions == null ? defaultValue : this._filterOptions;
	}

	public boolean hasFilterOptions() {
		return this._filterOptions != null;
	}

	public AutocompleteElement removeFilterOptions() {
		this._filterOptions = null;
		return this;
	} 

	public AutocompleteElement setFilterSelectedOptions(Object value) {
		this._filterSelectedOptions = value;
		return this;
	}

	public Object getFilterSelectedOptions() {
		return this._filterSelectedOptions;
	}

	public Object getFilterSelectedOptions(Object defaultValue) {
		return this._filterSelectedOptions == null ? defaultValue : this._filterSelectedOptions;
	}

	public boolean hasFilterSelectedOptions() {
		return this._filterSelectedOptions != null;
	}

	public AutocompleteElement removeFilterSelectedOptions() {
		this._filterSelectedOptions = null;
		return this;
	} 

	public AutocompleteElement setForcePopupIcon(Object value) {
		this._forcePopupIcon = value;
		return this;
	}

	public Object getForcePopupIcon() {
		return this._forcePopupIcon;
	}

	public Object getForcePopupIcon(Object defaultValue) {
		return this._forcePopupIcon == null ? defaultValue : this._forcePopupIcon;
	}

	public boolean hasForcePopupIcon() {
		return this._forcePopupIcon != null;
	}

	public AutocompleteElement removeForcePopupIcon() {
		this._forcePopupIcon = null;
		return this;
	} 

	public AutocompleteElement setFreeSolo(Object value) {
		this._freeSolo = value;
		return this;
	}

	public Object getFreeSolo() {
		return this._freeSolo;
	}

	public Object getFreeSolo(Object defaultValue) {
		return this._freeSolo == null ? defaultValue : this._freeSolo;
	}

	public boolean hasFreeSolo() {
		return this._freeSolo != null;
	}

	public AutocompleteElement removeFreeSolo() {
		this._freeSolo = null;
		return this;
	} 

	public AutocompleteElement setFullWidth(Object value) {
		this._fullWidth = value;
		return this;
	}

	public Object getFullWidth() {
		return this._fullWidth;
	}

	public Object getFullWidth(Object defaultValue) {
		return this._fullWidth == null ? defaultValue : this._fullWidth;
	}

	public boolean hasFullWidth() {
		return this._fullWidth != null;
	}

	public AutocompleteElement removeFullWidth() {
		this._fullWidth = null;
		return this;
	} 

	public AutocompleteElement setGetLimitTagsText(Object value) {
		this._getLimitTagsText = value;
		return this;
	}

	public Object getGetLimitTagsText() {
		return this._getLimitTagsText;
	}

	public Object getGetLimitTagsText(Object defaultValue) {
		return this._getLimitTagsText == null ? defaultValue : this._getLimitTagsText;
	}

	public boolean hasGetLimitTagsText() {
		return this._getLimitTagsText != null;
	}

	public AutocompleteElement removeGetLimitTagsText() {
		this._getLimitTagsText = null;
		return this;
	} 

	public AutocompleteElement setGetOptionDisabled(Object value) {
		this._getOptionDisabled = value;
		return this;
	}

	public Object getGetOptionDisabled() {
		return this._getOptionDisabled;
	}

	public Object getGetOptionDisabled(Object defaultValue) {
		return this._getOptionDisabled == null ? defaultValue : this._getOptionDisabled;
	}

	public boolean hasGetOptionDisabled() {
		return this._getOptionDisabled != null;
	}

	public AutocompleteElement removeGetOptionDisabled() {
		this._getOptionDisabled = null;
		return this;
	} 

	public AutocompleteElement setGetOptionLabel(Object value) {
		this._getOptionLabel = value;
		return this;
	}

	public Object getGetOptionLabel() {
		return this._getOptionLabel;
	}

	public Object getGetOptionLabel(Object defaultValue) {
		return this._getOptionLabel == null ? defaultValue : this._getOptionLabel;
	}

	public boolean hasGetOptionLabel() {
		return this._getOptionLabel != null;
	}

	public AutocompleteElement removeGetOptionLabel() {
		this._getOptionLabel = null;
		return this;
	} 

	public AutocompleteElement setGetOptionSelected(Object value) {
		this._getOptionSelected = value;
		return this;
	}

	public Object getGetOptionSelected() {
		return this._getOptionSelected;
	}

	public Object getGetOptionSelected(Object defaultValue) {
		return this._getOptionSelected == null ? defaultValue : this._getOptionSelected;
	}

	public boolean hasGetOptionSelected() {
		return this._getOptionSelected != null;
	}

	public AutocompleteElement removeGetOptionSelected() {
		this._getOptionSelected = null;
		return this;
	} 

	public AutocompleteElement setGroupBy(Object value) {
		this._groupBy = value;
		return this;
	}

	public Object getGroupBy() {
		return this._groupBy;
	}

	public Object getGroupBy(Object defaultValue) {
		return this._groupBy == null ? defaultValue : this._groupBy;
	}

	public boolean hasGroupBy() {
		return this._groupBy != null;
	}

	public AutocompleteElement removeGroupBy() {
		this._groupBy = null;
		return this;
	} 

	public AutocompleteElement setHandleHomeEndKeys(Object value) {
		this._handleHomeEndKeys = value;
		return this;
	}

	public Object getHandleHomeEndKeys() {
		return this._handleHomeEndKeys;
	}

	public Object getHandleHomeEndKeys(Object defaultValue) {
		return this._handleHomeEndKeys == null ? defaultValue : this._handleHomeEndKeys;
	}

	public boolean hasHandleHomeEndKeys() {
		return this._handleHomeEndKeys != null;
	}

	public AutocompleteElement removeHandleHomeEndKeys() {
		this._handleHomeEndKeys = null;
		return this;
	} 

	public AutocompleteElement setId(Object value) {
		this._id = value;
		return this;
	}

	public Object getId() {
		return this._id;
	}

	public Object getId(Object defaultValue) {
		return this._id == null ? defaultValue : this._id;
	}

	public boolean hasId() {
		return this._id != null;
	}

	public AutocompleteElement removeId() {
		this._id = null;
		return this;
	} 

	public AutocompleteElement setIncludeInputInList(Object value) {
		this._includeInputInList = value;
		return this;
	}

	public Object getIncludeInputInList() {
		return this._includeInputInList;
	}

	public Object getIncludeInputInList(Object defaultValue) {
		return this._includeInputInList == null ? defaultValue : this._includeInputInList;
	}

	public boolean hasIncludeInputInList() {
		return this._includeInputInList != null;
	}

	public AutocompleteElement removeIncludeInputInList() {
		this._includeInputInList = null;
		return this;
	} 

	public AutocompleteElement setInputValue(Object value) {
		this._inputValue = value;
		return this;
	}

	public Object getInputValue() {
		return this._inputValue;
	}

	public Object getInputValue(Object defaultValue) {
		return this._inputValue == null ? defaultValue : this._inputValue;
	}

	public boolean hasInputValue() {
		return this._inputValue != null;
	}

	public AutocompleteElement removeInputValue() {
		this._inputValue = null;
		return this;
	} 

	public AutocompleteElement setLimitTags(Object value) {
		this._limitTags = value;
		return this;
	}

	public Object getLimitTags() {
		return this._limitTags;
	}

	public Object getLimitTags(Object defaultValue) {
		return this._limitTags == null ? defaultValue : this._limitTags;
	}

	public boolean hasLimitTags() {
		return this._limitTags != null;
	}

	public AutocompleteElement removeLimitTags() {
		this._limitTags = null;
		return this;
	} 

	public AutocompleteElement setListboxComponent(Object value) {
		this._ListboxComponent = value;
		return this;
	}

	public Object getListboxComponent() {
		return this._ListboxComponent;
	}

	public Object getListboxComponent(Object defaultValue) {
		return this._ListboxComponent == null ? defaultValue : this._ListboxComponent;
	}

	public boolean hasListboxComponent() {
		return this._ListboxComponent != null;
	}

	public AutocompleteElement removeListboxComponent() {
		this._ListboxComponent = null;
		return this;
	} 

	public AutocompleteElement setListboxProps(Object value) {
		this._ListboxProps = value;
		return this;
	}

	public Object getListboxProps() {
		return this._ListboxProps;
	}

	public Object getListboxProps(Object defaultValue) {
		return this._ListboxProps == null ? defaultValue : this._ListboxProps;
	}

	public boolean hasListboxProps() {
		return this._ListboxProps != null;
	}

	public AutocompleteElement removeListboxProps() {
		this._ListboxProps = null;
		return this;
	} 

	public AutocompleteElement setLoading(Object value) {
		this._loading = value;
		return this;
	}

	public Object getLoading() {
		return this._loading;
	}

	public Object getLoading(Object defaultValue) {
		return this._loading == null ? defaultValue : this._loading;
	}

	public boolean hasLoading() {
		return this._loading != null;
	}

	public AutocompleteElement removeLoading() {
		this._loading = null;
		return this;
	} 

	public AutocompleteElement setLoadingText(Object value) {
		this._loadingText = value;
		return this;
	}

	public Object getLoadingText() {
		return this._loadingText;
	}

	public Object getLoadingText(Object defaultValue) {
		return this._loadingText == null ? defaultValue : this._loadingText;
	}

	public boolean hasLoadingText() {
		return this._loadingText != null;
	}

	public AutocompleteElement removeLoadingText() {
		this._loadingText = null;
		return this;
	} 

	public AutocompleteElement setMultiple(Object value) {
		this._multiple = value;
		return this;
	}

	public Object getMultiple() {
		return this._multiple;
	}

	public Object getMultiple(Object defaultValue) {
		return this._multiple == null ? defaultValue : this._multiple;
	}

	public boolean hasMultiple() {
		return this._multiple != null;
	}

	public AutocompleteElement removeMultiple() {
		this._multiple = null;
		return this;
	} 

	public AutocompleteElement setNoOptionsText(Object value) {
		this._noOptionsText = value;
		return this;
	}

	public Object getNoOptionsText() {
		return this._noOptionsText;
	}

	public Object getNoOptionsText(Object defaultValue) {
		return this._noOptionsText == null ? defaultValue : this._noOptionsText;
	}

	public boolean hasNoOptionsText() {
		return this._noOptionsText != null;
	}

	public AutocompleteElement removeNoOptionsText() {
		this._noOptionsText = null;
		return this;
	} 

	public AutocompleteElement setOnChange(Object value) {
		this._onChange = value;
		return this;
	}

	public Object getOnChange() {
		return this._onChange;
	}

	public Object getOnChange(Object defaultValue) {
		return this._onChange == null ? defaultValue : this._onChange;
	}

	public boolean hasOnChange() {
		return this._onChange != null;
	}

	public AutocompleteElement removeOnChange() {
		this._onChange = null;
		return this;
	} 

	public AutocompleteElement setOnClose(Object value) {
		this._onClose = value;
		return this;
	}

	public Object getOnClose() {
		return this._onClose;
	}

	public Object getOnClose(Object defaultValue) {
		return this._onClose == null ? defaultValue : this._onClose;
	}

	public boolean hasOnClose() {
		return this._onClose != null;
	}

	public AutocompleteElement removeOnClose() {
		this._onClose = null;
		return this;
	} 

	public AutocompleteElement setOnHighlightChange(Object value) {
		this._onHighlightChange = value;
		return this;
	}

	public Object getOnHighlightChange() {
		return this._onHighlightChange;
	}

	public Object getOnHighlightChange(Object defaultValue) {
		return this._onHighlightChange == null ? defaultValue : this._onHighlightChange;
	}

	public boolean hasOnHighlightChange() {
		return this._onHighlightChange != null;
	}

	public AutocompleteElement removeOnHighlightChange() {
		this._onHighlightChange = null;
		return this;
	} 

	public AutocompleteElement setOnInputChange(Object value) {
		this._onInputChange = value;
		return this;
	}

	public Object getOnInputChange() {
		return this._onInputChange;
	}

	public Object getOnInputChange(Object defaultValue) {
		return this._onInputChange == null ? defaultValue : this._onInputChange;
	}

	public boolean hasOnInputChange() {
		return this._onInputChange != null;
	}

	public AutocompleteElement removeOnInputChange() {
		this._onInputChange = null;
		return this;
	} 

	public AutocompleteElement setOnOpen(Object value) {
		this._onOpen = value;
		return this;
	}

	public Object getOnOpen() {
		return this._onOpen;
	}

	public Object getOnOpen(Object defaultValue) {
		return this._onOpen == null ? defaultValue : this._onOpen;
	}

	public boolean hasOnOpen() {
		return this._onOpen != null;
	}

	public AutocompleteElement removeOnOpen() {
		this._onOpen = null;
		return this;
	} 

	public AutocompleteElement setOpen(Object value) {
		this._open = value;
		return this;
	}

	public Object getOpen() {
		return this._open;
	}

	public Object getOpen(Object defaultValue) {
		return this._open == null ? defaultValue : this._open;
	}

	public boolean hasOpen() {
		return this._open != null;
	}

	public AutocompleteElement removeOpen() {
		this._open = null;
		return this;
	} 

	public AutocompleteElement setOpenOnFocus(Object value) {
		this._openOnFocus = value;
		return this;
	}

	public Object getOpenOnFocus() {
		return this._openOnFocus;
	}

	public Object getOpenOnFocus(Object defaultValue) {
		return this._openOnFocus == null ? defaultValue : this._openOnFocus;
	}

	public boolean hasOpenOnFocus() {
		return this._openOnFocus != null;
	}

	public AutocompleteElement removeOpenOnFocus() {
		this._openOnFocus = null;
		return this;
	} 

	public AutocompleteElement setOpenText(Object value) {
		this._openText = value;
		return this;
	}

	public Object getOpenText() {
		return this._openText;
	}

	public Object getOpenText(Object defaultValue) {
		return this._openText == null ? defaultValue : this._openText;
	}

	public boolean hasOpenText() {
		return this._openText != null;
	}

	public AutocompleteElement removeOpenText() {
		this._openText = null;
		return this;
	} 

	public AutocompleteElement setOptions(Object value) {
		this._options = value;
		return this;
	}

	public Object getOptions() {
		return this._options;
	}

	public Object getOptions(Object defaultValue) {
		return this._options == null ? defaultValue : this._options;
	}

	public boolean hasOptions() {
		return this._options != null;
	}

	public AutocompleteElement removeOptions() {
		this._options = null;
		return this;
	} 

	public AutocompleteElement setPaperComponent(Object value) {
		this._PaperComponent = value;
		return this;
	}

	public Object getPaperComponent() {
		return this._PaperComponent;
	}

	public Object getPaperComponent(Object defaultValue) {
		return this._PaperComponent == null ? defaultValue : this._PaperComponent;
	}

	public boolean hasPaperComponent() {
		return this._PaperComponent != null;
	}

	public AutocompleteElement removePaperComponent() {
		this._PaperComponent = null;
		return this;
	} 

	public AutocompleteElement setPopperComponent(Object value) {
		this._PopperComponent = value;
		return this;
	}

	public Object getPopperComponent() {
		return this._PopperComponent;
	}

	public Object getPopperComponent(Object defaultValue) {
		return this._PopperComponent == null ? defaultValue : this._PopperComponent;
	}

	public boolean hasPopperComponent() {
		return this._PopperComponent != null;
	}

	public AutocompleteElement removePopperComponent() {
		this._PopperComponent = null;
		return this;
	} 

	public AutocompleteElement setPopupIcon(Object value) {
		this._popupIcon = value;
		return this;
	}

	public Object getPopupIcon() {
		return this._popupIcon;
	}

	public Object getPopupIcon(Object defaultValue) {
		return this._popupIcon == null ? defaultValue : this._popupIcon;
	}

	public boolean hasPopupIcon() {
		return this._popupIcon != null;
	}

	public AutocompleteElement removePopupIcon() {
		this._popupIcon = null;
		return this;
	} 

	public AutocompleteElement setRenderGroup(Object value) {
		this._renderGroup = value;
		return this;
	}

	public Object getRenderGroup() {
		return this._renderGroup;
	}

	public Object getRenderGroup(Object defaultValue) {
		return this._renderGroup == null ? defaultValue : this._renderGroup;
	}

	public boolean hasRenderGroup() {
		return this._renderGroup != null;
	}

	public AutocompleteElement removeRenderGroup() {
		this._renderGroup = null;
		return this;
	} 

	public AutocompleteElement setRenderInput(Object value) {
		this._renderInput = value;
		return this;
	}

	public Object getRenderInput() {
		return this._renderInput;
	}

	public Object getRenderInput(Object defaultValue) {
		return this._renderInput == null ? defaultValue : this._renderInput;
	}

	public boolean hasRenderInput() {
		return this._renderInput != null;
	}

	public AutocompleteElement removeRenderInput() {
		this._renderInput = null;
		return this;
	} 

	public AutocompleteElement setRenderOption(Object value) {
		this._renderOption = value;
		return this;
	}

	public Object getRenderOption() {
		return this._renderOption;
	}

	public Object getRenderOption(Object defaultValue) {
		return this._renderOption == null ? defaultValue : this._renderOption;
	}

	public boolean hasRenderOption() {
		return this._renderOption != null;
	}

	public AutocompleteElement removeRenderOption() {
		this._renderOption = null;
		return this;
	} 

	public AutocompleteElement setRenderTags(Object value) {
		this._renderTags = value;
		return this;
	}

	public Object getRenderTags() {
		return this._renderTags;
	}

	public Object getRenderTags(Object defaultValue) {
		return this._renderTags == null ? defaultValue : this._renderTags;
	}

	public boolean hasRenderTags() {
		return this._renderTags != null;
	}

	public AutocompleteElement removeRenderTags() {
		this._renderTags = null;
		return this;
	} 

	public AutocompleteElement setSelectOnFocus(Object value) {
		this._selectOnFocus = value;
		return this;
	}

	public Object getSelectOnFocus() {
		return this._selectOnFocus;
	}

	public Object getSelectOnFocus(Object defaultValue) {
		return this._selectOnFocus == null ? defaultValue : this._selectOnFocus;
	}

	public boolean hasSelectOnFocus() {
		return this._selectOnFocus != null;
	}

	public AutocompleteElement removeSelectOnFocus() {
		this._selectOnFocus = null;
		return this;
	} 

	public AutocompleteElement setSize(Object value) {
		this._size = value;
		return this;
	}

	public Object getSize() {
		return this._size;
	}

	public Object getSize(Object defaultValue) {
		return this._size == null ? defaultValue : this._size;
	}

	public boolean hasSize() {
		return this._size != null;
	}

	public AutocompleteElement removeSize() {
		this._size = null;
		return this;
	} 

	public AutocompleteElement setValue(Object value) {
		this._value = value;
		return this;
	}

	public Object getValue() {
		return this._value;
	}

	public Object getValue(Object defaultValue) {
		return this._value == null ? defaultValue : this._value;
	}

	public boolean hasValue() {
		return this._value != null;
	}

	public AutocompleteElement removeValue() {
		this._value = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		AutocompleteElement that = (AutocompleteElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "AutocompleteElement(autoComplete,autoHighlight,autoSelect,blurOnSelect,ChipProps,classes,className,clearOnBlur,clearOnEscape,clearText,closeIcon,closeText,debug,defaultValue,disableClearable,disableCloseOnSelect,disabled,disabledItemsFocusable,disableListWrap,disablePortal,filterOptions,filterSelectedOptions,forcePopupIcon,freeSolo,fullWidth,getLimitTagsText,getOptionDisabled,getOptionLabel,getOptionSelected,groupBy,handleHomeEndKeys,id,includeInputInList,inputValue,limitTags,ListboxComponent,ListboxProps,loading,loadingText,multiple,noOptionsText,onChange,onClose,onHighlightChange,onInputChange,onOpen,open,openOnFocus,openText,options,PaperComponent,PopperComponent,popupIcon,renderGroup,renderInput,renderOption,renderTags,selectOnFocus,size,value) ::= <<<Autocomplete~if(autoComplete)~\n" + 
				"	autoComplete~endif~~if(autoHighlight)~\n" + 
				"	autoHighlight~endif~~if(autoSelect)~\n" + 
				"	autoSelect~endif~~if(blurOnSelect)~\n" + 
				"	blurOnSelect=\"~blurOnSelect~\"~endif~~if(ChipProps)~\n" + 
				"	ChipProps=~ChipProps~~endif~~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(clearOnBlur)~\n" + 
				"	clearOnBlur~endif~~if(clearOnEscape)~\n" + 
				"	clearOnEscape~endif~~if(clearText)~\n" + 
				"	clearText=\"~clearText~\"~endif~~if(closeIcon)~\n" + 
				"	closeIcon=~closeIcon~~endif~~if(closeText)~\n" + 
				"	closeText=\"~closeText~\"~endif~~if(debug)~\n" + 
				"	debug~endif~~if(defaultValue)~\n" + 
				"	defaultValue=~defaultValue~~endif~~if(disableClearable)~\n" + 
				"	disableClearable~endif~~if(disableCloseOnSelect)~\n" + 
				"	disableCloseOnSelect~endif~~if(disabled)~\n" + 
				"	disabled~endif~~if(disabledItemsFocusable)~\n" + 
				"	disabledItemsFocusable~endif~~if(disableListWrap)~\n" + 
				"	disableListWrap~endif~~if(disablePortal)~\n" + 
				"	disablePortal~endif~~if(filterOptions)~\n" + 
				"	filterOptions=~filterOptions~~endif~~if(filterSelectedOptions)~\n" + 
				"	filterSelectedOptions~endif~~if(forcePopupIcon)~\n" + 
				"	forcePopupIcon=\"~forcePopupIcon~\"~endif~~if(freeSolo)~\n" + 
				"	freeSolo~endif~~if(fullWidth)~\n" + 
				"	fullWidth~endif~~if(getLimitTagsText)~\n" + 
				"	getLimitTagsText=~getLimitTagsText~~endif~~if(getOptionDisabled)~\n" + 
				"	getOptionDisabled=~getOptionDisabled~~endif~~if(getOptionLabel)~\n" + 
				"	getOptionLabel=~getOptionLabel~~endif~~if(getOptionSelected)~\n" + 
				"	getOptionSelected=~getOptionSelected~~endif~~if(groupBy)~\n" + 
				"	groupBy=~groupBy~~endif~~if(handleHomeEndKeys)~\n" + 
				"	handleHomeEndKeys~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(includeInputInList)~\n" + 
				"	includeInputInList~endif~~if(inputValue)~\n" + 
				"	inputValue=\"~inputValue~\"~endif~~if(limitTags)~\n" + 
				"	limitTags=~limitTags~~endif~~if(ListboxComponent)~\n" + 
				"	ListboxComponent=~ListboxComponent~~endif~~if(ListboxProps)~\n" + 
				"	ListboxProps=~ListboxProps~~endif~~if(loading)~\n" + 
				"	loading~endif~~if(loadingText)~\n" + 
				"	loadingText=~loadingText~~endif~~if(multiple)~\n" + 
				"	multiple~endif~~if(noOptionsText)~\n" + 
				"	noOptionsText=~noOptionsText~~endif~~if(onChange)~\n" + 
				"	onChange=~onChange~~endif~~if(onClose)~\n" + 
				"	onClose=~onClose~~endif~~if(onHighlightChange)~\n" + 
				"	onHighlightChange=~onHighlightChange~~endif~~if(onInputChange)~\n" + 
				"	onInputChange=~onInputChange~~endif~~if(onOpen)~\n" + 
				"	onOpen=~onOpen~~endif~~if(open)~\n" + 
				"	open~endif~~if(openOnFocus)~\n" + 
				"	openOnFocus~endif~~if(openText)~\n" + 
				"	openText=\"~openText~\"~endif~\n" + 
				"	options=~options~~if(PaperComponent)~\n" + 
				"	PaperComponent=~PaperComponent~~endif~~if(PopperComponent)~\n" + 
				"	PopperComponent=~PopperComponent~~endif~~if(popupIcon)~\n" + 
				"	popupIcon=~popupIcon~~endif~~if(renderGroup)~\n" + 
				"	renderGroup=~renderGroup~~endif~\n" + 
				"	renderInput=~renderInput~~if(renderOption)~\n" + 
				"	renderOption=~renderOption~~endif~~if(renderTags)~\n" + 
				"	renderTags=~renderTags~~endif~~if(selectOnFocus)~\n" + 
				"	selectOnFocus~endif~~if(size)~\n" + 
				"	size=\"~size~\"~endif~~if(value)~\n" + 
				"	value=~value~~endif~ /> >>";
}  