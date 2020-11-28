package nextgen.events;

public final class NewKV {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(NewKV.class);

	public static void post(nextgen.model.STModel stModel, nextgen.model.STArgument argument, nextgen.model.STArgumentKV kv, nextgen.model.STParameterKey stParameterKey, nextgen.model.STValue value) {
		//log.info("post NewKV");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewKV(stModel, argument, kv, stParameterKey, value));
	}

	public final nextgen.model.STModel stModel;
	public final nextgen.model.STArgument argument;
	public final nextgen.model.STArgumentKV kv;
	public final nextgen.model.STParameterKey stParameterKey;
	public final nextgen.model.STValue value;

	public NewKV(nextgen.model.STModel stModel, nextgen.model.STArgument argument, nextgen.model.STArgumentKV kv, nextgen.model.STParameterKey stParameterKey, nextgen.model.STValue value) {
		this.stModel = stModel;
		this.argument = argument;
		this.kv = kv;
		this.stParameterKey = stParameterKey;
		this.value = value;
	}
}