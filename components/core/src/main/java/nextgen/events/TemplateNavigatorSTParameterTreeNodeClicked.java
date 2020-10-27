package nextgen.events;

public final class TemplateNavigatorSTParameterTreeNodeClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(TemplateNavigatorSTParameterTreeNodeClicked.class);

	public static void post(nextgen.st.domain.STParameter parameter, nextgen.st.model.STModel model) {
		log.info("post TemplateNavigatorSTParameterTreeNodeClicked");
		org.greenrobot.eventbus.EventBus.getDefault().post(new TemplateNavigatorSTParameterTreeNodeClicked(parameter, model));
	}

	public final nextgen.st.domain.STParameter parameter;
	public final nextgen.st.model.STModel model;

	public TemplateNavigatorSTParameterTreeNodeClicked(nextgen.st.domain.STParameter parameter, nextgen.st.model.STModel model) {
		this.parameter = parameter;
		this.model = model;
	}
}