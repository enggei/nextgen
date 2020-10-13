package nextgen.events;

public final class NewSTEnum {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(NewSTEnum.class);

	public static void post(nextgen.st.domain.STEnum model, nextgen.st.domain.STGroupModel parent) {
		log.info("post NewSTEnum");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewSTEnum(model, parent));
	}

	public final nextgen.st.domain.STEnum model;
	public final nextgen.st.domain.STGroupModel parent;

	public NewSTEnum(nextgen.st.domain.STEnum model, nextgen.st.domain.STGroupModel parent) {
		this.model = model;
		this.parent = parent;
	}
}