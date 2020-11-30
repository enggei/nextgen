package nextgen.templates.maven;

public enum DependencyType {

	Jar() {
		@Override
		public String toString() { return "jar"; }
	},
	War() {
		@Override
		public String toString() { return "war"; }
	},
	Pom() {
		@Override
		public String toString() { return "pom"; }
	}
}  