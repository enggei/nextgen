package nextgen.events;

public final class NewSTArgument {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(NewSTArgument.class);

	public static void post(nextgen.st.model.STArgument stArgument, nextgen.st.model.STModel stModel) {
		log.info("post NewSTArgument");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewSTArgument(stArgument, stModel));
	}

	public final nextgen.st.model.STArgument stArgument;
	public final nextgen.st.model.STModel stModel;

	public NewSTArgument(nextgen.st.model.STArgument stArgument, nextgen.st.model.STModel stModel) {
		this.stArgument = stArgument;
		this.stModel = stModel;
	}
}