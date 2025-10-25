package racingcar;

import java.util.List;
import racingcar.domain.CarMover;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingManager;
import racingcar.domain.WinnerDeterminer;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

    private static final int MOVE_THRESHOLD = 4;

    private static final RacingManager racingManager = new RacingManager();
    private static final CarMover carMover = new CarMover();
    private static final WinnerDeterminer winnerDeterminer = new WinnerDeterminer();

    public static void main(String[] args) {
        List<String> carNames = InputView.getCarNames();
        int attemptCount = InputView.getAttemptCount();

        List<RacingCar> participants = racingManager.registerCars(carNames);

        OutputView.printResultMessage();
        while (attemptCount-- > 0) {
            for (RacingCar r : participants) {
                carMover.moveIfOverThreshold(r, MOVE_THRESHOLD);
            }
            OutputView.printCurrentProgress(participants);
        }

        List<RacingCar> winners = winnerDeterminer.getWinners(participants);
        OutputView.printWinner(winners);
    }
}
