package nextgen.templates.kotlin;

public enum ArithmeticOperator {

	plus() {
		@Override
		public String toString() { return "+"; }
	},
	minus() {
		@Override
		public String toString() { return "-"; }
	},
	times() {
		@Override
		public String toString() { return "*"; }
	},
	div() {
		@Override
		public String toString() { return "/"; }
	},
	rem() {
		@Override
		public String toString() { return "%"; }
	},
	rangeTo() {
		@Override
		public String toString() { return ".."; }
	}
}  