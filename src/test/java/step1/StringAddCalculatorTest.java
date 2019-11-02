package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StringAddCalculatorTest {
    StringAddCalculator stringAddCalculator = new StringAddCalculator("");

    @DisplayName("stringAddCalculator 생성 테스트")
    @Test
    void stringAddCalculatorTest() {

    }

    @DisplayName("null, empty 확인")
    @ParameterizedTest
    @NullAndEmptySource
    void isBlankTest(String nullAndEmpty) {
        assertThat(stringAddCalculator.isBlank(nullAndEmpty)).isTrue();
    }

    @DisplayName("한자리 숫자인지 검사")
    @Test
    void isOneLengthNumberTest() {
        assertThat(stringAddCalculator.isOneLengthNumber("1")).isTrue();
    }

    @DisplayName("음수이면 Exception 발생")
    @Test
    void isNegativeTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            stringAddCalculator.isNegative(-1);
        });
    }

    @DisplayName("더하기")
    @Test
    void plusTest() {
        String[] operands = {"1", "1", "8"};
        assertThat(stringAddCalculator.plus(operands)).isEqualTo(10);
    }
}
