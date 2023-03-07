package nextstep._01_ladder_mine;

public class LadderMain {

    public static void main(String[] args) {
        Ladder ladder = new Ladder("one,two,three,four,five,six,seven,eight,nine,ten", 10);
        DefaultPointMoveStrategy defaultPointMoveStrategy = new DefaultPointMoveStrategy(ladder.getPointsSize());
        ladder.printNames();
        ladder.movePointsAndDrawLadder(defaultPointMoveStrategy);
        ladder.printNames();

    }
}
