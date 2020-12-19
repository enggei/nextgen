package nextgen.events;

public final class NewSTKVArgument {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(NewSTKVArgument.class);

	public static void post(nextgen.model.STModel model, nextgen.model.STParameter stParameter, nextgen.model.STArgument argument, java.util.Collection<nextgen.model.STArgumentKV> kvs) {
		log.info("NewSTKVArgument" + " model" + " stParameter" + " argument" + " kvs");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewSTKVArgument(model, stParameter, argument, kvs));
	}

	public final nextgen.model.STModel model;
	public final nextgen.model.STParameter stParameter;
	public final nextgen.model.STArgument argument;
	public final java.util.Collection<nextgen.model.STArgumentKV> kvs;

	public NewSTKVArgument(nextgen.model.STModel model, nextgen.model.STParameter stParameter, nextgen.model.STArgument argument, java.util.Collection<nextgen.model.STArgumentKV> kvs) {
		this.model = model;
		this.stParameter = stParameter;
		this.argument = argument;
		this.kvs = kvs;
	}
}