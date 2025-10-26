package racingcar.validator;

import java.util.HashSet;
import java.util.List;

public class InputValidator {

    public static void validateCarNames(List<String> names) {
        if (names.isEmpty()) {
            throw new IllegalArgumentException("자동차를 한대 이상 등록해야 합니다.");
        }
        if (hasDuplicate(names)) {
            throw new IllegalArgumentException("자동차 이름이 중복입니다.");
        }
        names.forEach(name -> {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        });
    }

    public static void validateAttemptCount(String input) {
        try {
            int attemptCount = Integer.parseInt(input);
            if (attemptCount < 0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }

    private static boolean hasDuplicate(List<String> names) {
        return names.size() != new HashSet<>(names).size();
    }
}