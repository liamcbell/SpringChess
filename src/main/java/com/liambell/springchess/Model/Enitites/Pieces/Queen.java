package com.liambell.springchess.Model.Enitites.Pieces;

import com.liambell.springchess.Model.Enitites.Piece;

public class Queen implements Piece {

    String allegiance;
    String pieceName = "Q";
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

    public Queen(String allegiance) {
        this.allegiance = allegiance;
    }

    @Override
    public void setMoveRule() {

    }

    @Override
    public boolean getMoveRule(Piece[][] board, Piece pieceBeingMoved, int[] startPosition, int[] newPosition) {
        return false;
    }
}
