package nextgen.templates.test;

public enum LOL {

    ONE() {
        @Override
        public String toString() { return "1"; }
    },
    STRING() {
        @Override
        public String toString() { return "java.lang.String"; }
    };

    public static void main(String[] args) {
        System.out.println(LOL.ONE.name() + " = " + LOL.ONE);
        System.out.println(LOL.STRING.name() + " = " + LOL.STRING);
    }
}