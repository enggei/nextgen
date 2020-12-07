package nextgen.templates.java;

public class PasswordUtils {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private Object _packageName;

	PasswordUtils(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("PasswordUtils");
		st.add("name", _name);
		st.add("packageName", _packageName);
		return st.render().trim();
	}

	public PasswordUtils setName(Object value) {
		this._name = value;
		return this;
	}

	public Object getName() {
		return this._name;
	}

	public Object getName(Object defaultValue) {
		return this._name == null ? defaultValue : this._name;
	}

	public boolean hasName() {
		return this._name != null;
	}

	public PasswordUtils removeName() {
		this._name = null;
		return this;
	} 

	public PasswordUtils setPackageName(Object value) {
		this._packageName = value;
		return this;
	}

	public Object getPackageName() {
		return this._packageName;
	}

	public Object getPackageName(Object defaultValue) {
		return this._packageName == null ? defaultValue : this._packageName;
	}

	public boolean hasPackageName() {
		return this._packageName != null;
	}

	public PasswordUtils removePackageName() {
		this._packageName = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		PasswordUtils that = (PasswordUtils) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "PasswordUtils(name,packageName) ::= <<package ~packageName~;\n" + 
				"\n" + 
				"import javax.crypto.SecretKeyFactory;\n" + 
				"import javax.crypto.spec.PBEKeySpec;\n" + 
				"import java.security.NoSuchAlgorithmException;\n" + 
				"import java.security.SecureRandom;\n" + 
				"import java.security.spec.InvalidKeySpecException;\n" + 
				"import java.util.Arrays;\n" + 
				"import java.util.Base64;\n" + 
				"import java.util.Random;\n" + 
				"\n" + 
				"public class ~name~ {\n" + 
				"\n" + 
				"    private static final Random RANDOM = new SecureRandom();\n" + 
				"    private static final String ALPHABET = \"0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz\";\n" + 
				"    private static final int ITERATIONS = 10000;\n" + 
				"    private static final int KEY_LENGTH = 256;\n" + 
				"\n" + 
				"    public static String getSalt(int length) {\n" + 
				"        StringBuilder returnValue = new StringBuilder(length);\n" + 
				"        for (int i = 0; i < length; i++)\n" + 
				"            returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));\n" + 
				"        return new String(returnValue);\n" + 
				"    }\n" + 
				"\n" + 
				"    public static byte[] hash(char[] password, byte[] salt) {\n" + 
				"        final PBEKeySpec spec = new PBEKeySpec(password, salt, ITERATIONS, KEY_LENGTH);\n" + 
				"        Arrays.fill(password, Character.MIN_VALUE);\n" + 
				"        try {\n" + 
				"            SecretKeyFactory skf = SecretKeyFactory.getInstance(\"PBKDF2WithHmacSHA1\");\n" + 
				"            return skf.generateSecret(spec).getEncoded();\n" + 
				"        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {\n" + 
				"            throw new AssertionError(\"Error while hashing a password: \" + e.getMessage(), e);\n" + 
				"        } finally {\n" + 
				"            spec.clearPassword();\n" + 
				"        }\n" + 
				"    }\n" + 
				"\n" + 
				"    public static String generateSecurePassword(String password, String salt) {\n" + 
				"        String returnValue;\n" + 
				"        byte[] securePassword = hash(password.toCharArray(), salt.getBytes());\n" + 
				"        returnValue = Base64.getEncoder().encodeToString(securePassword);\n" + 
				"        return returnValue;\n" + 
				"    }\n" + 
				"\n" + 
				"    public static boolean verifyUserPassword(String providedPassword, String securedPassword, String salt) {\n" + 
				"        final String newSecurePassword = generateSecurePassword(providedPassword, salt);\n" + 
				"        return newSecurePassword.equalsIgnoreCase(securedPassword);\n" + 
				"    }\n" + 
				"} >>";
}  