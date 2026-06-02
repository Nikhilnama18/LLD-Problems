package org.nikhil.entities;

public class Snake extends SpecailMover{
    private Integer id;
    private Integer stratPos;
    private Integer endPos;

    private static Integer autoId = 1;

    public Snake(Integer startPos, Integer endPos){
        this.id = autoId;
        this.stratPos = startPos;
        this.endPos = endPos;
        autoId++;
    }

    public Integer getStratPos() {
        return stratPos;
    }

    @Override
    public Integer getMoveResult() {
        return getEndPos() - getStratPos();
    }

    public Integer getEndPos() {
        return endPos;
    }
}
