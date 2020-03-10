package com.liambell.springchess.Model.Enitites.Pieces;

import com.liambell.springchess.Model.Enitites.Piece;

public class Knight implements Piece {
    String allegiance;
    String pieceName = "k";
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
        return null;
    }

    @Override
    public String getPieceName() {
        return this.pieceName;
    }

    public Knight(String allegiance) {
        this.allegiance = allegiance;
    }

    @Override
    public void setMoveRule() {

    }

    @Override
    public boolean getMoveRule(Piece[][] board, Piece pieceBeingMoved, int[] startPosition, int[] newPosition) {
        boolean isValid = false;

        if ((Math.abs(newPosition[1] - startPosition[1]) == 1 && Math.abs(newPosition[0] - startPosition[0]) == 2) ||
                (Math.abs(newPosition[1] - startPosition[1]) == 2 && Math.abs(newPosition[0] - startPosition[0]) == 1) && board[newPosition[0]][newPosition[1]].getAllegiance() != this.allegiance) {

            isValid = board[newPosition[0]][newPosition[1]].getAllegiance() != this.allegiance ? true : false;
        }

        return isValid;
    }
}
