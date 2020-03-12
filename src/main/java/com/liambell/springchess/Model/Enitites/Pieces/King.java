package com.liambell.springchess.Model.Enitites.Pieces;

import com.liambell.springchess.Model.Enitites.Piece;

public class King extends Piece {
    String allegiance;
    String pieceName = "K";


    public String getAllegiance() {
        return this.allegiance;
    };

    public String getPieceName() {
        return this.pieceName;
    };

    @Override
    public boolean isValidMove(Piece[][] board, Piece pieceBeingMoved, int[] startPosition, int[] newPosition) {
        boolean isValid = false;
        if ((Math.abs(startPosition[0] - newPosition[0]) == 1 ||
                Math.abs(startPosition[0] - newPosition[0]) == 0 ) &&
                (Math.abs(startPosition[1] - newPosition[1]) == 1 ||
                        Math.abs(startPosition[1] - newPosition[1]) == 0 ) &&
                board[newPosition[0]][newPosition[1]].getAllegiance() != this.allegiance) {
            isValid = true;
        }
        return isValid;
    }

    public King(String allegiance) {
        this.allegiance = allegiance;
    }
}
