package nextgen.java.st;


public class CompilationUnit {

	private java.util.List<ImportDeclaration> importDeclaration = new java.util.ArrayList<>();
	private PackageDeclaration packageDeclaration;
	private java.util.List<CompilationUnitMember> types = new java.util.ArrayList<>();
	private final java.util.UUID uuid;

	public java.util.List<ImportDeclaration> getImportDeclaration() { 
		return importDeclaration;
	}

	public CompilationUnit addImportDeclaration(ImportDeclaration importDeclaration) { 
		this.importDeclaration.add(importDeclaration);
		return this;
	}

	public CompilationUnit removeImportDeclaration(ImportDeclaration importDeclaration) { 
		this.importDeclaration.remove(importDeclaration);
		return this;
	}

	public PackageDeclaration getPackageDeclaration() { 
		return packageDeclaration;
	}

	public CompilationUnit setPackageDeclaration(PackageDeclaration packageDeclaration) { 
		this.packageDeclaration = packageDeclaration;
		return this;
	}

	public CompilationUnit removePackageDeclaration() { 
		this.packageDeclaration = null;
		return this;
	}

	public java.util.List<CompilationUnitMember> getTypes() { 
		return types;
	}

	public CompilationUnit addTypes(CompilationUnitMember types) { 
		this.types.add(types);
		return this;
	}

	public CompilationUnit removeTypes(CompilationUnitMember types) { 
		this.types.remove(types);
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "CompilationUnit";
	}

	public CompilationUnit() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public CompilationUnit(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final CompilationUnit other = (CompilationUnit) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}