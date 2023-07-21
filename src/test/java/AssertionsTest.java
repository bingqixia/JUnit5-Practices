import com.pooki.Calculator;
import com.pooki.Person;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Bingqi Xia
 * @version 1.0
 * @date 16/07/2023 21:22
 */

public class AssertionsTest {
    /**
     * Value Equals with custom message
     */
    @Test
    void addNumbers() {
        Calculator calculator = new Calculator();
        assertEquals(5, calculator.add(2, 3), "1 + 2 should equal 3");
    }

    /**
     * True Condition
     */
    @Test
    void firstNameStartsWithB() {
        Person person = new Person("Bingqi", "Xia");
        assertTrue(person.getFirstName().startsWith("B"));
    }

    /**
     * Not NULL
     */
    @Test
    void personHasFirstName() {
        Person person = new Person("Bingqi", "Xia");
        assertNotNull(person.getFirstName());
    }

    /**
     * Array Equals
     */
    @Test
    void arrayEquals() {
        final int[] array = {3, 2, 1};
        final int[] expected = {1, 2, 3};

        Arrays.sort(array);

        assertArrayEquals(expected, array);
    }

    /**
     * Iterable Equals
     */
    @Test
    void iterablesEqual() {
        final List<String> fruites = Arrays.asList("Mango", "Banana", "Apple");
        final List<String> excepted = Arrays.asList("Apple", "Banana", "Mango");

        Collections.sort(fruites);

        assertIterableEquals(excepted, fruites);
    }

    /**
     * Objects are equals by value
     * need override toString(), equals(), hashCode() method of this Class
     * Otherwise it will compare two objects by reference
     */
    @Test
    void personsAreSame() {
        Person pooki = new Person("Bingqi", "Xia");
        Person xia = new Person("Bingqi", "Xia");

        assertEquals(pooki, xia);
    }

    /**
     * Compare two objects by reference
     */
    @Test
    void personsAreNotSameInstance() {
        Person john = new Person("Bingqi", "Xia");
        Person doe = new Person("Bingqi", "Xia");

        assertNotSame(john, doe);
    }

    /**
     * Exceptions
     */
    @Test
    void divideByZeroThrowsIllegalArgumentException() {
        Calculator calculator = new Calculator();
        assertThrows(IllegalArgumentException.class, () -> calculator.divide(1, 0));
    }

    /**
     * Timeout without abort execution
     */
    @Test
    void returnValueBeforeTimeoutExceeded() {
        final String message = assertTimeout(Duration.ofMillis(50), () -> {
            Thread.sleep(100);
            return "a message";
        });
        assertEquals("a message", message);
    }

    /**
     * Timeout with abort execution, it will abort after 50ms
     */
    @Test
    void abortWhenTimeoutExceeded() {
        final String message = assertTimeoutPreemptively(Duration.ofMillis(50), () -> {
            Thread.sleep(100);
            return "another message";
        });
        assertEquals("another message", message);
    }

    /**
     * Format Custom Message
     */
    @Test
    void addingEmployeesToPersonnel() {
        Person employee = new Person("John", "Doe");

        Set<Person> personnel = new HashSet<>();
        personnel.add(employee);

        assertTrue(personnel.contains(employee),
                () -> String.format("Personnel file for %s was not found", employee));
    }

    /**
     * Grouped AssertionsTest
     */
    @Test
    void firstAndLastNameMatches() {
        Person person = new Person("John", "Doe");

        assertAll("person",
                () -> assertEquals("John", person.getFirstName()),
                () -> assertEquals("Doe", person.getLastName())
        );
    }

    /**
     * check contains, we can use Hamcrest, AssertJ, or Truth library
     * they have additional assertions to support these complex testing in simple code
     */
    @Test
    void listHasPerson() {
        List<Person> people = new ArrayList<>();
        people.add(new Person("John", "Doe"));
        people.add(new Person("Jane", "Doe"));
        assertTrue(people.stream().anyMatch(p -> p.getFirstName().equals("John")));
    }
}
