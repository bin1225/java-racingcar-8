package racingcar.domain;

import java.util.List;

public class WinnerDeterminer {

    public List<RacingCar> getWinners(List<RacingCar> participants) {
        int maxPosition = getMaxPosition(participants);

        return participants.stream()
                .filter(p->p.getPosition() == maxPosition)
                .toList();
    }

    private int getMaxPosition(List<RacingCar> participants) {
        return participants.stream()
                .mapToInt(RacingCar::getPosition)
                .max()
                .orElse(0);
    }
}
