package nextgen.templates.javaswing;

public enum PANEL_LAYOUT {

	BORDER() {
		@Override
		public String toString() { return "new java.awt.BorderLayout()"; }
	},
	FLOW() {
		@Override
		public String toString() { return "new java.awt.FlowLayout()"; }
	}
}  