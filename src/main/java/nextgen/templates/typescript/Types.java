package nextgen.templates.typescript;

public enum Types {

	booleanType() {
		@Override
		public String toString() { return "boolean"; }
	},
	numberType() {
		@Override
		public String toString() { return "number"; }
	},
	stringType() {
		@Override
		public String toString() { return "string"; }
	}
}  