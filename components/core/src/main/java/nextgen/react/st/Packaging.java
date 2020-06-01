package nextgen.react.st;


public enum Packaging {

	POM,
	JAR,
	WAR;

	@Override
	public java.lang.String toString() { 
		return name().toString().toLowerCase();
	}
}