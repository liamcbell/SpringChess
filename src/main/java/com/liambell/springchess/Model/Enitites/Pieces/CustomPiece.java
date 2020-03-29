package com.liambell.springchess.Model.Enitites.Pieces;

import com.liambell.springchess.Model.Enitites.Piece;

import java.util.HashMap;
import java.util.stream.IntStream;

public class CustomPiece extends Piece {
    private HashMap<Integer, Integer[][]> movementRules;
    private String pieceName;
    public HashMap<Integer, Integer[][]> getMovementRules() {
        return movementRules;
    }

    public void setMovementRules(HashMap<Integer, Integer[][]> movementRules) {
        this.movementRules = movementRules;
    }

    public boolean isValidMove(Integer[][] positions) {
        boolean isValid = false;
        loop:
        for (int i = 0; i < this.movementRules.size(); i++) {
            Integer[][] tempArr = movementRules.get(i);
            if (Math.abs((tempArr[0][0] - tempArr[0][1]) / (tempArr[1][0] - tempArr[1][1])) ==
                    Math.abs((positions[0][0] - positions[0][1]) / (positions[1][0] - positions[1][1]))) {
                isValid = true;
                break loop;
            }
        }
        return isValid;
    }

    public CustomPiece(HashMap<Integer, Integer[][]> movementRules, String pieceName) {
        this.movementRules = movementRules;
        this.pieceName = pieceName;
    }

    public CustomPiece () {

    }
}
