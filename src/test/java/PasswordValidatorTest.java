import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mock;

public class PasswordValidatorTest {

      PasswordValidator passwordValidator;

    @Mock
    private CommonPasswordChecker commonPasswordChecker;

    @BeforeEach
    public void setUp() {
        passwordValidator = new PasswordValidator(commonPasswordChecker);
    }

    @Test
    public void testToShort() {
        String password = "h";
        assertFalse(passwordValidator.checkPassword(password));
    }

    @Test
    public void testToLong() {
        String password = "1234567876543245676543234565432345643";
        assertFalse(passwordValidator.checkPassword(password));
    }

    //NOT WORKING
    @Test
    public void testOk() {
        String password = "1234567";
        assertTrue(passwordValidator.checkPassword(password));
    }
}