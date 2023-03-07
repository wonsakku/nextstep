package nextstep._01_ladder_mine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PointsTest {

    Points points;

    @BeforeEach
    void init(){
        points = new Points("one,two,three");
    }

    @Test
    void pointsCurrentPositionTest(){
        for(int i = 0; i < points.size() ; i++){
            assertThat(points.nthPointPosition(i)).isEqualTo(new Coordinate(i, 0));
        }
    }

    @Test
    void pointsMoveTest(){

        // given
        List<Direction> moveDirections = List.of(Direction.DOWN, Direction.RIGHT, Direction.LEFT);

        // when
        points.move(moveDirections);

        //then
        assertThat(points.findCoordinateByName("one")).isEqualTo(new Coordinate(0, 1));
        assertThat(points.findCoordinateByName("two")).isEqualTo(new Coordinate(2, 1));
        assertThat(points.findCoordinateByName("three")).isEqualTo(new Coordinate(1, 1));
    }

    @ParameterizedTest
    @CsvSource(value = {"0", "1", "2"})
    void rearrangeTest(int idx){
        // given
        List<Direction> moveDirections = List.of(Direction.DOWN, Direction.RIGHT, Direction.LEFT);

        // when
        points.move(moveDirections);
        points.sequenceRearrange();

        assertThat(points.nthPointPosition(idx).getX()).isEqualTo(idx);
    }

    @Test
    void moveThreeTimeTest(){

        // given & when
        points.move(List.of(Direction.DOWN, Direction.RIGHT, Direction.LEFT));
        points.sequenceRearrange();
        points.move(List.of(Direction.RIGHT, Direction.LEFT, Direction.DOWN));
        points.sequenceRearrange();
        points.move(List.of(Direction.DOWN, Direction.RIGHT, Direction.LEFT));
        points.sequenceRearrange();


        // then
        assertThat(points.findCoordinateByName("one")).isEqualTo(new Coordinate(2, 3));
        assertThat(points.findCoordinateByName("two")).isEqualTo(new Coordinate(1, 3));
        assertThat(points.findCoordinateByName("three")).isEqualTo(new Coordinate(0, 3));
    }

}









