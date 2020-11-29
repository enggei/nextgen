package nextgen.templates.maven;

public class NpmScript {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;


	NpmScript(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("npmScript");
		return st.render().trim();
	}




	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		NpmScript that = (NpmScript) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "npmScript() ::= <<#!/bin/sh\n" + 
				"PATH=\"$PWD/target/node/\":$PATH\n" + 
				"node \"target/node/node_modules/npm/bin/npm-cli.js\" \"$@\" >>";
}  