package nextgen.templates.java;

public enum Modifiers {

	PUBLIC() {
		@Override
		public String toString() { return "public"; }
	},
	PROTECTED() {
		@Override
		public String toString() { return "protected"; }
	},
	PRIVATE() {
		@Override
		public String toString() { return "private"; }
	},
	FINAL() {
		@Override
		public String toString() { return "final"; }
	},
	STATIC() {
		@Override
		public String toString() { return "static"; }
	}
}  