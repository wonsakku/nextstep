package nextstep._01_ladder_mine;

public class Point {
    public static final int MIN_NAME_LENGTH = 1;
    public static final int MAX_NAME_LENGTH = 5;
    private final String name;
    private final Coordinate coordinate;

    public Point(String name, int coordinateX) {
        this(name, Coordinate.withX(coordinateX));
    }

    public Point(String name, Coordinate coordinate) {
        validateNameLength(name);
        this.name = name;
        this.coordinate = coordinate;
    }


    private void validateNameLength(String name) {
        if (name == null || name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름의 길이는 1~5자입니다.");
        }
    }

    public void move(Direction moveDirection) {
        if (moveDirection.isLeft()) {
            this.coordinate.moveLeft();
        }
        if (moveDirection.isRight()) {
            this.coordinate.moveRight();
        }
        this.coordinate.moveDown();
    }

    public Coordinate currentPosition() {
        return this.coordinate;
    }

    public boolean isSameName(String name) {
        return this.name.equals(name);
    }

    public int getX(){
        return this.coordinate.getX();
    }

    public String getName() {
        return this.name;
    }
}
