package com.liambell.springchess.Model.Enitites;

import org.springframework.stereotype.Component;

public class Piece implements Movement {

    //Hashing out the Piece properties as a whole before narrowing down on a piece by piece basis.
    /* Commonalities:
        All pieces have positions
        All pieces have an Allegiance
        All pieces have a relational position to neighboring pieces.
        All pieces have the ability to move
    */

    private String allegiance;
    private String pieceName;


    public String getAllegiance() {
        return this.allegiance;
    };

    public String getPieceName() {
        return this.pieceName;
    };

    @Override
    public void setMoveRule() {

    }

    @Override
    public boolean isValidMove(Piece[][] board, Piece pieceBeingMoved, int[] startPosition, int[] newPosition) {
        return false;
    }

    public Piece() {

    }


}
