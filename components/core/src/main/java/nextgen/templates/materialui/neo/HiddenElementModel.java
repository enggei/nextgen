package nextgen.templates.materialui.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class HiddenElementModel {

	public static final String stGroupModelUuid = "321c04de-dca6-45c6-bbff-ebdcf1e62d5d";
	public static final String stTemplateUuid = "4ebcbd9b-fe57-4ec4-b917-daa4ffe6eab6";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public HiddenElementModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public HiddenElementModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public HiddenElementModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public HiddenElementModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		HiddenElementModel that = (HiddenElementModel) o;
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

	public HiddenElementModel setClassName(String value) {
		return setClassName(db.newSTValue(value));
	}

	public HiddenElementModel setClassName(STValue value) {
		return set(value, "className");
	}

	public STValue getClassName() {
		return get("className");
	}

	public STArgument getClassNameArgument() {
		return getArgument("className");
	}

	public HiddenElementModel removeClassName() {
		return removeArgument("className");
	}

	public HiddenElementModel setId(String value) {
		return setId(db.newSTValue(value));
	}

	public HiddenElementModel setId(STValue value) {
		return set(value, "id");
	}

	public STValue getId() {
		return get("id");
	}

	public STArgument getIdArgument() {
		return getArgument("id");
	}

	public HiddenElementModel removeId() {
		return removeArgument("id");
	}

	public HiddenElementModel setImplementation(String value) {
		return setImplementation(db.newSTValue(value));
	}

	public HiddenElementModel setImplementation(STValue value) {
		return set(value, "implementation");
	}

	public STValue getImplementation() {
		return get("implementation");
	}

	public STArgument getImplementationArgument() {
		return getArgument("implementation");
	}

	public HiddenElementModel removeImplementation() {
		return removeArgument("implementation");
	}

	public HiddenElementModel setInitialWidth(String value) {
		return setInitialWidth(db.newSTValue(value));
	}

	public HiddenElementModel setInitialWidth(STValue value) {
		return set(value, "initialWidth");
	}

	public STValue getInitialWidth() {
		return get("initialWidth");
	}

	public STArgument getInitialWidthArgument() {
		return getArgument("initialWidth");
	}

	public HiddenElementModel removeInitialWidth() {
		return removeArgument("initialWidth");
	}

	public HiddenElementModel setKey(String value) {
		return setKey(db.newSTValue(value));
	}

	public HiddenElementModel setKey(STValue value) {
		return set(value, "key");
	}

	public STValue getKey() {
		return get("key");
	}

	public STArgument getKeyArgument() {
		return getArgument("key");
	}

	public HiddenElementModel removeKey() {
		return removeArgument("key");
	}

	public HiddenElementModel setLgDown(String value) {
		return setLgDown(db.newSTValue(value));
	}

	public HiddenElementModel setLgDown(STValue value) {
		return set(value, "lgDown");
	}

	public STValue getLgDown() {
		return get("lgDown");
	}

	public STArgument getLgDownArgument() {
		return getArgument("lgDown");
	}

	public HiddenElementModel removeLgDown() {
		return removeArgument("lgDown");
	}

	public HiddenElementModel setLgUp(String value) {
		return setLgUp(db.newSTValue(value));
	}

	public HiddenElementModel setLgUp(STValue value) {
		return set(value, "lgUp");
	}

	public STValue getLgUp() {
		return get("lgUp");
	}

	public STArgument getLgUpArgument() {
		return getArgument("lgUp");
	}

	public HiddenElementModel removeLgUp() {
		return removeArgument("lgUp");
	}

	public HiddenElementModel setMdDown(String value) {
		return setMdDown(db.newSTValue(value));
	}

	public HiddenElementModel setMdDown(STValue value) {
		return set(value, "mdDown");
	}

	public STValue getMdDown() {
		return get("mdDown");
	}

	public STArgument getMdDownArgument() {
		return getArgument("mdDown");
	}

	public HiddenElementModel removeMdDown() {
		return removeArgument("mdDown");
	}

	public HiddenElementModel setMdUp(String value) {
		return setMdUp(db.newSTValue(value));
	}

	public HiddenElementModel setMdUp(STValue value) {
		return set(value, "mdUp");
	}

	public STValue getMdUp() {
		return get("mdUp");
	}

	public STArgument getMdUpArgument() {
		return getArgument("mdUp");
	}

	public HiddenElementModel removeMdUp() {
		return removeArgument("mdUp");
	}

	public HiddenElementModel setOnly(String value) {
		return setOnly(db.newSTValue(value));
	}

	public HiddenElementModel setOnly(STValue value) {
		return set(value, "only");
	}

	public STValue getOnly() {
		return get("only");
	}

	public STArgument getOnlyArgument() {
		return getArgument("only");
	}

	public HiddenElementModel removeOnly() {
		return removeArgument("only");
	}

	public HiddenElementModel setSmDown(String value) {
		return setSmDown(db.newSTValue(value));
	}

	public HiddenElementModel setSmDown(STValue value) {
		return set(value, "smDown");
	}

	public STValue getSmDown() {
		return get("smDown");
	}

	public STArgument getSmDownArgument() {
		return getArgument("smDown");
	}

	public HiddenElementModel removeSmDown() {
		return removeArgument("smDown");
	}

	public HiddenElementModel setSmUp(String value) {
		return setSmUp(db.newSTValue(value));
	}

	public HiddenElementModel setSmUp(STValue value) {
		return set(value, "smUp");
	}

	public STValue getSmUp() {
		return get("smUp");
	}

	public STArgument getSmUpArgument() {
		return getArgument("smUp");
	}

	public HiddenElementModel removeSmUp() {
		return removeArgument("smUp");
	}

	public HiddenElementModel setStyle(String value) {
		return setStyle(db.newSTValue(value));
	}

	public HiddenElementModel setStyle(STValue value) {
		return set(value, "style");
	}

	public STValue getStyle() {
		return get("style");
	}

	public STArgument getStyleArgument() {
		return getArgument("style");
	}

	public HiddenElementModel removeStyle() {
		return removeArgument("style");
	}

	public HiddenElementModel setXlDown(String value) {
		return setXlDown(db.newSTValue(value));
	}

	public HiddenElementModel setXlDown(STValue value) {
		return set(value, "xlDown");
	}

	public STValue getXlDown() {
		return get("xlDown");
	}

	public STArgument getXlDownArgument() {
		return getArgument("xlDown");
	}

	public HiddenElementModel removeXlDown() {
		return removeArgument("xlDown");
	}

	public HiddenElementModel setXlUp(String value) {
		return setXlUp(db.newSTValue(value));
	}

	public HiddenElementModel setXlUp(STValue value) {
		return set(value, "xlUp");
	}

	public STValue getXlUp() {
		return get("xlUp");
	}

	public STArgument getXlUpArgument() {
		return getArgument("xlUp");
	}

	public HiddenElementModel removeXlUp() {
		return removeArgument("xlUp");
	}

	public HiddenElementModel setXsDown(String value) {
		return setXsDown(db.newSTValue(value));
	}

	public HiddenElementModel setXsDown(STValue value) {
		return set(value, "xsDown");
	}

	public STValue getXsDown() {
		return get("xsDown");
	}

	public STArgument getXsDownArgument() {
		return getArgument("xsDown");
	}

	public HiddenElementModel removeXsDown() {
		return removeArgument("xsDown");
	}

	public HiddenElementModel setXsUp(String value) {
		return setXsUp(db.newSTValue(value));
	}

	public HiddenElementModel setXsUp(STValue value) {
		return set(value, "xsUp");
	}

	public STValue getXsUp() {
		return get("xsUp");
	}

	public STArgument getXsUpArgument() {
		return getArgument("xsUp");
	}

	public HiddenElementModel removeXsUp() {
		return removeArgument("xsUp");
	}

	public HiddenElementModel addChildren(String value) {
		return addChildren(db.newSTValue(value));
	}

	public HiddenElementModel addChildren(STValue value) {
		return add(value, "children");
	}

	public Stream<STValue> getChildren() {
		return stream("children");
	}

	public HiddenElementModel addAttribute(String _name, String _value) {
		return addAttribute(db.newSTValue(_name), db.newSTValue(_value));
	}

	public HiddenElementModel addAttribute(HiddenElementModel_Attribute value) {
		return addAttribute(value.getName(), value.getValue());
	}

	public HiddenElementModel addAttribute(STValue _name, STValue _value) {
		findParameter("attribute")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_value, stParameter, kvs, "value");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<HiddenElementModel_Attribute> streamAttribute() {
		return findParameter("attribute")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new HiddenElementModel_Attribute(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class HiddenElementModel_Attribute {

		STArgument stArgument;
		STParameter stParameter;

		public HiddenElementModel_Attribute(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public HiddenElementModel_Attribute setName(String value) {
			return setName(db.newSTValue(value));
		}

		public HiddenElementModel_Attribute setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public HiddenElementModel_Attribute setValue(String value) {
			return setValue(db.newSTValue(value));
		}

		public HiddenElementModel_Attribute setValue(STValue value) {
			return setKVValue("value", value);
		}

		public STValue getValue() {
			return getKVValue("value");
		}


		private HiddenElementModel_Attribute setKVValue(String name, STValue value) {

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

	private HiddenElementModel set(STValue value, String name) {
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

	private HiddenElementModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private HiddenElementModel add(STValue value, String name) {
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