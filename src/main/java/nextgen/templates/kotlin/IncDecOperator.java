package nextgen.templates.kotlin;

public enum IncDecOperator {

	inc() {
		@Override
		public String toString() { return "++"; }
	},
	dec() {
		@Override
		public String toString() { return "--"; }
	}
}  