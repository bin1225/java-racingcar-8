package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarMoverTest {

    private static final int THRESHOLD = 4;
    private static final int GO = 4;
    private static final int STOP = 3;

    CarMover carMover = new CarMover();

    @Test
    void 랜덤값이_임계값_이상이면_전진한다() {
        //given
        RacingCar racingCar = new RacingCar("car");

        //when & then
        assertRandomNumberInRangeTest(
                () -> {
                    carMover.moveIfOverThreshold(racingCar, THRESHOLD);
                    Assertions.assertThat(racingCar.getPosition()).isEqualTo(1);
                },
                GO
        );
    }

    @Test
    void 랜덤값이_임계값_미만이면_이동하지_않는다() {
        //given
        RacingCar racingCar = new RacingCar("car");

        //when & then
        assertRandomNumberInRangeTest(
                () -> {
                    carMover.moveIfOverThreshold(racingCar, THRESHOLD);
                    Assertions.assertThat(racingCar.getPosition()).isEqualTo(0);
                },
                STOP
        );
    }
}