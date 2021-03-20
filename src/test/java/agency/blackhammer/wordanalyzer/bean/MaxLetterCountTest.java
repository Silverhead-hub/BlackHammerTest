package agency.blackhammer.wordanalyzer.bean;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxLetterCountTest {

    @Test
    public void isValid_OnlyNumbers() {
        MaxLetterCount maxLetterCount = new MaxLetterCount();
        assertFalse(maxLetterCount.isValid("0000"));
    }

    @Test
    public void isValid_EmptyString() {
        MaxLetterCount maxLetterCount = new MaxLetterCount();
        assertThrows(IllegalArgumentException.class , ()->maxLetterCount.setInputWord(""));
    }

    @Test
    public void isValid_StringValid() {
        MaxLetterCount maxLetterCount = new MaxLetterCount();
        assertTrue(maxLetterCount.isValid("tester"));
    }

    @Test
    public void isValid_StringNull() {
        MaxLetterCount maxLetterCount = new MaxLetterCount();
        assertThrows(IllegalArgumentException.class , ()->maxLetterCount.setInputWord(null));
    }

    @Test
    public void findMaxLetter_ValidWord() {
        MaxLetterCount maxLetterCount = new MaxLetterCount();
        maxLetterCount.setInputWord("tester");
        assertEquals("e 2", maxLetterCount.findMaxLetter());
    }

}