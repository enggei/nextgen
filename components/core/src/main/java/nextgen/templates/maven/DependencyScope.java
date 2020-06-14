package nextgen.templates.maven;

public enum DependencyScope {

	Provided() {
		@Override
		public String toString() { return "provided"; }
	},
	Runtime() {
		@Override
		public String toString() { return "runtime"; }
	},
	Test() {
		@Override
		public String toString() { return "test"; }
	},
	System() {
		@Override
		public String toString() { return "system"; }
	},
	Import() {
		@Override
		public String toString() { return "import"; }
	}
} 