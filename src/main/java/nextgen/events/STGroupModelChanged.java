package nextgen.events;

public final class STGroupModelChanged {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STGroupModelChanged.class);

	public static void post(nextgen.model.STGroupModel sTGroupModel) {
		log.info("STGroupModelChanged" + " sTGroupModel");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STGroupModelChanged(sTGroupModel));
	}

	public final nextgen.model.STGroupModel sTGroupModel;

	public STGroupModelChanged(nextgen.model.STGroupModel sTGroupModel) {
		this.sTGroupModel = sTGroupModel;
	}
}  