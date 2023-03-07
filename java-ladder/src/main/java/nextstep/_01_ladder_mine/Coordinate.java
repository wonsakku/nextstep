package nextstep._01_ladder_mine;

import java.util.Objects;

public class Coordinate {


    private int x;
    private int y;

    public static Coordinate withX(int x) {
        return new Coordinate(x, 0);
    }

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public boolean isXZero() {
        return this.x == 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public void moveLeft() {
        if (this.x < 1) {
            throw new IllegalArgumentException("x값이 1보다 작을 경우 왼쪽으로 이동할 수 없습니다.");
        }
        this.x -= 1;
    }

    public void moveRight() {
        this.x += 1;
    }

    public void moveDown() {
        this.y += 1;
    }


    public int getX() {
        return this.x;
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
