package nextgen.templates.materialui.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class ContainerElementModel {

	public static final String stGroupModelUuid = "321c04de-dca6-45c6-bbff-ebdcf1e62d5d";
	public static final String stTemplateUuid = "99a68165-a9dd-4a94-8172-4cea189eed53";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public ContainerElementModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public ContainerElementModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public ContainerElementModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public ContainerElementModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ContainerElementModel that = (ContainerElementModel) o;
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

	public ContainerElementModel setClasses(String value) {
		return setClasses(db.newSTValue(value));
	}

	public ContainerElementModel setClasses(STValue value) {
		return set(value, "classes");
	}

	public STValue getClasses() {
		return get("classes");
	}

	public STArgument getClassesArgument() {
		return getArgument("classes");
	}

	public ContainerElementModel removeClasses() {
		return removeArgument("classes");
	}

	public ContainerElementModel setClassName(String value) {
		return setClassName(db.newSTValue(value));
	}

	public ContainerElementModel setClassName(STValue value) {
		return set(value, "className");
	}

	public STValue getClassName() {
		return get("className");
	}

	public STArgument getClassNameArgument() {
		return getArgument("className");
	}

	public ContainerElementModel removeClassName() {
		return removeArgument("className");
	}

	public ContainerElementModel setComponent(String value) {
		return setComponent(db.newSTValue(value));
	}

	public ContainerElementModel setComponent(STValue value) {
		return set(value, "component");
	}

	public STValue getComponent() {
		return get("component");
	}

	public STArgument getComponentArgument() {
		return getArgument("component");
	}

	public ContainerElementModel removeComponent() {
		return removeArgument("component");
	}

	public ContainerElementModel setDisableGutters(String value) {
		return setDisableGutters(db.newSTValue(value));
	}

	public ContainerElementModel setDisableGutters(STValue value) {
		return set(value, "disableGutters");
	}

	public STValue getDisableGutters() {
		return get("disableGutters");
	}

	public STArgument getDisableGuttersArgument() {
		return getArgument("disableGutters");
	}

	public ContainerElementModel removeDisableGutters() {
		return removeArgument("disableGutters");
	}

	public ContainerElementModel setFixed(String value) {
		return setFixed(db.newSTValue(value));
	}

	public ContainerElementModel setFixed(STValue value) {
		return set(value, "fixed");
	}

	public STValue getFixed() {
		return get("fixed");
	}

	public STArgument getFixedArgument() {
		return getArgument("fixed");
	}

	public ContainerElementModel removeFixed() {
		return removeArgument("fixed");
	}

	public ContainerElementModel setId(String value) {
		return setId(db.newSTValue(value));
	}

	public ContainerElementModel setId(STValue value) {
		return set(value, "id");
	}

	public STValue getId() {
		return get("id");
	}

	public STArgument getIdArgument() {
		return getArgument("id");
	}

	public ContainerElementModel removeId() {
		return removeArgument("id");
	}

	public ContainerElementModel setKey(String value) {
		return setKey(db.newSTValue(value));
	}

	public ContainerElementModel setKey(STValue value) {
		return set(value, "key");
	}

	public STValue getKey() {
		return get("key");
	}

	public STArgument getKeyArgument() {
		return getArgument("key");
	}

	public ContainerElementModel removeKey() {
		return removeArgument("key");
	}

	public ContainerElementModel setMaxWidth(String value) {
		return setMaxWidth(db.newSTValue(value));
	}

	public ContainerElementModel setMaxWidth(STValue value) {
		return set(value, "maxWidth");
	}

	public STValue getMaxWidth() {
		return get("maxWidth");
	}

	public STArgument getMaxWidthArgument() {
		return getArgument("maxWidth");
	}

	public ContainerElementModel removeMaxWidth() {
		return removeArgument("maxWidth");
	}

	public ContainerElementModel setStyle(String value) {
		return setStyle(db.newSTValue(value));
	}

	public ContainerElementModel setStyle(STValue value) {
		return set(value, "style");
	}

	public STValue getStyle() {
		return get("style");
	}

	public STArgument getStyleArgument() {
		return getArgument("style");
	}

	public ContainerElementModel removeStyle() {
		return removeArgument("style");
	}

	public ContainerElementModel addChildren(String value) {
		return addChildren(db.newSTValue(value));
	}

	public ContainerElementModel addChildren(STValue value) {
		return add(value, "children");
	}

	public Stream<STValue> getChildren() {
		return stream("children");
	}

	public ContainerElementModel addAttribute(String _name, String _value) {
		return addAttribute(db.newSTValue(_name), db.newSTValue(_value));
	}

	public ContainerElementModel addAttribute(ContainerElementModel_Attribute value) {
		return addAttribute(value.getName(), value.getValue());
	}

	public ContainerElementModel addAttribute(STValue _name, STValue _value) {
		findParameter("attribute")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_value, stParameter, kvs, "value");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<ContainerElementModel_Attribute> streamAttribute() {
		return findParameter("attribute")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new ContainerElementModel_Attribute(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class ContainerElementModel_Attribute {

		STArgument stArgument;
		STParameter stParameter;

		public ContainerElementModel_Attribute(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public ContainerElementModel_Attribute setName(String value) {
			return setName(db.newSTValue(value));
		}

		public ContainerElementModel_Attribute setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public ContainerElementModel_Attribute setValue(String value) {
			return setValue(db.newSTValue(value));
		}

		public ContainerElementModel_Attribute setValue(STValue value) {
			return setKVValue("value", value);
		}

		public STValue getValue() {
			return getKVValue("value");
		}


		private ContainerElementModel_Attribute setKVValue(String name, STValue value) {

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

	private ContainerElementModel set(STValue value, String name) {
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

	private ContainerElementModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private ContainerElementModel add(STValue value, String name) {
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