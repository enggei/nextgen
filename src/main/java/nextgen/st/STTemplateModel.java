package nextgen.st;


import nextgen.model.STTemplate;

public class STTemplateModel {

	private final java.util.UUID uuid;
	private STTemplate stTemplate;
	private org.stringtemplate.v4.ST st;

	public STTemplateModel() {
		this.uuid = java.util.UUID.randomUUID();
	}

	public STTemplateModel(java.util.UUID uuid) {
		this.uuid = uuid;
	}

	public STTemplateModel(STTemplateModel source) {
		this();
		this.stTemplate = source.stTemplate;
		this.st = source.st;
	}

	public STTemplateModel(STTemplate stTemplate, org.stringtemplate.v4.ST st) {
		this();
		this.stTemplate = stTemplate;
		this.st = st;
	}

	public java.util.UUID getUuid() {
		return this.uuid;
	}	

	public STTemplateModel setStTemplate(STTemplate value) {
		this.stTemplate = value;
		return this;
	}

	public STTemplate stTemplate() {
		return stTemplate;
	}


	public STTemplateModel setSt(org.stringtemplate.v4.ST value) {
		this.st = value;
		return this;
	}

	public org.stringtemplate.v4.ST st() {
		return st;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		STTemplateModel that = (STTemplateModel) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}
}