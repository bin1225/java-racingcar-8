package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class CarMover {

    private static final int NUMBER_START = 0;
    private static final int NUMBER_END = 9;

    public void moveIfOverThreshold(RacingCar car, int threshold) {
        int pickNumber = Randoms.pickNumberInRange(NUMBER_START,NUMBER_END);
        if (pickNumber >= threshold) {
            car.moveForward();
        }
    }
}
