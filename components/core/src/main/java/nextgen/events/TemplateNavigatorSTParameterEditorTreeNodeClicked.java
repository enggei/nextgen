package nextgen.events;

public final class TemplateNavigatorSTParameterEditorTreeNodeClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(TemplateNavigatorSTParameterEditorTreeNodeClicked.class);

	public static void post(nextgen.st.domain.STParameter parameter, nextgen.st.model.STModel model) {
		log.info("post TemplateNavigatorSTParameterEditorTreeNodeClicked");
		org.greenrobot.eventbus.EventBus.getDefault().post(new TemplateNavigatorSTParameterEditorTreeNodeClicked(parameter, model));
	}

	public final nextgen.st.domain.STParameter parameter;
	public final nextgen.st.model.STModel model;

	public TemplateNavigatorSTParameterEditorTreeNodeClicked(nextgen.st.domain.STParameter parameter, nextgen.st.model.STModel model) {
		this.parameter = parameter;
		this.model = model;
	}
}