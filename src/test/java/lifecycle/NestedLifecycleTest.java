package lifecycle;

import org.junit.jupiter.api.*;

/**
 * @author Bingqi Xia
 * @version 1.0
 * @date 21/07/2023 15:46
 */
public class NestedLifecycleTest {
    @Nested
    class NestedTestPerMethod {
        @BeforeEach
        void beforeEachTest() {
            System.out.println("[NestedTestPerMethod]: Before Each Test");
        }

        @AfterEach
        void afterEachTest() {
            System.out.println("[NestedTestPerMethod]: After Each Test");
        }

        @Test
        void firstTest() {
            System.out.println("[NestedTestPerMethod]: First Test");
        }

        @Test
        void secondTest() {
            System.out.println("[NestedTestPerMethod]: Second Test");
        }
    }

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class NestedTestPerClass {
        @BeforeAll
        void beforeEntireTest() {
            System.out.println("[NestedTestPerClass]: Before Entire Test");
        }

        @AfterAll
        void afterEntireTest() {
            System.out.println("[NestedTestPerClass]: After Entire Test");
        }

        @Test
        void firstTest() {
            System.out.println("[NestedTestPerClass]: First Test");
        }

        @Test
        void secondTest() {
            System.out.println("[NestedTestPerClass]: Second Test");
        }
    }
}
