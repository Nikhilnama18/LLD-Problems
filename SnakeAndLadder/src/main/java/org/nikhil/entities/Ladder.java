package org.nikhil.entities;

public class Ladder extends SpecailMover{
    private Integer id;
    private Integer stratPos;
    private Integer endPos;

    private static Integer autoId = 1;

    public Ladder(Integer startPos, Integer endPos){
        this.id = autoId;
        this.stratPos = startPos;
        this.endPos = endPos;
        autoId++;
    }

    public Integer getStratPos() {
        return stratPos;
    }

    public Integer getEndPos() {
        return endPos;
    }

    @Override
    public Integer getMoveResult() {
        return getEndPos() - getStratPos();
    }
}
