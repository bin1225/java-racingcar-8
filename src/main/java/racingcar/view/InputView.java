package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
                .peek(name -> {
                    if (name.length() > 5) {
                        throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다: " + name);
                    }
                })
                .filter(s -> !s.isEmpty())
                .toList();

        if (carNames.isEmpty()) {
            throw new IllegalArgumentException("자동차를 한대 이상 등록해야 합니다.");
        }

        if (checkDuplicateNameExist(carNames)) {
            throw new IllegalArgumentException("자동차 이름이 중복입니다");
        }

        return carNames;

    }

    public static int getAttemptCount() {
        System.out.println(ATTEMPT_COUNT_GUIDE_MESSAGE);
        String input = Console.readLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }

    private static boolean checkDuplicateNameExist(List<String> carNames) {
        Set<String> uniqueNames = new HashSet<>(carNames);
        return uniqueNames.size() != carNames.size();
    }
}
