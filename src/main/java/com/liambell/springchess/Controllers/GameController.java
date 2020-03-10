package com.liambell.springchess.Controllers;

import com.liambell.springchess.Model.Enitites.Board;
import com.liambell.springchess.Model.Enitites.Piece;
import com.liambell.springchess.Model.Services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GameController {

    @Autowired
    GameService gameService;
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {

        Piece[][] board = new Piece[8][8];
        int[] pawnStart = new int[2];
        int[] pawnTwoStart = new int[2];
        int[] pawnTwoNew = new int[2];
        int[] pawnNew = new int[2];
        pawnStart[0] = 2;
        pawnStart[1] = 1;
        pawnNew[0] = 2;
        pawnNew[1] = 2;
        pawnTwoStart[0] = 4;
        pawnTwoStart[1] = 1;
        pawnTwoNew[0] = 4;
        pawnTwoNew[1] = 3;

        int[] rookStart = new int[2];
        int[] rookNew = new int[2];
        rookStart[0] = 1;
        rookStart[1] = 0;
        rookNew[0] = 5;
        rookNew[1] = 4;
        board = gameService.loadInitialGameState();
        getBoardState(board);
        gameService.movePiece(pawnStart, pawnNew);
        System.out.println("\n");
        getBoardState(board);
        gameService.movePiece(pawnTwoStart, pawnTwoNew);
        System.out.println("\n");
        getBoardState(board);
        gameService.movePiece(rookStart, rookNew);
        System.out.println("\n");
        getBoardState(board);
        return "Success";
    }

    public void getBoardState(Piece[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print("[" + board[i][j].getPieceName() + "]");
                if (j == 7) {
                    System.out.println();
                }
            }
        }
    }

}
