import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
public class CommonPasswordCheckerTest {
    CommonPasswordChecker commonPasswordChecker;

    @BeforeEach
    public void setUp() {
        System.out.println("hello");
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