package nextgen.events;

public final class NewSTKVArgument {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(NewSTKVArgument.class);

	public static void post(nextgen.st.model.STModel model, nextgen.st.domain.STParameter parameter, nextgen.st.model.STArgument argument) {
		log.info("post NewSTKVArgument");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewSTKVArgument(model, parameter, argument));
	}

	public final nextgen.st.model.STModel model;
	public final nextgen.st.domain.STParameter parameter;
	public final nextgen.st.model.STArgument argument;

	public NewSTKVArgument(nextgen.st.model.STModel model, nextgen.st.domain.STParameter parameter, nextgen.st.model.STArgument argument) {
		this.model = model;
		this.parameter = parameter;
		this.argument = argument;
	}
}