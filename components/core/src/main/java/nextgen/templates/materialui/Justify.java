package nextgen.templates.materialui;

public enum Justify {

	START() {
		@Override
		public String toString() { return "flex-start"; }
	},
	CENTER() {
		@Override
		public String toString() { return "center"; }
	},
	END() {
		@Override
		public String toString() { return "flex-end"; }
	},
	BETWEEN() {
		@Override
		public String toString() { return "space-between"; }
	},
	AROUND() {
		@Override
		public String toString() { return "space-around"; }
	},
	EVENLY() {
		@Override
		public String toString() { return "space-evenly"; }
	}
}  