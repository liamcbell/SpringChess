package com.liambell.springchess.Model.Enitites.Pieces;

import com.liambell.springchess.Model.Enitites.Piece;

public class Knight extends Piece {
    String allegiance;
    String pieceName = "k";


    public String getAllegiance() {
        return this.allegiance;
    };

    public String getPieceName() {
        return this.pieceName;
    };


    @Override
    public boolean isValidMove(Piece[][] board, Piece pieceBeingMoved, int[] startPosition, int[] newPosition) {
        boolean isValid = false;

        if ((Math.abs(newPosition[1] - startPosition[1]) == 1 && Math.abs(newPosition[0] - startPosition[0]) == 2) ||
                (Math.abs(newPosition[1] - startPosition[1]) == 2 && Math.abs(newPosition[0] - startPosition[0]) == 1) && board[newPosition[0]][newPosition[1]].getAllegiance() != this.allegiance) {

            isValid = board[newPosition[0]][newPosition[1]].getAllegiance() != this.allegiance ? true : false;
        }

        return isValid;
    }

    public Knight(String allegiance) {
        this.allegiance = allegiance;
    }
}
