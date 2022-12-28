import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    static CharacterComparator offByOne = new OffByOne();

    static CharacterComparator offByN = new OffByN(2);

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testisPalindrome(){
        assertTrue(palindrome.isPalindrome("wow"));
        assertTrue(palindrome.isPalindrome("lol"));
        assertFalse(palindrome.isPalindrome("coool"));
        assertFalse(palindrome.isPalindrome("perfect"));
    }

    @Test
    public void testPalindromeOffOne(){
        assertTrue(palindrome.isPalindrome("flake",offByOne));
        assertTrue(palindrome.isPalindrome("mon",offByOne));
        assertTrue(palindrome.isPalindrome("aceghfdb",offByOne));
        assertFalse(palindrome.isPalindrome("bird",offByOne));
        assertFalse(palindrome.isPalindrome("eletricity",offByOne));
    }

    @Test
    public void testPalindromeOffByN(){
        assertTrue(palindrome.isPalindrome("bad",offByN));
        assertTrue(palindrome.isPalindrome("adc",offByN));
        assertFalse(palindrome.isPalindrome("bird",offByN));
        assertFalse(palindrome.isPalindrome("eletricity",offByN));
    }
}
