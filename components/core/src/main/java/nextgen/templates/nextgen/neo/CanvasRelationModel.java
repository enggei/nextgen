package nextgen.templates.nextgen.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class CanvasRelationModel {

	public static final String stGroupModelUuid = "483489b9-c91a-41c8-ad49-1dc7f9f1469f";
	public static final String stTemplateUuid = "1bff4c6f-bd1a-4660-8235-5339fd7107e3";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public CanvasRelationModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public CanvasRelationModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public CanvasRelationModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public CanvasRelationModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	public String getUuid() {
		return stModel.getUuid();
	}

	public STValue asSTValue () {
		return db.newSTValue(stModel);
	}

	public CanvasRelationModel setName(String value) {
		return setName(db.newSTValue(value));
	}

	public CanvasRelationModel setName(STValue value) {
		return set(value, "name");
	}

	public STValue getName() {
		return get("name");
	}

	public CanvasRelationModel setUuidExpression(String value) {
		return setUuidExpression(db.newSTValue(value));
	}

	public CanvasRelationModel setUuidExpression(STValue value) {
		return set(value, "uuidExpression");
	}

	public STValue getUuidExpression() {
		return get("uuidExpression");
	}

	public CanvasRelationModel setLabelExpression(String value) {
		return setLabelExpression(db.newSTValue(value));
	}

	public CanvasRelationModel setLabelExpression(STValue value) {
		return set(value, "labelExpression");
	}

	public STValue getLabelExpression() {
		return get("labelExpression");
	}

	public CanvasRelationModel addRightClickStatements(String value) {
		return addRightClickStatements(db.newSTValue(value));
	}

	public CanvasRelationModel addRightClickStatements(STValue value) {
		return add(value, "rightClickStatements");
	}

	public Stream<STValue> getRightClickStatements() {
		return stream("rightClickStatements");
	}

	public CanvasRelationModel addActions(String value) {
		return addActions(db.newSTValue(value));
	}

	public CanvasRelationModel addActions(STValue value) {
		return add(value, "actions");
	}

	public Stream<STValue> getActions() {
		return stream("actions");
	}

	public CanvasRelationModel addFields(String _type, String _name) {
		return addFields(db.newSTValue(_type), db.newSTValue(_name));
	}

	public CanvasRelationModel addFields(CanvasRelationModel_Fields value) {
		return addFields(value.getType(), value.getName());
	}

	public CanvasRelationModel addFields(STValue _type, STValue _name) {
		findParameter("fields")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_type, stParameter, kvs, "type");
					addKV(_name, stParameter, kvs, "name");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<CanvasRelationModel_Fields> streamFields() {
		return findParameter("fields")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new CanvasRelationModel_Fields(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class CanvasRelationModel_Fields {

		STArgument stArgument;
		STParameter stParameter;

		public CanvasRelationModel_Fields(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public CanvasRelationModel_Fields setType(String value) {
			return setType(db.newSTValue(value));
		}

		public CanvasRelationModel_Fields setType(STValue value) {
			return setKVValue("type", value);
		}

		public STValue getType() {
			return getKVValue("type");
		}


		public CanvasRelationModel_Fields setName(String value) {
			return setName(db.newSTValue(value));
		}

		public CanvasRelationModel_Fields setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		private CanvasRelationModel_Fields setKVValue(String name, STValue value) {

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

	public CanvasRelationModel addRightClickActions(String _name) {
		return addRightClickActions(db.newSTValue(_name));
	}

	public CanvasRelationModel addRightClickActions(CanvasRelationModel_RightClickActions value) {
		return addRightClickActions(value.getName());
	}

	public CanvasRelationModel addRightClickActions(STValue _name) {
		findParameter("rightClickActions")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<CanvasRelationModel_RightClickActions> streamRightClickActions() {
		return findParameter("rightClickActions")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new CanvasRelationModel_RightClickActions(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class CanvasRelationModel_RightClickActions {

		STArgument stArgument;
		STParameter stParameter;

		public CanvasRelationModel_RightClickActions(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public CanvasRelationModel_RightClickActions setName(String value) {
			return setName(db.newSTValue(value));
		}

		public CanvasRelationModel_RightClickActions setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		private CanvasRelationModel_RightClickActions setKVValue(String name, STValue value) {

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

	public CanvasRelationModel addKeyPressActions(String _key, String _name) {
		return addKeyPressActions(db.newSTValue(_key), db.newSTValue(_name));
	}

	public CanvasRelationModel addKeyPressActions(CanvasRelationModel_KeyPressActions value) {
		return addKeyPressActions(value.getKey(), value.getName());
	}

	public CanvasRelationModel addKeyPressActions(STValue _key, STValue _name) {
		findParameter("keyPressActions")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_key, stParameter, kvs, "key");
					addKV(_name, stParameter, kvs, "name");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<CanvasRelationModel_KeyPressActions> streamKeyPressActions() {
		return findParameter("keyPressActions")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new CanvasRelationModel_KeyPressActions(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class CanvasRelationModel_KeyPressActions {

		STArgument stArgument;
		STParameter stParameter;

		public CanvasRelationModel_KeyPressActions(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public CanvasRelationModel_KeyPressActions setKey(String value) {
			return setKey(db.newSTValue(value));
		}

		public CanvasRelationModel_KeyPressActions setKey(STValue value) {
			return setKVValue("key", value);
		}

		public STValue getKey() {
			return getKVValue("key");
		}


		public CanvasRelationModel_KeyPressActions setName(String value) {
			return setName(db.newSTValue(value));
		}

		public CanvasRelationModel_KeyPressActions setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		private CanvasRelationModel_KeyPressActions setKVValue(String name, STValue value) {

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

	private CanvasRelationModel set(STValue value, String name) {
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

	private CanvasRelationModel add(STValue value, String name) {
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