import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
    public void nullShouldReturnFalse() {
        assertFalse(passwordValidator.checkPasswordNull(null));
    }

    @Test
    public void passwordShouldBeLargerThanEightSymbols() {
        assertFalse(passwordValidator.checkPasswordLength("toShort"));
    }

    @Test
    public void passwordShouldBeSmallerThanTwentyFiveSymbols() {
        assertFalse(passwordValidator.checkPasswordLength("toLoooooooooooooooooooooooooong"));
    }

    @Test
    public void passwordShouldBeGreaterThanEightSymbolsAndSmallerThenTwentyFiveSymbols() {
        assertTrue(passwordValidator.checkPasswordLength("perfectPassword"));
    }

    @Test
    public void passwordShouldNotHaveOnlyLowerCase() {
        assertFalse(passwordValidator.checkPasswordUpperLowerCase("onlylowercase"));
    }

    @Test
    public void passwordShouldNotHaveOnlyUpperCase() {
        assertFalse(passwordValidator.checkPasswordUpperLowerCase("ONLYUPPERCASE"));
    }

    @Test
    public void passwordShouldConsistUpperAndLowerCase() {
        assertTrue(passwordValidator.checkPasswordUpperLowerCase("UPPERCASElowercase"));
    }

    @Test
    public void passwordMustHaveNumbers() {
        assertFalse(passwordValidator.checkPasswordHasNumber("noNumbers"));
    }

    @Test
    public void passwordMustHaveSpecialCharacter() {
        assertFalse(passwordValidator.checkPasswordSpecialCharacter("nospecialchars"));
    }

    @Test
    public void passwordMustNotHaveSameContinuesNumbers() {
        assertFalse(passwordValidator.checkPasswordContinuousNumbers("123abcdefg"));
    }

    @Test
    public void passwordMustNotHaveSameNumber() {
        assertFalse(passwordValidator.checkPasswordSameNumber("222223456"));
    }
}