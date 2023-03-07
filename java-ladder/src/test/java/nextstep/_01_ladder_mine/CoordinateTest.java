package nextstep._01_ladder_mine;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CoordinateTest {


    @Test
    void first(){
        Coordinate coordinate = Coordinate.withX(0);
        assertThat(coordinate.isXZero()).isTrue();
    }

    @Test
    void move(){
        Coordinate coordinate = Coordinate.withX(1);
        coordinate.moveLeft();
        coordinate.moveDown();

        assertThat(coordinate).isEqualTo(new Coordinate(0, 1));
    }

    @Test
    void moveException(){
        Coordinate coordinate = Coordinate.withX(0);
        assertThatThrownBy(() -> {
            coordinate.moveLeft();
        }).isInstanceOf(IllegalArgumentException.class)
        .hasMessage("x값이 1보다 작을 경우 왼쪽으로 이동할 수 없습니다.");
    }



}
