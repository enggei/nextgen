package nextgen.templates.jgoodies;

public enum hAlignment {

	CENTER() {
		@Override
		public String toString() { return "center"; }
	},
	LEFT() {
		@Override
		public String toString() { return "left"; }
	},
	RIGHT() {
		@Override
		public String toString() { return "right"; }
	},
	DEFAULT() {
		@Override
		public String toString() { return "default"; }
	},
	FILL() {
		@Override
		public String toString() { return "fill"; }
	}
}  