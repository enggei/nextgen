package nextgen.events;

public final class NewSTArgument {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(NewSTArgument.class);

	public static void post(nextgen.model.STArgument argument, nextgen.model.STModel model, nextgen.model.STParameter parameter, nextgen.model.STValue value) {
		log.info("NewSTArgument" + " argument" + " model" + " parameter" + " value");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewSTArgument(argument, model, parameter, value));
	}

	public final nextgen.model.STArgument argument;
	public final nextgen.model.STModel model;
	public final nextgen.model.STParameter parameter;
	public final nextgen.model.STValue value;

	public NewSTArgument(nextgen.model.STArgument argument, nextgen.model.STModel model, nextgen.model.STParameter parameter, nextgen.model.STValue value) {
		this.argument = argument;
		this.model = model;
		this.parameter = parameter;
		this.value = value;
	}
}