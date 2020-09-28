package nextgen.templates.vertx.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class WebVerticleModel {

	public static final String stGroupModelUuid = "68548572-6e3a-48dd-a96e-2d23030ba650";
	public static final String stTemplateUuid = "d128bcda-0d12-4d30-ab1b-6534a3c38e4e";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public WebVerticleModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public WebVerticleModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public WebVerticleModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public WebVerticleModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		WebVerticleModel that = (WebVerticleModel) o;
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

	public WebVerticleModel setPackageName(String value) {
		return setPackageName(db.newSTValue(value));
	}

	public WebVerticleModel setPackageName(STValue value) {
		return set(value, "packageName");
	}

	public STValue getPackageName() {
		return get("packageName");
	}

	public STArgument getPackageNameArgument() {
		return getArgument("packageName");
	}

	public WebVerticleModel removePackageName() {
		return removeArgument("packageName");
	}

	public WebVerticleModel setName(String value) {
		return setName(db.newSTValue(value));
	}

	public WebVerticleModel setName(STValue value) {
		return set(value, "name");
	}

	public STValue getName() {
		return get("name");
	}

	public STArgument getNameArgument() {
		return getArgument("name");
	}

	public WebVerticleModel removeName() {
		return removeArgument("name");
	}

	public WebVerticleModel addImports(String value) {
		return addImports(db.newSTValue(value));
	}

	public WebVerticleModel addImports(STValue value) {
		return add(value, "imports");
	}

	public Stream<STValue> getImports() {
		return stream("imports");
	}

	public WebVerticleModel addStartStatements(String value) {
		return addStartStatements(db.newSTValue(value));
	}

	public WebVerticleModel addStartStatements(STValue value) {
		return add(value, "startStatements");
	}

	public Stream<STValue> getStartStatements() {
		return stream("startStatements");
	}

	public WebVerticleModel addHandlers(String value) {
		return addHandlers(db.newSTValue(value));
	}

	public WebVerticleModel addHandlers(STValue value) {
		return add(value, "handlers");
	}

	public Stream<STValue> getHandlers() {
		return stream("handlers");
	}

	public WebVerticleModel addMethods(String value) {
		return addMethods(db.newSTValue(value));
	}

	public WebVerticleModel addMethods(STValue value) {
		return add(value, "methods");
	}

	public Stream<STValue> getMethods() {
		return stream("methods");
	}

	public WebVerticleModel addFields(String _type, String _name, String _init) {
		return addFields(db.newSTValue(_type), db.newSTValue(_name), db.newSTValue(_init));
	}

	public WebVerticleModel addFields(WebVerticleModel_Fields value) {
		return addFields(value.getType(), value.getName(), value.getInit());
	}

	public WebVerticleModel addFields(STValue _type, STValue _name, STValue _init) {
		findParameter("fields")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_type, stParameter, kvs, "type");
					addKV(_name, stParameter, kvs, "name");
					addKV(_init, stParameter, kvs, "init");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<WebVerticleModel_Fields> streamFields() {
		return findParameter("fields")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new WebVerticleModel_Fields(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class WebVerticleModel_Fields {

		STArgument stArgument;
		STParameter stParameter;

		public WebVerticleModel_Fields(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public WebVerticleModel_Fields setType(String value) {
			return setType(db.newSTValue(value));
		}

		public WebVerticleModel_Fields setType(STValue value) {
			return setKVValue("type", value);
		}

		public STValue getType() {
			return getKVValue("type");
		}


		public WebVerticleModel_Fields setName(String value) {
			return setName(db.newSTValue(value));
		}

		public WebVerticleModel_Fields setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public WebVerticleModel_Fields setInit(String value) {
			return setInit(db.newSTValue(value));
		}

		public WebVerticleModel_Fields setInit(STValue value) {
			return setKVValue("init", value);
		}

		public STValue getInit() {
			return getKVValue("init");
		}


		private WebVerticleModel_Fields setKVValue(String name, STValue value) {

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

	public WebVerticleModel addRoutes(String _action, String _url, String _handler) {
		return addRoutes(db.newSTValue(_action), db.newSTValue(_url), db.newSTValue(_handler));
	}

	public WebVerticleModel addRoutes(WebVerticleModel_Routes value) {
		return addRoutes(value.getAction(), value.getUrl(), value.getHandler());
	}

	public WebVerticleModel addRoutes(STValue _action, STValue _url, STValue _handler) {
		findParameter("routes")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_action, stParameter, kvs, "action");
					addKV(_url, stParameter, kvs, "url");
					addKV(_handler, stParameter, kvs, "handler");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<WebVerticleModel_Routes> streamRoutes() {
		return findParameter("routes")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new WebVerticleModel_Routes(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class WebVerticleModel_Routes {

		STArgument stArgument;
		STParameter stParameter;

		public WebVerticleModel_Routes(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public WebVerticleModel_Routes setAction(String value) {
			return setAction(db.newSTValue(value));
		}

		public WebVerticleModel_Routes setAction(STValue value) {
			return setKVValue("action", value);
		}

		public STValue getAction() {
			return getKVValue("action");
		}


		public WebVerticleModel_Routes setUrl(String value) {
			return setUrl(db.newSTValue(value));
		}

		public WebVerticleModel_Routes setUrl(STValue value) {
			return setKVValue("url", value);
		}

		public STValue getUrl() {
			return getKVValue("url");
		}


		public WebVerticleModel_Routes setHandler(String value) {
			return setHandler(db.newSTValue(value));
		}

		public WebVerticleModel_Routes setHandler(STValue value) {
			return setKVValue("handler", value);
		}

		public STValue getHandler() {
			return getKVValue("handler");
		}


		private WebVerticleModel_Routes setKVValue(String name, STValue value) {

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

	private WebVerticleModel set(STValue value, String name) {
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

	private WebVerticleModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private WebVerticleModel add(STValue value, String name) {
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