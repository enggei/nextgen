package nextgen.templates.jgoodies;

public enum rowAlignment {

	TOP() {
		@Override
		public String toString() { return "top"; }
	},
	CENTER() {
		@Override
		public String toString() { return "center"; }
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