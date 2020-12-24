package nextgen.templates.jgoodies;

public enum vAlignment {

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
	DEFAULT() {
		@Override
		public String toString() { return "default"; }
	},
	FILL() {
		@Override
		public String toString() { return "fill"; }
	}
}  