package nextgen.events;

public final class STInterfaceChanged {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STInterfaceChanged.class);

	public static void post(nextgen.model.STInterface sTInterface) {
		log.info("STInterfaceChanged" + " sTInterface");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STInterfaceChanged(sTInterface));
	}

	public final nextgen.model.STInterface sTInterface;

	public STInterfaceChanged(nextgen.model.STInterface sTInterface) {
		this.sTInterface = sTInterface;
	}
}  