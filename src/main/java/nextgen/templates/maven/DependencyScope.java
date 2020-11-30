package nextgen.templates.maven;

public enum DependencyScope {

	System() {
		@Override
		public String toString() { return "system"; }
	},
	Test() {
		@Override
		public String toString() { return "test"; }
	},
	Runtime() {
		@Override
		public String toString() { return "runtime"; }
	},
	Provided() {
		@Override
		public String toString() { return "provided"; }
	},
	Import() {
		@Override
		public String toString() { return "import"; }
	},
	Compile() {
		@Override
		public String toString() { return "compile"; }
	}
}  