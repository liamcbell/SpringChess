package com.liambell.springchess.Model.Enitites.Pieces;

import com.liambell.springchess.Model.Enitites.Movement;
import com.liambell.springchess.Model.Enitites.Piece;

public class Pawn extends Piece {

    private final String pieceName = "P";
    String allegiance;
    private int[][] movementRule = new int[1][1];


    public String getAllegiance() {
        return this.allegiance;
    };

    public String getPieceName() {
        return this.pieceName;
    };

    @Override
    public boolean isValidMove(Piece[][] board, Piece pieceBeingMoved, int[] startPosition, int[] newPosition) {
        boolean isValid = false;
        String allegiance = board[newPosition[0]][newPosition[1]].getAllegiance();
        movementRule[0][0] = 1;
        //Accounts for initial movement of two spaces
        //Movement of once forward space if it is empty
        //Moving diagonal in either direction if there is an enemy.
        if (board[newPosition[0]][newPosition[1]].getAllegiance() != pieceBeingMoved.getAllegiance()) {
            if ((startPosition[1] == 1 && newPosition[1] == 3) ||(startPosition[1] == 6 && newPosition[1] == 4) && board[startPosition[0]][2].getPieceName() == " ") {
                isValid = true;
            } else if (Math.abs(newPosition[1] - startPosition[1]) == movementRule[0][0] &&
                    board[newPosition[0]][newPosition[1]].getPieceName() == " "
                ) {
                    isValid = true;
            } else if (Math.abs(newPosition[1] - startPosition[1]) == 1) {
                if (board[newPosition[0]][newPosition[1]].getPieceName() != " " &&
                        !this.allegiance.equals(allegiance)) {
                    isValid = true;
                }
            }
        }
        return isValid;
    }
    public Pawn(String allegiance) {
        this.allegiance = allegiance;
    }

}
