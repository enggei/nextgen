package nextgen.templates.kotlin;

public enum BitwiseOperator {

	signedShiftLeft() {
		@Override
		public String toString() { return "shl"; }
	},
	signedShiftRight() {
		@Override
		public String toString() { return "shr"; }
	},
	unsignedShiftRight() {
		@Override
		public String toString() { return "ushr"; }
	},
	bitwiseAnd() {
		@Override
		public String toString() { return "and"; }
	},
	bitwiseOr() {
		@Override
		public String toString() { return "or"; }
	},
	bitwiseXor() {
		@Override
		public String toString() { return "xor"; }
	},
	bitwiseInversion() {
		@Override
		public String toString() { return "inv"; }
	}
}  