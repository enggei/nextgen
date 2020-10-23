package nextgen.events;

public final class TemplateNavigatorSTEnumTreeNodeClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(TemplateNavigatorSTEnumTreeNodeClicked.class);

	public static void post(nextgen.st.domain.STGroupModel stGroup, nextgen.st.domain.STEnum stEnum) {
		log.info("post TemplateNavigatorSTEnumTreeNodeClicked");
		org.greenrobot.eventbus.EventBus.getDefault().post(new TemplateNavigatorSTEnumTreeNodeClicked(stGroup, stEnum));
	}

	public final nextgen.st.domain.STGroupModel stGroup;
	public final nextgen.st.domain.STEnum stEnum;

	public TemplateNavigatorSTEnumTreeNodeClicked(nextgen.st.domain.STGroupModel stGroup, nextgen.st.domain.STEnum stEnum) {
		this.stGroup = stGroup;
		this.stEnum = stEnum;
	}
}