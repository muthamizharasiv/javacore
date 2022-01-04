import Clsobj.Bmw;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BmwTests {
    @DisplayName("Testing object nullability")
    @Test
    void testInValidObject(){
        Bmw bmw = null;
        Assertions.assertNull(bmw);
    }
    @DisplayName("Testing object validity")
    @Test
    void testValidObject(){
        Bmw bmw = new Bmw();
        Assertions.assertNotNull(bmw);
        int expectedSpeed = 10;
        int actualSpeed = bmw.speed;
        Assertions.assertEquals(expectedSpeed,actualSpeed);
    }
}
