package nextgen.templates.test;

public enum TEST {

	ONE() {
		@Override
		public String toString() { return "1"; }
	},
	TWO() {
		@Override
		public String toString() { return "2"; }
	},
	THREE
}