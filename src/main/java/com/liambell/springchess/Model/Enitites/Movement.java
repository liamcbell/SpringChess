package com.liambell.springchess.Model.Enitites;

public interface Movement {

    public void setMoveRule();

    public boolean isValidMove(Piece[][] board, Piece pieceBeingMoved,
                               int[] startPosition, int[] newPosition);



}
