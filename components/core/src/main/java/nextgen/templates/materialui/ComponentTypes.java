package nextgen.templates.materialui;

public enum ComponentTypes {

	Grid() {
		@Override
		public String toString() { return "@material-ui/core/Grid"; }
	},
	FormLabel() {
		@Override
		public String toString() { return "@material-ui/core/FormLabel"; }
	},
	FormControlLabel() {
		@Override
		public String toString() { return "'@material-ui/core/FormControlLabel"; }
	},
	RadioGroup() {
		@Override
		public String toString() { return "@material-ui/core/RadioGroup"; }
	},
	Paper() {
		@Override
		public String toString() { return "@material-ui/core/Paper"; }
	},
	Typography() {
		@Override
		public String toString() { return "@material-ui/core/Typography"; }
	},
	Link() {
		@Override
		public String toString() { return "@material-ui/core/Link"; }
	},
	Button() {
		@Override
		public String toString() { return "@material-ui/core/Button"; }
	},
	Divider() {
		@Override
		public String toString() { return "@material-ui/core/Divider"; }
	}
}  