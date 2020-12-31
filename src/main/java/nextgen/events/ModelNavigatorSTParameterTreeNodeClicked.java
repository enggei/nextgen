package nextgen.events;

public final class ModelNavigatorSTParameterTreeNodeClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ModelNavigatorSTParameterTreeNodeClicked.class);

	public static void post(nextgen.model.STParameter parameter, nextgen.model.STModel model) {
		log.info("ModelNavigatorSTParameterTreeNodeClicked" + " parameter" + " model");
		org.greenrobot.eventbus.EventBus.getDefault().post(new ModelNavigatorSTParameterTreeNodeClicked(parameter, model));
	}

	public final nextgen.model.STParameter parameter;
	public final nextgen.model.STModel model;

	public ModelNavigatorSTParameterTreeNodeClicked(nextgen.model.STParameter parameter, nextgen.model.STModel model) {
		this.parameter = parameter;
		this.model = model;
	}
}