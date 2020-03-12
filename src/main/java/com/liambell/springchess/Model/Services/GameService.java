package com.liambell.springchess.Model.Services;

import com.liambell.springchess.Model.Enitites.Board;
import com.liambell.springchess.Model.Enitites.Piece;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

@Service
public class GameService {

    @Autowired
    Board board;

    public Piece[][] loadInitialGameState() {
        return board.loadDefaultChessConfiguration();
    }

    public Piece[][] movePiece(int[] startPos, int[] newPos) {
        return board.movePieceToNewPosition(startPos, newPos);

    }

    public boolean isInCheck(Piece[][] board, String currentPieceAllegiance) {


        //How to check for check?
        /*

            do any pieces from the opposing allegiance have a direct path to the king based on their rules?
         */
        int[] kingLocation = new int[2];
        String whiteAllegiance = "White";
        boolean isKingInCheck = false;
        //Get location of White King
        //Refactor later to pass in current player allegiance
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                String kingAllegiance = currentPieceAllegiance;
                if (board[i][j].getPieceName() == "K" && board[i][j].getAllegiance() == kingAllegiance) {
                    kingLocation[0] = i;
                    kingLocation[1] = j;
                    i = board.length;
                    j = board.length;
                    break;
                }
            }
        }

        outerscope:
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j].getAllegiance() != currentPieceAllegiance && board[i][j].getPieceName() != " ") {

                    //Check all movements that are possible for a piece. If any of those movements force the piece onto the current king, then validate to true;
                    Piece currentPiece = board[i][j];
                    int[] currentPiecePosition = new int[2];
                    currentPiecePosition[0] = i;
                    currentPiecePosition[1] = j;
                    if (currentPiece.isValidMove(board, currentPiece, currentPiecePosition, kingLocation)) {
                        isKingInCheck = true;
                    }

                }
            }
        }

        return isKingInCheck;
    }

    public ArrayList<int[]> getCoordinatesForPieceMovementAction() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Y Axis Start Position: ");
        String startPositionY =   reader.readLine();
        System.out.println("Enter X Axis Start Position: ");
        String startPositionX =   reader.readLine();
        System.out.println("Enter Y Axis End Position: ");
        String newPositionY =   reader.readLine();
        System.out.println("Enter X Axis End Position: ");
        String newPositionX =   reader.readLine();
        int[] startPositions = new int[2];
        int[] newPositions = new int[2];
        startPositions[0] = Integer.parseInt(startPositionY);
        startPositions[1] = Integer.parseInt(startPositionX);
        newPositions[0] = Integer.parseInt(newPositionY);
        newPositions[1] = Integer.parseInt(newPositionX);

        ArrayList<int[]> movement = new ArrayList();
        movement.add(startPositions);
        movement.add(newPositions);

        return movement;
    }


}
