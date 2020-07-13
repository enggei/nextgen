package nextgen.templates.kotlin;

public enum UnaryPrefixOperator {

	unaryPlus() {
		@Override
		public String toString() { return "+"; }
	},
	unaryMinus() {
		@Override
		public String toString() { return "-"; }
	},
	not() {
		@Override
		public String toString() { return "!"; }
	}
}  