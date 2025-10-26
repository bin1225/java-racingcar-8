package racingcar.validator;


import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @Test
    void 유효한_자동차_이름_목록이면_예외가_발생하지_않는다() {
        //given
        List<String> carNames = List.of("car1", "car2", "car3");

        //when & then
        Assertions.assertThatCode(() -> InputValidator.validateCarNames(carNames))
                .doesNotThrowAnyException();
    }

    @Test
    void 자동차_이름_목록이_비어있으면_예외를_발생시킨다() {
        //given
        List<String> carNames = new ArrayList<>();

        //when & then
        assertExceptionMessageContains(carNames, "한대 이상");
    }

    @Test
    void 중복된_자동차_이름이_존재하면_예외를_발생시킨다() {
        //given
        List<String> carNames = List.of("car", "car");

        //when & then
        assertExceptionMessageContains(carNames, "중복");
    }

    @Test
    void 자동차_이름이_5자를_초과하면_예외를_발생시킨다() {
        //given
        List<String> carNames = List.of("ABCDEF");

        //when & then
        assertExceptionMessageContains(carNames, "5자 이하");
    }

    @Test
    void 시도횟수가_숫자가_아닌_경우_예외를_발생시킨다() {
        //given
        String input = "ㅁ";

        //when & then
        Assertions.assertThatThrownBy(() -> InputValidator.validateAttemptCount(input))
                .hasMessageContaining("숫자");
    }

    @Test
    void 시도횟수가_음수인_경우_예외를_발생시킨다() {
        //given
        String input = "-1";

        //when & then
        Assertions.assertThatThrownBy(() -> InputValidator.validateAttemptCount(input))
                .hasMessageContaining("음수");
    }

    private static void assertExceptionMessageContains(List<String> carNames, String expectedMessagePart) {
        Assertions.assertThatThrownBy(() -> InputValidator.validateCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedMessagePart);
    }
}