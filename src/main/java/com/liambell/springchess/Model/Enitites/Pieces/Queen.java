package com.liambell.springchess.Model.Enitites.Pieces;

import com.liambell.springchess.Model.Enitites.Piece;
import com.liambell.springchess.Model.Services.MovementService;

public class Queen extends Piece {

    String allegiance;
    String pieceName = "Q";


    public String getAllegiance() {
        return this.allegiance;
    };

    public String getPieceName() {
        return this.pieceName;
    };

    @Override
    public boolean isValidMove(Piece[][] board, Piece pieceBeingMoved, int[] startPosition, int[] newPosition) {
        boolean isValid = false;
        MovementService movementService = new MovementService();
        String direction = movementService.determineMovementDirection(startPosition, newPosition);
        if ((direction == "Vertical" || direction == "Horizontal" || direction == "Diagonal") &&
                        board[newPosition[0]][newPosition[1]].getAllegiance() != pieceBeingMoved.getAllegiance()) {
            int[] temporaryPositionArray = movementService.getAbsolutePositionCoords(startPosition, newPosition, direction);
            isValid = movementService.isPathClearToNewPosition(temporaryPositionArray[0], temporaryPositionArray[1],
                    temporaryPositionArray[2], temporaryPositionArray[3], board, direction, pieceBeingMoved.getAllegiance());
        }
        return isValid;
    }



    public Queen(String allegiance) {
        this.allegiance = allegiance;
    }


}
