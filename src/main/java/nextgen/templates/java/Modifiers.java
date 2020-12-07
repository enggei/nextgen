package nextgen.templates.java;

public enum Modifiers {

	STATIC() {
		@Override
		public String toString() { return "static"; }
	},
	PRIVATE() {
		@Override
		public String toString() { return "private"; }
	},
	FINAL() {
		@Override
		public String toString() { return "final"; }
	},
	PUBLIC() {
		@Override
		public String toString() { return "public"; }
	},
	PROTECTED() {
		@Override
		public String toString() { return "protected"; }
	}
}  