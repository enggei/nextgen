package nextgen.templates.nextgen.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class CanvasNodeModel {

	public static final String stGroupModelUuid = "483489b9-c91a-41c8-ad49-1dc7f9f1469f";
   public static final String stTemplateUuid = "e1bdb5a6-e400-4975-8082-138672753225";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public CanvasNodeModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public CanvasNodeModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public CanvasNodeModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public STValue asSTValue () {
		return db.newSTValue(stModel);
	}

	public CanvasNodeModel setName(String value) {
		return setName(db.newSTValue(value));
	}

	public CanvasNodeModel setName(STValue value) {
		return set(value, "name");
	}

	public STValue getName() {
		return get("name");
	}

	public CanvasNodeModel setModelType(String value) {
		return setModelType(db.newSTValue(value));
	}

	public CanvasNodeModel setModelType(STValue value) {
		return set(value, "modelType");
	}

	public STValue getModelType() {
		return get("modelType");
	}

	public CanvasNodeModel setUuidExpression(String value) {
		return setUuidExpression(db.newSTValue(value));
	}

	public CanvasNodeModel setUuidExpression(STValue value) {
		return set(value, "uuidExpression");
	}

	public STValue getUuidExpression() {
		return get("uuidExpression");
	}

	public CanvasNodeModel setLabelExpression(String value) {
		return setLabelExpression(db.newSTValue(value));
	}

	public CanvasNodeModel setLabelExpression(STValue value) {
		return set(value, "labelExpression");
	}

	public STValue getLabelExpression() {
		return get("labelExpression");
	}

	public CanvasNodeModel addAddedToCanvasStatements(String value) {
		return addAddedToCanvasStatements(db.newSTValue(value));
	}

	public CanvasNodeModel addAddedToCanvasStatements(STValue value) {
		return add(value, "addedToCanvasStatements");
	}

	public Stream<STValue> getAddedToCanvasStatements() {
		return stream("addedToCanvasStatements");
	}

	public CanvasNodeModel addNewNodeAddedStatements(String value) {
		return addNewNodeAddedStatements(db.newSTValue(value));
	}

	public CanvasNodeModel addNewNodeAddedStatements(STValue value) {
		return add(value, "newNodeAddedStatements");
	}

	public Stream<STValue> getNewNodeAddedStatements() {
		return stream("newNodeAddedStatements");
	}

	public CanvasNodeModel addRightClickStatements(String value) {
		return addRightClickStatements(db.newSTValue(value));
	}

	public CanvasNodeModel addRightClickStatements(STValue value) {
		return add(value, "rightClickStatements");
	}

	public Stream<STValue> getRightClickStatements() {
		return stream("rightClickStatements");
	}

	public CanvasNodeModel addLeftClickStatements(String value) {
		return addLeftClickStatements(db.newSTValue(value));
	}

	public CanvasNodeModel addLeftClickStatements(STValue value) {
		return add(value, "leftClickStatements");
	}

	public Stream<STValue> getLeftClickStatements() {
		return stream("leftClickStatements");
	}

	public CanvasNodeModel addActions(String value) {
		return addActions(db.newSTValue(value));
	}

	public CanvasNodeModel addActions(STValue value) {
		return add(value, "actions");
	}

	public Stream<STValue> getActions() {
		return stream("actions");
	}

	public CanvasNodeModel addMethods(String value) {
		return addMethods(db.newSTValue(value));
	}

	public CanvasNodeModel addMethods(STValue value) {
		return add(value, "methods");
	}

	public Stream<STValue> getMethods() {
		return stream("methods");
	}

	public CanvasNodeModel addFields(String _type, String _name) {
		return addFields(db.newSTValue(_type), db.newSTValue(_name));
	}

	public CanvasNodeModel addFields(CanvasNodeModel_Fields value) {
		return addFields(value.getType(), value.getName());
	}

	public CanvasNodeModel addFields(STValue _type, STValue _name) {
		findParameter("fields")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_type, stParameter, kvs, "type");
					addKV(_name, stParameter, kvs, "name");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<CanvasNodeModel_Fields> streamFields() {
		return findParameter("fields")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new CanvasNodeModel_Fields(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class CanvasNodeModel_Fields {

		STArgument stArgument;
		STParameter stParameter;

		public CanvasNodeModel_Fields(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public CanvasNodeModel_Fields setType(String value) {
			return setType(db.newSTValue(value));
		}

		public CanvasNodeModel_Fields setType(STValue value) {
			return setKVValue("type", value);
		}

		public STValue getType() {
			return getKVValue("type");
		}


		public CanvasNodeModel_Fields setName(String value) {
			return setName(db.newSTValue(value));
		}

		public CanvasNodeModel_Fields setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		private CanvasNodeModel_Fields setKVValue(String name, STValue value) {

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

	public CanvasNodeModel addRightClickActions(String _name) {
		return addRightClickActions(db.newSTValue(_name));
	}

	public CanvasNodeModel addRightClickActions(CanvasNodeModel_RightClickActions value) {
		return addRightClickActions(value.getName());
	}

	public CanvasNodeModel addRightClickActions(STValue _name) {
		findParameter("rightClickActions")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<CanvasNodeModel_RightClickActions> streamRightClickActions() {
		return findParameter("rightClickActions")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new CanvasNodeModel_RightClickActions(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class CanvasNodeModel_RightClickActions {

		STArgument stArgument;
		STParameter stParameter;

		public CanvasNodeModel_RightClickActions(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public CanvasNodeModel_RightClickActions setName(String value) {
			return setName(db.newSTValue(value));
		}

		public CanvasNodeModel_RightClickActions setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		private CanvasNodeModel_RightClickActions setKVValue(String name, STValue value) {

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

	public CanvasNodeModel addKeyPressActions(String _key, String _name) {
		return addKeyPressActions(db.newSTValue(_key), db.newSTValue(_name));
	}

	public CanvasNodeModel addKeyPressActions(CanvasNodeModel_KeyPressActions value) {
		return addKeyPressActions(value.getKey(), value.getName());
	}

	public CanvasNodeModel addKeyPressActions(STValue _key, STValue _name) {
		findParameter("keyPressActions")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_key, stParameter, kvs, "key");
					addKV(_name, stParameter, kvs, "name");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<CanvasNodeModel_KeyPressActions> streamKeyPressActions() {
		return findParameter("keyPressActions")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new CanvasNodeModel_KeyPressActions(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class CanvasNodeModel_KeyPressActions {

		STArgument stArgument;
		STParameter stParameter;

		public CanvasNodeModel_KeyPressActions(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public CanvasNodeModel_KeyPressActions setKey(String value) {
			return setKey(db.newSTValue(value));
		}

		public CanvasNodeModel_KeyPressActions setKey(STValue value) {
			return setKVValue("key", value);
		}

		public STValue getKey() {
			return getKVValue("key");
		}


		public CanvasNodeModel_KeyPressActions setName(String value) {
			return setName(db.newSTValue(value));
		}

		public CanvasNodeModel_KeyPressActions setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		private CanvasNodeModel_KeyPressActions setKVValue(String name, STValue value) {

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

	private CanvasNodeModel set(STValue value, String name) {
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

	private CanvasNodeModel add(STValue value, String name) {
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