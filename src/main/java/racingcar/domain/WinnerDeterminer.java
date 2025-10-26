package racingcar.domain;

import java.util.List;

public class WinnerDeterminer {

    public List<RacingCar> getWinners(List<RacingCar> participants) {
        int maxPosition = getMaxPositionFromCars(participants);

        return participants.stream()
                .filter(p->p.getPosition() == maxPosition)
                .toList();
    }

    private int getMaxPositionFromCars(List<RacingCar> participants) {
        return participants.stream()
                .mapToInt(RacingCar::getPosition)
                .max()
                .orElse(0);
    }
}
