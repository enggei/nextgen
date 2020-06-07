package nextgen.templates.test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import static nextgen.templates.test.TestST.*;

/**
 * Tests for TestST
 **/
public class TestSTTests {

    @org.junit.Test
    public void testAll() {
        testParameterTests();
        testAllTypes();
        testComplex();
        testConditional();
        testEmbeddedKVConditional();
        testKv();
        testList();
        testSingle();
    }

    @org.junit.Test
    public void testParameterTests() {
        System.out.println("\n--- TEST ParameterTests:\n" + newParameterTests());
    }

    @org.junit.Test
    public void testAllTypes() {
        System.out.println("\n--- TEST AllTypes:\n" + newAllTypes());
    }

    @org.junit.Test
    public void testComplex() {
        System.out.println("\n--- TEST Complex:\n" + newComplex());
    }

    @org.junit.Test
    public void testConditional() {
        System.out.println("\n--- TEST Conditional:\n" + newConditional());
    }

    @org.junit.Test
    public void testEmbeddedKVConditional() {
        System.out.println("\n--- TEST EmbeddedKVConditional:\n" + newEmbeddedKVConditional());
    }

    @org.junit.Test
    public void testKv() {
        System.out.println("\n--- TEST Kv:\n" + newKv().addValue(1, 0L).addValue(2, new AtomicLong(99).incrementAndGet()));
    }

    @org.junit.Test
    public void testList() {
        System.out.println("\n--- TEST List:\n" + newList().addValue(1).addValue(2).addValue(3));
    }

    @org.junit.Test
    public void testSingle() {
        System.out.println("\n--- TEST Single:\n" + newSingle().setValue("TEXT"));
    }
} 