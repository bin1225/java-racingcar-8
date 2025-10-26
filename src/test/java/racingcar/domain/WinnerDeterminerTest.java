package racingcar.domain;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class WinnerDeterminerTest {

    WinnerDeterminer winnerDeterminer = new WinnerDeterminer();

    @Test
    void 가장_멀리_간_자동차를_우승자로_반환한다() {
        //given
        RacingCar racingCar1 = new RacingCar("car1");
        RacingCar racingCar2 = new RacingCar("car2");

        //when
        racingCar1.moveForward();
        List<RacingCar> winners = winnerDeterminer.getWinners(List.of(racingCar1, racingCar2));

        //then
        assertThat(winners).containsOnly(racingCar1);
    }

    @Test
    void 우승자가_여러명일_경우_모두_반환한다() {
        //given
        RacingCar racingCar1 = new RacingCar("car1");
        RacingCar racingCar2 = new RacingCar("car2");

        //when
        List<RacingCar> winners = winnerDeterminer.getWinners(List.of(racingCar1, racingCar2));

        //then
        assertThat(winners).hasSize(2)
                .extracting(RacingCar::getName)
                .containsExactlyInAnyOrder("car1", "car2");
    }

    @Test
    void 참가자가_없을_경우_빈_리스트를_반환한다() {
        // given
        List<RacingCar> participants = List.of();

        // when
        List<RacingCar> winners = winnerDeterminer.getWinners(participants);

        // then
        assertThat(winners).isEmpty();
    }
}