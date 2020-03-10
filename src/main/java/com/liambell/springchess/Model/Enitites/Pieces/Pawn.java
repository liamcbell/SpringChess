package com.liambell.springchess.Model.Enitites.Pieces;

import com.liambell.springchess.Model.Enitites.Movement;
import com.liambell.springchess.Model.Enitites.Piece;

public class Pawn implements Piece {

    private final String pieceName = "P";
    String allegiance;
    private int[][] movementRule = new int[1][1];



    @Override
    public int[][] getPiecePosition() {
        return new int[0][];
    }

    @Override
    public void setPiecePosition(int[][] piecePosition) {

    }

    @Override
    public int[][][] getPieceMovementRules() {
        return new int[0][][];
    }

    @Override
    public int[][][] setPieceMovementRules() {
        return new int[0][][];
    }

    @Override
    public String getAllegiance() {
        return this.allegiance;
    }

    @Override
    public String getPieceName() {
        return this.pieceName;
    }

    public Pawn(String allegiance) {
        this.allegiance = allegiance;
    }

    @Override
    public void setMoveRule() {

    }

    @Override
    public boolean getMoveRule(Piece[][] board, Piece pieceBeingMoved, int[] startPosition, int[] newPosition) {
        boolean isValid = false;
        String allegiance = board[newPosition[0]][newPosition[1]].getAllegiance();
        movementRule[0][0] = 1;

        //Accounts for initial movement of two spaces
        //Movement of once forward space if it is empty
        //Moving diagonal in either direction if there is an enemy.
        if (board[newPosition[0]][newPosition[1]].getAllegiance() != this.allegiance) {
            if (startPosition[1] == 1 && newPosition[1] == 3 && board[startPosition[0]][2].getPieceName() == " ") {
                isValid = true;
            } else if (newPosition[1] - startPosition[1] == movementRule[0][0] &&
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

    public boolean getMoveRule(Piece[][] board, Piece pieceBeingMoved, int[][] startPosition, int[][] newPosition) {
        boolean isValid = false;
        if (newPosition[0][0] - startPosition[0][0] == movementRule[0][1] &&
            board[newPosition[0][0]][newPosition[0][1]].getPieceName() == "E"
        ) {
            isValid = true;
        }
        return isValid;
    }


}
