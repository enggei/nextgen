package nextgen.events;

public final class NewSTKVArgument {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(NewSTKVArgument.class);

	public static void post(nextgen.st.model.STModel model, nextgen.st.model.STParameter stParameter, nextgen.st.model.STArgument argument, java.util.Collection<nextgen.st.model.STArgumentKV> kvs) {
		log.info("post NewSTKVArgument");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewSTKVArgument(model, stParameter, argument, kvs));
	}

	public final nextgen.st.model.STModel model;
	public final nextgen.st.model.STParameter stParameter;
	public final nextgen.st.model.STArgument argument;
	public final java.util.Collection<nextgen.st.model.STArgumentKV> kvs;

	public NewSTKVArgument(nextgen.st.model.STModel model, nextgen.st.model.STParameter stParameter, nextgen.st.model.STArgument argument, java.util.Collection<nextgen.st.model.STArgumentKV> kvs) {
		this.model = model;
		this.stParameter = stParameter;
		this.argument = argument;
		this.kvs = kvs;
	}
}