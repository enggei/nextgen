package nextgen.events;

public final class TemplateNavigatorSTEnumTreeNodeClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(TemplateNavigatorSTEnumTreeNodeClicked.class);

	public static void post(nextgen.model.STGroupModel stGroup, nextgen.model.STEnum stEnum) {
		//log.info("post TemplateNavigatorSTEnumTreeNodeClicked");
		org.greenrobot.eventbus.EventBus.getDefault().post(new TemplateNavigatorSTEnumTreeNodeClicked(stGroup, stEnum));
	}

	public final nextgen.model.STGroupModel stGroup;
	public final nextgen.model.STEnum stEnum;

	public TemplateNavigatorSTEnumTreeNodeClicked(nextgen.model.STGroupModel stGroup, nextgen.model.STEnum stEnum) {
		this.stGroup = stGroup;
		this.stEnum = stEnum;
	}
}