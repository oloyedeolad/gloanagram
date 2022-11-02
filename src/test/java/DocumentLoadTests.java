import org.example.ReadSimilarWord;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DocumentLoadTests {


    @Test
    @DisplayName("Test empty file path")
    void testEmptyFilePathThrowException() {


        Throwable throwable =  assertThrows(RuntimeException.class, () -> ReadSimilarWord.readWordFromFile(""));

        assertEquals("The file path cannot be empty", throwable.getMessage());


    }

    @Test
    @DisplayName("Test file not found")
    void testFileNotFoundThrowException() {


        assertThrows(RuntimeException.class, () -> ReadSimilarWord.readWordFromFile("C:\\Users\\oloye\\IdeaProjects\\Anagram\\src\\main\\resources\\example300.txt"));

    }

    @Test
    @DisplayName("Test bad file format")
    void testInvalidFileThrowException() {


        assertThrows(RuntimeException.class, () -> ReadSimilarWord.readWordFromFile("C:\\Users\\oloye\\IdeaProjects\\Anagram\\src\\main\\resources\\example3.txts"));

    }


}
