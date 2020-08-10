package nextgen.st;

import nextgen.st.canvas.STModelCanvas;

public class STAppEvents {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STAppEvents.class);

	public static void postNewProject(nextgen.st.model.Project project) {
		log.info("post NewProject");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewProject(project));
	}

	public static void postRemovedProject(java.lang.String uuid) {
		log.info("post RemovedProject");
		org.greenrobot.eventbus.EventBus.getDefault().post(new RemovedProject(uuid));
	}

	public static void postNewSTModel(nextgen.st.model.STModel sTModel) {
		log.info("post NewSTModel");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewSTModel(sTModel));
	}

	public static void postRemovedSTModel(java.lang.String uuid) {
		log.info("post RemovedSTModel");
		org.greenrobot.eventbus.EventBus.getDefault().post(new RemovedSTModel(uuid));
	}

	public static void postNewSTValue(nextgen.st.model.STValue sTValue) {
		log.info("post NewSTValue");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewSTValue(sTValue));
	}

	public static void postRemovedSTValue(java.lang.String uuid) {
		log.info("post RemovedSTValue");
		org.greenrobot.eventbus.EventBus.getDefault().post(new RemovedSTValue(uuid));
	}

	public static void postNewScript(nextgen.st.model.Script script) {
		log.info("post NewScript");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewScript(script));
	}

	public static void postRemovedScript(java.lang.String uuid) {
		log.info("post RemovedScript");
		org.greenrobot.eventbus.EventBus.getDefault().post(new RemovedScript(uuid));
	}

	public static void postNodeAddedToCanvas(STModelCanvas canvas, nextgen.st.canvas.STNode node) {
		log.info("post NodeAddedToCanvas");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NodeAddedToCanvas(canvas, node));
	}

	public static void postNodeClosed(STModelCanvas canvas, nextgen.st.canvas.STNode node) {
		log.info("post NodeClosed");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NodeClosed(canvas, node));
	}

	public static void postOpenSTModel(java.lang.String uuid) {
		log.info("post OpenSTModel");
		org.greenrobot.eventbus.EventBus.getDefault().post(new OpenSTModel(uuid));
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

	public static class NodeAddedToCanvas {

		public final STModelCanvas canvas;
		public final nextgen.st.canvas.STNode node;

		public NodeAddedToCanvas(STModelCanvas canvas, nextgen.st.canvas.STNode node) {
			this.canvas = canvas;
			this.node = node;
		}
	}

	public static class NodeClosed {

		public final STModelCanvas canvas;
		public final nextgen.st.canvas.STNode node;

		public NodeClosed(STModelCanvas canvas, nextgen.st.canvas.STNode node) {
			this.canvas = canvas;
			this.node = node;
		}
	}

	public static class OpenSTModel {

		public final java.lang.String uuid;

		public OpenSTModel(java.lang.String uuid) {
			this.uuid = uuid;
		}
	}
}