package nextgen.templates.jgoodies;

public enum rowAlignment {

	CENTER() {
		@Override
		public String toString() { return "center"; }
	},
	TOP() {
		@Override
		public String toString() { return "top"; }
	},
	BOTTOM() {
		@Override
		public String toString() { return "bottom"; }
	},
	FILL() {
		@Override
		public String toString() { return "fill"; }
	}
}  