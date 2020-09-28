package nextgen.templates.materialui.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class AlertElementModel {

	public static final String stGroupModelUuid = "321c04de-dca6-45c6-bbff-ebdcf1e62d5d";
	public static final String stTemplateUuid = "a1e7caf4-a545-433a-9487-bdee22e0e9be";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public AlertElementModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public AlertElementModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public AlertElementModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public AlertElementModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		AlertElementModel that = (AlertElementModel) o;
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

	public AlertElementModel setAction(String value) {
		return setAction(db.newSTValue(value));
	}

	public AlertElementModel setAction(STValue value) {
		return set(value, "action");
	}

	public STValue getAction() {
		return get("action");
	}

	public STArgument getActionArgument() {
		return getArgument("action");
	}

	public AlertElementModel removeAction() {
		return removeArgument("action");
	}

	public AlertElementModel setClasses(String value) {
		return setClasses(db.newSTValue(value));
	}

	public AlertElementModel setClasses(STValue value) {
		return set(value, "classes");
	}

	public STValue getClasses() {
		return get("classes");
	}

	public STArgument getClassesArgument() {
		return getArgument("classes");
	}

	public AlertElementModel removeClasses() {
		return removeArgument("classes");
	}

	public AlertElementModel setClassName(String value) {
		return setClassName(db.newSTValue(value));
	}

	public AlertElementModel setClassName(STValue value) {
		return set(value, "className");
	}

	public STValue getClassName() {
		return get("className");
	}

	public STArgument getClassNameArgument() {
		return getArgument("className");
	}

	public AlertElementModel removeClassName() {
		return removeArgument("className");
	}

	public AlertElementModel setCloseText(String value) {
		return setCloseText(db.newSTValue(value));
	}

	public AlertElementModel setCloseText(STValue value) {
		return set(value, "closeText");
	}

	public STValue getCloseText() {
		return get("closeText");
	}

	public STArgument getCloseTextArgument() {
		return getArgument("closeText");
	}

	public AlertElementModel removeCloseText() {
		return removeArgument("closeText");
	}

	public AlertElementModel setColor(String value) {
		return setColor(db.newSTValue(value));
	}

	public AlertElementModel setColor(STValue value) {
		return set(value, "color");
	}

	public STValue getColor() {
		return get("color");
	}

	public STArgument getColorArgument() {
		return getArgument("color");
	}

	public AlertElementModel removeColor() {
		return removeArgument("color");
	}

	public AlertElementModel setIcon(String value) {
		return setIcon(db.newSTValue(value));
	}

	public AlertElementModel setIcon(STValue value) {
		return set(value, "icon");
	}

	public STValue getIcon() {
		return get("icon");
	}

	public STArgument getIconArgument() {
		return getArgument("icon");
	}

	public AlertElementModel removeIcon() {
		return removeArgument("icon");
	}

	public AlertElementModel setIconMapping(String value) {
		return setIconMapping(db.newSTValue(value));
	}

	public AlertElementModel setIconMapping(STValue value) {
		return set(value, "iconMapping");
	}

	public STValue getIconMapping() {
		return get("iconMapping");
	}

	public STArgument getIconMappingArgument() {
		return getArgument("iconMapping");
	}

	public AlertElementModel removeIconMapping() {
		return removeArgument("iconMapping");
	}

	public AlertElementModel setId(String value) {
		return setId(db.newSTValue(value));
	}

	public AlertElementModel setId(STValue value) {
		return set(value, "id");
	}

	public STValue getId() {
		return get("id");
	}

	public STArgument getIdArgument() {
		return getArgument("id");
	}

	public AlertElementModel removeId() {
		return removeArgument("id");
	}

	public AlertElementModel setKey(String value) {
		return setKey(db.newSTValue(value));
	}

	public AlertElementModel setKey(STValue value) {
		return set(value, "key");
	}

	public STValue getKey() {
		return get("key");
	}

	public STArgument getKeyArgument() {
		return getArgument("key");
	}

	public AlertElementModel removeKey() {
		return removeArgument("key");
	}

	public AlertElementModel setOnClose(String value) {
		return setOnClose(db.newSTValue(value));
	}

	public AlertElementModel setOnClose(STValue value) {
		return set(value, "onClose");
	}

	public STValue getOnClose() {
		return get("onClose");
	}

	public STArgument getOnCloseArgument() {
		return getArgument("onClose");
	}

	public AlertElementModel removeOnClose() {
		return removeArgument("onClose");
	}

	public AlertElementModel setRole(String value) {
		return setRole(db.newSTValue(value));
	}

	public AlertElementModel setRole(STValue value) {
		return set(value, "role");
	}

	public STValue getRole() {
		return get("role");
	}

	public STArgument getRoleArgument() {
		return getArgument("role");
	}

	public AlertElementModel removeRole() {
		return removeArgument("role");
	}

	public AlertElementModel setSeverity(String value) {
		return setSeverity(db.newSTValue(value));
	}

	public AlertElementModel setSeverity(STValue value) {
		return set(value, "severity");
	}

	public STValue getSeverity() {
		return get("severity");
	}

	public STArgument getSeverityArgument() {
		return getArgument("severity");
	}

	public AlertElementModel removeSeverity() {
		return removeArgument("severity");
	}

	public AlertElementModel setStyle(String value) {
		return setStyle(db.newSTValue(value));
	}

	public AlertElementModel setStyle(STValue value) {
		return set(value, "style");
	}

	public STValue getStyle() {
		return get("style");
	}

	public STArgument getStyleArgument() {
		return getArgument("style");
	}

	public AlertElementModel removeStyle() {
		return removeArgument("style");
	}

	public AlertElementModel setVariant(String value) {
		return setVariant(db.newSTValue(value));
	}

	public AlertElementModel setVariant(STValue value) {
		return set(value, "variant");
	}

	public STValue getVariant() {
		return get("variant");
	}

	public STArgument getVariantArgument() {
		return getArgument("variant");
	}

	public AlertElementModel removeVariant() {
		return removeArgument("variant");
	}

	public AlertElementModel addChildren(String value) {
		return addChildren(db.newSTValue(value));
	}

	public AlertElementModel addChildren(STValue value) {
		return add(value, "children");
	}

	public Stream<STValue> getChildren() {
		return stream("children");
	}

	public AlertElementModel addAttribute(String _name, String _value) {
		return addAttribute(db.newSTValue(_name), db.newSTValue(_value));
	}

	public AlertElementModel addAttribute(AlertElementModel_Attribute value) {
		return addAttribute(value.getName(), value.getValue());
	}

	public AlertElementModel addAttribute(STValue _name, STValue _value) {
		findParameter("attribute")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_value, stParameter, kvs, "value");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<AlertElementModel_Attribute> streamAttribute() {
		return findParameter("attribute")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new AlertElementModel_Attribute(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class AlertElementModel_Attribute {

		STArgument stArgument;
		STParameter stParameter;

		public AlertElementModel_Attribute(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public AlertElementModel_Attribute setName(String value) {
			return setName(db.newSTValue(value));
		}

		public AlertElementModel_Attribute setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public AlertElementModel_Attribute setValue(String value) {
			return setValue(db.newSTValue(value));
		}

		public AlertElementModel_Attribute setValue(STValue value) {
			return setKVValue("value", value);
		}

		public STValue getValue() {
			return getKVValue("value");
		}


		private AlertElementModel_Attribute setKVValue(String name, STValue value) {

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

	private AlertElementModel set(STValue value, String name) {
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

	private AlertElementModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private AlertElementModel add(STValue value, String name) {
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