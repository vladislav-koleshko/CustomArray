package com.inkspac3.course.reader;

import com.inkspac3.course.exception.CustomArrayException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomArrayReaderTest {

    private final CustomArrayReader reader = new CustomArrayReader();

    @Test
    void readLines_ValidFile_ReturnsLines() throws IOException, CustomArrayException {
        Path tempFile = Files.createTempFile("test", ".txt");
        Files.write(tempFile, List.of("Hello", "World"));

        List<String> lines = reader.readLines(tempFile.toString());

        assertAll(
                () -> assertEquals(2, lines.size()),
                () -> assertEquals("Hello", lines.get(0)),
                () -> assertEquals("World", lines.get(1))
        );

        Files.deleteIfExists(tempFile);
    }

    @Test
    void readLines_NullOrEmptyFilePath_ThrowsException() {
        assertAll(
                () -> {
                    CustomArrayException ex = assertThrows(CustomArrayException.class, () -> reader.readLines(null));
                    assertEquals("File path cannot be null or empty", ex.getMessage());
                },
                () -> {
                    CustomArrayException ex = assertThrows(CustomArrayException.class, () -> reader.readLines("   "));
                    assertEquals("File path cannot be null or empty", ex.getMessage());
                }
        );
    }
}
