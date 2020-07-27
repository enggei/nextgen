package nextgen.st;

public class STAppEvents {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STAppEvents.class);

	public static void postOpenSTModel(String uuid) {
		log.info("post OpenSTModel");
		org.greenrobot.eventbus.EventBus.getDefault().post(new OpenSTModel(uuid));
	}

	public static void postSTModelCreated(nextgen.st.model.STModel stModel) {
		log.info("post STModelCreated");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STModelCreated(stModel));
	}

	public static void postNodeClosed(nextgen.st.canvas.STCanvas canvas, nextgen.st.canvas.STNode node) {
		log.info("post NodeClosed");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NodeClosed(canvas, node));
	}

	public static void postNodeAdded(nextgen.st.canvas.STCanvas canvas, nextgen.st.canvas.STNode node) {
		log.info("post NodeAdded");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NodeAdded(canvas, node));
	}

	public static class OpenSTModel {

		public final String uuid;

		public OpenSTModel(String uuid) {
			this.uuid = uuid;
		}
	}

	public static class STModelCreated {

		public final nextgen.st.model.STModel stModel;

		public STModelCreated(nextgen.st.model.STModel stModel) {
			this.stModel = stModel;
		}
	}

	public static class NodeClosed {

		public final nextgen.st.canvas.STCanvas canvas;
		public final nextgen.st.canvas.STNode node;

		public NodeClosed(nextgen.st.canvas.STCanvas canvas, nextgen.st.canvas.STNode node) {
			this.canvas = canvas;
			this.node = node;
		}
	}

	public static class NodeAdded {

		public final nextgen.st.canvas.STCanvas canvas;
		public final nextgen.st.canvas.STNode node;

		public NodeAdded(nextgen.st.canvas.STCanvas canvas, nextgen.st.canvas.STNode node) {
			this.canvas = canvas;
			this.node = node;
		}
	}
}