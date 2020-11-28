package nextgen.events;

public final class NewKV {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(NewKV.class);

	public static void post(nextgen.st.model.STModel stModel, nextgen.st.model.STArgument argument, nextgen.st.model.STArgumentKV kv, nextgen.st.model.STParameterKey stParameterKey, nextgen.st.model.STValue value) {
		//log.info("post NewKV");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewKV(stModel, argument, kv, stParameterKey, value));
	}

	public final nextgen.st.model.STModel stModel;
	public final nextgen.st.model.STArgument argument;
	public final nextgen.st.model.STArgumentKV kv;
	public final nextgen.st.model.STParameterKey stParameterKey;
	public final nextgen.st.model.STValue value;

	public NewKV(nextgen.st.model.STModel stModel, nextgen.st.model.STArgument argument, nextgen.st.model.STArgumentKV kv, nextgen.st.model.STParameterKey stParameterKey, nextgen.st.model.STValue value) {
		this.stModel = stModel;
		this.argument = argument;
		this.kv = kv;
		this.stParameterKey = stParameterKey;
		this.value = value;
	}
}