import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;


public class PasswordValidatorTest {

    private PasswordValidator passwordValidator;

    @BeforeEach
    public void setUp(){
        CommonPasswordChecker commonPasswordChecker = Mockito.mock(CommonPasswordChecker.class);
        passwordValidator = new PasswordValidator(commonPasswordChecker);
    }
    @Test
    public void passwordShouldReturnFalseIfNull() {
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
    public void passwordShouldHaveNumbers() {
        assertFalse(passwordValidator.checkPasswordHasNumber("noNumbers"));
    }

    @Test
    public void passwordShouldHaveSpecialCharacter() {
        assertFalse(passwordValidator.checkPasswordSpecialCharacter("nospecialchars"));
    }

    @Test
    public void passwordShouldHaveSpecialCharacters() {
        assertTrue(passwordValidator.checkPasswordSpecialCharacter("passwordWith@"));
    }

    @Test
    public void passwordShouldNotHaveSameContinuesNumbers() {
        assertFalse(passwordValidator.checkPasswordContinuousNumbers("123abcdefg"));
    }

    @Test
    public void passwordShouldBeValidWhenNoDuplicateDigital() {
        assertFalse(passwordValidator.checkPasswordSameNumber("222223456"));
    }

    @Test
    public void passwordIsValid() {
        assertTrue(passwordValidator.checkPassword("EFeAdzh@r1245"));
    }

    @Test
    public void passwordIsInvalid() {
        assertFalse(passwordValidator.checkPassword("Ef@45"));
    }
}