package nextgen.templates.kotlin;

public enum LogicalOperator {

	and() {
		@Override
		public String toString() { return "&&"; }
	},
	or() {
		@Override
		public String toString() { return "||"; }
	},
	not() {
		@Override
		public String toString() { return "!"; }
	}
}  