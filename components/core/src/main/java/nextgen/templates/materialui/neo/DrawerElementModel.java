package nextgen.templates.materialui.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class DrawerElementModel {

	public static final String stGroupModelUuid = "321c04de-dca6-45c6-bbff-ebdcf1e62d5d";
	public static final String stTemplateUuid = "0ba678e4-26fe-487c-8295-b715a6adeb4d";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public DrawerElementModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public DrawerElementModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public DrawerElementModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public DrawerElementModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		DrawerElementModel that = (DrawerElementModel) o;
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

	public DrawerElementModel setAnchor(String value) {
		return setAnchor(db.newSTValue(value));
	}

	public DrawerElementModel setAnchor(STValue value) {
		return set(value, "anchor");
	}

	public STValue getAnchor() {
		return get("anchor");
	}

	public STArgument getAnchorArgument() {
		return getArgument("anchor");
	}

	public DrawerElementModel removeAnchor() {
		return removeArgument("anchor");
	}

	public DrawerElementModel setClasses(String value) {
		return setClasses(db.newSTValue(value));
	}

	public DrawerElementModel setClasses(STValue value) {
		return set(value, "classes");
	}

	public STValue getClasses() {
		return get("classes");
	}

	public STArgument getClassesArgument() {
		return getArgument("classes");
	}

	public DrawerElementModel removeClasses() {
		return removeArgument("classes");
	}

	public DrawerElementModel setClassName(String value) {
		return setClassName(db.newSTValue(value));
	}

	public DrawerElementModel setClassName(STValue value) {
		return set(value, "className");
	}

	public STValue getClassName() {
		return get("className");
	}

	public STArgument getClassNameArgument() {
		return getArgument("className");
	}

	public DrawerElementModel removeClassName() {
		return removeArgument("className");
	}

	public DrawerElementModel setElevation(String value) {
		return setElevation(db.newSTValue(value));
	}

	public DrawerElementModel setElevation(STValue value) {
		return set(value, "elevation");
	}

	public STValue getElevation() {
		return get("elevation");
	}

	public STArgument getElevationArgument() {
		return getArgument("elevation");
	}

	public DrawerElementModel removeElevation() {
		return removeArgument("elevation");
	}

	public DrawerElementModel setId(String value) {
		return setId(db.newSTValue(value));
	}

	public DrawerElementModel setId(STValue value) {
		return set(value, "id");
	}

	public STValue getId() {
		return get("id");
	}

	public STArgument getIdArgument() {
		return getArgument("id");
	}

	public DrawerElementModel removeId() {
		return removeArgument("id");
	}

	public DrawerElementModel setKey(String value) {
		return setKey(db.newSTValue(value));
	}

	public DrawerElementModel setKey(STValue value) {
		return set(value, "key");
	}

	public STValue getKey() {
		return get("key");
	}

	public STArgument getKeyArgument() {
		return getArgument("key");
	}

	public DrawerElementModel removeKey() {
		return removeArgument("key");
	}

	public DrawerElementModel setModalProps(String value) {
		return setModalProps(db.newSTValue(value));
	}

	public DrawerElementModel setModalProps(STValue value) {
		return set(value, "ModalProps");
	}

	public STValue getModalProps() {
		return get("ModalProps");
	}

	public STArgument getModalPropsArgument() {
		return getArgument("ModalProps");
	}

	public DrawerElementModel removeModalProps() {
		return removeArgument("ModalProps");
	}

	public DrawerElementModel setOnClose(String value) {
		return setOnClose(db.newSTValue(value));
	}

	public DrawerElementModel setOnClose(STValue value) {
		return set(value, "onClose");
	}

	public STValue getOnClose() {
		return get("onClose");
	}

	public STArgument getOnCloseArgument() {
		return getArgument("onClose");
	}

	public DrawerElementModel removeOnClose() {
		return removeArgument("onClose");
	}

	public DrawerElementModel setOpen(String value) {
		return setOpen(db.newSTValue(value));
	}

	public DrawerElementModel setOpen(STValue value) {
		return set(value, "open");
	}

	public STValue getOpen() {
		return get("open");
	}

	public STArgument getOpenArgument() {
		return getArgument("open");
	}

	public DrawerElementModel removeOpen() {
		return removeArgument("open");
	}

	public DrawerElementModel setPaperProps(String value) {
		return setPaperProps(db.newSTValue(value));
	}

	public DrawerElementModel setPaperProps(STValue value) {
		return set(value, "PaperProps");
	}

	public STValue getPaperProps() {
		return get("PaperProps");
	}

	public STArgument getPaperPropsArgument() {
		return getArgument("PaperProps");
	}

	public DrawerElementModel removePaperProps() {
		return removeArgument("PaperProps");
	}

	public DrawerElementModel setSlideProps(String value) {
		return setSlideProps(db.newSTValue(value));
	}

	public DrawerElementModel setSlideProps(STValue value) {
		return set(value, "SlideProps");
	}

	public STValue getSlideProps() {
		return get("SlideProps");
	}

	public STArgument getSlidePropsArgument() {
		return getArgument("SlideProps");
	}

	public DrawerElementModel removeSlideProps() {
		return removeArgument("SlideProps");
	}

	public DrawerElementModel setStyle(String value) {
		return setStyle(db.newSTValue(value));
	}

	public DrawerElementModel setStyle(STValue value) {
		return set(value, "style");
	}

	public STValue getStyle() {
		return get("style");
	}

	public STArgument getStyleArgument() {
		return getArgument("style");
	}

	public DrawerElementModel removeStyle() {
		return removeArgument("style");
	}

	public DrawerElementModel setTransitionDuration(String value) {
		return setTransitionDuration(db.newSTValue(value));
	}

	public DrawerElementModel setTransitionDuration(STValue value) {
		return set(value, "transitionDuration");
	}

	public STValue getTransitionDuration() {
		return get("transitionDuration");
	}

	public STArgument getTransitionDurationArgument() {
		return getArgument("transitionDuration");
	}

	public DrawerElementModel removeTransitionDuration() {
		return removeArgument("transitionDuration");
	}

	public DrawerElementModel setVariant(String value) {
		return setVariant(db.newSTValue(value));
	}

	public DrawerElementModel setVariant(STValue value) {
		return set(value, "variant");
	}

	public STValue getVariant() {
		return get("variant");
	}

	public STArgument getVariantArgument() {
		return getArgument("variant");
	}

	public DrawerElementModel removeVariant() {
		return removeArgument("variant");
	}

	public DrawerElementModel addChildren(String value) {
		return addChildren(db.newSTValue(value));
	}

	public DrawerElementModel addChildren(STValue value) {
		return add(value, "children");
	}

	public Stream<STValue> getChildren() {
		return stream("children");
	}

	public DrawerElementModel addAttribute(String _name, String _value) {
		return addAttribute(db.newSTValue(_name), db.newSTValue(_value));
	}

	public DrawerElementModel addAttribute(DrawerElementModel_Attribute value) {
		return addAttribute(value.getName(), value.getValue());
	}

	public DrawerElementModel addAttribute(STValue _name, STValue _value) {
		findParameter("attribute")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_value, stParameter, kvs, "value");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<DrawerElementModel_Attribute> streamAttribute() {
		return findParameter("attribute")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new DrawerElementModel_Attribute(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class DrawerElementModel_Attribute {

		STArgument stArgument;
		STParameter stParameter;

		public DrawerElementModel_Attribute(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public DrawerElementModel_Attribute setName(String value) {
			return setName(db.newSTValue(value));
		}

		public DrawerElementModel_Attribute setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public DrawerElementModel_Attribute setValue(String value) {
			return setValue(db.newSTValue(value));
		}

		public DrawerElementModel_Attribute setValue(STValue value) {
			return setKVValue("value", value);
		}

		public STValue getValue() {
			return getKVValue("value");
		}


		private DrawerElementModel_Attribute setKVValue(String name, STValue value) {

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

	private DrawerElementModel set(STValue value, String name) {
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

	private DrawerElementModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private DrawerElementModel add(STValue value, String name) {
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