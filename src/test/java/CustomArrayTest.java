import com.inkspac3.entity.CustomArray;
import com.inkspac3.exception.CustomArrayException;
import com.inkspac3.validator.impl.CustomArrayValidatorImpl;
import com.inkspac3.validator.CustomArrayValidator;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class CustomArrayTest {

    private final CustomArrayValidator validator = new CustomArrayValidatorImpl();
    private CustomArray array;

    @BeforeEach
    public void setUp() throws CustomArrayException {
        array = new CustomArray(2,validator);
    }

    @Test
//    @CsvSource({
//            "book",
//            "tail",
//            "ice"
//    })
    public void testAddAndGet() throws CustomArrayException {

        array.add("book");
        array.add("tail");

        assertEquals(2, array.size());
        assertEquals("book", array.getElem(0));
        assertEquals("tail", array.getElem(1));

        Exception exception = assertThrows(CustomArrayException.class, () -> array.add("ice"));
        assertEquals("Array is full", exception.getMessage());
    }

    @Test
    public void testInvalidIndexException() throws CustomArrayException {
        array.add("table");


        Exception exception2 = assertThrows(CustomArrayException.class, () -> array.getElem(2));
        assertEquals("Index out of bounds", exception2.getMessage());
    }
}
