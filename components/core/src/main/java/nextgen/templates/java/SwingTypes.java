package nextgen.templates.java;

public enum SwingTypes {

	SwingUtilitiesType() {
		@Override
		public String toString() { return "javax.swing.SwingUtilities"; }
	},
	JPanelType() {
		@Override
		public String toString() { return "javax.swing.JPanel"; }
	}
}  