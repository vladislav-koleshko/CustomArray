package com.inkspac3.test.service;

import com.inkspac3.entity.CustomArray;
import com.inkspac3.exception.CustomArrayException;
import com.inkspac3.factory.ArrFactory;
import com.inkspac3.service.*;
import com.inkspac3.service.impl.*;
import com.inkspac3.validator.CustomArrayValidator;
import com.inkspac3.validator.impl.CustomArrayValidatorImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ServiceTest {

    private CustomArrayValidator validator;
    private ArrFactory factory;
    private CustomArray array;

    @BeforeEach
    void setUp() throws CustomArrayException {
        validator = new CustomArrayValidatorImpl();
        factory = new ArrFactory(validator);
        array = factory.createArray(10);
    }

    @Test
    void testCalculateAvgLength() throws CustomArrayException {
        array.add("123");
        array.add("45678");

        AvgLengthService service = new AvgLengthServiceImpl(validator);

        assertEquals(4, service.calculateAvgLength(array));
    }

    @Test
    void testCalculateAvgLengthEmptyArray() throws CustomArrayException {
        AvgLengthService service = new AvgLengthServiceImpl(validator);

        assertEquals(0, service.calculateAvgLength(array));
    }

    @Test
    void testThrowsExceptionForInvalidArray() {
        CustomArrayValidator mockValidator = mock(CustomArrayValidator.class);
        when(mockValidator.validateArray(array)).thenReturn(false);

        AvgLengthService service = new AvgLengthServiceImpl(mockValidator);

        Exception exception = assertThrows(CustomArrayException.class,
                () -> service.calculateAvgLength(array));
        assertEquals("Array can't be null", exception.getMessage());
    }

    @Test
    void testCalculateCountOfElem() throws CustomArrayException {
        array.add("123");
        array.add("45678");

        CountOfElemService service = new CountOfElemServiceImpl(validator);
        assertEquals(2, service.calculateCountOfElem(array));
    }

    @Test
    void testGetMinAndMax() throws CustomArrayException {
        array.add("12");
        array.add("123");

        MinMaxService service = new MinMaxServiceImpl(validator);
        assertAll("Min and Max tests",
                () -> assertEquals("12", service.getMin(array)),
                () -> assertEquals("123", service.getMax(array))
        );
    }

    @Test
    void testReplaceByIndex() throws CustomArrayException {
        array.add("123");

        ReplaceByConditionService service = new ReplaceByConditionServiceImpl(validator);
        assertEquals("4", service.replaceByIndex(0, array, "4"));
    }

    @Test
    void testSortByLength() throws CustomArrayException {
        array.add("333");
        array.add("22");
        array.add("1");

        SortService service = new SortServiceImpl(validator);

        assertAll("Sort by length",
                () -> assertArrayEquals(new String[]{"1", "22", "333"},
                        service.sortByLengthWQuickSort(array).get(), "QuickSort failed"),
                () -> assertArrayEquals(new String[]{"1", "22", "333"},
                        service.sortByLengthWMergeSort(array).get(), "MergeSort failed"),
                () -> assertArrayEquals(new String[]{"1", "22", "333"},
                        service.sortByLengthWSelectionSort(array).get(), "SelectionSort failed")
        );
    }
}
