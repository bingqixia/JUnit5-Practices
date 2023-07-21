package lifecycle;

import org.junit.jupiter.api.*;

/**
 * @author Bingqi Xia
 * @version 1.0
 * @date 21/07/2023 15:29
 */
public class PerMethodLifecycleTest {
    public PerMethodLifecycleTest() {
        System.out.println("Constructor");
    }

    @BeforeAll
    static void beforeTheEntireTest() {
        System.out.println("Before the entire test fixture");
    }

    @AfterAll
    static void afterTheEntireTest() {
        System.out.println("After the entire test");
    }

    @BeforeEach
    void beforeEachTest() {
        System.out.println("Before each test");
    }

    @AfterEach
    void afterEachTest() {
        System.out.println("After each test");
    }

    @Test
    void firstTest() {
        System.out.println("First Test");
    }

    @Test
    void secondTest() {
        System.out.println("Second Test");
    }
}
