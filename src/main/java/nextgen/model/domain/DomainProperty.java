package nextgen.model.domain;

import org.greenrobot.eventbus.*;

import java.util.UUID;

public class DomainProperty {

	private final String uuid = UUID.randomUUID().toString();
	private final String instance = "." + uuid + ".DomainProperty.";

	private String name = "";
	private Object value;

	public DomainProperty() {
		EventBus.getDefault().post(System.currentTimeMillis() + instance + "new");
	}

	public String getName() { return name; }

	public DomainProperty setName(String name) { 
		this.name = name; 
		EventBus.getDefault().post(System.currentTimeMillis() + instance +  "name.set." + name);
		return this;
	}

	public Object getValue() { return value; }

	public DomainProperty setValue(Object value) { 
		this.value = value; 
		EventBus.getDefault().post(System.currentTimeMillis() + instance +  "value.set." + value);
		return this;
	}


	@Override
	public String toString() { return uuid; }
}