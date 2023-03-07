package nextstep._01_ladder_mine;

import java.util.ArrayList;
import java.util.List;

public class DefaultPointMoveStrategy implements PointMoveStrategy {

    private final int directionCount;

    public DefaultPointMoveStrategy(int directionCount) {
        this.directionCount = directionCount;
    }

    @Override
    public List<Direction> create() {

        List<Direction> results = new ArrayList<>();
        Direction beforeDirection = null;

        for(int i = 0 ; i < directionCount ; i++){
            Direction direction = decide(i, beforeDirection);
            beforeDirection = direction;
            results.add(direction);
        }

        return results;
    }

    private Direction decide(int currentIdx, Direction beforeDirection) {

        if(beforeDirection == null){
            return Direction.rightOrDown();
        }

        if(beforeDirection.isRight()){
            return Direction.LEFT;
        }

        if(isLastIndex(currentIdx)){
            return Direction.DOWN;
        }

        return Direction.rightOrDown();
    }

    private boolean isLastIndex(int currentIdx) {
        return currentIdx == this.directionCount - 1;
    }

}









