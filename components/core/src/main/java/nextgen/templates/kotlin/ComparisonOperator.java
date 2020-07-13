package nextgen.templates.kotlin;

public enum ComparisonOperator {

	equals() {
		@Override
		public String toString() { return "=="; }
	},
	notEquals() {
		@Override
		public String toString() { return "!="; }
	},
	gt() {
		@Override
		public String toString() { return ">"; }
	},
	lt() {
		@Override
		public String toString() { return "<"; }
	},
	gte() {
		@Override
		public String toString() { return ">="; }
	},
	lte() {
		@Override
		public String toString() { return "<="; }
	},
	identity() {
		@Override
		public String toString() { return "==="; }
	},
	notIdentity() {
		@Override
		public String toString() { return "!=="; }
	}
}  