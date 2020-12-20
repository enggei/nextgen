package nextgen.templates.jgoodies;

public enum columnAlignment {

	R() {
		@Override
		public String toString() { return "right"; }
	},
	L() {
		@Override
		public String toString() { return "left"; }
	},
	C() {
		@Override
		public String toString() { return "center"; }
	},
	F() {
		@Override
		public String toString() { return "fill"; }
	},
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