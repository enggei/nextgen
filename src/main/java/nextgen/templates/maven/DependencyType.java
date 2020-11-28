package nextgen.templates.maven;

public enum DependencyType {

	Pom() {
		@Override
		public String toString() { return "pom"; }
	},
	Jar() {
		@Override
		public String toString() { return "jar"; }
	},
	War() {
		@Override
		public String toString() { return "war"; }
	}
}  