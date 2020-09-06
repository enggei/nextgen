package nextgen.templates.nextgen.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class CanvasModel {

	public static final String stGroupModelUuid = "483489b9-c91a-41c8-ad49-1dc7f9f1469f";
   public static final String stTemplateUuid = "ddde208a-2415-4367-a5f7-35e5e3ea0c9a";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public CanvasModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public CanvasModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public CanvasModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public STValue asSTValue () {
		return db.newSTValue(stModel);
	}

	public CanvasModel setPackageName(String value) {
		return setPackageName(db.newSTValue(value));
	}

	public CanvasModel setPackageName(STValue value) {
		return set(value, "packageName");
	}

	public STValue getPackageName() {
		return get("packageName");
	}

	public CanvasModel setName(String value) {
		return setName(db.newSTValue(value));
	}

	public CanvasModel setName(STValue value) {
		return set(value, "name");
	}

	public STValue getName() {
		return get("name");
	}

	public CanvasModel addConstructorStatements(String value) {
		return addConstructorStatements(db.newSTValue(value));
	}

	public CanvasModel addConstructorStatements(STValue value) {
		return add(value, "constructorStatements");
	}

	public Stream<STValue> getConstructorStatements() {
		return stream("constructorStatements");
	}

	public CanvasModel addMethods(String value) {
		return addMethods(db.newSTValue(value));
	}

	public CanvasModel addMethods(STValue value) {
		return add(value, "methods");
	}

	public Stream<STValue> getMethods() {
		return stream("methods");
	}

	public CanvasModel addRightClickStatements(String value) {
		return addRightClickStatements(db.newSTValue(value));
	}

	public CanvasModel addRightClickStatements(STValue value) {
		return add(value, "rightClickStatements");
	}

	public Stream<STValue> getRightClickStatements() {
		return stream("rightClickStatements");
	}

	public CanvasModel addActions(String value) {
		return addActions(db.newSTValue(value));
	}

	public CanvasModel addActions(STValue value) {
		return add(value, "actions");
	}

	public Stream<STValue> getActions() {
		return stream("actions");
	}

	public CanvasModel addCanvasNodes(String value) {
		return addCanvasNodes(db.newSTValue(value));
	}

	public CanvasModel addCanvasNodes(STValue value) {
		return add(value, "canvasNodes");
	}

	public Stream<STValue> getCanvasNodes() {
		return stream("canvasNodes");
	}

	public CanvasModel addCanvasRelations(String value) {
		return addCanvasRelations(db.newSTValue(value));
	}

	public CanvasModel addCanvasRelations(STValue value) {
		return add(value, "canvasRelations");
	}

	public Stream<STValue> getCanvasRelations() {
		return stream("canvasRelations");
	}

	public CanvasModel addFields(String _type, String _name) {
		return addFields(db.newSTValue(_type), db.newSTValue(_name));
	}

	public CanvasModel addFields(CanvasModel_Fields value) {
		return addFields(value.getType(), value.getName());
	}

	public CanvasModel addFields(STValue _type, STValue _name) {
		findParameter("fields")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_type, stParameter, kvs, "type");
					addKV(_name, stParameter, kvs, "name");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<CanvasModel_Fields> streamFields() {
		return findParameter("fields")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new CanvasModel_Fields(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class CanvasModel_Fields {

		STArgument stArgument;
		STParameter stParameter;

		public CanvasModel_Fields(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public CanvasModel_Fields setType(String value) {
			return setType(db.newSTValue(value));
		}

		public CanvasModel_Fields setType(STValue value) {
			return setKVValue("type", value);
		}

		public STValue getType() {
			return getKVValue("type");
		}


		public CanvasModel_Fields setName(String value) {
			return setName(db.newSTValue(value));
		}

		public CanvasModel_Fields setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		private CanvasModel_Fields setKVValue(String name, STValue value) {

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

	public CanvasModel addRightClickActions(String _name) {
		return addRightClickActions(db.newSTValue(_name));
	}

	public CanvasModel addRightClickActions(CanvasModel_RightClickActions value) {
		return addRightClickActions(value.getName());
	}

	public CanvasModel addRightClickActions(STValue _name) {
		findParameter("rightClickActions")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<CanvasModel_RightClickActions> streamRightClickActions() {
		return findParameter("rightClickActions")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new CanvasModel_RightClickActions(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class CanvasModel_RightClickActions {

		STArgument stArgument;
		STParameter stParameter;

		public CanvasModel_RightClickActions(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public CanvasModel_RightClickActions setName(String value) {
			return setName(db.newSTValue(value));
		}

		public CanvasModel_RightClickActions setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		private CanvasModel_RightClickActions setKVValue(String name, STValue value) {

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

	public CanvasModel addKeyPressActions(String _key, String _name) {
		return addKeyPressActions(db.newSTValue(_key), db.newSTValue(_name));
	}

	public CanvasModel addKeyPressActions(CanvasModel_KeyPressActions value) {
		return addKeyPressActions(value.getKey(), value.getName());
	}

	public CanvasModel addKeyPressActions(STValue _key, STValue _name) {
		findParameter("keyPressActions")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_key, stParameter, kvs, "key");
					addKV(_name, stParameter, kvs, "name");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<CanvasModel_KeyPressActions> streamKeyPressActions() {
		return findParameter("keyPressActions")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new CanvasModel_KeyPressActions(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class CanvasModel_KeyPressActions {

		STArgument stArgument;
		STParameter stParameter;

		public CanvasModel_KeyPressActions(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public CanvasModel_KeyPressActions setKey(String value) {
			return setKey(db.newSTValue(value));
		}

		public CanvasModel_KeyPressActions setKey(STValue value) {
			return setKVValue("key", value);
		}

		public STValue getKey() {
			return getKVValue("key");
		}


		public CanvasModel_KeyPressActions setName(String value) {
			return setName(db.newSTValue(value));
		}

		public CanvasModel_KeyPressActions setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		private CanvasModel_KeyPressActions setKVValue(String name, STValue value) {

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

	private CanvasModel set(STValue value, String name) {
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

	private CanvasModel add(STValue value, String name) {
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