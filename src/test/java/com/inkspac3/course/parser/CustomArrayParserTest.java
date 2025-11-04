package com.inkspac3.course.parser;

import com.inkspac3.course.entity.CustomArray;
import com.inkspac3.course.exception.CustomArrayException;
import com.inkspac3.course.factory.CustomArrayFactory;
import com.inkspac3.course.validator.CustomArrayValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CustomArrayParserTest {

    private CustomArrayValidator validator;
    private CustomArrayFactory factory;
    private CustomArrayParser parser;

    @BeforeEach
    void setUp() throws CustomArrayException {
        validator = mock(CustomArrayValidator.class);
        factory = mock(CustomArrayFactory.class);
        parser = new CustomArrayParser(validator, factory);

        when(factory.createArray(anyInt())).thenAnswer(invocation -> {
            int size = invocation.getArgument(0);
            return new CustomArray(100L ,size);
        });

        doNothing().when(validator).validateArrayCreation(anyInt());
    }

    @Test
    void parseToArray_ValidLines_ReturnsCustomArray() throws CustomArrayException {
        List<String> lines = List.of("Hello World", " 123 456 ", "Тест");

        CustomArray array = parser.parseToArray(lines);

        assertAll("Check parsed elements and size",
                () -> assertEquals(6, array.size()),
                () -> assertEquals("Hello", array.getElem(0, validator)),
                () -> assertEquals("World", array.getElem(1, validator)),
                () -> assertEquals("123", array.getElem(2, validator)),
                () -> assertEquals("456", array.getElem(3, validator)),
                () -> assertEquals("Тест", array.getElem(4, validator)),
                () -> assertEquals("Тест", array.getElem(5, validator))
        );
    }

    @Test
    void parseToArray_EmptyOrInvalidLines_ThrowsException() {
        assertAll("Check exceptions for invalid input",
                () -> {
                    CustomArrayException ex = assertThrows(CustomArrayException.class, () -> parser.parseToArray(List.of()));
                    assertEquals("No lines to parse", ex.getMessage());
                },
                () -> {
                    CustomArrayException ex = assertThrows(CustomArrayException.class,
                            () -> parser.parseToArray(List.of("!!! @@@", "   ")));
                    assertEquals("No valid strings found", ex.getMessage());
                }
        );
    }
}
