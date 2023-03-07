package nextstep._01_ladder_mine;

import java.util.List;

public class Ladder {

    private final String VERTICAL_LINE = "|";
    private final String HORIZON_LINE = "-----";
    private final String EMPTY_HORIZON_LINE = "     ";

    private final Points points;
    private final int lineCount;

    public Ladder(String names, int lineCount) {
        this.points = new Points(names);
        this.lineCount = lineCount;
    }

    public void printNames(){

        for(int i = 0 ; i < getPointsSize() ; i++){
            String name = this.points.nthPointName(i);
            int nameLength = name.length();
            String emptySpace = "";

            for(int j = 0 ; j < 6-nameLength ; j++){
                emptySpace += " ";
            }

            System.out.print(name + emptySpace);
        }
        System.out.println();
    }

    public int getPointsSize(){
        return this.points.size();
    }

    public void movePointsAndDrawLadder(PointMoveStrategy pointMoveStrategy){

        for(int i = 0 ; i < lineCount ; i++){
            List<Direction> directions = pointMoveStrategy.create();
            movePoints(directions);
            drawLadder(directions);
        }
    }

    private void movePoints(List<Direction> directions) {
        this.points.move(directions);
        this.points.sequenceRearrange();
    }

    private void drawLadder(List<Direction> directions) {

        for (Direction direction : directions) {

            System.out.print(VERTICAL_LINE);

            if(direction.isRight()){
                System.out.print(HORIZON_LINE);
                continue;
            }

            System.out.print(EMPTY_HORIZON_LINE);

        }
        System.out.println();
    }
}
