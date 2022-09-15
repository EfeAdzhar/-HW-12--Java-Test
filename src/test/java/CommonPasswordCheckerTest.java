import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;

public class CommonPasswordCheckerTest {
    CommonPasswordChecker commonPasswordChecker;

    @BeforeEach
    public void setUp() {
        commonPasswordChecker = new CommonPasswordChecker();
    }

    @ParameterizedTest
    @MethodSource("setCommonPasswordChecker")
    public void testValid(String password) {
        commonPasswordChecker.checkCommonPassword(password);
    }


    public static Set<Arguments> setCommonPasswordChecker() {
         return Set.of(
                 Arguments.of("1234567"),
                 Arguments.of("qwerty"),
                 Arguments.of("abcdef"),
                 Arguments.of("putinhuilo")
         );
    }
}