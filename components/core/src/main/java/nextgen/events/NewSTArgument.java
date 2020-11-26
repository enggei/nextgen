package nextgen.events;

public final class NewSTArgument {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(NewSTArgument.class);

	public static void post(nextgen.st.model.STArgument argument, nextgen.st.model.STModel model, nextgen.st.model.STParameter parameter, nextgen.st.model.STValue value) {
		//log.info("post NewSTArgument");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewSTArgument(argument, model, parameter, value));
	}

	public final nextgen.st.model.STArgument argument;
	public final nextgen.st.model.STModel model;
	public final nextgen.st.model.STParameter parameter;
	public final nextgen.st.model.STValue value;

	public NewSTArgument(nextgen.st.model.STArgument argument, nextgen.st.model.STModel model, nextgen.st.model.STParameter parameter, nextgen.st.model.STValue value) {
		this.argument = argument;
		this.model = model;
		this.parameter = parameter;
		this.value = value;
	}
}