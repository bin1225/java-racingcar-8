package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingManager {

    private final List<RacingCar> participants = new ArrayList<>();

    public List<RacingCar> registerCars(List<String> carNames) {
        carNames.forEach(name -> participants.add(new RacingCar(name)));
        return List.copyOf(participants);
    }
}
