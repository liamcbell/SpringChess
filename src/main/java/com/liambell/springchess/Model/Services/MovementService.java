package com.liambell.springchess.Model.Services;

import com.liambell.springchess.Model.Enitites.Piece;

public class MovementService {

    public boolean isPathClearToNewPosition(int basePositionY, int endPositionY, int basePositionX, int endPositionX, Piece[][] board, String direction, String allegiance) {

        boolean isClearPath = false;

        iterator:
            if (direction == "Vertical") {
                for (int i = basePositionY; i <= endPositionY; i++) {
                    if (board[i][basePositionX].getPieceName() != allegiance) {
                        isClearPath = true;
                    } else if (endPositionY - basePositionY != 1) {
                        break iterator;
                    }
                }
            } else if (direction == "Horizontal") {
                for (int i = basePositionX; i <= endPositionX; i++) {
                    if (board[basePositionY][i].getPieceName() != allegiance && i > 1 ) {
                        isClearPath = true;
                    } else if (endPositionX - basePositionX != 1) {
                        break iterator;
                    }
                }
            } else if (direction == "Diagonal") {
                for (int i = basePositionY; i <= endPositionY; i++) {
                    for (int j = basePositionX; j <= endPositionX; j++) {
                        if (board[i][j].getPieceName() != allegiance) {
                            isClearPath = true;
                        } else {
                            break iterator;
                        }
                    }
                }
            }
        return isClearPath;
    }

    public String determineMovementDirection(int[] startPosition, int[] newPosition) {
        String direction = "";

        if (Math.abs(startPosition[0] - newPosition[0]) != 0 && Math.abs(startPosition[1] - newPosition[1]) == 0) {
            direction = "Vertical";
        } else if (Math.abs(startPosition[1] - newPosition[1]) != 0 && Math.abs(startPosition[0] - newPosition[0]) == 0) {
            direction = "Horizontal";
        } else if (Math.abs(startPosition[0] - newPosition[0]) == Math.abs((startPosition[1] - newPosition[1]))) {
            direction = "Diagonal";
        }

        return direction;
    }

    public String determineRowAndColumnDirection(int startPosition, int newPosition) {
        return (newPosition -  startPosition >= 0) ? "Positive" : "Negative";
    }

    public int[] getAbsolutePositionCoords(int[] startPosition, int[] newPosition, String direction) {
        int basePositionY = 0;
        int basePositionX = 0;
        int endPositionY = 0;
        int endPositionX = 0;
        switch (direction) {

            case "Vertical":
                if (this.determineRowAndColumnDirection(startPosition[0], newPosition[0]) == "Positive") {
                    if (newPosition[0] - startPosition[0] > 1) {
                        basePositionY = startPosition[0] + 1;
                    } else {
                        basePositionY = startPosition[0];
                    }

                    endPositionY = newPosition[0];
                } else {
                    if (startPosition[0] - newPosition[0] > 1) {
                        basePositionY = newPosition[0] + 1;
                    } else {
                        basePositionY = newPosition[0];
                    }
                    endPositionY = startPosition[0];
                }
                basePositionX = startPosition[1];
                endPositionX = newPosition[1];
                break;
            case "Horizontal":
                if (this.determineRowAndColumnDirection(startPosition[1], newPosition[1]) == "Positive") {
                    if (newPosition[1] - startPosition[1] > 1) {
                        basePositionX = startPosition[1] + 1;
                    } else {
                        basePositionX = startPosition[1];
                    }
                    endPositionX = newPosition[1];
                } else {
                    if (startPosition[1] - newPosition[1] > 1) {
                        basePositionX = newPosition[1] + 1;
                    } else {
                        basePositionX = newPosition[1];
                    }
                    endPositionX = startPosition[1];
                }
                basePositionY = startPosition[0];
                endPositionY = newPosition[0];
                break;
            case "Diagonal":
                String movementDirectionY = this.determineRowAndColumnDirection(startPosition[0], newPosition[0]);
                String movementDirectionX = this.determineRowAndColumnDirection(startPosition[1], newPosition[1]);
                if (movementDirectionY == "Positive") {
                    basePositionY = startPosition[0] + 1;
                    endPositionY = newPosition[0];
                } else {
                    basePositionY = newPosition[0] + 1;
                    endPositionY = startPosition[0];
                }

                if (movementDirectionX == "Positive") {
                    basePositionX = startPosition[1] + 1;
                    endPositionX = newPosition[1];
                } else {
                    basePositionX = newPosition[1] + 1;
                    endPositionX = startPosition[1];
                }
                break;
        }
        int[] tempPositionHolder = new int[4];
        tempPositionHolder[0] = basePositionY;
        tempPositionHolder[1] = endPositionY;
        tempPositionHolder[2] = basePositionX;
        tempPositionHolder[3] = endPositionX;
        return tempPositionHolder;
    }
}
