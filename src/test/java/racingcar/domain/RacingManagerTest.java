package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class RacingManagerTest {

    private RacingManager racingManager = new RacingManager();

    @Test
    void 참가자_이름을_전달하면_자동차를_등록하고_반환한다() {
        //given
        List<String> carNames = List.of("car1", "car2", "car3");

        //when
        List<RacingCar> registeredCars = racingManager.registerCars(carNames);

        //then
        assertThat(registeredCars)
                .hasSize(3)
                .extracting(RacingCar::getName)
                .containsExactlyInAnyOrder("car1", "car2", "car3");
    }

    @Test
    void 등록된_자동차의_초기_위치는_0_이다() {
        //given
        List<String> carNames = List.of("car1", "car2");

        //when
        List<RacingCar> registeredCars = racingManager.registerCars(carNames);

        //then
        assertThat(registeredCars)
                .extracting(RacingCar::getPosition)
                .containsOnly(0);
    }
}