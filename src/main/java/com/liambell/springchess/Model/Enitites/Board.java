package com.liambell.springchess.Model.Enitites;

import com.liambell.springchess.Model.Enitites.Pieces.*;
import com.liambell.springchess.Model.Services.GameService;
import org.springframework.stereotype.Component;

@Component
public class Board {

    private Piece[][] boardArray = new Piece[8][8];


    public Board(int boardArraySizeOnInit) {
        this.boardArray = new Piece [8][8];
    }

    //Load Config will only occur once throughout an entire game.
    public Piece[][] loadDefaultChessConfiguration() {
        //All White Pieces
        this.boardArray[0][0] = new Rook("White");
        this.boardArray[7][0] = new Rook("White");
        this.boardArray[1][0] = new Bishop("White");
        this.boardArray[6][0] = new Bishop("White");
        this.boardArray[2][0] = new Knight("White");
        this.boardArray[5][0] = new Knight("White");
        this.boardArray[3][0] = new Queen("White");
        this.boardArray[4][0] = new King("White");
        this.boardArray[0][1] = new Pawn("White");
        this.boardArray[1][1] = new Pawn("White");
        this.boardArray[2][1] = new Pawn("White");
        this.boardArray[3][1] = new Pawn("White");
        this.boardArray[4][1] = new EmptyPiece();
        this.boardArray[5][1] = new Pawn("White");
        this.boardArray[6][1] = new Pawn("White");
        this.boardArray[7][1] = new Pawn("White");

        //All Black Pieces
        this.boardArray[0][7] = new Rook("Black");
        this.boardArray[7][7] = new Rook("Black");
        this.boardArray[1][7] = new Bishop("Black");
        this.boardArray[6][7] = new Bishop("Black");
        this.boardArray[2][7] = new Knight("Black");
        this.boardArray[5][7] = new Knight("Black");
        this.boardArray[4][7] = new Queen("Black");
        this.boardArray[3][7] = new King("Black");
        this.boardArray[0][6] = new Pawn("Black");
        this.boardArray[1][6] = new Pawn("Black");
        this.boardArray[2][6] = new Pawn("Black");
        this.boardArray[3][6] = new Pawn("Black");
        this.boardArray[4][6] = new Rook("Black");
        this.boardArray[5][6] = new Pawn("Black");
        this.boardArray[6][6] = new Pawn("Black");
        this.boardArray[7][6] = new Pawn("Black");

        //Empty Spaces. I do not want to use null, so I will use an "Empty" Piece Object
        for (int i = 0; i < 8; i++) {
            for (int j = 2; j < 6; j++) {
                this.boardArray[i][j] = new EmptyPiece();
            }
        }

        return this.boardArray;
    }

    public Piece[][] resizeBoard(int x, int y) {
        Piece[][] resizedBoard = new Piece[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (i * j < this.boardArray.length) {
                    resizedBoard[i][j] = this.boardArray[i][j];
                }
            }
        }
        this.boardArray = resizedBoard;
        return this.boardArray;
    }

    public Piece[][] movePieceToNewPosition(int[] startPosition, int[] newPosition) {
        //validateMove
        Piece piece = this.boardArray[startPosition[0]][startPosition[1]];
        String opposingAllegiance = piece.getAllegiance() == "White" ? "Black" : "White";
        GameService gameService = new GameService();
        if (piece.isValidMove(this.boardArray,
                this.boardArray[startPosition[0]][startPosition[1]],
                startPosition, newPosition)){
            Piece[][] temporaryBoardToAnalyzeCheck = cloneArray();
            temporaryBoardToAnalyzeCheck[startPosition[0]][startPosition[1]] = new EmptyPiece();
            temporaryBoardToAnalyzeCheck[newPosition[0]][newPosition[1]] = piece;
            if (!gameService.isInCheck(temporaryBoardToAnalyzeCheck, piece.getAllegiance())) {
                this.boardArray[startPosition[0]][startPosition[1]] = new EmptyPiece();
                this.boardArray[newPosition[0]][newPosition[1]] = piece;
            } else {
                System.out.println("You are in check. You must make a move to get out of check.");
            }
        } else {
            System.out.println("Hey, you can't do that.");
        }


        System.out.println(gameService.isInCheck(this.boardArray,opposingAllegiance));

        return this.boardArray;
    }

    public Board() {

    }

    public Piece[][] cloneArray() {
        Piece[][] tempBoard = new Piece[this.boardArray.length][this.boardArray.length];
        for (int i = 0; i < this.boardArray.length; i++) {
            for (int j = 0; j < this.boardArray.length; j++) {
                tempBoard[i][j] = this.boardArray[i][j];
            }
        }
        return tempBoard;
    }
}
