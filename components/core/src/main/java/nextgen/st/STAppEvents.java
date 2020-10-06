package nextgen.st;

public class STAppEvents {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STAppEvents.class);

	public static void postCanvasSTModelClicked(nextgen.st.model.STModel stModel) {
		log.info("post CanvasSTModelClicked");
		org.greenrobot.eventbus.EventBus.getDefault().post(new CanvasSTModelClicked(stModel));
	}

	public static class CanvasSTModelClicked {

		public final nextgen.st.model.STModel stModel;

		public CanvasSTModelClicked(nextgen.st.model.STModel stModel) {
			this.stModel = stModel;
		}
	}

	public static void postSTModelUpdated(nextgen.st.model.STModel stModel) {
		log.info("post STModelUpdated");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STModelUpdated(stModel));
	}

	public static class STModelUpdated {

		public final nextgen.st.model.STModel stModel;

		public STModelUpdated(nextgen.st.model.STModel stModel) {
			this.stModel = stModel;
		}
	}

	public static void postNewProject(nextgen.st.model.Project project) {
		log.info("post NewProject");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewProject(project));
	}

	public static void postRemovedProject(java.lang.String uuid) {
		log.info("post RemovedProject");
		org.greenrobot.eventbus.EventBus.getDefault().post(new RemovedProject(uuid));
	}

	public static void postOpenProject(nextgen.st.model.Project project) {
		log.info("post OpenProject");
		org.greenrobot.eventbus.EventBus.getDefault().post(new OpenProject(project));
	}

	public static class NewProject {

		public final nextgen.st.model.Project project;

		public NewProject(nextgen.st.model.Project project) {
			this.project = project;
		}
	}

	public static class RemovedProject {

		public final java.lang.String uuid;

		public RemovedProject(java.lang.String uuid) {
			this.uuid = uuid;
		}
	}

	public static class OpenProject {

		public final nextgen.st.model.Project project;

		public OpenProject(nextgen.st.model.Project project) {
			this.project = project;
		}
	}

	public static void postNewSTModel(nextgen.st.model.STModel sTModel) {
		log.info("post NewSTModel");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewSTModel(sTModel));
	}

	public static void postRemovedSTModel(java.lang.String uuid) {
		log.info("post RemovedSTModel");
		org.greenrobot.eventbus.EventBus.getDefault().post(new RemovedSTModel(uuid));
	}

	public static void postOpenSTModel(nextgen.st.model.STModel sTModel) {
		log.info("post OpenSTModel");
		org.greenrobot.eventbus.EventBus.getDefault().post(new OpenSTModel(sTModel));
	}

	public static class NewSTModel {

		public final nextgen.st.model.STModel sTModel;

		public NewSTModel(nextgen.st.model.STModel sTModel) {
			this.sTModel = sTModel;
		}
	}

	public static class RemovedSTModel {

		public final java.lang.String uuid;

		public RemovedSTModel(java.lang.String uuid) {
			this.uuid = uuid;
		}
	}

	public static class OpenSTModel {

		public final nextgen.st.model.STModel sTModel;

		public OpenSTModel(nextgen.st.model.STModel sTModel) {
			this.sTModel = sTModel;
		}
	}

	public static void postNewSTValue(nextgen.st.model.STValue sTValue) {
		log.info("post NewSTValue");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewSTValue(sTValue));
	}

	public static void postRemovedSTValue(java.lang.String uuid) {
		log.info("post RemovedSTValue");
		org.greenrobot.eventbus.EventBus.getDefault().post(new RemovedSTValue(uuid));
	}

	public static void postOpenSTValue(nextgen.st.model.STValue sTValue) {
		log.info("post OpenSTValue");
		org.greenrobot.eventbus.EventBus.getDefault().post(new OpenSTValue(sTValue));
	}

	public static class NewSTValue {

		public final nextgen.st.model.STValue sTValue;

		public NewSTValue(nextgen.st.model.STValue sTValue) {
			this.sTValue = sTValue;
		}
	}

	public static class RemovedSTValue {

		public final java.lang.String uuid;

		public RemovedSTValue(java.lang.String uuid) {
			this.uuid = uuid;
		}
	}

	public static class OpenSTValue {

		public final nextgen.st.model.STValue sTValue;

		public OpenSTValue(nextgen.st.model.STValue sTValue) {
			this.sTValue = sTValue;
		}
	}

	public static void postNewScript(nextgen.st.model.Script script) {
		log.info("post NewScript");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewScript(script));
	}

	public static void postRemovedScript(java.lang.String uuid) {
		log.info("post RemovedScript");
		org.greenrobot.eventbus.EventBus.getDefault().post(new RemovedScript(uuid));
	}

	public static void postOpenScript(nextgen.st.model.Script script) {
		log.info("post OpenScript");
		org.greenrobot.eventbus.EventBus.getDefault().post(new OpenScript(script));
	}

	public static class NewScript {

		public final nextgen.st.model.Script script;

		public NewScript(nextgen.st.model.Script script) {
			this.script = script;
		}
	}

	public static class RemovedScript {

		public final java.lang.String uuid;

		public RemovedScript(java.lang.String uuid) {
			this.uuid = uuid;
		}
	}

	public static class OpenScript {

		public final nextgen.st.model.Script script;

		public OpenScript(nextgen.st.model.Script script) {
			this.script = script;
		}
	}

	public static void postNewSTTemplate(nextgen.st.domain.STTemplate sTTemplate) {
		log.info("post NewSTTemplate");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewSTTemplate(sTTemplate));
	}

	public static void postRemovedSTTemplate(java.lang.String uuid) {
		log.info("post RemovedSTTemplate");
		org.greenrobot.eventbus.EventBus.getDefault().post(new RemovedSTTemplate(uuid));
	}

	public static void postOpenSTTemplate(nextgen.st.domain.STTemplate sTTemplate) {
		log.info("post OpenSTTemplate");
		org.greenrobot.eventbus.EventBus.getDefault().post(new OpenSTTemplate(sTTemplate));
	}

	public static class NewSTTemplate {

		public final nextgen.st.domain.STTemplate sTTemplate;

		public NewSTTemplate(nextgen.st.domain.STTemplate sTTemplate) {
			this.sTTemplate = sTTemplate;
		}
	}

	public static class RemovedSTTemplate {

		public final java.lang.String uuid;

		public RemovedSTTemplate(java.lang.String uuid) {
			this.uuid = uuid;
		}
	}

	public static class OpenSTTemplate {

		public final nextgen.st.domain.STTemplate sTTemplate;

		public OpenSTTemplate(nextgen.st.domain.STTemplate sTTemplate) {
			this.sTTemplate = sTTemplate;
		}
	}

	public static void postSTModelTreeNodeClicked(nextgen.st.model.STModel stModel) {
		log.info("post STModelTreeNodeClicked");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STModelTreeNodeClicked(stModel));
	}

	public static class STModelTreeNodeClicked {

		public final nextgen.st.model.STModel stModel;

		public STModelTreeNodeClicked(nextgen.st.model.STModel stModel) {
			this.stModel = stModel;
		}
	}
}