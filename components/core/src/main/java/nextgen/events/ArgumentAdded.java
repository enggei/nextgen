package nextgen.events;

public final class ArgumentAdded {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ArgumentAdded.class);

	public static void post(nextgen.st.model.STModel stModel, nextgen.st.model.STArgument stArgument, nextgen.st.domain.STParameter stParameter, nextgen.st.model.STValue stValue) {
		log.info("post ArgumentAdded");
		org.greenrobot.eventbus.EventBus.getDefault().post(new ArgumentAdded(stModel, stArgument, stParameter, stValue));
	}

	public final nextgen.st.model.STModel stModel;
	public final nextgen.st.model.STArgument stArgument;
	public final nextgen.st.domain.STParameter stParameter;
	public final nextgen.st.model.STValue stValue;

	public ArgumentAdded(nextgen.st.model.STModel stModel, nextgen.st.model.STArgument stArgument, nextgen.st.domain.STParameter stParameter, nextgen.st.model.STValue stValue) {
		this.stModel = stModel;
		this.stArgument = stArgument;
		this.stParameter = stParameter;
		this.stValue = stValue;
	}
}