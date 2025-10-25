package racingcar.domain;

public class RacingCar {

    private String name;
    private int position;


    public int getPosition() {
        return position;
    }

    public RacingCar(String name) {
        this.name = name;
        this.position = 0;
    }

    public void moveForward() {
        position++;
    }
}
