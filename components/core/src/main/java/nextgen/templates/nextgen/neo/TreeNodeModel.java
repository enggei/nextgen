package nextgen.templates.nextgen.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class TreeNodeModel {

	public static final String stGroupModelUuid = "483489b9-c91a-41c8-ad49-1dc7f9f1469f";
   public static final String stTemplateUuid = "ecd9b597-6268-415b-9558-40ac8160f4a3";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public TreeNodeModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public TreeNodeModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public TreeNodeModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public STValue asSTValue () {
		return db.newSTValue(stModel);
	}

	public TreeNodeModel setName(String value) {
		return setName(db.newSTValue(value));
	}

	public TreeNodeModel setName(STValue value) {
		return set(value, "name");
	}

	public STValue getName() {
		return get("name");
	}

	public TreeNodeModel setModelType(String value) {
		return setModelType(db.newSTValue(value));
	}

	public TreeNodeModel setModelType(STValue value) {
		return set(value, "modelType");
	}

	public STValue getModelType() {
		return get("modelType");
	}

	public TreeNodeModel setHasUuid(String value) {
		return setHasUuid(db.newSTValue(value));
	}

	public TreeNodeModel setHasUuid(STValue value) {
		return set(value, "hasUuid");
	}

	public STValue getHasUuid() {
		return get("hasUuid");
	}

	public TreeNodeModel setIcon(String value) {
		return setIcon(db.newSTValue(value));
	}

	public TreeNodeModel setIcon(STValue value) {
		return set(value, "icon");
	}

	public STValue getIcon() {
		return get("icon");
	}

	public TreeNodeModel setLabelExpression(String value) {
		return setLabelExpression(db.newSTValue(value));
	}

	public TreeNodeModel setLabelExpression(STValue value) {
		return set(value, "labelExpression");
	}

	public STValue getLabelExpression() {
		return get("labelExpression");
	}

	public TreeNodeModel setTooltipExpression(String value) {
		return setTooltipExpression(db.newSTValue(value));
	}

	public TreeNodeModel setTooltipExpression(STValue value) {
		return set(value, "tooltipExpression");
	}

	public STValue getTooltipExpression() {
		return get("tooltipExpression");
	}

	public TreeNodeModel addConstructorStatements(String value) {
		return addConstructorStatements(db.newSTValue(value));
	}

	public TreeNodeModel addConstructorStatements(STValue value) {
		return add(value, "constructorStatements");
	}

	public Stream<STValue> getConstructorStatements() {
		return stream("constructorStatements");
	}

	public TreeNodeModel addGetActionsStatements(String value) {
		return addGetActionsStatements(db.newSTValue(value));
	}

	public TreeNodeModel addGetActionsStatements(STValue value) {
		return add(value, "getActionsStatements");
	}

	public Stream<STValue> getGetActionsStatements() {
		return stream("getActionsStatements");
	}

	public TreeNodeModel addActions(String value) {
		return addActions(db.newSTValue(value));
	}

	public TreeNodeModel addActions(STValue value) {
		return add(value, "actions");
	}

	public Stream<STValue> getActions() {
		return stream("actions");
	}

	public TreeNodeModel addMethods(String value) {
		return addMethods(db.newSTValue(value));
	}

	public TreeNodeModel addMethods(STValue value) {
		return add(value, "methods");
	}

	public Stream<STValue> getMethods() {
		return stream("methods");
	}

	public TreeNodeModel addFields(String _type, String _name) {
		return addFields(db.newSTValue(_type), db.newSTValue(_name));
	}

	public TreeNodeModel addFields(TreeNodeModel_Fields value) {
		return addFields(value.getType(), value.getName());
	}

	public TreeNodeModel addFields(STValue _type, STValue _name) {
		findParameter("fields")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_type, stParameter, kvs, "type");
					addKV(_name, stParameter, kvs, "name");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<TreeNodeModel_Fields> streamFields() {
		return findParameter("fields")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new TreeNodeModel_Fields(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class TreeNodeModel_Fields {

		STArgument stArgument;
		STParameter stParameter;

		public TreeNodeModel_Fields(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public TreeNodeModel_Fields setType(String value) {
			return setType(db.newSTValue(value));
		}

		public TreeNodeModel_Fields setType(STValue value) {
			return setKVValue("type", value);
		}

		public STValue getType() {
			return getKVValue("type");
		}


		public TreeNodeModel_Fields setName(String value) {
			return setName(db.newSTValue(value));
		}

		public TreeNodeModel_Fields setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		private TreeNodeModel_Fields setKVValue(String name, STValue value) {

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

	public TreeNodeModel addParameters(String _type, String _name) {
		return addParameters(db.newSTValue(_type), db.newSTValue(_name));
	}

	public TreeNodeModel addParameters(TreeNodeModel_Parameters value) {
		return addParameters(value.getType(), value.getName());
	}

	public TreeNodeModel addParameters(STValue _type, STValue _name) {
		findParameter("parameters")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_type, stParameter, kvs, "type");
					addKV(_name, stParameter, kvs, "name");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<TreeNodeModel_Parameters> streamParameters() {
		return findParameter("parameters")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new TreeNodeModel_Parameters(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class TreeNodeModel_Parameters {

		STArgument stArgument;
		STParameter stParameter;

		public TreeNodeModel_Parameters(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public TreeNodeModel_Parameters setType(String value) {
			return setType(db.newSTValue(value));
		}

		public TreeNodeModel_Parameters setType(STValue value) {
			return setKVValue("type", value);
		}

		public STValue getType() {
			return getKVValue("type");
		}


		public TreeNodeModel_Parameters setName(String value) {
			return setName(db.newSTValue(value));
		}

		public TreeNodeModel_Parameters setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		private TreeNodeModel_Parameters setKVValue(String name, STValue value) {

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

	private TreeNodeModel set(STValue value, String name) {
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

	private TreeNodeModel add(STValue value, String name) {
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