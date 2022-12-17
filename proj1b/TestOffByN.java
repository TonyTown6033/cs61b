import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    static CharacterComparator offByN = new OffByN(2);
    @Test
    public void testEqualChars(){
        assertTrue(offByN.equalChars('a','c'));
        assertTrue(offByN.equalChars('f','h'));
        assertFalse(offByN.equalChars('q','a'));
        assertFalse(offByN.equalChars('r','b'));
    }
}
