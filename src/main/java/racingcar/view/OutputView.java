package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.RacingCar;

public class OutputView {

    private static final String POSITION_BAR = "-";
    private static final String RESULT_MESSAGE = "실행결과";

    public static void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printCurrentProgress(List<RacingCar> racingCars) {
        String currentProgress = racingCars.stream()
                .map(car -> car.getName() + ":" + toPositionBar(car.getPosition()))
                .collect(Collectors.joining("\n"));

        System.out.println(currentProgress);
    }

    private static String toPositionBar(int position) {
        return POSITION_BAR.repeat(position);
    }
}