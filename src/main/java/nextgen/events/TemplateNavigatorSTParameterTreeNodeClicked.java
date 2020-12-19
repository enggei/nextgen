package nextgen.events;

public final class TemplateNavigatorSTParameterTreeNodeClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(TemplateNavigatorSTParameterTreeNodeClicked.class);

	public static void post(nextgen.model.STParameter parameter, nextgen.model.STModel model) {
		log.info("TemplateNavigatorSTParameterTreeNodeClicked" + " parameter" + " model");
		org.greenrobot.eventbus.EventBus.getDefault().post(new TemplateNavigatorSTParameterTreeNodeClicked(parameter, model));
	}

	public final nextgen.model.STParameter parameter;
	public final nextgen.model.STModel model;

	public TemplateNavigatorSTParameterTreeNodeClicked(nextgen.model.STParameter parameter, nextgen.model.STModel model) {
		this.parameter = parameter;
		this.model = model;
	}
}