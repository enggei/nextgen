package nextgen.templates.materialui.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class UnstableTrapFocusElementModel {

	public static final String stGroupModelUuid = "321c04de-dca6-45c6-bbff-ebdcf1e62d5d";
	public static final String stTemplateUuid = "d2f70ce4-615e-4a6d-8c35-34381b647d4f";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public UnstableTrapFocusElementModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public UnstableTrapFocusElementModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public UnstableTrapFocusElementModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public UnstableTrapFocusElementModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		UnstableTrapFocusElementModel that = (UnstableTrapFocusElementModel) o;
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

	public UnstableTrapFocusElementModel setClassName(String value) {
		return setClassName(db.newSTValue(value));
	}

	public UnstableTrapFocusElementModel setClassName(STValue value) {
		return set(value, "className");
	}

	public STValue getClassName() {
		return get("className");
	}

	public STArgument getClassNameArgument() {
		return getArgument("className");
	}

	public UnstableTrapFocusElementModel removeClassName() {
		return removeArgument("className");
	}

	public UnstableTrapFocusElementModel setDisableAutoFocus(String value) {
		return setDisableAutoFocus(db.newSTValue(value));
	}

	public UnstableTrapFocusElementModel setDisableAutoFocus(STValue value) {
		return set(value, "disableAutoFocus");
	}

	public STValue getDisableAutoFocus() {
		return get("disableAutoFocus");
	}

	public STArgument getDisableAutoFocusArgument() {
		return getArgument("disableAutoFocus");
	}

	public UnstableTrapFocusElementModel removeDisableAutoFocus() {
		return removeArgument("disableAutoFocus");
	}

	public UnstableTrapFocusElementModel setDisableEnforceFocus(String value) {
		return setDisableEnforceFocus(db.newSTValue(value));
	}

	public UnstableTrapFocusElementModel setDisableEnforceFocus(STValue value) {
		return set(value, "disableEnforceFocus");
	}

	public STValue getDisableEnforceFocus() {
		return get("disableEnforceFocus");
	}

	public STArgument getDisableEnforceFocusArgument() {
		return getArgument("disableEnforceFocus");
	}

	public UnstableTrapFocusElementModel removeDisableEnforceFocus() {
		return removeArgument("disableEnforceFocus");
	}

	public UnstableTrapFocusElementModel setDisableRestoreFocus(String value) {
		return setDisableRestoreFocus(db.newSTValue(value));
	}

	public UnstableTrapFocusElementModel setDisableRestoreFocus(STValue value) {
		return set(value, "disableRestoreFocus");
	}

	public STValue getDisableRestoreFocus() {
		return get("disableRestoreFocus");
	}

	public STArgument getDisableRestoreFocusArgument() {
		return getArgument("disableRestoreFocus");
	}

	public UnstableTrapFocusElementModel removeDisableRestoreFocus() {
		return removeArgument("disableRestoreFocus");
	}

	public UnstableTrapFocusElementModel setGetDoc(String value) {
		return setGetDoc(db.newSTValue(value));
	}

	public UnstableTrapFocusElementModel setGetDoc(STValue value) {
		return set(value, "getDoc");
	}

	public STValue getGetDoc() {
		return get("getDoc");
	}

	public STArgument getGetDocArgument() {
		return getArgument("getDoc");
	}

	public UnstableTrapFocusElementModel removeGetDoc() {
		return removeArgument("getDoc");
	}

	public UnstableTrapFocusElementModel setId(String value) {
		return setId(db.newSTValue(value));
	}

	public UnstableTrapFocusElementModel setId(STValue value) {
		return set(value, "id");
	}

	public STValue getId() {
		return get("id");
	}

	public STArgument getIdArgument() {
		return getArgument("id");
	}

	public UnstableTrapFocusElementModel removeId() {
		return removeArgument("id");
	}

	public UnstableTrapFocusElementModel setIsEnabled(String value) {
		return setIsEnabled(db.newSTValue(value));
	}

	public UnstableTrapFocusElementModel setIsEnabled(STValue value) {
		return set(value, "isEnabled");
	}

	public STValue getIsEnabled() {
		return get("isEnabled");
	}

	public STArgument getIsEnabledArgument() {
		return getArgument("isEnabled");
	}

	public UnstableTrapFocusElementModel removeIsEnabled() {
		return removeArgument("isEnabled");
	}

	public UnstableTrapFocusElementModel setKey(String value) {
		return setKey(db.newSTValue(value));
	}

	public UnstableTrapFocusElementModel setKey(STValue value) {
		return set(value, "key");
	}

	public STValue getKey() {
		return get("key");
	}

	public STArgument getKeyArgument() {
		return getArgument("key");
	}

	public UnstableTrapFocusElementModel removeKey() {
		return removeArgument("key");
	}

	public UnstableTrapFocusElementModel setStyle(String value) {
		return setStyle(db.newSTValue(value));
	}

	public UnstableTrapFocusElementModel setStyle(STValue value) {
		return set(value, "style");
	}

	public STValue getStyle() {
		return get("style");
	}

	public STArgument getStyleArgument() {
		return getArgument("style");
	}

	public UnstableTrapFocusElementModel removeStyle() {
		return removeArgument("style");
	}

	public UnstableTrapFocusElementModel addChildren(String value) {
		return addChildren(db.newSTValue(value));
	}

	public UnstableTrapFocusElementModel addChildren(STValue value) {
		return add(value, "children");
	}

	public Stream<STValue> getChildren() {
		return stream("children");
	}

	public UnstableTrapFocusElementModel addAttribute(String _name, String _value) {
		return addAttribute(db.newSTValue(_name), db.newSTValue(_value));
	}

	public UnstableTrapFocusElementModel addAttribute(UnstableTrapFocusElementModel_Attribute value) {
		return addAttribute(value.getName(), value.getValue());
	}

	public UnstableTrapFocusElementModel addAttribute(STValue _name, STValue _value) {
		findParameter("attribute")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_value, stParameter, kvs, "value");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<UnstableTrapFocusElementModel_Attribute> streamAttribute() {
		return findParameter("attribute")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new UnstableTrapFocusElementModel_Attribute(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class UnstableTrapFocusElementModel_Attribute {

		STArgument stArgument;
		STParameter stParameter;

		public UnstableTrapFocusElementModel_Attribute(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public UnstableTrapFocusElementModel_Attribute setName(String value) {
			return setName(db.newSTValue(value));
		}

		public UnstableTrapFocusElementModel_Attribute setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public UnstableTrapFocusElementModel_Attribute setValue(String value) {
			return setValue(db.newSTValue(value));
		}

		public UnstableTrapFocusElementModel_Attribute setValue(STValue value) {
			return setKVValue("value", value);
		}

		public STValue getValue() {
			return getKVValue("value");
		}


		private UnstableTrapFocusElementModel_Attribute setKVValue(String name, STValue value) {

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

	private UnstableTrapFocusElementModel set(STValue value, String name) {
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

	private UnstableTrapFocusElementModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private UnstableTrapFocusElementModel add(STValue value, String name) {
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