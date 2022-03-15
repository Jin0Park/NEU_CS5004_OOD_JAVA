import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthorTest {

    private static Author testAuthor;
    private static Person testPerson;

    @BeforeEach
    void setUp() {
        testPerson = new Person("Jin Young", "Park");
        testAuthor = new Author(testPerson, "jinpark@neu.com", "225 Thomas Ave N");
    }

    @Test
    void getName() {
        Person expectedName = new Person("Jin Young", "Park");
         assertEquals(expectedName, testAuthor.getName());
        // assertEquals(expectedName, testAuthor.getName());
        // -> this fails because expected name and the value of testAuthor.getName() seems the same but stored in different location.
        //  Meaning that comparing with same looking apples.
        // but if override the values, then it will pass
    }

    @Test
    void getEmail() {
        assertEquals("jinpark@neu.com", testAuthor.getEmail());
    }

    @Test
    void getAddress() {
        assertEquals("225 Thomas Ave N", testAuthor.getAddress());
    }
}