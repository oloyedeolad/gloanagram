import org.example.FindingAnagrams;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TestFindAnagram {

    static ArrayList<String> arrayList;
    static FindingAnagrams findingAnagrams;
    static ArrayList<ArrayList<String>> results;

    @BeforeAll
    @Tag("Load test data")
    @DisplayName("Load date")
    static void setUpArrayList() {
        arrayList = new ArrayList<>();

        arrayList.add("abc");
        arrayList.add("fun");
        arrayList.add("bac");
        arrayList.add("fun");
        arrayList.add("cba");
        arrayList.add("unf");
        arrayList.add("hello");
        findingAnagrams = new FindingAnagrams();
        results  = findingAnagrams.findAnagram(arrayList);
    }

    @Test
    @DisplayName("Test anagram result")
    void testFindAnagram() {
        assertFalse(results.isEmpty());
        assertEquals(3, results.size());
        assertEquals(3, results.get(0).size());
        assertEquals(1, results.get(1).size());
        assertEquals(3, results.get(2).size());
    }

    @Test
    @DisplayName("List are not repeated")
    void testAnagramWordsDifferent() {

        assertNotEquals(results.get(0), results.get(2));
        assertNotEquals(results.get(2), results.get(1));
        assertNotEquals(results.get(2), results.get(1));
    }

    @Test
    @DisplayName("Test the list contains the correct strings")
    void testAnagramWordsCorrect() {

        assertTrue(results.get(0).contains("abc"));
        assertTrue(results.get(0).contains("bac"));
        assertTrue(results.get(0).contains("cba"));
        assertTrue(results.get(1).contains("hello"));
    }
}
