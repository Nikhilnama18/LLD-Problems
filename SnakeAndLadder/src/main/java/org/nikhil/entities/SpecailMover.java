package org.nikhil.entities;

public abstract class SpecailMover {
    private Integer id;
    private Integer stratPos;
    private Integer endPos;


    public Integer getStratPos() {
        return stratPos;
    }

    public Integer getEndPos() {
        return endPos;
    }

    public abstract Integer getMoveResult();
}
