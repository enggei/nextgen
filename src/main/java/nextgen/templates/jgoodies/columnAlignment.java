package nextgen.templates.jgoodies;

public enum columnAlignment {

	LEFT() {
		@Override
		public String toString() { return "left"; }
	},
	CENTER() {
		@Override
		public String toString() { return "center"; }
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