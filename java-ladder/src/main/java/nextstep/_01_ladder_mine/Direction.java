package nextstep._01_ladder_mine;

import java.util.Random;

public enum Direction {
    RIGHT, LEFT, DOWN;

    private final static Random random = new Random();
    public static Direction rightOrDown() {
        Direction[] directions = {RIGHT, DOWN};
        return directions[random.nextInt(directions.length)];
    }

    public boolean isLeft() {
        return this == LEFT;
    }
    public boolean isRight() {
        return this == RIGHT;
    }
}
