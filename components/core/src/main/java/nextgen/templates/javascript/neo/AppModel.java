package nextgen.templates.javascript.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class AppModel {

	public static final String stGroupModelUuid = "3ff969ac-4b1c-43fb-968a-7c579bf6779b";
	public static final String stTemplateUuid = "14e250cf-b417-4fb7-b512-a54f6ba8fe58";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public AppModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public AppModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public AppModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public AppModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		AppModel that = (AppModel) o;
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

	public AppModel setTheme(String value) {
		return setTheme(db.newSTValue(value));
	}

	public AppModel setTheme(STValue value) {
		return set(value, "theme");
	}

	public STValue getTheme() {
		return get("theme");
	}

	public STArgument getThemeArgument() {
		return getArgument("theme");
	}

	public AppModel removeTheme() {
		return removeArgument("theme");
	}

	public AppModel addStores(String value) {
		return addStores(db.newSTValue(value));
	}

	public AppModel addStores(STValue value) {
		return add(value, "stores");
	}

	public Stream<STValue> getStores() {
		return stream("stores");
	}

	public AppModel addRoutes(String _component, String _filename, String _path, String _render) {
		return addRoutes(db.newSTValue(_component), db.newSTValue(_filename), db.newSTValue(_path), db.newSTValue(_render));
	}

	public AppModel addRoutes(AppModel_Routes value) {
		return addRoutes(value.getComponent(), value.getFilename(), value.getPath(), value.getRender());
	}

	public AppModel addRoutes(STValue _component, STValue _filename, STValue _path, STValue _render) {
		findParameter("routes")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_component, stParameter, kvs, "component");
					addKV(_filename, stParameter, kvs, "filename");
					addKV(_path, stParameter, kvs, "path");
					addKV(_render, stParameter, kvs, "render");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<AppModel_Routes> streamRoutes() {
		return findParameter("routes")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new AppModel_Routes(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class AppModel_Routes {

		STArgument stArgument;
		STParameter stParameter;

		public AppModel_Routes(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public AppModel_Routes setComponent(String value) {
			return setComponent(db.newSTValue(value));
		}

		public AppModel_Routes setComponent(STValue value) {
			return setKVValue("component", value);
		}

		public STValue getComponent() {
			return getKVValue("component");
		}


		public AppModel_Routes setFilename(String value) {
			return setFilename(db.newSTValue(value));
		}

		public AppModel_Routes setFilename(STValue value) {
			return setKVValue("filename", value);
		}

		public STValue getFilename() {
			return getKVValue("filename");
		}


		public AppModel_Routes setPath(String value) {
			return setPath(db.newSTValue(value));
		}

		public AppModel_Routes setPath(STValue value) {
			return setKVValue("path", value);
		}

		public STValue getPath() {
			return getKVValue("path");
		}


		public AppModel_Routes setRender(String value) {
			return setRender(db.newSTValue(value));
		}

		public AppModel_Routes setRender(STValue value) {
			return setKVValue("render", value);
		}

		public STValue getRender() {
			return getKVValue("render");
		}


		private AppModel_Routes setKVValue(String name, STValue value) {

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

	private AppModel set(STValue value, String name) {
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

	private AppModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private AppModel add(STValue value, String name) {
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