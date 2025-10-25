package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;

public class CarMover {

    private final List<Integer> candidateNumbers = IntStream.rangeClosed(0, 9).boxed().toList();

    public void moveIfOverThreshold(RacingCar car, int threshold) {
        int pickNumber = Randoms.pickNumberInList(candidateNumbers);
        if (pickNumber >= threshold) {
            car.moveForward();
        }
    }
}
