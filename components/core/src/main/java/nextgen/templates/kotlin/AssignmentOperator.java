package nextgen.templates.kotlin;

public enum AssignmentOperator {

	assign() {
		@Override
		public String toString() { return "="; }
	},
	plusAssign() {
		@Override
		public String toString() { return "+="; }
	},
	minusAssign() {
		@Override
		public String toString() { return "-="; }
	},
	timesAssign() {
		@Override
		public String toString() { return "*="; }
	},
	divAssign() {
		@Override
		public String toString() { return "/="; }
	},
	remAssign() {
		@Override
		public String toString() { return "%="; }
	}
}  