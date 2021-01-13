package nextgen.events;

public final class STParameterTreeNodeClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STParameterTreeNodeClicked.class);

	public static void post(nextgen.model.STParameter parameter, nextgen.model.STModel model) {
		log.info("STParameterTreeNodeClicked" + " parameter" + " model");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STParameterTreeNodeClicked(parameter, model));
	}

	public final nextgen.model.STParameter parameter;
	public final nextgen.model.STModel model;

	public STParameterTreeNodeClicked(nextgen.model.STParameter parameter, nextgen.model.STModel model) {
		this.parameter = parameter;
		this.model = model;
	}
}