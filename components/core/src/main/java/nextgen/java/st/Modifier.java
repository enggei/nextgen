package nextgen.java.st;


public enum Modifier {

	PUBLIC,
	PROTECTED,
	PRIVATE,
	STATIC,
	ABSTRACT,
	FINAL;

	@Override
	public java.lang.String toString() { 
		return name().toString().toLowerCase();
	}
}