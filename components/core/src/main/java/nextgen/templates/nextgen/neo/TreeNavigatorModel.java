package nextgen.templates.nextgen.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class TreeNavigatorModel {

	public static final String stGroupModelUuid = "483489b9-c91a-41c8-ad49-1dc7f9f1469f";
   public static final String stTemplateUuid = "76d29786-6c58-46af-b1bd-9d49ed4bb8a9";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public TreeNavigatorModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public TreeNavigatorModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public TreeNavigatorModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public STValue asSTValue () {
		return db.newSTValue(stModel);
	}

	public TreeNavigatorModel setPackageName(String value) {
		return setPackageName(db.newSTValue(value));
	}

	public TreeNavigatorModel setPackageName(STValue value) {
		return set(value, "packageName");
	}

	public STValue getPackageName() {
		return get("packageName");
	}

	public TreeNavigatorModel setName(String value) {
		return setName(db.newSTValue(value));
	}

	public TreeNavigatorModel setName(STValue value) {
		return set(value, "name");
	}

	public STValue getName() {
		return get("name");
	}

	public TreeNavigatorModel setRootNodeExpression(String value) {
		return setRootNodeExpression(db.newSTValue(value));
	}

	public TreeNavigatorModel setRootNodeExpression(STValue value) {
		return set(value, "rootNodeExpression");
	}

	public STValue getRootNodeExpression() {
		return get("rootNodeExpression");
	}

	public TreeNavigatorModel setPreferredWidth(String value) {
		return setPreferredWidth(db.newSTValue(value));
	}

	public TreeNavigatorModel setPreferredWidth(STValue value) {
		return set(value, "preferredWidth");
	}

	public STValue getPreferredWidth() {
		return get("preferredWidth");
	}

	public TreeNavigatorModel setPreferredHeight(String value) {
		return setPreferredHeight(db.newSTValue(value));
	}

	public TreeNavigatorModel setPreferredHeight(STValue value) {
		return set(value, "preferredHeight");
	}

	public STValue getPreferredHeight() {
		return get("preferredHeight");
	}

	public TreeNavigatorModel setBaseTreeNode(String value) {
		return setBaseTreeNode(db.newSTValue(value));
	}

	public TreeNavigatorModel setBaseTreeNode(STValue value) {
		return set(value, "baseTreeNode");
	}

	public STValue getBaseTreeNode() {
		return get("baseTreeNode");
	}

	public TreeNavigatorModel addImports(String value) {
		return addImports(db.newSTValue(value));
	}

	public TreeNavigatorModel addImports(STValue value) {
		return add(value, "imports");
	}

	public Stream<STValue> getImports() {
		return stream("imports");
	}

	public TreeNavigatorModel addOnSelectionStatements(String value) {
		return addOnSelectionStatements(db.newSTValue(value));
	}

	public TreeNavigatorModel addOnSelectionStatements(STValue value) {
		return add(value, "onSelectionStatements");
	}

	public Stream<STValue> getOnSelectionStatements() {
		return stream("onSelectionStatements");
	}

	public TreeNavigatorModel addConstructorStatements(String value) {
		return addConstructorStatements(db.newSTValue(value));
	}

	public TreeNavigatorModel addConstructorStatements(STValue value) {
		return add(value, "constructorStatements");
	}

	public Stream<STValue> getConstructorStatements() {
		return stream("constructorStatements");
	}

	public TreeNavigatorModel addTreeNodes(String value) {
		return addTreeNodes(db.newSTValue(value));
	}

	public TreeNavigatorModel addTreeNodes(STValue value) {
		return add(value, "treeNodes");
	}

	public Stream<STValue> getTreeNodes() {
		return stream("treeNodes");
	}

	public TreeNavigatorModel addMethods(String value) {
		return addMethods(db.newSTValue(value));
	}

	public TreeNavigatorModel addMethods(STValue value) {
		return add(value, "methods");
	}

	public Stream<STValue> getMethods() {
		return stream("methods");
	}

	public TreeNavigatorModel addFields(String _type, String _name) {
		return addFields(db.newSTValue(_type), db.newSTValue(_name));
	}

	public TreeNavigatorModel addFields(TreeNavigatorModel_Fields value) {
		return addFields(value.getType(), value.getName());
	}

	public TreeNavigatorModel addFields(STValue _type, STValue _name) {
		findParameter("fields")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_type, stParameter, kvs, "type");
					addKV(_name, stParameter, kvs, "name");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<TreeNavigatorModel_Fields> streamFields() {
		return findParameter("fields")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new TreeNavigatorModel_Fields(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class TreeNavigatorModel_Fields {

		STArgument stArgument;
		STParameter stParameter;

		public TreeNavigatorModel_Fields(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public TreeNavigatorModel_Fields setType(String value) {
			return setType(db.newSTValue(value));
		}

		public TreeNavigatorModel_Fields setType(STValue value) {
			return setKVValue("type", value);
		}

		public STValue getType() {
			return getKVValue("type");
		}


		public TreeNavigatorModel_Fields setName(String value) {
			return setName(db.newSTValue(value));
		}

		public TreeNavigatorModel_Fields setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		private TreeNavigatorModel_Fields setKVValue(String name, STValue value) {

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

	private TreeNavigatorModel set(STValue value, String name) {
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

	private TreeNavigatorModel add(STValue value, String name) {
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