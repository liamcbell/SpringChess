package com.liambell.springchess.Model;

import com.liambell.springchess.Model.Enitites.Board;

public class GameState {

    private final int BOARD_SIZE = 8;

    //Initial State Of Board
    public void loadGameInitialState() {
        Board board = new Board(BOARD_SIZE);
        board.loadDefaultChessConfiguration();

    }

}
