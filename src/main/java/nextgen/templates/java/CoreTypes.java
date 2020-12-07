package nextgen.templates.java;

public enum CoreTypes {

	AtomicLongType() {
		@Override
		public String toString() { return "java.util.concurrent.atomic.AtomicLong"; }
	},
	LongType() {
		@Override
		public String toString() { return "java.lang.Long"; }
	},
	ThreadType() {
		@Override
		public String toString() { return "java.util.Thread"; }
	},
	StringType() {
		@Override
		public String toString() { return "java.lang.String"; }
	},
	FileType() {
		@Override
		public String toString() { return "java.io.File"; }
	}
}  