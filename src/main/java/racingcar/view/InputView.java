package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.validator.InputValidator;

public class InputView {

    private static final String CAR_NAMES_GUIDE_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ATTEMPT_COUNT_GUIDE_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String DELIMITER = ",";

    private InputView() {
    }

    public static List<String> getCarNames() {
        System.out.println(CAR_NAMES_GUIDE_MESSAGE);
        String input = Console.readLine();

        List<String> carNames = Arrays.stream(input.split(DELIMITER))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .toList();

        InputValidator.validateCarNames(carNames);

        return carNames;
    }

    public static int getAttemptCount() {
        System.out.println(ATTEMPT_COUNT_GUIDE_MESSAGE);
        String input = Console.readLine();

        InputValidator.validateNumericInput(input);
        return Integer.parseInt(input);
    }
}
