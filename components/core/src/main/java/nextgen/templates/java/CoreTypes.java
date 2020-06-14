package nextgen.templates.java;

public enum CoreTypes {

	FileType() {
		@Override
		public String toString() { return "java.io.File"; }
	},
	StringType() {
		@Override
		public String toString() { return "java.lang.String"; }
	},
	LongType() {
		@Override
		public String toString() { return "java.lang.Long"; }
	},
	AtomicLongType() {
		@Override
		public String toString() { return "java.util.concurrent.atomic.AtomicLong"; }
	}
}  