package com.liambell.springchess.Model.Enitites.Pieces;

import com.liambell.springchess.Model.Enitites.Piece;

public class Rook implements Piece {

    String allegiance;
    String pieceName = "R";
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

    public Rook(String allegiance) {
        this.allegiance = allegiance;
    }

    @Override
    public void setMoveRule() {

    }

    @Override
    public boolean getMoveRule(Piece[][] board, Piece pieceBeingMoved, int[] startPosition, int[] newPosition) {
        boolean isValid = true;

        if ((Math.abs(startPosition[0] - newPosition[0]) == 0 && Math.abs(startPosition[1] - newPosition[1]) == 1) ||
                (Math.abs(startPosition[0] - newPosition[0]) == 1 && Math.abs(startPosition[1] - newPosition[1]) == 0) && board[newPosition[0]][newPosition[1]].getAllegiance() != this.allegiance) {
            for (int i = startPosition[0] + 1; i < newPosition[0]; i++) {
                for (int j = startPosition[1] + 1; j < newPosition[1]; j++) {
                    if (board[i][j].getPieceName() != " ") {
                        isValid = false;
                    }
                }
            }

        }

        return isValid;
    }
}