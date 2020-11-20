package nextgen.events;

public final class EditSTModels {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(EditSTModels.class);

	public static void post(nextgen.st.model.STTemplate stModel) {
		log.info("post EditSTModels");
		org.greenrobot.eventbus.EventBus.getDefault().post(new EditSTModels(stModel));
	}

	public final nextgen.st.model.STTemplate stModel;

	public EditSTModels(nextgen.st.model.STTemplate stModel) {
		this.stModel = stModel;
	}
}