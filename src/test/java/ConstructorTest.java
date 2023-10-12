import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;


    public class ConstructorTest {
        @Test
        public void testNullaryConstructor() {
            // given
            // when
            PhoneBook phoneBook = new PhoneBook();

            // then
            assertTrue(phoneBook.getMap() instanceof Map<String, List<String>>);
        }

        @Test
        public void testNonNullaryConstructor() {
            // given
            Map<String, List<String>> dependency = new LinkedHashMap<>();

            // when
            PhoneBook phoneBook = new PhoneBook(dependency);

            // then
            assertEquals(dependency, phoneBook.getMap());
        }

}
