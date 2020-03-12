package com.liambell.springchess.Controllers;

import com.liambell.springchess.Model.Enitites.Board;
import com.liambell.springchess.Model.Enitites.Piece;
import com.liambell.springchess.Model.Services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
public class GameController {

    @Autowired
    GameService gameService;
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public void test() throws IOException {
        Map<String, Object> response = new HashMap<>();

        Piece[][] board = new Piece[8][8];
        ArrayList<int[]> movement = new ArrayList<>();
        board = gameService.loadInitialGameState();
        getBoardState(board);
        //gameService.movePiece(pawnStart, pawnNew);
        while(true) {
            movement = gameService.getCoordinatesForPieceMovementAction();
            gameService.movePiece(movement.get(0), movement.get(1));
            getBoardState(board);
            System.out.println("\n");
        }
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
