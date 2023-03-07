package nextstep._01_ladder_mine;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Points {

    private final List<Point> points;

    public Points(String names) {
        String[] splitNames = names.split(",");
        this.points = IntStream.range(0, splitNames.length)
                .mapToObj(idx -> new Point(splitNames[idx], idx))
                .collect(Collectors.toList());
    }


    public int size() {
        return this.points.size();
    }

    public Coordinate nthPointPosition(int idx) {
        return this.points.get(idx).currentPosition();
    }

    public String nthPointName(int idx){
        return this.points.get(idx).getName();
    }

    public void move(List<Direction> moveDirections) {

        validateMoveDirectionSize(moveDirections);

        int forLoopCount = this.points.size();

        for (int i = 0; i < forLoopCount; i++) {
            this.points.get(i).move(moveDirections.get(i));
        }

        sequenceRearrange();
    }

    private void validateMoveDirectionSize(List<Direction> moveDirections) {
        if (this.points.size() != moveDirections.size()) {
            throw new IllegalArgumentException("이동 방식의 길이가 points의 길이와 맞지 않습니다.");
        }
    }

    public Coordinate findCoordinateByName(String name) {
        return this.points.stream()
                .filter(point -> point.isSameName(name))
                .map(Point::currentPosition)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("일치하는 이름이 없습니다."))
                ;
    }

    public void sequenceRearrange(){
        Collections.sort(this.points, Comparator.comparing(Point::getX));
    }
}


