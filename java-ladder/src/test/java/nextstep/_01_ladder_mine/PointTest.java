package nextstep._01_ladder_mine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class PointTest {

    Point point;

    @BeforeEach
    void init(){
        point = new Point("kim", new Coordinate(0, 0));
    }

    @Test
    void moveTest(){
        point = new Point("kim", new Coordinate(0, 0));
        point.move(Direction.RIGHT);
        assertThat(point.currentPosition()).isEqualTo(new Coordinate(1, 1));
    }

    @Test
    void moveException(){
        assertThatThrownBy(() -> {
            point.move(Direction.LEFT);
        }).isInstanceOf(IllegalArgumentException.class)
        .hasMessage("x값이 1보다 작을 경우 왼쪽으로 이동할 수 없습니다.")
        ;
    }
}
