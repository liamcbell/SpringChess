package com.liambell.springchess.Model.Enitites;

import org.springframework.stereotype.Component;

public interface Piece extends Movement {

    //Hashing out the Piece properties as a whole before narrowing down on a piece by piece basis.
    /* Commonalities:
        All pieces have positions
        All pieces have an Allegiance
        All pieces have a relational position to neighboring pieces.
        All pieces have the ability to move
    */

    public int[][] getPiecePosition();

    public void setPiecePosition(int[][] piecePosition);


    //Will be utilized for AI movement and player move limiters.
    public int [][][] getPieceMovementRules();

    //If I decide to allow the creation of new pieces or rules for existing pieces.
    public int [][][] setPieceMovementRules();
    public String getAllegiance();

    public String getPieceName();



}
