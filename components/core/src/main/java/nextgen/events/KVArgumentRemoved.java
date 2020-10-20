package nextgen.events;

public final class KVArgumentRemoved {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(KVArgumentRemoved.class);

	public static void post(nextgen.st.model.STArgument argument) {
		log.info("post KVArgumentRemoved");
		org.greenrobot.eventbus.EventBus.getDefault().post(new KVArgumentRemoved(argument));
	}

	public final nextgen.st.model.STArgument argument;

	public KVArgumentRemoved(nextgen.st.model.STArgument argument) {
		this.argument = argument;
	}
}