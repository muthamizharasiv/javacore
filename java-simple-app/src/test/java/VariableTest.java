import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class VariableTest {
    @DisplayName ("Check variables are correct")
    @Test // this annotation
    void learnTheVariableValidCase(){
        int osNum = 12;
        int expectedValue = 12;
        Assertions.assertEquals(expectedValue, osNum);

    }
    @DisplayName("Check variables are incorrect")
    @Test
    void learnVariablesInvalidCase(){
        int osNum = 12;
        int expectedValue = 13;
        Assertions.assertNotEquals(expectedValue,osNum);
    }
}
