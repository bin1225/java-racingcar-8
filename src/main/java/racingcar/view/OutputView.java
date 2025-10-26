package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.RacingCar;

public class OutputView {

    private static final String POSITION_BAR = "-";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자";

    private OutputView() {
    }

    public static void printResultMessage() {
        System.out.println("\n" + RESULT_MESSAGE);
    }

    public static void printCurrentProgress(List<RacingCar> racingCars) {
        String currentProgress = racingCars.stream()
                .map(car -> car.getName() + " : " + toPositionBar(car.getPosition()))
                .collect(Collectors.joining("\n"));

        System.out.println(currentProgress + "\n");
    }

    public static void printWinner(List<RacingCar> winners) {
        String winnerNames = winners.stream()
                .map(RacingCar::getName)
                .collect(Collectors.joining(", "));
        System.out.println(WINNER_MESSAGE + " : " + winnerNames);
    }

    private static String toPositionBar(int position) {
        return POSITION_BAR.repeat(position);
    }
}