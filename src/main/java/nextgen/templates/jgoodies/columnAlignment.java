package nextgen.templates.jgoodies;

public enum columnAlignment {

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
	FILL() {
		@Override
		public String toString() { return "fill"; }
	}
}  