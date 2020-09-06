package nextgen.templates.nextgen.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class CanvasActionModel {

	public static final String stGroupModelUuid = "483489b9-c91a-41c8-ad49-1dc7f9f1469f";
   public static final String stTemplateUuid = "f69bdee4-69a3-4533-b2ac-866366709929";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public CanvasActionModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public CanvasActionModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public CanvasActionModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public STValue asSTValue () {
		return db.newSTValue(stModel);
	}

	public CanvasActionModel setName(String value) {
		return setName(db.newSTValue(value));
	}

	public CanvasActionModel setName(STValue value) {
		return set(value, "name");
	}

	public STValue getName() {
		return get("name");
	}

	public CanvasActionModel setTitle(String value) {
		return setTitle(db.newSTValue(value));
	}

	public CanvasActionModel setTitle(STValue value) {
		return set(value, "title");
	}

	public STValue getTitle() {
		return get("title");
	}

	public CanvasActionModel addStatements(String value) {
		return addStatements(db.newSTValue(value));
	}

	public CanvasActionModel addStatements(STValue value) {
		return add(value, "statements");
	}

	public Stream<STValue> getStatements() {
		return stream("statements");
	}

	public CanvasActionModel addFields(String _type, String _name) {
		return addFields(db.newSTValue(_type), db.newSTValue(_name));
	}

	public CanvasActionModel addFields(CanvasActionModel_Fields value) {
		return addFields(value.getType(), value.getName());
	}

	public CanvasActionModel addFields(STValue _type, STValue _name) {
		findParameter("fields")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_type, stParameter, kvs, "type");
					addKV(_name, stParameter, kvs, "name");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<CanvasActionModel_Fields> streamFields() {
		return findParameter("fields")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new CanvasActionModel_Fields(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class CanvasActionModel_Fields {

		STArgument stArgument;
		STParameter stParameter;

		public CanvasActionModel_Fields(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public CanvasActionModel_Fields setType(String value) {
			return setType(db.newSTValue(value));
		}

		public CanvasActionModel_Fields setType(STValue value) {
			return setKVValue("type", value);
		}

		public STValue getType() {
			return getKVValue("type");
		}


		public CanvasActionModel_Fields setName(String value) {
			return setName(db.newSTValue(value));
		}

		public CanvasActionModel_Fields setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		private CanvasActionModel_Fields setKVValue(String name, STValue value) {

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

	private CanvasActionModel set(STValue value, String name) {
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

	private CanvasActionModel add(STValue value, String name) {
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